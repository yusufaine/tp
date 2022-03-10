package seedu.address.logic.parser;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import seedu.address.logic.commands.ViewCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.recipe.Name;


public class ViewCommandParser implements Parser<ViewCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the ViewCommand
     * and returns a ViewCommand object for execution.
     *
     * @param args the string name of the recipe to be viewed.
     * @return the ViewCommand object that displays the contents of the appropriate recipe.
     * @throws ParseException if the user input does not conform the expected format.
     */
    public ViewCommand parse(String args) throws ParseException {
        try {
            Name name = RecipeBookParserUtil.parseName(args);
            return new ViewCommand(name);
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.MESSAGE_USAGE), pe);
        }
    }

}
