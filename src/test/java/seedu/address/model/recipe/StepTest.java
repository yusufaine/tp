package seedu.address.model.recipe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;

class StepTest {
    Step s1 = new Step("chop garlic");
    Step s2 = new Step("saute garlic");

    @Test
    public void constructor_null_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> new Step(null));
    }

    @Test
    public void constructor_invalidName_throwsIllegalArgumentException() {
        String invalidStep = " ";
        assertThrows(IllegalArgumentException.class, () -> new Step(invalidStep));
    }

    @Test
    public void toString_test() {
        assertEquals(s1.toString(), "chop garlic");
    }

    @Test
    public void isValidName() {
        String validStep = "Saute garlic";
        assertTrue(Name.isValidName(validStep));
    }

    @Test
    public void equalityCheck() {
        Step s1_copy = new Step(s1.value);

        // Step::equals
        assertNotEquals(s1, s1.value);
        assertEquals(s1, s1);
        assertEquals(s1, s1_copy);
        assertNotEquals(s1, s2);

        // Step::hashCode
        assertEquals(s1.hashCode(), s1_copy.hashCode());
        assertNotEquals(s1.hashCode(), s2.hashCode());
    }
}
