package co.edu.upb.principal;

import java.util.ArrayList;
import java.util.Scanner;

import co.edu.upb.Interna.Almacen; //de esta forma se importa las clases de otro paquete de esta forma utilizando solamente un fragmento
import co.edu.upb.Interna.Categoria;//de forma ordenada del patron de diseño de composite utilizando asi los paquetes de prioridad y eficiencia
import co.edu.upb.Interna.Pieza;//volviendo asi el codigo mas organizado y funcional
import co.edu.upb.Interna.SistemaGestion;

public class Main {
	public static void main(String[]args) {
		Scanner scanner = new Scanner(System.in);
		SistemaGestion almacen = new Almacen();
		/**
		 * Do while sencillo se repite constantemente hasta seleccionar 7
		 * donde se hace un cerrado de forma obligatoria con  un codigo de salida o valor de estado
		 * donde 0 es usado para indicar la finalziacion del programa sin errores
		 * del resto cada case ubica cada opcion y invocando los metodos staticos privados y propios de esta clase
		 * donde estos invocan las distintas funcionalidades de metodos de las otras clases
		 */
		
		while(true) {
			System.out.println("___________________MENU PRINCIPAL___________________");
			System.out.println("1. Agregar Pieza");
			System.out.println("2. Eliminar Pieza por ID");
			System.out.println("3. Buscar Pieza Por Nombre");
			System.out.println("4. Buscar pieza por Categoria");
			System.out.println("5. Actualizar Cantidad De Pieza");
			System.out.println("6. Mostrar Inventario");
			System.out.println("7. Salir");
			
			System.out.print("Ingrese La Opcion Deseada: ");
			int opcion = scanner.nextInt();
			switch(opcion) {
			case 1:
				System.out.println("__AGREGAR PIEZA__");
				Pieza nuevaPieza = crearPiezaDesdeEntradaUsuario(scanner);
				almacen.agregarPieza(nuevaPieza);
				System.out.println("AGREE");
				break;
			case 2:
				System.out.println("__ELIMINAR PIEZA POR ID__");
				System.out.print("Ingrese el ID de la pieza a eliminar: ");
				int idEliminar = scanner.nextInt();
				almacen.eliminarPorId(idEliminar);
				System.out.println("Pieza Eliminada correctamente. ");
				break;
			case 3:
				System.out.println("__BUSCAR PIEZA POR NOMBRE__");
				System.out.print("Ingrese el nombre de la pieza a buscar: ");
				String nombreBuscar = scanner.next();
				scanner.nextLine();
				mostrarResultadoBusqueda(almacen.buscarPorNombre(nombreBuscar));
				break;
			case 4:
				System.out.println("__BUSCAR PIEZA POR CATEGORIA__");
				System.out.print("Ingrese la categoria a buscar(ELECTRICA, HIDRAULICA, MECANICA): ");
				String categoriaBuscar = scanner.next().toUpperCase();
				scanner.nextLine();
				mostrarResultadoBusqueda(almacen.buscarPorCategoria(Categoria.valueOf(categoriaBuscar)));
				break;
			case 5:
				System.out.println("__ACTUALIZAR CANTIDAD DE PIEZA__");
				int idActualizar = obtenerIdDesdeEntradaUsuario(scanner);
				System.out.print("Ingrese la cantidad a agregar/restar (positivo para sumar, negativo para restar): ");
				int cantidadActualizar = scanner.nextInt();
				almacen.actualizarCantidadPieza(idActualizar, cantidadActualizar);
				System.out.println("Cantidad de pieza Actualizada correctamente.");
				break;
			case 6:
				System.out.println("__MOSTRAR INVENTARIO__");
				almacen.mostrarInventario();
				break;
			case 7:
				System.out.println("Bye");
				System.exit(0);
				break;
			default:
				System.out.println("");
			}
		}
	}//Scanner scanner dentro de la instancia del metodo que invocado la clase sirvfe para proporcionar metodos para leer diferentes tipos de datos de la entrada estandar o flujo de entrada
	private static Pieza crearPiezaDesdeEntradaUsuario(Scanner scanner) {//Metodo privado y propio de esta clase
		Almacen almacen = new Almacen();//Invoca la clase creando la instancia de almacen que genera un nuevo almacen cada vez que llamada este metodo 
		int id = almacen.obtenerTamanioListaPiezas()+1;//obtiene el tamaño actual de la lista de pieza y incrementa el identificador de 1 en 1
		
		System.out.print("Nombre de la pieza: ");
		scanner.nextLine();
		String nombre = scanner.nextLine();
		System.out.print("Ingrese la cantidad: ");
		int cantidad=scanner.nextInt();
		scanner.nextLine();
		
	    Categoria categoria = null;
	    do {
	        System.out.print("Categoria (ELECTRICA, MECANICA, HIDRAULICA): ");
	        String categoriaStr = scanner.nextLine().toUpperCase();
	        categoria = Categoria.obtenerCategoria(categoriaStr);
	        if (categoria == null) {
	            System.out.println("Categoria no válida. Intente nuevamente.");
	        }
	    } while (categoria == null);
		
		return new Pieza(id, nombre, cantidad, categoria);
	}
	private static int obtenerIdDesdeEntradaUsuario(Scanner scanner) {
		System.out.print("Ingrese ID de la pieza: ");
		return scanner.nextInt();
	}
	private static void mostrarResultadoBusqueda(ArrayList<Pieza>resultados) {
		System.out.println("Resultados de busqueda: ");
		if(resultados.isEmpty()) {
			System.out.println("Not Found");
		}
		else {
			for(Pieza pieza:resultados) {
				System.out.println("ID: " + pieza.getId() + " , Nombre: " + pieza.getNombre() + " , Cantidad: " + pieza.getCantidad() + " , Categoria: " + pieza.getCategoria());
			}
		}
	}
}