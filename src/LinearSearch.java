
public class LinearSearch {
	
	public static int linearSearch(int[] x,int startindex,int endIndex,int key){
		if(startindex>endIndex){
			return -1;
		}
		if(x[startindex]==key){
			return startindex;
		}
		return linearSearch(x, startindex+1, endIndex, key);
	}
	
	public static void main(String[] args) {
		int[] array={1,14 ,168,191,50,234};
		System.out.println(linearSearch(array, 0,array.length-1, 10));
	}
}
