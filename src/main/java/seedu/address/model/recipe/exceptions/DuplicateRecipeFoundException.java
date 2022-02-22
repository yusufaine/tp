package seedu.address.model.recipe.exceptions;

public class DuplicateRecipeFoundException extends RuntimeException {
    public DuplicateRecipeFoundException() {
        super("Operation would result in a duplicate recipe");
    }
}
