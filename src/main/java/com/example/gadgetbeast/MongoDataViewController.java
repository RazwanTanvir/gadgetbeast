package com.example.gadgetbeast;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.io.Serializable;
import java.util.List;

@Controller
public class MongoDataViewController implements Serializable {

    ISpecificationRepository specificationRepository;

    @Autowired
    public MongoDataViewController(ISpecificationRepository specificationRepository) {
        this.specificationRepository = specificationRepository;
    }

    @RequestMapping(value = "/show", method = RequestMethod.GET)
    public ResponseEntity<Specification> getData() {
        return new ResponseEntity(specificationRepository.findAll(), HttpStatus.OK);
        //List<Specification> specifications = (List<Specification>) specificationRepository.findAll();
        //return specifications;

    }

}
