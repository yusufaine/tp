package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.commons.core.Messages.MESSAGE_UNKNOWN_COMMAND;
import static seedu.address.testutil.Assert.assertThrows;
import static seedu.address.testutil.TypicalRecipes.AGLIO_OLIO;

import java.util.List;

import org.junit.jupiter.api.Test;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.commands.ExitCommand;
import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.HelpCommand;
import seedu.address.logic.commands.ListCommand;
import seedu.address.logic.commands.ViewCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.recipe.RecipeContainsKeywordPredicate;

class RecipeBookParserTest {

    RecipeBookParser recipeBookParser = new RecipeBookParser();

    //TODO
    @Test
    public void parseCommand_invalidFormat() {}

    //TODO
    @Test
    public void parseCommand_AddCommand() throws ParseException {
        // AddCommand expectedAddCommand = new AddCommand(AGLIO_OLIO);
        // String userInput = "add "
        //         + "-n Aglio Olio "
        //         + "-d 5 "
        //         + "-i Garlic 3.0 Cloves, Spaghetti 1.0, Olive Oil 500.0 ml, Bacon 3.0 slices "
        //         + "-ss 1 "
        //         + "-s Cook the pasta, Saute the garlic, Toss pasta in the sauce, Toss bacon slices in pasta, " +
        //         "Taste and season "
        //         + "-t Western, Italian ";
        // assertEquals(expectedAddCommand, recipeBookParser.parseCommand(userInput));
    }

    //TODO
    @Test
    public void parseCommand_ClearCommand() {}

    @Test
    public void parseCommand_DeleteCommand() throws ParseException {
        DeleteCommand expectedDeleteCommandName = new DeleteCommand(AGLIO_OLIO.getName());
        DeleteCommand expectedDeleteCommandIndex = new DeleteCommand(Index.fromOneBased(1));

        String userInputName = "delete aglio olio";
        String userInputIndex = "delete -x 1";

        assertEquals(expectedDeleteCommandName, recipeBookParser.parseCommand(userInputName));
        assertEquals(expectedDeleteCommandIndex, recipeBookParser.parseCommand(userInputIndex));
    }

    //TODO
    @Test
    public void parseCommand_EditCommand() {}

    @Test
    public void parseCommand_ExitCommand() throws ParseException {
        ExitCommand expectedExitCommand = new ExitCommand();
        String userInput = "exit";

        assertEquals(expectedExitCommand, recipeBookParser.parseCommand(userInput));
    }

    @Test
    public void parseCommand_FindCommand() throws ParseException {
        FindCommand expectedFindCommand = new FindCommand(new RecipeContainsKeywordPredicate(List.of("Asian",
                "Japanese")));
        String userInput = "find Asian, Japanese";

        assertEquals(expectedFindCommand, recipeBookParser.parseCommand(userInput));
    }

    @Test
    public void parseCommand_HelpCommand() throws ParseException {
        HelpCommand expectedHelpCommand = new HelpCommand();
        String userInput = "help";

        assertEquals(expectedHelpCommand, recipeBookParser.parseCommand(userInput));
    }

    @Test
    public void parseCommand_ListCommand() throws ParseException {
        ListCommand expectedListCommand = new ListCommand();
        String userInput = "list";

        assertEquals(expectedListCommand, recipeBookParser.parseCommand(userInput));
    }

    //TODO
    @Test
    public void parseCommand_ResetCommand() throws ParseException {}

    @Test
    public void parseCommand_ViewCommand() throws ParseException {
        ViewCommand expectedViewCommandName = new ViewCommand(AGLIO_OLIO.getName());
        ViewCommand expectedViewCommandIndex = new ViewCommand(Index.fromOneBased(1));

        String userInputName = "view aglio olio";
        String userInputIndex = "view -x 1";

        assertEquals(expectedViewCommandName, recipeBookParser.parseCommand(userInputName));
        assertEquals(expectedViewCommandIndex, recipeBookParser.parseCommand(userInputIndex));
    }

    @Test
    public void parseCommand_invalidCommandWord() {
        assertThrows(ParseException.class, MESSAGE_UNKNOWN_COMMAND, () -> recipeBookParser.parseCommand("invalid"));
    }

}