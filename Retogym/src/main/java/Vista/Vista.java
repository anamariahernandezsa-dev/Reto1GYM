package Vista;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador;
import Modelo.Ejercicio;
import Modelo.Serie;
import Modelo.Usuario;
import Modelo.workout;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;

	// ── ContentPane ──────────────────────────────────────────────────────────
	private JPanel contentPane;

	// ── Panels ───────────────────────────────────────────────────────────────
	private JPanel panelLogin;
	private JPanel panelRegistro;
	private JPanel panelWorkouts;
	private JPanel panelEjercios;
	private JPanel panelPerfil;
	private JPanel panelEntrenamiento;

	// ── Login ────────────────────────────────────────────────────────────────
	private JTextField txtusuarioLogin;
	private JPasswordField txtCotraseñaLogin;
	private JLabel xtxnoencontrado;

	// ── Registro ─────────────────────────────────────────────────────────────
	private JButton btnregistrarse;

	// ── Perfil ───────────────────────────────────────────────────────────────
	private JTextField txtNombrePerfil;
	private JTextField txtApePerfil;
	private JTextField txtEmailPerfil;
	private JTextField txtFechaPerfil;
	private JTextField txtContraPerfil;
	private JTextField txtUsuPerfil;
	private JButton btnGuardar;

	// ── Workouts ─────────────────────────────────────────────────────────────
	private JTable tableWorkouts;
	private JComboBox<String> comboNivel;
	private ArrayList<workout> todosWorkouts = new ArrayList<>();
	private String NomWorkout;
	private String DecWorkout;

	// ── Ejercicios ───────────────────────────────────────────────────────────
	private JTable tableEjercicios;
	private JButton btncomenzareje;
	private String NomEjercicio;
	private String decEjercicios;

	// ── Entrenamiento ────────────────────────────────────────────────────────
	private JLabel txtTituloWorkout;
	private JLabel txtDescripcionWorkout;
	private JLabel txtTituloEjercicio;
	private JLabel txtDescripcionejercicio;
	private JLabel avisos;
	private JLabel lblTiempoTotal;
	private JPanel panelSeries;
	private JButton btnPausar;
	private JButton btnSiguiente;
	private Timer timer;
	private Timer timerTotal;
	private ArrayList<Serie> seriesActuales = new ArrayList<>();
	private ArrayList<JPanel> tarjetasSeries = new ArrayList<>();
	private int indiceSerie = 0;
	private int indiceEjercicio = 0;
	private int segundosRestantes = 0;
	private int segundosTotales = 0;
	private boolean enDescanso = false;
	private boolean pausado = false;

	// ─────────────────────────────────────────────────────────────────────────

	public static void main(String[] args) {
		EventQueue.invokeLater(() -> {
			try {
				Vista frame = new Vista();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
	}

	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		construirPanelLogin();
		construirPanelRegistro();
		construirPanelWorkouts();
		construirPanelEjercicios();
		construirPanelPerfil();
		construirPanelEntrenamiento();
	}

	// =========================================================================
	//  LOGIN
	// =========================================================================
	private void construirPanelLogin() {
		panelLogin = new JPanel();
		panelLogin.setLayout(null);
		contentPane.add(panelLogin, "login");

		JLabel lblTitulo = new JLabel("Login");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setBounds(400, 70, 120, 35);
		panelLogin.add(lblTitulo);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Arial", Font.PLAIN, 14));
		lblUsuario.setBounds(250, 170, 100, 20);
		panelLogin.add(lblUsuario);

		txtusuarioLogin = new JTextField(10);
		txtusuarioLogin.setBounds(370, 168, 260, 24);
		panelLogin.add(txtusuarioLogin);

		JLabel lblContra = new JLabel("Contraseña");
		lblContra.setFont(new Font("Arial", Font.PLAIN, 14));
		lblContra.setBounds(250, 230, 100, 20);
		panelLogin.add(lblContra);

		txtCotraseñaLogin = new JPasswordField();
		txtCotraseñaLogin.setBounds(370, 228, 260, 24);
		panelLogin.add(txtCotraseñaLogin);

		xtxnoencontrado = new JLabel("");
		xtxnoencontrado.setFont(new Font("Arial", Font.PLAIN, 14));
		xtxnoencontrado.setForeground(new Color(255, 0, 0));
		xtxnoencontrado.setBounds(370, 275, 260, 25);
		panelLogin.add(xtxnoencontrado);

		JButton btnLogin = new JButton("Iniciar sesión");
		btnLogin.setBounds(510, 330, 120, 28);
		panelLogin.add(btnLogin);
		btnLogin.addActionListener(e -> {
			try {
				boolean encontrado = Controlador.conectionloging(txtusuarioLogin.getText(),
						String.valueOf(txtCotraseñaLogin.getPassword()));
				if (encontrado) {
					Usuario perfil = Controlador.CargarUser();
					txtNombrePerfil.setText(perfil.getNombre());
					txtApePerfil.setText(perfil.getApellido());
					txtUsuPerfil.setText(perfil.getUsuario());
					txtContraPerfil.setText(perfil.getContraseña());
					txtEmailPerfil.setText(perfil.getEmail());
					txtFechaPerfil.setText(perfil.getFechaNaci());

					todosWorkouts = Controlador.mostarWorkouts();
					int indice = perfil.getNivel() + 1;
					if (indice < 1 || indice >= comboNivel.getItemCount()) {
						indice = 0;
					}
					comboNivel.setSelectedIndex(indice);
					filtrarWorkouts();

					txtusuarioLogin.setText("");
					txtCotraseñaLogin.setText("");
					xtxnoencontrado.setText("");
					mostrar(panelWorkouts);
				} else {
					xtxnoencontrado.setText("Usuario no encontrado");
				}
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});

		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.setBounds(370, 330, 120, 28);
		panelLogin.add(btnRegistro);
		btnRegistro.addActionListener(e -> {
			txtCotraseñaLogin.setText("");
			txtusuarioLogin.setText("");
			xtxnoencontrado.setText("");
			mostrar(panelRegistro);
		});
	}

	// =========================================================================
	//  REGISTRO
	// =========================================================================
	private void construirPanelRegistro() {
		panelRegistro = new JPanel();
		panelRegistro.setLayout(null);
		contentPane.add(panelRegistro, "registro");

		JButton btnAtras = new JButton("Atrás");
		btnAtras.setBounds(10, 11, 89, 23);
		panelRegistro.add(btnAtras);
		btnAtras.addActionListener(e -> {
			txtCotraseñaLogin.setText("");
			txtusuarioLogin.setText("");
			xtxnoencontrado.setText("");
			mostrar(panelLogin);
		});

		JLabel lblTitulo = new JLabel("Registro");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setBounds(390, 30, 150, 35);
		panelRegistro.add(lblTitulo);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(120, 133, 100, 20);
		panelRegistro.add(lblNombre);

		JTextField txtNombreRegistro = new JTextField(10);
		txtNombreRegistro.setBounds(230, 130, 200, 24);
		panelRegistro.add(txtNombreRegistro);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(120, 203, 100, 20);
		panelRegistro.add(lblApellido);

		JTextField txtApellidoRegistro = new JTextField(10);
		txtApellidoRegistro.setBounds(230, 200, 200, 24);
		panelRegistro.add(txtApellidoRegistro);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(120, 273, 100, 20);
		panelRegistro.add(lblEmail);

		JTextField txtEmailRegistro = new JTextField(10);
		txtEmailRegistro.setBounds(230, 270, 200, 24);
		panelRegistro.add(txtEmailRegistro);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(470, 133, 100, 20);
		panelRegistro.add(lblUsuario);

		JTextField txtUsuarioRegistro = new JTextField(10);
		txtUsuarioRegistro.setBounds(600, 130, 200, 24);
		panelRegistro.add(txtUsuarioRegistro);

		JLabel lblContra = new JLabel("Contraseña");
		lblContra.setBounds(470, 203, 100, 20);
		panelRegistro.add(lblContra);

		JPasswordField txtContraseñaRegistro = new JPasswordField();
		txtContraseñaRegistro.setBounds(600, 200, 200, 24);
		panelRegistro.add(txtContraseñaRegistro);

		JLabel lblFecha = new JLabel("Fecha nacimiento");
		lblFecha.setBounds(470, 273, 120, 20);
		panelRegistro.add(lblFecha);

		JTextField txtFechNaciRegistro = new JTextField(10);
		txtFechNaciRegistro.setBounds(600, 270, 200, 24);
		panelRegistro.add(txtFechNaciRegistro);

		btnregistrarse = new JButton("Registrarse");
		btnregistrarse.setBounds(390, 380, 120, 28);
		panelRegistro.add(btnregistrarse);
		btnregistrarse.addActionListener(e -> {
			comprobarDatosRegistro(txtNombreRegistro.getText(), txtApellidoRegistro.getText(),
					txtUsuarioRegistro.getText(), String.valueOf(txtContraseñaRegistro.getPassword()),
					txtEmailRegistro.getText(), txtFechNaciRegistro.getText());
			txtApellidoRegistro.setText("");
			txtContraseñaRegistro.setText("");
			txtEmailRegistro.setText("");
			txtFechNaciRegistro.setText("");
			txtNombreRegistro.setText("");
			txtUsuarioRegistro.setText("");
		});
	}

	// =========================================================================
	//  WORKOUTS
	// =========================================================================
	private void construirPanelWorkouts() {
		panelWorkouts = new JPanel();
		panelWorkouts.setLayout(null);
		contentPane.add(panelWorkouts, "workouts");

		JButton btnCerrarSesion = new JButton("Cerrar sesión");
		btnCerrarSesion.setBounds(10, 11, 130, 25);
		panelWorkouts.add(btnCerrarSesion);
		btnCerrarSesion.addActionListener(e -> mostrar(panelLogin));

		JLabel lblTitulo = new JLabel("Sesiones de Entrenamiento");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitulo.setBounds(280, 8, 300, 25);
		panelWorkouts.add(lblTitulo);

		comboNivel = new JComboBox<>(new DefaultComboBoxModel<>(
				new String[] { "Todos los niveles", "Nivel 0", "Nivel 1", "Nivel 2", "Nivel 3" }));
		comboNivel.setBounds(680, 10, 180, 26);
		comboNivel.addActionListener(e -> filtrarWorkouts());
		panelWorkouts.add(comboNivel);

		tableWorkouts = new JTable(new DefaultTableModel(new Object[][] {},
				new String[] { "Nivel", "Nombre", "Descripción", "Guía" }) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		tableWorkouts.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
		tableWorkouts.setRowHeight(60);
		tableWorkouts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableWorkouts.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() < 2)
					return;
				int fila = tableWorkouts.getSelectedRow();
				if (fila != -1) {
					NomWorkout = tableWorkouts.getValueAt(fila, 1).toString();
					DecWorkout = tableWorkouts.getValueAt(fila, 2).toString();
					cargarEjercicios(NomWorkout);
					btncomenzareje.setVisible(false);
					mostrar(panelEjercios);
				}
			}
		});

		JScrollPane scrollWorkouts = new JScrollPane(tableWorkouts);
		scrollWorkouts.setBounds(10, 45, 850, 420);
		panelWorkouts.add(scrollWorkouts);

		JLabel lblHint = new JLabel("Doble clic en una sesión para ver sus ejercicios");
		lblHint.setFont(new Font("Arial", Font.ITALIC, 12));
		lblHint.setBounds(10, 480, 400, 20);
		panelWorkouts.add(lblHint);

		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setBounds(760, 478, 100, 28);
		panelWorkouts.add(btnPerfil);
		btnPerfil.addActionListener(e -> mostrar(panelPerfil));
	}

	// =========================================================================
	//  EJERCICIOS
	// =========================================================================
	private void construirPanelEjercicios() {
		panelEjercios = new JPanel();
		panelEjercios.setLayout(null);
		contentPane.add(panelEjercios, "ejercicios");

		JButton btnAtras = new JButton("Atrás");
		btnAtras.setBounds(10, 11, 89, 23);
		panelEjercios.add(btnAtras);
		btnAtras.addActionListener(e -> mostrar(panelWorkouts));

		JLabel lblTitulo = new JLabel("Ejercicios");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
		lblTitulo.setBounds(400, 8, 150, 25);
		panelEjercios.add(lblTitulo);

		btncomenzareje = new JButton("Comenzar Entrenamiento");
		btncomenzareje.setBounds(640, 8, 220, 28);
		panelEjercios.add(btncomenzareje);
		btncomenzareje.addActionListener(e -> {
			mostrar(panelEntrenamiento);
			txtTituloWorkout.setText(NomWorkout);
			txtDescripcionWorkout.setText(DecWorkout);
			txtTituloEjercicio.setText(NomEjercicio);
			txtDescripcionejercicio.setText(decEjercicios);
			iniciarEntrenamiento();
		});

		tableEjercicios = new JTable(new DefaultTableModel(new Object[][] {},
				new String[] { "Ejercicio", "Descripción", "Duración" }) {
			private static final long serialVersionUID = 1L;

			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		});
		tableEjercicios.getTableHeader().setFont(new Font("Arial", Font.BOLD, 13));
		tableEjercicios.setRowHeight(60);
		tableEjercicios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tableEjercicios.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getClickCount() < 2)
					return;
				int fila = tableEjercicios.getSelectedRow();
				if (fila != -1) {
					NomEjercicio = tableEjercicios.getValueAt(fila, 0).toString();
					decEjercicios = tableEjercicios.getValueAt(fila, 1).toString();
					btncomenzareje.setVisible(true);
				}
			}
		});

		JScrollPane scrollEjercicios = new JScrollPane(tableEjercicios);
		scrollEjercicios.setBounds(10, 45, 850, 420);
		panelEjercios.add(scrollEjercicios);

		JLabel lblHint = new JLabel("Doble clic en un ejercicio para comenzar desde ahí");
		lblHint.setFont(new Font("Arial", Font.ITALIC, 12));
		lblHint.setBounds(10, 480, 400, 20);
		panelEjercios.add(lblHint);

		JButton btnPerfil = new JButton("Perfil");
		btnPerfil.setBounds(760, 478, 100, 28);
		panelEjercios.add(btnPerfil);
		btnPerfil.addActionListener(e -> mostrar(panelPerfil));
	}

	// =========================================================================
	//  PERFIL
	// =========================================================================
	private void construirPanelPerfil() {
		panelPerfil = new JPanel();
		panelPerfil.setLayout(null);
		contentPane.add(panelPerfil, "perfil");

		JButton btnAtras = new JButton("Atrás");
		btnAtras.setBounds(10, 11, 89, 23);
		panelPerfil.add(btnAtras);
		btnAtras.addActionListener(e -> {
			btnGuardar.setVisible(false);
			setPerfilEditable(false);
			mostrar(panelWorkouts);
		});

		JLabel lblTitulo = new JLabel("Perfil");
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 24));
		lblTitulo.setBounds(410, 30, 150, 35);
		panelPerfil.add(lblTitulo);

		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(120, 133, 100, 20);
		panelPerfil.add(lblNombre);

		txtNombrePerfil = new JTextField(10);
		txtNombrePerfil.setEditable(false);
		txtNombrePerfil.setBounds(230, 130, 200, 24);
		panelPerfil.add(txtNombrePerfil);

		JLabel lblApellido = new JLabel("Apellido");
		lblApellido.setBounds(120, 203, 100, 20);
		panelPerfil.add(lblApellido);

		txtApePerfil = new JTextField(10);
		txtApePerfil.setEditable(false);
		txtApePerfil.setBounds(230, 200, 200, 24);
		panelPerfil.add(txtApePerfil);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(120, 273, 100, 20);
		panelPerfil.add(lblEmail);

		txtEmailPerfil = new JTextField(10);
		txtEmailPerfil.setEditable(false);
		txtEmailPerfil.setBounds(230, 270, 200, 24);
		panelPerfil.add(txtEmailPerfil);

		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(470, 133, 100, 20);
		panelPerfil.add(lblUsuario);

		txtUsuPerfil = new JTextField(10);
		txtUsuPerfil.setEditable(false);
		txtUsuPerfil.setBounds(600, 130, 200, 24);
		panelPerfil.add(txtUsuPerfil);

		JLabel lblContra = new JLabel("Contraseña");
		lblContra.setBounds(470, 203, 100, 20);
		panelPerfil.add(lblContra);

		txtContraPerfil = new JTextField(10);
		txtContraPerfil.setEditable(false);
		txtContraPerfil.setBounds(600, 200, 200, 24);
		panelPerfil.add(txtContraPerfil);

		JLabel lblFecha = new JLabel("Fecha nacimiento");
		lblFecha.setBounds(470, 273, 120, 20);
		panelPerfil.add(lblFecha);

		txtFechaPerfil = new JTextField(10);
		txtFechaPerfil.setEditable(false);
		txtFechaPerfil.setBounds(600, 270, 200, 24);
		panelPerfil.add(txtFechaPerfil);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.setBounds(320, 380, 120, 28);
		panelPerfil.add(btnModificar);
		btnModificar.addActionListener(e -> {
			btnGuardar.setVisible(true);
			setPerfilEditable(true);
		});

		btnGuardar = new JButton("Guardar");
		btnGuardar.setVisible(false);
		btnGuardar.setBounds(460, 380, 120, 28);
		panelPerfil.add(btnGuardar);
		btnGuardar.addActionListener(e -> comprobarDatosPerfil(txtNombrePerfil.getText(), txtApePerfil.getText(),
				txtUsuPerfil.getText(), txtContraPerfil.getText(), txtEmailPerfil.getText(),
				txtFechaPerfil.getText()));
	}

	private void setPerfilEditable(boolean editable) {
		txtNombrePerfil.setEditable(editable);
		txtApePerfil.setEditable(editable);
		txtContraPerfil.setEditable(editable);
		txtEmailPerfil.setEditable(editable);
		txtFechaPerfil.setEditable(editable);
		txtUsuPerfil.setEditable(editable);
	}

	// =========================================================================
	//  ENTRENAMIENTO
	// =========================================================================
	private void construirPanelEntrenamiento() {
		panelEntrenamiento = new JPanel();
		panelEntrenamiento.setLayout(null);
		contentPane.add(panelEntrenamiento, "entrenamiento");

		// ── Cabecera ─────────────────────────────────────────────────────────
		JPanel panelCabecera = new JPanel();
		panelCabecera.setBorder(new LineBorder(new Color(128, 128, 128), 3, true));
		panelCabecera.setBackground(new Color(128, 128, 128));
		panelCabecera.setBounds(10, 11, 850, 150);
		panelCabecera.setLayout(null);
		panelEntrenamiento.add(panelCabecera);

		txtTituloWorkout = new JLabel(NomWorkout);
		txtTituloWorkout.setForeground(Color.WHITE);
		txtTituloWorkout.setFont(new Font("Arial", Font.BOLD, 36));
		txtTituloWorkout.setBounds(15, 10, 580, 50);
		panelCabecera.add(txtTituloWorkout);

		txtDescripcionWorkout = new JLabel("");
		txtDescripcionWorkout.setForeground(Color.WHITE);
		txtDescripcionWorkout.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDescripcionWorkout.setBounds(15, 65, 560, 70);
		panelCabecera.add(txtDescripcionWorkout);

		lblTiempoTotal = new JLabel("Tiempo total: 00:00");
		lblTiempoTotal.setForeground(Color.WHITE);
		lblTiempoTotal.setFont(new Font("Arial", Font.BOLD, 14));
		lblTiempoTotal.setBounds(640, 15, 190, 25);
		panelCabecera.add(lblTiempoTotal);

		timerTotal = new Timer(1000, e -> {
			segundosTotales++;
			actualizarTotal();
		});

		btnPausar = new JButton("Pausar");
		btnPausar.setFont(new Font("Arial", Font.BOLD, 11));
		btnPausar.setBackground(Color.WHITE);
		btnPausar.setForeground(new Color(0, 128, 0));
		btnPausar.setBounds(620, 70, 100, 28);
		panelCabecera.add(btnPausar);
		btnPausar.addActionListener(e -> pausarReanudar());

		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setFont(new Font("Arial", Font.BOLD, 11));
		btnSiguiente.setBackground(Color.WHITE);
		btnSiguiente.setForeground(new Color(0, 0, 255));
		btnSiguiente.setBounds(620, 105, 100, 28);
		panelCabecera.add(btnSiguiente);
		btnSiguiente.addActionListener(e -> siguienteSerie());

		JButton btnSalir = new JButton("Salir");
		btnSalir.setFont(new Font("Arial", Font.BOLD, 11));
		btnSalir.setBackground(Color.WHITE);
		btnSalir.setForeground(new Color(255, 0, 0));
		btnSalir.setBounds(735, 70, 100, 63);
		panelCabecera.add(btnSalir);
		btnSalir.addActionListener(e -> salirEntrenamiento());

		// ── Ejercicio actual ─────────────────────────────────────────────────
		JPanel panelEjercicioActual = new JPanel();
		panelEjercicioActual.setBackground(new Color(192, 192, 192));
		panelEjercicioActual.setBounds(10, 175, 850, 300);
		panelEjercicioActual.setLayout(null);
		panelEntrenamiento.add(panelEjercicioActual);

		txtTituloEjercicio = new JLabel("");
		txtTituloEjercicio.setForeground(Color.BLACK);
		txtTituloEjercicio.setFont(new Font("Arial", Font.BOLD, 20));
		txtTituloEjercicio.setBounds(22, 11, 600, 35);
		panelEjercicioActual.add(txtTituloEjercicio);

		txtDescripcionejercicio = new JLabel("");
		txtDescripcionejercicio.setForeground(Color.BLACK);
		txtDescripcionejercicio.setFont(new Font("Arial", Font.PLAIN, 12));
		txtDescripcionejercicio.setBounds(22, 46, 580, 40);
		panelEjercicioActual.add(txtDescripcionejercicio);

		timer = new Timer(1000, e -> tick());

		avisos = new JLabel("");
		avisos.setHorizontalAlignment(SwingConstants.CENTER);
		avisos.setFont(new Font("Arial", Font.BOLD, 14));
		avisos.setForeground(Color.BLACK);
		avisos.setBounds(640, 30, 190, 36);
		panelEjercicioActual.add(avisos);

		panelSeries = new JPanel();
		panelSeries.setLayout(new BoxLayout(panelSeries, BoxLayout.X_AXIS));
		JScrollPane scrollSeries = new JScrollPane(panelSeries, ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollSeries.setBounds(10, 100, 830, 165);
		panelEjercicioActual.add(scrollSeries);
	}

	// =========================================================================
	//  LÓGICA DE ENTRENAMIENTO
	// =========================================================================
	private void iniciarEntrenamiento() {
		indiceEjercicio = Math.max(tableEjercicios.getSelectedRow(), 0);
		segundosTotales = 0;
		actualizarTotal();
		timerTotal.restart();
		pausado = false;
		enDescanso = false;
		btnPausar.setText("Pausar");
		cargarSeries(NomEjercicio);
		indiceSerie = 0;
		iniciarSerie();
	}

	private void iniciarSerie() {
		timer.stop();
		if (indiceSerie >= seriesActuales.size()) {
			terminarEjercicio();
			return;
		}
		enDescanso = false;
		Serie s = seriesActuales.get(indiceSerie);
		segundosRestantes = s.getDuracion() != null ? s.getDuracion().intValue() : 0;
		resaltarSerie();
		actualizarAviso();
		if (segundosRestantes > 0 && !pausado) {
			timer.start();
		}
	}

	private void tick() {
		segundosRestantes--;
		actualizarAviso();
		if (segundosRestantes <= 0) {
			timer.stop();
			if (enDescanso) {
				cargarEjercicioActual();
			} else {
				indiceSerie++;
				iniciarSerie();
			}
		}
	}

	private void pausarReanudar() {
		if (pausado) {
			pausado = false;
			btnPausar.setText("Pausar");
			timerTotal.start();
			if (segundosRestantes > 0) {
				timer.start();
			}
		} else {
			pausado = true;
			btnPausar.setText("Reanudar");
			timerTotal.stop();
			timer.stop();
		}
	}

	private void siguienteSerie() {
		if (enDescanso) {
			timer.stop();
			cargarEjercicioActual();
		} else {
			indiceSerie++;
			iniciarSerie();
		}
	}

	private void terminarEjercicio() {
		int descanso = 0;
		Object d = tableEjercicios.getValueAt(indiceEjercicio, 2);
		if (d instanceof Number) {
			descanso = ((Number) d).intValue();
		}
		indiceEjercicio++;
		if (indiceEjercicio >= tableEjercicios.getRowCount()) {
			finalizarEntrenamiento(true);
			return;
		}
		if (descanso <= 0) {
			cargarEjercicioActual();
			return;
		}
		enDescanso = true;
		segundosRestantes = descanso;
		actualizarAviso();
		if (!pausado) {
			timer.start();
		}
	}

	private void cargarEjercicioActual() {
		tableEjercicios.setRowSelectionInterval(indiceEjercicio, indiceEjercicio);
		NomEjercicio = String.valueOf(tableEjercicios.getValueAt(indiceEjercicio, 0));
		decEjercicios = String.valueOf(tableEjercicios.getValueAt(indiceEjercicio, 1));
		txtTituloEjercicio.setText(NomEjercicio);
		txtDescripcionejercicio.setText(decEjercicios);
		cargarSeries(NomEjercicio);
		indiceSerie = 0;
		iniciarSerie();
	}

	private void salirEntrenamiento() {
		boolean corriendo = timer.isRunning();
		boolean totalCorriendo = timerTotal.isRunning();
		timerTotal.stop();
		timer.stop();
		int r = JOptionPane.showConfirmDialog(panelEntrenamiento, "¿Salir del entrenamiento?", "Salir",
				JOptionPane.YES_NO_OPTION);
		if (r == JOptionPane.YES_OPTION) {
			finalizarEntrenamiento(false);
		} else {
			if (corriendo) {
				timer.start();
			}
			if (totalCorriendo) {
				timerTotal.start();
			}
		}
	}

	private void finalizarEntrenamiento(boolean completado) {
		timer.stop();
		timerTotal.stop();
		pausado = false;
		enDescanso = false;
		btnPausar.setText("Pausar");
		avisos.setText("");
		mostrar(panelWorkouts);
		if (completado) {
			JOptionPane.showMessageDialog(panelWorkouts, "Entrenamiento completado", "",
					JOptionPane.INFORMATION_MESSAGE);
		}
	}

	private void resaltarSerie() {
		for (int i = 0; i < tarjetasSeries.size(); i++) {
			JPanel t = tarjetasSeries.get(i);
			if (i == indiceSerie) {
				t.setBorder(new LineBorder(Color.BLUE, 3));
				SwingUtilities.invokeLater(() -> panelSeries.scrollRectToVisible(t.getBounds()));
			} else {
				t.setBorder(new LineBorder(Color.LIGHT_GRAY));
			}
		}
	}

	private void actualizarTotal() {
		lblTiempoTotal.setText(String.format("Tiempo total: %02d:%02d", segundosTotales / 60, segundosTotales % 60));
	}

	private void actualizarAviso() {
		if (enDescanso) {
			avisos.setText("Descanso: " + segundosRestantes + "s");
		} else if (segundosRestantes > 0) {
			avisos.setText("Serie " + (indiceSerie + 1) + "/" + seriesActuales.size() + " · " + segundosRestantes + "s");
		} else {
			avisos.setText("Serie " + (indiceSerie + 1) + "/" + seriesActuales.size());
		}
	}

	// =========================================================================
	//  CARGA DE DATOS
	// =========================================================================
	private void filtrarWorkouts() {
		int seleccion = comboNivel.getSelectedIndex();
		DefaultTableModel modelo = (DefaultTableModel) tableWorkouts.getModel();
		modelo.setRowCount(0);
		for (workout w : todosWorkouts) {
			if (seleccion == 0 || w.getNivel() == seleccion - 1) {
				modelo.addRow(new Object[] { w.getNivel(), w.getNombre(), w.getDecripcion(), w.getUrl() });
			}
		}
	}

	public void cargarEjercicios(String nomworkout) {
		try {
			ArrayList<Ejercicio> arrayEjercicio = Controlador.mostarEjercicios(nomworkout);
			DefaultTableModel modelo = (DefaultTableModel) tableEjercicios.getModel();
			modelo.setRowCount(0);
			for (Ejercicio E : arrayEjercicio) {
				modelo.addRow(new Object[] { E.getNombre(), E.getDescripcion(), E.getTiempoDescando() });
			}
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	public void cargarSeries(String nomeje) {
		try {
			ArrayList<Serie> arrayseries = Controlador.mostarseries(nomeje);
			panelSeries.removeAll();
			seriesActuales = arrayseries;
			tarjetasSeries.clear();
			for (Serie Series : arrayseries) {
				JPanel tarjeta = crearTarjetaSerie(Series);
				tarjetasSeries.add(tarjeta);
				panelSeries.add(tarjeta);
				panelSeries.add(Box.createHorizontalStrut(10));
			}
			panelSeries.revalidate();
			panelSeries.repaint();
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	private JPanel crearTarjetaSerie(Serie series) {
		JPanel card = new JPanel(new BorderLayout());
		card.setPreferredSize(new Dimension(150, 118));
		card.setMaximumSize(new Dimension(150, 118));
		card.setBorder(new LineBorder(Color.LIGHT_GRAY));

		JLabel img = new JLabel("", SwingConstants.CENTER);
		ImageIcon imagenIcon = new ImageIcon(series.getFoto());
		Image escalada = imagenIcon.getImage().getScaledInstance(140, 55, Image.SCALE_SMOOTH);
		img.setIcon(new ImageIcon(escalada));

		JPanel pie = new JPanel(new GridLayout(3, 1));
		JLabel nombre = new JLabel(series.getNombre());
		nombre.setFont(new Font("Arial", Font.BOLD, 12));
		pie.add(nombre);
		pie.add(new JLabel("Duracion: " + series.getDuracion() + "s"));
		pie.add(new JLabel("Nº repeticiones: " + series.getnRepeticiones()));
		card.add(img, BorderLayout.CENTER);
		card.add(pie, BorderLayout.SOUTH);

		return card;
	}

	// =========================================================================
	//  VALIDACIÓN PERFIL
	// =========================================================================
	public void comprobarDatosPerfil(String nomPerfil, String apePerfil, String usuPerfil, String contraPerfil,
			String emailPerfil, String fechanaciPerfil) {
		boolean correcto = true;
		StringBuilder errores = new StringBuilder();
		if (usuPerfil.isEmpty()) {
			errores.append("El usuario no puede estar vacío.\n");
			correcto = false;
		}
		if (usuPerfil.length() > 30) {
			errores.append("El usuario no puede tener más de 30 caracteres.\n");
			correcto = false;
		}
		if (contraPerfil.isEmpty()) {
			errores.append("La contraseña no puede estar vacía.\n");
			correcto = false;
		}
		if (nomPerfil.isEmpty()) {
			errores.append("El nombre no puede estar vacío.\n");
			correcto = false;
		}
		if (nomPerfil.length() > 30) {
			errores.append("El nombre no puede tener más de 30 caracteres.\n");
			correcto = false;
		}
		if (apePerfil.isEmpty()) {
			errores.append("Los apellidos no pueden estar vacíos.\n");
			correcto = false;
		}
		if (apePerfil.length() > 70) {
			errores.append("Los apellidos no pueden tener más de 70 caracteres.\n");
			correcto = false;
		}
		if (fechanaciPerfil == null || fechanaciPerfil.isEmpty()) {
			errores.append("La fecha de nacimiento no puede estar vacía.\n");
			correcto = false;
		}
		if (emailPerfil.isEmpty()) {
			errores.append("El email no puede estar vacio. \n");
			correcto = false;
		}
		if (!emailPerfil.contains("@")) {
			errores.append("El email debe de contener un @");
			correcto = false;
		}

		if (!correcto) {
			JOptionPane.showMessageDialog(btnGuardar, errores.toString(), "Errores de validación",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		try {
			Controlador.modificar(nomPerfil, apePerfil, usuPerfil, contraPerfil, emailPerfil, fechanaciPerfil);
			JOptionPane.showMessageDialog(btnGuardar, "Se han modificado los datos", "",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	// =========================================================================
	//  VALIDACIÓN REGISTRO
	// =========================================================================
	public void comprobarDatosRegistro(String nomRegistro, String apRegistro, String usuRegistro,
			String contraRegistro, String emailRegistro, String fechanaciRegistro) {
		boolean correcto = true;
		StringBuilder errores = new StringBuilder();
		if (usuRegistro.isEmpty()) {
			errores.append("El usuario no puede estar vacío.\n");
			correcto = false;
		}
		if (usuRegistro.length() > 30) {
			errores.append("El usuario no puede tener más de 30 caracteres.\n");
			correcto = false;
		}
		if (contraRegistro.isEmpty()) {
			errores.append("La contraseña no puede estar vacía.\n");
			correcto = false;
		}
		if (nomRegistro.isEmpty()) {
			errores.append("El nombre no puede estar vacío.\n");
			correcto = false;
		}
		if (nomRegistro.length() > 30) {
			errores.append("El nombre no puede tener más de 30 caracteres.\n");
			correcto = false;
		}
		if (apRegistro.isEmpty()) {
			errores.append("Los apellidos no pueden estar vacíos.\n");
			correcto = false;
		}
		if (apRegistro.length() > 70) {
			errores.append("Los apellidos no pueden tener más de 70 caracteres.\n");
			correcto = false;
		}
		if (fechanaciRegistro == null || fechanaciRegistro.isEmpty()) {
			errores.append("La fecha de nacimiento no puede estar vacía.\n");
			correcto = false;
		}
		if (emailRegistro.isEmpty()) {
			errores.append("El email no puede estar vacio. \n");
			correcto = false;
		}
		if (!emailRegistro.contains("@")) {
			errores.append("El email debe de contener un @");
			correcto = false;
		}

		if (!correcto) {
			JOptionPane.showMessageDialog(btnregistrarse, errores.toString(), "Errores de validación",
					JOptionPane.WARNING_MESSAGE);
			return;
		}

		try {
			Controlador.recogeRegistro(nomRegistro, apRegistro, usuRegistro, contraRegistro, emailRegistro,
					fechanaciRegistro);
			JOptionPane.showMessageDialog(btnregistrarse, "Te has registrado correctamente", "",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (InterruptedException | ExecutionException e) {
			e.printStackTrace();
		}
	}

	// =========================================================================
	//  UTILIDADES
	// =========================================================================

	/** Muestra el panel indicado y oculta todos los demás. */
	private void mostrar(JPanel panelObjetivo) {
		JPanel[] todos = { panelLogin, panelRegistro, panelWorkouts, panelEjercios, panelPerfil,
				panelEntrenamiento };
		for (JPanel p : todos)
			if (p != null)
				p.setVisible(false);
		panelObjetivo.setVisible(true);
	}
}