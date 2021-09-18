package com.example.tdd;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.example.tdd.model.BookingModel;
import com.example.tdd.repository.BookingRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {

	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	private ObjectMapper objectMapper;
	

	@MockBean
	BookingRepository bookingRepository;
	
	
	@Test
	public void bookingTestGetAll() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("/bookings"))
        .andExpect(MockMvcResultMatchers.status().isOk());

	}

	@Test
	public void bookingTestSave() throws Exception {
		LocalDate checkIn = LocalDate.parse("2020-11-10");
		LocalDate checkOut = LocalDate.parse("2020-11-20");

		BookingModel bookingModel = new BookingModel("1", "Sheila", checkIn, checkOut, 2);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/bookings")
                .contentType("application/json")
                .content(objectMapper.writeValueAsString(bookingModel)))
                .andExpect(MockMvcResultMatchers.status().isOk());
	}

}
