package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

class AppTest {

    // ─────────────────────────────────────────────────────────────
    // add(int a, int b)
    // ─────────────────────────────────────────────────────────────

    @Test
    void add_twoPositives_returnsSum() {
        assertEquals(5, App.add(2, 3));
    }

    @Test
    void add_twoNegatives_returnsSum() {
        assertEquals(-5, App.add(-2, -3));
    }

    @Test
    void add_positiveAndNegative_returnsSum() {
        assertEquals(1, App.add(4, -3));
    }

    @Test
    void add_withZero_returnsSameNumber() {
        assertEquals(7, App.add(7, 0));
    }

    @Test
    void add_bothZero_returnsZero() {
        assertEquals(0, App.add(0, 0));
    }

    // ─────────────────────────────────────────────────────────────
    // isPrime(int n)
    // ─────────────────────────────────────────────────────────────

    @Test
    void isPrime_negativeNumber_returnsFalse() {
        assertFalse(App.isPrime(-5));
    }

    @Test
    void isPrime_zero_returnsFalse() {
        assertFalse(App.isPrime(0));
    }

    @Test
    void isPrime_one_returnsFalse() {
        assertFalse(App.isPrime(1));
    }

    @Test
    void isPrime_two_returnsTrue() {
        // 2 is the only even prime — the loop never runs (sqrt(2) < 2)
        assertTrue(App.isPrime(2));
    }

    @Test
    void isPrime_three_returnsTrue() {
        assertTrue(App.isPrime(3));
    }

    @Test
    void isPrime_four_returnsFalse() {
        assertFalse(App.isPrime(4));
    }

    @Test
    void isPrime_largePrime_returnsTrue() {
        assertTrue(App.isPrime(97));
    }

    @Test
    void isPrime_largeComposite_returnsFalse() {
        assertFalse(App.isPrime(100));
    }

    @Test
    void isPrime_oddCompositeWithNonTrivialFactor_returnsFalse() {
        // n=9: loop runs i=2 (9%2≠0, continues) then i=3 (9%3=0, returns false).
        // Every existing "divisor found" test uses n=4 or n=100, where i=2 hits immediately.
        // This is the only test where the inner if-branch fires on a non-first loop iteration.
        assertFalse(App.isPrime(9));
    }

    // ─────────────────────────────────────────────────────────────
    // reverse(String s)
    // ─────────────────────────────────────────────────────────────

    @Test
    void reverse_normalString_returnsReversed() {
        assertEquals("olleh", App.reverse("hello"));
    }

    @Test
    void reverse_emptyString_returnsEmpty() {
        assertEquals("", App.reverse(""));
    }

    @Test
    void reverse_singleCharacter_returnsSame() {
        assertEquals("a", App.reverse("a"));
    }

    @Test
    void reverse_palindrome_returnsSame() {
        assertEquals("racecar", App.reverse("racecar"));
    }

    @Test
    void reverse_stringWithSpaces_returnsReversed() {
        assertEquals("dlrow olleh", App.reverse("hello world"));
    }

    // ─────────────────────────────────────────────────────────────
    // factorial(int n)
    // ─────────────────────────────────────────────────────────────

    @Test
    void factorial_zero_returnsOne() {
        // 0! = 1 by definition; the loop body never executes
        assertEquals(1, App.factorial(0));
    }

    @Test
    void factorial_one_returnsOne() {
        assertEquals(1, App.factorial(1));
    }

    @Test
    void factorial_five_returns120() {
        assertEquals(120, App.factorial(5));
    }

    @Test
    void factorial_ten_returns3628800() {
        assertEquals(3628800, App.factorial(10));
    }

    @Test
    void factorial_negative_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> App.factorial(-1));
    }

    // ─────────────────────────────────────────────────────────────
    // isPalindrome(String s)
    // ─────────────────────────────────────────────────────────────

    @Test
    void isPalindrome_simplePalindrome_returnsTrue() {
        assertTrue(App.isPalindrome("racecar"));
    }

    @Test
    void isPalindrome_notPalindrome_returnsFalse() {
        assertFalse(App.isPalindrome("hello"));
    }

    @Test
    void isPalindrome_sentenceWithSpacesAndPunctuation_returnsTrue() {
        // After stripping non-alphanumeric and lowercasing: "amanaplanacanalpanama"
        assertTrue(App.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    void isPalindrome_emptyString_returnsTrue() {
        // Empty string reversed is still empty
        assertTrue(App.isPalindrome(""));
    }

    @Test
    void isPalindrome_singleCharacter_returnsTrue() {
        assertTrue(App.isPalindrome("a"));
    }

    @Test
    void isPalindrome_numericPalindrome_returnsTrue() {
        assertTrue(App.isPalindrome("12321"));
    }

    @Test
    void isPalindrome_mixedCase_returnsTrue() {
        // "RaceCar" -> cleaned to "racecar"
        assertTrue(App.isPalindrome("RaceCar"));
    }

    // ─────────────────────────────────────────────────────────────
    // fibonacciUpTo(int n)
    // ─────────────────────────────────────────────────────────────

    @Test
    void fibonacciUpTo_zero_returnsListWithZero() {
        assertEquals(List.of(0), App.fibonacciUpTo(0));
    }

    @Test
    void fibonacciUpTo_one_returnsZeroAndOne() {
        // Both 0 and 1 are ≤ 1, and 1 appears only once in the sequence
        assertEquals(List.of(0, 1, 1), App.fibonacciUpTo(1));
    }

    @Test
    void fibonacciUpTo_ten_returnsCorrectSequence() {
        assertEquals(List.of(0, 1, 1, 2, 3, 5, 8), App.fibonacciUpTo(10));
    }

    @Test
    void fibonacciUpTo_exactFibNumber_includesThatNumber() {
        // 8 is a Fibonacci number and must be included
        List<Integer> result = App.fibonacciUpTo(8);
        assertTrue(result.contains(8));
        assertFalse(result.contains(13)); // next Fibonacci exceeds limit
    }

    @Test
    void fibonacciUpTo_negative_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> App.fibonacciUpTo(-1));
    }

    // ─────────────────────────────────────────────────────────────
    // charFrequency(String input)
    // ─────────────────────────────────────────────────────────────

    @Test
    void charFrequency_normalString_returnsCorrectCounts() {
        Map<Character, Integer> freq = App.charFrequency("aab");
        assertEquals(2, freq.get('a'));
        assertEquals(1, freq.get('b'));
    }

    @Test
    void charFrequency_emptyString_returnsEmptyMap() {
        assertTrue(App.charFrequency("").isEmpty());
    }

    @Test
    void charFrequency_singleCharacter_returnsCountOfOne() {
        Map<Character, Integer> freq = App.charFrequency("z");
        assertEquals(1, freq.get('z'));
        assertEquals(1, freq.size());
    }

    @Test
    void charFrequency_stringWithSpaces_countsSpaces() {
        Map<Character, Integer> freq = App.charFrequency("a b");
        assertEquals(1, freq.get('a'));
        assertEquals(1, freq.get(' '));
        assertEquals(1, freq.get('b'));
    }

    @Test
    void charFrequency_repeatedChar_returnsCorrectCount() {
        Map<Character, Integer> freq = App.charFrequency("aaaa");
        assertEquals(4, freq.get('a'));
        assertEquals(1, freq.size());
    }

    // ─────────────────────────────────────────────────────────────
    // isAnagram(String s1, String s2)
    // ─────────────────────────────────────────────────────────────

    @Test
    void isAnagram_classicAnagram_returnsTrue() {
        assertTrue(App.isAnagram("listen", "silent"));
    }

    @Test
    void isAnagram_notAnagram_returnsFalse() {
        assertFalse(App.isAnagram("hello", "world"));
    }

    @Test
    void isAnagram_differentLengths_returnsFalse() {
        assertFalse(App.isAnagram("ab", "abc"));
    }

    @Test
    void isAnagram_caseInsensitive_returnsTrue() {
        assertTrue(App.isAnagram("Listen", "Silent"));
    }

    @Test
    void isAnagram_withSpaces_returnsTrue() {
        // Spaces are stripped before comparison
        assertTrue(App.isAnagram("anagram", "nag a ram"));
    }

    @Test
    void isAnagram_bothEmpty_returnsTrue() {
        assertTrue(App.isAnagram("", ""));
    }

    @Test
    void isAnagram_sameWord_returnsTrue() {
        assertTrue(App.isAnagram("test", "test"));
    }

    // ─────────────────────────────────────────────────────────────
    // average(int[] arr)
    // ─────────────────────────────────────────────────────────────

    @Test
    void average_normalArray_returnsCorrectAverage() {
        assertEquals(2.0, App.average(new int[]{1, 2, 3}));
    }

    @Test
    void average_singleElement_returnsThatElement() {
        assertEquals(5.0, App.average(new int[]{5}));
    }

    @Test
    void average_allNegatives_returnsCorrectAverage() {
        assertEquals(-2.0, App.average(new int[]{-1, -2, -3}));
    }

    @Test
    void average_mixedPositiveAndNegative_returnsZero() {
        assertEquals(0.0, App.average(new int[]{-1, 1}));
    }

    @Test
    void average_emptyArray_throwsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> App.average(new int[]{}));
    }

    @Test
    void average_nonIntegerResult_returnsCorrectDouble() {
        // 1+2 = 3, 3/2 = 1.5 — verifies double division, not integer division
        assertEquals(1.5, App.average(new int[]{1, 2}));
    }

    // ─────────────────────────────────────────────────────────────
    // filterEvens(List<Integer> list)
    // ─────────────────────────────────────────────────────────────

    @Test
    void filterEvens_mixedList_returnsOnlyEvens() {
        assertEquals(List.of(2, 4), App.filterEvens(Arrays.asList(1, 2, 3, 4)));
    }

    @Test
    void filterEvens_allOdd_returnsEmptyList() {
        assertTrue(App.filterEvens(Arrays.asList(1, 3, 5)).isEmpty());
    }

    @Test
    void filterEvens_allEven_returnsSameValues() {
        assertEquals(List.of(2, 4, 6), App.filterEvens(Arrays.asList(2, 4, 6)));
    }

    @Test
    void filterEvens_emptyList_returnsEmptyList() {
        assertTrue(App.filterEvens(List.of()).isEmpty());
    }

    @Test
    void filterEvens_negativeEvens_areIncluded() {
        assertEquals(List.of(-2, -4), App.filterEvens(Arrays.asList(-2, -1, -4)));
    }

    @Test
    void filterEvens_zero_isIncluded() {
        // 0 % 2 == 0, so zero is even
        assertEquals(List.of(0), App.filterEvens(Arrays.asList(0, 1, 3)));
    }

    // ─────────────────────────────────────────────────────────────
    // mostCommonWord(String text)
    // ─────────────────────────────────────────────────────────────

    @Test
    void mostCommonWord_clearWinner_returnsMostFrequent() {
        assertEquals("the", App.mostCommonWord("the cat sat on the mat the"));
    }

    @Test
    void mostCommonWord_singleWord_returnsThatWord() {
        assertEquals("hello", App.mostCommonWord("hello"));
    }

    @Test
    void mostCommonWord_caseInsensitive_treatsAsSameWord() {
        // "Hello" and "hello" both lowercase to "hello"
        assertEquals("hello", App.mostCommonWord("Hello hello world"));
    }

    @Test
    void mostCommonWord_withPunctuation_ignoresPunctuation() {
        // Splits on \W+ so punctuation is not part of any word
        assertEquals("hi", App.mostCommonWord("hi! hi, hi."));
    }

    @Test
    void mostCommonWord_emptyString_returnsEmptyString() {
        // "".split("\\W+") produces [""], so the count map is {"": 1} and "" is returned.
        // Documents that the function has no guard for empty input.
        assertEquals("", App.mostCommonWord(""));
    }

    @Test
    void mostCommonWord_leadingPunctuation_doesNotPreventCorrectResult() {
        // "!the the".split("\\W+") = ["", "the", "the"] — the empty token gets count 1,
        // but "the" gets count 2 and still wins. Confirms leading punctuation doesn't
        // corrupt the result when there is a clear word winner.
        assertEquals("the", App.mostCommonWord("!the the"));
    }
}
