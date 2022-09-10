package com.example.gadgetbeast;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import com.example.gadgetbeast.Specification.Type;
import com.example.gadgetbeast.DesignGadgetWithSpecController;

import java.util.Arrays;
import java.util.List;


@WebMvcTest(DesignGadgetWithSpecController.class)
public class DesignGadgetWithSpecControllerTest {
    @Autowired
    private MockMvc mockMvc;


    private List<Specification> ingredients;

    private Gadget design;

    @MockBean
    private ISpecificationRepository ingredientRepository;

    @MockBean
    private OrderRepository orderRepository;

    private List<Specification> specifications;

    @BeforeEach
    public void setup() {
        specifications = Arrays.asList(
                new Specification("1", "ASUS", "16 GB", Type.RAM),
                new Specification("2", "HP", "16 GB", Type.RAM),
                new Specification("3","ASUS", "8 GB", Type.RAM),
                new Specification("4","DELL", "1 TB", Type.HDD),
                new Specification("5","SAMSUNG", "512 GB", Type.HDD),
                new Specification("6","ASUS", "2 TB", Type.HDD),
                new Specification("7","DELL", "256 GB", Type.HDD),
                new Specification("8","HP", "13.6 inch", Type.DISPLAY),
                new Specification("9","HP", "14.6 inch", Type.DISPLAY),
                new Specification("10","DELL", "1.6 inch", Type.DISPLAY),
                new Specification("11","SAMSUNG", "core i7", Type.PROCESSOR),
                new Specification("12","INTEL", "core i5", Type.PROCESSOR),
                new Specification("13","INTEL", "core i3", Type.PROCESSOR)
        );

    }

    @Test
    public void testShowDesignForm() throws Exception {
        mockMvc.perform(get("/design"))
                .andExpect(status().isOk())
                .andExpect(view().name("view/design"))
                .andExpect(model().attribute("ram", specifications.subList(0, 3)))
                .andExpect(model().attribute("hdd", specifications.subList(3, 7)))
                .andExpect(model().attribute("display", specifications.subList(7, 10)))
                .andExpect(model().attribute("processor", specifications.subList(10, 13)));
    }

    @Test
    public void processTaco() throws Exception {
        mockMvc.perform(post("/design")
                        .content("name=Test+Gadget&specifications=1,4,8,11")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED))
                .andExpect(status().is3xxRedirection())
                .andExpect(header().stringValues("Location", "/orders/current"));
    }
}
