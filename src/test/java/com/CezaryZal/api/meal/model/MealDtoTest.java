package com.CezaryZal.api.meal.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidatorFactory;
import javax.validation.Validator;

import java.time.LocalDateTime;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class MealDtoTest {

    private Validator validator;

    @BeforeEach
    void setUp() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    void shouldCompareTwoSimilarMealsDto() {
        MealDto expectedMeal = MealDto.builder()
                .id(1L)
                .dateTimeOfEat(LocalDateTime.of(2018, 12, 20, 12, 6, 23))
                .type("kolacja")
                .kcal(200)
                .description("serek")
                .dayId(3L)
                .build();

        MealDto newMeal = MealDto.builder()
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
    void shouldBuildCorrectMealDto() {
        MealDto newMeal = MealDto.builder()
                .id(1L)
                .dateTimeOfEat(LocalDateTime.now())
                .type("kolacja")
                .kcal(200)
                .description("serek")
                .dayId(3L)
                .build();

        Set<ConstraintViolation<MealDto>> constraintViolations =
                validator.validate(newMeal);

        assertThat(0).isEqualTo(constraintViolations.size());
    }

    @Test
    void shouldThrowExceptionWhenSendingTooSmallValueOfKcal() {
        Set<ConstraintViolation<MealDto>> constraintViolations =
                validator.validateValue(MealDto.class, "kcal", 20);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The value of kcal entered is too small, min is 50")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingTooBigValueOfKcal() {
        Set<ConstraintViolation<MealDto>> constraintViolations =
                validator.validateValue(MealDto.class, "kcal", 1600);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The value of kcal entered is too big, max is 1500")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNegativeNumberToKcal() {
        Set<ConstraintViolation<MealDto>> constraintViolations =
                validator.validateValue(MealDto.class, "kcal", -8);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The value of kcal entered is too small, min is 50")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNullToKcal() {
        Set<ConstraintViolation<MealDto>> constraintViolations =
                validator.validateValue(MealDto.class, "kcal", null);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'kcal' should not be null")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingTooLongStringToDescription() {
        Set<ConstraintViolation<MealDto>> constraintViolations =
                validator.validateValue(
                        MealDto.class,
                        "description",
                        "a sample description of meal, that will be too long, " +
                                "which should throw an exception with the error message");

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'description' should be between 3 and 100 characters")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingTooShortStringToDescription(){
        Set<ConstraintViolation<MealDto>> constraintViolations =
                validator.validateValue(MealDto.class, "description", "tmp");

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'description' should be between 3 and 100 characters")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNullToDescription(){
        Set<ConstraintViolation<MealDto>> constraintViolations =
                validator.validateValue(MealDto.class, "description", null);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'description' should not be blank")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingBlankStringToDescription(){
        Set<ConstraintViolation<MealDto>> constraintViolations =
                validator.validateValue(MealDto.class, "description", "       ");

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'description' should not be blank")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNegativeValueToDayId(){
        Set<ConstraintViolation<MealDto>> constraintViolations =
                validator.validateValue(MealDto.class, "dayId", -1L);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("must be greater than 0")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNullToDayId(){
        Set<ConstraintViolation<MealDto>> constraintViolations =
                validator.validateValue(MealDto.class, "dayId", null);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'dayId' should not be null")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingZeroNumberToDayId(){
        Set<ConstraintViolation<MealDto>> constraintViolations =
                validator.validateValue(MealDto.class, "dayId", 0L);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("must be greater than 0")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingTooLongStringToType() {
        Set<ConstraintViolation<MealDto>> constraintViolations =
                validator.validateValue(
                        MealDto.class,
                        "type",
                        "a sample type of meal, that will be too long, ");

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'type' should be between 3 and 20 characters")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingTooShortStringToType(){
        Set<ConstraintViolation<MealDto>> constraintViolations =
                validator.validateValue(MealDto.class, "type", "tmp");

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'type' should be between 3 and 20 characters")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNullToType(){
        Set<ConstraintViolation<MealDto>> constraintViolations =
                validator.validateValue(MealDto.class, "type", null);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'type' should not be blank")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingBlankStringToType(){
        Set<ConstraintViolation<MealDto>> constraintViolations =
                validator.validateValue(MealDto.class, "type", "       ");

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'type' should not be blank")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNullToDataTimeOfEat(){
        Set<ConstraintViolation<MealDto>> constraintViolations =
                validator.validateValue(MealDto.class, "dateTimeOfEat", null);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The 'dateTimeOfEat' should not be null")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingDateFromPastToDateTimeOfEat(){
        Set<ConstraintViolation<MealDto>> constraintViolations =
                validator.validateValue(MealDto.class,
                        "dateTimeOfEat",
                        LocalDateTime.now().minusHours(24).minusMinutes(1));

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The date time should be current")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingDateFromFutureToDateTimeOfEat(){
        Set<ConstraintViolation<MealDto>> constraintViolations =
                validator.validateValue(MealDto.class,
                        "dateTimeOfEat",
                        LocalDateTime.now().plusHours(24).plusMinutes(1));

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The date time should be current")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingNegativeValueToId(){
        Set<ConstraintViolation<MealDto>> constraintViolations =
                validator.validateValue(MealDto.class, "id", -1L);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("must be greater than 0")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }

    @Test
    void shouldThrowExceptionWhenSendingZeroNumberToId(){
        Set<ConstraintViolation<MealDto>> constraintViolations =
                validator.validateValue(MealDto.class, "id", 0L);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("must be greater than 0")
                .isEqualTo(constraintViolations.iterator().next().getMessage());
    }
}