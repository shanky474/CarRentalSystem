package model;

public class Customer {

	int userId;
	String customerName;
	String dob;
	String customerGender;
	String startingPoint;
	String destination;
	String carSelected;
	String dateOfJourney;
	String journeyEndingDate;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getCustomerGender() {
		return customerGender;
	}

	public void setCustomerGender(String customerGender) {
		this.customerGender = customerGender;
	}

	public String getStartingPoint() {
		return startingPoint;
	}

	public void setStartingPoint(String startingPoint) {
		this.startingPoint = startingPoint;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getCarSelected() {
		return carSelected;
	}

	public void setCarSelected(String carSelected) {
		this.carSelected = carSelected;
	}

	public String getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(String dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public String getJourneyEndingDate() {
		return journeyEndingDate;
	}

	public void setJourneyEndingDate(String journeyEndingDate) {
		this.journeyEndingDate = journeyEndingDate;
	}

}
