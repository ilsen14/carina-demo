package com.qaprosoft.carina.demo.enums;

import com.itextpdf.text.pdf.RadioCheckField;

public enum GenderEnum {
    MALE("male"),
    FEMALE("female");

    public static RadioCheckField getGenderEnum;

    GenderEnum(String gender) {
    }

}
