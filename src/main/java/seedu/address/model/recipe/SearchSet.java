package seedu.address.model.recipe;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a searchable values of a recipe for {@code FindCommand}.
 */
public class SearchSet {
    private final Set<String> searchValues = new HashSet<>();
    private final StringBuilder stringRepresentation = new StringBuilder();

    /**
     * Adds the {@code value} into {@code searchValues} and only appends to {@code stringRepresentation} if the
     * element is successfully added into {@code searchValues}.
     * @param value the value that wants to be added into {@code searchValues} and {@code stringRepresentation}.
     */
    public void add(String value) {
        if (this.searchValues.add(value)) {
            this.stringRepresentation.append(value).append(" ");
        }
    }

    @Override
    public String toString() {
        return stringRepresentation.toString();
    }
}
