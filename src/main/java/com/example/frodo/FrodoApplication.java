package com.example.frodo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@SpringBootApplication
public class FrodoApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrodoApplication.class, args);
	}

}
@Controller
public class HomeController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {	
		HttpServletRequest req = ((ServletRequestAttributes)RequestContextHolder.currentRequestAttributes()).getRequest();
		String ip = req.getHeader("X-FORWARDED-FOR");
		if (ip == null)
			ip = req.getRemoteAddr();
		
		model.addAttribute("clientIP", ip);
		return "home";
	}
}