package cl.drobles.distancias.repository;

import org.springframework.web.multipart.MultipartFile;


public interface FileUploadRepository {
	
	
	public void save(MultipartFile file, int id) throws Exception;

	void save(MultipartFile file, String name, String ext) throws Exception;
	
	
	
}
