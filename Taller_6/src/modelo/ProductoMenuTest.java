package modelo;
import static org.junit.Assert.assertEquals;



import org.junit.jupiter.api.*;


public class ProductoMenuTest {

	
ProductoMenu productomuno;

	@BeforeEach
	void setUp() {productomuno = new ProductoMenu("arverjas",1500,50);}
	@AfterEach
	void Finish() {}
	
	@Test
	void prueba()
	{
		assertEquals("El precio es "+ 1500+" con "+50+" calorias",productomuno.generarTextoFactura());
	}
 
 
}
