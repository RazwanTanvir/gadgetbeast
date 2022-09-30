package com.example.gadgetbeast.web;

import com.example.gadgetbeast.Gadget;
import com.example.gadgetbeast.GadgetOrder;
import com.example.gadgetbeast.Specification;
import com.example.gadgetbeast.User;
import com.example.gadgetbeast.data.GadgetRepository;
import com.example.gadgetbeast.data.ISpecificationRepository;
import com.example.gadgetbeast.data.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import com.example.gadgetbeast.Specification.Type;


import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


@Slf4j
@Controller
@RequestMapping("/design")
@SessionAttributes("gadgetOrder")
public class DesignGadgetWithSpecController {

    private final ISpecificationRepository specificationRepository;

    private GadgetRepository gadgetRepo;

    private UserRepository userRepo;

    @Autowired
    public DesignGadgetWithSpecController(
            ISpecificationRepository specificationRepository,
            GadgetRepository gadgetRepo,
            UserRepository userRepo) {
        this.specificationRepository = specificationRepository;
        this.gadgetRepo = gadgetRepo;
        this.userRepo = userRepo;
    }

    @ModelAttribute
    public void addSpecToModel (Model model) {

        List<Specification> specifications = new ArrayList<>();

        List<Specification> finalSpecifications = specifications;
        specificationRepository.findAll().forEach(i-> finalSpecifications.add(i));

        specifications = Arrays.asList(
                new Specification("1", "ASUS", "16 GB", Specification.Type.RAM),
                new Specification("2", "HP", "16 GB", Specification.Type.RAM),
                new Specification("3", "ASUS", "8 GB", Specification.Type.RAM),
                new Specification("4", "DELL", "1 TB", Specification.Type.HDD),
                new Specification("5", "SAMSUNG", "512 GB", Specification.Type.HDD),
                new Specification("6", "ASUS", "2 TB", Specification.Type.HDD),
                new Specification("7", "DELL", "256 GB", Specification.Type.HDD),
                new Specification("8", "HP", "13.6 inch", Specification.Type.DISPLAY),
                new Specification("9", "HP", "14.6 inch", Specification.Type.DISPLAY),
                new Specification("10", "DELL", "1.6 inch", Specification.Type.DISPLAY),
                new Specification("11", "SAMSUNG", "core i7", Specification.Type.PROCESSOR),
                new Specification("12", "INTEL", "core i5", Specification.Type.PROCESSOR),
                new Specification("13", "INTEL", "core i3", Specification.Type.PROCESSOR)
        );

        Type[] types = Specification.Type.values();
        for (Type type: types) {
            model.addAttribute(type.toString().toLowerCase(),
                    filterByType(specifications, type));
        }
    }

    @ModelAttribute(name = "gadgetOrder")
    public GadgetOrder order () {
        return new GadgetOrder();
    }

    @ModelAttribute(name = "gadget")
    public Gadget gadget () {
        return new Gadget();
    }

    @ModelAttribute(name = "user")
    public User user(Principal principal) {
        String username = principal.getName();
        User user = userRepo.findByUsername(username);
        return user;
    }

    @GetMapping
    public String showDesignForm() {
        return "design";
    }

    @PostMapping
    public String processGadget(@Valid Gadget gadget,
                              @ModelAttribute GadgetOrder gadgetOrder, Errors errors) {

        if(errors.hasErrors()) {
            return "design";
        }

        Gadget saved = gadgetRepo.save(gadget);
        gadgetOrder.addGadget(gadget);
        log.info("Processing gadget: {}", gadget);
        return "redirect:/orders/current";
    }

    private Iterable<Specification> filterByType (
            List<Specification> specifications, Type type) {
        return specifications
                .stream()
                .filter(x -> x.getType().equals(type))
                .collect(Collectors.toList());
    }
}
