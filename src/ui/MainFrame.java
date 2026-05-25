package ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Image;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 825, 566);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(null);
		panel.setBounds(0, 0, 186, 527);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Campus");
		lblNewLabel_2.setForeground(new Color(128, 0, 255));
		lblNewLabel_2.setFont(new Font("Arial Black", Font.PLAIN, 16));
		lblNewLabel_2.setBounds(56, 11, 85, 23);
		panel.add(lblNewLabel_2);
		
		
		JLabel lblNewLabel_LogoCampus = new JLabel();
		lblNewLabel_LogoCampus.setBounds(7, 6, 40, 40);
		panel.add(lblNewLabel_LogoCampus);
		ImageIcon icon = new ImageIcon(
		        MainFrame.class.getResource("/Images/logoCampus.png")
		);
		Image img = icon.getImage();
		Image scaledImg = img.getScaledInstance(
		        40,
		        40,
		        Image.SCALE_SMOOTH
		);
		lblNewLabel_LogoCampus.setIcon(new ImageIcon(scaledImg));
		
		
		
		
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setBounds(7, 106, 27, 28);
		panel.add(lblNewLabel_3);
		ImageIcon iconEstudiante = new ImageIcon(
		        MainFrame.class.getResource("/Images/logoEstudiante.png")
		);
		Image imgEstudiante = iconEstudiante.getImage();
		Image scaledImgEstudiante = imgEstudiante.getScaledInstance(
		        27,
		        28,
		        Image.SCALE_SMOOTH
		);

		lblNewLabel_3.setIcon(new ImageIcon(scaledImgEstudiante));
		
		JButton btnNewButtonStudents = new JButton("Estudiantes");
		btnNewButtonStudents.setBounds(46, 106, 118, 28);
		panel.add(btnNewButtonStudents);
		
		
		
		JLabel lblNewLabel_4 = new JLabel();
		lblNewLabel_4.setBounds(7, 184, 27, 28);
		panel.add(lblNewLabel_4);
		ImageIcon iconCurso = new ImageIcon(
		        MainFrame.class.getResource("/Images/logoCurso.png")
		);
		Image imgCurso = iconCurso.getImage();
		Image scaledImgCurso = imgCurso.getScaledInstance(
		        27,
		        28,
		        Image.SCALE_SMOOTH
		);
		lblNewLabel_4.setIcon(new ImageIcon(scaledImgCurso));
		
		
		
		JButton btnNewButtonCourse = new JButton("Curso");
		btnNewButtonCourse.setBounds(46, 184, 118, 28);
		panel.add(btnNewButtonCourse);
		
		
		
		
		JLabel lblNewLabel_5 = new JLabel();
		lblNewLabel_5.setBounds(7, 250, 27, 28);
		panel.add(lblNewLabel_5);
		ImageIcon iconEvaluaciones = new ImageIcon(
		        MainFrame.class.getResource("/Images/logoEvaluaciones.png")
		);
		Image imgEvaluaciones = iconEvaluaciones.getImage();
		Image scaledImgEvaluaciones = imgEvaluaciones.getScaledInstance(
		        27,
		        28,
		        Image.SCALE_SMOOTH
		);
		lblNewLabel_5.setIcon(new ImageIcon(scaledImgEvaluaciones));
		
		
		
		
		JButton btnNewButtonEvaluations = new JButton("Evaluaciones");
		btnNewButtonEvaluations.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButtonEvaluations.setBounds(46, 250, 118, 28);
		panel.add(btnNewButtonEvaluations);
		
		
		
		
		
		JLabel lblNewLabel_6 = new JLabel();
		lblNewLabel_6.setBounds(7, 314, 27, 28);
		panel.add(lblNewLabel_6);
		ImageIcon iconReportes = new ImageIcon(
		        MainFrame.class.getResource("/Images/logoReportes.png")
		);

		Image imgReportes = iconReportes.getImage();
		Image scaledImgReportes = imgReportes.getScaledInstance(
		        27,
		        28,
		        Image.SCALE_SMOOTH
		);
		lblNewLabel_6.setIcon(new ImageIcon(scaledImgReportes));
		
		JButton btnNewButtonReports = new JButton("Reportes");
		btnNewButtonReports.setBounds(46, 314, 118, 28);
		panel.add(btnNewButtonReports);
		
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Gestiona estudiantes,cursos y evaluaciones desde un solo lugar.");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(223, 49, 516, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("¡BIENVENIDO!");
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 14));
		lblNewLabel.setBounds(228, 11, 125, 27);
		contentPane.add(lblNewLabel);

	}
}
