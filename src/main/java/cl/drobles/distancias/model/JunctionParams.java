package cl.drobles.distancias.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class JunctionParams {
	@JsonProperty("junction_id")
	private Integer junction_id;

	@JsonProperty("latitude")
	private Double latitud;

	@JsonProperty("longitude")
	private Double longitud;
	
	@JsonProperty("distance")
	private Double distancia;
	
	//-------------------------------------------------------------------------
	
	public JunctionParams() {
		super();
	}
	
	public JunctionParams(Integer id, Double latitud, Double longitud, Double distancia) {
		super();
		this.junction_id = id;
		this.latitud = latitud;
		this.longitud = longitud;
		this.distancia = distancia;
	}

	//-------------------------------------------------------------------------
	
	

	public Double getLatitud() {
		return latitud;
	}
	
	public Integer getJunction_id() {
		return junction_id;
	}

	public void setJunction_id(Integer junction_id) {
		this.junction_id = junction_id;
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
		return "JunctionParams [id=" + junction_id + ", latitud=" + latitud + ", longitud=" + longitud + ", distancia="
				+ distancia + "]";
	}

}
