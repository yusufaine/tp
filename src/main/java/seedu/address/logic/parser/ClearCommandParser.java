//package seedu.address.logic.parser;
//
//import seedu.address.logic.commands.ClearCommand;
//import seedu.address.logic.parser.exceptions.ParseException;
//
//
///**
// * Parses input arguments and creates a new ConfirmationCommand object.
// */
//public class ClearCommandParser implements Parser<ClearCommand> {
//    /**
//     * Parses the given {@code String} of user input in the context of the ViewCommand
//     * and returns a ViewCommand object for execution.
//     *
//     * @param userInput the string name of the recipe to be viewed.
//     * @return the ViewCommand object that displays the contents of the appropriate recipe.
//     * @throws ParseException if the user input does not conform the expected format.
//     */
//    @Override
//    public ClearCommand parse(String userInput) throws ParseException {
//        String prefixForForce = "-f";
//        if (userInput.contains(prefixForForce)) {
//            ClearCommand.setIsForced(true);
//            return new ClearCommand();
//        } else {
//            return new ClearCommand();
//        }
//    }
//}
