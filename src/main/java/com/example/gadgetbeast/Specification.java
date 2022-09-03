package com.example.gadgetbeast;

import lombok.Data;

@Data
public class Specification {
    private final String id;
    private final String brand;
    private final String size;
    private final Type type;

    public enum Type {
        RAM, HDD, DISPLAY, PROCESSOR
    }
}
