package br.edu.pii.tecaplay.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UtilData {
	public class DataUtil {
		public static final String FORMATO_DATA_HORA = "dd/MM/yyyy HH:mm:ss";

		public String convertDateToString(Date dataHora) {
			String strDatahora = new SimpleDateFormat(FORMATO_DATA_HORA).format(dataHora);
			return strDatahora;
		}
	}
}