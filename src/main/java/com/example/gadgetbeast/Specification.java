package com.example.gadgetbeast;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Specification {
    @Id
    private final String id;
    private final String brand;
    private final String size;
    private final Type type;

    public enum Type {
        RAM, HDD, DISPLAY, PROCESSOR
    }
}
