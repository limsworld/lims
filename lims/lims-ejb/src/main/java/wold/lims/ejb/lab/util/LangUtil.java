package wold.lims.ejb.lab.util;

import org.json.JSONObject;

import wold.lims.ejb.lab.enums.LangEnum;

public class LangUtil {

	public static String value(String lang, String json) {
		if (lang.endsWith(LangEnum.en.name())) {
			return new JSONObject(json).getJSONArray("lang").getJSONObject(0).optString("label");
		}
		if (lang.endsWith(LangEnum.de.name())) {
			return new JSONObject(json).getJSONArray("lang").getJSONObject(1).optString("label");
		}
		return "error label";
	}
	
}
