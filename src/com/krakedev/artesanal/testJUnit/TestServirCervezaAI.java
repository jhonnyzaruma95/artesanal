package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Maquina;

public class TestServirCervezaAI {
	
	 // Tolerancia para comparar valores double
    private static final double DELTA = 0.001;

    @Test
    public void testServirCervezaConCapacidadSuficiente() {

        // Validar que la maquina sirve cerveza cuando tiene suficiente cantidad.
        // Tambien verifica que retorna el valor correcto a pagar.

        Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", "101", 0.05, 5000);

        maquina.recargarCerveza(2000);

        double valor = maquina.servirCerveza(500);

        assertEquals(25.0, valor, DELTA);
        assertEquals(1500.0, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testServirTodaLaCervezaDisponible() {

        // Validar que se puede servir toda la cerveza disponible
        // y que la cantidad actual queda en cero.

        Maquina maquina = new Maquina("Club", "Cerveza especial", "120", 0.04);

        maquina.recargarCerveza(1000);

        double valor = maquina.servirCerveza(1000);

        assertEquals(40.0, valor, DELTA);
        assertEquals(0.0, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testServirCantidadInsuficiente() {

        // Validar que cuando no existe suficiente cerveza,
        // no se sirve nada, no se modifica la cantidad actual
        // y el método retorna cero.

        Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", "101", 0.05, 5000);

        maquina.recargarCerveza(300);

        double cantidadAntes = maquina.getCantidadActual();

        double valor = maquina.servirCerveza(500);

        assertEquals(0.0, valor, DELTA);
        assertEquals(cantidadAntes, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testServirCuandoLaMaquinaEstaVacia() {

        // Validar que una maquina vacia no puede servir cerveza
        // y que su cantidad actual permanece en cero.

        Maquina maquina = new Maquina("Club", "Cerveza especial", "120", 0.04, 5000);

        double valor = maquina.servirCerveza(100);

        assertEquals(0.0, valor, DELTA);
        assertEquals(0.0, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testServirCeroMililitros() {

        // Validar que al solicitar cero mililitros,
        // el valor a pagar es cero y la cantidad actual no cambia.

        Maquina maquina = new Maquina("Pilsener", "Cerveza rubia", "101", 0.05, 5000);

        maquina.recargarCerveza(1000);

        double cantidadAntes = maquina.getCantidadActual();

        double valor = maquina.servirCerveza(0);

        assertEquals(0.0, valor, DELTA);
        assertEquals(cantidadAntes, maquina.getCantidadActual(), DELTA);
    }

    @Test
    public void testServirConSegundoConstructor() {

        // Validar el funcionamiento del metodo utilizando
        // el segundo constructor de la clase Maquina.

        Maquina maquina = new Maquina("Club", "Cerveza artesanal", "120", 0.03);

        maquina.recargarCerveza(1500);

        double valor = maquina.servirCerveza(400);

        assertEquals(12.0, valor, DELTA);
        assertEquals(1100.0, maquina.getCantidadActual(), DELTA);
    }

}


