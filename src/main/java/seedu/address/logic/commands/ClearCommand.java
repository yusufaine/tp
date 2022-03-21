package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.Model;
import seedu.address.model.RecipeBook;

/**
 * Clears the recipe book.
 */
public class ClearCommand extends Command {
    public static final String COMMAND_WORD = "clear";
    public static final String MESSAGE_SUCCESS = "Recipe book has been cleared!";
    public static final String MESSAGE_CONFIRMATION_REQUIRED = "Are you sure you want to clear the recipe book?"
            + " Enter 'yes' if you wish to clear and 'no' if you do not wish to clear";
    public static final String FORCED_MESSAGE_CONSTRAINT = "There should not be any other inputs after prefix!";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + " -f executes a forced clear with no need for confirmation.\n"
            + COMMAND_WORD
            + " without any parameter will require a confirmation \n"
            + "Example: " + COMMAND_WORD + " -f\n"
            + "Example: " + COMMAND_WORD;

    /* isCalled will be set to true if user enters a clear command. */
    private static boolean isCalled = false;
    /* isConfirmed will be set to true if user confirms to perform the clear command. */
    private static boolean isConfirmed = false;
    /* isForced will be set to true if clear command is forced. */
    private static boolean isForced = false;

    /**
     * Checks whether clear has been called.
     *
     * @return true if clear has been called.
     */
    public static boolean isClearCalled() {
        return isCalled;
    }

    /**
     * Checks whether clear has been confirmed.
     *
     * @return true if clear has been confirmed.
     */

    public static boolean isClearConfirmed() {
        return isConfirmed;
    }

    /**
     * Checks whether clear has been forced.
     *
     * @return true if clear has been forced.
     */

    public static boolean isClearForced() {
        return isForced;
    }

    /**
     * Sets isClear to true or false.
     */

    public static void setIsCalled(boolean b) {
        isCalled = b;
    }

    /**
     * Sets isConfirmed to true or false.
     */

    public static void setIsConfirmed(boolean b) {
        isConfirmed = b;
    }

    /**
     * Sets isForced to true or false.
     */
    public static void setIsForced(boolean b) {
        isForced = b;
    }



    @Override
    public CommandResult execute(Model model) {
        if (isCalled && isConfirmed) {
            isConfirmed = false;
            isCalled = false;
            requireNonNull(model);
            model.setRecipeBook(new RecipeBook());
            return new CommandResult(MESSAGE_SUCCESS);
        } else if (isForced) {
            isForced = false;
            requireNonNull(model);
            model.setRecipeBook(new RecipeBook());
            return new CommandResult(MESSAGE_SUCCESS);
        } else {
            isCalled = true;
            return new CommandResult(MESSAGE_CONFIRMATION_REQUIRED);
        }
    }
}
