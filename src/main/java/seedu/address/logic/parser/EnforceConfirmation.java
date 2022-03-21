package seedu.address.logic.parser;

import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.ConfirmationCommand;

public class EnforceConfirmation {
    /**
     * Checks whether clearCommand has been called prior to the current command.
     * @return true if clear has been called previously.
     */
    public static boolean clearIsCalled() {
        return ClearCommand.isClearCalled();
    }

    /**
     *  Ensures the next command has to be a confirmationCommand's command word.
     *
     * @param commandWord the user entered.
     * @return true if the command word is valid for confirmation.
     */

    public static boolean isNextCommandAConfirmation(String commandWord) {
        return commandWord.equals(ConfirmationCommand.CONFIRM_COMMAND_WORD)
                || commandWord.equals(ConfirmationCommand.CANCEL_COMMAND_WORD);
    }

    public static void resetConfirmation() {
        ClearCommand.setIsCalled(false);
    }


}
