package sorting.variationsOfBubblesort;

import sorting.AbstractSorting;
import util.Util;

/**
 * This algorithm applies two bubblesorts simultaneously. In a same iteration, a
 * bubblesort pushes the greatest elements to the right and another bubblesort
 * pushes the smallest elements to the left. At the end of the first iteration,
 * the smallest element is in the first position (index 0) and the greatest
 * element is the last position (index N-1). The next iteration does the same
 * from index 1 to index N-2. And so on. The execution continues until the array
 * is completely ordered.
 */
public class SimultaneousBubblesort<T extends Comparable<T>> extends
		AbstractSorting<T> {
	public void sort(T[] array, int leftIndex, int rightIndex) {
		if (isValid(array, leftIndex, rightIndex)) {
			int start = leftIndex;
			int end = rightIndex;
			int middleIndex = 1 + ((leftIndex + rightIndex) / 2);

			for (int i = leftIndex; i <= middleIndex; i++) {
				for (int j = start; j < end; j++) {
					if (array[j].compareTo(array[j + 1]) > 0) {
						Util.swap(array, j, j + 1);
					}
				}
				end--;

				for (int j = end; j > start; j--) {
					if (array[j].compareTo(array[j - 1]) < 0) {
						Util.swap(array, j, j - 1);
					}
				}
				start++;
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
