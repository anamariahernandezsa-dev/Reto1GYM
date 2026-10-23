package Modelo;

import java.io.FileInputStream;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;

public class DatosFirebase {

	private static final String ID_PROYECTO = "gimnasio-9879c";
	private static final String FICHERO_CREDENCIALES = "gimnasio.json";

	public static void main(String[] args) {

		try {
			Firestore db = conectar();
			System.out.println("conectado");
			db.close();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

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
}
