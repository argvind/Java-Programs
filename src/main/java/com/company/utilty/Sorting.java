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
		final int iSize = items.length;
		int[] finalItems;
		if(iSize == 1){
			finalItems = items;
		}else{
			final int newSize = iSize/2;
			final int[] firstPart = new int[newSize];
			final int[] secondPart = new int[iSize - newSize];
			
			System.arraycopy(items, 0, firstPart, 0, newSize);
			System.arraycopy(items, newSize, secondPart, 0, secondPart.length);
			
			finalItems = merge(mergeSort(firstPart), mergeSort(secondPart));
		}
		return finalItems;
	}

	/**
	 * It gets the input as sorted array, then it merges the sorted array into
	 * one sorted array and returns it.
	 * @param firstPart
	 * @param secondPart
	 * @return Merged sorted array
	 */
	private static int[] merge(final int[] firstPart, final int[] secondPart) {
		final int firstPartSize = firstPart.length;
		final int secondPartSize = secondPart.length;
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
