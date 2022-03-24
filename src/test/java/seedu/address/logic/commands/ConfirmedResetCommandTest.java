package seedu.address.logic.commands;

import org.junit.jupiter.api.Test;

import seedu.address.model.Model;
import seedu.address.model.ReadOnlyRecipeBook;
import seedu.address.model.RecipeBook;
import seedu.address.model.RecipeBookModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.util.SampleDataUtil;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalRecipes.getTypicalRecipeBook;

/**
 * Contains integration tests (interaction with the Model) and unit tests for.
 * {@code ConfirmedResetCommand}.
 */
public class ConfirmedResetCommandTest {
    private final Model model = new RecipeBookModelManager(getTypicalRecipeBook(), new UserPrefs());
    private final Model expectedModel = new RecipeBookModelManager(getTypicalRecipeBook(), new UserPrefs());

    @Test
    public void execute_recipeBookReset_success() {
        ConfirmedResetCommand command = new ConfirmedResetCommand();
        ReadOnlyRecipeBook readOnlyBeforeReset = model.getRecipeBook();
        RecipeBook beforeReset = new RecipeBook(readOnlyBeforeReset);

        expectedModel.setRecipeBook(SampleDataUtil.getSampleRecipeBook());
        String expectedMessage = "Recipe book has been Reset!";

        assertCommandSuccess(command, model, expectedMessage, expectedModel);
        assertEquals(model.getRecipeBook(), expectedModel.getRecipeBook());
        assertNotEquals(beforeReset, new RecipeBook(model.getRecipeBook()));
    }

    @Test
    public void equals_test() {
        ResetCommand Reset = new ResetCommand();
        ConfirmedResetCommand c1 = new ConfirmedResetCommand();
        ConfirmedResetCommand c2 = new ConfirmedResetCommand();
        assertEquals(c1, c1);
        assertEquals(c1, c2);
        assertNotEquals(c1, Reset);
    }

}
