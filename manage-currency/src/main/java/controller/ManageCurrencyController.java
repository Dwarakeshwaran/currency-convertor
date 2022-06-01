package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ManageCurrencyController {
	
	
	@RequestMapping(method = RequestMethod.GET, path = "/test")
	@ResponseBody
	public String test() {
		return "test";
	}

}
