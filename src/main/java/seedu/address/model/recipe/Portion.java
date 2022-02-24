package seedu.address.model.recipe;

import java.util.Objects;

import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a Recipe's portion in the recipe book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPortion(double)}
 */
public class Portion {
    public static final String MESSAGE_CONSTRAINTS = "Portion size should not be left blank";

    public final double value;

    /**
     * Constructs a {@code Portion}.
     *
     * @param portion A valid portion size.
     */
    public Portion(double portion) {
        checkArgument(isValidPortion(portion), MESSAGE_CONSTRAINTS);
        value = portion;
    }

    /**
     * Checks if the quantity is a valid Integer value > 0.
     */
    public static boolean isValidPortion(double test) {
        return (test >= 0);
    }

    @Override
    public String toString() {
        return "" + this.value;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Portion)) {
            return false;
        }

        if (o == this) {
            return true;
        }

        Portion other = (Portion) o;
        return this.value == other.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
