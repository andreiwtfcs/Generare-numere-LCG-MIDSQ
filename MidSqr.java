/**
 * 
 */

/**
 * @author Andrei-PC
 *
 */
public class MidSqr implements IGenerator {
	int seedd;
	int numberofseed;
	public MidSqr(int seed) {
		//System.out.println(seed);
		seedd=seed;
		numberofseed = NumberOfDigits(seedd);
		//System.out.println(numberofseed);
	}
	
	private int NumberOfDigits(int number) {
		int nr=0;
		long newSeedCopy=number;
		while(newSeedCopy!=0) {
			newSeedCopy/=10;
			nr++;
		}
		return nr;
	}
	public float Random() {
		if(numberofseed==NumberOfDigits(seedd)) {
			long newSeed=seedd*seedd;
			//System.out.println(newSeed);	
			newSeed=(long) (newSeed/(Math.pow(10,numberofseed/2)));
			//System.out.println(newSeed);
			newSeed=(long) (newSeed%(Math.pow(10,numberofseed)));
			//System.out.println(newSeed);
			//newSeed=(long) (newSeed/(Math.pow(10,numberofseed)));
			seedd=(int)newSeed;
			//System.out.println(seedd);
			return seedd;
		}
		return 0;
	}

}
