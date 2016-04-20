package euler45;

import java.math.BigInteger;

/*
 * Series
- n: int 
-result: int
-kind:char
+series(int currentN, char kind)
+moveOnN(int n) : void
+setN(int value) : int
+generateResult(char kind):int 
+setNAtComparison(int a,int b ,int found)



 */
public class Series {
	
	private int n;
	private int result;
	private BigInteger bigN = new BigInteger(String.valueOf(n));
	private char kind;
	
	//constructor
	public Series(int n, char kind){
		
		this.n = n;
		this.kind = kind;
		
	}
	
	public int getN(){
		return n;
	}
	public char getKind(){
		return kind;
	}
	public int getResult(){
		
		return result;
	}
	
	public void moveOnN(){
		n +=1;
		//return n;
	}
	
	public void setN(int n ){
		this.n = n;
	}
	
	public int generateResult(){
		if(kind == 'T'){
			
			return n * (n+1)/2;
			
		}
		
		if(kind == 'P'){
			return n* (3*n -1)/2;
		}
		
		if(kind == 'H'){
			
			return n * (2*n -1 );
			
		}
		return 0 ; 
	}
	public BigInteger generateResult(int x){
		BigInteger n2 = new BigInteger(String.valueOf(n));

		if(kind == 'T'){
			//return n * (n+1)/2;?
			return n2.multiply(n2.add(new BigInteger("1"))).divide(
					new BigInteger("2"));
			
		}
		
		if(kind == 'P'){
			//return n* (3*n -1)/2;
			return n2.multiply(n2.multiply(new BigInteger("3")).subtract(
					new BigInteger("1"))).divide(new BigInteger("2"));//.divide(new BigInteger("2"))));
		}
		
		if(kind == 'H'){
			
			//return n * (2*n -1 );
			return n2.multiply(n2.multiply(new BigInteger("2")).subtract(new BigInteger("1")));
			
		}
		//return 0 ; 
		return null;
	}
	
	//found : -1 not matching, 0 : 1 matching, 1 : full matching
	public int setNAtComparison(int a,int b ,int found){
		
		if (a == b && found == 1 ){
			moveOnN();
		}
		
		return 0;
		
	}
}
