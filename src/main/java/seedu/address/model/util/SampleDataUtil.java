package seedu.address.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.logic.parser.RecipeBookParserUtil;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.ReadOnlyRecipeBook;
import seedu.address.model.RecipeBook;
import seedu.address.model.recipe.CompletionTime;
import seedu.address.model.recipe.Ingredient;
import seedu.address.model.recipe.Name;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.ServingSize;
import seedu.address.model.recipe.Step;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code RecipeBook} with sample data.
 */
public class SampleDataUtil {
    private static Recipe[] getSampleRecipes() {
        //Aglio Olio
        Ingredient ingredient1 = new Ingredient("Garlic", 3, "Cloves");
        Ingredient ingredient2 = new Ingredient("Spaghetti", 1);
        Ingredient ingredient3 = new Ingredient("Olive oil", 500, "ml");
        Ingredient ingredient4 = new Ingredient("Bacon", 3, "slices");

        Ingredient[] ingredientArr = new Ingredient[]{ingredient1, ingredient2, ingredient3, ingredient4};
        List<Ingredient> ingredients = List.of(ingredientArr);

        Step step1 = new Step("Cook the pasta");
        Step step2 = new Step("Saute the garlic");
        Step step3 = new Step("Toss pasta in the sauce");
        Step step4 = new Step("Toss bacon slices in pasta");
        Step step5 = new Step("Taste and season");

        List<Step> steps = new ArrayList<>(List.of(new Step[]{step1, step2, step3, step4, step5}));

        Recipe recipe = new Recipe(new Name("Aglio Olio"), new CompletionTime(5), new ServingSize(1),
                ingredients, steps, getTagSet("Western", "Italian"));

        //Nasi Lemak
        Ingredient i1 = new Ingredient("fish", 10);
        Ingredient i2 = new Ingredient("rice", 1, null);

        Ingredient[] ingredientArr2 = new Ingredient[]{i1, i2};
        List<Ingredient> nasiLemakIngredients = List.of(ingredientArr2);

        Step s1 = new Step("toss it into the dustbin");
        List<Step> steps2 = new ArrayList<>(List.of(new Step[]{s1}));

        Recipe recipe2 = new Recipe(new Name("Nasi Lemak"), new CompletionTime(10), new ServingSize(5),
                nasiLemakIngredients, steps2, getTagSet("Asian", "Malay"));


        return new Recipe[] {recipe, recipe2};
    }

    public static ReadOnlyRecipeBook getSampleRecipeBook() {
        RecipeBook sampleRb = new RecipeBook();
        for (Recipe sampleRecipe : SampleDataUtil.getSampleRecipes()) {
            sampleRb.addRecipe(sampleRecipe);
            System.out.println(sampleRb);
        }
        return sampleRb;
    }

    /**
       * Returns an ingredient list containing the list of strings given.
       *
       * @param strings ingredients that are to the list of ingredients.
       * @return the list of ingredients containing the newly added ingredients.
       * @throws ParseException if any of the fields given in {@code strings} is invalid.
       */
    public static List<Ingredient> getIngredientList(String... strings) throws ParseException {
        Collection<String> toBeParsed = List.of(strings);
        return RecipeBookParserUtil.parseIngredients(toBeParsed);
    }

    /**
     * Returns a step list containing the list of strings given.
     *
     * @param strings list of steps to be added to the list of step.
     * @return List of Steps containing the newly added list of step.
     */
    public static List<Step> getStepList(String... strings) {
        return Arrays.stream(strings).map(Step::new).collect(Collectors.toList());
    }

    /**
     * Returns a tag set containing the list of strings given.
     *
     * @param strings list of tag to be added to the list of tag.
     * @return list of tags containing the newly added list of tags.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }


}
