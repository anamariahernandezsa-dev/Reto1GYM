package Vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

public class Vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtusuario;
	private JTextField txtCotraseña;
	private JTextField txtNombre;
	private JTextField txtApellido;
	private JTextField txtEmail;
	private JTextField txtFechNaci;
	private JTextField txtContraseña;
	private JTextField txtUsuario;
	private JTable tableWorkouts;
	private JTable tableEjercicios;

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
		
		JPanel PanelLogin = new JPanel();
		contentPane.add(PanelLogin, "name_84904836361500");
		PanelLogin.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuario");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(108, 152, 81, 14);
		PanelLogin.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Contraseña");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(108, 226, 81, 14);
		PanelLogin.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Login");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(255, 51, 110, 46);
		PanelLogin.add(lblNewLabel_2);
		
		txtusuario = new JTextField();
		txtusuario.setBounds(247, 149, 243, 20);
		PanelLogin.add(txtusuario);
		txtusuario.setColumns(10);
		
		txtCotraseña = new JTextField();
		txtCotraseña.setBounds(247, 223, 243, 20);
		PanelLogin.add(txtCotraseña);
		txtCotraseña.setColumns(10);
		
		JButton btniniciosecion = new JButton("Iniciar secion");
		btniniciosecion.setBounds(145, 339, 110, 23);
		PanelLogin.add(btniniciosecion);
		
		JButton btnregistro = new JButton("Registrarse");
		btnregistro.setBounds(372, 339, 89, 23);
		PanelLogin.add(btnregistro);
		
		JPanel PanelRegistro = new JPanel();
		contentPane.add(PanelRegistro, "name_85225128619600");
		PanelRegistro.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre");
		lblNewLabel_3.setBounds(24, 141, 46, 14);
		PanelRegistro.add(lblNewLabel_3);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(109, 138, 181, 20);
		PanelRegistro.add(txtNombre);
		txtNombre.setColumns(10);
		
		txtApellido = new JTextField();
		txtApellido.setBounds(109, 211, 181, 20);
		PanelRegistro.add(txtApellido);
		txtApellido.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Apellido");
		lblNewLabel_4.setBounds(24, 214, 46, 14);
		PanelRegistro.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setBounds(24, 288, 46, 14);
		PanelRegistro.add(lblNewLabel_5);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(109, 285, 181, 20);
		PanelRegistro.add(txtEmail);
		txtEmail.setColumns(10);
		
		txtFechNaci = new JTextField();
		txtFechNaci.setColumns(10);
		txtFechNaci.setBounds(396, 285, 181, 20);
		PanelRegistro.add(txtFechNaci);
		
		txtContraseña = new JTextField();
		txtContraseña.setColumns(10);
		txtContraseña.setBounds(396, 211, 181, 20);
		PanelRegistro.add(txtContraseña);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(396, 138, 181, 20);
		PanelRegistro.add(txtUsuario);
		
		JLabel lblNewLabel_5_1 = new JLabel("Fecha nacimiento");
		lblNewLabel_5_1.setBounds(300, 288, 86, 14);
		PanelRegistro.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("Contraseña");
		lblNewLabel_5_2.setBounds(300, 214, 66, 14);
		PanelRegistro.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("Usuario");
		lblNewLabel_5_3.setBounds(300, 141, 46, 14);
		PanelRegistro.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("Registro");
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3_1.setBounds(255, 28, 108, 61);
		PanelRegistro.add(lblNewLabel_3_1);
		
		JButton btnvolver = new JButton("Volver");
		btnvolver.setBounds(165, 362, 89, 23);
		PanelRegistro.add(btnvolver);
		
		JButton btnregistrarse = new JButton("Registrarse");
		btnregistrarse.setBounds(377, 362, 89, 23);
		PanelRegistro.add(btnregistrarse);
		
		JPanel PanelWorkouts = new JPanel();
		PanelWorkouts.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPane.add(PanelWorkouts, "name_87590927918800");
		PanelWorkouts.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Sesiones de Entrenamiento");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_6.setBounds(10, 11, 361, 30);
		PanelWorkouts.add(lblNewLabel_6);
		
		JList listNivel = new JList();
		listNivel.setBorder(new LineBorder(new Color(192, 192, 192)));
		listNivel.setBounds(404, 10, 188, 31);
		PanelWorkouts.add(listNivel);
		
		tableWorkouts = new JTable();
		tableWorkouts.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Nivel", "Nombre", "Descripcion", "Gu\u00EDa"
			}
		));
		tableWorkouts.setBorder(new LineBorder(new Color(192, 192, 192)));
		tableWorkouts.setBounds(10, 69, 582, 189);
		PanelWorkouts.add(tableWorkouts);
		
		JPanel PanelEjercios = new JPanel();
		contentPane.add(PanelEjercios, "name_93612366560700");
		PanelEjercios.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Ejercicios");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_7.setBounds(28, 11, 129, 51);
		PanelEjercios.add(lblNewLabel_7);
		
		tableEjercicios = new JTable();
		tableEjercicios.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Ejercicio", "Descripcion", "Duracion"
			}
		));
		tableEjercicios.setBorder(new LineBorder(new Color(192, 192, 192)));
		tableEjercicios.setBounds(28, 103, 548, 199);
		PanelEjercios.add(tableEjercicios);
		
		JButton btnvolvereje = new JButton("Volver");
		btnvolvereje.setBounds(34, 361, 89, 23);
		PanelEjercios.add(btnvolvereje);
		
		JButton btncomenzareje = new JButton("Comenzar Entrenamiento");
		btncomenzareje.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btncomenzareje.setBounds(356, 21, 220, 35);
		PanelEjercios.add(btncomenzareje);

	}
}
