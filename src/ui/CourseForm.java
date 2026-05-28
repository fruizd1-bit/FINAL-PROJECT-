package ui;

import java.awt.EventQueue;


import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

import Dominio.Course;
import Dominio.Student;
import ui.EvaluationForm;

import servicio.FileManager;
import servicio.StudentManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;


public class CourseForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable tableCourses;
	private JTextField textCourseName;
	//variable globales
	private Student student;
	private StudentManager manager;
	private DefaultTableModel model;
	private JButton btnAddCourse;
	private JButton btnSearchCourse;
	private JButton btnEditCourse;
	private JButton btnDeleteCourse;
	private JButton btnBack;
	

	/*
	 * Launch the application.
	 */
	
	
	
	
	/**
	 * Create the frame.
	 */
	public CourseForm(
	        Student student,
	        StudentManager manager
	) {
		this.student = student;

		this.manager = manager;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setForeground(new Color(255, 255, 255));
		panel.setBounds(0, 0, 809, 527);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 809, 62);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion de Cursos");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 26));
		lblNewLabel.setBounds(35, 11, 322, 55);
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(0, 300, 809, 216);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		tableCourses = new JTable();
		tableCourses.setBounds(57, 35, 412, 170);
		panel_2.add(tableCourses);
		model = new DefaultTableModel();
		model.addColumn("Nombre Curso");
		tableCourses.setModel(model);
		refreshTable();
		
		
		
		
		
		JLabel lblNameCourse = new JLabel("Curso:");
		lblNameCourse.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNameCourse.setBounds(10, 73, 55, 24);
		panel.add(lblNameCourse);
		
		textCourseName = new JTextField();
		textCourseName.setFont(new Font("Arial Black", Font.PLAIN, 12));
		textCourseName.setBounds(75, 73, 152, 24);
		panel.add(textCourseName);
		textCourseName.setColumns(10);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(Color.DARK_GRAY);
		panel_1_1.setBounds(0, 189, 809, 62);
		panel.add(panel_1_1);
		
		btnAddCourse = new JButton("Agregar");
		btnAddCourse.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnAddCourse.setBounds(27, 11, 92, 27);
		panel_1_1.add(btnAddCourse);
		btnAddCourse.addActionListener(e -> {

		    try {

		        String courseName =
		                textCourseName.getText();

		        Course course =
		                new Course(courseName);

		        student.addCourse(course);

		        FileManager.saveData(manager);

		        refreshTable();

		        textCourseName.setText("");

		        JOptionPane.showMessageDialog(
		                null,
		                "Curso agregado correctamente"
		        );

		    } catch (IllegalArgumentException ex) {

		        JOptionPane.showMessageDialog(
		                null,
		                ex.getMessage()
		        );
		    }
		});
		
		
		JButton btnManageEvaluations = new JButton("Evaluaciones");
		btnManageEvaluations.setBounds(491, 35, 140, 27);
		panel_2.add(btnManageEvaluations);

		btnManageEvaluations.setFont(
		        new Font("Arial Black", Font.PLAIN, 12)
		);

		btnManageEvaluations.addActionListener(e -> {

		    int selectedRow =
		            tableCourses.getSelectedRow();

		    if (selectedRow != -1) {

		        String courseName =
		                model.getValueAt(
		                        selectedRow,
		                        0
		                ).toString();

		        Course selectedCourse = null;

		        for (Course course :
		                student.getCourses()) {

		            if (
		                    course.getCourseName()
		                            .equals(courseName)
		            ) {

		                selectedCourse = course;

		                break;
		            }
		        }

		        if (selectedCourse != null) {

		            EvaluationForm form =
		                    new EvaluationForm(
		                            selectedCourse,
		                            manager
		                    );

		            form.setVisible(true);
		        }

		    } else {

		        JOptionPane.showMessageDialog(
		                null,
		                "Seleccione un curso"
		        );
		    }
		});
		
		
		btnSearchCourse = new JButton("Buscar");
		btnSearchCourse.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnSearchCourse.setBounds(170, 11, 92, 27);
		panel_1_1.add(btnSearchCourse);
		
		btnSearchCourse.addActionListener(e -> {

		    String courseName =
		            textCourseName.getText();

		    Course foundCourse = null;

		    for (Course course :
		            student.getCourses()) {

		        if (
		                course.getCourseName()
		                        .equalsIgnoreCase(courseName)
		        ) {

		            foundCourse = course;

		            break;
		        }
		    }

		    if (foundCourse != null) {

		        JOptionPane.showMessageDialog(
		                null,
		                "Curso encontrado: "
		                + foundCourse.getCourseName()
		        );

		    } else {

		        JOptionPane.showMessageDialog(
		                null,
		                "Curso no encontrado"
		        );
		    }
		});
		
		
		
		btnEditCourse = new JButton("Editar");
		btnEditCourse.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnEditCourse.setBounds(311, 11, 92, 27);
		panel_1_1.add(btnEditCourse);
		
		btnEditCourse.addActionListener(e -> {

		    String currentName =
		            JOptionPane.showInputDialog(
		                    "Ingrese el nombre actual del curso"
		            );

		    if (currentName == null ||
		            currentName.isEmpty()) {

		        return;
		    }

		    String newName =
		            textCourseName.getText();

		    try {

		        for (Course course :
		                student.getCourses()) {

		            if (
		                    course.getCourseName()
		                            .equalsIgnoreCase(currentName)
		            ) {

		                course.setCourseName(newName);

		                FileManager.saveData(manager);

		                refreshTable();

		                textCourseName.setText("");

		                JOptionPane.showMessageDialog(
		                        null,
		                        "Curso editado correctamente"
		                );

		                return;
		            }
		        }

		        JOptionPane.showMessageDialog(
		                null,
		                "Curso no encontrado"
		        );

		    } catch (IllegalArgumentException ex) {

		        JOptionPane.showMessageDialog(
		                null,
		                ex.getMessage()
		        );
		    }
		});
		
		btnDeleteCourse = new JButton("Eliminar");
		btnDeleteCourse.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnDeleteCourse.setBounds(457, 11, 92, 27);
		panel_1_1.add(btnDeleteCourse);
		
		btnDeleteCourse.addActionListener(e -> {

		    String courseName =
		            textCourseName.getText();

		    boolean removed =
		            student.removeCourse(courseName);

		    if (removed) {

		        FileManager.saveData(manager);

		        refreshTable();

		        textCourseName.setText("");

		        JOptionPane.showMessageDialog(
		                null,
		                "Curso eliminado correctamente"
		        );

		    } else {

		        JOptionPane.showMessageDialog(
		                null,
		                "Curso no encontrado"
		        );
		    }
		});
		
		
		
		btnBack = new JButton("Regresar");
		btnBack.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnBack.setBounds(605, 11, 92, 27);
		panel_1_1.add(btnBack);
		
		btnBack.addActionListener(e -> {

		    dispose();
		});
		

	}
	
	private void refreshTable() {

	    model.setRowCount(0);

	    for (Course course :
	            student.getCourses()) {

	        model.addRow(new Object[] {

	                course.getCourseName()
	        });
	    }
	}
	
	
}
