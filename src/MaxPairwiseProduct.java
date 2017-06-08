
	import java.util.*;
	import java.io.*;

	public class MaxPairwiseProduct {
	    
	static int getMaxPairwiseProduct(int[] numbers) 
	{
			long start=System.nanoTime();
	        int result = 0;
	        int n = numbers.length;
	        int startindex=0;
	        int max1 = -1;
	       
	        int max2 = -1;
	       
	        for(int i=0;i<n;i++){
					
	        			if(max1==-1||(numbers[i]>numbers[max1])){
	        				max1=i;
		        			System.out.println("max i is current"+max1);

	        			}
						
	        }
	        
	        for(int j=0;j<n;j++){
	        	System.out.println(numbers[j]+"_"+numbers[max1]);
				if(max2==-1||((numbers[j]!=numbers[max1])&&(numbers[max2]<numbers[j]))){
					max2=j;
					System.out.println("setting max2 to" +max2);
				}
    			
				
    }
	        /*for(int j=0;j<n;j++){
	        	if(((max2==-1)&&numbers[j]!=numbers[max1])||numbers[j]>numbers[max2]){
	        		max2=j;
	        	}
	        }*/
	        	
	        result=numbers[max2]*numbers[max1];
	        long end=System.nanoTime();
	        System.out.println("total time"+((end-start)/1e9));
	        return result;
	    }

	    public static void main(String[] args) {
	        FastScanner scanner = new FastScanner(System.in);
	        int n = scanner.nextInt();
	        int[] numbers = new int[n];
	        for (int i = 0; i < n; i++) {
	            numbers[i] = scanner.nextInt();
	        }
	        System.out.println(getMaxPairwiseProduct(numbers));
	    }

	    static class FastScanner {
	        BufferedReader br;
	        StringTokenizer st;

	        FastScanner(InputStream stream) {
	            try {
	                br = new BufferedReader(new InputStreamReader(stream));
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }

	        String next() {
	            while (st == null || !st.hasMoreTokens()) {
	                try {
	                    st = new StringTokenizer(br.readLine());
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	           
		 return st.nextToken();
	        }


	        int nextInt() {
	            return Integer.parseInt(next());
	        }
	    }

	}
