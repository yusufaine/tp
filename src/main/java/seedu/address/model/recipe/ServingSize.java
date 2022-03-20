package seedu.address.model.recipe;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.Objects;
/**
 * Represents a Recipe's serving size in the recipe book.
 * Guarantees: immutable; is valid as declared in {@link #isValidServingSize(Integer)}
 */
public class ServingSize {
    public static final String MESSAGE_CONSTRAINTS =
            "ServingSize size should not be left blank or less than or equals to 0";

    public final Integer value;

    /**
     * Constructs a {@code ServingSize}.
     *
     * @param size A valid serving size.
     */
    public ServingSize(Integer size) {
        requireNonNull(size);
        checkArgument(isValidServingSize(size), MESSAGE_CONSTRAINTS);
        value = size;
    }

    /**
     * Checks if the size is a valid Integer value > 0.
     */
    public static boolean isValidServingSize(Integer test) {
        return test > 0;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof ServingSize)) {
            return false;
        }

        if (o == this) {
            return true;
        }

        ServingSize other = (ServingSize) o;
        return this.value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
