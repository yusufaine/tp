package seedu.address.model.recipe;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.Objects;

/**
 * Represents a Recipe's completion time in the recipe book.
 * Guarantees: immutable; is valid as declared in {@link #isValidCompletionTime(int)}
 */
public class CompletionTime {

    public static final String MESSAGE_CONSTRAINTS = "Portion size should not be left blank";

    public final int value;

    /**
     * Constructs a {@code CompletionTime}.
     *
     * @param completionTime A valid completion time.
     */
    public CompletionTime(int completionTime) {
        requireNonNull(completionTime);
        checkArgument(isValidCompletionTime(completionTime), MESSAGE_CONSTRAINTS);

        value = completionTime;
    }

    public static boolean isValidCompletionTime(int test) {
        return (test > 0);
    }

    @Override
    public String toString() {
        return String.format("%d", value);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof CompletionTime)) {
            return false;
        }

        if (this == o) {
            return true;
        }

        CompletionTime other = (CompletionTime) o;
        return this.value == other.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
