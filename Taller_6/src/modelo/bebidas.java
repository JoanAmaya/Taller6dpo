package modelo;

public class bebidas implements Producto{
	private String nombre;
	private int precioBase;
	private int calorias;
	public bebidas(String nombre, int preciobase,int calorias)
	{
		this.nombre=nombre;
		this.precioBase=preciobase;
		this.calorias=calorias;
	}
	
	public String getNombre()
	{
		
		return nombre;
	}
	
	public int getPrecio()
	{
		return precioBase;
		
	}
	public int getcalorias()
	{
		return calorias;
	}
	public String generarTextoFactura()
	{
		String precio_str=Integer.toString(this.precioBase);
		String calorias_str=Integer.toString(this.calorias);
		String textofactura="El precio es "+ precio_str+" con "+calorias_str+" calorias";
		return textofactura;
		
	}


}
