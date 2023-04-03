package cl.drobles.distancias.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.lang.Nullable;

import com.fasterxml.jackson.annotation.JsonProperty;


@Entity
@Table(name = "comuna")
public class Commune {

	@Id
	@Column(name = "id_comuna")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	@Column(name = "nombre")
	String  name;

	@Column(name = "id_region")
	@JsonProperty("id_region")
	Integer region_id;
	
	@Column(name = "nombre_region")
	@Nullable
	String  nombre_region;
	
	@Column(name = "mantenida")
	Boolean maintained;
	
	//-------------------------------------------------------------------------
	
	public Commune() {
		super();
	}
	
	

	public Commune(Integer id, String name, Integer region_id, String region_name, Boolean maintained) {
		super();
		this.id = id;
		this.name = name;
		this.region_id = region_id;
		this.nombre_region = region_name;
		this.maintained = maintained;
	}



	//-------------------------------------------------------------------------
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name.trim();
	}

	public void setName(String name) {
		this.name = name;
	}

	

	
	
	
	
	//-------------------------------------------------------------------------
	
	public Integer getRegion_id() {
		return region_id;
	}



	public void setRegion_id(Integer region_id) {
		this.region_id = region_id;
	}



	public String getNombre_region() {
		return nombre_region;
	}



	public void setNombre_region(String nombre_region) {
		this.nombre_region = nombre_region;
	}



	public Boolean getMaintained() {
		return maintained;
	}



	public void setMaintained(Boolean maintained) {
		this.maintained = maintained;
	}



	@Override
	public String toString() {
		return "Commune [id=" + id + ", name=" + name + ", region_id=" + region_id + ", region_name=" + nombre_region
				+ ", maintained=" + maintained + "]";
	}



	

}
