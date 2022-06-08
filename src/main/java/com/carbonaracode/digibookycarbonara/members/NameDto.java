package com.carbonaracode.digibookycarbonara.members;

public class NameDto {
    private final String firstName;
    private final String lastName;

    public NameDto(String firstName, String lastName) {
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
