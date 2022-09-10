package com.example.gadgetbeast;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.gadgetbeast.Specification.Type;

@Component
public class SpecificationByIdConverter implements Converter<String, Specification> {



    private ISpecificationRepository specificationRepository;

    @Autowired
    public SpecificationByIdConverter(ISpecificationRepository specificationRepository) {
        this.specificationRepository = specificationRepository;
    }

    @Override
    public Specification convert(String id) {

        return specificationRepository.findById(id).orElse(null);
    }
}
