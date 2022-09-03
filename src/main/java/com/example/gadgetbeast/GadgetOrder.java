package com.example.gadgetbeast;

import java.util.List;
import java.util.ArrayList;
import lombok.Data;

import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import org.hibernate.validator.constraints.CreditCardNumber;

@Data
public class GadgetOrder {

    @NotBlank(message="Delivery name is required")
    private String deliveryName;

    @NotBlank(message="Street is required")
    private String deliveryStreet;

    @NotBlank(message="City is required")
    private String deliveryCity;

    @NotBlank(message="State is required")
    private String deliveryState;

    @NotBlank(message="Zip code is required")
    private String deliveryZip;

    @CreditCardNumber(message="Not a valid credit card number")
    private String ccNumber;

    @Pattern(regexp="^(0[1-9]|1[0-2])([\\/])([2-9][0-9])$",
            message="Must be formatted MM/YY")
    private String ccExpiration;

    @Digits(integer=3, fraction=0, message="Invalid CVV")
    private String ccCVV;

//    private List<Gadget> specifications = new ArrayList<>();
    private List<Gadget> gadgets = new ArrayList<>();

//    public void addSpecification(Gadget gadget) {
//        this.specifications.add(gadget);
//    }
    public void addSpecification(Gadget gadget) {
        this.gadgets.add(gadget);
    }
}
