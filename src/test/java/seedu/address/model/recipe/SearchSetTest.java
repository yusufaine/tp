package seedu.address.model.recipe;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

class SearchSetTest {

    private static final SearchSet ss = new SearchSet();

    @Test
    void add_test() {
        List<String> sampleInput = List.of("Western", "Korean", "Aglio Olio", "Bibimbap");
        StringBuilder sb = new StringBuilder();
        for (String s : sampleInput) {
            ss.add(s);
            sb.append(s).append(" ");
        }
        assertEquals(ss.toString(), sb.toString());
    }
}
