package cl.drobles.distancias.repository;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

import cl.drobles.distancias.model.RequestCaptcha;
import cl.drobles.distancias.model.ResponseCaptcha;
import cl.drobles.distancias.model.ResponseServer;
import java.util.logging.Level;
import java.util.logging.Logger;

@Repository
public class CaptchaRepository {

	private final WebClient webClient;

	private String SECRET_KEY = "6LdFaBoiAAAAAI_LPE45viyVDOd5zGxqD1S1h-sz";
	
	public CaptchaRepository(WebClient.Builder webClientBuilder) {

		this.webClient = webClientBuilder.baseUrl("").build();
	}

	public Boolean validar(RequestCaptcha captcha) {
		
		MultiValueMap<String, String> mm = new LinkedMultiValueMap<>();
		mm.add("secret", SECRET_KEY);
		mm.add("response", captcha.getToken());
		ResponseCaptcha response = webClient.post().uri("https://www.google.com/recaptcha/api/siteverify").body(BodyInserters.fromFormData(mm))
				.retrieve().bodyToMono(ResponseCaptcha.class).block();
		if( response != null) {			
			if( response.getSuccess() && response.getScore() >= 0.5) {				
				return true;
			}else {
				return false;
			}
		}
		return false;
			
	}
	
	public int reenviar(RequestCaptcha request) throws IOException, InterruptedException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_HH-mm-ss");
		Date date = new Date();
		MultipartBodyBuilder builder = new MultipartBodyBuilder();
		if(request.getImagen().getBytes().length > 0) {
			
			builder.part("attachment", request.getImagen().getResource());
			builder.part("fileName", "qr_" + request.getId_cruce() + "_" + sdf.format(date) + ".jpg");
		}else {
			builder.part("attachment", "");
			builder.part("fileName", "");
		}
		
		if(request.getComentario().trim().length() == 0 || request.getComentario() == null || request.getComentario().equals("")) {
			request.setComentario("Sin observación por parte del usuario.");
		}
		
		JSONObject jo = new JSONObject();
		jo.put("email", request.getCorreo());
		jo.put("junction_id", request.getId_cruce());
		jo.put("phone", "");
		jo.put("name", "QR");
		jo.put("observation", request.getComentario());
		jo.put("commune_id", request.getId_comuna());
		jo.put("street1", request.getCalle1());
		jo.put("street2", request.getCalle2());
		jo.put("subject_id", request.getId_asunto());
		jo.put("subject", request.getAsunto());
		builder.part("json", jo.toString());
		
		int contador = 0;
		while(contador < 3)
		{
			try {
				ResponseServer rs =  webClient.post()
					    .uri("https://URL/api/solicitud/qr")						
					    .contentType(MediaType.MULTIPART_FORM_DATA)
					    .body(BodyInserters.fromMultipartData(builder.build()))
					    .retrieve().bodyToMono(ResponseServer.class).block(); 
					if(rs != null) {
						return rs.getRequest_id();
					}
					return -1;
					
				}
				catch(Exception ex) {
					Logger.getLogger(CaptchaRepository.class.getName()).log(Level.SEVERE, null, ex);
					Thread.sleep(5000);
				}
				contador ++;
		}
		return -1;
		
	}
		
		
	
}
