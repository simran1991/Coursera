
public class BinarySearch {

	public static int binarySearhRecur(int[] x,int startIndex,int lastIndex,int key){
		if(startIndex>lastIndex){
			return startIndex-1;
		}
		int midIndex=startIndex+(int)(Math.floor((lastIndex-startIndex)/2));
		
		if(x[midIndex]==key){
			return midIndex;
		}
		if(x[midIndex]>key){
			lastIndex=midIndex-1;
			return binarySearhRecur(x, startIndex, lastIndex, key);
		}else{
			startIndex=midIndex+1;
			return binarySearhRecur(x, startIndex, lastIndex, key);
		}
	}
	
	public static int binarySearchIt(int[] x,int startIndex,int lastIndex,int key) {
		while(startIndex<=lastIndex){
			int midIndex=startIndex+(int)(Math.floor((lastIndex-startIndex)/2));
			if(x[midIndex]==key){
				return midIndex;
			}
			if(x[midIndex]>key){
				lastIndex=midIndex-1;
			}else{
				startIndex=midIndex+1;
			}
		}
		//outside while loop mean we iterate
		//over the whole array ad we could not find the element.
		return startIndex-1;
		
	}
	public static void main(String[] args) {
		int[] array={1,6,10,90,95,100,110,120};
		int[] array1=new int[0];
		System.out.println(binarySearhRecur(array,0, array.length-1, 120));
		System.out.println(binarySearchIt(array,0, array.length-1, 120));
	}
}
