package com.example.gadgetbeast;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<GadgetOrder, String> {

//    List<GadgetOrder> findByDeliveryZip(String deliveryZip);

//    List<GadgetOrder> readOrderByDeliverZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);
//
//    List<GadgetOrder> findByDeliveryToAndDeliveryCityAllIgnoreCase (
//            String deliveryTo, String deliveryCity
//    );
//
//    List<GadgetOrder> findByDeliveryCityOrderByDeliveryTo (String city);
//
//    @Query ("Order o where o.deliveryCity = 'Seattle'")
//    List<GadgetOrder> readOrderDeliveryInSeattle();

}
