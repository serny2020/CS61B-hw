import org.junit.Test;

import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();

    @Test
    public void testWordToDeque() {
        Deque<Character> d = palindrome.wordToDeque("persiflage");
        String actual = "";
        for (int i = 0; i < "persiflage".length(); i++) {
            actual += d.removeFirst();
        }
//        System.out.println(actual);
        assertEquals("persiflage", actual);
    }

    @Test
    public void testisPalindrome() {
//        int a = 'a';
//        int b = 'A';
//        System.out.println(a);
//        System.out.println(b);
        assertTrue(palindrome.isPalindrome("c"));
        assertTrue(palindrome.isPalindrome(""));
        assertTrue(palindrome.isPalindrome("cc"));
        assertTrue(palindrome.isPalindrome("aba"));
        assertTrue(palindrome.isPalindrome("abba"));
        assertFalse(palindrome.isPalindrome("ab"));
        assertFalse(palindrome.isPalindrome("cat"));
        assertFalse(palindrome.isPalindrome("aaaaacataaaaa"));
    }

    @Test
    public void testisPalindromeoffByOne() {
        CharacterComparator cc = new OffByOne();
        assertTrue(palindrome.isPalindrome("flake", cc));
    }

    @Test
    public void testisPalindromeoffByN() {
        CharacterComparator cc = new OffByN(1);
        assertTrue(palindrome.isPalindrome("flake", cc));
    }
}

// Uncomment this class once you've created your Palindrome class.

