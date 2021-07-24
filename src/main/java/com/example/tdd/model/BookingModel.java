package com.example.tdd.model;

import java.time.LocalDate;

public class BookingModel {
	private String id;
	private String reservename;
	private LocalDate checkIn;
	private LocalDate checkOut;
	private int numberGuests;

	public BookingModel(String id, String reservename, LocalDate checkIn, LocalDate checkOut, int numberGuests) {
		super();
		this.id = id;
		this.reservename = reservename;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numberGuests = numberGuests;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getReservename() {
		return reservename;
	}

	public void setReservename(String reservename) {
		this.reservename = reservename;
	}

	public LocalDate getCheckIn() {
		return checkIn;
	}

	public void setCheckIn(LocalDate checkIn) {
		this.checkIn = checkIn;
	}

	public LocalDate getCheckOut() {
		return checkOut;
	}

	public void setCheckOut(LocalDate checkOut) {
		this.checkOut = checkOut;
	}

	public int getNumberGuests() {
		return numberGuests;
	}

	public void setNumberGuests(int numberGuests) {
		this.numberGuests = numberGuests;
	}

}
