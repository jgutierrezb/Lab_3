package test.logic;

import static org.junit.Assert.*;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo 
{

	private Modelo modelo;
	private static int CAPACIDAD=100;

	@Before
	public void setUp1() 
	{
		modelo= new Modelo(CAPACIDAD);
	}

	public void setUp2() 
	{
		for(int i =0; i< CAPACIDAD;i++)
		{
			modelo.agregar("prueba"+i);
		}
	}

	@Test
	public void testModelo() 
	{
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darTamano());  // Modelo con 0 elementos presentes.
	}

	@Test
	public void testDarTamano() 
	{
		setUp1();
		setUp2();
		assertTrue(modelo!=null);
		assertEquals(100 , modelo.darTamano());
	}

	@Test
	public void testAgregar() 
	{
		setUp1();
		setUp2();
		assertTrue(modelo!=null);
		assertEquals("prueba"+2 , modelo.buscar("prueba"+2));
	}

	@Test
	public void testBuscar()
	{
		setUp2();
		setUp1();
		assertTrue(modelo!=null);
		modelo.agregar("clase");
		assertEquals( "clase" , modelo.buscar("clase"));
	}

	@Test
	public void testEliminar() 
	{
		setUp1();
		setUp2();
		assertTrue(modelo!=null);
		modelo.eliminar("prueba50");
		assertEquals( "prueba99" , modelo.buscar("prueba99"));
		assertEquals( null , modelo.buscar("prueba50"));
	}
}
