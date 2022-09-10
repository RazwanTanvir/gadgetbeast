//package com.example.gadgetbeast;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Repository;
//
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//import java.util.Optional;
//
//@Repository
//public class JdbcSpecificationRepository implements ISpecificationRepository{
//
////    private JdbcTemplate jdbcTemplate;
////
////    @Autowired
////    public JdbcSpecificationRepository(JdbcTemplate jdbcTemplate) {
////        this.jdbcTemplate = jdbcTemplate;
////    }
////
////    @Override
////    public Iterable<Specification> findAll() {
////        return jdbcTemplate.query("select id, brand, size, type " +
////                "from Specification",this::mapRowToSpecification);
////    }
////
////    @Override
////    public Optional<Specification> findById(String id) {
////        List<Specification> results = jdbcTemplate.query(
////                "select id, brand, size, type from Specification where id = ?",
////                this::mapRowToSpecification, id
////        );
////        return results.size() == 0 ?
////                Optional.empty():
////                Optional.of(results.get(0));
////    }
////
////    @Override
////    public Specification save(Specification specification) {
////        jdbcTemplate.update(
////                "insert into Specification (id, brand, size, type)" +
////                        "values (?, ?, ?)",
////                specification.getId(), specification.getBrand(),
////                specification.getSize(), specification.getType().toString());
////            return specification;
////    }
////
////    private Specification mapRowToSpecification(ResultSet row, int rowNum)
////            throws SQLException {
////        return new Specification(
////                row.getString("id"),
////                row.getString("brand"),
////                row.getString("size"),
////                Specification.Type.valueOf(row.getString("type")));
////    }
//}
