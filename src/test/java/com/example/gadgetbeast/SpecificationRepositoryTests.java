//package com.example.gadgetbeast;
//
//import com.example.gadgetbeast.data.ISpecificationRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.jdbc.core.JdbcTemplate;
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.Optional;
//
//@SpringBootTest
//public class SpecificationRepositoryTests {
//    @Autowired
//    ISpecificationRepository specificationRepository;
//
//    @Autowired
//    JdbcTemplate jdbc;
//
//    @Test
//    public void findById() {
//        Optional<Specification> ram16 = specificationRepository.findById("1");
//
//        assertThat(ram16.isPresent()).isTrue();
//        assertThat(ram16.get()).isEqualTo(new Specification("1", "ASUS", "16 GB", Specification.Type.RAM));
//    }
//}
