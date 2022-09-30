package com.example.gadgetbeast.data;

import com.example.gadgetbeast.Specification;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ISpecificationRepository
        extends CrudRepository<Specification, String> {

}
