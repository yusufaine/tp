package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.HelpCommand.HELP_MESSAGE;

import org.junit.jupiter.api.Test;
import seedu.address.model.Model;
import seedu.address.model.RecipeBookModelManager;

class HelpCommandTest {
    private Model model = new RecipeBookModelManager();
    private Model expectedModel = new RecipeBookModelManager();

    @Test
    public void execute_help_success() {
        CommandResult expectedCommandResult = new CommandResult(HELP_MESSAGE, true, false);
        assertCommandSuccess(new HelpCommand(), model, expectedCommandResult, expectedModel);
    }
}