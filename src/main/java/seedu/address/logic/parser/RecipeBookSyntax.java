package seedu.address.logic.parser;

/**
 * Contains Command Line Interface (CLI) syntax definitions common to multiple commands.
 */
public class RecipeBookSyntax {

    /* Prefix definitions */
    public static final Prefix PREFIX_NAME = new Prefix("-n");
    public static final Prefix PREFIX_INGREDIENT = new Prefix("-i");
    public static final Prefix PREFIX_STEPS = new Prefix("-s");
    public static final Prefix PREFIX_TAG = new Prefix("--tag");
    public static final Prefix PREFIX_DURATION = new Prefix("--time");
}
