package com.company.main;

import java.util.Arrays;

import com.company.logger.MainLogger;
import com.company.utilty.ArrayUtil;

/**
 * @author akumar
 *
 */
public class DeDup {

	/*
	 *Sample array to test 
	 * */
	public static int[] randomIntegers = { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16,
			19, 1, 18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16,
			3, 6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

	/**
	 * @param args
	 */
	public static void main(final String[] args) {

		MainLogger.info("Target array for duplicate removal " + Arrays.toString(randomIntegers));

		int[] items = ArrayUtil.removeDuplicatesForMoreRedundantIntegers(randomIntegers);
		MainLogger.info("Integers after duplicate removal " + Arrays.toString(items));

		items = ArrayUtil.removeDuplicatesForLessRedundantElements(randomIntegers);
		MainLogger.info("Integers after duplicate removal " + Arrays.toString(items));

		items = ArrayUtil.removeDuplicatesFromHugeArray(randomIntegers);
		MainLogger.info("Integers after duplicate removal " + Arrays.toString(items));
	}
}
