package com.carbonaracode.digibookycarbonara;

public class NameDTO {
    private final String firstName;
    private final String lastName;

    public NameDTO(String firstName, String lastName) {
        validateNameField(lastName);
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getLastName() {
        return lastName;
    }

    private void validateNameField(String name){
        if (name == null || name.isBlank()){
            throw new IllegalArgumentException("name cannot be empty!");
        }
    }
}
