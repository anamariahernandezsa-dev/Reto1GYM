package Modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
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
	public static Firestore colectionLoging() throws Exception {
		Firestore db = conectar();
		System.out.println("conectado");
		
		ApiFuture<QuerySnapshot> query = db.collection("login").get();
		QuerySnapshot querySnapshot = query.get();  
		List<QueryDocumentSnapshot> usuario = querySnapshot.getDocuments();
		for(QueryDocumentSnapshot usuarios : usuario) {
			System.out.println(usuarios.getId());
		}
		db.close();
		
		return null;
		
	}
}
