package com.mibarrioaldia.backend.controller;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HealthControllerTest {

    @Test
    void healthShouldReturnExpectedValues() {

        HealthController controller = new HealthController();

        var response = controller.health();

        assertEquals("UP", response.get("status"));
        assertEquals("mi-barrio-al-dia", response.get("application"));
    }
}