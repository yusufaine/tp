package seedu.address.model.recipe;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import seedu.address.model.person.Address;
/**
 * Represents the list of steps to make the Recipe in the recipe book.
 * Guarantees: immutable; is valid as declared in {@link #isValidSteps(String)},
 */
public class Step {
    public static final String MESSAGE_CONSTRAINTS = "The steps to make the ingredients should not be empty";

    public final String value;

    /**
     * Constructs a {@code Steps}.
     *
     * @param step A valid list of steps.
     */
    public Step(String step) {
        requireNonNull(step);
        checkArgument(isValidSteps(step), MESSAGE_CONSTRAINTS);
        value = step;
    }

    /**
     * Returns true if the given list of steps is not empty.
     */
    public static boolean isValidSteps(String test) {
        return (!test.isEmpty());
    }

    @Override
    public String toString() {
        return value;
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

}
