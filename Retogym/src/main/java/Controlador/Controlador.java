package Controlador;

import Modelo.GestorBase;

public class Controlador {
	
	public static boolean conectionloging(String usuario , String contraseña) throws Exception {
		return GestorBase.colectionLoging(usuario, contraseña);
		
		
	}

	public static boolean recogeRegistro(String nomRegistro, String apRegistro, String usuRegistro, String contraRegistro, String emailRegistro,
			String fechanaciRegistro) {
		
		return GestorBase.validaRegistro(nomRegistro,apRegistro,usuRegistro,contraRegistro,emailRegistro,fechanaciRegistro);
	}
}
