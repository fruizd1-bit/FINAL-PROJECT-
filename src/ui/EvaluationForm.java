package ui;

import java.awt.EventQueue;

import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;

import Dominio.Course;
import Dominio.Evaluation;
import Dominio.Student;
import Dominio.WrittenExam;
import Dominio.LabEvaluation;
import Dominio.ProjectEvaluation;

import servicio.StudentManager;
import servicio.FileManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JButton;

public class EvaluationForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNameEvaluation;
	private JTextField textPorcentaje;
	private JTextField textNota;
	private JTable tableEvaluations;
	private JComboBox<String> comboType;
	private Student student;
	private Course course;
	private StudentManager manager;
	private DefaultTableModel model;
	private CourseForm courseForm;


	/**
	 * Launch the application.
	 */
	

	/**
	 * Create the frame.
	 */
	
	public EvaluationForm(
	        Course course,
	        StudentManager manager,
	        CourseForm courseForm
	){

	    this.course = course;
	    this.manager = manager;
	    this.courseForm = courseForm;
		
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
		panel_1.setBounds(0, 0, 809, 54);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestion de Evaluaciones");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 351, 32);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 65, 62, 22);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Porcentaje");
		lblNewLabel_1_1.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_1_1.setBounds(10, 99, 85, 22);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Nota");
		lblNewLabel_1_2.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblNewLabel_1_2.setBounds(10, 132, 62, 22);
		panel.add(lblNewLabel_1_2);
		
		textNameEvaluation = new JTextField();
		textNameEvaluation.setFont(new Font("Arial Black", Font.PLAIN, 12));
		textNameEvaluation.setBounds(135, 65, 219, 20);
		panel.add(textNameEvaluation);
		textNameEvaluation.setColumns(10);
		
		textPorcentaje = new JTextField();
		textPorcentaje.setFont(new Font("Arial Black", Font.PLAIN, 12));
		textPorcentaje.setColumns(10);
		textPorcentaje.setBounds(135, 101, 219, 20);
		panel.add(textPorcentaje);
		
		textNota = new JTextField();
		textNota.setFont(new Font("Arial Black", Font.PLAIN, 12));
		textNota.setColumns(10);
		textNota.setBounds(135, 134, 219, 20);
		panel.add(textNota);
		
		
		comboType = new JComboBox<>();
		comboType.addItem("Examen");
		comboType.addItem("Laboratorio");
		comboType.addItem("Proyecto");
		comboType.setFont(
		        new Font("Arial Black", Font.PLAIN, 12)
		);

		comboType.setBounds(173, 188, 181, 22);
		panel.add(comboType);
		
		
		
		JLabel lblComboBoxTipodeEvaluacion = new JLabel("Tipo de Evaluación");
		lblComboBoxTipodeEvaluacion.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblComboBoxTipodeEvaluacion.setBounds(10, 187, 151, 22);
		panel.add(lblComboBoxTipodeEvaluacion);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 216, 809, 67);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnAdd = new JButton("Agregar");
		btnAdd.addActionListener(e -> {

		    try {

		        String name =
		                textNameEvaluation.getText();

		        double percentage =
		                Double.parseDouble(
		                        textPorcentaje.getText()
		                );

		        double score =
		                Double.parseDouble(
		                        textNota.getText()
		                );

		        String type =
		                comboType.getSelectedItem()
		                        .toString();

		        Evaluation evaluation = null;

		        if (type.equals("Examen")) {

		            evaluation =
		                    new WrittenExam(
		                            name,
		                            percentage,
		                            score
		                    );

		        } else if (
		                type.equals("Laboratorio")
		        ) {

		            evaluation =
		                    new LabEvaluation(
		                            name,
		                            percentage,
		                            score
		                    );

		        } else if (
		                type.equals("Proyecto")
		        ) {

		            evaluation =
		                    new ProjectEvaluation(
		                            name,
		                            percentage,
		                            score
		                    );
		        }

		        course.addEvaluation(evaluation);

		        FileManager.saveData(manager);

		        refreshTable();

		        JOptionPane.showMessageDialog(
		                null,
		                "Evaluacion agregada"
		        );

		    } catch (Exception ex) {

		        JOptionPane.showMessageDialog(
		                null,
		                ex.getMessage()
		        );
		    }
		});
		
		
		btnAdd.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnAdd.setBounds(10, 11, 99, 33);
		panel_2.add(btnAdd);
		
		
		
		JButton btnSeach = new JButton("Buscar");
		btnSeach.addActionListener(e -> {

		    String name =
		            textNameEvaluation.getText();

		    Evaluation evaluation =
		            course.searchEvaluation(name);

		    if (evaluation != null) {

		        textPorcentaje.setText(
		                String.valueOf(
		                        evaluation.getPercentage()
		                )
		        );

		        double score = 0;

		        if (evaluation instanceof WrittenExam) {

		            score =
		                    ((WrittenExam) evaluation)
		                            .getScore();

		            comboType.setSelectedItem(
		                    "Examen"
		            );

		        } else if (
		                evaluation instanceof LabEvaluation
		        ) {

		            score =
		                    ((LabEvaluation) evaluation)
		                            .getScore();

		            comboType.setSelectedItem(
		                    "Laboratorio"
		            );

		        } else if (
		                evaluation instanceof ProjectEvaluation
		        ) {

		            score =
		                    ((ProjectEvaluation) evaluation)
		                            .getScore();

		            comboType.setSelectedItem(
		                    "Proyecto"
		            );
		        }

		        textNota.setText(
		                String.valueOf(score)
		        );

		        JOptionPane.showMessageDialog(
		                null,
		                "Evaluacion encontrada"
		        );

		    } else {

		        JOptionPane.showMessageDialog(
		                null,
		                "Evaluacion no encontrada"
		        );
		    }
		});
		btnSeach.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnSeach.setBounds(139, 11, 99, 33);
		panel_2.add(btnSeach);
		
		JButton btnEdit = new JButton("Editar");
		btnEdit.addActionListener(e -> {

		    try {

		        String currentName =
		                JOptionPane.showInputDialog(
		                        "Ingrese el nombre actual de la evaluacion"
		                );

		        if (
		                currentName == null ||
		                currentName.isEmpty()
		        ) {

		            return;
		        }

		        String newName =
		                textNameEvaluation.getText();

		        double newPercentage =
		                Double.parseDouble(
		                        textPorcentaje.getText()
		                );

		        double newScore =
		                Double.parseDouble(
		                        textNota.getText()
		                );

		        course.editEvaluation(

		                currentName,
		                newName,
		                newPercentage,
		                newScore
		        );

		        FileManager.saveData(manager);

		        refreshTable();

		        JOptionPane.showMessageDialog(
		                null,
		                "Evaluacion editada correctamente"
		        );

		    } catch (Exception ex) {

		        JOptionPane.showMessageDialog(
		                null,
		                ex.getMessage()
		        );
		    }
		});
		btnEdit.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnEdit.setBounds(268, 11, 99, 33);
		panel_2.add(btnEdit);
		
		JButton btnDelete = new JButton("Eliminar");
		btnDelete.addActionListener(e -> {

		    String name =
		            textNameEvaluation.getText();

		    boolean removed =
		            course.removeEvaluation(name);

		    if (removed) {

		        FileManager.saveData(manager);

		        refreshTable();

		        textNameEvaluation.setText("");
		        textPorcentaje.setText("");
		        textNota.setText("");

		        JOptionPane.showMessageDialog(
		                null,
		                "Evaluacion eliminada"
		        );

		    } else {

		        JOptionPane.showMessageDialog(
		                null,
		                "Evaluacion no encontrada"
		        );
		    }
		});
		btnDelete.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnDelete.setBounds(401, 11, 99, 33);
		panel_2.add(btnDelete);
		
		
		
		JButton btnBack = new JButton("Regresar");
		btnBack.addActionListener(e -> {
		    courseForm.setVisible(true);

		    dispose();
		});
		btnBack.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnBack.setBounds(530, 11, 99, 33);
		panel_2.add(btnBack);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(0, 279, 809, 248);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		
		
		tableEvaluations = new JTable();
		tableEvaluations.setFont(
		        new Font("Arial Black", Font.PLAIN, 12)
		);

		tableEvaluations.setModel(
		        new DefaultTableModel(
		                new Object[][] {},
		                new String[] {
		                        "Nombre",
		                        "Porcentaje",
		                        "Nota",
		                        "Tipo"
		                }
		        )
		);

		tableEvaluations.setBounds(54, 22, 469, 215);
		panel_3.add(tableEvaluations);

		model =
		        (DefaultTableModel)
		                tableEvaluations.getModel();

		refreshTable();
		
		JButton btnFinalNote = new JButton("Calcular Nota Final");
		btnFinalNote.addActionListener(e -> {

		    double finalGrade =
		            course.calculateFinalGrade();

		    JOptionPane.showMessageDialog(
		            null,
		            "Nota Final: " + finalGrade
		    );
		});
		btnFinalNote.setFont(new Font("Arial Black", Font.PLAIN, 12));
		btnFinalNote.setBounds(533, 46, 202, 33);
		panel_3.add(btnFinalNote);

	}
	
	
	private void refreshTable() {

	    model.setRowCount(0);

	    for (Evaluation evaluation :
	            course.getEvaluations()) {

	        double score = 0;

	        if (evaluation instanceof WrittenExam) {

	            score =
	                    ((WrittenExam) evaluation)
	                            .getScore();

	        } else if (
	                evaluation instanceof LabEvaluation
	        ) {

	            score =
	                    ((LabEvaluation) evaluation)
	                            .getScore();

	        } else if (
	                evaluation instanceof ProjectEvaluation
	        ) {

	            score =
	                    ((ProjectEvaluation) evaluation)
	                            .getScore();
	        }

	        model.addRow(new Object[] {

	                evaluation.getName(),
	                evaluation.getPercentage(),
	                score,
	                evaluation.getClass()
	                        .getSimpleName()
	        });
	    }
	}
	
	
}
