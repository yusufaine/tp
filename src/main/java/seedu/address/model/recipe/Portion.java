package seedu.address.model.recipe;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

import java.util.Objects;
/**
 * Represents a Recipe's portion in the recipe book.
 * Guarantees: immutable; is valid as declared in {@link #isValidPortion(Double)}
 */
public class Portion {
    public static final String MESSAGE_CONSTRAINTS = "Portion size should not be left blank or "
            + "less than or equals to 0";

    public final Double value;

    /**
     * Constructs a {@code Portion}.
     *
     * @param portion A valid portion size.
     */
    public Portion(Double portion) {
        requireNonNull(portion);
        checkArgument(isValidPortion(portion), MESSAGE_CONSTRAINTS);
        value = portion;
    }

    /**
     * Checks if the quantity is a valid Double value > 0.
     */
    public static boolean isValidPortion(Double test) {
        return test > 0;
    }

    @Override
    public String toString() {
        return String.valueOf(this.value);
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
        return this.value.equals(other.value);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }
}
