package dwaki.convertcurrency.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dwaki.convertcurrency.service.ConvertCurrencyService;

@Controller
@RequestMapping("api")
public class ConvertCurrencyController {

	@Autowired
	private ConvertCurrencyService service;

	@RequestMapping(method = RequestMethod.POST, value = "convertCurrency", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> convertCurrency(@RequestBody Map<String, String> conversionDetails) {

		String countryCode = conversionDetails.get("countryCode");
		Double amount = Double.parseDouble(conversionDetails.get("amount"));
		Double convertedAmount = null;

		System.out.println("Country Code: " + countryCode + " Conversion Amount: " + amount);

		if (service.checkCurrencyCodeAvailability(countryCode)) {
			convertedAmount = service.convertAmount(countryCode, amount);
			return new ResponseEntity<String>(convertedAmount.toString(), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(countryCode + " Does Not Exists", HttpStatus.BAD_REQUEST);
		}

	}

}
