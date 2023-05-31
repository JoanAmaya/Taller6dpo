package modelo;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.*;

public class ComboTest {
	ProductoAjustado ajustado;
	ArrayList<Ingrediente> ingredientes= new ArrayList<>();
	Combo combo;

	@BeforeEach
	void setUp() {
		double descuento=0.54;
		String nombrecombo="Triple hamburgesa de trufasitalianianas con carne wagyu A5";
		combo= new Combo(descuento,nombrecombo);
		
		ProductoMenu productomenu = new ProductoMenu("WagyuA5conmarmoleoyoroconbatidodemildolaresedicionmrbeast",1500,50);
		combo.agregarItemACombo(productomenu);
		ProductoMenu productomenu2 = new ProductoMenu("WagyuA5conmarmoleoyoroconbatidodemildolaresedicionmrbeast2",1000,50);
		combo.agregarItemACombo(productomenu2);
	}
	@AfterEach
	void Finish() {}
	
	@Test
	void prueba()
	{	
		double valor = 2500-2500*0.54;
		int valorr= (int)valor;
		System.out.println(String.valueOf(combo.getPrecio()));
	System.out.println(String.valueOf(valorr));
		assertEquals(String.valueOf(valorr),String.valueOf(combo.getPrecio()));	}
	@Test
	//Calorias
	void prueba2()
	{assertEquals(100,combo.getcalorias());}
	@Test
	//Factura
	void prueba3()
	{assertEquals("El precio de "+1150+" con calorias de "+100,combo.generarTextoFactura());}

	
}
