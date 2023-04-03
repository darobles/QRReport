package cl.drobles.distancias.model;

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestCaptcha {	
	/**
	 * 
	 */
	//private static final long serialVersionUID = 1L;
	private String token;
	private String action;	
	@JsonProperty("id_cruce")
	private int id_cruce;
	@JsonProperty("id_comuna")
	private int id_comuna;
	@JsonProperty("calle_1")
	private String calle1;
	@JsonProperty("calle_2")
	private String calle2;
	private String correo = "";
	private String comentario = "";
	@JsonProperty("id_asunto")
	private int id_asunto;
	private String asunto = "";
	private MultipartFile imagen;
	
	public RequestCaptcha() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public RequestCaptcha(String token, String action, int id_cruce, int id_comuna, String calle1, String calle2,
			String correo, String comentario, int id_asunto, String asunto, MultipartFile imagen) {
		super();
		this.token = token;
		this.action = action;
		this.id_cruce = id_cruce;
		this.id_comuna = id_comuna;
		this.calle1 = calle1;
		this.calle2 = calle2;
		this.correo = correo;
		this.comentario = comentario;
		this.id_asunto = id_asunto;
		this.asunto = asunto;
		this.imagen = imagen;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getAction() {
		return action;
	}


	public void setAction(String action) {
		this.action = action;
	}


	public String getCalle1() {
		return calle1;
	}


	public void setCalle1(String calle1) {
		this.calle1 = calle1;
	}


	public String getCalle2() {
		return calle2;
	}


	public void setCalle2(String calle2) {
		this.calle2 = calle2;
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


	public String getAsunto() {
		return asunto;
	}


	public void setAsunto(String asunto) {
		this.asunto = asunto;
	}


	public MultipartFile getImagen() {
		return imagen;
	}


	public void setImagen(MultipartFile imagen) {
		this.imagen = imagen;
	}


	public int getId_cruce() {
		return id_cruce;
	}


	public void setId_cruce(int id_cruce) {
		this.id_cruce = id_cruce;
	}


	public int getId_comuna() {
		return id_comuna;
	}


	public void setId_comuna(int id_comuna) {
		this.id_comuna = id_comuna;
	}


	public int getId_asunto() {
		return id_asunto;
	}


	public void setId_asunto(int id_asunto) {
		this.id_asunto = id_asunto;
	}


	@Override
	public String toString() {
		return "RequestCaptcha [token=" + token + ", action=" + action + ", id_cruce=" + id_cruce + ", id_comuna="
				+ id_comuna + ", calle1=" + calle1 + ", calle2=" + calle2 + ", correo=" + correo + ", comentario="
				+ comentario + ", id_asunto=" + id_asunto + ", asunto=" + asunto + ", imagen=" + imagen + "]";
	}



	


}
