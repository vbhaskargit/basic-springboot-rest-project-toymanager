package com.vb.sb.toymanager.test.integrated;

import com.vb.sb.toymanager.controller.ToyManager;
import com.vb.sb.toymanager.main.Application;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Class to test externally exposed REST Services
 */
@SpringBootTest(classes = Application.class)
@AutoConfigureMockMvc
public class TestToyManagerRESTService {

    @Autowired
    private MockMvc mockMvc;

    //Do not mock the Service, use actual Service to render the http request
    //@MockBean
    //private ToyManager toyManager;

    @Test
    public void testHTTPGetAvailableToys() throws Exception {
        this.mockMvc.perform(MockMvcRequestBuilders.get("/toys/available"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().json("[\"Light Saber\",\"Fighter Plane\"]"));

    }
}
