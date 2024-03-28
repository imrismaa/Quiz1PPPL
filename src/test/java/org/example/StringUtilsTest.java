package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilsTest {
    public StringUtils string = new StringUtils();

    @Test
    void testReverseString() {
        assertNull(string.reverseString(null));
    }

    @Test
    void testReverseString2() {
        assertEquals("arukaS", string.reverseString("Sakura"));
        assertNotNull(string.reverseString("Sakura"));
        assertSame(6, string.reverseString("Sakura").length());
    }

    @Test
    void testIsPalindrome() {
        assertFalse(string.isPalindrome(null));
    }

    @Test
    void testIsPalindrome2() {
        assertTrue(string.isPalindrome("Kasur ini rusak"));
    }

    @Test
    void testCountVowels() {
        assertEquals(0, string.countVowels(null));
    }

    @Test
    void testCountVowels2() {
        assertEquals(4, string.countVowels("Eunchae"));
        assertNotEquals(0, string.countVowels("Eunchae"));
    }
}