package com.CezaryZal.api.meal;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(MealController.class)
public class MealControllerTest {

    private MockMvc mockMvc;
    private SimpleDateFormat dateFormat;

    @Resource
    private WebApplicationContext webApplicationContext;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .build();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm");
    }

    @Test
    public void ShouldReturnOkStatusFromGetDailyDietByDayIdMethod() throws Exception {

        mockMvc.perform(get("/api/meal/dto/day-id/{dayId}", 1L))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void ShouldReturnCreateStatusFromAddMealMethod() throws Exception {

        String mealDtoInJson = "{\"dateTimeOfEat\": \"" + dateFormat.format(new Date()) +"\"," +
                " \"dayId\": 9," +
                " \"description\": \"jaja1\"," +
                " \"kcal\": 80," +
                " \"type\": \"sniadanie1\"}";

        mockMvc.perform(post("/api/meal/current/{userId}", 1L)
                .content(mealDtoInJson)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated());
    }

    @Test
    public void ShouldReturnCreateStatusFromUpdateMealMethod() throws Exception {

        String mealDtoInJson = "{\"dateTimeOfEat\": \"" + dateFormat.format(new Date()) +"\"," +
                " \"dayId\": 9," +
                " \"description\": \"jaja2\"," +
                " \"kcal\": 200," +
                " \"type\": \"sniadanie2\"}";

        mockMvc.perform(put("/api/meal/{id}", 1L)
                .content(mealDtoInJson)
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isAccepted());
    }

    public static String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}