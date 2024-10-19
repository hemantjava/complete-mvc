package com.hemant.complete.mvc.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ServiceTest {

    @Mock
    private ServiceImpl serviceMock;
    @Test
    void getData() {

        // Define behavior for the mock
        when(serviceMock.getData()).thenReturn("Mocked Data");

        // Test the mocked behavior
        String data = serviceMock.getData();
        System.out.println(data); // Output will be "Mock
    }
}