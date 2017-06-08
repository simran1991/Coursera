
public class SlectionSort {

	public static int[] selectionSort(int[] x){
		int minIndex=0;
		int len=x.length;
		int temp=0;
		for(int i=0;i<len;i++){
			minIndex=i;
			for(int j=i+1;j<len;j++){
				if(x[j]<x[minIndex]){
					minIndex=j;
				}
			}
			temp=x[i];
			x[i]=x[minIndex];
			x[minIndex]=temp;
		}
		return x;
	} 
	
	public static void main(String[] args) {
		int[] array={1,6,2,30,15,10,8,2,3,5,9};
		int[] sortedArray=selectionSort(array);
		for(int x:sortedArray){
			System.out.print(x);
		}
	}
}
