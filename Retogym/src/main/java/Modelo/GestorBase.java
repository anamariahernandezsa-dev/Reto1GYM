package Modelo;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.mockserver.formatting.StringFormatter;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.firestore.v1.Document;

public class GestorBase {
	
	private static Long IdPerfil;
	private static final String ID_PROYECTO = "ciclosfp-62975";
	private static final String FICHERO_CREDENCIALES = "config.json";
	private static QueryDocumentSnapshot infoDocument;
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
			IdPerfil=info.getLong("Id");
			if(usuencontrado.equals(usuario)&&contaencontrado.equals(contraseña)) {
				return true;
			}
			
			return false;
			
		}
		
		db.close();
		return encontrado;
		
	}
	public static boolean validaRegistro(String nomRegistro, String apRegistro, String usuRegistro,
			String contraRegistro, String emailRegistro, String fechanaciRegistro) throws InterruptedException, ExecutionException {
		Firestore db = conectar();
		CollectionReference usuario = db.collection("login");
		QuerySnapshot queryUltimoId = usuario.orderBy("Id", Query.Direction.DESCENDING).limit(1).get().get();
		long siguienteId =( queryUltimoId.getDocuments().get(0).getLong("Id"))+ 1;
		String nombre = String.format("usuario_%03d", siguienteId);
		Map<String,Object> userNuevo = new HashMap<>();
	
		
		userNuevo.put("Apellidos",apRegistro);
		userNuevo.put("Email",emailRegistro);
		userNuevo.put("FechaNac",fechanaciRegistro);
		userNuevo.put("Id", siguienteId);
		userNuevo.put("Nivel",0);
		userNuevo.put("Nombre",nomRegistro );
		userNuevo.put("Pass", contraRegistro);
		userNuevo.put("Usuario",usuRegistro );
		
		
		usuario.document(nombre).set(userNuevo).get();
		
		return false;
	}
	public static Usuario cargarperfil() throws InterruptedException, ExecutionException {
		Firestore db = conectar();
		CollectionReference perfil = db.collection("login");
		QuerySnapshot queryid = perfil.whereEqualTo("Id", IdPerfil).get().get();
		 infoDocument = queryid.getDocuments().get(0);
		Usuario usuario = new Usuario(infoDocument.getString("Nombre"),infoDocument.getString("Apellidos"),infoDocument.getString("Usuario"),infoDocument.getString("Pass"),
				infoDocument.getString("Email"),infoDocument.getString("FechaNac"));
		return usuario;
		
	}
	public static boolean modificar(String nomPerfil, String apePerfil, String usuPerfil, String contraPerfil,
			String emailPerfil, String fechanaciPerfil) throws InterruptedException, ExecutionException {
		Firestore dbFirestore = conectar();
		CollectionReference coleccion = dbFirestore.collection("login");
		String iddoc = infoDocument.getId();
		DocumentReference refusu = dbFirestore.collection("login").document(iddoc);
		Map<String, Object> cambios = new HashMap<>();
		cambios.put("Apellidos", apePerfil);
		cambios.put("Nombre", nomPerfil);
		cambios.put("Usuario", usuPerfil);
		cambios.put("Pass", contraPerfil);
		cambios.put("Email", emailPerfil);
		cambios.put("FechaNac",fechanaciPerfil);
		
		refusu.update(cambios).get();
		
		
		
		
		return false;
	}
	public static ArrayList<workout> cargarworkouts() throws InterruptedException, ExecutionException{
		
		Firestore db = conectar();
		ArrayList<workout> arrayRutinas = new ArrayList<workout>();
		
		workout Workout;;
		CollectionReference ref = db.collection("login");
		QuerySnapshot queryid = ref.whereEqualTo("Id", IdPerfil).get().get();
		infoDocument = queryid.getDocuments().get(0);
		 long nivel = infoDocument.getLong("Nivel");
		 
		ApiFuture<QuerySnapshot> query = db.collection("Workout").get();
		QuerySnapshot querySnapshot =  query.get();
		List<QueryDocumentSnapshot> rutina = querySnapshot.getDocuments();
		
			for(QueryDocumentSnapshot rutinas: rutina) {
				long rutinanivel = rutinas.getLong("Nivel");
				if ( nivel == rutinanivel) {
					Workout = new workout(rutinas.getString("Nombre"),rutinas.getString("Descripcion"),rutinas.getLong("Nivel"),rutinas.getString("URL"));
					arrayRutinas.add(Workout);
				}
				
			}
		
			return arrayRutinas;
		
	}
}
