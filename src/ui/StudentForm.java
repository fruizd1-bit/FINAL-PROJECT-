package ui;

import Dominio.Student;
import ui.CourseForm;
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
	private JLabel lblName_1;
	private JLabel lblID_1;
	private JLabel lblEmail_1;
	private JButton btnManageCourses_1;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

	    EventQueue.invokeLater(new Runnable() {

	        public void run() {

	            try {

	                StudentManager manager =
	                        new StudentManager();

	                FileManager.loadData(manager);

	                StudentForm frame =
	                        new StudentForm(manager);

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
	public StudentForm(StudentManager manager) {
		this.manager = manager;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 566);
		//integracion de los servicios
		
		
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
		panel_1.setBounds(0, 288, 809, 239);
		panelFondo.add(panel_1);
		panel_1.setLayout(null);
		
		tableStudents = new JTable();
		tableStudents.setBounds(41, 36, 461, 176);
		panel_1.add(tableStudents);
		tableStudents.setFont(new Font("Arial Black", Font.PLAIN, 12));
		tableStudents.setModel(new DefaultTableModel(
				new Object[][] {},
			    new String[] {
			        "ID", "Nombre", "Email"
			    }
				
				
		));
		
		lblName_1 = new JLabel("Nombre");
		lblName_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblName_1.setBounds(194, 0, 88, 32);
		panel_1.add(lblName_1);
		
		lblID_1 = new JLabel("ID");
		lblID_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblID_1.setBounds(79, 0, 88, 28);
		panel_1.add(lblID_1);
		
		lblEmail_1 = new JLabel("Email");
		lblEmail_1.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblEmail_1.setBounds(380, 2, 88, 28);
		panel_1.add(lblEmail_1);
		
		
		btnManageCourses_1 = new JButton("Cursos");
		btnManageCourses_1.setBounds(530, 45, 140, 40);
		panel_1.add(btnManageCourses_1);
		btnManageCourses_1.setFont(
		        new Font("Arial Black", Font.PLAIN, 12)
		);
		btnManageCourses_1.addActionListener(new ActionListener() {

		    public void actionPerformed(ActionEvent e) {

		        int selectedRow =
		                tableStudents.getSelectedRow();

		        if (selectedRow == -1) {

		            JOptionPane.showMessageDialog(
		                    null,
		                    "Seleccione un estudiante"
		            );

		            return;
		        }

		        String studentId =
		                model.getValueAt(
		                        selectedRow,
		                        0
		                ).toString();

		        Student student =
		                manager.searchStudent(studentId);

		        CourseForm courseForm =
		                new CourseForm(
		                        student,
		                        manager
		                );

		        courseForm.setVisible(true);
		    }
		});
		
		
		
		
		
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
		
		btnAddStudent.addActionListener(new ActionListener() {
//metodo para conectar el boton agregar estudiante
		    public void actionPerformed(ActionEvent e) {

		        try {

		            Student student = new Student(

		                    textID.getText(),
		                    textName.getText(),
		                    textEmail.getText()
		            );

		            manager.addStudent(student);

		            FileManager.saveData(manager);

		            refreshTable();

		            JOptionPane.showMessageDialog(
		                    null,
		                    "Estudiante agregado correctamente"
		            );

		        } catch (IllegalArgumentException ex) {

		            JOptionPane.showMessageDialog(
		                    null,
		                    ex.getMessage()
		            );
		        }
		    }
		});
		
		
		btnAddStudent.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnAddStudent.setBounds(32, 11, 110, 40);
		panel_2.add(btnAddStudent);
		
		
		btnSearchStudent = new JButton("Buscar");
		//metodo para unir logica con boton buscar
		btnSearchStudent.addActionListener(new ActionListener() {

		    public void actionPerformed(ActionEvent e) {

		        String id = textID.getText();

		        Student student = manager.searchStudent(id);

		        if (student != null) {

		            textName.setText(student.getName());

		            textEmail.setText(student.getEmail());

		            JOptionPane.showMessageDialog(
		                    null,
		                    "Estudiante encontrado"
		            );

		        } else {

		            JOptionPane.showMessageDialog(
		                    null,
		                    "Estudiante no encontrado"
		            );
		        }
		    }
		});
		
		
		btnSearchStudent.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnSearchStudent.setBounds(182, 11, 110, 40);
		panel_2.add(btnSearchStudent);
		
		btnEditEstudent = new JButton("Editar");
		
		btnEditEstudent.addActionListener(new ActionListener() {
//metodo para conectar la logica con el boton editar
		    public void actionPerformed(ActionEvent e) {

		        Student student =
		                manager.searchStudent(
		                        textID.getText()
		                );

		        if (student != null) {

		            try {

		                student.editStudent(

		                        textName.getText(),

		                        textEmail.getText()
		                );

		                FileManager.saveData(manager);

		                refreshTable();

		                JOptionPane.showMessageDialog(
		                        null,
		                        "Estudiante actualizado"
		                );

		            } catch (IllegalArgumentException ex) {

		                JOptionPane.showMessageDialog(
		                        null,
		                        ex.getMessage()
		                );
		            }

		        } else {

		            JOptionPane.showMessageDialog(
		                    null,
		                    "Estudiante no encontrado"
		            );
		        }
		    }
		});
		
		
		btnEditEstudent.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnEditEstudent.setBounds(329, 11, 110, 40);
		panel_2.add(btnEditEstudent);
		
		btnDeleteStudent = new JButton("Eliminar");
		
		btnDeleteStudent.addActionListener(new ActionListener() {
//metodo para unir la logica con el boton eliminar
		    public void actionPerformed(ActionEvent e) {

		        String id = textID.getText();

		        boolean removed =
		                manager.removeStudent(id);

		        if (removed) {

		            FileManager.saveData(manager);

		            refreshTable();

		            textID.setText("");
		            textName.setText("");
		            textEmail.setText("");

		            JOptionPane.showMessageDialog(
		                    null,
		                    "Estudiante eliminado"
		            );

		        } else {

		            JOptionPane.showMessageDialog(
		                    null,
		                    "Estudiante no encontrado"
		            );
		        }
		    }
		});
		
		
		
		btnDeleteStudent.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnDeleteStudent.setBounds(469, 11, 110, 40);
		panel_2.add(btnDeleteStudent);
		
		btnClearFields = new JButton("Limpiar");
		
		btnClearFields.addActionListener(new ActionListener() {
//metodo para el boton limpiar
		    public void actionPerformed(ActionEvent e) {

		        textID.setText("");
		        textName.setText("");
		        textEmail.setText("");
		    }
		});
		
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
