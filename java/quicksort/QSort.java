package quicksort;
import java.util.Random;

public class QSort {
	public void sortInit(String type,String order) {
		Random rand = new Random();
		if(type.equals("int")) {
			Integer[] arr = new Integer[10];
			for (int i=0;i<arr.length ;i++ ) {
				arr[i] = rand.nextInt(10);
			}
			Quick sorter = new Quick(arr,order);
			sorter.sort();
		} else if(type.equals("float")) {
			Float[] arr = new Float[10];

			for (int i=0;i<arr.length ;i++ ) {
				arr[i] = rand.nextFloat();
			}
			Quick sorter = new Quick(arr,order);
			sorter.sort();
		} else if(type.equals("string")) {
			String characters = "abcdefghijklmnopqrstuvwxyz";
			String[] arr = new String[10];
			int x;

			for (int i=0;i<arr.length ;i++ ) {
				x = rand.nextInt(25);
				arr[i] = characters.substring(x,x+1);
			}
			Quick sorter = new Quick(arr,order);
			sorter.sort();
		}		
	}
}

class Quick <T extends Comparable<T>> {
	private T[] input;
	private String order;

	public Quick(T[] input,String order) {
		this.input = input;
		this.order = order;
	}

	public void sort() {
		quicksort(input,0,input.length-1);
		print(input);
	}

	public void quicksort(T[] input,int start,int end) {
		if (start < end) 
		{
			T pivot = input[end];
			int i = start;
			int j = end;

			while(i != j)
			{
				if (compare(input[i],pivot) > 0) 
				{
					i++;		
				} else {
					input[j] = input[i];
					input[i] = input[j-1];
					j--;
				}
			}	
			input[j] = pivot;
			quicksort(input,start,j-1);
			quicksort(input,j+1,end);
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