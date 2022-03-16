package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.recipe.Name;
import seedu.address.model.recipe.Recipe;

/**
 * Displays the contents of a recipe to the result display.
 */
public class ViewCommand extends Command {

    public static final String COMMAND_WORD = "view";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Displays the details of a recipe identified by the name of "
            + "the recipe in the recipe list.\n"
            + "Parameters: name (must be a valid case sensitive name)\n"
            + "Example: " + COMMAND_WORD + " Mac and cheese";

    private final Name targetName;

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

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        List<Recipe> lastShownList = model.getFilteredRecipeList();
        Recipe recipe = getRecipe(lastShownList, targetName);

        if (recipe == null) { // Recipe not found in LastShownList
            throw new CommandException(String.format(Messages.MESSAGE_RECIPE_NOT_FOUND, targetName.fullName));
        }

        return new CommandResult(recipe);
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof ViewCommand // instanceof handles nulls
                && targetName.equals(((ViewCommand) other).targetName)); // state check
    }

    /**
     * Retrieves the {@code Recipe} with the same name as the specified name
     * from a given list of recipes.
     * Returns null if a recipe with the same name cannot be found.
     *
     * @param lastShownList the list of recipes to search from.
     * @param recipeName the name of the recipe to match.
     * @return the recipe from the list matching the specified name.
     */
    private Recipe getRecipe(List<Recipe> lastShownList, Name recipeName) {
        for (Recipe recipe : lastShownList) {
            if (recipeName.equals(recipe.getName())) {
                return recipe;
            }
        }
        return null;
    }
}
