package cl.drobles.distancias.model;

public class ModelCaptcha {
	public String secret;
	public String response;
	public ModelCaptcha() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ModelCaptcha(String secret, String response) {
		super();
		this.secret = secret;
		this.response = response;
	}
	public String getSecret() {
		return secret;
	}
	public void setSecret(String secret) {
		this.secret = secret;
	}
	public String getResponse() {
		return response;
	}
	public void setResponse(String response) {
		this.response = response;
	}
	
	
}
