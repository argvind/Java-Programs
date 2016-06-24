package com.company.utilty;

/**
 * Utility Class for sorting algorithms
 * @author akumar
 *
 */
public class Sorting {
	
	/**
	 * It takes integer array as input and breaks then array into 2 equal part recursively
	 * until each part becomes size of one then it merges parts in sorted way. 
	 * @param items
	 * @return
	 */
	public static int[] mergeSort(int[] items){
		int iSize = items.length;
		if(iSize == 1){
			return items;
		}
		
		int newSize = (iSize/2);
		int[] firstPart = new int[newSize];
		int[] secondPart = new int[iSize - newSize];
		
		System.arraycopy(items, 0, firstPart, 0, newSize);
		System.arraycopy(items, newSize, secondPart, 0, secondPart.length);
		
		return merge(mergeSort(firstPart), mergeSort(secondPart));
	}

	/**
	 * It gets the input as sorted array, then it merges the sorted array into
	 * one sorted array and returns it.
	 * @param firstPart
	 * @param secondPart
	 * @return Merged sorted array
	 */
	private static int[] merge(int[] firstPart, int[] secondPart) {
		int firstPartSize = firstPart.length;
		int secondPartSize = secondPart.length;
		int[] finalItems = new int[firstPartSize + secondPartSize];
		
		int iLeftIndex = 0;
		int iRightIndex = 0;
		int iMainIndex = 0;
		
		while(iLeftIndex < firstPartSize && iRightIndex < secondPartSize){
			if(firstPart[iLeftIndex] < secondPart[iRightIndex]){
				finalItems[iMainIndex++] = firstPart[iLeftIndex++];
			}else{
				finalItems[iMainIndex++] = secondPart[iRightIndex++];
			}
		}
		
		while(iLeftIndex < firstPartSize){
			finalItems[iMainIndex++] = firstPart[iLeftIndex++];
		}
		
		while(iRightIndex < secondPartSize){
			finalItems[iMainIndex++] = secondPart[iRightIndex++];
		}
		
		return finalItems;
	}
}
