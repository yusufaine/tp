package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Prompt the user for a final confirmation before proceeding to execute a command.
 */
public class ConfirmationCommand extends Command {
    public static final String CONFIRM_COMMAND_WORD = "yes";
    public static final String CANCEL_COMMAND_WORD = "no";
    public static final String ENFORCE_MESSAGE = "You have a pending clear/reset command. "
            + "Confirmation has to be done immediately after calling "
            + "a clear/reset command! \n"
            + "Call the command again if you wish to do another clear/reset.";

    private static final String CANCEL_MESSAGE = "You have successfully cancelled the command";
    /* Determines whether the command is to be executed. */
    private boolean commandConfirmed = false;
    /**
     * Constructs a {@code ConfirmationCommand} based on the given {@code confirmation}.
     *
     * @param confirmationFromUser that will decide whether the command is aborted or executed.
     */
    public ConfirmationCommand(String confirmationFromUser) {
        if (confirmationFromUser.equals(CONFIRM_COMMAND_WORD)) {
            commandConfirmed = true;
        }
    }

    @Override
    public CommandResult execute(Model model) {
        if (commandConfirmed) {
            ClearCommand.setIsConfirmed(true);
            return new ClearCommand().execute(model);
        }
        ClearCommand.setIsCalled(false);
        return new CommandResult(CANCEL_MESSAGE);
    }



}
