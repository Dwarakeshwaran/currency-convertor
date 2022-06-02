package managecurrency.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CurrencyDTO {

	private String countryCode;
	private Double conversionFactor;

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode.toUpperCase();
	}

}
