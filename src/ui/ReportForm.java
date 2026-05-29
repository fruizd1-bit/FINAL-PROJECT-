package ui;


import javax.swing.table.DefaultTableModel;

import Dominio.Student;
import Dominio.Course;
import Dominio.Evaluation;
import Dominio.WrittenExam;
import Dominio.LabEvaluation;
import Dominio.ProjectEvaluation;

import servicio.StudentManager;

import javax.swing.JScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;

public class ReportForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable table;
	private JComboBox<String> comboStudents;
	private JComboBox<String> comboCourses;
	private JLabel lblFinalNote;
	private JLabel lblStatus;
	private DefaultTableModel model;
	private StudentManager manager;
	private JButton btnBack;

	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	public ReportForm(StudentManager manager){
		this.manager = manager;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 809, 527);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(0, 0, 809, 69);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Reportes");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 26));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 11, 328, 47);
		panel_1.add(lblNewLabel);
		
		btnBack = new JButton("Regresar");
		btnBack.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnBack.setDefaultCapable(false);
		btnBack.setBounds(607, 11, 142, 30);
		panel_1.add(btnBack);
		btnBack.addActionListener(e -> {

		    MainFrame mainFrame =
		            new MainFrame();

		    mainFrame.setVisible(true);

		    dispose();
		});
		
		comboStudents = new JComboBox<>();
		comboStudents.setBounds(20, 107, 180, 22);
		panel.add(comboStudents);
		
		comboCourses = new JComboBox<>();
		comboCourses.setBounds(220, 107, 180, 22);
		panel.add(comboCourses);
		
		JLabel lblStudents = new JLabel("Estudiantes");
		lblStudents.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblStudents.setBounds(20, 80, 97, 22);
		panel.add(lblStudents);
		
		JLabel lblCourses = new JLabel("Cursos");
		lblCourses.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblCourses.setBounds(220, 80, 97, 22);
		panel.add(lblCourses);
		
		table = new JTable();
		model = new DefaultTableModel();
		model.addColumn("Evaluacion");
		model.addColumn("Porcentaje");
		model.addColumn("Nota");
		model.addColumn("Tipo");
		table.setModel(model);
		JScrollPane scrollPane =
		        new JScrollPane(table);

		scrollPane.setBounds(20, 161, 476, 197);
		panel.add(scrollPane);
		
		lblFinalNote= new JLabel("Nota Final: 0");
		lblFinalNote.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblFinalNote.setBounds(20, 376, 164, 22);
		panel.add(lblFinalNote);
		
		lblStatus= new JLabel("Estado: ");
		lblStatus.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblStatus.setBounds(20, 409, 212, 22);
		panel.add(lblStatus);
		
		loadStudents();
		
		comboStudents.addActionListener(e -> {

		    loadCourses();
		    
		});
		
		comboCourses.addActionListener(e -> {

		    loadEvaluations();
		});
		
		
	}
	private void loadStudents() {

	    comboStudents.removeAllItems();

	    comboCourses.removeAllItems();

	    for (Student student :
	            manager.getStudents()) {

	        comboStudents.addItem(
	                student.getName()
	        );
	    }
	}
	
	private void loadCourses() {

	    comboCourses.removeAllItems();

	    model.setRowCount(0);

	    lblFinalNote.setText("Nota Final: 0");

	    lblStatus.setText("Estado:");

	    if (comboStudents.getSelectedItem() == null) {

	        return;
	    }

	    String studentName =
	            comboStudents.getSelectedItem()
	                    .toString();

	    for (Student student :
	            manager.getStudents()) {

	        if (
	                student.getName()
	                        .equals(studentName)
	        ) {

	            for (Course course :
	                    student.getCourses()) {

	                comboCourses.addItem(
	                        course.getCourseName()
	                );
	            }
	        }
	    }
	}
	
	private void loadEvaluations() {

	    model.setRowCount(0);

	    if (
	            comboStudents.getSelectedItem() == null ||
	            comboCourses.getSelectedItem() == null
	    ) {

	        return;
	    }

	    String studentName =
	            comboStudents.getSelectedItem()
	                    .toString();

	    String courseName =
	            comboCourses.getSelectedItem()
	                    .toString();

	    for (Student student :
	            manager.getStudents()) {

	        if (
	                student.getName()
	                        .equals(studentName)
	        ) {

	            for (Course course :
	                    student.getCourses()) {

	                if (
	                        course.getCourseName()
	                                .equals(courseName)
	                ) {

	                    for (Evaluation evaluation :
	                            course.getEvaluations()) {

	                        double score = 0;

	                        String type = "";

	                        if (
	                                evaluation instanceof WrittenExam
	                        ) {

	                            score =
	                                    ((WrittenExam) evaluation)
	                                            .getScore();

	                            type = "Examen";

	                        } else if (
	                                evaluation instanceof LabEvaluation
	                        ) {

	                            score =
	                                    ((LabEvaluation) evaluation)
	                                            .getScore();

	                            type = "Laboratorio";

	                        } else if (
	                                evaluation instanceof ProjectEvaluation
	                        ) {

	                            score =
	                                    ((ProjectEvaluation) evaluation)
	                                            .getScore();

	                            type = "Proyecto";
	                        }

	                        model.addRow(new Object[] {

	                                evaluation.getName(),
	                                evaluation.getPercentage(),
	                                score,
	                                type
	                        });
	                    }

	                    double finalGrade =
	                            course.calculateFinalGrade();

	                    lblFinalNote.setText(
	                            "Nota Final: "
	                            + String.format(
	                                    "%.2f",
	                                    finalGrade
	                            )
	                    );

	                    if (finalGrade >= 61) {

	                        lblStatus.setText(
	                                "Estado: APROBADO"
	                        );

	                    } else {

	                        lblStatus.setText(
	                                "Estado: REPROBADO"
	                        );
	                    }
	                }
	            }
	        }
	    }
	}
	
}
	


