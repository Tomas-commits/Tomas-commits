package lt.bit.sportClub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import lt.bit.sportClub.services.StorageService;

@Controller
@RequestMapping("/files")
public class FileStorageController {
	@Autowired
	private StorageService storageService;
	@GetMapping("/")
	public String home() {
		return "uploadPage";
	}
	
	@PostMapping("/")
	public String uploadFile(@RequestParam("file") MultipartFile file) { // pasiemam failą
		storageService.store(file);
		return home();
	}

}
