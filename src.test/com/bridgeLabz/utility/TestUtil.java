package com.bridgeLabz.utility;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestUtil {

	// 2^0 = 1//3
	@Test
	public void test_powerOfTwo_Zero() {
		assertEquals(1, Util.powerOfTwo(0));
	}

	// 2^-1 = 0 as casted to integer type//5
	@Test
	public void test_powerOfTwo_negativePower() {
		assertEquals(0, Util.powerOfTwo(-1));
	}

	// result is out of capacity of integer//6
	@Test
	public void test_powerOfTwo_outOfIntegerCapacity() {
		assertEquals(2147483647, Util.powerOfTwo(12345));
	}

	// to test type casting.//4
	@Test
	public void test_powerOfTwo_inputMismatch() {
		assertEquals(4.00, Util.powerOfTwo(2), 0);
	}

	// test input zero//1
	@Test
	public void test_isLeapYear_inputZero() {
		assertFalse(Util.isLeapYear(0));
	}

	// input boundaries//2
	@Test
	public void test_isLeapYear_boundaries() {
		// divisible by 4 and 100 not 400.
		assertFalse(Util.isLeapYear(1000));
		assertFalse(Util.isLeapYear(10000));
	}

	// negative input values
	@Test
	public void test_isLeapYear_negativeInput() {
		assertFalse(Util.isLeapYear(-2000));
	}

	// checking positive inputs
	@Test
	public void test_isLeapYear_positiveValue() {
		assertFalse(Util.isLeapYear(1800));
		assertTrue(Util.isLeapYear(2000));
	}

	@Test
	public void test_isAnagram_positiveInput() {
		assertTrue("single word positive input", Util.isAnagram("heart", "earth"));
		assertTrue("double word positive input having space", Util.isAnagram("debit card", "bad credit"));
		assertTrue("numeric positive input", Util.isAnagram("123", "312"));
	}

	@Test
	public void test_isAnagram_negativeInput() {
		assertFalse("single word negative input", Util.isAnagram("ramesh", "suresh"));
		assertFalse("Numeric negative input", Util.isAnagram("12345", "69870"));
	}

	@Test
	public void test_isAnagram_inputHavingLetterCaseMismatch() {
		assertTrue("UpperCase in between word", Util.isAnagram("HearT", "eArtH"));
	}

	@Test
	public void test_isAnagram_inputHavingSpacesAtStartingAndEndPosition() {
		assertTrue("UpperCase in between word", Util.isAnagram("   HearT  ", "   eArtH    "));
	}

	@Test
	public void test_isAnagram_inputHavingDifferentWords() {
		assertTrue("1st input 3 words and 2nd 2 words", Util.isAnagram("new york times", "monkeys write"));
	}

	@Test
	public void test_isPallindrome_withEvenLength() {
		assertTrue(Util.isPallindrome("abccba"));
	}

	@Test
	public void test_isPallindrome_withOddLength() {
		assertTrue(Util.isPallindrome("abcba"));
	}

	@Test
	public void test_isPallindrome_withSingleLetter() {
		assertTrue(Util.isPallindrome("a"));
	}

	@Test
	public void test_isPallindrome_withEmptyString() {
		assertFalse(Util.isPallindrome(""));
	}

	@Test
	public void test_isPallindrome_withNonePallindrome() {
		assertFalse(Util.isPallindrome("abcde"));
	}

	@Test
	public void test_isPallindrome_withNumericLetter() {
		assertTrue(Util.isPallindrome("12321"));
	}

	@Test
	public void test_isPrime_withZero() {
		assertEquals(false, Util.isPrime(0));
	}

	@Test
	public void test_isPrime_withOne() {
		assertEquals(false, Util.isPrime(1));
	}

	@Test
	public void test_isPrime_withTwo() {
		assertEquals(true, Util.isPrime(2));
	}

	@Test
	public void test_isPrime_withNumberItself() {
		assertEquals(true, Util.isPrime(11));
	}

	@Test
	public void test_readFile_readingFile() {
		assertEquals("raja", Util.readFile("C:\\Users\\durgasankar\\eclipse-workspace\\test.txt"));
	}

	@Test
	public void test_reverseString_positiveInput() {
		assertEquals("ajar", Util.reverseString("raja"));
	}

	@Test
	public void test_reverseString_numericStringInput() {
		assertEquals("321", Util.reverseString("123"));
	}

	@Test
	public void test_reverseString_emptyInput() {
		assertEquals("", Util.reverseString(""));
	}

	@Test
	public void test_countDigit_countThreeDigit() {
		assertEquals(3, Util.countDigits(125));
	}

	@Test
	public void test_countDigit_countNegativeThreeDigit() {
		assertEquals(3, Util.countDigits(-125));
	}

	@Test
	public void test_isAnagram_Integer_positiveInput() {
		assertTrue("palindrome condition", Util.isAnagram(103, 310));
		assertTrue("random order", Util.isAnagram(103, 301));
	}

	@Test
	public void test_isAnagram_Integer_negativeInput() {
		assertFalse("Numeric negative input", Util.isAnagram(12345, 69870));
	}

	@Test
	public void test_isAnagram_Integer_zeroAtInitialPosition() {
		assertFalse("Numeric negative input", Util.isAnagram(205, 025));
	}

}
