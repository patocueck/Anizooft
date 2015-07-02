package cl.usm.tdsw.anizooft.utils;

public class AnizooftUtils {
	
	
	public String formatRut(long rut){
		
		String sRut = Long.toString(rut);
		String prim  = sRut.substring(0, sRut.length()-2);
		String sRutRet =  prim + sRut.substring(sRut.length()-2, sRut.length()-1);
		
		return sRutRet;
	}
	
	public static boolean esVacio(String valor){
		boolean resp = false;
		
		
		return resp;
	}
	
}
