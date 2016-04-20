package euler45;
//U here - it's should work now don't know where it's stuck. U need to debuug and organize it (do draft if u want
// but here it's need to be clear and nice
import java.math.BigInteger;

import javax.print.attribute.standard.Compression;
//*I succedd to get the right answer to the example but there is a memory problem so I need to upgrade it.
public class Tester {
	
	/*Create this please: 
	 *
- rightAnswer: boolean
- TNumber, PNumber, HNumber: series
-timesOfFounds : int 
- numberA, NumberB: int
- 

	 */
	
	private boolean rightAnswer;
	private Series Tnumber = new Series(1 , 'T') , Pnumber = new Series(1, 'P') , Hnumber= new Series(1, 'H' );
	private int timesFoundDemand,timesFound;
 	private BigInteger numberA, numberB;
	//private long numberA, numberB;
	
	
	//ctor - with arg of the timesFound wanted
	
	public Tester (int timesFoundDemand){
		this.timesFoundDemand = timesFoundDemand;
	}
	
	//method- continueOn - when u want to continue on
	//...maybe it's not necessary
	
	public void continueOn(Series x ){
		
		x.moveOnN();
		
	}
	
	//method - continueNext - when u want to continue next series - if y  > x
	//...
	public Series continueNext(Series x){
		
		return decideToWhere(x, Tnumber,Pnumber, Hnumber);
	}
	
	//method - decideToWhere - for decide to where continue if u want to continue next
	//...
	public Series decideToWhere(Series x , Series...xArr ){
		
		for (int i = 0 ; i < xArr.length-1; i++ ){
			if (x.getKind() == xArr[i].getKind()){
				return xArr[i+1];
			}
			
			
		}
		
		return xArr[0];
		
	}
	
	//temp to constant :
	
	public void tempToContant(Series x){
		if (x.getKind() == 'T'){
			Tnumber = x;
		}
		if(x.getKind() == 'P'){
			Pnumber = x;
		}
		if ( x.getKind() == 'H'){
			Hnumber = x;
		}
		
	}
	
	//the work - take number> set n> move to next > compare>do the action > take Number,
	
	//action - check if correct (at bottom "work2()" is with output.
	public void work(){
		
		
		// 
		//first take the number : 
		//at big integer :: 
		//numberA.valueOf(Tnumber.generateResult(0));numberB.valueOf(Pnumber.generateResult());
		numberA= Tnumber.generateResult(0); numberB = Pnumber.generateResult(0);
		int compareResult = -1;
		Series tempA = Tnumber, tempB = Pnumber;
		//start the loop 
		
		for (int i =0 ; ; i++){
			numberA= tempA.generateResult(0); 
			numberB=  tempB.generateResult(0);
			
			//step - 1
			//make numberB > numberA and change the series - 
			for( ;numberA.compareTo(numberB)== 1 ; ){
			
			tempB.moveOnN();
			numberB = tempB.generateResult(0);
			
						}
			//synchro the changes : 
			
			tempToContant(tempA);tempToContant(tempB);
			
			
			
			//step-2
			//compare
			
			compareResult = Comparator.compare(numberA,numberB, compareResult);
			
			//count the result and check case for stoping.
			if (compareResult == 1){//if it's found 
				System.out.println("check 2 - found = " + numberA );
				
				tempA.moveOnN();tempToContant(tempA);
				tempB.moveOnN();tempToContant(tempB);
				numberA = tempA.generateResult(0);//not not necessary?
				timesFound++;
				if (timesFound == timesFoundDemand)
					return;
			}
			
			
			if( numberA .compareTo(numberB)== -1 || compareResult == 0){
				//replace checkedNumber 1 to 2
				tempA = tempB;
				tempB = continueNext(tempB);
				tempToContant(tempA); tempToContant(tempB);
			}
			
			
			
			
			
			
			
		}
		
		
		
		
	}
	
	//action - check if correct 
		public void work2(){
			
			
			//first take the number : 
			//as big integer :: 
			numberA= Tnumber.generateResult(0); numberB = Pnumber.generateResult(0);
			
			
			//long - trying - not 
			
			
			int compareResult = -1;
			Series tempA = Tnumber, tempB = Pnumber;
			//start the loop 
			
			//*maybe needed a identifier for the numberA series and number B series, or int other word - 
			// - the round series (like temporary)
			
			for (int i =0 ; ; i++){
				numberA= tempA.generateResult(0); 
				numberB=  tempB.generateResult(0);
				
				//step - 1
				//make numberB > numberA and change the series - 
				//for(;BigInteger.valueOf(numberA) > BigInteger.valueOf(numberB) ;  ){// u here u need to make all big integer
				for( ;numberA.compareTo(numberB)== 1 ; ){
				
				tempB.moveOnN();
				numberB = tempB.generateResult(0);
				
				//	BigInteger bb=BigInteger.valueOf(numberB);
				//	System.out.println("check4 - number bb = " + bb + " |number A = " + numberA);
					
				}
				//synchro the changes : 
				
				tempToContant(tempA);tempToContant(tempB);
				System.out.println("this is the 2 checked numbers : " + numberA + " + " +numberB);
				System.out.println("check10 -  nT + nP + nH - " + Tnumber.getN() +" "+ Pnumber.getN()
				+" " + Hnumber.getN());
				
				
				//step-2
				//compare
				//y
				compareResult = Comparator.compare(numberA,numberB, compareResult);
				System.out.println("check - 11 -compareResult =  " + compareResult);
				//count the result and case for stoping.
				//TO here - VVV -checked
				if (compareResult == 1){//if it's found 
					System.out.println("check 2 - found ");
					
					tempA.moveOnN();tempToContant(tempA);
					tempB.moveOnN();tempToContant(tempB);
					numberA = tempA.generateResult(0);//not not necessary?
					timesFound++;
					System.out.println("check 2 - found = " + timesFound );
					if (timesFound == timesFoundDemand)
						return;
				}
				//u need to make case for return 
				//...
				
				
				//replace checkedNumber 1 to 2
				//x= y;
				
				//case for if y> x > - tempB = tempA, tempA - next , synchro
				//???(OR compare result == 0 (still not found U HERE - dont success ))
				//to understand
				if( numberA .compareTo(numberB)== -1 || compareResult == 0){
					//replace checkedNumber 1 to 2
					tempA = tempB;
					tempB = continueNext(tempB);
					System.out.println("check 3 - "+ tempB.getKind());
					tempToContant(tempA); tempToContant(tempB);
				}
				
				//case for move up checkedNumber2 
				
				
				
				
				
			}
			
			
			
			
		}
}

/*
 * if y < x - continue checking
 * */
