package seedu.address.model.recipe;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a searchable values of a recipe for {@code FindCommand}.
 */
public class SearchSet {
    private final Set<String> searchValues = new HashSet<>();

    public Set<String> getSearchValues() {
        return searchValues;
    }

    public void add(String value) {
        searchValues.add(value);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        this.getSearchValues().forEach(v -> sb.append(v).append(" "));
        return sb.toString();
    }
}
