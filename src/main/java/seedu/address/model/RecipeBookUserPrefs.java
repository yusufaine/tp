package seedu.address.model;

import seedu.address.commons.core.GuiSettings;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * Represents User's preferences.
 */
public class RecipeBookUserPrefs implements ReadOnlyUserPrefs {
    //TODO: rename to "UserPrefs" once we confirm that we don't need AB3 files
    private GuiSettings guiSettings = new GuiSettings();
    private Path recipeBookFilePath = Paths.get("data" , "recipebook.json");

    /**
     * Creates a {@code UserPrefs} with default values.
     */
    public RecipeBookUserPrefs() {}

    /**
     * Creates a {@code UserPrefs} with the prefs in {@code userPrefs}.
     */
    public RecipeBookUserPrefs(ReadOnlyUserPrefs userPrefs) {
        this();
        resetData(userPrefs);
    }

    /**
     * Resets the existing data of this {@code UserPrefs} with {@code newUserPrefs}.
     */
    public void resetData(ReadOnlyUserPrefs newUserPrefs) {
        requireNonNull(newUserPrefs);
        setGuiSettings(newUserPrefs.getGuiSettings());
        setRecipeBookFilePath(newUserPrefs.getRecipeBookFilePath());
    }

    public GuiSettings getGuiSettings() {
        return guiSettings;
    }

    public void setGuiSettings(GuiSettings guiSettings) {
        requireNonNull(guiSettings);
        this.guiSettings = guiSettings;
    }

    public Path getRecipeBookFilePath() {
        return recipeBookFilePath;
    }

    public void setRecipeBookFilePath(Path recipeBookFilePath) {
        requireNonNull(recipeBookFilePath);
        this.recipeBookFilePath = recipeBookFilePath;
    }

    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof RecipeBookUserPrefs
                    && guiSettings.equals(((RecipeBookUserPrefs) other).guiSettings)
                    && recipeBookFilePath.equals(((RecipeBookUserPrefs) other).recipeBookFilePath));
    }

    @Override
    public int hashCode() {
        return Objects.hash(guiSettings, recipeBookFilePath);
    }

    @Override
    public String toString() {
        return String.format("GUI Settings : %s \nLocal data file location : %s", guiSettings, recipeBookFilePath);
    }

}
