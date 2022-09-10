package com.example.gadgetbeast;

import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import lombok.extern.slf4j.Slf4j;

import com.example.gadgetbeast.GadgetOrder;

import javax.validation.Valid;

@Slf4j
@Controller
@RequestMapping("/orders")
@SessionAttributes("gadgetOrder")

public class OrderController {

    private OrderRepository orderRepository;

    public OrderController(OrderRepository orderRepo) {
        this.orderRepository = orderRepo;
    }

    @GetMapping("/current")
    public String orderForm() {
        return "view/orderForm";
    }

    @PostMapping
    public String processOrder(@Valid GadgetOrder gadgetOrder, Errors errors,
                               SessionStatus sessionStatus) {

        if (errors.hasErrors()) {
            return "view/orderForm";
        }

        log.info("Order submitted: {}", gadgetOrder);

        orderRepository.save(gadgetOrder);
        sessionStatus.setComplete();

        return "redirect:/";
    }
}
