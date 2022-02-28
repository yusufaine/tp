package seedu.address.model.recipe;

// import static java.util.Objects.requireNonNull;
// import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * TODO JavaDocs
 */
public class UniqueRecipeList implements Iterable<Recipe> {

    private final ObservableList<Recipe> internalList = FXCollections.observableArrayList();
    private final ObservableList<Recipe> internalUnmodifiableList =
            FXCollections.unmodifiableObservableList(internalList);

    // TODO: Implement these features
    public void add(Recipe toAdd) {}

    public void remove(Recipe toRemove) {}

    public void contains(Recipe toCheck) {}

    // edit feature
    public void setRecipe(Recipe target, Recipe editedRecipe) {}

    public void setRecipes(List<Recipe> recipes) {}

    public void setRecipes(UniqueRecipeList replacement) {}

    public ObservableList<Recipe> asUnmodifiableObservableList() {
        return internalUnmodifiableList;
    }

    @Override
    public Iterator<Recipe> iterator() {
        return internalList.iterator();
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof UniqueRecipeList)) {
            return false;
        }

        if (o == this) {
            return true;
        }
        UniqueRecipeList other = (UniqueRecipeList) o;
        return this.internalList.equals(other.internalList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(internalList);
    }

    /**
     * Returns true if {@code recipes} only contain unique entries. <br>
     * Uniqueness here uses the weak notation of equality (same name).
     *
     * @param recipes list of {@code Recipe} that needs to be checked for unique entries.
     * @return true if {@code recipes} does not contain any duplicates.
     */
    private boolean recipesAreUnique(List<Recipe> recipes) {
        Set<String> duplicateCheck = new HashSet<>();
        recipes.forEach(recipe -> duplicateCheck.add(recipe.getName().fullName));

        // if size are equal, recipe list has unique entries (weak notation)
        return recipes.size() == duplicateCheck.size();
    }
}
