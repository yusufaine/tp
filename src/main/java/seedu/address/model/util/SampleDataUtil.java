package seedu.address.model.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import seedu.address.model.ReadOnlyRecipeBook;
import seedu.address.model.RecipeBook;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Phone;
import seedu.address.model.recipe.CompletionTime;
import seedu.address.model.recipe.Ingredient;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.ServingSize;
import seedu.address.model.recipe.Step;
import seedu.address.model.tag.Tag;

/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    private static Recipe[] getSampleRecipes() {
        Ingredient ingredient1 = new Ingredient("Garlic", 3, "Cloves");
        Ingredient ingredient2 = new Ingredient("Spaghetti", 1);
        Ingredient ingredient3 = new Ingredient("Olive oil", 500, "ml");
        Ingredient ingredient4 = new Ingredient("Bacon", 3, "slices");

        List<Ingredient> ingredients =new ArrayList(List.of(new Ingredient[]{ingredient1, ingredient2, ingredient3,
                ingredient4}));

        Step step1 = new Step("Cook the pasta");
        Step step2 = new Step("Saute the garlic");
        Step step3 = new Step("Toss pasta in the sauce");
        Step step4 = new Step("Toss bacon slices in pasta");
        Step step5 = new Step("Taste and season");

        List<Step> steps = new ArrayList<>(List.of(new Step[]{step1, step2, step3, step4, step5}));

        return new Recipe[] {

                new Recipe(new Name("Alex Yeoh"), new CompletionTime(5), new ServingSize(1),
                        ingredients, steps,
                        new Address("Blk 30 Geylang Street 29, #06-40"),
                        getTagSet("friends")),
                new Recipe(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                        new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
                        getTagSet("colleagues", "friends")),
                new Recipe(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                        new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
                        getTagSet("neighbours")),
                new Recipe(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                        new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
                        getTagSet("family")),
                new Recipe(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                        new Address("Blk 47 Tampines Street 20, #17-35"),
                        getTagSet("classmates")),
                new Recipe(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                        new Address("Blk 45 Aljunied Street 85, #11-31"),
                        getTagSet("colleagues"))
        };
    }
    // public static Person[] getSamplePersons() {
    //     return new Person[] {
    //         new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
    //             new Address("Blk 30 Geylang Street 29, #06-40"),
    //             getTagSet("friends")),
    //         new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
    //             new Address("Blk 30 Lorong 3 Serangoon Gardens, #07-18"),
    //             getTagSet("colleagues", "friends")),
    //         new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
    //             new Address("Blk 11 Ang Mo Kio Street 74, #11-04"),
    //             getTagSet("neighbours")),
    //         new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
    //             new Address("Blk 436 Serangoon Gardens Street 26, #16-43"),
    //             getTagSet("family")),
    //         new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
    //             new Address("Blk 47 Tampines Street 20, #17-35"),
    //             getTagSet("classmates")),
    //         new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
    //             new Address("Blk 45 Aljunied Street 85, #11-31"),
    //             getTagSet("colleagues"))
    //     };
    // }

    public static ReadOnlyRecipeBook getSampleRecipeBook() {
        RecipeBook sampleRb = new RecipeBook();
        for (Recipe sampleRecipe : getSampleRecipes()) {
            sampleRb.addRecipe(sampleRecipe);
        }
        return sampleRb;
    }

    /**
     * Returns an ingredient list containing the list of strings given.
     */
    public static List<Ingredient> getIngredientList(String... strings) {
        return Arrays.stream(strings).map(Ingredient::new).collect(Collectors.toList());
    }

    /**
     * Returns a step list containing the list of strings given.
     */
    public static List<Step> getStepList(String... strings) {
        return Arrays.stream(strings).map(Step::new).collect(Collectors.toList());
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(String... strings) {
        return Arrays.stream(strings)
                .map(Tag::new)
                .collect(Collectors.toSet());
    }

}
