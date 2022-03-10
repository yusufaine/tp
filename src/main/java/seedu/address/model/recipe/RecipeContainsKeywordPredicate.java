package seedu.address.model.recipe;

import java.util.List;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;

/**
 * Tests that a {@code Recipe}'s {@code Name} matches any of the keywords given.
 */
public class RecipeContainsKeywordPredicate implements Predicate<Recipe> {
    private final List<String> keywords;

    public RecipeContainsKeywordPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Recipe recipe) {
        return keywords.stream()
                .anyMatch(v -> StringUtil.containsWordsIgnoreCase(recipe.getSearchSet().toString(), v));
    }
}
