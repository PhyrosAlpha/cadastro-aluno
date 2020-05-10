package cadastro.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class MainViewHelp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	protected  JTextPane txtHelp;
	private JLabel lblNewLabel;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_1;

	/**
		Janela que exibirá uma msg com intruções para auxiliar os usuários.
	


	/**
	 * Create the dialog.
	 */
	
	public MainViewHelp() {
		
		setResizable(false);// Impede de mexer nas dimensões durante a execução do programa
		this.setModal(true);// Quando a janela for aberta impede que a janela "pai" seja acessada bloqueando a mesma até que a janela atual seja encerrada.
		setBounds(100, 100, 451, 304);
		getContentPane().setLayout(new BorderLayout());
		setTitle("Janela de ajuda");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 98, 367, 131);
		contentPanel.add(scrollPane);
		
		txtHelp = new JTextPane();
		txtHelp.setEditable(false);
		scrollPane.setViewportView(txtHelp);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("/home/phyrosx/git/cadastro-aluno/cadastro-aluno/src/icons/icons8-ideia-64.png"));
		lblNewLabel.setBounds(40, 22, 74, 64);
		contentPanel.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Ajuda");
		lblNewLabel_1.setFont(new Font("Abyssinica SIL", Font.BOLD, 20));
		lblNewLabel_1.setBounds(126, 32, 65, 42);
		contentPanel.add(lblNewLabel_1);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						setVisible(false);		
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}

		}
	}
}
