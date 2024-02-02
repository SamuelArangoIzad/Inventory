package co.edu.upb.Interna;
/**
 * Enum este caso las categorias donde cada constante es un objeto. No se pueden crear
 * nuevos objetos del enum. Todos los objetos de la clase son los que aparecen en la declaracion
 * del enum
 * por ser una clase enum puede contener atributos y metodos
 */
public enum Categoria {
	MECANICA,HIDRAULICA,ELECTRICA;//Obtiene una instancia de enum partiendo de las distintas de un nombre de categoria proporcionado
	public static Categoria obtenerCategoria(String nombreCategoria) {
        for (Categoria categoria : Categoria.values()) {
            if (categoria.name().equals(nombreCategoria.toUpperCase())) {
                return categoria;
            }
        }
        System.out.println("Categoria no válida.");
        return null;//Si el nombre no reconoce ninguna entrada valida sera un nulo
	}
}
/**
 * .values funciona como un arraylist interno dentro de java para enumeracion devolviendo todas las constantes
 * que esta contiene de categoria
 * 
 * Donde el bucle for itera como for each sobre las constantes de la enumeracion
 * y asi como si fuera un arraylist recorriendo usa el if con categoria.name que devuelve el nombre de la constante iterrado actualmente
 * toUppercase() es tambien un metodo interno de java que me permite convertir el nombre de la categoria como un argumento en mayusculas como un String
 * esto hace para asegurar su debida comparacion para que de esta forma sea precisa evitando un error que el usuario dijite una minuscula y esto genere
 * un error de busqueda fallida
 * 
 * Complementado el if se comprende que compara el nombre de la constante actual con el nombre de la categoria proporcionada , y luego de convertir el ultimo a mayusculas
 * si hay una coincidencia significa que ha encontrado la ctegoria y el return finalmente retornado lo dijitado que internamente ya comprobo que coincide con una
 * seccion del enum
 */