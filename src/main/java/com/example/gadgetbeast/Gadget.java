package com.example.gadgetbeast;

import java.util.List;
import lombok.Data;

import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Data
public class Gadget {
    @NotNull
    @Size(min=5, message = "Error: Gadget Name must be at least 5 characters long.")
    private String name;

    @NotNull
    @Size(min=1, message="Error: You must choose your specs!")
    private List<Specification> specifications;
}
