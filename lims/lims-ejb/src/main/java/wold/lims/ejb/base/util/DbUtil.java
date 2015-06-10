package wold.lims.ejb.base.util;

import java.util.StringTokenizer;

public class DbUtil {

	public static String getFullTextQuery(String suchfeld) {
		return getPostgresTsQuery(suchfeld);
	}

	public static String getPostgresTsQuery(String suchfeld) {
		if (suchfeld == null || suchfeld.length() == 0)
			return "";
		StringTokenizer token = new StringTokenizer(suchfeld, " ");
		StringBuffer buffer = new StringBuffer();
		String app = new String();
		while (token.hasMoreElements()) {
			buffer.append(app);
			buffer.append(token.nextElement()).append(":*");
			app = " & ";
		}
		return buffer.toString();
	}

}
