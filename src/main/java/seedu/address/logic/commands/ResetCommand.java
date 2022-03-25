package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.model.Model;

/**
 * Resets the recipe book.
 */
public class ResetCommand extends Command {
    public static final String COMMAND_WORD = "reset";
    public static final String MESSAGE_CONFIRMATION_REQUIRED = "Are you sure you want to clear and reset the "
            + "recipe book to the default preloaded recipes? Enter 'yes' if you wish to clear and 'no' if you "
            + "do not wish to clear";
    public static final String MESSAGE_USAGE = COMMAND_WORD
            + " -f executes a forced reset with no need for confirmation.\n"
            + COMMAND_WORD
            + " without any parameter will require a confirmation \n"
            + "Example: " + COMMAND_WORD + " -f\n"
            + "Example: " + COMMAND_WORD;


    @Override
    public boolean equals(Object o) {
        // instanceof handles nulls
        if (!(o instanceof ResetCommand)) {
            return false;
        }

        // short circuit if same object
        if (this == o) {
            return true;
        }

        ResetCommand other = (ResetCommand) o;
        return this.toString().equals(other.toString()); // state check
    }

    @Override
    public String toString() {
        return COMMAND_WORD;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        return new CommandResult(MESSAGE_CONFIRMATION_REQUIRED);
    }
}
