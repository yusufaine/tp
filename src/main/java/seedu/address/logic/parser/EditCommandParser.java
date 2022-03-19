package seedu.address.logic.parser;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.core.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.RecipeBookSyntax.PREFIX_COMPLETION_TIME;
import static seedu.address.logic.parser.RecipeBookSyntax.PREFIX_INDEX;
import static seedu.address.logic.parser.RecipeBookSyntax.PREFIX_INGREDIENT;
import static seedu.address.logic.parser.RecipeBookSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.RecipeBookSyntax.PREFIX_SERVING_SIZE;
import static seedu.address.logic.parser.RecipeBookSyntax.PREFIX_STEP;
import static seedu.address.logic.parser.RecipeBookSyntax.PREFIX_TAG;

import java.util.List;
import java.util.Set;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.EditCommand;
import seedu.address.logic.commands.EditCommand.EditRecipeDescriptor;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.recipe.CompletionTime;
import seedu.address.model.recipe.Ingredient;
import seedu.address.model.recipe.Name;
import seedu.address.model.recipe.ServingSize;
import seedu.address.model.recipe.Step;
import seedu.address.model.tag.Tag;

/**
 * Parses input arguments and creates a new EditCommand object
 */
public class EditCommandParser implements Parser<EditCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the EditCommand
     * and returns an EditCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public EditCommand parse(String userInput) throws ParseException {
        requireNonNull(userInput);

        ArgumentMultimap argMultimap;
        Prefix prefix = userInput.contains(PREFIX_INDEX.getPrefix())
                ? PREFIX_INDEX
                : PREFIX_NAME;

        if (userInput.contains(PREFIX_INDEX.getPrefix())) {
            argMultimap = ArgumentTokenizer.tokenize(userInput, PREFIX_INDEX, PREFIX_NAME, PREFIX_COMPLETION_TIME,
                    PREFIX_SERVING_SIZE, PREFIX_INGREDIENT, PREFIX_TAG, PREFIX_STEP);
        } else {
            argMultimap = ArgumentTokenizer.tokenize(userInput, PREFIX_NAME, PREFIX_COMPLETION_TIME,
                    PREFIX_SERVING_SIZE, PREFIX_INGREDIENT, PREFIX_TAG, PREFIX_STEP);
        }

        Index index;
        Name name;

        try {
            if (prefix.equals(PREFIX_INDEX)) {
                index = RecipeBookParserUtil.parseIndex(argMultimap.getValue(PREFIX_INDEX).get());
                EditRecipeDescriptor editRecipeDescriptor = parseEditArgumentValues(argMultimap);
                return new EditCommand(index, editRecipeDescriptor);
            } else {
                name = RecipeBookParserUtil.parseName(argMultimap.getPreamble());
                EditRecipeDescriptor editRecipeDescriptor = parseEditArgumentValues(argMultimap);
                return new EditCommand(name, editRecipeDescriptor);
            }
        } catch (ParseException pe) {
            String errorMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, EditCommand.MESSAGE_USAGE);
            throw new ParseException(errorMessage, pe);
        }
    }

    private EditRecipeDescriptor parseEditArgumentValues(ArgumentMultimap argMultimap) throws ParseException {
        EditRecipeDescriptor editRecipeDescriptor = new EditRecipeDescriptor();
        if (argMultimap.getValue(PREFIX_NAME).isPresent()) {
            Name parsedName = RecipeBookParserUtil.parseName(argMultimap.getValue(PREFIX_NAME).get());
            editRecipeDescriptor.setName(parsedName);
        }

        if (argMultimap.getValue(PREFIX_COMPLETION_TIME).isPresent()) {
            CompletionTime parsedCompletionTime =
                    RecipeBookParserUtil.parseCompletionTime(argMultimap.getValue(PREFIX_COMPLETION_TIME).get());
            editRecipeDescriptor.setCompletionTime(parsedCompletionTime);
        }

        if (argMultimap.getValue(PREFIX_SERVING_SIZE).isPresent()) {
            ServingSize parsedServingSize =
                    RecipeBookParserUtil.parseServingSize(argMultimap.getValue(PREFIX_SERVING_SIZE).get());
            editRecipeDescriptor.setServingSize(parsedServingSize);
        }

        if (!argMultimap.getAllValues(PREFIX_INGREDIENT).isEmpty()) {
            List<Ingredient> parsedIngredients =
                    RecipeBookParserUtil.parseIngredients(argMultimap.getAllValues(PREFIX_INGREDIENT));
            editRecipeDescriptor.setIngredients(parsedIngredients);
        }

        if (!argMultimap.getAllValues(PREFIX_STEP).isEmpty()) {
            List<Step> parsedSteps =
                    RecipeBookParserUtil.parseSteps(argMultimap.getAllValues(PREFIX_STEP));
            editRecipeDescriptor.setSteps(parsedSteps);
        }

        if (!argMultimap.getAllValues(PREFIX_TAG).isEmpty()) {
            Set<Tag> parsedTags = RecipeBookParserUtil.parseTags(argMultimap.getAllValues(PREFIX_TAG));
            editRecipeDescriptor.setTags(parsedTags);
        }

        if (!editRecipeDescriptor.isAnyFieldEdited()) {
            throw new ParseException(EditCommand.MESSAGE_NOT_EDITED);
        }

        return editRecipeDescriptor;
    }
}
