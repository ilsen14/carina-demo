package com.qaprosoft.carina.demo.enums;

import com.itextpdf.text.pdf.RadioCheckField;

public enum GenderEnum {
    MALE("male"),
    FEMALE("female");

    public static RadioCheckField getGenderEnum;

    private final String gender;

    GenderEnum(String gender) {
        this.gender = gender;
    }

    public String getGender(){
        return gender;
    }
}
