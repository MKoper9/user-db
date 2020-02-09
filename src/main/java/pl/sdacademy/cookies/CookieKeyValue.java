package pl.sdacademy.cookies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CookieKeyValue {

	private String name;
	private String value;
}