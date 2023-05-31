package modelo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.*;
public class ProductoAjustadoTest {
	
	ProductoAjustado ajustado;
	ArrayList<Ingrediente> ingredientes= new ArrayList<>();

	@BeforeEach
	void setUp() {
		Ingrediente ingrediente= new Ingrediente("lechuga",50,50);
		
		ProductoMenu productomenu = new ProductoMenu("WagyuA5conmarmoleoyoroconbatidodemildolaresedicionmrbeast",1500,50);
		
		ajustado=new ProductoAjustado(productomenu);
		ajustado.anadir(ingrediente);
	}
	@AfterEach
	void Finish() {}
	
	@Test
	void prueba()
	{
		assertEquals(1550,ajustado.getPrecio());	}
	@Test
	//Calorias
	void prueba2()
	{assertEquals(100,ajustado.getcalorias());}
	@Test
	//Factura
	void prueba3()
	{assertEquals("El precio "+" es :"+1550+" con calorias de "+100,ajustado.generarTextoFactura());}
	
 

}
