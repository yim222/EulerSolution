package euler45;

import java.math.BigInteger;

public class Comparator {
	private static int found = -1;
	
	//if there is 1 found = 0, 2 = 1. - 0 = -1
	public static int compare ( int a , int b, int found){
		
		if( a == b && found == 0){
			return 1;
		}
		if( a== b && found == -1){
			return 0;
		}
		
		return -1;
		
	}
	
public static int compare ( BigInteger a , BigInteger b, int found){
		
		if( a.compareTo(b)== 0 && found == 0){
			return 1;
		}
		if(  a.compareTo(b)== 0 && found == -1){
			return 0;
		}
		
		return -1;
		
	}
}
