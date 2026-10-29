package Controlador;

import java.util.concurrent.ExecutionException;

import javax.swing.JTextField;

import Modelo.GestorBase;
import Modelo.Usuario;

public class Controlador {
	
	public static boolean conectionloging(String usuario , String contraseña) throws Exception {
		return GestorBase.colectionLoging(usuario, contraseña);
		
		
	}

	public static boolean recogeRegistro(String nomRegistro, String apRegistro, String usuRegistro, String contraRegistro, String emailRegistro,
			String fechanaciRegistro) throws InterruptedException, ExecutionException {
		
		return GestorBase.validaRegistro(nomRegistro,apRegistro,usuRegistro,contraRegistro,emailRegistro,fechanaciRegistro);
	}

	public static Usuario CargarUser() throws InterruptedException, ExecutionException {
		
		return GestorBase.cargarperfil();
	}

	public static boolean modificar(String nomPerfil, String apePerfil, String usuPerfil, String contraPerfil,
			String emailPerfil, String fechanaciPerfil) throws InterruptedException, ExecutionException {
		
		return  GestorBase.modificar( nomPerfil,  apePerfil,  usuPerfil,  contraPerfil,
				 emailPerfil,  fechanaciPerfil);
	}
}
