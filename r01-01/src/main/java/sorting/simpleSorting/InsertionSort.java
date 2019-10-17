package sorting.simpleSorting;

import sorting.AbstractSorting;

/**
 * As the insertion sort algorithm iterates over the array, it makes the
 * assumption that the visited positions are already sorted in ascending order,
 * which means it only needs to find the right position for the current element
 * and insert it there.
 */
public class InsertionSort<T extends Comparable<T>> extends AbstractSorting<T> {

	@Override
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if(isValid(array,leftIndex,rightIndex)){
			for (int i = leftIndex + 1; i <= rightIndex; i++){
				int j = i - 1;
				T key = array[i];

				while ((j >= leftIndex) && (array[j].compareTo(key) > 0)) {
					array[j + 1] = array[j];
					j--;
				}
				array[j + 1] = key;

			}
		}

	}
	public boolean isValid(T[] array, int leftIndex, int rightIndex){
		boolean isValid = true;

		if (array == null) {
			isValid = false;
		} else if ((leftIndex > rightIndex) || (leftIndex < 0) || (rightIndex < 0)) {
			isValid = false;
		} else if (rightIndex > (array.length - 1)) {
			isValid = false;
		}

		return isValid;
	}
}
