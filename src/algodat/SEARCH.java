package algodat;

public class SEARCH {
	/*
	 * Binary search bekerja secara efisien pada array terurut
	 * tidak begitu cocok untuk linked list karena 
	 * akses ke elemen di tengah memerlukan traversal
	 */
	static int binarySearch(int[] array, int target) {
		int low = 0;
		int high = array.length - 1;
		int middle;
		while(low <= high) {
			middle = low + (high-low)/2;
			if(target < array[middle]) {
				high = middle -1;
			}else if(target > array[middle]) {
				low = middle + 1;
			}else {
				return middle;
			}
		}
		return -1;
	}
	
	/* lebih cepat daripada binary search 
	 * Jika data tidak merata, yaitu elemen-elemen berada dalam interval-nilai yang besar, 
	 * interpolasi search dapat menghasilkan perkiraan yang sangat jauh dari lokasi sebenarnya.
	 */
	static int interpolationSearch(int[] array, int target) {
		int low = 0;
		int high = array.length - 1;
		int pos;
		while(low >= array[low] && target <= array[high] && low <= high) {
			pos = low + (target - array[low])*(high-low)/(array[high]- array[low]);
			if(target < array[pos]) {
				high=pos-1;
			}else if(target > array[pos]) {
				low=pos+1;
			}else {
				return pos;
			}
		}
		return -1;
	}
	/*
	 * penggabungan algoritma linear search dengan binary search
	 */
	static int expoSearch(int[] array, int target) {
		int i=1;
		if(array[0]==target) {
			return 0;
		}
		while(i<array.length && array[i]<= target) {
			if(array[i]==target) {
				return i;
			}
			i=i*2;
		}
		int low=i/2, high, middle;
		if(i>=array.length) {
			high=array.length-1;
		}else {
			high=i;
		}
		while(low <= high) {
			middle = low + (high-low)/2;
			if(target < array[middle]) {
				high = middle -1;
			}else if(target > array[middle]) {
				low = middle + 1;
			}else {
				return middle;
			}
		}
		return -1;
	}
	public static void main(String[] args) {
//		int array[]= new int[50];
//		for(int i=0; i<array.length; i++) {
//			array[i]=i+1;
//		}
		int array[]= {1,4,5,12,15,17,21,23,25,26,34,37,39};
		System.out.println(array.length);
		System.out.println(expoSearch(array, 39));
//		System.out.println(interpolationSearch(array, 3));
	}

		
}
