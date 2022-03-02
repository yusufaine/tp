package seedu.address.logic.commands;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;
import seedu.address.model.recipe.CompletionTime;
import seedu.address.model.recipe.Ingredient;
import seedu.address.model.recipe.Name;
import seedu.address.model.recipe.Portion;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.Step;
import seedu.address.model.tag.Tag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Objects.requireNonNull;

/**
 * Displays the contents of a recipe to the resultBox
 */
public class ViewCommand extends Command {

    public static final String COMMAND_WORD = "view";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays the details of a recipe identified by the index number of "
            + "the recipe in the recipe list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String RECIPE_CONTENT = "Name: %s\n\n"
            + "Ingredients:\n%s\n"
            + "Steps:\n%s\n"
            + "Total time: %s\n"
            + "Servings: %s";

    private final Index targetIndex;

    public ViewCommand(Index targetIndex) {
        this.targetIndex = targetIndex;
    }

    /*
    REPLACE WITH THIS WHEN RecipeBookModel HAS BEEN INTEGRATED.
     */
//    @Override
//    public CommandResult execute(RecipeBookModel model) throws CommandException {
//        requireNonNull(model);
//        List<Recipe> lastShownList = model.getFilteredRecipeList();
//
//        if (targetIndex.getZeroBased() >= lastShownList.size()) {
//            // throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
//            throw new CommandException("That's an invalid index");
//        }
//
//        Recipe recipe = lastShownList.get(targetIndex.getZeroBased());
//
//
//        return new CommandResult(String.format(RECIPE_CONTENT,
//                recipe.getName(), getIngredients(recipe), getSteps(recipe));
//                recipe.getCompletionTime(), recipe.getPortion()));
//    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Person> lastShownList = model.getFilteredPersonList();

        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            // throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
            throw new CommandException("invalid index, recipe not found");
        }

        Recipe recipe = createTestRecipe();

        return new CommandResult(String.format(RECIPE_CONTENT,
                recipe.getName(), getIngredients(recipe), getSteps(recipe),
                recipe.getCompletionTime(), recipe.getPortion()));
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ViewCommand // instanceof handles nulls
                && targetIndex.equals(((ViewCommand) other).targetIndex)); // state check
    }

    private String getIngredients(Recipe recipe) {
        StringBuilder ingredients = new StringBuilder();
        for (Ingredient ingredient : recipe.getIngredients()) {
            ingredients.append(String.format("%s %s%s\n", ingredient.getIngredientName(),
                    ingredient.getQuantity(), ingredient.getQuantifier()));
        }
        return ingredients.toString();
    }

    private String getSteps(Recipe recipe) {
        int index = 1;
        StringBuilder steps = new StringBuilder();
        for (Step step : recipe.getSteps()) {
            steps.append(String.format("%d. %s\n", index, step.toString()));
            index++;
        }
        return steps.toString();
    }

    private Recipe createTestRecipe() {
        Name name = new Name("bread");
        List<Ingredient> ingredients = new ArrayList<>();

        Ingredient flour = new Ingredient("flour", "1", "kg");
        Ingredient milk = new Ingredient("milk", "100.50", "ml");
        Ingredient sugar = new Ingredient("sugar", "45.5", "g");

        ingredients.add(flour);
        ingredients.add(milk);
        ingredients.add(sugar);

        List<Step> steps = new ArrayList<>();
        steps.add(new Step("whisk flour and sugar together"));
        steps.add(new Step("pour milk and knead dough until firm"));
        steps.add(new Step("bake at 180c for 20 minutes"));

        CompletionTime completionTime = new CompletionTime(40);
        Portion portion = new Portion(1.0);

        Set<Tag> tags = new HashSet<>();

        return new Recipe(name, ingredients, completionTime, portion, steps, tags);
    }
}
