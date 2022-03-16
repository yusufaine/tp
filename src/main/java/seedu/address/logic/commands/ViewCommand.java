package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.logic.parser.RecipeBookParserUtil;
import seedu.address.model.Model;
import seedu.address.model.recipe.Ingredient;
import seedu.address.model.recipe.Name;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.Step;

/**
 * Displays the contents of a recipe to the result display.
 */
public class ViewCommand extends Command {

    public static final String COMMAND_WORD = "view";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays the details of a recipe identified by the name of "
            + "the recipe in the recipe list.\n\n"
            + "Parameters:\n1. name (must be a valid name, not case-sensitive)\n"
            + "2. index (must be a valid non-negative index)\n\n"
            + "Example: " + COMMAND_WORD + " Mac and cheese\n"
            + "Example: " + COMMAND_WORD + " -x 3";

    public static final String RECIPE_CONTENT = "Name: %s\n\n"
            + "Total time: %s\n"
            + "Servings: %s\n\n"
            + "Ingredients:\n%s\n"
            + "Steps:\n%s\n";

    private Name targetName;
    private Index targetIndex;

    /**
     * Create a ViewCommand that displays the contents of stored recipe
     * with the same {@code Name} as the specified name.
     *
     * @param targetName Name of recipe to be viewed.
     */
    public ViewCommand(Name targetName) {
        requireNonNull(targetName);
        this.targetName = targetName;
    }

    /**
     * Create a ViewCommand that displays the contents of stored recipe
     * at the specified {@code Index} of the list.
     *
     * @param targetIndex Index (one-based) of recipe to be viewed.
     */
    public ViewCommand(Index targetIndex) {
        requireNonNull(targetIndex);
        this.targetIndex = targetIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Recipe> lastShownList = model.getFilteredRecipeList();

        // Guaranteed that either targetIndex or targetName is non-null.
        Recipe recipe = (targetIndex != null)
                ? getRecipe(lastShownList, targetIndex)
                : getRecipe(lastShownList, targetName);

        if (recipe == null) { // Recipe not found in LastShownList
            throw new CommandException(String.format(Messages.MESSAGE_RECIPE_NOT_FOUND, targetName.fullName));
        }

        return new CommandResult(generateRecipeContent(recipe));
    }

    @Override
    public boolean equals(Object o) {
        // instanceof handles nulls
        if (!(o instanceof ViewCommand)) {
            return false;
        }

        // short circuit if same object
        if (this == o) {
            return true;
        }

        ViewCommand other = (ViewCommand) o;
        return targetName.equals(other.targetName)
                || targetIndex.equals(other.targetIndex); // state check
    }

    /**
     * Generates a properly formatted string of the contents of a specified {@code Recipe}.
     *
     * @param recipe the recipe to read the contents from.
     * @return a formatted String of the contents of the specified recipe.
     */
    private String generateRecipeContent(Recipe recipe) {
        return String.format(RECIPE_CONTENT,
                recipe.getName(),
                recipe.getCompletionTime(),
                recipe.getServingSize(),
                getIngredients(recipe),
                getSteps(recipe));
    }

    /**
     * Retrieves the {@code Recipe} with the same name as the specified name
     * from a given list of recipes.
     * Returns null if a recipe with the same name cannot be found.
     *
     * @param lastShownList the list of recipes to search from.
     * @param recipeName the name of the recipe to view.
     * @return the recipe from the list matching the specified name.
     */
    private Recipe getRecipe(List<Recipe> lastShownList, Name recipeName) {
        for (Recipe recipe : lastShownList) {
            if (RecipeBookParserUtil.isRecipeNamesEqual(recipeName, recipe.getName())) {
                return recipe;
            }
        }
        return null;
    }

    /**
     * Retrieves the {@code Recipe} at the specified index from the given list of recipes. <br>
     * Returns null if a recipe with the same name cannot be found.
     *
     * @param lastShownList the list of recipes to search from.
     * @param recipeIndex the index (zero-based) of the recipe to view.
     * @return the recipe from the list matching the specified index.
     */
    private Recipe getRecipe(List<Recipe> lastShownList, Index recipeIndex) {
        int zeroBasedIndex = recipeIndex.getZeroBased();
        if (zeroBasedIndex < lastShownList.size()) {
            return lastShownList.get(zeroBasedIndex);
        }
        return null;
    }

    /**
     * Parses the {@code Ingredient}s of a given {@code Recipe} into a formatted String for display.
     *
     * @param recipe the recipe to parse.
     * @return the formatted String of ingredients.
     */
    private String getIngredients(Recipe recipe) {
        StringBuilder ingredients = new StringBuilder();
        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredients.append(String.format("%s %s %s\n", ingredient.getIngredientName(),
                    ingredient.getQuantity(), ingredient.getQuantifier()));
        }
        return ingredients.toString();
    }

    /**
     * Parses the {@code Step}s of a given {@code Recipe} into a formatted String for display.
     *
     * @param recipe the recipe to parse.
     * @return the formatted String of steps.
     */
    private String getSteps(Recipe recipe) {
        StringBuilder steps = new StringBuilder();
        for (int i = 0; i < recipe.getSteps().size(); i++) {
            Step step = recipe.getSteps().get(i);
            steps.append(String.format("%d. %s\n", (i + 1), step.toString()));
        }
        return steps.toString();
    }
}
