
public class MinRefillsTest {

	public int minRefills(int[] x,int n,int L){
		int numOfRefills=0;//number of refills 
		int currentRefill=0;//current refill location.
		/**
		 * 
		 */
		int lastRefill=0;
		while(currentRefill<=n){
			lastRefill=currentRefill;
					while(currentRefill<=n && (x[currentRefill]-x[lastRefill]<=L )){
						currentRefill++;
						
					}
					if(currentRefill==lastRefill){
						System.out.println("imposible");
						break;
					}
					if(currentRefill<=n){
						numOfRefills=numOfRefills+1;
						System.out.println("current refill point"+currentRefill);

					}
		}
		
		return numOfRefills;
		
	}
	
	
	public static void main(String[] args) {
		MinRefillsTest minRefillsTest=new MinRefillsTest();
		int[] aTob={1,2,3,4,5,6,7,8,9,10,11,12,13,14};
		int n=aTob.length-1;
		int L=4;
		System.out.println(minRefillsTest.minRefills(aTob, n, L));
	}
}
