package seedu.address.model.tag;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

public class TagTest {
    Tag t1 = new Tag("Western");
    Tag t2 = new Tag("Korean");

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Tag(null));
    }

    @Test
    public void constructor_invalidTagName_throwsIllegalArgumentException() {
        String invalidTagName = "";
        assertThrows(IllegalArgumentException.class, () -> new Tag(invalidTagName));
    }

    @Test
    public void toString_test() {
        assertEquals(t1.toString(), "[Western]");
    }

    @Test
    public void isValidTagName() {
        // null tag name
        assertThrows(NullPointerException.class, () -> Tag.isValidTagName(null));
    }

    @Test
    public void equalityCheck() {
        Tag t1_copy = new Tag(t1.tagName);

        // Tag::equals
        assertNotEquals(t1, t1.tagName);
        assertEquals(t1, t1);
        assertEquals(t1, t1_copy);
        assertNotEquals(t1, t2);

        // Tag::hashCode
        assertEquals(t1.hashCode(), t1_copy.hashCode());
        assertNotEquals(t1.hashCode(), t2.hashCode());
    }

}
