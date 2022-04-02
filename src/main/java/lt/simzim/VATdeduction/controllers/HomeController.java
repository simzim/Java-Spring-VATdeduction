package lt.simzim.VATdeduction.controllers;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/result")
	public String result() {
		return "result";
	}
	
	
	@PostMapping("/")
	public String vat(
			@RequestParam("kaina") Double kaina, 
			@RequestParam("kiekis") Integer kiekis,
			Model model) {
		
		double bePVM = Math.round( (kaina / 1.21)*100)/100.0;
		double PVM = Math.round( (kaina - bePVM)*100)/100.0;
		
		double vntKaina = Math.round( (kaina / kiekis)*100)/100.0;
		double vntBePVM = Math.round( (vntKaina / 1.21)*100)/100.0;
		double vntPVM = Math.round( (vntKaina - vntBePVM)*100)/100.0 ;
		
		model.addAttribute("kaina", kaina);	
		model.addAttribute("keikis", kiekis);
		model.addAttribute("bePVM", bePVM);	
		model.addAttribute("PVM", PVM);
		
		model.addAttribute("vntKaina", vntKaina);	
		model.addAttribute("vntBePVM", vntBePVM);
		model.addAttribute("vntPVM", vntPVM);	
		
		
		return result();
	}
	
	
	
}