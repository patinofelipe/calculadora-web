package br.com.calculadora.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class CalculadoraServiceTest {

    @Test
    void deveSomarDoisNumeros() {

        CalculadoraService service = new CalculadoraService();

        double resultado = service.somar(10, 20);

        assertEquals(30, resultado);
    }

    @Test
    void deveSubtrairDoisNumeros() {

        CalculadoraService service = new CalculadoraService();

        double resultado = service.subtrair(20, 10);

        assertEquals(10, resultado);
    }

    @Test
    void deveMultiplicarDoisNumeros() {

        CalculadoraService service = new CalculadoraService();

        double resultado = service.multiplicar(10, 5);

        assertEquals(50, resultado);
    }

    @Test
    void deveDividirDoisNumeros() {

        CalculadoraService service = new CalculadoraService();

        double resultado = service.dividir(20, 5);

        assertEquals(4, resultado);
    }

    @Test
    void naoDeveDividirPorZero() {

        CalculadoraService service = new CalculadoraService();

        assertThrows(
            IllegalArgumentException.class,
            () -> service.dividir(10, 0)
        );
    }
}
