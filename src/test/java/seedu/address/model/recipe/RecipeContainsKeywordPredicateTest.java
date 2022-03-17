package seedu.address.model.recipe;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalRecipes.AGLIO_OLIO;
import static seedu.address.testutil.TypicalRecipes.CHICKEN_RICE;
import static seedu.address.testutil.TypicalRecipes.FISH_CHIPS;
import static seedu.address.testutil.TypicalRecipes.SHOYU_RAMEN;

import java.util.List;

import org.junit.jupiter.api.Test;

class RecipeContainsKeywordPredicateTest {


    @Test
    public void test_containsKeywords() {
        RecipeContainsKeywordPredicate singlePred = new RecipeContainsKeywordPredicate(List.of("Western"));
        RecipeContainsKeywordPredicate doublePred = new RecipeContainsKeywordPredicate(List.of("Western", "Italian"));
        RecipeContainsKeywordPredicate mixedPred = new RecipeContainsKeywordPredicate(List.of("wEsTerN", "itaLiaN"));
        RecipeContainsKeywordPredicate multiPred =
                new RecipeContainsKeywordPredicate(List.of("Aglio Olio", "Western", "Rice"));


        // Single matching
        assertTrue(singlePred.test(FISH_CHIPS)); // tag == "Western"
        assertTrue(singlePred.test(AGLIO_OLIO)); // tag == "Western", "Italian"

        // Multi matching
        assertTrue(doublePred.test(FISH_CHIPS)); // matches one
        assertTrue(doublePred.test(AGLIO_OLIO)); // matches both

        // Case-insensitive matching
        assertTrue(mixedPred.test(FISH_CHIPS));
        assertTrue(mixedPred.test(AGLIO_OLIO));

        // Matches Name, Tag, Ingredient
        assertTrue(multiPred.test(AGLIO_OLIO));
        assertTrue(multiPred.test(FISH_CHIPS));
        assertTrue(multiPred.test(CHICKEN_RICE));
    }

    @Test
    public void test_doesNotContainKeywords() {
        RecipeContainsKeywordPredicate singlePred = new RecipeContainsKeywordPredicate(List.of("Bacon"));
        RecipeContainsKeywordPredicate doublePred = new RecipeContainsKeywordPredicate(List.of("Eggs", "Caviar"));
        RecipeContainsKeywordPredicate multiPred = new RecipeContainsKeywordPredicate(List.of("Aglio Olio", "Western"));

        // Fail single matching
        assertFalse(singlePred.test(FISH_CHIPS)); // searchString does not contain "bacon"
        assertFalse(singlePred.test(CHICKEN_RICE));

        // Multi matching
        assertFalse(doublePred.test(AGLIO_OLIO));

        // Matches the name as well as the tag
        assertFalse(multiPred.test(SHOYU_RAMEN));
        assertFalse(multiPred.test(CHICKEN_RICE));
    }

    @Test
    public void equalityCheck() {
        RecipeContainsKeywordPredicate singlePred = new RecipeContainsKeywordPredicate(List.of("Bacon"));
        RecipeContainsKeywordPredicate doublePred = new RecipeContainsKeywordPredicate(List.of("Eggs", "Caviar"));
        RecipeContainsKeywordPredicate singlePredCopy = new RecipeContainsKeywordPredicate(singlePred.getKeywords());

        assertNotEquals(singlePred, singlePred.getKeywords());
        assertEquals(singlePred, singlePred);
        assertEquals(singlePred, new RecipeContainsKeywordPredicate(singlePred.getKeywords()));
        assertNotEquals(singlePred, doublePred);

        assertEquals(singlePred.hashCode(), singlePredCopy.hashCode());
        assertNotEquals(singlePred.hashCode(), doublePred.hashCode());
    }
}