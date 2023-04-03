package cl.drobles.distancias.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "imagen")
public class Imagen {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_imagen")
	@JsonProperty("id_imagen")
	private int id_imagen;
	@Column(name = "id_reporte")
	@JsonProperty("id_reporte")
	private int id_reporte;
	@Column(name = "nombre_original")
	@JsonProperty("nombre_original")
	private String nombre_original;
	private String nombre;
	private String tipo;
	public Imagen() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Imagen(int id_imagen, int id_reporte, String nombre_original, String nombre, String tipo) {
		super();
		this.id_imagen = id_imagen;
		this.id_reporte = id_reporte;
		this.nombre_original = nombre_original;
		this.nombre = nombre;
		this.tipo = tipo;
	}
	
	public int getId_imagen() {
		return id_imagen;
	}
	public void setId_imagen(int id_imagen) {
		this.id_imagen = id_imagen;
	}
	public int getId_reporte() {
		return id_reporte;
	}
	public void setId_reporte(int id_reporte) {
		this.id_reporte = id_reporte;
	}
	public String getNombre_original() {
		return nombre_original;
	}
	public void setNombre_original(String nombre_original) {
		this.nombre_original = nombre_original;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	@Override
	public String toString() {
		return "Imagen [id_imagen=" + id_imagen + ", id_reporte=" + id_reporte + ", nombre_original=" + nombre_original
				+ ", nombre=" + nombre + ", tipo=" + tipo + "]";
	}
	
	
}
