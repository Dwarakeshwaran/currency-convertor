package dwaki.convertcurrencyboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "inr")
public class Currency {

	@Id
	@Column(name = "country_code")
	private String countryCode;
	@Column(name = "conversion_factor")
	private Double conversionFactor;

}