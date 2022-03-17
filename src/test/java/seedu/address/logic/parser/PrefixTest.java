package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class PrefixTest {

    Prefix name = new Prefix("-n");
    Prefix index = new Prefix("-x");

    @Test
    public void equalityCheck() {
        Prefix nameCopy = new Prefix(name.getPrefix());

        assertEquals(name.toString(), "-n");
        
        // Prefix::equals
        assertNotEquals(name, name.getPrefix());
        assertEquals(name, name);
        assertEquals(name, nameCopy);
        assertNotEquals(name, index);

        // Prefix::hashCode
        assertEquals(name.hashCode(), nameCopy.hashCode());
        assertNotEquals(name.hashCode(), index.hashCode());
    }

}