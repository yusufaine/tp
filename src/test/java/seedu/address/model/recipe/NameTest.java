package seedu.address.model.recipe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class NameTest {
    Name n1 = new Name("test-00");
    Name n2 = new Name("test-01");

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Name(null));
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        String invalidName = " ";
        assertThrows(IllegalArgumentException.class, () -> new Name(invalidName));
    }

    @Test
    public void toString_test() {
        assertEquals(n1.toString(), "test-00");
    }

    @Test
    public void isValidName() {
        String validName = "Aglio Olio";
        assertTrue(Name.isValidName(validName));
    }

    @Test
    public void equalityCheck() {
        Name n1_copy = new Name(n1.fullName);
        // Name::equals
        assertNotEquals(n1, n1.fullName);
        assertEquals(n1, n1);
        assertEquals(n1, n1_copy);
        assertNotEquals(n1, n2);

        // Name::hashCode
        assertEquals(n1.hashCode(), n1_copy.hashCode());
        assertNotEquals(n1.hashCode(), n2.hashCode());
    }
}
