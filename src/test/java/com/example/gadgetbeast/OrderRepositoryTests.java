package com.example.gadgetbeast;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class OrderRepositoryTests {

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void saveOrderWithTwoGadgets() {

            GadgetOrder order = new GadgetOrder();
            order.setDeliveryName("Test McTest");
            order.setDeliveryStreet("1234 Test Lane");
            order.setDeliveryCity("Testville");
            order.setDeliveryState("CO");
            order.setDeliveryZip("80123");
            order.setCcNumber("4111111111111111");
            order.setCcExpiration("10/23");
            order.setCcCVV("123");

            Gadget gadget1 = new Gadget();

            gadget1.setName("Gadget 1");
            gadget1.addSpecification(
                new Specification("1", "ASUS", "16 GB", Specification.Type.RAM));

            order.addGadget(gadget1);

            Gadget gadget2 = new Gadget();

            gadget2.setName("Gadget 2");
            gadget2.addSpecification(new Specification("2", "HP", "16 GB", Specification.Type.RAM));

            order.addGadget(gadget2);

            GadgetOrder saveOrder = orderRepository.save(order);

            assertThat(saveOrder.getId()).isNotNull();

            GadgetOrder fetchedOrder = orderRepository.findById(saveOrder.getId()).get();
            assertThat(fetchedOrder.getDeliveryName()).isEqualTo("Test McTest");
            assertThat(fetchedOrder.getDeliveryStreet()).isEqualTo("1234 Test Lane");
            assertThat(fetchedOrder.getDeliveryCity()).isEqualTo("Testville");
            assertThat(fetchedOrder.getDeliveryState()).isEqualTo("CO");
            assertThat(fetchedOrder.getDeliveryZip()).isEqualTo("80123");
            assertThat(fetchedOrder.getCcNumber()).isEqualTo("4111111111111111");
            assertThat(fetchedOrder.getCcExpiration()).isEqualTo("10/23");
            assertThat(fetchedOrder.getCcCVV()).isEqualTo("123");
            assertThat(fetchedOrder.getPlacedAt().getTime()).isEqualTo(saveOrder.getPlacedAt().getTime());
            List<Gadget> tacos = fetchedOrder.getGadgets();
            assertThat(tacos.size()).isEqualTo(2);
            assertThat(tacos).containsExactlyInAnyOrder(gadget1, gadget2);

    }
}
