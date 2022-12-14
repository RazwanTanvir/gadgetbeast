package com.example.gadgetbeast;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;

@Data
@Entity
public class Gadget {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Date createdAt;

    @NotNull
    @Size(min=5, message = "Error: Gadget Name must be at least 5 characters long.")
    private String name;

//    @NotNull
    @Size(min=1, message="Error: You must choose your specs!")
    @ManyToMany(targetEntity = Specification.class)
    private List<Specification> specifications = new ArrayList<>();

    @PrePersist
    void createdAt() {
        this.createdAt = new Date();
    }

//    public void addSpecification(Specification specification) {
//        this.specifications.add(specification);
//    }
}
