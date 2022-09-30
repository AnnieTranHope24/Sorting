package hwk7;

import java.util.Random;

public class Hwk7Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] numbers = new Integer[4];
		numbers[0] = 11;
		numbers[1] = 3;
		numbers[2] = 9;
		numbers[3] = 10;
		Integer[] numbersCopy = new Integer[4];
		numbersCopy[0] = 11;
		numbersCopy[1] = 3;
		numbersCopy[2] = 9;
		numbersCopy[3] = 10;
		Integer[] numbersCopy2 = new Integer[4];
		numbersCopy2[0] = 11;
		numbersCopy2[1] = 3;
		numbersCopy2[2] = 9;
		numbersCopy2[3] = 10;
		


		System.out.println("PP 9.1");
		Sorting.bubbleSort(numbersCopy2);
		System.out.println("Sorted list: ");
		for(Integer number: numbersCopy2) {
			System.out.print(number + " ");
		}
		System.out.println();
		System.out.println();
		System.out.println("PP 9.3");
		System.out.println("Test with small arrays");
		System.out.println("Insertion Sort: ");
		Sorting.insertionSort(numbers);
		System.out.println("Quick Sort: ");
		Sorting.quickSort(numbersCopy);
		System.out.println();

		System.out.println("Insertion Sort to sort an already sorted array: ");
		Sorting.insertionSort(numbers);
		System.out.println("Quick Sort to sort an already sorted array: ");
		Sorting.quickSort(numbersCopy);
		System.out.println();

		// Test with large arrays
		System.out.println("Test with arrays size 10,000");
		Integer[] elements = new Integer[10000];
		for (int i = 0; i < elements.length; i++) {
			Random rand = new Random();
			elements[i] = rand.nextInt(1000);
		}
		Integer[] elementsCopy = new Integer[10000];
		for (int i = 0; i < elementsCopy.length; i++) {

			elementsCopy[i] = elements[i];
		}

		System.out.println("Insertion Sort: ");
		Sorting.insertionSort(elements);
		System.out.println("Quick Sort: ");
		Sorting.quickSort(elementsCopy);
		System.out.println();
		System.out.println("Insertion Sort to sort an already sorted array: ");
		Sorting.insertionSort(elements);
		System.out.println("Quick Sort to sort an already sorted array: ");
		Sorting.quickSort(elementsCopy);
		System.out.println();
		System.out.println("PP 9.4");
		Integer[] array1 = new Integer[100000];
		for (int i = 0; i < array1.length; i++) {
			Random rand = new Random();
			array1[i] = rand.nextInt(1000);
		}
		Integer[] array1Copy = new Integer[100000];
		for (int i = 0; i < array1Copy.length; i++) {

			array1Copy[i] = array1[i];
		}
		System.out.println("Array of size 100,000");
		System.out.println("Old Quick Sort: ");
		Sorting.quickSort(array1);
		System.out.println("Quick Sort with middle-of-three partition: ");
		Sorting.quickSortMiddle(array1Copy);
		System.out.println();
		
		
		Integer[] array2 = new Integer[500000];
		for (int i = 0; i < array2.length; i++) {
			Random rand = new Random();
			array2[i] = rand.nextInt(1000);
		}
		Integer[] array2Copy = new Integer[500000];
		for (int i = 0; i < array2Copy.length; i++) {

			array2Copy[i] = array2[i];
		}
		System.out.println("Array of size 500,000");
		System.out.println("Old Quick Sort: ");
		Sorting.quickSort(array2);
		System.out.println("Quick Sort with middle-of-three partition: ");
		Sorting.quickSortMiddle(array2Copy);
		System.out.println();

		
		


	}

}
