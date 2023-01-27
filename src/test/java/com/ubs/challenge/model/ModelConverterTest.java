package com.ubs.challenge.model;

import com.dog.challenge.model.Model;
import com.dog.challenge.model.ModelConverter;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author sfe
 */
class ModelConverterTest {

    @Test
    void convertDataToModelListNullOrEmpty() {
        assertThrows(IllegalArgumentException.class, () -> ModelConverter.convertDataToModelList(null));

        assertTrue(ModelConverter.convertDataToModelList("").isEmpty());
        assertTrue(ModelConverter.convertDataToModelList(";").isEmpty());
        assertTrue(ModelConverter.convertDataToModelList(";;").isEmpty());
        assertTrue(ModelConverter.convertDataToModelList(";;;").isEmpty());
    }

    @Test
    void convertDataToModelListFilterDifferentLines() {

        String differentDogLines =
                """
                dog01;dog02\n
                dog03;dog04\n
                dog05;dog06;dog07\n
                dog08;\n
                ;dog09\n
                ;;\n
                """;

        List<Model> models = ModelConverter.convertDataToModelList(differentDogLines);
        assertTrue(!models.isEmpty());

        assertEquals("dog01", models.get(0).field1());
        assertEquals("dog02", models.get(0).field2());

        assertEquals("dog03", models.get(1).field1());
        assertEquals("dog04", models.get(1).field2());
    }
}
