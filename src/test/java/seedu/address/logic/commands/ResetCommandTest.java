package seedu.address.logic.commands;

import org.junit.jupiter.api.Test;
import seedu.address.model.Model;
import seedu.address.model.RecipeBookModelManager;
import seedu.address.model.UserPrefs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalRecipes.getTypicalRecipeBook;

/**
 * Contains integration tests (interaction with the Model) and unit tests for.
 * {@code ResetCommand}.
 */
public class ResetCommandTest {
    private final Model model = new RecipeBookModelManager(getTypicalRecipeBook(), new UserPrefs());
    private final Model expectedModel = new RecipeBookModelManager(getTypicalRecipeBook(), new UserPrefs());

    @Test
    public void execute_showsRequireConfirmationMessage() {
        ResetCommand command = new ResetCommand();
        String expectedMessage = "Are you sure you want to clear and reset the "
                + "recipe book to the default preloaded recipes? Enter 'yes' if you wish to clear and 'no' if you "
                + "do not wish to clear";
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
    }

    @Test
    public void equals_test() {
        ResetCommand c1 = new ResetCommand();
        ResetCommand c2 = new ResetCommand();
        ConfirmedResetCommand confirmedReset = new ConfirmedResetCommand();
        CancelResetCommand cancelReset = new CancelResetCommand();
        assertEquals(c1, c1);
        assertEquals(c1, c2);
        assertNotEquals(c1, confirmedReset);
        assertNotEquals(c1, cancelReset);
    }

}
