package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static seedu.address.testutil.Assert.assertThrows;

import org.junit.jupiter.api.Test;
import seedu.address.commons.core.Messages;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.recipe.Ingredient;

class RecipeBookParserUtilTest {

    @Test
    public void parseIngredient_noQuantity_throwsParseException() {
        assertThrows(ParseException.class, Ingredient.QUANTITY_CONSTRAINTS, () ->
                RecipeBookParserUtil.parseIngredient("ingredient with no quantity"));
    }

    @Test
    public void parseIngredient_moreThanThreeFields_throwsParseException() {
        assertThrows(ParseException.class, Messages.MESSAGE_INVALID_NUMBER_OF_INGREDIENT_FIELDS ,() ->
                RecipeBookParserUtil.parseIngredient("more 1 than, 3.0, fields, error"));
    }

    @Test
    public void parseIngredient_invalidIngredientInput_throwsParseException() throws ParseException {
        String validName = "garlic";
        String invalidName = "";
        String validQuantity = "1";
        String invalidQuantity = "0.0";
        Ingredient expectedIngredient = new Ingredient(validName, Double.parseDouble(validQuantity));

        assertThrows(ParseException.class, Ingredient.NAME_CONSTRAINTS, () ->
                RecipeBookParserUtil.parseIngredient(invalidName + " " + validQuantity));

        assertThrows(ParseException.class, Ingredient.QUANTITY_CONSTRAINTS, () ->
                RecipeBookParserUtil.parseIngredient(validName + " " + invalidQuantity));

        assertThrows(ParseException.class, Ingredient.NAME_CONSTRAINTS, () ->
                RecipeBookParserUtil.parseIngredient(invalidName + " " + invalidQuantity));

        assertEquals(expectedIngredient, RecipeBookParserUtil.parseIngredient(validName + " " + validQuantity));
    }
}
