package com.lucassouza.distance;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DistanceCalculatorTest {

    private DistanceCalculator distanceCalculator;

    @BeforeEach
    void setUp() {
        distanceCalculator = new DistanceCalculator();
    }

    @Test
    void shouldReturnAValidDistanceForAKnowLocation() {
        assertEquals(distanceCalculator.toDublin(52.986375, -6.043701), 41.77, 0.01);
    }

    @Test
    void shoudReturnZeroForDublin() {
        assertEquals(distanceCalculator.toDublin(DublinCoordinates.latitude, DublinCoordinates.longitude), 0, 0.01);
    }

    @Test
    void shouldCompareLessThan100Km() {
        assertTrue(DistanceCalculator.lessThan100Km(10));
        assertFalse(DistanceCalculator.lessThan100Km(101));
    }
}