package cadastro.view;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import cadastro.dao.AlunoCursoDao;
import cadastro.dao.AlunoDao;
import cadastro.dao.CursoDao;
import cadastro.model.Aluno;
import cadastro.model.AlunoCurso;
import cadastro.model.Curso;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.Color;

public class CadastroAluno extends JFrame {

	/**
	 * 
	 * Classe view de cadastro de novos alunos
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel panel;
	private JPanel panel_1;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnAjuda;
	private JLabel lblRgm;
	private JLabel lblNome;
	private JLabel lblDataDeNascimento;
	private JLabel lblCpf;
	private JLabel lblEmail;
	private JLabel lblEnd;
	private JLabel lblMunicpio;
	private JLabel lblCelular;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtEnd;
	private JTextField txtMun;
	private JFormattedTextField txtData;
	private JFormattedTextField txtCpf;
	private MaskFormatter fmtRgm;
	private MaskFormatter fmtCpf;
	private MaskFormatter fmtData;
	private MaskFormatter fmtTelefone;
	private ButtonGroup grupoRadio;
	private JComboBox cmbUf;
	private JLabel lblUf;
	private JMenu mnMenu;
	private JMenuItem mntmSair;
	private JFormattedTextField txtTel;
	private JMenuItem mntmVoltarAoMenu;
	private JMenuItem mntmCadastrarAluno;
	private JButton btnAdd;
	private JButton btnAdd_1;
	private JLabel lblCurso;
	private JLabel lblCampus;
	private JLabel lblPerodo;
	private JComboBox cmbCurso;
	private JComboBox cmbCampus;
	private JRadioButton rdbtnMatutino;
	private JRadioButton rdbtnVespertino;
	private JRadioButton rdbtnNoturno;
	private JFormattedTextField txtRgm;
	
	private Aluno aluno;
	private Curso curso;
	private AlunoDao alunoDao;
	private CursoDao cursoDao;
	private AlunoCurso alunoCurso;
	private List<Curso> listaCurso;
	private AlunoCursoDao alunoCursoDao;
	private JLabel lblChecagem;
	

	

	/**
	 * Launch the application.
	 */


	/**
	 * Create the frame.
	 */
	public CadastroAluno() throws ParseException {
		setResizable(false);
		fmtRgm = new MaskFormatter("####-#");
		fmtRgm.setValidCharacters("0123456789");
		fmtCpf = new MaskFormatter("###.###.###-##");
		fmtCpf.setValidCharacters("0123456789");
		fmtData = new MaskFormatter("##-##-####");
		fmtData.setValidCharacters("0123456789");
		fmtTelefone = new MaskFormatter("(##)#####-####");
		fmtTelefone.setValidCharacters("0123456789");
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(700, 350, 700, 400);
		setTitle("Cadastrar Aluno");
		
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
		
		mntmVoltarAoMenu = new JMenuItem("Voltar");
		mntmVoltarAoMenu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_B, InputEvent.CTRL_MASK));
		mntmVoltarAoMenu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				try {
					MainView main = new MainView();
					main.setBounds(getBounds());
					setVisible(false);
					main.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
						
			}
		});
		mnMenu.add(mntmVoltarAoMenu);
		mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mnMenu.add(mntmSair);
		
		mnNewMenu = new JMenu("Aluno");
		menuBar.add(mnNewMenu);
		
		mntmCadastrarAluno = new JMenuItem("Cadastrar Aluno");
		mntmCadastrarAluno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mntmCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cadastrar();		
			}
		});
		mnNewMenu.add(mntmCadastrarAluno);
		
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
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 32, 676, 328);
		contentPane.add(tabbedPane);
		
		panel = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, panel, null);
		panel.setLayout(null);
		
		lblRgm = new JLabel("RGM");
		lblRgm.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRgm.setBounds(12, 12, 77, 23);
		panel.add(lblRgm);
		
		lblNome = new JLabel("Nome");
		lblNome.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNome.setBounds(294, 12, 77, 23);
		panel.add(lblNome);
		
		lblDataDeNascimento = new JLabel("Data de Nascimento");
		lblDataDeNascimento.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDataDeNascimento.setBounds(12, 54, 202, 23);
		panel.add(lblDataDeNascimento);
		
		lblCpf = new JLabel("CPF");
		lblCpf.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCpf.setBounds(344, 54, 77, 23);
		panel.add(lblCpf);
		
		lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEmail.setBounds(12, 99, 77, 23);
		panel.add(lblEmail);
		
		lblEnd = new JLabel("End.");
		lblEnd.setFont(new Font("Dialog", Font.BOLD, 16));
		lblEnd.setBounds(12, 139, 77, 23);
		panel.add(lblEnd);
		
		lblMunicpio = new JLabel("Município");
		lblMunicpio.setFont(new Font("Dialog", Font.BOLD, 16));
		lblMunicpio.setBounds(12, 173, 122, 23);
		panel.add(lblMunicpio);
		
		lblCelular = new JLabel("Celular");
		lblCelular.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCelular.setBounds(396, 173, 77, 23);
		panel.add(lblCelular);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Dialog", Font.BOLD, 16));
		txtNome.setColumns(10);
		txtNome.setBounds(365, 12, 264, 27);
		panel.add(txtNome);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Dialog", Font.BOLD, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(67, 97, 379, 27);
		panel.add(txtEmail);
		
		txtEnd = new JTextField();
		txtEnd.setFont(new Font("Dialog", Font.BOLD, 16));
		txtEnd.setColumns(10);
		txtEnd.setBounds(67, 134, 379, 27);
		panel.add(txtEnd);
		
		txtMun = new JTextField();
		txtMun.setFont(new Font("Dialog", Font.BOLD, 16));
		txtMun.setColumns(10);
		txtMun.setBounds(104, 171, 160, 27);
		panel.add(txtMun);
		
		txtData = new JFormattedTextField(fmtData);
		txtData.setFont(new Font("Dialog", Font.BOLD, 16));
		txtData.setBounds(204, 53, 122, 27);
		panel.add(txtData);	
		txtData.setColumns(6);
		
		txtCpf = new JFormattedTextField(fmtCpf);
		txtCpf.setFont(new Font("Dialog", Font.BOLD, 16));
		txtCpf.setBounds(389, 53, 185, 27);
		panel.add(txtCpf);
		txtCpf.setColumns(2);

		cmbUf = new JComboBox();
		cmbUf.setModel(new DefaultComboBoxModel(new String[] {"AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RO", "RR", "SC", "SP", "SE", "TO"}));
		cmbUf.setBounds(327, 173, 52, 24);
		panel.add(cmbUf);
		
		lblUf = new JLabel("UF");
		lblUf.setFont(new Font("Dialog", Font.BOLD, 16));
		lblUf.setBounds(288, 173, 38, 23);
		panel.add(lblUf);
		
		txtTel = new JFormattedTextField(fmtTelefone);
		txtTel.setFont(new Font("Dialog", Font.BOLD, 16));
		txtTel.setColumns(6);
		txtTel.setBounds(467, 172, 122, 27);
		panel.add(txtTel);
		
		btnAdd = new JButton("");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cadastrar();
			}
		});
		btnAdd.setIcon(new ImageIcon("/home/phyrosx/eclipse-workspace/cadastro-aluno/src/icons/icons8-ok-64.png"));
		btnAdd.setBounds(489, 211, 77, 69);
		panel.add(btnAdd);
		
		btnAdd_1 = new JButton("");
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpar();
			}
		});
		btnAdd_1.setIcon(new ImageIcon("/home/phyrosx/eclipse-workspace/cadastro-aluno/src/icons/icons8-cancelar-64.png"));
		btnAdd_1.setBounds(582, 211, 77, 69);
		panel.add(btnAdd_1);
		
		txtRgm = new JFormattedTextField(fmtRgm);
		txtRgm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

			}
			@Override
			public void keyReleased(KeyEvent e) {
				if(consultarRgm() != false) {
					lblChecagem.setForeground(Color.RED);
					lblChecagem.setText("Rgm já cadastrado");	
				}else {
					lblChecagem.setForeground(Color.GREEN);
					lblChecagem.setText("Não cadastrado");	
				}
				
			}
		});
		txtRgm.setBounds(67, 12, 160, 27);
		panel.add(txtRgm);
		
		lblChecagem = new JLabel("Checagem RGM");
		lblChecagem.setBackground(Color.BLACK);
		lblChecagem.setBounds(72, 38, 157, 15);
		panel.add(lblChecagem);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Curso", null, panel_1, null);
		panel_1.setLayout(null);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCurso.setBounds(12, 28, 59, 23);
		panel_1.add(lblCurso);
		
		lblCampus = new JLabel("Campus");
		lblCampus.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCampus.setBounds(12, 73, 81, 23);
		panel_1.add(lblCampus);
		
		lblPerodo = new JLabel("Período");
		lblPerodo.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPerodo.setBounds(38, 123, 77, 23);
		panel_1.add(lblPerodo);
			
		cmbCurso = new JComboBox();
		cmbCurso.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {
					int cod = listaCurso.get(cmbCurso.getSelectedIndex()).getCursoId();						
				}catch(Exception e) {			
					JOptionPane.showMessageDialog(null, "Erro ao carregar cursos!");
				}				
			}
		});
		cmbCurso.setBounds(98, 29, 403, 23);
		panel_1.add(cmbCurso);
	
		cmbCampus = new JComboBox();
		cmbCampus.setModel(new DefaultComboBoxModel(new String[] {"Tatuapé", "Anália Franco", "Morumbi"}));
		cmbCampus.setBounds(98, 74, 403, 23);
		panel_1.add(cmbCampus);
		
		rdbtnVespertino = new JRadioButton("Vespertino ");
		rdbtnVespertino.setActionCommand("Vespertino");
		rdbtnVespertino.setFont(new Font("Dialog", Font.BOLD, 16));
		rdbtnVespertino.setBounds(267, 123, 139, 23);
		panel_1.add(rdbtnVespertino);
		
		rdbtnNoturno = new JRadioButton("Noturno ");
		rdbtnNoturno.setActionCommand("Noturno");
		rdbtnNoturno.setFont(new Font("Dialog", Font.BOLD, 16));
		rdbtnNoturno.setBounds(418, 123, 104, 23);
		panel_1.add(rdbtnNoturno);
		
		rdbtnMatutino = new JRadioButton("Matutino ");
		rdbtnMatutino.setSelected(true);
		rdbtnMatutino.setActionCommand("Matutino");
		rdbtnMatutino.setBounds(129, 121, 122, 27);
		panel_1.add(rdbtnMatutino);
		rdbtnMatutino.setFont(new Font("Dialog", Font.BOLD, 16));

		
		grupoRadio = new ButtonGroup();
		grupoRadio.add(rdbtnMatutino);
		grupoRadio.add(rdbtnVespertino);
		grupoRadio.add(rdbtnNoturno);
		
		consultarCursos();
	}

	
	public void limpar() {
		txtRgm.setText(null);
		txtNome.setText(null);
		txtCpf.setText(null);
		txtData.setText(null);
		txtEmail.setText(null);
		txtEnd.setText(null);
		txtMun.setText(null);
		cmbUf.setSelectedIndex(0);
		txtTel.setText(null);
		
	}
	
	public boolean consultarRgm() {
		try {
			alunoDao = new AlunoDao();
			String rgm = txtRgm.getText();
			
			if(alunoDao.consultarAluno(rgm) != null) {
				return true;
				
			}else return false;
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro na consulta!" + e.getMessage());	
		}
		return false;

	}	
	
	public void cadastrar(){
		try {
			aluno = new Aluno();
			alunoCurso = new AlunoCurso();
			alunoCursoDao = new AlunoCursoDao();
			alunoDao = new AlunoDao();
			
			aluno.setRgm(txtRgm.getText());
			aluno.setNome(txtNome.getText());
			aluno.setCpf(txtCpf.getText());
			aluno.setDate(txtData.getText());
			aluno.setEmail(txtEmail.getText());
			aluno.setEndereço(txtEnd.getText());
			aluno.setMunicipio(txtMun.getText());
			aluno.setEstado((String)cmbUf.getSelectedItem());
			aluno.setTelefone(txtTel.getText());
			alunoDao.salvar(aluno);	
			
			alunoCurso.setRgm(txtRgm.getText());
			alunoCurso.setCursoId(listaCurso.get(cmbCurso.getSelectedIndex()).getCursoId());
			alunoCurso.setCampus((String)cmbCampus.getSelectedItem());
			alunoCurso.setPeriodo(grupoRadio.getSelection().getActionCommand());
			alunoCursoDao.matricularCurso(alunoCurso);
				
			JOptionPane.showMessageDialog(null, "Aluno Cadastrado com sucesso");
			
			limpar();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Salvar" + e.getMessage());		
		}
	}
	
	public void consultarCursos() {
		try {	
			cursoDao = new CursoDao();
			listaCurso = cursoDao.listarCursos();
			
			for(Curso obj : listaCurso) {
				cmbCurso.addItem(obj.getNome());	
			}
		
		}catch (Exception e){
			JOptionPane.showMessageDialog(null, "Erro ao listar cursos " + e.getMessage());
		}
	}
}
