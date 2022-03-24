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
 * {@code CancelResetCommand}.
 */
public class CancelResetCommandTest {
    private final Model model = new RecipeBookModelManager(getTypicalRecipeBook(), new UserPrefs());
    private final Model expectedModel = new RecipeBookModelManager(getTypicalRecipeBook(), new UserPrefs());

    @Test
    public void execute_showsCancellationMessage_success() {
        CancelResetCommand command = new CancelResetCommand();
        String expectedMessage = "Reset has been cancelled!";
        assertCommandSuccess(command, model, expectedMessage, expectedModel);
    }

    @Test
    public void equals_test() {
        ResetCommand Reset = new ResetCommand();
        CancelResetCommand c1 = new CancelResetCommand();
        CancelResetCommand c2 = new CancelResetCommand();
        assertEquals(c1, c1);
        assertEquals(c1, c2);
        assertNotEquals(c1, Reset);
    }

}
