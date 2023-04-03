package cl.drobles.distancias.service;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import cl.drobles.distancias.model.Imagen;
import cl.drobles.distancias.repository.FileUploadRepository;


@Service
public class FileUploadService implements FileUploadRepository {

	@Autowired
	public ImagenService fService;

	public static final String EXTERNAL_FILE_PATH = "uploads/";
	public static final String EXTERNAL_FILE_PATH_PRODUCTION = "/usr/local/src/QR/uploads/"; 
	private final Path rootFolder = Paths.get(EXTERNAL_FILE_PATH_PRODUCTION);
	@SuppressWarnings("unused")
	private final Path rootFolderW = Paths.get(EXTERNAL_FILE_PATH);
		
	BufferedImage resizeImage(BufferedImage originalImage, int targetWidth, int targetHeight) throws IOException {
	    Image resultingImage = originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_DEFAULT);
	    BufferedImage outputImage = new BufferedImage(targetWidth, targetHeight, BufferedImage.TYPE_INT_RGB);
	    outputImage.getGraphics().drawImage(resultingImage, 0, 0, null);
	    return outputImage;
	}
	
	public void resize(String name, String ext) {		
		try {
			File pathToFile = new File(EXTERNAL_FILE_PATH_PRODUCTION+name);				
			ByteArrayOutputStream os = new ByteArrayOutputStream();
			ImageIO.write(resizeImage(ImageIO.read(pathToFile),500,500), ext, os);                          // Passing: ​(RenderedImage im, String formatName, OutputStream output)
			InputStream is = new ByteArrayInputStream(os.toByteArray());
			Files.delete(rootFolder.resolve(name));
			Files.copy(is, this.rootFolder.resolve(name));
			
		} catch (Exception e) {
			
		}
	}
	
	
	@Override
	public void save(MultipartFile file, String name, String ext) throws Exception {
		Files.copy(file.getInputStream(), this.rootFolder.resolve(name));
		resize(name,ext);
	}
	
	@Override
	public void save(MultipartFile file, int id) throws Exception {	
			if(file != null) {
				String contentType = file.getContentType();
				String extension = "";
				if(contentType != null) {
					if (contentType.contains("jpeg")) {
						extension = "jpeg";
					} else if (contentType.contains("pdf")) {
						extension = "pdf";
					} else if (contentType.contains("csv")) {
						extension = "csv";
					} else if (contentType.contains("webp")) {
						extension = "webp";
					} else if (contentType.contains("png")) {
						extension = "png";
					} else if (contentType.contains("jpg")) {
						extension = "jpg";
					}
				}				

				String name = file.getName() + "_"
						+ new Timestamp(System.currentTimeMillis()).toLocalDateTime().toString().replace(":", ".") + "."
						+ extension;				
				
				Imagen f = new Imagen();			
				f.setNombre_original(file.getOriginalFilename());
				f.setNombre(name);
				f.setTipo(contentType);
				f.setId_reporte(id);
				fService.save(f);
				save(file, name, extension);
			}
			
		

	}


}
