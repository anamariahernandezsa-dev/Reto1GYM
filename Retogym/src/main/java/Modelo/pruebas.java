package Modelo;

import java.io.FileInputStream;
import java.io.IOException;
import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import java.util.List;

public class pruebas {

//	private static final String ID_PROYECTO = "reto13a";
//	private static final String FICHERO_CREDENCIALES = "config.json";
	
	private static final String ID_PROYECTO = "ciclosfp-62975";
	private static final String FICHERO_CREDENCIALES = "config.json";

	public static void main(String[] args) {

		try {
			Firestore db = conectar();
			System.out.println("conectado");
			
			ApiFuture<QuerySnapshot> query = db.collection("login").get();
			CollectionReference usuariosRef = db.collection("login");
			QuerySnapshot queryLogin = usuariosRef.whereEqualTo("Apellidos", "balatrez").get().get();
			System.out.println(queryLogin.getDocuments());
			QuerySnapshot querySnapshot = query.get();  
			List<QueryDocumentSnapshot> usuario = querySnapshot.getDocuments();
			for(QueryDocumentSnapshot usuarios : usuario) {
				System.out.println(usuarios.getId());
				
			}
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
