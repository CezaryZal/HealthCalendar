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
    void shouldBuildCorrectMeal(){
        Meal newMeal = Meal.builder()
                .id(1L)
                .dateTimeOfEat(LocalDateTime.of(2018, 12, 20, 12, 6, 23))
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
    void shouldThrowExceptionWhenSendTooSmallValueOfKcal() {
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(Meal.class, "kcal", 20);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The value entered is too small, min is 50")
                .isEqualTo(constraintViolations.iterator().next().getMessage());

    }

    @Test
    void shouldThrowExceptionWhenSendTooBigValueOfKcal() {
        Set<ConstraintViolation<Meal>> constraintViolations =
                validator.validateValue(Meal.class, "kcal", 1600);

        assertThat(1).isEqualTo(constraintViolations.size());
        assertThat("The value entered is too big, max is 1500")
                .isEqualTo(constraintViolations.iterator().next().getMessage());

    }

}