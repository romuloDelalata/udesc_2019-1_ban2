package helpers;

import java.util.Date;

public class DateSqlHelper {

	public static String toDateSql(Date date) {
		return new java.sql.Date(date.getTime()).toString();
	}

	public static Date toDate(java.sql.Date date) {
		return new Date(date.getTime());
	}
}
