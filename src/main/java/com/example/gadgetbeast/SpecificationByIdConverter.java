package com.example.gadgetbeast;

import java.util.HashMap;
import java.util.Map;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.example.gadgetbeast.Specification.Type;

@Component
public class SpecificationByIdConverter implements Converter<String, Specification> {
    private Map<String, Specification> specificationMap = new HashMap<>();

    public SpecificationByIdConverter () {

        specificationMap.put("1", new Specification("1", "ASUS", "16 GB", Type.RAM));
        specificationMap.put("2", new Specification("2", "HP", "16 GB", Type.RAM));
        specificationMap.put("3", new Specification("3","ASUS", "8 GB", Type.RAM));
        specificationMap.put("4", new Specification("4","DELL", "1 TB", Type.HDD));
        specificationMap.put("5", new Specification("5","SAMSUNG", "512 GB", Type.HDD));
        specificationMap.put("6", new Specification("6","ASUS", "2 TB", Type.HDD));
        specificationMap.put("7", new Specification("7","DELL", "256 GB", Type.HDD));
        specificationMap.put("8", new Specification("8","HP", "13.6 inch", Type.DISPLAY));
        specificationMap.put("9", new Specification("9","HP", "14.6 inch", Type.DISPLAY));
        specificationMap.put("10", new Specification("10","DELL", "1.6 inch", Type.DISPLAY));
        specificationMap.put("11", new Specification("11","SAMSUNG", "core i7", Type.PROCESSOR));
        specificationMap.put("12", new Specification("12","INTEL", "core i5", Type.PROCESSOR));
        specificationMap.put("13", new Specification("13","INTEL", "core i3", Type.PROCESSOR));

    }

    @Override
    public Specification convert(String id) {
        return specificationMap.get(id);
    }
}
