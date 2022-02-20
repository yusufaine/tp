package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.UniqueRecipeList;

import java.util.List;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

public class RecipeBook implements ReadOnlyRecipeBook {

    private final UniqueRecipeList recipes;

    public RecipeBook() {
        recipes = new UniqueRecipeList();
    }

    public RecipeBook(ReadOnlyRecipeBook toBeCopied) {
        this();
        resetData(toBeCopied);
    }

    public void setRecipes(List<Recipe> recipes) {
        //TODO
        this.recipes.setRecipes(recipes);
    }

    public void resetData(ReadOnlyRecipeBook newData) {
        requireNonNull(newData);
        setRecipes(newData.getRecipeList());
    }

    public boolean hasRecipe(Recipe recipe) {
        //TODO
        return false;
    }

    public void addRecipe(Recipe toAdd) {}

    public void setRecipe(Recipe target, Recipe editedRecipe) {}

    public void removeRecipe(Recipe toRemove) {}

    @Override
    public String toString() {
        return String.format("%d recipe(s)", recipes.asUnmodifiableObservableList().size());
    }

    @Override
    public ObservableList<Recipe> getRecipeList() {
        return recipes.asUnmodifiableObservableList();
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof RecipeBook
                    && recipes.equals(((RecipeBook) other).recipes));
    }

    @Override
    public int hashCode() {
        return Objects.hash(recipes);
    }
}
