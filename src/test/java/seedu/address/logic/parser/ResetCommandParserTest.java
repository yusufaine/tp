package seedu.address.logic.parser;

import org.junit.jupiter.api.Test;
import seedu.address.logic.commands.ResetCommand;
import seedu.address.logic.commands.ConfirmedResetCommand;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;


/**
 * Contains integration tests and unit tests for.
 * {@code ResetCommandParser}.
 */
public class ResetCommandParserTest {

    private final ResetCommandParser parser = new ResetCommandParser();
    private final String ResetCommand = "Reset";
    private final String confirmedReset = "Reset -f";

    /**
     * Tests the isNotForcedResetCommand.
     * Returns false if it is not a forced Reset.
     */
    @Test
    public void parse_isForcedResetCommand_returnsFalse() {
        assertFalse(ResetCommandParser.isNotForcedReset(confirmedReset));
    }

    /**
     * Tests the isNotForcedResetCommand.
     * Returns true if it is not a forced Reset.
     */
    @Test
    public void parse_isNotForcedResetCommand_returnsTrue() {
        assertTrue(ResetCommandParser.isNotForcedReset(ResetCommand));
    }

    @Test
    public void parse_forcedReset_returnsConfirmedResetCommand() {
        ConfirmedResetCommand expected = new ConfirmedResetCommand();
        assertParseSuccess(parser, confirmedReset, expected);
    }

    @Test
    public void parse_notForcedReset_returnsResetCommand() {
        ResetCommand expected = new ResetCommand();
        assertParseSuccess(parser, ResetCommand, expected);
    }


}
