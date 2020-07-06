package com.lucassouza.distance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DitanceUnitsConverterTest {

    DitanceUnitsConverter ditanceUnitsConverter;

    @BeforeEach
    void setUp() {
        ditanceUnitsConverter = new DitanceUnitsConverter();
    }

    @Test
    void shouldConvertToRadians() {
        double expected = 0.785398;
        assertEquals(expected, ditanceUnitsConverter.toRadians(45), 0.001);
        assertEquals(-expected, ditanceUnitsConverter.toRadians(-45), 0.001);
    }

    @Test
    void whenReceivesZero_shouldReturnZero() {
        assertEquals(0, ditanceUnitsConverter.toRadians(0), 0.001);
    }
}