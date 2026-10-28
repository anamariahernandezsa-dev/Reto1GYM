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
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import Controlador.Controlador;

import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;
import java.awt.event.ActionEvent;

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
		
		JButton btniniciosecion = new JButton("Iniciar secion");
		btniniciosecion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					boolean  encontrado =  Controlador.conectionloging(txtusuarioLogin.getText(),txtCotraseñaLogin.getText());
					if(encontrado==true) {
						txtusuarioLogin.setText("");
						txtCotraseñaLogin.setText("");
						
						panelLogin.setVisible(false);
						panelWorkouts.setVisible(true);
						xtxnoencontrado.setText("");
						
					}else {
						xtxnoencontrado.setText("Usuario no encontrado");
					}
				} catch (Exception e1) {
					
					e1.printStackTrace();
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
				comprobarDatos(txtNombreRegistro.getText(),txtApellidoRegistro.getText(),txtUsuarioRegistro.getText(),
						txtContraseñaRegistro.getText(),txtEmailRegistro.getText(),txtFechNaciRegistro.getText());
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
		
		JList listNivel = new JList();
		listNivel.setBorder(new LineBorder(new Color(192, 192, 192)));
		listNivel.setBounds(404, 10, 188, 31);
		panelWorkouts.add(listNivel);
		
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
		panelWorkouts.add(tableWorkouts);
		
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
		
		panelEjercios = new JPanel();
		contentPane.add(panelEjercios, "name_93612366560700");
		panelEjercios.setLayout(null);
		
		JLabel lblNewLabel_7 = new JLabel("Ejercicios");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_7.setBounds(28, 11, 129, 51);
		panelEjercios.add(lblNewLabel_7);
		
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
		panelEjercios.add(tableEjercicios);
		
		JButton btnvolvereje = new JButton("Volver");
		btnvolvereje.setBounds(34, 361, 89, 23);
		panelEjercios.add(btnvolvereje);
		
		JButton btncomenzareje = new JButton("Comenzar Entrenamiento");
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
			}
		});
		btnvolverInicio.setBounds(165, 362, 89, 23);
		panelPerfil.add(btnvolverInicio);
		
		JButton btnModificar = new JButton("Modificar");
		btnModificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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

		
	}
	public void comprobarDatos(String nomRegistro, String apRegistro, String usuRegistro,
			String contraRegistro, String emailRegistro, String fechanaciRegistro) {
		 boolean correcto = true;
	      StringBuilder errores = new StringBuilder();
       if (usuRegistro.isEmpty())          { errores.append("El usuario no puede estar vacío.\n");             correcto = false; }
       if (usuRegistro.length() > 30)      { errores.append("El usuario no puede tener más de 30 caracteres.\n"); correcto = false; }
       if (contraRegistro.isEmpty())         { errores.append("La contraseña no puede estar vacía.\n");          correcto = false; }
       if (nomRegistro.isEmpty())           { errores.append("El nombre no puede estar vacío.\n");              correcto = false; }
       if (nomRegistro.length() > 30)       { errores.append("El nombre no puede tener más de 30 caracteres.\n"); correcto = false; }
       if (apRegistro.isEmpty())        { errores.append("Los apellidos no pueden estar vacíos.\n");        correcto = false; }
       if (apRegistro.length() > 70)    { errores.append("Los apellidos no pueden tener más de 70 caracteres.\n"); correcto = false; }
       if (fechanaciRegistro == null || fechanaciRegistro.isEmpty()) { errores.append("La fecha de nacimiento no puede estar vacía.\n"); correcto = false; }
       if(emailRegistro.isEmpty()) {errores.append("El email no puede estar vacio. \n"); correcto = false;}
       if(!emailRegistro.contains("@")){errores.append("El email debe de contener un @"); correcto = false; }
       
       if(!correcto) {
           JOptionPane.showMessageDialog(btnregistrarse, errores.toString(), "Errores de validación", JOptionPane.WARNING_MESSAGE);
           return;
       }else {
    	   try {
			boolean registrado = Controlador.recogeRegistro(nomRegistro,apRegistro,usuRegistro,
					   contraRegistro,emailRegistro,fechanaciRegistro);
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
