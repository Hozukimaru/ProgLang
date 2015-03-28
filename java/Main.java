import bubblesort.BSort;
import quicksort.QSort;
import mergesort.MSort;

public class Main {
	public static void main(String[] args) {
		String sortType = args[0];
		String varType = args[1];
		String order = args[2];

		if(sortType.equals("bubble")) {
			bubblesort.BSort sorter = new bubblesort.BSort();
			sorter.sortInit(varType,order);
		} else if(sortType.equals("quick")) {
			quicksort.QSort sorter = new quicksort.QSort();
			sorter.sortInit(varType,order);
		} else if(sortType.equals("merge")) {
			mergesort.MSort sorter = new mergesort.MSort();
			sorter.sortInit(sortType,order);
		}
	}
}