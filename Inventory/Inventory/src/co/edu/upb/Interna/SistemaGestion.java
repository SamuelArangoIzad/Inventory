package co.edu.upb.Interna;

import java.util.ArrayList;
//Contrato que define lo que se debe implementar de forma gestionada para el inventario
public interface SistemaGestion {
	//Agrega una nueva pieza al inventario
	public void agregarPieza(Pieza pieza);
	//Elimina una pieza del inventgario basandose en su identificador
	public void eliminarPorId(int id);
	//Buscar piezas en el inventario popr su nombre
	ArrayList<Pieza>buscarPorNombre(String nombre);
	//Buscar piezas por su categoria
	ArrayList<Pieza>buscarPorCategoria(Categoria categoria);
	//Actualiza la cantidad de una pieza en el inventario
	public void actualizarCantidadPieza(int id, int cantidad);
	//Muestra el inventario actual de piezas
	public void mostrarInventario();
	//Obtiene el tamaño actual de la lista de piezas en el inventario
	public int obtenerTamanioListaPiezas();
}
/**
 * Con base a lo siguiente se guia por medio de lo solicitado en la creación
 * de metodos para el correcto funcionamiento, cabe resaltar que interface es
 * un contrato que hay que cumplir en una clase que implementara
 * lo establecido en esta clase para que de esta
 * forma se pueda implementar
 * 
 * el void en esta clase es un tipo de datos quie se utiliza para indicar que una funcion
 * o metodo no devuelve ningun valor, en otras palabras una funcion con un tipo de retorno
 * no produce un resultado que puede ser utilizado o asignado a una variable.
 */