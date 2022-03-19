package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.recipe.Name;
import seedu.address.model.recipe.Recipe;



/**
 * Deletes a recipe identified using it's displayed recipe name from the Recipe Book.
 */
public class DeleteCommand extends Command {

    public static final String COMMAND_WORD = "delete";

    public static final String MESSAGE_USAGE = COMMAND_WORD
            + ": Deletes the recipe identified by the name used in the displayed list of recipes.\n"
            + "Parameters: name (must be a valid case sensitive name)\n"
            + "Example: " + COMMAND_WORD + " Aglio Olio\n"
            + "Example: " + COMMAND_WORD + " -i 3";

    public static final String MESSAGE_DELETE_RECIPE_SUCCESS = "Deleted Recipe: %1$s";
    public static final String MESSAGE_DELETE_RECIPE_NOT_EXIST = "Recipe does not exist in the recipe book";


    private Name toDelete;
    private Index toDeleteIndex;

    /**
     * Creates a DeleteCommand to delete the specified {@code Recipe}
     * @param toDelete
     */
    public DeleteCommand(Name toDelete) {
        this.toDelete = toDelete;
    }

    public DeleteCommand(Index toDeleteIndex) {
        this.toDeleteIndex = toDeleteIndex;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        List<Recipe> lastShownList = model.getFilteredRecipeList();
        int recipeToDeleteIndex = (toDeleteIndex != null)
                ? this.toDeleteIndex.getZeroBased()
                : getRecipeIndex(lastShownList, toDelete);
        if (recipeToDeleteIndex >= 0) {
            Recipe recipeToDelete = lastShownList.get(recipeToDeleteIndex);
            model.deleteRecipe(recipeToDelete);
            return new CommandResult(String.format(MESSAGE_DELETE_RECIPE_SUCCESS, recipeToDelete));
        } else {
            throw new CommandException(MESSAGE_DELETE_RECIPE_NOT_EXIST);
        }
    }

    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof DeleteCommand // instanceof handles nulls
                && toDelete.equals(((DeleteCommand) other).toDelete)); // state check
    }

    /**
     * Gets index of each recipe in the last shown list
     * @param lastShownList list shown after user searches a particular field
     * @param recipeName name of recipe
     * @return indexes of recipes in the lastShownList
     */
    private int getRecipeIndex(List<Recipe> lastShownList, Name recipeName) {
        for (Recipe recipe : lastShownList) {
            if (recipeName.equals(recipe.getName())) {
                return lastShownList.indexOf(recipe);
            }
        }
        return -1;
    }
}
