import java.util.Random;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Andrei-PC
 *
 */
public class TestProgram {
	
	private static int NumberOfDigits(int number) {
		int nr=0;
		long newSeedCopy=number;
		while(newSeedCopy!=0) {
			newSeedCopy/=10;
			nr++;
		}
		return nr;
	}
	
	public static int[] computeX(int l, int n) {
		 
		 int min = (int) Math.pow(2, (l-1));
		 int max = (int) Math.pow(2, l);
		 Random rand = new Random();
		 
		 //aici il compunem pe m ca fiind un numar aleator intre aleator[(2^l-1)+1] +max
		 int m = rand.nextInt((min+1)) + max;	
		 
		 // aici compunem pe b si pe x ca fiind numere aleatoare intre 0 si m
		 int a = rand.nextInt(m);
		 int b = rand.nextInt(m);
		 int x = rand.nextInt(m);
		 
		 int[] array = new int[n+1];
		 System.out.print("Valori random prin metoda LCG: \n");
		 for (int i = 0; i < n+1; i ++) {
			 x = (a * x + b) % m; // formula LCG
			 System.out.println(x);
			 array[i] = x;
		 }
		 return array;
	 }
	
	public static void main(String[] args) {
		int seed=6541,nraleatoare = 15,n=0;
		int numberofseed = NumberOfDigits(seed);
		MidSqr test=new MidSqr(seed);
		float x=test.Random();
		System.out.println((int)x);
		while(n!=nraleatoare - 1) {
			MidSqr test1=new MidSqr((int)x);
			x=test1.Random();
			if(NumberOfDigits((int)x)==numberofseed)
			{
				System.out.println((int)x);
			}
			else {
				int z = n+2;
				System.out.println("Al"+z+ "-lea numar are seedul mai mic de "+numberofseed+" cifre");
			}
			n++;
		}	
		
		 Scanner scanner = new Scanner(System.in);
         System.out.print( "Numar intreg de intrare pozitiv l: " );
         int l = scanner.nextInt();
         System.out.print( "Cate numere sa genereze n: " );
         int ne = scanner.nextInt();      
         // aici intra in compute cu valorile citite de la tastatura
         int[] array = computeX(l,ne-1);
	}


}
