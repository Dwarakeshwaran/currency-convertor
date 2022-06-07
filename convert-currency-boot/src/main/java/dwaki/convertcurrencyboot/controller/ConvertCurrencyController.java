package dwaki.convertcurrencyboot.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dwaki.convertcurrencyboot.service.ConvertCurrencyService;

@Controller
@RequestMapping("convert-currency-boot/api")
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

	@RequestMapping(method = RequestMethod.POST, value = "inverseConversion", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> inverseConversion(@RequestBody Map<String, String> conversionDetails) {

		String countryCode = conversionDetails.get("countryCode");
		Double amount = Double.parseDouble(conversionDetails.get("amount"));
		Double conversionInvertedAmount = null;

		System.out.println("Country Code: " + countryCode + " Conversion Amount: " + amount);

		if (service.checkCurrencyCodeAvailability(countryCode)) {
			conversionInvertedAmount = service.inverseConversion(countryCode, amount);
			return new ResponseEntity<String>(conversionInvertedAmount.toString(), HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(countryCode + " Does Not Exists", HttpStatus.BAD_REQUEST);
		}

	}

}
