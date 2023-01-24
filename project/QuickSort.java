package project;

import java.util.Vector;

public class QuickSort {
	static <E> void swap(Vector<E> v, int i, int j) {
	    E o;
	    o = v.elementAt(i);
	    v.setElementAt(v.elementAt(j), i);
	    v.setElementAt(o, j);
	}
	static <E extends Comparable<E>> int partition(Vector<E> v,int low, int high) {
		E pivot = v.elementAt(high);
		int i = (low-1);
		for (int j = low; j < high ; j++) {
	        if(pivot.compareTo(v.elementAt(j))==1){
	            i++;
	            swap(v,i,j);
	        }
	    }
	    swap(v,i + 1, high);
	    return (i + 1);
	}
	static <E extends Comparable<E>> void quickSort(Vector<E> v, int low, int high) {
		if (low < high) {
	        int pi = partition(v, low, high);

	        quickSort(v, low, pi - 1);
	        quickSort(v, pi + 1, high);
	    }
	}
}
