package euler45;

import java.util.ArrayList;
import java.util.Scanner;

public class Euler45 {
	
	public static int Tnumber(int n){
		//Triangle		Tn=n(n+1)/2		1, 3, 6, 10, 15, ...
		
		
		
		return n * (n+1)/2;
	}
	public static int Pnumber(int n){
		//Pentagonal		Pn=n(3n−1)/2		1, 5, 12, 22, 35, ...

		return n* (3*n -1)/2; 
	}
	
	public static int Hnumber(int n){
		//Hexagonal		Hn=n(2n−1)		1, 6, 15, 28, 45, ...

		return n * (2*n -1 );
	}
	
	public static void compateTPH(int jump, int upToRank){
		int indexT = 0, indexP =0, indexH = 0;
		ArrayList<Integer> Tlist, Plist, Hlist = new ArrayList<>();
		Tlist = generateToList('T', jump, 1); Plist = generateToList('P',jump , 1);
		Hlist = generateToList('H',jump , 1);
		int T = 0,P =0,H = 0; 
		int counter = 0;boolean  loop1 = true, loop2 = true;
		while(true){
			// -if P<T – continue check, (indexP ++)
			//  - if T < P stop and continue to next T . 
			//if == now do the same from P to H.
			T= Tlist.get(indexT);P = Plist.get(indexP); 
			if( T == P ){
				
				while(loop2){
					H = Hlist.get(indexH);
					System.out.println("h= "+ H + "indexH ="+ indexH+ (T==H));
					if (T == H){
						System.out.println("equal! - " + T);counter++;indexH++;
						indexT++;
						
						if (counter == upToRank){
							return;
							}else{break;}
						
					}
					if(P < H){break;}
					indexH++;
				}
				
			}
			if(T > P ){
				
				indexT++;
				continue;
				
			}
			indexP ++;
			
			
		}
		
		
		
	}
	public static void compateTPH2(int jump, int upToRank){
		int indexT = 0, indexP =0, indexH = 0;
		ArrayList<Integer> Tlist, Plist, Hlist = new ArrayList<>();
		Tlist = generateToList('T', jump, 1); Plist = generateToList('P',jump , 1);
		Hlist = generateToList('H',jump , 1);
		int T = 0,P =0,H = 0; 
		int counter = 0;boolean  loop1 = true, loop2 = true;
		
		while (loop1){
			T = Tlist.get(indexT); P = Plist.get(indexP);
			
			//if T == P
			if(T == P){
				System.out.println("T == P");
				//compare it to H also : 
				while (loop2){
					//T = Tlist.get(indexT); P = Plist.get(indexP);
					H = Hlist.get(indexH);
					//if T == H
					if(T == H){
					
						//count the equal:
						counter ++ ;
						//output the number
						System.out.println("number = " + T);
						
						//Advanced the next index H
						indexH++; 
					
					}
					//The regular search when P > H (advanced H
					else if(P > H){
						indexH++;
					}
					
					//The third situation when P < H (advance P)
					else{
						indexP ++;
						//and break
						loop2 = false;
					}
					
					
					
					System.out.println("H = " + H);
					
					
					
					
					
					
					
					
					
				}
				
				
				
				
				
				//Advanced the next index P & T
				indexT++; indexP++;
			
			}
			//The regular search when T > P (advanced P
			else if(T > P){
				indexP++;
			}
			
			//The third situation when T < P (advance T)
			else{
				indexT ++;
			}
			
			
			//tell it to stop if u get the rank 
			// Put it down
			loop1 = !(counter == upToRank );
			System.out.println("check - loop1 = " + loop1
					+"\nT = " + T + " P = " + P + " H = " + H
					+"\nindexT = " + indexT + " indexP = " + indexP + " indexH = " + indexH+"\n");
			
			
			
			
			
			
		}
		
		
		
		
	}
	public static void generateList(char kind, int upTo){
		if (kind == 'T'){
			for (int i = 1; i <=upTo; i++){
				System.out.println(Tnumber(i));
			}
		}
		if (kind == 'P'){
			for (int i = 1; i <=upTo; i++){
				System.out.println(Pnumber(i));
			}
		}
		if (kind == 'H'){
			for (int i = 1; i <=upTo; i++){
				System.out.println(Hnumber(i));
			}
		}
	}
		public static ArrayList generateToList(char kind, int upTo,int fromTo){
			ArrayList<Integer> list = new ArrayList<>();
			if (kind == 'T'){
				for (int i = fromTo; i <=upTo; i++){
					//System.out.println(Tnumber(i));
					list.add(Tnumber(i));
					
				}
			}
			if (kind == 'P'){
				for (int i = fromTo; i <=upTo; i++){
					//System.out.println(Pnumber(i));
					list.add(Pnumber(i));
				}
			}
			if (kind == 'H'){
				for (int i = fromTo; i <=upTo; i++){
					//System.out.println(Hnumber(i));
					list.add(Hnumber(i));
				}
			}
			return list;
		
		
		
	}
		
	public static void compare3(){
		int equals = 0, checkedNumber = 0,checkedNumber2 = 0 , checkedNumber3 = 0, founds = 0; 
		char series = 'T';
		int nT = 2, nP = 2 , nH = 2;
		int nX = 0;
		for(int i = 1;  i <=10 ; i++ ){
			//take the right n for use
			nX = getNx( nT, nP, nH, series);
			
			//assign the checked value 
			checkedNumber = Xnumber(nX, series);
			
			System.out.println("test - checkedNumber = " + checkedNumber);
			
			//now we compare to the next number 
			series = moveOn(series);
			if (series == 'T'){
				nX = nT;
			}
			else if(series == 'P'){
				nX = nP;
			}
			else if (series == 'H'){
				nX = nH;
			}
			
			//assign the checked value 
			checkedNumber2 = Xnumber(nX, series);
			
			System.out.println("test - checkedNumber2 =  " + checkedNumber2);
			//now take care the situation - 3 situation 
			
			//if == 
			//The advanced is append at the times found if 2 so shout me out and go on 
			// if once - so check the next.
			
			
			//if 2 >1 
			//u need to stop and advanced to the next series. this number itself
			
			
			
			
			//if 2<1
			//u need to step on and check another n at this series, maybe it's foound? ? 
			series = moveOn(series);
			System.out.println("it's 2 > 1 and now the series becaome to " + series);
			
			
			
			
		}
		
		
	}
	
	//helper for compare3
	public static char moveOn(char series){
		if (series == 'T'){
			return 'P';
		}
		else if (series == 'P'){
			return 'H';
		}
		else{
			return 'T';
		}
	}
	
	//more helper 
	public static int Xnumber(int n , char series){
		
		if(series == 'T'){
			return Tnumber(n);
		}
		else if(series == 'P'){
			return Pnumber(n );
		}
		else if(series == 'H'){
			return Hnumber(n);
		}
		System.out.println("invalid");
		
		return 0;
	}
	
	public static int getNx(int nT, int nP, int nH, char series){
		if (series == 'T'){
			return nT;
		}
		else if(series == 'P'){
			return nP;
		}
		else if (series == 'H'){
			 return nH;
		}
		
		
		
		
		return 0;
	}
	
	
	public static void main(String[] args ){
		compare3();
		
		/*
		Scanner input = new Scanner(System.in);
		
		
		int n = input.nextInt();
		System.out.println("n= "+ n + " | Tn = "+ Tnumber(n) );
		System.out.println("n= "+ n + " | Pn = "+ Pnumber(n) );
		System.out.println("n= "+ n + " | Hn = "+ Hnumber(n) );
		//compateTPH(1);
		//generateList('H', 100);
		//ArrayList<Integer> myList = generateToList('T', 100, 1);
		//System.out.println(myList);
		//compateTPH2(300, 2);
		
		*/
	}
}
