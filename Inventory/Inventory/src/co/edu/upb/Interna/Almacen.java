package co.edu.upb.Interna;

import java.util.ArrayList;
import java.util.HashMap;
//Esta clase implementa la interfaz de sistema de gestion y representa un almacen de piezas
public class Almacen implements SistemaGestion{
	private ArrayList<Pieza> listaPiezas;//Lista de todas las piezas
	private HashMap<Integer, Pieza>mapaPiezas; //El mapa necesario que asocia las ids y piezas siendo asi un key y un value
	private int ultimoId;//Ultimo id asignado a la pieza
	
	public Almacen() {
		this.listaPiezas=new ArrayList<>();//Se inicializan las instancias en el constructor siendo asi el arrayList una coleccion dinamica
		this.mapaPiezas=new HashMap<>();//se instancia 
		this.ultimoId=0;//Inicializa la variable a partir de 0 ya que el primer valor no debe iniciar en 0 si no en 1 y seguirse almacenando de esta forma
	}
	
	@Override //Metodo que agrega una nueva pieza al almacen
	public void agregarPieza(Pieza pieza) {
		ultimoId++; // Incrementa el ID 
	    pieza.setId(ultimoId);//Establece el identificador de la pieza antes de asignarlo 
	    
	    listaPiezas.add(pieza);//Agrega la pieza a lista de piezas es decir al arraylist que contiene las piezas almacenadas en el almacen
	    mapaPiezas.put(ultimoId, pieza);//asi como el array list se agrega la pieza al mapa utilizando ultimo id como la clave propia instancia de la pieza como valor asociado a esta clave de esta forma se accede  a la pieza por medio de la identificacion
	    
	    System.out.println("Pieza agregada con éxito. ID asignado: " + ultimoId);//Imprime el mensaje esto se ve reflejado en el main donde le dice al usuario que id posee de forma incremental a la nueva pieza
	}

	@Override
	public void eliminarPorId(int id) {
		Pieza pieza = mapaPiezas.get(id);//Obtiene la referencia de la pieza correspondiente al identificador proporcionado si no se encuentra por id este sera null
		if(pieza != null) {//busca donde pieza no sea igual a nulo para asi hacer la perspectiva busqueda y proceder a eliminar si la pieza no existe simplemente paila, no se encuentra
			listaPiezas.remove(pieza);//Elimina la pieza correspondiente al array y se actualiza el array de piezas
			mapaPiezas.remove(id);//Asi mismo como en el array se elimina en el hash map
		}
	}

	@Override
	public ArrayList<Pieza> buscarPorNombre(String nombre) {//Se crea una nuevca instancia de arraylist llamada piezas. Esto se utilizara para almacenar las piezas que coincidan por nombre dijitado por el usuario
		ArrayList<Pieza> piezasPorNombre = new ArrayList<>();
		for(Pieza pieza: listaPiezas) {//Este for each se inicia el bucle que itera cada elemento de la lista de piezas que contiene las piezas del almacen
			if(pieza.getNombre().toLowerCase().contains(nombre.toLowerCase())) {//LowerCasi Busqueda sensible entre mayusculas y minusculas 
				piezasPorNombre.add(pieza);//Si coincide agrega la pieza a la lista
			}
		}
		return piezasPorNombre;//Si coincide el nombre de la pieza devuelve todas las piezas que contiene nombres coincidentes 
	}

	@Override
	public ArrayList<Pieza> buscarPorCategoria(Categoria categoria) {
		ArrayList<Pieza> piezasPorCategoria = new ArrayList<>();//Se crea la instancia de arraylist llamada piezas por categoria utilizada para almacenar piezas pertenecientes a categoria proporcionada como argumento
		for(Pieza pieza: listaPiezas) {//for each itera los elementos que contiene las piezas en el almacen
			if(pieza.getCategoria().equals(categoria)) {//Obtiene el valor de la categoria y lo compara si es igual con lo dijitado por el usuario
				piezasPorCategoria.add(pieza);//Si es asi se agrega la pieza y si no coincide simplemente no se muestra
			}
		}
		return piezasPorCategoria;//De vuelve la lista de las piezas que pertenecen a la categoria proporcionada
	}

	@Override
	public void actualizarCantidadPieza(int id, int cantidad) {
		Pieza pieza = mapaPiezas.get(id);//Si existe una pieza con el identificador obtendra la referencia de la misma de lo contrario sera nulo
		if(pieza != null) {//Verifica la referencia que no sea nulo esto significa que ha encontrado una pieza con el id correspondiente dijitado
			int nuevaCantidad = pieza.getCantidad()+cantidad;//Calcula la nueva cantidad y obtiene los datos que ya existen y establece o suma los nuevos dijitados por el usuario
			pieza.setCantidad(nuevaCantidad);//Establece la nueva cantidad calculada en la propiedad de cantidad
		}
	}

	@Override
	public void mostrarInventario() {
		System.out.println("Inventory: ");//Muestra en consola simplemente inventory por ubicarse
		for(Pieza pieza: listaPiezas) {//el for each muestra todas las piezas que pertenecen al arraylist de lista de piezas
			System.out.println("ID: " + pieza.getId() + ", Nombre: " + pieza.getNombre() + ", Cantidad: " + pieza.getCantidad() + ", Categoria: " + pieza.getCategoria());
		}//y simpolemente cada pieza. representa el llamado de la clase Pieza y su obtencion de informacion de cada una de las variables 
	}

	@Override
	public int obtenerTamanioListaPiezas() {
		return listaPiezas.size();
	}//De vuelve el tamaño del arrayList de lista de piezas es decir la cantidad de piezas existen no la sumatoria de cada pieza no, solamente cuantas pieza
}