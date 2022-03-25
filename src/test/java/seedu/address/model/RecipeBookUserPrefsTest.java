package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.nio.file.Path;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.address.commons.core.GuiSettings;

class RecipeBookUserPrefsTest {

    private RecipeBookUserPrefs recipeBookUserPrefs1;
    private RecipeBookUserPrefs recipeBookUserPrefs2;
    private RecipeBookUserPrefs recipeBookUserPrefs1Copy;

    @BeforeEach
    public void init() {
        recipeBookUserPrefs1 = new RecipeBookUserPrefs();
        recipeBookUserPrefs1.setRecipeBookFilePath(Path.of("path/to/recipe/book"));
        recipeBookUserPrefs1.setGuiSettings(new GuiSettings(1, 2, 3, 4));

        recipeBookUserPrefs1Copy = new RecipeBookUserPrefs(recipeBookUserPrefs1);
        recipeBookUserPrefs2 = new RecipeBookUserPrefs();
    }

    @Test
    public void equals() {
        assertNotEquals(recipeBookUserPrefs1, recipeBookUserPrefs1.getGuiSettings());
        assertEquals(recipeBookUserPrefs1, recipeBookUserPrefs1);
        assertEquals(recipeBookUserPrefs1, recipeBookUserPrefs1Copy);
        assertNotEquals(recipeBookUserPrefs1, recipeBookUserPrefs2);
    }

    @Test
    public void hashCode_test() {
        assertEquals(recipeBookUserPrefs1.hashCode(), recipeBookUserPrefs1Copy.hashCode());
        assertNotEquals(recipeBookUserPrefs1.hashCode(), recipeBookUserPrefs2.hashCode());
    }
}