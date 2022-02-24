package seedu.address.newStorage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.recipe.*;
import seedu.address.model.tag.Tag;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Jackson-friendly version of {@link Recipe}.
 */
class JsonAdaptedRecipe {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Recipe's %s field is missing!";

    private final String name;
    private final List<JsonAdaptedIngredient> ingredients = new ArrayList<>();
    private final double portion;
    private final List<JsonAdaptedStep> steps = new ArrayList<>();
    private final List<JsonAdaptedTag> tags = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedPerson} with the given person details.
     */
    @JsonCreator
    public JsonAdaptedRecipe(@JsonProperty("name") String name, @JsonProperty("ingredients") List<JsonAdaptedIngredient> ingredients,
                             @JsonProperty("portion") double portion, @JsonProperty("steps") List<JsonAdaptedStep> steps,
                             @JsonProperty("tags") List<JsonAdaptedTag> tags) {
        this.name = name;
        this.portion = portion;
        if (ingredients != null) {
            this.ingredients.addAll(ingredients);
        }
        if (steps != null) {
            this.steps.addAll(steps);
        }
        if (tags != null) {
            this.tags.addAll(tags);
        }
    }

    /**
     * Converts a given {@code Recipe} into this class for Jackson use.
     */
    public JsonAdaptedRecipe(Recipe source) {
        name = source.getName().fullName;
        portion = source.getPortion().value;
        tags.addAll(source.getTags().stream()
                .map(seedu.address.newStorage.JsonAdaptedTag::new)
                .collect(Collectors.toList()));
        steps.addAll(source.getSteps().stream()
                .map(seedu.address.newStorage.JsonAdaptedStep::new)
                .collect(Collectors.toList()));
        ingredients.addAll(source.getIngredients().stream()
                .map(seedu.address.newStorage.JsonAdaptedIngredient::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted person object into the model's {@code Person} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted person.
     */
    public Recipe toModelType() throws IllegalValueException {
        final List<Tag> recipeTags = new ArrayList<>();
        for (JsonAdaptedTag tag : tags) {
            recipeTags.add(tag.toModelType());
        }

        final List<Ingredient> recipeIngredients = new ArrayList<>();
        for (JsonAdaptedIngredient ingredient: ingredients) {
            recipeIngredients.add(ingredient.toModelType());
        }

        final List<Step> recipeSteps = new ArrayList<>();
        for (JsonAdaptedStep step: steps) {
            recipeSteps.add(step.toModelType());
        }

        if (name == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (portion == 0) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT, Portion.class.getSimpleName()));
        }
        if (!Portion.isValidPortion(portion)) {
            throw new IllegalValueException(Portion.MESSAGE_CONSTRAINTS);
        }
        final Portion modelPortion = new Portion(portion);
        final List<Step> modelSteps = new ArrayList<>(recipeSteps);
        final List<Ingredient> modelIngredients = new ArrayList<>(recipeIngredients);
        final Set<Tag> modelTags = new HashSet<>(recipeTags);
        return new Recipe(modelName, modelIngredients, modelPortion, modelSteps, modelTags);
    }

}
