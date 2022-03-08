import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TestOffByOne {

    // You must use this CharacterComparator and not instantiate
    // new ones, or the autograder might be upset.
    static CharacterComparator offByOne = new OffByOne();

    @Test
    public void testEqualChars() {
        assertTrue("true", offByOne.equalChars('a', 'b'));
        assertTrue("true", offByOne.equalChars('r', 'q'));
        assertFalse("true", offByOne.equalChars('a', 'e'));
        assertFalse("true", offByOne.equalChars('z', 'a'));
        assertFalse("true", offByOne.equalChars('a', 'a'));

    }


}
// Your tests go here.
// Uncomment this class once you've created your CharacterComparator interface and OffByOne class.

