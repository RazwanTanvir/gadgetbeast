package com.example.gadgetbeast;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Document(collection = "specifications")
public class Specification {
    @Id
    private String id;
    private String brand;
    private String size;
    private Type type;

    public enum Type {
        RAM, HDD, DISPLAY, PROCESSOR
    }
}


