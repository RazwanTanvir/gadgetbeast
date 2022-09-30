package com.example.gadgetbeast.web;

import com.example.gadgetbeast.Specification;
import com.example.gadgetbeast.data.ISpecificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

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
