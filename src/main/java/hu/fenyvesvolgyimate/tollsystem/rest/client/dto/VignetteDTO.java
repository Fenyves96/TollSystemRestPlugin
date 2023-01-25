package hu.fenyvesvolgyimate.tollsystem.rest.client.dto;

import java.util.Date;

public class VignetteDTO {
    String vehicleCategory;
    Date dateOfPurchase;
    Date validFrom;
    Date validTo;
    boolean isValid;

    public String getVehicleCategory() {
        return vehicleCategory;
    }

    public void setVehicleCategory(String vehicleCategory) {
        this.vehicleCategory = vehicleCategory;
    }

    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    public void setDateOfPurchase(Date dateOfPurchase) {
        this.dateOfPurchase = dateOfPurchase;
    }

    public Date getValidFrom() {
        return validFrom;
    }

    public void setValidFrom(Date validFrom) {
        this.validFrom = validFrom;
    }

    public Date getValidTo() {
        return validTo;
    }

    public void setValidTo(Date validTo) {
        this.validTo = validTo;
    }

    public void setIsValid(boolean isValid) {
        this.isValid = isValid;
    }
}
