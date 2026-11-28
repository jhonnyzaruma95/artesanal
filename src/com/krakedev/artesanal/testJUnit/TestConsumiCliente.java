package com.krakedev.artesanal.testJUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.krakedev.artesanal.Cliente;
import com.krakedev.artesanal.Maquina;
import com.krakedev.artesanal.Negocio;

public class TestConsumiCliente {
	
	@Test
	public void probarConsumo() {
		
		Maquina maquinaA = new Maquina("Pilsener", "Rubia", "101", 0.002, 8000);
		Negocio barDeMoe = new Negocio("Bar de Moe", maquinaA);
		
		Cliente cliente = new Cliente("Andres", "0106678299");
		
		barDeMoe.cargarMaquinaA();
		barDeMoe.consumirCervezaMaquinaA(cliente, 100);
		
		assertEquals(7800, maquinaA.getCantidadActual(), 0.0001);
		assertEquals(0.2, cliente.getTotalConsumido(), 0.0001);
		
		barDeMoe.consumirCervezaMaquinaA(cliente, 200);
		
		assertEquals(7600, maquinaA.getCantidadActual(), 0.001);
		assertEquals(0.6, cliente.getTotalConsumido(), 0.0001);
	}

}
