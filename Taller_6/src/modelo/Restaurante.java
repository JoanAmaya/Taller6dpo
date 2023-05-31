package modelo;
import java.util.ArrayList;
import java.nio.file.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap; 



public class Restaurante {
	private ArrayList<Ingrediente> ingredientes;
	private ArrayList<Pedido> pedidos;
	private ArrayList<ProductoMenu> menuBase;
	private ArrayList<bebidas> bebidasbase;
	private ArrayList<Combo> combos;
	private Pedido pedidoEnCurso=null;
	HashMap<String, String> productos = new HashMap<String, String>();
	HashMap<String, String> productos_calorias = new HashMap<String, String>();
	private boolean existe_producto;

	public Restaurante() {
		
		this.ingredientes = new ArrayList<Ingrediente>();
		this.pedidos = new ArrayList<Pedido>();
		this.menuBase = new ArrayList<ProductoMenu>();
		this.combos= new ArrayList<Combo>();
		this.bebidasbase= new ArrayList<bebidas>();

	}
	
	
	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}





	public ArrayList<ProductoMenu> getMenuBase() {
		return menuBase;
	}

	public void setpedido_curso() {
		this.pedidoEnCurso=null;
	}
		

	public boolean getexiste_producto()
	{
		if (pedidoEnCurso==null)
		{
			existe_producto=false;
		}
		else
		{
			existe_producto=true;
		}
		return existe_producto;
	}
	
	
	public Pedido getPedidoEnCurso() {
		return pedidoEnCurso;
	}
	
	public ArrayList<Combo> getcombos()
	{
		return combos;
	}
	public ArrayList<bebidas> getbebidas()
	{
		return bebidasbase;
	}
	
	private void cargarIngredientes(String nombre_archivo) throws FileNotFoundException, IOException,Exception
	{
		BufferedReader br = new BufferedReader(new FileReader(nombre_archivo));
		String linea = br.readLine();
		while(linea!=null)
		{
			String[] partes = linea.split(";");
			Ingrediente valor_ingrediente=new Ingrediente(partes[0],Integer.parseInt(partes[1]),Integer.parseInt(partes[2]));
			if (Integer.parseInt(partes[1])>150000)
				throw new IngredienteRepetidoException ("El producto "+ valor_ingrediente.getNombre()+" supera el valor permitido");
			if  (!ingredientes.contains(valor_ingrediente))
			{
			ingredientes.add(valor_ingrediente);
			}
			else 
			{
				throw new IngredienteRepetidoException ("El ingrediente "+valor_ingrediente.getNombre()+" esta repetido");
			}
			linea = br.readLine();
			
		}
		br.close();
		
	}
	private void cargarMenu(String nombre_archivo) throws FileNotFoundException, IOException, Exception
	{
		BufferedReader br = new BufferedReader(new FileReader(nombre_archivo));
		String linea = br.readLine();
		while(linea!=null)
		{
			String[] partes = linea.split(";");
			productos.put(partes[0],partes[1]);
			productos_calorias.put(partes[0],partes[2]);
			ProductoMenu valor_menu=new ProductoMenu(partes[0],Integer.parseInt(partes[1]),Integer.parseInt(partes[2]));
			if (Integer.parseInt(partes[1])>150000)
				throw new ProductoRepetidoException ("El producto "+ valor_menu.getNombre()+" supera el valor permitido");
			if(!menuBase.contains(valor_menu))
			{
			menuBase.add(valor_menu);
			}
			else 
			{
				throw new ProductoRepetidoException ("El producto "+ valor_menu.getNombre()+" esta repetido");
			}
			
			linea = br.readLine();
			
		}
		br.close();
		
	}
	private void cargarbebidas(String nombre_archivo) throws FileNotFoundException, IOException, Exception
	{
		BufferedReader br = new BufferedReader(new FileReader(nombre_archivo));
		String linea = br.readLine();
		while(linea!=null)
		{
			String[] partes = linea.split(";");
			productos.put(partes[0],partes[1]);
			productos_calorias.put(partes[0],partes[2]);
			bebidas valor_menu=new bebidas(partes[0],Integer.parseInt(partes[1]),Integer.parseInt(partes[2]));
			if(!bebidasbase.contains(valor_menu))
			{
			bebidasbase.add(valor_menu);
			}
			else 
			{
				throw new Exception ("Bebidas repetidos");
			}
			linea = br.readLine();
			
		}
		br.close();
		
	}
	
	private void cargarCombos(String nombre_archivo) throws FileNotFoundException, IOException
	{
		BufferedReader br = new BufferedReader(new FileReader(nombre_archivo));
		String linea = br.readLine();
		while(linea!=null)
		{
			String[] partes = linea.split(";");
			String descuento=partes[1];
			String elemento_1=partes[2];
			String elemento_2=partes[3];
			String elemento_3=partes[4];
			String precio1=productos.get(elemento_1);
			String precio2=productos.get(elemento_2);
			String precio3=productos.get(elemento_3);
			String calorias1=productos_calorias.get(elemento_1);
			String calorias2=productos_calorias.get(elemento_2);
			String calorias3=productos_calorias.get(elemento_3);
			ProductoMenu producto1= new ProductoMenu(elemento_1,Integer.parseInt(precio1),Integer.parseInt(calorias1));
			ProductoMenu producto2= new ProductoMenu(elemento_2,Integer.parseInt(precio2),Integer.parseInt(calorias2));
			bebidas producto3= new bebidas(elemento_3,Integer.parseInt(precio3),Integer.parseInt(calorias3));
			descuento=descuento.replace("%","");
			double descuento_double=Double.parseDouble(descuento)/100;
			Combo valor_combo=new Combo(descuento_double,partes[0]);
			valor_combo.agregarItemACombo(producto1);
			valor_combo.agregarItemACombo(producto2);
			valor_combo.agregarItemACombo(producto3);
			
			if (!combos.contains(valor_combo))
			{
				combos.add(valor_combo);
			}
			
				
				
			linea = br.readLine();
			
		}
		br.close();
		
	}
	
	
	public void CargarInformacionRestaurante(String nombre_archivo) throws Exception
	{
		
		cargarMenu(nombre_archivo+"/menu.txt");
		cargarIngredientes(nombre_archivo+"/ingredientes.txt");
		cargarbebidas(nombre_archivo+"/bebidas.txt");
		cargarCombos(nombre_archivo+"/combos.txt");
		
		
	}
	
	public void iniciarPedido(String nombreCliente, String direccionCliente)
	{
		Pedido pedidoEnCurso=new Pedido(nombreCliente,direccionCliente);
		int Id_pedido= pedidoEnCurso.getIdPedido();
		System.out.println("la id del pedido es"+Id_pedido);
		/*
		 * Nombre_general_para_todos_los_Archivos
		 */
		String archivo="facturas/orden_id";
		Path path = Paths.get(archivo+Integer.toString(Id_pedido)+".txt");
		if (!Files.exists(path))
		{
			this.pedidoEnCurso = pedidoEnCurso;
		}
		else
		{
			this.pedidoEnCurso = null;
		}
		pedidos.add(pedidoEnCurso);
		
	}
	
	public void cerrarYGuardarPedido()
	{
		if (pedidoEnCurso!=null)
		{
			String archivo="facturas/orden_id";
			pedidoEnCurso.guardarFactura(archivo);
			pedidoEnCurso=null;
		}
		else
		{
			System.out.println("No hay pedidos en curso");
		}
	}

	
	
	
}
