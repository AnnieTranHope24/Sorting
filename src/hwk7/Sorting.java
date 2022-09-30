package hwk7;

public class Sorting<T extends Comparable<T>> {
	static int quickSortCount;
	static int mergeSortCount;

	/**
	 * Sorts the specified array of objects using a bubble sort algorithm.
	 *
	 * @param data the array to be sorted
	 */
	public static <T extends Comparable<T>> void bubbleSort(T[] data) {
		int position, scan;
		T temp;
		position = data.length - 1;
		boolean isExchanged = true;
		while (position >= 0 && isExchanged) {
			isExchanged = false;
			for (scan = 0; scan <= position - 1; scan++) {
				if (data[scan].compareTo(data[scan + 1]) > 0) {
					swap(data, scan, scan + 1);
					isExchanged = true;
				}

			}

			position--;

		}
		int i = position + 1;
		int numLoop = data.length - i;
		System.out.println("The outer loop loops " + numLoop + " times until the array sorted.");
	}

	/**
	 * Sorts the specified array of objects using an insertion sort algorithm.
	 *
	 * @param data the array to be sorted
	 */
	public static <T extends Comparable<T>> void insertionSort(T[] data) {
		long startTime = System.nanoTime();
		int comprNum = 0;
		for (int index = 1; index < data.length; index++) {
			T key = data[index];
			int position = index;
			// if key is greater than the largest element of the sorted list

			// shift larger values to the right
			while (position > 0 && data[position - 1].compareTo(key) > 0) {
				data[position] = data[position - 1];
				position--;
				comprNum++;
			}
			// if the while loop stops before position = 0
			if (position != 0) {
				comprNum++;
			}

			data[position] = key;

		}
		long stopTime = System.nanoTime();
		long timeElapsed = stopTime - startTime;
		System.out.println("Number of comparisons: " + comprNum);
		System.out.println("Time elapsed: " + timeElapsed);
	}

	/**
	 * Sorts the specified array of objects using the quick sort algorithm.
	 * 
	 * @param data the array to be sorted
	 */
	public static <T extends Comparable<T>> void quickSort(T[] data) {
		quickSortCount = 0;
		long startTime = System.nanoTime();
		quickSort(data, 0, data.length - 1);
		long stopTime = System.nanoTime();
		long timeElapsed = stopTime - startTime;
		System.out.println("Number of comparisons: " + quickSortCount);
		System.out.println("Time elapsed: " + timeElapsed);
	}

	/**
	 * Recursively sorts a range of objects in the specified array using the quick
	 * sort algorithm.
	 * 
	 * @param data the array to be sorted
	 * @param min  the minimum index in the range to be sorted
	 * @param max  the maximum index in the range to be sorted
	 */
	private static <T extends Comparable<T>> void quickSort(T[] data, int min, int max) {
		if (min < max) {
			// create partitions
			int indexofpartition = partition(data, min, max);
			// sort the left partition (lower values)
			quickSort(data, min, indexofpartition - 1);
			// sort the right partition (higher values)
			quickSort(data, indexofpartition + 1, max);

		}
	}

	/**
	 * Used by the quick sort algorithm to find the partition.
	 * 
	 * @param data the array to be sorted
	 * @param min  the minimum index in the range to be sorted
	 * @param max  the maximum index in the range to be sorted
	 */
	private static <T extends Comparable<T>> int partition(T[] data, int min, int max) {
		T partitionelement;
		int left, right;
		int middle = (min + max) / 2;
		int count = 0;

		// use the middle data value as the partition element
		partitionelement = data[middle];
		// move it out of the way for now
		swap(data, middle, min);
		left = min;
		right = max;

		while (left < right) {
			// search for an element that is > the partition element
			while (left < right && data[left].compareTo(partitionelement) <= 0) {
				left++;
				count++;
			}
			if (data[left].compareTo(partitionelement) > 0) {
				count++;
			}

			// search for an element that is < the partition element
			while (data[right].compareTo(partitionelement) > 0) {
				right--;
				count++;
			}

			if (data[right].compareTo(partitionelement) <= 0) {
				count++;
			}
			// swap the elements
			if (left < right)
				swap(data, left, right);
		}
		// move the partition element into place
		swap(data, min, right);
		quickSortCount += count;

		return right;
	}

	/**
	 * Sorts the specified array of objects using the quick sort algorithm with middle-of-three method.
	 * 
	 * @param data the array to be sorted
	 */
	public static <T extends Comparable<T>> void quickSortMiddle(T[] data) {
		quickSortCount = 0;
		long startTime = System.nanoTime();
		quickSortMiddle(data, 0, data.length - 1);
		long stopTime = System.nanoTime();
		long timeElapsed = stopTime - startTime;
		System.out.println("Number of comparisons: " + quickSortCount);
		System.out.println("Time elapsed: " + timeElapsed);
	}

	/**
	 * Recursively sorts a range of objects in the specified array using the quick
	 * sort algorithm with middle-of-three method.
	 * 
	 * @param data the array to be sorted
	 * @param min  the minimum index in the range to be sorted
	 * @param max  the maximum index in the range to be sorted
	 */
	private static <T extends Comparable<T>> void quickSortMiddle(T[] data, int min, int max) {
		if (min < max) {
			// create partitions
			int indexofpartition = partitionMidd(data, min, max);
			// sort the left partition (lower values)
			quickSortMiddle(data, min, indexofpartition - 1);
			// sort the right partition (higher values)
			quickSortMiddle(data, indexofpartition + 1, max);

		}
	}
	/**
	 * Used by the quick sort algorithm with middle-of-three method to find the partition.
	 * 
	 * @param data the array to be sorted
	 * @param min  the minimum index in the range to be sorted
	 * @param max  the maximum index in the range to be sorted
	 */
	private static <T extends Comparable<T>> int partitionMidd(T[] data, int min, int max) {
		int middle = middleOfThree(data, min, max);
		T partitionelement;
		int left, right;
		int count = 0;

		// use the middle data value as the partition element
		partitionelement = data[middle];
		// move it out of the way for now
		swap(data, middle, min);
		left = min;
		right = max;

		while (left < right) {
			// search for an element that is > the partition element
			while (left < right && data[left].compareTo(partitionelement) <= 0) {
				left++;
				count++;
			}
			if (data[left].compareTo(partitionelement) > 0) {
				count++;
			}

			// search for an element that is < the partition element
			while (data[right].compareTo(partitionelement) > 0) {
				right--;
				count++;
			}

			if (data[right].compareTo(partitionelement) <= 0) {
				count++;
			}
			// swap the elements
			if (left < right)
				swap(data, left, right);
		}
		// move the partition element into place
		swap(data, min, right);
		quickSortCount += count;

		return right;

	}
/**
 * Find the median of 3 points.
 * @param <T>
 * @param arr
 * @param left
 * @param right
 * @return
 */
	private static <T extends Comparable<T>> int middleOfThree(T[] arr, int left, int right) {
		int mid = (left + right) / 2;
		if (arr[right].compareTo(arr[left]) < 0) {
			swap(arr, left, right);
		}

		else if (arr[mid].compareTo(arr[left]) < 0) {
			swap(arr, mid, left);
		}

		else if (arr[right].compareTo(arr[mid]) < 0) {
			swap(arr, right, mid);
		}

		return mid;

	}

	/**
	 * Swaps to elements in an array. Used by various sorting algorithms.
	 * 
	 * @param data   the array in which the elements are swapped
	 * @param index1 the index of the first element to be swapped
	 * @param index2 the index of the second element to be swapped
	 */
	private static <T extends Comparable<T>> void swap(T[] data, int index1, int index2) {
		T temp = data[index1];
		data[index1] = data[index2];
		data[index2] = temp;
	}

}
