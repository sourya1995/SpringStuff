package io.datajek.springmvc;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PlayerController {
	
	@Autowired
	PlayerService service;
	
	@RequestMapping("/showPlayerForm")
	public String showForm() {
		return "search-player-form";
	}
	
	@RequestMapping("/processPlayerForm")
	public String processForm(@RequestParam("playerName") String pName, Model model) {
		
		Player player = service.getPlayerByName(pName);
		model.addAttribute("name", pName);
		model.addAttribute("country", player.getNationality());
		model.addAttribute("dob", player.getBirthDate());
		model.addAttribute("titles", player.getTitles());
		return "player-detail";
	}

}
