package seedu.address.newStorage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.recipe.Ingredient;

/**
 * Jackson-friendly version of {@link Ingredient}.
 */
class JsonAdaptedIngredient {

    public final String ingredientName;
    public final String quantity;
    public final String quantifier;

    /**
     * Constructs a {@code JsonAdaptedTag} with the given {@code tagName}.
     */
    @JsonCreator
    public JsonAdaptedIngredient(String ingredientName, String quantity, String quantifier) {
        this.ingredientName = ingredientName;
        this.quantity = quantity;
        this.quantifier = quantifier;
    }

    /**
     * Converts a given {@code Tag} into this class for Jackson use.
     */
    public JsonAdaptedIngredient(Ingredient source) {
        ingredientName = source.ingredientName;
        quantity = String.valueOf(source.quantity);
        quantifier = source.quantifier;
    }

    @JsonValue
    public String getIngredientName() {
        return ingredientName;
    }

    @JsonValue
    public String getQuantity() {
        return quantity;
    }

    @JsonValue
    public String getQuantifier() {
        return quantifier;
    }

    /**
     * Converts this Jackson-friendly adapted tag object into the model's {@code Tag} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted tag.
     */
    public Ingredient toModelType() throws IllegalValueException {
        if (!Ingredient.isValidIngredientName(ingredientName)) {
            throw new IllegalValueException(Ingredient.NAME_CONSTRAINTS);
        }

        if (!Ingredient.isValidQuantity(quantity)) {
            throw new IllegalValueException(Ingredient.QUANTITY_CONSTRAINTS);
        }

        if (!Ingredient.isValidQuantifier(quantifier)) {
            throw new IllegalValueException(Ingredient.QUANTIFIER_CONSTRAINTS);
        }

        return new Ingredient(ingredientName, quantity, quantifier);
    }

}
