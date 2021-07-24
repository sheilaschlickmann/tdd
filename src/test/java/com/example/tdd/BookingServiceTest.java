package com.example.tdd;

import java.time.LocalDate;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.example.tdd.model.BookingModel;
import com.example.tdd.repository.BookingRepository;
import com.example.tdd.service.BookingService;

@ExtendWith(SpringExtension.class)
public class BookingServiceTest {

	@TestConfiguration
	static class BookingServiceTestConfiguration {

		@Bean
		public BookingService bookService() {
			return new BookingService();
		}

	}

	@Autowired
	BookingService bookingService;

	@MockBean
	BookingRepository bookingRepository;

	@Test
	public void bookingTestServiceDaysCalculator() {
		String name = "Sheila";
		int days = bookingService.daysCalculatorWithDatabase(name);

		Assertions.assertEquals(days, 10);

	}

	@BeforeEach
	public void setup() {
		LocalDate checkIn = LocalDate.parse("2020-11-10");
		LocalDate checkOut = LocalDate.parse("2020-11-20");
		BookingModel bookingModel = new BookingModel("1", "Sheila", checkIn, checkOut, 2);

		Mockito.when(bookingRepository.findByReserveName(bookingModel.getReservename()))
				.thenReturn(java.util.Optional.of(bookingModel));

	}

}
