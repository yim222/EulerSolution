package euler45;

import java.util.HashMap;
import java.util.Map;

public class OtherSolution {
	
	public static void main(String ... args){
	    System.out.println(calcTriangle(285));
	    System.out.println(calcPentagonal(165));
	    System.out.println(calcHexagonal(143));
	    System.out.println(calcTriangle(55385));
	    System.out.println(calcPentagonal(31977));
	    System.out.println(calcHexagonal(27693));
	    long start = System.currentTimeMillis();
	    int numberOfBuckets = 1_000_000;
	    Map<Long, Long> triabgleBuckets = new HashMap<>(numberOfBuckets * 2);
	    Map<Long, Long> pentagonalBuckets = new HashMap<>();
	    for(int n = 0; n < numberOfBuckets ; n++){
	      triabgleBuckets.put(calcTriangle((long) n), (long) n);
	    }
	    for(int k = 0; k < numberOfBuckets ; k++){
	      long pentagonal = calcPentagonal((long) k);
	      if(triabgleBuckets.containsKey(pentagonal)){
	        System.out.println("Value: " + pentagonal + " present in triangle: " + triabgleBuckets.get(pentagonal) + " and in pentagonal " + k);
	      }
	      pentagonalBuckets.put(pentagonal, (long)k);
	    }

	    for(int h = 0 ; h < numberOfBuckets ; h++){
	      long hexagonal = calcHexagonal(h);
	      if (pentagonalBuckets.containsKey(hexagonal)) {
	        System.out.println("Found value: " + hexagonal + " with inidices: Triangle: " + triabgleBuckets.get(hexagonal) + " Pentagonal: " + pentagonalBuckets.get(hexagonal) + " Hexagonal: " + h);
	      }
	    }
	    long end = System.currentTimeMillis();
	    System.out.println("Calculation took: " + (end - start) + "millis");
	  }

	  public static long calcTriangle(long n){
	    return n * (n + 1) / 2;
	  }

	  public static long calcPentagonal(long n){
	    return n * (3 * n - 1) / 2;
	  }

	  public static long calcHexagonal(long n){
	    return n * (2 * n - 1);
	  }

}
