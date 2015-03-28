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
    	int n = this.array.length;
    	if(n <= 1) {
    	    return this.array;
    	}
    	T[] firstHalf = Utility.slice(this.array, 0, n/2);
    	T[] secondHalf = Utility.slice(this.array, n/2, n);
    	return Utility.merge(
        	new Mergesort(firstHalf).sorted(),
        	new Mergesort(secondHalf).sorted()
        );
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