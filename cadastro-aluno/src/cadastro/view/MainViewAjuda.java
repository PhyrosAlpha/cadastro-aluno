package cadastro.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;

public class MainViewAjuda extends JFrame {

	private JPanel contentPane;
	private JTextArea txtrTutorial;
	private JScrollPane scrollPane;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public MainViewAjuda() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 12, 367, 188);
		contentPane.add(scrollPane);
		
		txtrTutorial = new JTextArea();
		scrollPane.setViewportView(txtrTutorial);
		txtrTutorial.setText("Tutorial");
	}

}
