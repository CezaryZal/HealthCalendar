package com.CezaryZal.api.meal.model.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.time.LocalDateTime;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class MealTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void shouldCompareTwoSimilarMeals() {
        Meal expectedMeal = Meal.builder()
                .id(1L)
                .dateTimeOfEat(LocalDateTime.of(2018, 12, 20, 12, 6, 23))
                .type("kolacja")
                .kcal(200)
                .description("serek")
                .dayId(3L)
                .build();

        Meal newMeal = Meal.builder()
                .id(1L)
                .dateTimeOfEat(LocalDateTime.of(2018, 12, 20, 12, 6, 23))
                .type("kolacja")
                .kcal(200)
                .description("serek")
                .dayId(3L)
                .build();

        assertThat(expectedMeal).isEqualTo(newMeal);
    }

    @Test
    void shouldBuildCorrectMeal() {
        Meal newMeal = Meal.builder()
                .id(1L)
                .dateTimeOfEat(LocalDateTime.now())
                .type("kolacja")
                .kcal(200)
                .description("serek")
                .dayId(3L)
                .build();

        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validate(newMeal);

        assertThat(0).isEqualTo(constraintViolations.size());
    }

    @Test
    void shouldThrowExceptionWhenSendingTooSmallValueOfKcal() {
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(Meal.class, "kcal", 20);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The value entered is too small, min is 50")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingTooBigValueOfKcal() {
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(Meal.class, "kcal", 1600);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The value entered is too big, max is 1500")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNegativeNumberToKcal() {
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(Meal.class, "kcal", -8);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The value entered is too small, min is 50")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNullToKcal() {
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(Meal.class, "kcal", null);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("must not be null")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingTooLongStringToDescription() {
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(
                        Meal.class,
                        "description",
                        "a sample description of meal, that will be too long, " +
                                "which should throw an exception with the error message");

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'description' should be between 3 and 100 characters")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingTooShortStringToDescription(){
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(Meal.class, "description", "tmp");

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'description' should be between 3 and 100 characters")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNullToDescription(){
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(Meal.class, "description", null);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'description' should not be blank")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingBlankStringToDescription(){
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(Meal.class, "description", "       ");

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'description' should not be blank")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNegativeValueToDayId(){
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(Meal.class, "dayId", -1L);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("must be greater than 0")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNullToDayId(){
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(Meal.class, "dayId", null);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("must not be null")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingZeroNumberToDayId(){
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(Meal.class, "dayId", 0L);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("must be greater than 0")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingTooLongStringToType() {
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(
                        Meal.class,
                        "type",
                        "a sample type of meal, that will be too long, ");

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'type' should be between 3 and 20 characters")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingTooShortStringToType(){
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(Meal.class, "type", "tmp");

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'type' should be between 3 and 20 characters")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNullToType(){
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(Meal.class, "type", null);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'type' should not be blank")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingBlankStringToType(){
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(Meal.class, "type", "       ");

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'type' should not be blank")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNullToDataTimeOfEat(){
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(Meal.class, "dateTimeOfEat", null);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("must not be null")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingDateFromPastToDateTimeOfEat(){
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(Meal.class,
                        "dateTimeOfEat",
                        LocalDateTime.now().minusHours(24).minusMinutes(1));

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The date time should be current")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingDateFromFutureToDateTimeOfEat(){
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(Meal.class,
                        "dateTimeOfEat",
                        LocalDateTime.now().plusHours(24).plusMinutes(1));

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The date time should be current")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNegativeValueToId(){
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(Meal.class, "id", -1L);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("must be greater than 0")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNullToId(){
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(Meal.class, "id", null);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("must not be null")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingZeroNumberToId(){
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(Meal.class, "id", 0L);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("must be greater than 0")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

}