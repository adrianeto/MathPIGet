package com.spring.math.operations.controller;

import com.spring.math.operations.controller.controller.OperationsController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(OperationsController.class)
public class OperationsControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testAddOperation()throws Exception{
        this.mockMvc.perform(get("/math2/calculate?operations=add&x=3&y=6")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(content().string("3 + 6 = 9")
                );
    }
    @Test
    public void testSubOperation()throws Exception{
        this.mockMvc.perform(get("/math2/calculate?operations=substract&x=6&y=3")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(content().string("6 - 3 = 3")
                );
    }
    @Test
    public void testMultiplyOperation()throws Exception{
        this.mockMvc.perform(get("/math2/calculate?operations=multiply&x=3&y=6")
                .accept(MediaType.TEXT_PLAIN))
                .andExpect(content().string("3 * 6 = 18")
                );
    }


    @Test
    public void testDivideOperation()throws Exception{
        this.mockMvc.perform(get("/math2/calculate?operations=divide&x=6&y=3")
                .accept(MediaType.TEXT_PLAIN))
             .andExpect(content().string("6 / 3 = 2"));

    }
    @Test
    public void testPostOperation()throws Exception{
        this.mockMvc.perform(post("/math2/sum")
                .accept(MediaType.TEXT_PLAIN)//.accept(MediaType.APPLICATION_JSON)
                .contentType("application/x-www-form-urlencoded")
                .param("n","4")
                .param("n","5")
                .param("n","10")
                .param("n","20"))
                .andExpect(content().string("4 + 5 + 10 + 20 = 39"));
    }
}
