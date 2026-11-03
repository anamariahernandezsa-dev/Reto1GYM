package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import static org.junit.Assert.assertTrue;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador;
import Modelo.Ejercicio;
import Modelo.Serie;
import Modelo.Usuario;
import Modelo.workout;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ExecutionException;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.JScrollBar;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtusuarioLogin;
	private JTextField txtCotraseñaLogin;
	private JTable tableWorkouts;
	private JTable tableEjercicios;
	private JLabel xtxnoencontrado;
	private JPanel panelLogin;
	private JPanel panelRegistro;
	private JPanel panelWorkouts;
	private JPanel panelEjercios;
	private JButton btnregistrarse;
	private JTextField txtNombrePerfil;
	private JTextField txtApePerfil;
	private JTextField txtEmailPerfil;
	private JTextField txtFechaPerfil;
	private JTextField txtContraPerfil;
	private JTextField txtUsuPerfil;
	private JPanel panelPerfil;
	private JButton btnGuardar;
	private JPanel panelEntrenamiento;
	private JLabel txtTituloWorkout;
	private JLabel txtDescripcionWorkout;
	private JLabel txtTituloEjercicio;
	private JLabel txtDescripcionejercicio;
	private JLabel avisos;
	private String NomWorkout;
	private String DecWorkout;
	private String NomEjercicio;
	private String decEjercicios;
	private JButton btncomenzareje;
	private JPanel panelSeries;
	private JPanel panel_1;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vista frame = new Vista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Vista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 628, 469);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));

		panelLogin = new JPanel();
		contentPane.add(panelLogin, "name_84904836361500");
		panelLogin.setLayout(null);

		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(108, 152, 81, 14);
		panelLogin.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(108, 226, 81, 14);
		panelLogin.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(255, 51, 110, 46);
		panelLogin.add(lblNewLabel_2);

		txtusuarioLogin = new JTextField();
		txtusuarioLogin.setBounds(247, 149, 243, 20);
		panelLogin.add(txtusuarioLogin);
		txtusuarioLogin.setColumns(10);

		txtCotraseñaLogin = new JTextField();
		txtCotraseñaLogin.setBounds(247, 223, 243, 20);
		panelLogin.add(txtCotraseñaLogin);
		txtCotraseñaLogin.setColumns(10);

		JButton btniniciosecion = new JButton("Iniciar sesion");
		btniniciosecion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean encontrado = Controlador.conectionloging(txtusuarioLogin.getText(),
							txtCotraseñaLogin.getText());
					if (encontrado == true) {
						Usuario perfil = Controlador.CargarUser();
						txtNombrePerfil.setText(perfil.getNombre());
						txtApePerfil.setText(perfil.getApellido());
						txtUsuPerfil.setText(perfil.getUsuario());
						txtContraPerfil.setText(perfil.getContraseña());
						txtEmailPerfil.setText(perfil.getEmail());
						txtFechaPerfil.setText(perfil.getFechaNaci());
						ArrayList<workout> arrayworkouts = Controlador.mostarWorkouts();
						cargartablaworkouts(arrayworkouts); 
						txtusuarioLogin.setText("");
						txtCotraseñaLogin.setText("");

						panelLogin.setVisible(false);
						panelWorkouts.setVisible(true);
						xtxnoencontrado.setText("");
						
					

					} else {
						xtxnoencontrado.setText("Usuario no encontrado");
					}
				
				} catch (Exception e1) {

					e1.printStackTrace();
				}
			}

			private void cargartablaworkouts(ArrayList<workout> arrayworkouts) {
				//TABLA DE LOS WORKOUT--------------------------------------
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(20, 61, 560, 245);
				panelWorkouts.add(scrollPane);
				
				tableWorkouts = new JTable();
				
				scrollPane.setViewportView(tableWorkouts);
				tableWorkouts.setModel(new DefaultTableModel(
						new Object[][] {},
						new String[] {"Nivel","Nombre","Descripcion","Guia"}
						) {
					@Override
				    public boolean isCellEditable(int row, int column) {
				        return false;
				    }
					
					});
				tableWorkouts.setRowHeight(60);
				scrollPane.setViewportView(tableWorkouts);
				DefaultTableModel modelo = (DefaultTableModel) tableWorkouts.getModel();
				
				
				modelo.setRowCount(0);
				for(workout w :arrayworkouts ) {
					modelo.addRow(new Object[] {
							w.getNivel(),
							w.getNombre(),
							w.getDecripcion(),
							w.getUrl()
					});
					
				}
				tableWorkouts.addMouseListener(new MouseAdapter() {
					@Override
					public void mousePressed(MouseEvent e) {
						if(e.getClickCount() < 2) return;
						int lineaSeleccionada = tableWorkouts.getSelectedRow();
						if(lineaSeleccionada != - 1) {
							Object nombrerutina = tableWorkouts.getValueAt(lineaSeleccionada,1);
							Object decs = tableWorkouts.getValueAt(lineaSeleccionada, 2);
							NomWorkout = nombrerutina.toString();
							DecWorkout = decs.toString();
							cargarEjercicios(NomWorkout);
							panelWorkouts.setVisible(false);
							panelEjercios.setVisible(true);
							btncomenzareje.setVisible(false);
							
						}
						
					}

					
				});
				
				
			}
			public void cargarEjercicios(String nomworkout) {
				try {
					ArrayList<Ejercicio> arrayEjercicio = Controlador.mostarEjercicios(nomworkout);
					//TABLA DE LOS Ejercicios--------------------------------------
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(20, 61, 560, 245);
					panelEjercios.add(scrollPane);
					
					tableEjercicios = new JTable();
					scrollPane.setViewportView(tableEjercicios);
					tableEjercicios.setModel(new DefaultTableModel(
							new Object[][] {},
							new String[] {"Ejercicio","Descripcion","Duracion"}
							) {
						 @Override
						    public boolean isCellEditable(int row, int column) {
						        return false;
						    } 
						
							});
					tableEjercicios.setRowHeight(60);
					scrollPane.setViewportView(tableEjercicios);
					DefaultTableModel modelo = (DefaultTableModel) tableEjercicios.getModel();
					modelo.setRowCount(0);
					for(Ejercicio E :arrayEjercicio ) {
						modelo.addRow(new Object[] {
								E.getNombre(),
								E.getDescripcion(),
								E.getTiempoDescando(),
							
						});
						
					}
					tableEjercicios.addMouseListener(new MouseAdapter() {
						@Override
						public void mousePressed(MouseEvent e) {
							if(e.getClickCount() < 2) return;
							int lineaSeleccionada = tableEjercicios.getSelectedRow();
							if(lineaSeleccionada != - 1) {
								
								Object nombreejer = tableEjercicios.getValueAt(lineaSeleccionada,0);
								Object decs = tableEjercicios.getValueAt(lineaSeleccionada, 1);
								NomEjercicio = nombreejer.toString();
								decEjercicios = decs.toString();
								btncomenzareje.setVisible(true);
								
								
							}
							
						}

						
					});
					
				} catch (InterruptedException e) {
					e.printStackTrace();
				} catch (ExecutionException e) {
					e.printStackTrace();
				}
				
			}
		
		});
		btniniciosecion.setBounds(350, 341, 110, 23);
		panelLogin.add(btniniciosecion);

		JButton btnregistro = new JButton("Registrarse");
		btnregistro.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				txtCotraseñaLogin.setText("");
				txtusuarioLogin.setText("");
				panelLogin.setVisible(false);
				panelRegistro.setVisible(true);
			}
		});
		btnregistro.setBounds(132, 341, 117, 23);
		panelLogin.add(btnregistro);

		xtxnoencontrado = new JLabel("");
		xtxnoencontrado.setFont(new Font("Arial", Font.PLAIN, 15));
		xtxnoencontrado.setForeground(new Color(255, 0, 0));
		xtxnoencontrado.setBounds(230, 278, 188, 30);
		panelLogin.add(xtxnoencontrado);

		panelRegistro = new JPanel();
		contentPane.add(panelRegistro, "name_85225128619600");
		panelRegistro.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setBounds(24, 141, 46, 14);
		panelRegistro.add(lblNewLabel_3);

		JTextField txtNombreRegistro = new JTextField();
		txtNombreRegistro.setBounds(109, 138, 181, 20);
		panelRegistro.add(txtNombreRegistro);
		txtNombreRegistro.setColumns(10);

		JTextField txtApellidoRegistro = new JTextField();
		txtApellidoRegistro.setBounds(109, 211, 181, 20);
		panelRegistro.add(txtApellidoRegistro);
		txtApellidoRegistro.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Apellido");
		lblNewLabel_4.setBounds(24, 214, 46, 14);
		panelRegistro.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setBounds(24, 288, 46, 14);
		panelRegistro.add(lblNewLabel_5);

		JTextField txtEmailRegistro = new JTextField();
		txtEmailRegistro.setBounds(109, 285, 181, 20);
		panelRegistro.add(txtEmailRegistro);
		txtEmailRegistro.setColumns(10);

		JTextField txtFechNaciRegistro = new JTextField();
		txtFechNaciRegistro.setColumns(10);
		txtFechNaciRegistro.setBounds(411, 285, 181, 20);
		panelRegistro.add(txtFechNaciRegistro);

		JTextField txtContraseñaRegistro = new JTextField();
		txtContraseñaRegistro.setColumns(10);
		txtContraseñaRegistro.setBounds(411, 211, 181, 20);
		panelRegistro.add(txtContraseñaRegistro);

		JTextField txtUsuarioRegistro = new JTextField();
		txtUsuarioRegistro.setColumns(10);
		txtUsuarioRegistro.setBounds(411, 138, 181, 20);
		panelRegistro.add(txtUsuarioRegistro);

		JLabel lblNewLabel_5_1 = new JLabel("Fecha nacimiento");
		lblNewLabel_5_1.setBounds(300, 288, 102, 14);
		panelRegistro.add(lblNewLabel_5_1);

		JLabel lblNewLabel_5_2 = new JLabel("Contraseña");
		lblNewLabel_5_2.setBounds(300, 214, 66, 14);
		panelRegistro.add(lblNewLabel_5_2);

		JLabel lblNewLabel_5_3 = new JLabel("Usuario");
		lblNewLabel_5_3.setBounds(300, 141, 46, 14);
		panelRegistro.add(lblNewLabel_5_3);

		JLabel lblNewLabel_3_1 = new JLabel("Registro");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(255, 28, 108, 61);
		panelRegistro.add(lblNewLabel_3_1);

		JButton btnvolver = new JButton("Volver");
		btnvolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCotraseñaLogin.setText("");
				txtusuarioLogin.setText("");
				xtxnoencontrado.setText("");
				panelRegistro.setVisible(false);
				panelLogin.setVisible(true);

			}
		});
		btnvolver.setBounds(165, 362, 89, 23);
		panelRegistro.add(btnvolver);

		btnregistrarse = new JButton("Registrarse");
		btnregistrarse.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarDatosRegistro(txtNombreRegistro.getText(), txtApellidoRegistro.getText(),
						txtUsuarioRegistro.getText(), txtContraseñaRegistro.getText(), txtEmailRegistro.getText(),
						txtFechNaciRegistro.getText());
				txtApellidoRegistro.setText("");
				txtContraseñaRegistro.setText("");
				txtEmailRegistro.setText("");
				txtFechNaciRegistro.setText("");
				txtNombreRegistro.setText("");
				txtUsuarioRegistro.setText("");

			}
		});
		btnregistrarse.setBounds(364, 362, 102, 23);
		panelRegistro.add(btnregistrarse);

		panelWorkouts = new JPanel();
		panelWorkouts.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panelWorkouts, "name_87590927918800");
		panelWorkouts.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("Sesiones de Entrenamiento");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_6.setBounds(10, 11, 361, 30);
		panelWorkouts.add(lblNewLabel_6);
		

		JButton btncerrarsecion = new JButton("Cerrar secion");
		btncerrarsecion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelWorkouts.setVisible(false);
				panelLogin.setVisible(true);
			}
		});
		btncerrarsecion.setBounds(10, 369, 98, 30);
		panelWorkouts.add(btncerrarsecion);

		JButton btnPerfilWorkout = new JButton("Perfil");
		btnPerfilWorkout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelWorkouts.setVisible(false);
				panelPerfil.setVisible(true);
			}
		});
		btnPerfilWorkout.setBounds(482, 369, 98, 30);
		panelWorkouts.add(btnPerfilWorkout);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Todos los niveles", "Nivel 0", "Nivel 1", "Nivel 2", "Nivel 3"}));
		comboBox.setFont(new Font("Arial", Font.BOLD, 14));
		comboBox.setBackground(new Color(192, 192, 192));
		comboBox.setBounds(404, 11, 188, 39);
		panelWorkouts.add(comboBox);

		panelEjercios = new JPanel();
		contentPane.add(panelEjercios, "name_93612366560700");
		panelEjercios.setLayout(null);

		JLabel lblNewLabel_7 = new JLabel("Ejercicios");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_7.setBounds(28, 11, 129, 51);
		panelEjercios.add(lblNewLabel_7);

		JButton btnvolvereje = new JButton("Volver");
		btnvolvereje.setBounds(34, 361, 89, 23);
		panelEjercios.add(btnvolvereje);

		btncomenzareje = new JButton("Comenzar Entrenamiento");
		btncomenzareje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEjercios.setVisible(false);
				panelEntrenamiento.setVisible(true);
				txtTituloWorkout.setText(NomWorkout);
				txtDescripcionWorkout.setText(DecWorkout);
				txtTituloEjercicio.setText(NomEjercicio);
				txtDescripcionejercicio.setText(decEjercicios);
				cargarSeries(NomEjercicio);
				
				
				
				
			}
		});
		btncomenzareje.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btncomenzareje.setBounds(356, 21, 220, 35);
		panelEjercios.add(btncomenzareje);

		JButton btnPerfilEjercicios = new JButton("Perfil");
		btnPerfilEjercicios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEjercios.setVisible(false);
				panelPerfil.setVisible(true);
			}
		});
		btnPerfilEjercicios.setBounds(487, 361, 89, 23);
		panelEjercios.add(btnPerfilEjercicios);

		panelPerfil = new JPanel();
		panelPerfil.setLayout(null);
		contentPane.add(panelPerfil, "name_3871259056800");

		JLabel lblNewLabel_3_2 = new JLabel("Nombre");
		lblNewLabel_3_2.setBounds(24, 141, 46, 14);
		panelPerfil.add(lblNewLabel_3_2);

		txtNombrePerfil = new JTextField();
		txtNombrePerfil.setEditable(false);
		txtNombrePerfil.setColumns(10);
		txtNombrePerfil.setBounds(109, 138, 181, 20);
		panelPerfil.add(txtNombrePerfil);

		txtApePerfil = new JTextField();
		txtApePerfil.setEditable(false);
		txtApePerfil.setColumns(10);
		txtApePerfil.setBounds(109, 211, 181, 20);
		panelPerfil.add(txtApePerfil);

		JLabel lblNewLabel_4_1 = new JLabel("Apellido");
		lblNewLabel_4_1.setBounds(24, 214, 46, 14);
		panelPerfil.add(lblNewLabel_4_1);

		JLabel lblNewLabel_5_4 = new JLabel("Email");
		lblNewLabel_5_4.setBounds(24, 288, 46, 14);
		panelPerfil.add(lblNewLabel_5_4);

		txtEmailPerfil = new JTextField();
		txtEmailPerfil.setEditable(false);
		txtEmailPerfil.setColumns(10);
		txtEmailPerfil.setBounds(109, 285, 181, 20);
		panelPerfil.add(txtEmailPerfil);

		txtFechaPerfil = new JTextField();
		txtFechaPerfil.setEditable(false);
		txtFechaPerfil.setColumns(10);
		txtFechaPerfil.setBounds(411, 285, 181, 20);
		panelPerfil.add(txtFechaPerfil);

		txtContraPerfil = new JTextField();
		txtContraPerfil.setEditable(false);
		txtContraPerfil.setColumns(10);
		txtContraPerfil.setBounds(411, 211, 181, 20);
		panelPerfil.add(txtContraPerfil);

		txtUsuPerfil = new JTextField();
		txtUsuPerfil.setEditable(false);
		txtUsuPerfil.setColumns(10);
		txtUsuPerfil.setBounds(411, 138, 181, 20);
		panelPerfil.add(txtUsuPerfil);

		JLabel lblNewLabel_5_1_1 = new JLabel("Fecha nacimiento");
		lblNewLabel_5_1_1.setBounds(300, 288, 102, 14);
		panelPerfil.add(lblNewLabel_5_1_1);

		JLabel lblNewLabel_5_2_1 = new JLabel("Contraseña");
		lblNewLabel_5_2_1.setBounds(300, 214, 66, 14);
		panelPerfil.add(lblNewLabel_5_2_1);

		JLabel lblNewLabel_5_3_1 = new JLabel("Usuario");
		lblNewLabel_5_3_1.setBounds(300, 141, 46, 14);
		panelPerfil.add(lblNewLabel_5_3_1);

		JLabel lblNewLabel_3_1_1 = new JLabel("Perfil");
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1_1.setBounds(277, 24, 108, 61);
		panelPerfil.add(lblNewLabel_3_1_1);

		JButton btnvolverInicio = new JButton("Volver");
		btnvolverInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelPerfil.setVisible(false);
				panelWorkouts.setVisible(true);
				btnGuardar.setVisible(false);
				txtNombrePerfil.setEditable(false);
				txtApePerfil.setEditable(false);
				txtContraPerfil.setEditable(false);
				txtEmailPerfil.setEditable(false);
				txtFechaPerfil.setEditable(false);
				txtUsuPerfil.setEditable(false);
				
			}
		});
		btnvolverInicio.setBounds(165, 362, 89, 23);
		panelPerfil.add(btnvolverInicio);

		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnGuardar.setVisible(true);
				txtNombrePerfil.setEditable(true);
				txtApePerfil.setEditable(true);
				txtContraPerfil.setEditable(true);
				txtEmailPerfil.setEditable(true);
				txtFechaPerfil.setEditable(true);
				txtUsuPerfil.setEditable(true);

			}
		});
		btnModificar.setBounds(364, 362, 102, 23);
		panelPerfil.add(btnModificar);

		btnGuardar = new JButton("Guardar");
		btnGuardar.setVisible(false);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobarDatosPerfil(txtNombrePerfil.getText(),txtApePerfil.getText(),txtUsuPerfil.getText(), txtContraPerfil.getText(),
						txtEmailPerfil.getText(),txtFechaPerfil.getText());
			}
		});
		btnGuardar.setBounds(503, 75, 89, 23);
		panelPerfil.add(btnGuardar);
		
		panelEntrenamiento = new JPanel();
		panelEntrenamiento.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(panelEntrenamiento, "name_444844956700600");
		panelEntrenamiento.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(128, 128, 128), 3, true));
		panel.setBackground(new Color(128, 128, 128));
		panel.setBounds(10, 11, 582, 152);
		panelEntrenamiento.add(panel);
		panel.setLayout(null);
		System.out.println(NomWorkout);
		txtTituloWorkout = new JLabel(NomWorkout);
		txtTituloWorkout.setForeground(new Color(255, 255, 255));
		txtTituloWorkout.setFont(new Font("Arial", Font.BOLD, 44));
		txtTituloWorkout.setBounds(10, 11, 392, 59);
		panel.add(txtTituloWorkout);
		
		txtDescripcionWorkout = new JLabel("");
		txtDescripcionWorkout.setFont(new Font("Arial", Font.PLAIN, 15));
		txtDescripcionWorkout.setForeground(new Color(255, 255, 255));
		txtDescripcionWorkout.setBounds(54, 55, 304, 68);
		panel.add(txtDescripcionWorkout);
		
		JButton btnPausar = new JButton("Pausar");
		btnPausar.setFont(new Font("Arial", Font.BOLD, 11));
		btnPausar.setBackground(new Color(255, 255, 255));
		btnPausar.setForeground(new Color(0, 128, 0));
		btnPausar.setBounds(380, 79, 89, 23);
		panel.add(btnPausar);
		
		JButton btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setForeground(new Color(0, 0, 255));
		btnSiguiente.setFont(new Font("Arial", Font.BOLD, 11));
		btnSiguiente.setBackground(new Color(255, 255, 255));
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnSiguiente.setBounds(380, 113, 89, 23);
		panel.add(btnSiguiente);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panelEntrenamiento.setVisible(false);
				panelWorkouts.setVisible(true);
			}
		});
		btnSalir.setFont(new Font("Arial", Font.BOLD, 11));
		btnSalir.setForeground(new Color(255, 0, 0));
		btnSalir.setBackground(new Color(255, 255, 255));
		btnSalir.setBounds(483, 79, 89, 57);
		panel.add(btnSalir);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 174, 582, 235);
		panelEntrenamiento.add(panel_1);
		panel_1.setLayout(null);
		
		txtTituloEjercicio = new JLabel("");
		txtTituloEjercicio.setForeground(new Color(0, 0, 0));
		txtTituloEjercicio.setFont(new Font("Arial", Font.BOLD, 20));
		txtTituloEjercicio.setBounds(22, 11, 415, 35);
		panel_1.add(txtTituloEjercicio);
		
		txtDescripcionejercicio = new JLabel("");
		txtDescripcionejercicio.setForeground(new Color(0, 0, 0));
		txtDescripcionejercicio.setFont(new Font("Arial", Font.PLAIN, 10));
		txtDescripcionejercicio.setBounds(10, 46, 363, 35);
		panel_1.add(txtDescripcionejercicio);
		
		avisos = new JLabel("New label");
		avisos.setHorizontalAlignment(SwingConstants.CENTER);
		avisos.setForeground(new Color(0, 0, 0));
		avisos.setBackground(new Color(0, 0, 0));
		avisos.setBounds(416, 45, 156, 36);
		panel_1.add(avisos);
		
		panelSeries = new JPanel();
		panelSeries.setBounds(10, 92, 562, 132);
		panel_1.add(panelSeries);
		panelSeries.setLayout(new BoxLayout(panelSeries, BoxLayout.X_AXIS));
		JScrollPane scrollSeries = new JScrollPane(panelSeries,ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER,
													ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollSeries.setBounds(10, 92, 562, 132);
		panel_1.add(scrollSeries);

	}
		public void cargarSeries(String nomeje) {
			try {
				ArrayList<Serie> arrayseries = Controlador.mostarseries(nomeje);
				panelSeries.removeAll();
				for(Serie Series:arrayseries) {
					panelSeries.add(crearTarjetaSerie(Series));
					panelSeries.add(Box.createHorizontalStrut(10));
					
				}
				panelSeries.revalidate();
				panelSeries.repaint();
			} catch (InterruptedException e) {
				e.printStackTrace();
			} catch (ExecutionException e) {
				e.printStackTrace();
			}
		
	}

		private JPanel crearTarjetaSerie(Serie series) {
			JPanel card = new JPanel(new BorderLayout());
			card.setPreferredSize(new Dimension(160,190));
			card.setMaximumSize(new Dimension(160,190));
			card.setBorder(new LineBorder(Color.LIGHT_GRAY));
			
			JLabel img = new JLabel();
			JPanel pie = new JPanel(new GridLayout(2,1));
			pie.add(new JLabel(series.getNombre()));
			pie.add(new JLabel());
			card.add(img,BorderLayout.CENTER);
			card.add(pie,BorderLayout.SOUTH);
			return card;
		}

		public void comprobarDatosPerfil(String nomPerfil, String apePerfil, String usuPerfil,
				String contraPerfil, String emailPerfil, String fechanaciPerfil) {
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
			} else {
				try {
					boolean modificar = Controlador.modificar(nomPerfil,  apePerfil,  usuPerfil,
							 contraPerfil,  emailPerfil,  fechanaciPerfil);
					JOptionPane.showMessageDialog(btnGuardar, "Se han modificado los datos", "",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
			
		}
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
		} else {
			try {
				boolean registrado = Controlador.recogeRegistro(nomRegistro, apRegistro, usuRegistro, contraRegistro,
						emailRegistro, fechanaciRegistro);
				JOptionPane.showMessageDialog(btnregistrarse, "Te has registrado correctamente", "",
						JOptionPane.INFORMATION_MESSAGE);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}
}
