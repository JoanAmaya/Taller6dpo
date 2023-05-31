package modelo;

import java.util.ArrayList;

public class bebidasajustadas implements Producto {
	
	private bebidas base;
	private ArrayList<Ingrediente> agregados;
	private ArrayList<Ingrediente> eliminados;
	
	public bebidasajustadas(bebidas base)
	{
		this.base=base;
		this.agregados= new ArrayList<Ingrediente>();
		this.eliminados= new ArrayList<Ingrediente>();
	}
	
	public void anadir(Ingrediente ingrediente)
	{
		eliminados.remove(ingrediente);
		agregados.add(ingrediente);
	}
	
	public void quitar(Ingrediente ingrediente)
	{
		agregados.remove(ingrediente);
		eliminados.add(ingrediente);
	}
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		String pro_base=this.base.getNombre();
		for (Ingrediente i: agregados)
		{
			String nombre_ingrediente=i.getNombre();
			pro_base=pro_base.concat(" con adición de "+nombre_ingrediente);
		}
		for (Ingrediente i: eliminados)
		{
			String nombre_ingrediente_el=i.getNombre();
			pro_base=pro_base.concat(" sin "+nombre_ingrediente_el);
		}
		
		return pro_base;
	}

	@Override
	public int getPrecio() {
		int pre_base=this.base.getPrecio();
		for (Ingrediente i: agregados)
		{
			int precio_ingrediente=i.getCostoAdicional();
			pre_base+=(precio_ingrediente);
		
		}
		return pre_base;
				
	}
	public int getcalorias() {
		int cal_base=this.base.getcalorias();
		for (Ingrediente i: agregados)
		{
			int cal_ingrediente=i.getcalorias();
			cal_base+=(cal_ingrediente);
		
		}
		return cal_base;
				
	}

	@Override
	public String generarTextoFactura() {
		// TODO Auto-generated method stub
		int pre_base=this.base.getPrecio();
		System.out.println(pre_base);
		for (Ingrediente i: agregados)
		{
			int precio_ingrediente=i.getCostoAdicional();
			pre_base+=(precio_ingrediente);
		
		}
		int cal_base=this.base.getcalorias();
		for (Ingrediente i: agregados)
		{
			int cal_ingrediente=i.getcalorias();
			cal_base+=(cal_ingrediente);
		
		}
		String texto_precio=Integer.toString(pre_base);
		String texto_calorias=Integer.toString(cal_base);
		String factura="El precio "+" es :"+texto_precio+" con calorias de "+texto_calorias;
		return factura;
	}
	

}
