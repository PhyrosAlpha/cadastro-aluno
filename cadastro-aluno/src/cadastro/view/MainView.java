package cadastro.view;


import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.awt.event.InputEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.ImageIcon;


public class MainView extends JFrame {

	private JPanel contentPane;
	private JMenuBar menuBar;
	private JMenu mnAjuda;
	private MaskFormatter fmtCpf;
	private MaskFormatter fmtData;
	private MaskFormatter fmtTelefone;
	private JMenu mnMenu;
	private JMenuItem mntmSair;
	private JButton btnNewButton;
	private JMenuItem mntmCadastrarAluno;
	private JMenuItem mntmConsultarAluno;
	private JButton btnNewButton_1;
	private JLabel lblOlUsurioO;
	private JLabel lblCadastrarUmNovo;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public MainView() throws ParseException {
		setResizable(false);

		fmtCpf = new MaskFormatter("###.###.###-##");
		fmtCpf.setValidCharacters("0123456789");
		fmtData = new MaskFormatter("##/##/####");
		fmtData.setValidCharacters("0123456789");
		fmtTelefone = new MaskFormatter("(##)#####-####");
		fmtTelefone.setValidCharacters("0123456789");
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 350, 700, 400);
		setTitle("Gerenciador de Alunos 0.1");
		
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mnMenu = new JMenu("Menu");
		menuBar.add(mnMenu);
		
		mntmSair = new JMenuItem("Sair");
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		mntmCadastrarAluno = new JMenuItem("Cadastrar Aluno");
		mntmCadastrarAluno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
		mntmCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarParaTelaCadastrarAluno();
			}
		});
		mnMenu.add(mntmCadastrarAluno);
		
		mntmConsultarAluno = new JMenuItem("Consultar Aluno");
		mntmConsultarAluno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, InputEvent.CTRL_MASK));
		mntmConsultarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarParaTelaConsultarAluno();
			}
		});
		mnMenu.add(mntmConsultarAluno);
		mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mnMenu.add(mntmSair);
		
		mnAjuda = new JMenu("Ajuda");
		mnAjuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
			}
		});
		menuBar.add(mnAjuda);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarParaTelaCadastrarAluno();				
			}
		});
		btnNewButton.setIcon(new ImageIcon("/home/phyrosx/eclipse-workspace/cadastro-aluno/src/icons/icons8-documento-128.png"));
		btnNewButton.setBounds(109, 76, 136, 123);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mudarParaTelaConsultarAluno();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("/home/phyrosx/eclipse-workspace/cadastro-aluno/src/icons/icons8-pasta-128.png"));
		btnNewButton_1.setBounds(420, 76, 162, 123);
		contentPane.add(btnNewButton_1);
		
		lblOlUsurioO = new JLabel("Olá usuário o que deseja fazer?");
		lblOlUsurioO.setFont(new Font("DialogInput", Font.BOLD, 18));
		lblOlUsurioO.setBounds(166, 12, 381, 30);
		contentPane.add(lblOlUsurioO);
		
		lblCadastrarUmNovo = new JLabel("Cadastrar um novo aluno");
		lblCadastrarUmNovo.setBounds(88, 211, 185, 15);
		contentPane.add(lblCadastrarUmNovo);
		
		lblNewLabel = new JLabel("Consultar e alterar dados de um aluno");
		lblNewLabel.setBounds(379, 211, 284, 15);
		contentPane.add(lblNewLabel);
	}
	
	public void mudarParaTelaCadastrarAluno() {
		dispose();
		try {
			CadastroAluno telaCadastroAluno = new CadastroAluno();
			telaCadastroAluno.setBounds(this.getBounds());
			telaCadastroAluno.setVisible(true);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
	}
	
	public void mudarParaTelaConsultarAluno() {
		dispose();
		try {
			ConsultaAluno telaConsultaAluno = new ConsultaAluno();
			telaConsultaAluno.setBounds(this.getBounds());
			telaConsultaAluno.setVisible(true);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
				
	}
}
