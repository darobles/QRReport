package cl.drobles.distancias.rest;

import java.io.IOException;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.drobles.distancias.model.RequestCaptcha;
import cl.drobles.distancias.repository.CaptchaRepository;
import cl.drobles.distancias.service.SendEmailService;

@RestController
@RequestMapping("/report")
public class CaptchaREST {		
	@Autowired
	private CaptchaRepository cRepository;
	
	@Autowired
	private SendEmailService eService;
	
	private final static String ERROR = "error";
	private final static String DETALLE = "detail";
	private final static String MENSAJE = "msg";
	private final static String PETICION = "request_id";
	
	@PostMapping("")	
	public ResponseEntity<String> x(@ModelAttribute("captcha") RequestCaptcha captcha ) {		
		int request_id = -2;
		JSONObject jo = new JSONObject();
		
		try {
			if(captcha.getImagen()!=null) {
				if( captcha.getImagen().getBytes().length == 0 && captcha.getAsunto().length() == 0  ) {
					jo.put(MENSAJE, ERROR);
					jo.put(DETALLE, "Complete campo comentario o seleccione una imagen");
					jo.put(PETICION, request_id);
					return ResponseEntity.status(400).body(jo.toString());
				}
			}			
		} catch (IOException e1) {
			return ResponseEntity.status(400).body(e1.getMessage());
		}
		if(cRepository.validar(captcha)) {
						
			
			try {
				request_id = cRepository.reenviar(captcha);		
				if(request_id == -1)
				{
					throw new Exception();
				}
				jo.put(MENSAJE, "success");
				jo.put(DETALLE, "Reporte creado correctamente");
				jo.put(PETICION, request_id);
				if(captcha.getCorreo().length() >0) {
					String texto = "Estimado usuario, le informamos que su solicitud ha sido recepcionada con el número "+request_id+"  y nuestro equipo ya se encuentra trabajando para solucionarla de manera pronta y eficaz. En cuanto tengamos una respuesta se le informará oportunamente por este mismo medio.\r\n"
							+ "\r\n"
							+ "Atentamente";
					eService.sendEmail(new String[] {captcha.getCorreo()},
							"Creación de reporte", 
							texto
							//"Estimad@ recibimos con exito su reporte nro: "+request_id+", en la brevedad un equipo de AUTER S.A se acercará al lugar seleccionado por usted."
							);
				}
				return ResponseEntity.ok(jo.toString());
			} catch (Exception e) {				
				jo.put(MENSAJE, ERROR);
				jo.put(DETALLE, "Verifique el tipo de imagen seleccionada");
				jo.put(PETICION, request_id);
				return ResponseEntity.status(400).body(jo.toString());
			}
		}		
		jo.put(MENSAJE, ERROR);
		jo.put(DETALLE, "ReCaptcha te reconoce como un bot");
		jo.put(PETICION, request_id);
	    return ResponseEntity.status(400).body(jo.toString());
		
		
	}
}
