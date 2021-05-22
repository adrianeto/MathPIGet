package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MathPi.class)
public class MathPiTests {
    @Autowired
    private MockMvc mvc;

    @Test
    void renderPI() throws Exception {
        this.mvc.perform(get("/math/pi").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("3.141592653589793"));
    }

    @Test
    void renderWrongPI() throws Exception {
        this.mvc.perform(get("/Math/Pi").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isNotFound());
    }

    @Test
    void calculateAddOperation() throws Exception {
        this.mvc.perform(get("/math/calculate?operation=add&x=3&y=6")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(content().string("18"));
    }
}
