package mergesort;
import java.util.Random;

public class MSort {
	public void sortInit(String type,String order) {
		Random rand = new Random();
		if(type.equals("int")) {
			Integer[] arr = new Integer[10];
			for (int i=0;i<arr.length ;i++ ) {
				arr[i] = rand.nextInt(10);
			}
			Merge sorter = new Merge(arr,order);
			sorter.sort();
		} else if(type.equals("float")) {
			Float[] arr = new Float[10];

			for (int i=0;i<arr.length ;i++ ) {
				arr[i] = rand.nextFloat();
			}
			Merge sorter = new Merge(arr,order);
			sorter.sort();
		} else if(type.equals("string")) {
			String characters = "abcdefghijklmnopqrstuvwxyz";
			String[] arr = new String[10];
			int x;

			for (int i=0;i<arr.length ;i++ ) {
				x = rand.nextInt(25);
				arr[i] = characters.substring(x,x+1);
			}
			Merge sorter = new Merge(arr,order);
			sorter.sort();
		}		
	}
}

class Merge <T extends Comparable<T>> {
	private T[] input;
	private String order;
	private Object[] tempArr;

	public Merge(T[] input,String order) {
		this.input = input;
		tempArr = new Object[input.length];
		this.order = order;
	}

	public void sort() {
		//print(input);
		mergesort(0,input.length-1);
		print(input);
	}

	public void mergesort(int start,int end) {
		if (start < end) {
			int mid = start + (end - start ) / 2;
			mergesort(start,mid);
			mergesort(mid+1,start);
			mergeroni(start,mid,end);
		}
	}

	public void mergeroni(int start,int mid, int end) {
		for (int i=start;i<=end ;i++ ) {
			tempArr[i] = input[i];
		}
		int a = start;
		int b = mid+1;
		int c = start;
		while(a <= mid && b <= end) {
			if (compare((T)tempArr[a],(T)tempArr[b]) <= 0) {
				input[a++] = (T)tempArr[a++];
			} else {
				input[c++] = (T)tempArr[b++];
			}
		}

		while(a <= mid) {
			input[c++] = (T)tempArr[a++];
		}
	}

	public void swap(int a,int b) {
		T temp = input[a];
		input[a] = input[b];
		input[b] = temp;
	}

	public void print(Object[] sorted) {
		for (int i=0;i<sorted.length;i++) {
			System.out.println(sorted[i]);
		}
	}

	public int compare(T a,T b) {
		if (order.equals("ascending")) {
			return a.compareTo(b);
		}
		else {
			return -(a.compareTo(b));
		}
	}
}