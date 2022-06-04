package dwaki.convertcurrency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("api")
public class ConvertCurrencyController {

	@RequestMapping(method = RequestMethod.GET, value = "test")
	@ResponseBody
	public String test() {
		return "test";
	}

}
