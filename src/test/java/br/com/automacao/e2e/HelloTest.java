package br.com.automacao.e2e;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelloTest {

    @Test
    void deveValidarHelloWorld(){
        String hello = "Hello, World!";

        assertEquals("Hello, World!", hello);
    }
}
