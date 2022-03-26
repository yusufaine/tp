package seedu.address.logic.parser;

import seedu.address.logic.commands.ConfirmedResetCommand;
import seedu.address.logic.commands.ResetCommand;
import seedu.address.logic.parser.exceptions.ParseException;


/**
 * Parses input arguments and creates a new ResetCommand object.
 */
public class ResetCommandParser implements Parser<ResetCommand> {
    private static final String PREFIX = "-f";
    /**
     * Checks whether the ResetCommand is a forced Reset.
     *
     * @param arguments that comes after the Reset COMMAND_WORD.
     * @return true if command is a forced Reset.
     */

    public static boolean isNotForcedReset(String arguments) {
        return !arguments.contains(PREFIX);
    }

    /**
     * Parses the given {@code String} of user input in the context of the ResetCommand
     * and returns a ResetCommand object for execution.
     *
     * @param userInput the string name of the recipe to be viewed.
     * @return ConfirmedResetCommand object if it's a forced Reset and ResetCommand if confirmation is required.
     * @throws ParseException if the user input does not conform the expected format.
     */
    @Override
    public ResetCommand parse(String userInput) throws ParseException {
        if (userInput.contains(PREFIX)) {
            return new ConfirmedResetCommand();
        } else {
            return new ResetCommand();
        }
    }
}
