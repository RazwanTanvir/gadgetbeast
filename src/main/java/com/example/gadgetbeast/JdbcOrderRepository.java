//package com.example.gadgetbeast;
//
//import jdk.internal.org.objectweb.asm.Type;
//import org.springframework.jdbc.core.JdbcOperations;
//import org.springframework.jdbc.core.PreparedStatementCreator;
//import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
//import org.springframework.jdbc.support.GeneratedKeyHolder;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.sql.Types;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
//public class JdbcOrderRepository implements OrderRepository{
//
//    private JdbcOperations jdbcOperations;
//
//    public JdbcOrderRepository(JdbcOperations jdbcOperations) {
//        this.jdbcOperations = jdbcOperations;
//    }
//
//    @Override
//    @Transactional
//    public GadgetOrder save(GadgetOrder order) {
//        PreparedStatementCreatorFactory pscf = new PreparedStatementCreatorFactory(
//                "insert into Taco_Order "
//                        + "(delivery_name, delivery_street, delivery_city, "
//                        + "delivery_state, delivery_zip, cc_number, "
//                        + "cc_expiration, cc_cvv, placed_at) "
//                        + "values (?,?,?,?,?,?,?,?,?)",
//                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
//                Types.VARCHAR, Types.VARCHAR, Types.VARCHAR,
//                Types.VARCHAR, Types.VARCHAR, Types.TIMESTAMP
//        );
//        pscf.setReturnGeneratedKeys(true);
//        order.setPlacedAt(new Date());
//
//        PreparedStatementCreator psc =
//                pscf.newPreparedStatementCreator(
//                        Arrays.asList(
//                                order.getDeliveryName(),
//                                order.getDeliveryStreet(),
//                                order.getDeliveryCity(),
//                                order.getDeliveryState(),
//                                order.getDeliveryZip(),
//                                order.getCcNumber(),
//                                order.getCcExpiration(),
//                                order.getCcCVV(),
//                                order.getPlacedAt()));
//        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbcOperations.update(psc, keyHolder);
//        long orderId = keyHolder.getKey().longValue();
//        order.setId(orderId);
//
//        List<Gadget> gadgets = order.getGadgets();
//        int i=0;
//        for (Gadget gadget : gadgets) {
//            saveGadget(orderId, i++, gadget);
//        }
//        return order;
//    }
//
//    private long saveGadget(Long orderId, int orderKey, Gadget gadget) {
//        gadget.setCreatedAt(new Date());
//        PreparedStatementCreatorFactory pscf =
//                new PreparedStatementCreatorFactory(
//                        "insert into Gadget "
//                                + "(name, created_at, gadget_order, gadget_order_key) "
//                                + "values (?, ?, ?, ?)",
//                        Types.VARCHAR, Types.TIMESTAMP, Type.LONG, Type.LONG
//                );
//        pscf.setReturnGeneratedKeys(true);
//        PreparedStatementCreator psc =
//                pscf.newPreparedStatementCreator(
//                        Arrays.asList(
//                                gadget.getName(),
//                                gadget.getCreatedAt(),
//                                orderId,
//                                orderKey));
//        GeneratedKeyHolder keyHolder = new GeneratedKeyHolder();
//        jdbcOperations.update(psc, keyHolder);
//        long gadgetId = keyHolder.getKey().longValue();
//        gadget.setId(gadgetId);
//        saveSpecificationRefs(gadgetId, gadget.getSpecifications());
//        return gadgetId;
//    }
//
//    private void saveSpecificationRefs(
//            long gadgetId, List<SpecificationRef> specificationRefs) {
//        int key = 0;
//
//        for (SpecificationRef specificationRef: specificationRefs) {
//            jdbcOperations.update(
//                    "insert into Ingredient_Ref (ingredient, taco, taco_key) "
//                            + "values (?, ?, ?)",
//                    specificationRef.getSpecification(), gadgetId, key++);
//        }
//    }
//
//
//}
