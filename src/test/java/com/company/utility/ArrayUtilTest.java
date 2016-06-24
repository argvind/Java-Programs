package com.company.utility;

import org.junit.Before;
import org.junit.Test;
import org.powermock.api.easymock.PowerMock;

import com.company.utilty.ArrayUtil;

import junit.framework.TestCase;

/**
 * Junit to test various methods in ArrayUtil
 * @author akumar
 *
 */
public class ArrayUtilTest extends TestCase {

	private int[] randomIntegers;
	int[] expectedUniquesIntegersInInsertionOder;
	int[] expectedUniquesIntegersSortedOder;
    final String deleteDuplicateErrorMsg = "Fail: duplicate deletion not working properly";

    protected void setUp() throws Exception {
		super.setUp();
		randomIntegers = new int[] { 1, 2, 34, 34, 25, 1, 45, 3, 26, 85, 4, 34, 86, 25, 43, 2, 1, 10000, 11, 16, 19, 1,
				18, 4, 9, 3, 20, 17, 8, 15, 6, 2, 5, 10, 14, 12, 13, 7, 8, 9, 1, 2, 15, 12, 18, 10, 14, 20, 17, 16, 3,
				6, 19, 13, 5, 11, 4, 7, 19, 16, 5, 9, 12, 3, 20, 7, 15, 17, 10, 6, 1, 8, 18, 4, 14, 13, 2, 11 };

		expectedUniquesIntegersInInsertionOder = new int[] { 1, 2, 34, 25, 45, 3, 26, 85, 4, 86, 43, 10000, 11, 16, 19,
				18, 9, 20, 17, 8, 15, 6, 5, 10, 14, 12, 13, 7 };
		expectedUniquesIntegersSortedOder = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18,
				19, 20, 25, 26, 34, 43, 45, 85, 86, 10000 };
	}

	/**
	 * Tests the method testRemoveDuplicatesForLeastRedundantElements for int array of some length
	 */
	@Test
	public void testRemoveDuplicatesForLeastRedundantElementsValidArray() {
		final int[] randomTestIntegers = new int[randomIntegers.length];
		System.arraycopy(randomIntegers, 0, randomTestIntegers, 0, randomIntegers.length);
		PowerMock.replayAll();
		final int[] uniqueIntegers = ArrayUtil.removeDuplicatesForLessRedundantElements(randomIntegers);
		PowerMock.verifyAll();

		assertEquals(deleteDuplicateErrorMsg, expectedUniquesIntegersInInsertionOder.length,
				uniqueIntegers.length);
		for (int i = 0; i < uniqueIntegers.length; i++) {
			assertEquals("Fail: Numbers are not in order", expectedUniquesIntegersInInsertionOder[i],
					uniqueIntegers[i]);
		}

		for (int i = 0; i < randomIntegers.length; i++) {
			assertEquals("Fail: Original array got modified", randomIntegers[i], randomTestIntegers[i]);
		}

	}
	
	/**
	 * Tests the method testRemoveDuplicatesForLeastRedundantElements
	 * for all 0 in array
	 */
	@Test
	public void testRemoveDuplicatesForLeastRedundantElementsBlankArray() {
		final int[] randomTestIntegers = new int[3];
		PowerMock.replayAll();
		final int[] uniqueIntegers = ArrayUtil.removeDuplicatesForLessRedundantElements(randomTestIntegers);
		PowerMock.verifyAll();

		assertEquals("Fail: duplicate deletion not working properly", 1, uniqueIntegers.length);
		assertEquals("Fail: duplicate deletion not working properly", 0,uniqueIntegers[0]);

	}

	/**
	 * Tests the method testRemoveDuplicatesFromHugeArray
	 */
	@Test
	public void testRemoveDuplicatesFromHugeArray() {
		final int[] randomTestIntegers = new int[randomIntegers.length];
		System.arraycopy(randomIntegers, 0, randomTestIntegers, 0, randomIntegers.length);
		PowerMock.replayAll();
		final int[] uniqueIntegers = ArrayUtil.removeDuplicatesFromHugeArray(randomIntegers);
		PowerMock.verifyAll();

		assertEquals(deleteDuplicateErrorMsg, expectedUniquesIntegersSortedOder.length,
				uniqueIntegers.length);
		for (int i = 0; i < uniqueIntegers.length; i++) {
			assertEquals("Fail: Numbers are not in order", expectedUniquesIntegersSortedOder[i], uniqueIntegers[i]);
		}

		for (int i = 0; i < randomIntegers.length; i++) {
			assertEquals("Fail: Original array got modified", randomIntegers[i], randomTestIntegers[i]);
		}

	}
	
	/**
	 * Tests the method testRemoveDuplicatesFromHugeArray  for array having 0 only
	 */
	@Test
	public void testRemoveDuplicatesFromHugeArrayForAllItemZero() {
		final int[] randomTestIntegers = new int[4];
		PowerMock.replayAll();
		final int[] uniqueIntegers = ArrayUtil.removeDuplicatesFromHugeArray(randomTestIntegers);
		PowerMock.verifyAll();
		assertEquals(deleteDuplicateErrorMsg, 1, uniqueIntegers.length);
		assertEquals(deleteDuplicateErrorMsg, 0,uniqueIntegers[0]);

	}

	/**
	 * Tests the method testRemoveDuplicatesForMoreRedundantIntegers
	 */
	@Test
	public void testRemoveDuplicatesForMoreRedundantIntegers() {
		int[] randomTestIntegers = new int[randomIntegers.length];
		System.arraycopy(randomIntegers, 0, randomTestIntegers, 0, randomIntegers.length);
		PowerMock.replayAll();
		final int[] uniqueIntegers = ArrayUtil.removeDuplicatesForMoreRedundantIntegers(randomIntegers);
		PowerMock.verifyAll();

		assertEquals(deleteDuplicateErrorMsg, expectedUniquesIntegersInInsertionOder.length,
				uniqueIntegers.length);
		for (int i = 0; i < uniqueIntegers.length; i++) {
			assertEquals("Fail: Numbers are not in order", expectedUniquesIntegersInInsertionOder[i],
					uniqueIntegers[i]);
		}

		for (int i = 0; i < randomIntegers.length; i++) {
			assertEquals("Fail: Original array got modified", randomIntegers[i], randomTestIntegers[i]);
		}

	}
	
	/**
	 * Tests the method testRemoveDuplicatesForMoreRedundantIntegers for array having 0 only
	 */
	@Test
	public void testRemoveDuplicatesForMoreRedundantIntegersForAllItemZero() {
		final int[] randomTestIntegers = new int[4];
		PowerMock.replayAll();
		final int[] uniqueIntegers = ArrayUtil.removeDuplicatesForMoreRedundantIntegers(randomTestIntegers);
		PowerMock.verifyAll();
		assertEquals(deleteDuplicateErrorMsg, 1, uniqueIntegers.length);
		assertEquals(deleteDuplicateErrorMsg, 0,uniqueIntegers[0]);

	}

}
