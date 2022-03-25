package seedu.address.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.testutil.TypicalRecipes.AGLIO_OLIO;
import static seedu.address.testutil.TypicalRecipes.BEEF_TACO;
import static seedu.address.testutil.TypicalRecipes.FRIED_RICE;
import static seedu.address.testutil.TypicalRecipes.SHOYU_RAMEN;
import static seedu.address.testutil.TypicalRecipes.getTypicalRecipeBook;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import seedu.address.commons.core.GuiSettings;
import seedu.address.model.recipe.RecipeContainsKeywordPredicate;

class RecipeBookModelManagerTest {

    private RecipeBookModelManager recipeBookModelManager;
    private RecipeBook recipeBook;

    @BeforeEach
    public void init() {
        recipeBookModelManager = new RecipeBookModelManager();
        recipeBook = new RecipeBook();
        recipeBook.addRecipe(AGLIO_OLIO);
        recipeBook.addRecipe(FRIED_RICE);
        recipeBook.addRecipe(BEEF_TACO);

        recipeBookModelManager.setRecipeBook(recipeBook);
    }

    @Test
    public void constructor() {
        assertEquals(new RecipeBookUserPrefs(), recipeBookModelManager.getUserPrefs());
        assertEquals(new GuiSettings(), recipeBookModelManager.getGuiSettings());
        assertEquals(recipeBook, recipeBookModelManager.getRecipeBook());
    }

    @Test
    public void setUserPrefs_nullInput_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> recipeBookModelManager.setUserPrefs(null));
    }

    @Test
    public void setRecipeBookUserPrefs_validInput_success() {
        RecipeBookUserPrefs userPrefs = new RecipeBookUserPrefs();
        userPrefs.setRecipeBookFilePath(Paths.get("recipe/book/file/path"));
        userPrefs.setGuiSettings(new GuiSettings(1, 2, 3, 4));
        recipeBookModelManager.setUserPrefs(userPrefs);

        assertEquals(userPrefs, recipeBookModelManager.getUserPrefs());

        RecipeBookUserPrefs expectedUserPrefs = new RecipeBookUserPrefs(userPrefs);
        expectedUserPrefs.setRecipeBookFilePath(Paths.get("new/recipe/book/file/path"));

        assertNotEquals(expectedUserPrefs, recipeBookModelManager.getUserPrefs());
    }

    @Test
    public void setGuiSettings_nullInput_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> recipeBookModelManager.setGuiSettings(null));
    }

    @Test
    public void setGuiSettings_validInput_success() {
        GuiSettings expectedGuiSettings = new GuiSettings(1, 2, 3, 4);
        recipeBookModelManager.setGuiSettings(expectedGuiSettings);

        assertEquals(expectedGuiSettings, recipeBookModelManager.getGuiSettings());
    }

    @Test
    public void setRecipeBookFilePath_validPath_success() {
        Path expectedPath = Paths.get("recipe/book/file/path");
        recipeBookModelManager.setRecipeBookFilePath(expectedPath);

        assertEquals(expectedPath, recipeBookModelManager.getRecipeBookFilePath());
    }

    @Test
    public void setRecipeBookTest() {
        RecipeBook expectedRecipeBook = new RecipeBook(recipeBook);
        recipeBookModelManager.setRecipeBook(expectedRecipeBook);

        assertEquals(expectedRecipeBook, recipeBookModelManager.getRecipeBook());
    }

    @Test
    public void hasRecipe_nullInput_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> recipeBookModelManager.hasRecipe(null));
    }

    @Test
    public void hasRecipe_validInput_success() {
        assertFalse(recipeBookModelManager.hasRecipe(SHOYU_RAMEN));
        assertTrue(recipeBookModelManager.hasRecipe(AGLIO_OLIO));
    }

    @Test
    public void deleteRecipe_nullInput_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> recipeBookModelManager.deleteRecipe(null));
    }

    @Test
    public void deleteRecipe_validInput_success() {
        recipeBookModelManager.deleteRecipe(AGLIO_OLIO);
        RecipeBook expectedRecipeBook = new RecipeBook();
        expectedRecipeBook.setRecipes(List.of(FRIED_RICE, BEEF_TACO));

        assertEquals(expectedRecipeBook, recipeBookModelManager.getRecipeBook());
    }

    @Test
    public void addRecipe_nullInput_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () -> recipeBookModelManager.addRecipe(null));
    }

    @Test
    public void addRecipe_validInput_success() {
        recipeBookModelManager.addRecipe(SHOYU_RAMEN);
        RecipeBook expectedRecipeBook = new RecipeBook();
        expectedRecipeBook.setRecipes(List.of(AGLIO_OLIO, FRIED_RICE, BEEF_TACO, SHOYU_RAMEN));

        assertEquals(expectedRecipeBook, recipeBookModelManager.getRecipeBook());
    }

    @Test
    public void setRecipe_nullInput_throwsNullPointerException() {
        assertThrows(NullPointerException.class, () ->
                recipeBookModelManager.setRecipe(null, null));
        assertThrows(NullPointerException.class, () ->
                recipeBookModelManager.setRecipe(null, SHOYU_RAMEN));
        assertThrows(NullPointerException.class, () ->
                recipeBookModelManager.setRecipe(SHOYU_RAMEN, null));
    }

    @Test
    public void setRecipe_validInput_success() {
        recipeBookModelManager.setRecipe(AGLIO_OLIO, SHOYU_RAMEN);
        RecipeBook expectedRecipeBook = new RecipeBook();
        expectedRecipeBook.setRecipes(List.of(SHOYU_RAMEN, FRIED_RICE, BEEF_TACO));

        assertEquals(expectedRecipeBook, recipeBookModelManager.getRecipeBook());
    }

    @Test
    public void updateFilteredRecipeList_success() {
        RecipeContainsKeywordPredicate asianCuisinePredicate =
                new RecipeContainsKeywordPredicate(List.of("asian"));

        recipeBookModelManager.updateFilteredRecipeList(asianCuisinePredicate);
        assertEquals(1, recipeBookModelManager.getFilteredRecipeList().size());

        recipeBookModelManager.addRecipe(SHOYU_RAMEN);
        assertEquals(4, recipeBookModelManager.getFilteredRecipeList().size());

        recipeBookModelManager.updateFilteredRecipeList(asianCuisinePredicate);
        assertEquals(2, recipeBookModelManager.getFilteredRecipeList().size());
    }

    @Test
    public void equals() {
        UserPrefs userPrefs = new UserPrefs();
        userPrefs.setRecipeBookFilePath(Paths.get("recipe/book/file/path"));
        userPrefs.setGuiSettings(new GuiSettings(1, 2, 3, 4));
        RecipeBookModelManager modelManager2 = new RecipeBookModelManager(getTypicalRecipeBook(), userPrefs);
        RecipeBookModelManager modelManagerCopy =
                new RecipeBookModelManager(recipeBookModelManager.getRecipeBook(),
                        recipeBookModelManager.getUserPrefs());

        assertNotEquals(recipeBookModelManager, recipeBookModelManager.getUserPrefs());
        assertEquals(recipeBookModelManager, recipeBookModelManager);
        assertEquals(recipeBookModelManager, modelManagerCopy);
        assertNotEquals(recipeBookModelManager, modelManager2);
    }

    @Test
    public void hashCode_test() {
        UserPrefs userPrefs = new UserPrefs();
        userPrefs.setRecipeBookFilePath(Paths.get("recipe/book/file/path"));
        userPrefs.setGuiSettings(new GuiSettings(1, 2, 3, 4));
        RecipeBookModelManager modelManager2 = new RecipeBookModelManager(getTypicalRecipeBook(), userPrefs);
        RecipeBookModelManager modelManagerCopy =
                new RecipeBookModelManager(recipeBookModelManager.getRecipeBook(),
                        recipeBookModelManager.getUserPrefs());

        assertEquals(recipeBookModelManager.hashCode(), modelManagerCopy.hashCode());
        assertNotEquals(recipeBookModelManager.hashCode(), modelManager2.hashCode());
    }
}
