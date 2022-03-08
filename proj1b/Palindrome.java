public class Palindrome {
    /* storing string characters with original order */
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> d = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    /* recursion start at 0 */
    public boolean isPalindrome(String word) {
        return isPalindromeHelper(word, 0);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        return isPalindromeHelper(word, 0, cc);
    }

    /**
     * helper function using recursion to judge Palindrome directly (no use of deque),
     * refer to cs61b project1b answer.
     */
    private boolean isPalindromeHelper(String x, int start) {
        int end = x.length() - 1 - start; // end index changes with start index
        if (start >= end) { // base case: when start pass through end (equals if odd length)
            return true;
        }
        if (x.charAt(start) == x.charAt(end)) {
            return isPalindromeHelper(x, start + 1); // recursion
        } else return false;
    }

    private boolean isPalindromeHelper(String x, int start, CharacterComparator cc) {
        int end = x.length() - 1 - start;
        if (start >= end) {
            return true;
        }
        if (cc.equalChars(x.charAt(start), x.charAt(end))) {
            return isPalindromeHelper(x, start + 1, cc);
        } else {
            return false;
        }
    }
}
