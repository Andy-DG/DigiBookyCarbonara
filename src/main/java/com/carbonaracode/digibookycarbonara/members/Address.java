package com.carbonaracode.digibookycarbonara.members;

public class Address {
    private final String streetName;
    private final int streetNumber;
    private final int postalCode;
    private final String city;

    public Address(String streetName, int streetNumber, int postalCode, String city) {
        this.streetName = streetName;
        this.streetNumber = streetNumber;
        this.postalCode = postalCode;
        this.city = city;
    }
}