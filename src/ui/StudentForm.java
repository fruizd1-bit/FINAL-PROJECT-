package ui;

import Dominio.Student;
import servicio.StudentManager;
import servicio.FileManager;
import javax.swing.JOptionPane;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class StudentForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableStudents;
	private JLabel lblStudentsGestor;
	private JPanel panel_1;
	private JLabel lblID;
	private JLabel lblName;
	private JLabel lblEmail;
	private JTextField textID;
	private JTextField textName;
	private JTextField textEmail;
	private JButton btnAddStudent;
	private JButton btnSearchStudent;
	private JButton btnEditEstudent;
	private JButton btnDeleteStudent;
	private JButton btnClearFields;
	private StudentManager manager;
	private DefaultTableModel model;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentForm frame = new StudentForm();
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
	public StudentForm() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 566);
		//integracion de los servicios
		manager = new StudentManager();
		FileManager.loadData(manager);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelFondo = new JPanel();
		panelFondo.setBackground(Color.WHITE);
		panelFondo.setBounds(0, 0, 809, 527);
		contentPane.add(panelFondo);
		panelFondo.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 809, 62);
		panelFondo.add(panel);
		panel.setLayout(null);
		
		lblStudentsGestor = new JLabel("Gestor de Estudiantes");
		lblStudentsGestor.setForeground(Color.WHITE);
		lblStudentsGestor.setFont(new Font("Arial Black", Font.PLAIN, 24));
		lblStudentsGestor.setBounds(10, 11, 384, 26);
		panel.add(lblStudentsGestor);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 299, 552, 228);
		panelFondo.add(panel_1);
		panel_1.setLayout(null);
		
		tableStudents = new JTable();
		tableStudents.setBounds(42, 25, 461, 176);
		panel_1.add(tableStudents);
		tableStudents.setFont(new Font("Arial Black", Font.PLAIN, 12));
		tableStudents.setModel(new DefaultTableModel(
				new Object[][] {},
			    new String[] {
			        "ID", "Nombre", "Email"
			    }
				
				
		));
		tableStudents.getColumnModel().getColumn(0).setPreferredWidth(92);
		tableStudents.getColumnModel().getColumn(0).setMinWidth(30);
		tableStudents.getColumnModel().getColumn(1).setPreferredWidth(272);
		tableStudents.getColumnModel().getColumn(1).setMinWidth(30);
		tableStudents.getColumnModel().getColumn(2).setPreferredWidth(165);
		tableStudents.getColumnModel().getColumn(2).setMinWidth(30);
		model = (DefaultTableModel) tableStudents.getModel();
		refreshTable();
		
		
		lblID = new JLabel("ID");
		lblID.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblID.setBounds(23, 73, 88, 28);
		panelFondo.add(lblID);
		
		lblName = new JLabel("Nombre");
		lblName.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblName.setBounds(23, 122, 88, 28);
		panelFondo.add(lblName);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEmail.setBounds(23, 167, 88, 28);
		panelFondo.add(lblEmail);
		
		textID = new JTextField();
		textID.setFont(new Font("Arial", Font.PLAIN, 14));
		textID.setBounds(167, 79, 198, 22);
		panelFondo.add(textID);
		textID.setColumns(10);
		
		textName = new JTextField();
		textName.setFont(new Font("Arial", Font.PLAIN, 14));
		textName.setColumns(10);
		textName.setBounds(167, 126, 198, 22);
		panelFondo.add(textName);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Arial", Font.PLAIN, 14));
		textEmail.setColumns(10);
		textEmail.setBounds(167, 171, 198, 22);
		panelFondo.add(textEmail);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 199, 809, 62);
		panelFondo.add(panel_2);
		panel_2.setLayout(null);
		
		btnAddStudent = new JButton("Agregar");
		btnAddStudent.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnAddStudent.setBounds(32, 11, 110, 40);
		panel_2.add(btnAddStudent);
		
		btnSearchStudent = new JButton("Buscar");
		btnSearchStudent.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnSearchStudent.setBounds(182, 11, 110, 40);
		panel_2.add(btnSearchStudent);
		
		btnEditEstudent = new JButton("Editar");
		btnEditEstudent.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnEditEstudent.setBounds(329, 11, 110, 40);
		panel_2.add(btnEditEstudent);
		
		btnDeleteStudent = new JButton("Eliminar");
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeleteStudent.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnDeleteStudent.setBounds(469, 11, 110, 40);
		panel_2.add(btnDeleteStudent);
		
		btnClearFields = new JButton("Limpiar");
		btnClearFields.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnClearFields.setBounds(616, 11, 110, 40);
		panel_2.add(btnClearFields);
		
		

	}
	// metodo para refresh table
	private void refreshTable() {

	    model.setRowCount(0);

	    for (Student student : manager.getStudents()) {

	        model.addRow(new Object[] {

	                student.getId(),
	                student.getName(),
	                student.getEmail()
	        });
	    }
	}
	
	
}
