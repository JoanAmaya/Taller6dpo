package modelo;
import java.util.ArrayList;


public class Combo implements Producto{
	
	private double descuento;
	private String nombreCombo;
	private ArrayList<Producto> itemsCombo;
	public Combo(double descuento, String nombreCombo) {
		this.descuento = descuento;
		this.nombreCombo = nombreCombo;
		this.itemsCombo= new ArrayList<Producto>();
	}
	@Override
	public int getPrecio() {
		
		int pre_base=0;
		
		for (Producto i: itemsCombo)
		{
			int precio_ingrediente=i.getPrecio();
			pre_base+=(precio_ingrediente);
		
		}
		
		
		return (int) (pre_base-pre_base*descuento);
	}
	public int getcalorias() {
		
		int cal_base=0;
		
		for (Producto i: itemsCombo)
		{
			int cal_ingrediente=i.getcalorias();
			cal_base+=(cal_ingrediente);
		
		}
		
		
		return cal_base;
	}

	
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombreCombo;
		
	}
	public void agregarItemACombo(Producto itemCombo)
	{
		itemsCombo.add(itemCombo);
		
	}
	@Override
	public String generarTextoFactura() {
		int pre_base=0;
		for (Producto i: itemsCombo)
		{
			int precio_ingrediente=i.getPrecio();
			pre_base+=(precio_ingrediente);
		}
		int cal_base=0;
		
		for (Producto i: itemsCombo)
		{
			int cal_ingrediente=i.getcalorias();
			cal_base+=(cal_ingrediente);
		
		}
		
		int precio=(int) (pre_base-pre_base*descuento);
		String texto_precio=Integer.toString(precio);
		String factura="El precio de "+texto_precio+" con calorias de "+cal_base;
			
		return factura;
	}
	
	
	
	
	
	
}
