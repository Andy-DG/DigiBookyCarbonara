package com.carbonaracode.digibookycarbonara.members;

public class AddressDto {
    private final String streetName;
    private final int streetNumber;
    private final int postalCode;
    private final String city;

    public AddressDto(String streetName, int streetNumber, int postalCode, String city) {
        stringIsNotEmptyOrNull(city);
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
    }

    public String getCity() {
        return city;
    }

    private void stringIsNotEmptyOrNull(String string){
        if (string == null || string.isBlank()){
            throw new IllegalArgumentException("field cannot be empty!");
        }
    }
}
