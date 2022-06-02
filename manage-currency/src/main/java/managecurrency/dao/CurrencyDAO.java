package managecurrency.dao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CurrencyDAO {
	
	private String countryCode;
	private int conversionFactor;

}
