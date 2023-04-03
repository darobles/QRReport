package cl.drobles.distancias.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "reporte")
public class Report {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_reporte")
	@JsonProperty("id_reporte")
	private int id_reporte;	
	@Column(name = "id_cruce")
	@JsonProperty("id_cruce")
	private int id_cruce;
	private String correo;
	private String comentario;
	private Timestamp creacion;
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Report(int id_cruce, String correo, String comentario) {
		super();
		this.id_cruce = id_cruce;
		this.correo = correo;
		this.comentario = comentario;
		this.creacion = new Timestamp(System.currentTimeMillis());
	}


	public Report(int id_reporte, int id_cruce, String correo, String comentario) {
		super();
		this.id_reporte = id_reporte;
		this.id_cruce = id_cruce;
		this.correo = correo;
		this.comentario = comentario;

	}
	
	
	public int getId_reporte() {
		return id_reporte;
	}


	public void setId_reporte(int id_reporte) {
		this.id_reporte = id_reporte;
	}


	public int getId_cruce() {
		return id_cruce;
	}


	public void setId_cruce(int id_cruce) {
		this.id_cruce = id_cruce;
	}


	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getComentario() {
		return comentario;
	}
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	public Timestamp getCreacion() {
		return creacion;
	}
	public void setCreacion(Timestamp creacion) {
		this.creacion = creacion;
	}
	@Override
	public String toString() {
		return "Report [id_reporte=" + id_reporte + ", id_cruce=" + id_cruce + ", correo=" + correo + ", comentario="
				+ comentario + ", creacion=" + creacion + "]";
	}
	
	
	
	
	
	
}
