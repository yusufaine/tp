package seedu.address.newStorage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.recipe.Step;

/**
 * Jackson-friendly version of {@link Step}.
 */
class JsonAdaptedStep {

    private final String stepName;

    /**
     * Constructs a {@code JsonAdaptedStep} with the given {@code StepName}.
     */
    @JsonCreator
    public JsonAdaptedStep(String stepName) {
        this.stepName = stepName;
    }

    /**
     * Converts a given {@code Step} into this class for Jackson use.
     */
    public JsonAdaptedStep(Step source) {
        stepName = source.value;
    }

    @JsonValue
    public String getStepName() {
        return stepName;
    }

    /**
     * Converts this Jackson-friendly adapted Step object into the model's {@code Step} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted Step.
     */
    public Step toModelType() throws IllegalValueException {
        if (!Step.isValidSteps(stepName)) {
            throw new IllegalValueException(Step.MESSAGE_CONSTRAINTS);
        }
        return new Step(stepName);
    }

}
