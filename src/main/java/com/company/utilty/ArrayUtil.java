package com.company.utilty;

import java.util.LinkedHashSet;
import java.util.Set;

import com.company.logger.MainLogger;

/**
 * Utility Class to manipulate arrays
 * @author akumar
 *
 */
public class ArrayUtil {

	//A marker to label the duplicate numbers as visited
	public static final int VISITED = -999999999;

	/**
	 * This method returns an integer array after deleting all the duplicates,
	 * it maintains the order of the elements.
	 * 
	 * @param originalElements
	 * @return uniqueItems
	 */
	public static int[] removeDuplicatesForLessRedundantElements(final int[] originalElements) {
		MainLogger.debug("Method removeDuplicatesForLessRedundantElements started");
		final Set<Integer> uniqueNumbers = new LinkedHashSet<Integer>();
		for (int i = 0; i < originalElements.length; i++) {
			uniqueNumbers.add(originalElements[i]);
		}
		final int[] uniqueItems = new int[uniqueNumbers.size()];
		int index = 0;
		for (final Integer integer : uniqueNumbers) {
			uniqueItems[index++] = integer;
		}
		MainLogger.debug("Method removeDuplicatesForLessRedundantElements end");
		return uniqueItems;
	}

	/**
	 * This method returns an integer array after deleting all the duplicates,
	 * it does not maintain the original order of the elements. It returns the
	 * unique elements in sorted order. This method is suitable for deleting
	 * duplicate elements from a huge integer array.
	 * 
	 * @param originalElements
	 * @return
	 */
	public static int[] removeDuplicatesFromHugeArray(int[] originalElements) {
		MainLogger.debug("Method removeDuplicatesFromHugeArray started");
		int[] sortedItems = Sorting.mergeSort(originalElements);
		int ilastUniqueNumberIndex = 0;
		int iRunningIndex = 0;
		while (iRunningIndex < sortedItems.length) {
			if (sortedItems[ilastUniqueNumberIndex] != sortedItems[iRunningIndex++]) {
				sortedItems[++ilastUniqueNumberIndex] = sortedItems[iRunningIndex - 1];
			}
		}
		int[] uniqueItems = new int[ilastUniqueNumberIndex + 1];
		System.arraycopy(sortedItems, 0, uniqueItems, 0, ilastUniqueNumberIndex + 1);
		MainLogger.debug("Method removeDuplicatesFromHugeArray started");
		return uniqueItems;

	}

	/**
	 * This method returns an integer array after deleting all the duplicates.
	 * It maintains the original order of the elements. It performs fast when
	 * array contains more redundant numbers irrespective of the place. For this
	 * to work we need one number for which we are 100% sure that it can never
	 * be in array, Like in some scenario we can be sure of that array is always
	 * of positive numbers.
	 * 
	 * @param originalElements
	 * @return
	 */
	public static int[] removeDuplicatesForMoreRedundantIntegers(final int[] originalElements) {
		MainLogger.debug("Method removeDuplicatesForMoreRedundantIntegers started");
		int[] tempItems = new int[originalElements.length];
		System.arraycopy(originalElements, 0, tempItems, 0, originalElements.length);
		int iLastUniqueNumberIndex = 0;
		int iMovingIndex = 0;

		// scan all numbers in Array
		while (iMovingIndex < tempItems.length) {
			// skip same numbers
			if (tempItems[iLastUniqueNumberIndex] == tempItems[iMovingIndex] || tempItems[iMovingIndex] == VISITED) {
				iMovingIndex++;
				continue;
			}

			// mark all other same numbers as visited
			for (int j = iMovingIndex; j < tempItems.length; j++) {
				if (tempItems[iLastUniqueNumberIndex] == tempItems[j]) {
					tempItems[j] = VISITED;
				}
			}
			tempItems[++iLastUniqueNumberIndex] = tempItems[iMovingIndex];
		}

		int[] uniqueItems = new int[iLastUniqueNumberIndex + 1];
		System.arraycopy(tempItems, 0, uniqueItems, 0, iLastUniqueNumberIndex + 1);
		MainLogger.debug("Method removeDuplicatesForMoreRedundantIntegers started");
		return uniqueItems;
	}
}
