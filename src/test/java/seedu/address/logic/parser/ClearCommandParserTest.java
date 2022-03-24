package seedu.address.logic.parser;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.ClearCommand;
import seedu.address.logic.commands.ConfirmedClearCommand;


/**
 * Contains integration tests and unit tests for.
 * {@code ClearCommandParser}.
 */
public class ClearCommandParserTest {

    private final ClearCommandParser parser = new ClearCommandParser();
    private final static String forcedClearCommand = "clear -f";
    private final static String clearCommand = "clear";

    /**
     * Tests the isNotForcedClearCommand.
     * Returns false if it is not a forced clear.
     */
    @Test
    public void parse_isForcedClearCommand_returnsFalse() {
        assertFalse(ClearCommandParser.isNotForcedClear(forcedClearCommand));
    }

    /**
     * Tests the isNotForcedClearCommand.
     * Returns true if it is not a forced clear.
     */
    @Test
    public void parse_isNotForcedClearCommand_returnsTrue() {
        assertTrue(ClearCommandParser.isNotForcedClear(clearCommand));
    }

    @Test
    public void parse_forcedClear_returnsConfirmedClearCommand() {
        ConfirmedClearCommand expected = new ConfirmedClearCommand();
        assertParseSuccess(parser, forcedClearCommand, expected);
    }

    @Test
    public void parse_notForcedClear_returnsClearCommand_success() {
        ClearCommand expected = new ClearCommand();
        assertParseSuccess(parser, clearCommand, expected);
    }


}
