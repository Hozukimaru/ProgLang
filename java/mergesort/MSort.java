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

	public Merge(T[] input,String order) {
		this.input = input;
		this.order = order;
	}

	public void sort() {
		mergesort(input);
		print(input);
	}

	public void mergesort() {
    	int n = input.length;
    	if(n <= 1) {
    	    return this.array;
    	}
    	T[] firstHalf = slice(input, 0, n/2);
    	T[] secondHalf = slice(input, n/2, n);
    	return merge(
        	new Mergesort(firstHalf).sorted(),
        	new Mergesort(secondHalf).sorted()
        );
	}

	public T[] merge(T[] arr1, T[] arr2) {
		T[] result = new T[arr1.length + arr2.length];
		int p1 = 0;
		int p2 = 0;
		int q  = 0;
		while(p1 < arr1.length || p2 < arr2.length) {
			if(p1 < arr1.length && p2 < arr2.length) {
				int compare = arr1[p1].compareTo(arr2[p2]);
				if(compare <= 0) {
					result[q] = arr1[p1];
					p1 ++; q ++;
				} else if(compare > 0) {
					result[q] = arr2[p2];
					p2 ++; q ++;
				}
			} else {
				if(p1 == arr1.length) {
					copy(arr2, p2, arr2.length, result, q);
				} else {
					copy(arr1, p1, arr1.length, result, q);
				}
				break;
			}
		}
    	return result;
	}

	public T[] slice(T[] array, int a, int b) throws Exception {
		T[] newarray = new T[b-a];
		if(! (a < array.length && b <= array.length)) {
			throw new Exception("out of bound:" + a + "," + b);
		}
		for(int i=a; i < b; i++) {
			newarray[i-a] = array[i];
		}
    	return newarray;
	}

	public void copy(T[] src, int a, int b, T[] target, int start) {
		for(int i=0; i < b-a; i++) {
			target[start+i] = src[a+i];
		}
	}

	public void print(T[] sorted) {
		for (int i=0;i<sorted.length;i++) {
			System.out.println(sorted[i]);
		}
	}

	public int compare(T a,T b) {
		if (order.equals("ascending")) {
			return -(a.compareTo(b));
		}
		else {
			return a.compareTo(b);
		}
	}
}