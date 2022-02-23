package seedu.address.logic.commands;

import seedu.address.commons.core.Messages;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.RecipeBookModel;
import seedu.address.model.person.Person;
import seedu.address.model.recipe.Ingredient;
import seedu.address.model.recipe.Name;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.tag.Tag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static java.util.Objects.requireNonNull;

/**
 * Deletes a person identified using it's displayed index from the address book.
 */
public class ViewCommand extends Command {

    public static final String COMMAND_WORD = "view";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays the details of a recipe identified by the index number of "
            + "the recipe in the recipe list.\n"
            + "Parameters: INDEX (must be a positive integer)\n"
            + "Example: " + COMMAND_WORD + " 1";

    public static final String RECIPE_CONTENT = "Name: %s\n"
            + "Ingredients:\n%s\n"
            + "Steps:\n%s\n";

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
//                recipe.getName(), getIngredients(recipe), getDirections(recipe)));
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
                recipe.getName(), getIngredients(recipe), getDirections(recipe)));
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
            ingredients.append(String.format("%s %.2f%s\n", ingredient.getIngredientName(),
                    ingredient.getQuantity(), ingredient.getQuantifier()));
        }
        return ingredients.toString();
    }

    private String getDirections(Recipe recipe) {
        StringBuilder steps = new StringBuilder();
        for (String step : recipe.getDirections()) {
            steps.append(String.format("%s\n", step));
        }
        return steps.toString();
    }

    private Recipe createTestRecipe() {
        Name name = new Name("bread");
        List<Ingredient> ingredients = new ArrayList<>();

        Ingredient flour = new Ingredient("flour","1", "kg");
        Ingredient milk = new Ingredient("milk","100.50", "ml");
        Ingredient sugar = new Ingredient("sugar","45.5", "g");

        ingredients.add(flour);
        ingredients.add(milk);
        ingredients.add(sugar);

        List<String> directions = new ArrayList<>();
        directions.add("whisk flour and sugar together");
        directions.add("pour milk and knead dough until firm");
        directions.add("bake at 180c for 20 minutes");

        Set<Tag> tags = new HashSet<>();

        return new Recipe(name,ingredients,4,directions,tags);
    }
}
