package com.example.gadgetbeast;

import lombok.*;

import javax.persistence.Id;
//import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;

@Data
@RequiredArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Entity
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


