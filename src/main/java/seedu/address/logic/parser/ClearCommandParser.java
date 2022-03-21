package seedu.address.logic.parser;
import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.ConfirmationCommand;
import seedu.address.logic.commands.ViewCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.recipe.Name;

import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.RecipeBookSyntax.PREFIX_INDEX;
import static seedu.address.logic.parser.RecipeBookSyntax.PREFIX_NAME;

/**
 * Parses input arguments and creates a new ConfirmationCommand object.
 */
public class ConfirmationCommandParser implements Parser<ConfirmationCommand> {
    /**
     * Parses the given {@code String} of user input in the context of the ViewCommand
     * and returns a ViewCommand object for execution.
     *
     * @param command the string name of the recipe to be viewed.
     * @param forcePrefixExists the string name of the recipe to be viewed.
     * @return the ViewCommand object that displays the contents of the appropriate recipe.
     * @throws ParseException if the user input does not conform the expected format.
     */
    @Override
    public ConfirmationCommand parse(String command, String forcePrefixExists) throws ParseException {
        // Prefix defaults to name if indexFlag is not specified
        String indexFlag = "-x";
        Prefix prefix = userInput.contains(indexFlag)
                ? PREFIX_INDEX
                : PREFIX_NAME;
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(userInput, prefix);

        try {
            if (userInput.contains(indexFlag)) {
                Index index = RecipeBookParserUtil.parseIndex(argMultimap.getValue(PREFIX_INDEX).get());
                return new ConfirmationCommand(index);
            } else {
                Name name = RecipeBookParserUtil.parseName(userInput);
                return new ConfirmationCommand(name);
            }
        } catch (ParseException pe) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, ViewCommand.MESSAGE_USAGE), pe);
        }
    }

}
