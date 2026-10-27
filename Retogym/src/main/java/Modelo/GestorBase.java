package Modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

public class GestorBase {
	
	
	private static final String ID_PROYECTO = "ciclosfp-62975";
	private static final String FICHERO_CREDENCIALES = "config.json";

	public static Firestore conectar() {
		System.setProperty("javax.net.ssl.trustStoreType", "Windows-ROOT");
		try {
			FileInputStream credenciales = new FileInputStream(FICHERO_CREDENCIALES);
			FirestoreOptions opciones = FirestoreOptions.getDefaultInstance().toBuilder().setProjectId(ID_PROYECTO)
					.setCredentials(GoogleCredentials.fromStream(credenciales)).build();
			return opciones.getService();
		} catch (IOException e) {

			e.printStackTrace();
		}

		return null;
	}
	public static boolean colectionLoging(String usuario,String contraseña) throws Exception {
		
		Firestore db = conectar();
		boolean encontrado=false;
	
		System.out.println("conectado");
		CollectionReference usuariosRef = db.collection("login");
		QuerySnapshot queryLogin = usuariosRef.whereEqualTo("Usuario",usuario).get().get();
		if(!queryLogin.isEmpty()) {
			QueryDocumentSnapshot info = queryLogin.getDocuments().get(0);
			String usuencontrado = info.getString("Usuario");
			String contaencontrado = info.getString("Pass");
			if(usuencontrado.equals(usuario)&&contaencontrado.equals(contraseña)) {
				return true;
			}
			
			return false;
			
		}
		
		db.close();
		return encontrado;
		
	}
	public static boolean validaRegistro(String nomRegistro, String apRegistro, String usuRegistro,
			String contraRegistro, String emailRegistro, String fechanaciRegistro) {
		Firestore db = conectar();
		 
		
		return false;
	}
}
