public class MergeSort {
	
	public static int[] mergeSort(int[] x){
		
		if(x.length==1){
			return x;
		}
		int m=(int)Math.floor(x.length/2);
		int[] c = new int[m];
		int[] d = new int[x.length-m];
		
		
		System.arraycopy(x, 0, c, 0, m);
		System.arraycopy(x, m, d,0 , x.length-m);
		
		System.out.println("first array");
		for(int y:c){
			System.out.println(y);
		}
		System.out.println("second array");
		for(int z:d){
			System.out.println(z);
		}
		int[] a=mergeSort(c);
		int[] b=mergeSort(d);
		
		return merge(a,b);
		
	} 
	private static int[] merge(int[] a, int[] b) {
		int size=a.length+b.length;
		int[] d=new int[size];
		
		int startIndexA=0;
		int startIndexB=0;
		int startIndexMerged=0;
		int endIndexA=a.length-1;
		int endIndexB=b.length-1;
		
		//scan ,compare and copy elements in both array.
		while(startIndexA<=endIndexA && startIndexB<=endIndexB){
				if(a[startIndexA]<b[startIndexB]){
					d[startIndexMerged]=a[startIndexA];
					startIndexA++;

				}else{
					d[startIndexMerged]=b[startIndexB];
					startIndexB++;
				}
				startIndexMerged++;
		}

		//copy if any remaining element in left array
		while(startIndexA<=endIndexA){
			d[startIndexMerged]=a[startIndexA];
			startIndexA++;
			startIndexMerged++;
		}
		
		//copy if any remaining element in right array
		while(startIndexB<=endIndexB){
			d[startIndexMerged]=b[startIndexB];
			startIndexB++;
			startIndexMerged++;
		}
		
		// copy what's left
		//System.arraycopy(a, startIndexA, d, startIndexMerged, a.length - startIndexA);
	    //System.arraycopy(b, startIndexB, d, startIndexMerged, b.length - startIndexB);
		
	    System.out.println("array conbined with elements");
		
		for(int x:d){
			System.out.println(x);
		}
		return d;
	}
	public static int[] mergeSort(int[] x,int startIndex,int endIndex){
		
		int midIndex=(endIndex-startIndex)/2;
		
		int[] leftSubArray=mergeSort(x,startIndex,midIndex);
		int[] rightSubArray=mergeSort(x,midIndex+1,endIndex);
		
		return merge(leftSubArray,rightSubArray);
		
		
	}
	public static int[] createArray(int[] x,int startIndex,int lastIndex,int size){
		int[] result=new int[size];
		for(int i=startIndex;i<lastIndex;i++){
			result[i]=x[i];
		}
		return result;
	}
	public static void main(String[] args) {
		int[] array={1,6,2,30,15,10,8,2,3,5,9};
		int[] sortedArray=mergeSort(array);
		for(int x:sortedArray){
			System.out.print(x+",");
		}
	}
}
