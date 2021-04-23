package com.qaprosoft.carina.demo.enums;

public enum GenderEnum {
    MALE("[1]"),
    FEMALE("[2]");

    private final String gender;

    GenderEnum(String gender) {
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }
}
