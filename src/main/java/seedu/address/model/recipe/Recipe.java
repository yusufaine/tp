package seedu.address.model.recipe;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import seedu.address.model.tag.Tag;

/**
 * Represents a Recipe in the recipe book. <br>
 * Guarantees: details are present and not null, field values are validated and immutable.
 */
public class Recipe {

    // Identity fields
    private final Name name;
    private final List<Ingredient> ingredients = new ArrayList<>();

    // Data fields
    private final double portion;
    private final List<String> directions = new ArrayList<>();
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Constructs a {@code Recipe}. <br>
     *
     * Every field must be present a not null, otherwise it throws a NullPointerException.
     */
    public Recipe(Name name, List<Ingredient> ingredients, double portion, List<String> directions, Set<Tag> tags) {

        //TODO: Parser needs to ensure that ingredients and directions are in a list.
        requireAllNonNull(name, ingredients, portion, directions, tags);
        this.name = name;
        this.ingredients.addAll(ingredients);
        this.portion = portion;
        this.directions.addAll(directions);
        this.tags.addAll(tags);

        // Tags -> Ingredient/ Cuisine (provided by user).
        // TODO: Tags to only be `Tag`, search feature would need to look through Ingredient and Tag

        // this.ingredients.forEach(ingredient -> tags.add(new Tag(ingredient.getIngredientName())));
    }

    public Name getName() {
        return name;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public double getPortion() {
        return portion;
    }

    public List<String> getDirections() {
        return directions;
    }

    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(tags);
    }

    /**
     * Returns true if both recipes have the same name. <br>
     * This defines a weaker notion of equality between two recipes.
     *
     * @param otherRecipe another {@code Recipe} object
     * @return true if both recipes have the same name.
     */
    public boolean isSameRecipe(Recipe otherRecipe) {
        return otherRecipe == this
                || (otherRecipe != null
                && otherRecipe.getName().equals(this.getName()));
    }

    /**
     * Returns true if both recipes have the same field values. <br>
     * This defines a stronger notion of equality between two recipes.
     *
     * @param other another {@code Recipe} object
     * @return true if both recipes have the same field values.
     */
    @Override
    public boolean equals(Object other) {
        return other == this
                || (other instanceof Recipe
                    && this.getName().equals(((Recipe) other).getName())
                    && this.getIngredients().equals(((Recipe) other).getIngredients())
                    && this.getPortion() == ((Recipe) other).getPortion()
                    && this.getDirections().equals(((Recipe) other).getDirections())
                    && this.getTags().equals(((Recipe) other).getTags()));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, ingredients, portion, directions, tags);
    }

    @Override
    public String toString() {
        // use this to display a short version of the recipe in the default/list view
        // TODO: edit if needed
        StringBuilder sb = new StringBuilder();
        sb.append(getName())
                .append(String.format("; Portions: %2f", getPortion()));

        Set<Tag> tags = getTags();
        if (!tags.isEmpty()) {
            sb.append("; Tags: ");
            tags.forEach(sb::append);
        }

        return sb.toString();
    }
}
