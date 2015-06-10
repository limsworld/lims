package wold.lims.ejb.base.util;

public class Wilcard {

	public static final String get(String value) {
		if (value == null || value.length() == 0)
			return "";
		return "%" + value + "%";
	}

}
