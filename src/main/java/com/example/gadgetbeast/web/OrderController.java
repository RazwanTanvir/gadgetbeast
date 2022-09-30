package com.example.gadgetbeast.web;

import com.example.gadgetbeast.GadgetOrder;
import com.example.gadgetbeast.User;
import com.example.gadgetbeast.data.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import lombok.extern.slf4j.Slf4j;

import javax.validation.Valid;
import java.util.Arrays;


@Controller
@RequestMapping("/orders")
@SessionAttributes("gadgetOrder")
@Slf4j
public class OrderController {

    @Autowired
    Environment env;

    private OrderRepository orderRepository;

    private OrderProps props;

    public OrderController(OrderRepository orderRepository,
                           OrderProps props) {
        this.orderRepository = orderRepository;
        this.props = props;
    }


    @GetMapping("/current")
    public String orderForm(@AuthenticationPrincipal User user,
                            @ModelAttribute GadgetOrder order) {
        if (order.getDeliveryName() == null) {
            order.setDeliveryName(user.getFullname());
        }
        if (order.getDeliveryStreet() == null) {
            order.setDeliveryStreet(user.getStreet());
        }
        if (order.getDeliveryCity() == null) {
            order.setDeliveryCity(user.getCity());
        }
        if (order.getDeliveryState() == null) {
            order.setDeliveryState(user.getState());
        }
        if (order.getDeliveryZip() == null) {
            order.setDeliveryZip(user.getZip());
        }
        return "orderForm";
    }

    @PostMapping
    public String processOrder(@Valid GadgetOrder gadgetOrder, Errors errors,
                               SessionStatus sessionStatus,
                               @AuthenticationPrincipal User user) {

        if (errors.hasErrors()) {
            return "orderForm";
        }

        gadgetOrder.setUser(user);
//        log.info("Order submitted: {}", gadgetOrder);

        if (Arrays.asList(env.getActiveProfiles()).contains("prod")) {
            orderRepository.save(gadgetOrder);
        } else {
            //System.out.println(gadgetOrder.toString());
            log.info("Order placed: " + gadgetOrder.toString());
        }

        sessionStatus.setComplete();

        return "redirect:/";
    }

    @GetMapping
    public String ordersForUser(
            @AuthenticationPrincipal User user, Model model) {

        Pageable pageable = PageRequest.of(0, props.getPageSize());
        model.addAttribute("orders",
                orderRepository.findByUserOrderByPlacedAtDesc(user, pageable));

//        System.out.println("Page Size: " + props.getPageSize());
        log.info("Page Size: " + props.getPageSize());

        return "orderList";
    }

//    void run () {
//        if (Arrays.asList(env.getActiveProfiles()).contains("dev")) {
//            log();
//        }
//    }


}
