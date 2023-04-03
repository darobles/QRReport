package cl.drobles.distancias.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fallas")
public class Failture {

	@Id
	@Column(name = "id")
	int id;
	@Column(name = "texto")
	String name;
	
	public Failture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Failture [id=" + id + ", name=" + name + "]";
	}
		
	
}
