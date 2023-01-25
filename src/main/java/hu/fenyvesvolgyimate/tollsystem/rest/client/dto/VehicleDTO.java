package hu.fenyvesvolgyimate.tollsystem.rest.client.dto;

public class VehicleDTO {
    String registrationNumber;
    int maxTransportablePassengers;
    String make;
    String category;

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getMaxTransportablePassengers() {
        return maxTransportablePassengers;
    }

    public void setMaxTransportablePassengers(int maxTransportablePassengers) {
        this.maxTransportablePassengers = maxTransportablePassengers;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
