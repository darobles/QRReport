package cl.drobles.distancias.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "cruce")
public class Junction {
	@Id
	@Column(name = "id_cruce")
	@JsonProperty("id_cruce")
	private Integer id_cruce;
	@JsonProperty("calle_1")
	@Column(name = "calle_1")
	private String calle_1;
	@Column(name = "calle_2")
	@JsonProperty("calle_2")
	private String calle_2;
	@Column(name = "id_comuna")
	@JsonProperty("id_comuna")
	private Integer id_comuna;
	@Column(name = "latitud")
	private Double latitud;
	@Column(name = "longitud")
	private Double longitud;
	@Transient
	private Double distancia;

	//-------------------------------------------------------------------------
	
	public Junction() {
		super();
	}

	public Junction(Integer id_cruce, String calle_1, String calle_2, Integer id_comuna, Double latitud, Double longitud,
			Double distancia) {
		super();
		this.id_cruce = id_cruce;
		this.calle_1 = calle_1;
		this.calle_2 = calle_2;
		this.id_comuna = id_comuna;
		this.latitud = latitud;
		this.longitud = longitud;
		this.distancia = distancia;
	}

	//-------------------------------------------------------------------------
	

	

	public Double getLatitud() {
		return latitud;
	}

	public Integer getId_cruce() {
		return id_cruce;
	}

	public void setId_cruce(Integer id_cruce) {
		this.id_cruce = id_cruce;
	}

	public String getCalle_1() {
		return calle_1;
	}

	public void setCalle_1(String calle_1) {
		this.calle_1 = calle_1;
	}

	public String getCalle_2() {
		return calle_2;
	}

	public void setCalle_2(String calle_2) {
		this.calle_2 = calle_2;
	}

	public Integer getId_comuna() {
		return id_comuna;
	}

	public void setId_comuna(Integer id_comuna) {
		this.id_comuna = id_comuna;
	}

	public void setLatitud(Double latitud) {
		this.latitud = latitud;
	}

	public Double getLongitud() {
		return longitud;
	}

	public void setLongitud(Double longitud) {
		this.longitud = longitud;
	}

	public Double getDistancia() {
		return distancia;
	}

	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}

	//-------------------------------------------------------------------------
	
	@Override
	public String toString() {
		return "Junction [id_cruce=" + id_cruce + ", calle_1=" + calle_1 + ", calle_2=" + calle_2 + ", id_comuna="
				+ id_comuna + ", latitud=" + latitud + ", longitud=" + longitud + ", distancia=" + distancia + "]";
	}

}
