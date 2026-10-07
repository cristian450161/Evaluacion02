package util;

public class ValidateUtil {

	public static final String DNI = "\\d{8}";
	public static final String RUC = "\\d{11}";
	public static final String PLACA_AUTO = "[A-Z]{3}[0-9]{3}";
	public static final String TEXTO_30 = "[A-Za-z áéióúÁÉÍÓÚñÑüÜ]{1,30}";
	public static final String TEXTO_40 = "[A-Za-z áéióúÁÉÍÓÚñÑüÜ]{1,40}";
	public static final String EMAIL = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	public static final String DATE_YYYY_MM_DD ="((19|20)\\d\\d)-(0?[1-9]|1[012])-(0?[1-9]|[12][0-9]|3[01])";
	public static final String ENTERO_MAS_UN_DIGITO = "\\d+";
	public static final String REAL_CON_O_SIN_DECIMALES = "\\d+(\\.\\d{1,2})?";
	
	public static final String NOMBRE = "^[A-Za-z áéióúÁÉÍÓÚñÑüÜ]{1,30}$";
	public static final String DESCRIPCION = "^[A-Za-z0-9 áéióúÁÉÍÓÚñÑüÜ.,-]{1,200}$";
	public static final String PRECIO = "^\\d+(\\.\\d{1,2})?$";
	public static final String STOCK = "^[0-9]+$";
	public static final String FECHA = "^((19|20)\\d\\d-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01])|(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/(19|20)\\d\\d)$";
	public static final String CORREO = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"; // Corregido dominio final (.com, .net);

	
	
}