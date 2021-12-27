package ng.community.application.restController;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class DefaultUrlController {
@RequestMapping({"registration","info","consultation"})
	public String index() {
		
		return "index";
	}
}
