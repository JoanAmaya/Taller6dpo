package modelo;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PedidoTest {
	
	ProductoAjustado producto;
	Pedido pedido;
	String nombre="miguel";
	String direccion="carrera8";
	ArrayList<Producto> itemspedido= new ArrayList<>();

	@BeforeEach
	void setUp() {
		pedido = new Pedido(nombre,direccion);
		
		
		ProductoMenu productomenu = new ProductoMenu("WagyuA5conmarmoleoyoroconbatidodemildolaresedicionmrbeast",1500,50);
		ProductoMenu productomenu2 = new ProductoMenu("Coca Cola",100,500);
		pedido.agregarProducto(productomenu);
		pedido.agregarProducto(productomenu2);
	
		
	}
	@AfterEach
	void Finish() {}
	
	@Test
	//Precio neto
	void prueba()
	{
			pedido.guardarFactura(direccion);}
	
	
}
