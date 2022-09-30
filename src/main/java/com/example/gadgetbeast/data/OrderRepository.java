package com.example.gadgetbeast.data;

import com.example.gadgetbeast.GadgetOrder;
import com.example.gadgetbeast.User;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository
        extends CrudRepository<GadgetOrder, Long> {

        List<GadgetOrder> findByUserOrderByPlacedAtDesc(
                User user, Pageable pageable
        );

}
