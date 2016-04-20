package euler45;

import java.math.BigInteger;

//here is the draft of the tester from 11-4-16 :
public class TesterDraft {
	
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
	
	public TesterDraft (int timesFoundDemand){
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
	
	//action - check if correct 
	public void work(){
		
		//first take the number : 
		//at big integer :: 
		//numberA.valueOf(Tnumber.generateResult(0));numberB.valueOf(Pnumber.generateResult());
		numberA= Tnumber.generateResult(0); numberB = Pnumber.generateResult(0);
		
		
		//long - trying - not 
		
		
		int compareResult = -1;
		Series tempA = Tnumber, tempB = Pnumber;
		//start the loop 
		
		//*maybe needed a identifier for the numberA series and number B series, or int other word - 
		// - the round series (like temporary)
		for (int i =0 ; i <20; i++){
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
			
			
			//step-2
			//compare
			//y
			compareResult = Comparator.compare(numberA,numberB, compareResult);
			System.out.println("check - " + compareResult);
			//count the result and case for stoping.
			
			if (compareResult == 1){//if it's found 
				System.out.println("check 2 - found ");
				
				tempA.moveOnN();tempToContant(tempA);
				tempB.moveOnN();tempToContant(tempB);
				numberA = tempA.generateResult(0);//not not necessary?
				timesFound++;
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