package com.example.gadgetbeast.data;

import com.example.gadgetbeast.Gadget;
import org.springframework.data.repository.CrudRepository;

public interface GadgetRepository
        extends CrudRepository<Gadget, Long> {

}
