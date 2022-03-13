package seedu.address.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

        return new Recipe[] {recipe};
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
       * @param strings ingredients that are to the list of ingredients.
       * @return the list of ingredients containing the newly added ingredients.
       * @throws Exception Throws exception if number of variables is less than required
       *                   or if the 2nd argument (Quantifier) is unable to be parsed as
       *                   double.
       */
    public static List<Ingredient> getIngredientList(String... strings) throws Exception {
        List<Ingredient> listOfIngredients = new ArrayList<>();
        for (String s : strings) {
            try {
                //Get Quantity
                String quantityRegex = s.replaceAll("[^0-9.]+", " ").trim();

                double quantity = Double.parseDouble(quantityRegex);

                //Get Ingredient Name
                String ingredientName = s.substring(0, s.indexOf(quantityRegex.charAt(0))).trim();

                //Get Quantifier if any
                String quantifier = "";
                int lastIndexOfQuantity = s.indexOf(quantityRegex.charAt(quantityRegex.length() - 1)) + 1;
                if (lastIndexOfQuantity < s.length()) {
                    //For edge cases
                    String quantityAndQuantifier = s.substring(lastIndexOfQuantity);
                    String[] delimitedByWhiteSpace = quantityAndQuantifier.split(" ");
                    quantifier = quantityAndQuantifier.substring(quantityAndQuantifier.indexOf(delimitedByWhiteSpace[1].
                            charAt(0)));
                }

                listOfIngredients.add(new Ingredient(ingredientName, quantity, quantifier));

            } catch (NumberFormatException e) {
                throw new Exception("String does not contain Parsable Double");
            }
        }
        return listOfIngredients;
    }

    /**
     * Returns a step list containing the list of strings given.
     * @param strings list of steps to be added to the list of step.
     * @return List of Steps containing the newly added list of step.
     */
    public static List<Step> getStepList(String... strings) {
        return Arrays.stream(strings).map(Step::new).collect(Collectors.toList());
    }

    /**
     * Returns a tag set containing the list of strings given.
     * @param strings list of tag to be added to the list of tag.
     * @return list of tags containing the newly added list of tags.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }


}
