package co.edu.upb.Interna;
//La clase representa el sistema de gestion del inventario
public class Pieza {
	private int id;
	private String nombre;
	private Categoria categoria;
	private int cantidad;
	public Pieza(int id, String nombre, int cantidad, Categoria categoria) {
		super();//El constructor a pesar de tener un super es por su generacion automatica pero en este caso no sirve de nada
		this.id = id;//El identificador de la pieza en este caso lo uso como si el usuario pudiera dijitar el id pero realmente ya viene establecido de forma incremental desde el main
		this.nombre = nombre;//nombre de piza
		this.cantidad = cantidad;//cantidad de unidades disponibles
		this.categoria=categoria;//la categoria que pertenece a la pieza
	}
	public int getId() {//RECORDAR QUE UN GET OBTIENE Y UN SET ESTABLECE EL VALOR DE ESE ELEMENTO EN ESTE CASO AL SER UNA CLASE DONDE SUS ELEMENTOS U VARIABLES A USAR SON DE FORMA PRIVADA NO SE 
		return id;      //PUEDE ACCEDER DESDE OTRA PARTE SI NO POSEE ESTOS METODOS Y ESTO PARA QUE SIRVE PARA GARANTIZAR QUE NO EXISTA UN CAMBIO DE VALOR NO DESEADO QUE VENGA DESDE OTRA CLASE EN ESTE CASO
	}                   //VALOR DE LA VARIABLE
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Categoria getCategoria() {//Obtiene la categoria
		return categoria;
	}
	public void setCategoria(Categoria categoria) {//Establece la categoria a la cual pertenece la pieza
		this.categoria = categoria;
	}
	public int getCantidad() {//Obtiene la cantidad y asi en las distintas secciones
		return cantidad;
	}
	public void setCantidad(int cantidad) {//Establece la cantidad
		this.cantidad = cantidad;
	}
	
}