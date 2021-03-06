package sort;


public class MergeSort {
	private int[] array;
	private int[] helper;

	private int size;

	public void sort(int[] inputArr) {
		if (inputArr == null || inputArr.length == 0) {
			return;
	    }
		size= inputArr.length;
		array = inputArr;
		helper = new int[size];
		mergesort(0,size-1);
	  }

	  private void mergesort(int low, int high) {
		  if(low>=high)
			  return ;
		  int mid = (low+high)/2;
		  mergesort(low,mid);
		  mergesort(mid+1,high);
		  merge(low,mid,high);
		  for(int i =low;i<=high;i++)
			  array[i]=helper[i];
		  
	  }

	  private void merge(int low, int middle, int high) {
		 int left = low,right = middle+1;
		 int cur = low;
		 while(left<=middle && right <=high){
			 if(array[left]<array[right])
				 helper[cur++]=array[left++];
			 else
				 helper[cur++]=array[right++];
		 }
		 while(left<=middle)
			 helper[cur++]=array[left++];
		 while(right<=high)
			 helper[cur++]=array[right++];

	  }
}
