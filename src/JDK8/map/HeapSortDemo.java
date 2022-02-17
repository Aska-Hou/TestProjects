package JDK8.map;

public class HeapSortDemo {

	public static void HeapSort(Node[] arr) {
		//From the Last NotLeaf Node, Build the Max-Heap		
		for(int i = arr.length/2; i > 0; i--) {
			balanceHeap(arr, i, arr.length);
		}
		//Replace the last element with the first element. Only check the root
		for(int i = arr.length - 1; i >= 0; i--) {
			System.out.println("Word: " + arr[0].getWord() + ". Occurence" + arr[0].getOccurence());
			swap(arr, i, 0);
			balanceHeap(arr, 1, i);
		}
	}

	//Three values. The length is used to avoid the last swapped elements are moved to the top.
	public static void balanceHeap(Node[] arr, int i, int length) {
		int leftChild = 2 * i;
		if(leftChild > length)
			return;
		if(leftChild == length) {
			// The last Leaves
			if(arr[leftChild - 1].getOccurence() > arr[i - 1].getOccurence()) {
				swap(arr, leftChild - 1, i - 1);
			}
		}
		else {
			//Have Right Child
			int rightChild = 2 * i + 1;
			if(arr[rightChild - 1].getOccurence() >= arr[leftChild - 1].getOccurence() && arr[rightChild - 1].getOccurence() >= arr[i - 1].getOccurence()) {
				swap(arr, rightChild - 1, i - 1);
				// After swapping, we need to check the swapped child nodes
				balanceHeap(arr, rightChild, length);
			}
			else if(arr[leftChild - 1].getOccurence() >= arr[rightChild - 1].getOccurence() && arr[leftChild - 1].getOccurence() >= arr[i - 1].getOccurence()) {
				swap(arr, leftChild - 1, i - 1);
				// After swapping, we need to check the swapped child nodes
				balanceHeap(arr, leftChild, length);
			}
		}
	}
	
	public static void swap(Node[] arr, int m, int n) {
		Node number = arr[m];
		arr[m] = arr[n];
		arr[n] = number;
	}

}
