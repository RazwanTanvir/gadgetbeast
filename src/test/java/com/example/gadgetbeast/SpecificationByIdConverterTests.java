package com.example.gadgetbeast;

import com.example.gadgetbeast.data.ISpecificationRepository;
import com.example.gadgetbeast.web.SpecificationByIdConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class SpecificationByIdConverterTests {
    private SpecificationByIdConverter converter;

    @BeforeEach
    public void setup() {
        ISpecificationRepository specificationRepository = mock(ISpecificationRepository.class);
        when(specificationRepository.findById("1"))
                .thenReturn(Optional.of(new Specification("1", "ASUS", "16 GB", Specification.Type.RAM)));
        when(specificationRepository.findById("99"))
                .thenReturn(Optional.empty());
        this.converter = new SpecificationByIdConverter(specificationRepository);
    }

    @Test
    public void shouldReturnValueWhenPresent() {
        assertThat(converter.convert("1"))
                .isEqualTo(new Specification("1", "ASUS", "16 GB", Specification.Type.RAM));
    }

    @Test
    public void shouldReturnNullWhenMissing() {
        assertThat(converter.convert("99")).isNull();
    }
}