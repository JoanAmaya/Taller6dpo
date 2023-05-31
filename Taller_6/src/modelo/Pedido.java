package modelo;
import java.util.ArrayList;
import java.io.FileWriter;
import java.io.File;
import java.io.IOException; 
import java.util.Random;  


public class Pedido {
	private ArrayList<Producto> itemsPedido;
	private static int idPedido;
	private static int numeroPedidos=0;
	private String nombreCliente;
	private String direccionCliente;
	public Pedido(String nombreCliente, String direccionCliente) {
		this.nombreCliente = nombreCliente;
		this.direccionCliente = direccionCliente;
		Random random= new Random();
		idPedido= random.nextInt(100000000);
		this.itemsPedido = new ArrayList<Producto>();
		numeroPedidos+=1;
	}
	public int getIdPedido() {
		return idPedido;
	}
	public String nombre_total(){
		String resultado="";
		int k=0;
		for(Producto i: itemsPedido)
		{
			if (k==0)
			{
				
				resultado=resultado.concat("\n"+i.getNombre());
				resultado=resultado.concat(" y "+i.generarTextoFactura());
			}
			else
			{
				resultado=resultado.concat("\n con "+i.getNombre());
				resultado=resultado.concat(" y "+i.generarTextoFactura());
			}
			k+=1;
		}
		return resultado;
	}
	
	public void agregarProducto(Producto nuevoitem)
	{
		itemsPedido.add(nuevoitem);
	}

	
	private int getPrecioNetoPedido()
	{
		int precio=0;
		for (Producto i: itemsPedido)
		{
			precio+=i.getPrecio();
		}
		
		return precio;
	}
	private int getcaloriasnetas()
	{
		int cal=0;
		for (Producto i: itemsPedido)
		{
			cal+=i.getcalorias();
		}
		
		return cal;
	}
	
	private int getPrecioIVAPedido()
	{
		int precio=0;
		for (Producto i: itemsPedido)
		{
			precio+=i.getPrecio();
		}
		
		return (int)(precio*0.19);
	}
	
	private int getPrecioTotalPedido()
	{
		return (getPrecioIVAPedido()+getPrecioNetoPedido());
	}
	
	public void guardarFactura(String archivo)
	{
		 try {
		        File myObj = new File(archivo+Integer.toString(idPedido)+".txt");
		        if (myObj.createNewFile()) {
		          System.out.println("File created: " + myObj.getName());
		        } else {
		          System.out.println("File already exists.");
		        }
		      } catch (IOException e) {
		        System.out.println("An error occurred.");
		        e.printStackTrace();
		      }
		 try 
		 {
		      FileWriter factura = new FileWriter(archivo+Integer.toString(idPedido)+".txt");
		      factura.write("La factura es:\n Direccion cliente: "+ direccionCliente +"\n"+"Nombre del cliente: "+ nombreCliente +"\n"+"Numero de pedidos :"+numeroPedidos+"\n");
		      factura.write("La orden realizada es "+nombre_total()+"\n"+"Precio: "+Integer.toString(getPrecioTotalPedido())+" con un total de calorias de "+Integer.toString(getcaloriasnetas()));
		      factura.close();
		      System.out.println("Successfully wrote to the file.");
		      
		    } 
		 catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}
		
	
    
	
	
	
	
	
	

}
