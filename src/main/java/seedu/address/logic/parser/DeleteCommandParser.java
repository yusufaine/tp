package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.DeleteCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.recipe.Name;

/**
 * Parses input arguments and creates a new DeleteCommand object
 */
public class DeleteCommandParser implements Parser<DeleteCommand> {

    /**
     * Parses the given {@code String} of user input in the context of the DeleteCommand
     * and returns a DeleteCommand object for execution.
     *
     * @param userInput the string name of the recipe to be viewed.
     * @return the DeleteCommand object that deletes the command from the RecipeBook.
     * @throws ParseException if the user input does not conform the expected format.
     */
    @Override
    public DeleteCommand parse(String userInput) throws ParseException {
        try {
            Name recipeName = RecipeBookParserUtil.parseName(userInput);
            return new DeleteCommand(recipeName);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, DeleteCommand.MESSAGE_USAGE), pe);
        }
    }
}

