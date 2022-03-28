package seedu.address.logic.parser;

import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.ConfirmedClearCommand;
import seedu.address.logic.parser.exceptions.ParseException;


/**
 * Parses input arguments and creates a new ClearCommand object.
 */
public class ClearCommandParser implements Parser<ClearCommand> {
    private static final String FORCE_FLAG = "-f";
    /**
     * Checks whether the ClearCommand is a forced clear.
     *
     * @param arguments that comes after the clear COMMAND_WORD.
     * @return true if command is a forced clear.
     */

    public static boolean isNotForcedClear(String arguments) {
        return !arguments.contains(FORCE_FLAG);
    }

    /**
     * Parses the given {@code String} of user input in the context of the ClearCommand
     * and returns a ClearCommand object for execution.
     *
     * @param userInput the string name of the recipe to be viewed.
     * @return ConfirmedClearCommand object if it's a forced clear and ClearCommand if confirmation is required.
     * @throws ParseException if the user input does not conform the expected format.
     */
    @Override
    public ClearCommand parse(String userInput) throws ParseException {
        if (userInput.contains(FORCE_FLAG)) {
            return new ConfirmedClearCommand();
        } else {
            return new ClearCommand();
        }
    }
}
