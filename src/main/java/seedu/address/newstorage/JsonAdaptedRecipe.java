package seedu.address.newstorage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.recipe.CompletionTime;
import seedu.address.model.recipe.Ingredient;
import seedu.address.model.recipe.Name;
import seedu.address.model.recipe.Portion;
import seedu.address.model.recipe.Recipe;
import seedu.address.model.recipe.Step;
import seedu.address.model.tag.Tag;

/**
 * Jackson-friendly version of {@link Recipe}.
 */
class JsonAdaptedRecipe {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Recipe's %s field is missing!";

    private final String name;
    private final List<JsonAdaptedIngredient> ingredients = new ArrayList<>();
    private final Integer completionTime;
    private final Double portion;
    private final List<JsonAdaptedStep> steps = new ArrayList<>();
    private final List<JsonAdaptedTag> tags = new ArrayList<>();

    /**
     * Constructs a {@code JsonAdaptedRecipe} with the given recipe details.
     */
    @JsonCreator
    public JsonAdaptedRecipe(@JsonProperty("name") String name,
                             @JsonProperty("ingredients") List<JsonAdaptedIngredient> ingredients,
                             @JsonProperty("completionTime") Integer completionTime,
                             @JsonProperty("portion") Double portion,
                             @JsonProperty("steps") List<JsonAdaptedStep> steps,
                             @JsonProperty("tags") List<JsonAdaptedTag> tags) {
        this.name = name;
        this.portion = portion;
        this.completionTime = completionTime;
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
        completionTime = source.getCompletionTime().value;
        tags.addAll(source.getTags().stream()
                .map(seedu.address.newstorage.JsonAdaptedTag::new)
                .collect(Collectors.toList()));
        steps.addAll(source.getSteps().stream()
                .map(seedu.address.newstorage.JsonAdaptedStep::new)
                .collect(Collectors.toList()));
        ingredients.addAll(source.getIngredients().stream()
                .map(seedu.address.newstorage.JsonAdaptedIngredient::new)
                .collect(Collectors.toList()));
    }

    /**
     * Converts this Jackson-friendly adapted recipe object into the model's {@code Recipe} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted recipe.
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
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Name.class.getSimpleName()));
        }
        if (!Name.isValidName(name)) {
            throw new IllegalValueException(Name.MESSAGE_CONSTRAINTS);
        }
        final Name modelName = new Name(name);

        if (portion == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    Portion.class.getSimpleName()));
        }
        if (!Portion.isValidPortion(portion)) {
            throw new IllegalValueException(Portion.MESSAGE_CONSTRAINTS);
        }
        if (completionTime == null) {
            throw new IllegalValueException(String.format(MISSING_FIELD_MESSAGE_FORMAT,
                    CompletionTime.class.getSimpleName()));
        }
        if (!CompletionTime.isValidCompletionTime(completionTime)) {
            throw new IllegalValueException(CompletionTime.MESSAGE_CONSTRAINTS);
        }
        final CompletionTime modelCompletionTime = new CompletionTime(completionTime);
        final Portion modelPortion = new Portion(portion);
        final List<Step> modelSteps = new ArrayList<>(recipeSteps);
        final List<Ingredient> modelIngredients = new ArrayList<>(recipeIngredients);
        final Set<Tag> modelTags = new HashSet<>(recipeTags);
        return new Recipe(modelName, modelIngredients, modelCompletionTime, modelPortion, modelSteps, modelTags);
    }

}
