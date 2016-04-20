package euler45;

import java.math.BigInteger;

public class DraftTest {
	
	public static void main(String[] args) {
		
		/*
		
		Series mySeries = new Series( 1 , 'T');
		System.out.println( "n = "+ mySeries.getN()
		+ "\nkind = "+ mySeries.getKind());
		
		mySeries.setN(1);
		System.out.println("n after changing " + mySeries.getN()+ " result = " + mySeries.getResult());
		System.out.println(Comparator.compare(4, 4, -1));
		
		Series series2 = new Series(5, 'H');
		series2 = mySeries;
		System.out.println(series2.getN()); 
		
		for(int i= 0; i < 20; i ++){
			
			System.out.println(series2.generateResult(0));
			series2.moveOnN();
			
			long h = 111111;
			BigInteger bi = new BigInteger("55");
			BigInteger bi2 = new BigInteger("55");
			h = Long.valueOf(String.valueOf(bi));
			System.out.println(bi.compareTo(bi2));
			Tester tester = new Tester(3);
			tester.work();
			System.out.println(new Series(5, 'P').generateResult(0));
			System.out.println(Comparator.compare(bi, bi2, -1));
			
		}
		*/
		long x = System.currentTimeMillis();
		new Tester(3).work();
		long y = System.currentTimeMillis();
		System.out.println(y-x);
		
	}

}
