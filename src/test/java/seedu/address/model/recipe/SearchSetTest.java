package seedu.address.model.recipe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SearchSetTest {

    private final SearchSet ss = new SearchSet();
    private final List<String> sampleInput = List.of("Western", "Korean", "Aglio Olio", "Bibimbap");
    private final StringBuilder sb = new StringBuilder();

    @BeforeEach
    void initialise() {
        for (String s : sampleInput) {
            ss.add(s);
            appendString(sb, s);
        }
    }

    @Test
    void add_test_success() {
        String newValue = "Halal";
        ss.add(newValue);
        appendString(sb, newValue);
        assertEquals(ss.toString(), sb.toString());
    }

    @Test
    void add_value_exists() {
        String existingValue = "Western";
        ss.add(existingValue);
        appendString(sb, existingValue);
        assertNotEquals(ss.toString(), sb.toString());
    }

    private void appendString(StringBuilder sb, String s) {
        sb.append(s).append(" ");
    }
}
