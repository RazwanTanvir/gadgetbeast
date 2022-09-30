//package com.example.gadgetbeast;
//
//import static org.hamcrest.Matchers.containsString;
//import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
//
//import com.example.gadgetbeast.data.ISpecificationRepository;
//import com.example.gadgetbeast.data.OrderRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.test.web.servlet.MockMvc;
//
//
//@WebMvcTest(HomeController.class)
//public class HomeControllerTest {
//	@Autowired
//	private MockMvc mockMvc;
//
//	@MockBean
//	private ISpecificationRepository specificationRepository;
//
//	@MockBean
//	private OrderRepository orderRepository;
//
//	@Test
//	public void testHomePage() throws Exception {
//		mockMvc.perform(get("/"))
//			.andExpect(status().isOk())
//			.andExpect(view().name("home"))
//			.andExpect(content().string(containsString("Welcome to |Gadget Beast| ...")));
//	}
//}
