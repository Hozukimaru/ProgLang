package bubblesort;
import java.util.Random;

public class BSort {
	public void sortInit(String type,String order) {
		Random rand = new Random();
		if(type.equals("int")) {
			Integer[] arr = new Integer[10];
			for (int i=0;i<arr.length ;i++ ) {
				arr[i] = rand.nextInt(10);
			}
			Bubble sorter = new Bubble(arr,order);
			sorter.sort();
		} else if(type.equals("float")) {
			Float[] arr = new Float[10];

			for (int i=0;i<arr.length ;i++ ) {
				arr[i] = rand.nextFloat();
			}
			Bubble sorter = new Bubble(arr,order);
			sorter.sort();
		} else if(type.equals("string")) {
			String characters = "abcdefghijklmnopqrstuvwxyz";
			String[] arr = new String[10];
			int x;

			for (int i=0;i<arr.length ;i++ ) {
				x = rand.nextInt(25);
				arr[i] = characters.substring(x,x+1);
			}
			Bubble sorter = new Bubble(arr,order);
			sorter.sort();
		}		
	}
}

class Bubble <T extends Comparable<T>> {
	private T[] input;
	private String order;

	public Bubble(T[] input,String order) {
		this.input = input;
		this.order = order;
	}

	public void sort() {
		boolean changeOccured;
		T temp;
		do {
			changeOccured = false;
			for (int j=1; j<input.length;j++) {
				if (compare(input[j],input[j-1]) > 0) {
					temp = input[j];
					input[j] = input[j-1];
					input[j-1] = temp;
					changeOccured = true;
				}
			}
		}while(changeOccured == true);
		print(input);
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