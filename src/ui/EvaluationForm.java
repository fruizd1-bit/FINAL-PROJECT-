package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;

public class EvaluationForm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNameEvaluation;
	private JTextField textPorcentaje;
	private JTextField textNota;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EvaluationForm frame = new EvaluationForm();
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
	public EvaluationForm() {
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
		
		JComboBox comboBoxWrittenExam = new JComboBox();
		comboBoxWrittenExam.setBounds(173, 188, 30, 22);
		panel.add(comboBoxWrittenExam);
		
		JLabel lblComboBoxTipodeEvaluacion = new JLabel("Tipo de Evaluación");
		lblComboBoxTipodeEvaluacion.setFont(new Font("Arial Black", Font.PLAIN, 12));
		lblComboBoxTipodeEvaluacion.setBounds(10, 187, 151, 22);
		panel.add(lblComboBoxTipodeEvaluacion);
		
		JComboBox comboBoxLabEvaluatio = new JComboBox();
		comboBoxLabEvaluatio.setBounds(213, 188, 30, 22);
		panel.add(comboBoxLabEvaluatio);
		
		JComboBox comboBoxProjectEvaluation = new JComboBox();
		comboBoxProjectEvaluation.setBounds(253, 188, 30, 22);
		panel.add(comboBoxProjectEvaluation);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(0, 216, 809, 67);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.LIGHT_GRAY);
		panel_3.setBounds(0, 279, 809, 248);
		panel.add(panel_3);
		panel_3.setLayout(null);

	}
}
