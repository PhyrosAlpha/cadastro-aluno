package cadastro.view;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.text.ParseException;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
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
import javax.swing.JList;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JScrollPane;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

//------Models necessarios------\\
import cadastro.dao.AlunoDao;
import cadastro.dao.CursoDao;
import cadastro.dao.DisciplinaDao;
import cadastro.dao.MatriculaDao;
import cadastro.model.Aluno;
import cadastro.model.Curso;
import cadastro.model.Disciplina;
import cadastro.model.Matricula;
import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;


public class ConsultaAluno extends JFrame {

	/**
	 * 
	 * Classe view responsável por servir de interface
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
	private JFormattedTextField txtRgm;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JTextField txtEnd;
	private JTextField txtMun;
	private JFormattedTextField txtData;
	private JFormattedTextField txtCpf;
	private JComboBox<String> cmbUf;
	private JLabel lblUf;
	private JMenu mnMenu;
	private JMenuItem mntmSair;
	private JFormattedTextField txtTel;
	private JMenuItem mntmVoltarAoMenu;
	private JMenuItem mntmCadastrarAluno;
	private JButton btnEditar;
	private JLabel lblCurso;
	private JLabel lblCampus;
	private JLabel lblPerodo;
	private JMenuItem mntmSalvarAlteraes;
	private JLabel lblConsultarAluno;
	private JLabel lblRgm_1;
	private JFormattedTextField txtRgmConsulta;
	private JButton btnPesquisar;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JTextField txtMostrarNome;
	private JTextField txtMostrarRgm;
	private JTextField txtMostrarCurso;
	private JLabel lblRgm_2;
	private JLabel lblCurso_1;
	private JLabel lblNome_1;
	private JButton btnCancelarPesquisa;
	private JLabel lblCurso_2;
	private JLabel lblCurso_3;
	private JLabel lblCurso_4;
	private JLabel lblCurso_5;
	private JTextField txtFalta;
	private JTextField txtNota;
	private JComboBox cmbDisciplinas;
	private JComboBox<String> cmbSemestre;
	private JList<String> listDisciplinas;
	private JLabel lblDisciplinasCurso;
	private JLabel lblDisciplinasMatriculadas;
	private JList<String> listDisciplinasMatriculadas;
	private JButton btnMatricular;
	private JButton btnDeletar;
	private JTextField txtCurso2;
	private JLabel lblCurso_6;
	private JTextField txtDisciplinaSelect;
	private JTextField txtCurso;
	private JTextField txtCampus;
	private JTextField txtPeriodo;
	private JLabel lblInformaesDoCurso;
	private Matricula matricula;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
	private JButton btnEditarDadosDisciplina;
	private JLabel lblCurso_7;
	private JComboBox<String> cmbStatus;
	private JLabel lblBoletim;
	private JLabel lblNome_3;
	private JLabel lblCurso_9;
	private JLabel lblRgm_4;
	private JLabel lblNomeBoletim;
	private JLabel lblCursoBoletim;
	private JLabel lblRgmBoletim;
	private JTextField txtTeste;
	private JButton btnExcluirAluno;
	
	
	
	//-----------Listas-----------------\\          // Listas necessárias que exibem conjuntos de dados do banco de dados.
	private DefaultListModel<String> listElementsDisciplinas;
	private DefaultListModel listElementsDisciplinasMatriculadas;
	private DefaultComboBoxModel cmbListElementsDisciplinasMatriculadas;
	private List<String> cmbList;
	
	//---------Atributos necessarios-------\\
	private Aluno aluno;							//Esses atributos permitem que os dados transferidos pelas classes DAO sejam visiveis durante a execução do app, esses dados ficam na memória ram.
	private MatriculaDao matriculaDao;
	private AlunoDao alunoDao;
	private DisciplinaDao disciplinaDao;
	private ResultSet rs;
	private List<Disciplina> disciplinas;
	private List<Matricula> matriculas;
	
	//---------Formatadores--------\\
	private MaskFormatter fmtRgm;					//Formatadores usados em conjunto com JFormattedText para apenas aceitar os caracteres específicos num determinado formato.
	private MaskFormatter fmtCpf;
	private MaskFormatter fmtData;
	private MaskFormatter fmtTelefone;
	private JTable tableBoletim;
	private JScrollPane scrollPane_2;
	private CursoDao cursoDao;
	private Curso curso;
	private JLabel lblFormao;
	private JLabel lblrea;
	private JTextField txtFormacao;
	private JTextField txtArea;
	

	public ConsultaAluno() throws ParseException {
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
		setTitle("Consultar Aluno");
		
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
					setVisible(false);
					main.setVisible(true);
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
						
			}
		});
		mnMenu.add(mntmVoltarAoMenu);
		mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, InputEvent.CTRL_MASK));
		mnMenu.add(mntmSair);
		
		mnNewMenu = new JMenu("Aluno");
		menuBar.add(mnNewMenu);
		
		mntmCadastrarAluno = new JMenuItem("Consultar Aluno");
		mntmCadastrarAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(consultarAluno()) {
					listarDisciplinasMatriculadas();
				}
			
			}
		});
		mntmCadastrarAluno.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
		mnNewMenu.add(mntmCadastrarAluno);
		
		mntmSalvarAlteraes = new JMenuItem("Salvar Alterações");
		mntmSalvarAlteraes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tabbedPane.isEnabled()) {
				alterarDadosAluno();		
			}else JOptionPane.showMessageDialog(null, "Essa ação não é possível pois o menu está desabilitado");
			}
		});
		mntmSalvarAlteraes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		mnNewMenu.add(mntmSalvarAlteraes);
		
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
		tabbedPane.setEnabled(false);
		tabbedPane.setBounds(12, 49, 676, 311);
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
		
		txtRgm = new JFormattedTextField(fmtRgm);
		txtRgm.setEnabled(false);
		txtRgm.setFont(new Font("Dialog", Font.BOLD, 16));
		txtRgm.setBounds(67, 11, 160, 27);
		panel.add(txtRgm);
		txtRgm.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			    if ((txtEmail.getText() + e.getKeyChar()).length() > 50) {
			        e.consume();
			    }
			}
		});
		txtNome.setFont(new Font("Dialog", Font.BOLD, 16));
		txtNome.setColumns(10);
		txtNome.setBounds(365, 12, 264, 27);
		panel.add(txtNome);
		
		txtEmail = new JTextField();
		txtEmail.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			    if ((txtNome.getText() + e.getKeyChar()).length() > 50) {
			        e.consume();
			    }
			}
		});
		txtEmail.setFont(new Font("Dialog", Font.BOLD, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(67, 97, 379, 27);
		panel.add(txtEmail);
		
		txtEnd = new JTextField();
		txtEnd.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			    if ((txtEnd.getText() + e.getKeyChar()).length() > 50) {
			        e.consume();
			    }
			}
		});
		txtEnd.setFont(new Font("Dialog", Font.BOLD, 16));
		txtEnd.setColumns(10);
		txtEnd.setBounds(67, 134, 379, 27);
		panel.add(txtEnd);
		
		txtMun = new JTextField();
		txtMun.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
			    if ((txtMun.getText() + e.getKeyChar()).length() > 30) {
			        e.consume();
			    }
			}
		});
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
		txtCpf.setBounds(389, 53, 202, 27);
		panel.add(txtCpf);
		txtCpf.setColumns(2);
	
		cmbUf = new JComboBox<String>();
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
		txtTel.setBounds(467, 172, 185, 27);
		panel.add(txtTel);
		
		btnEditar = new JButton("");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarDadosAluno();
			}
		});
		btnEditar.setIcon(new ImageIcon("/home/phyrosx/eclipse-workspace/cadastro-aluno/src/icons/icons8-editar-64.png"));
		btnEditar.setBounds(497, 203, 77, 69);
		panel.add(btnEditar);
		
		btnExcluirAluno = new JButton("");
		btnExcluirAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int n = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja deletar todos os dados do aluno?","Saída" , JOptionPane.YES_NO_OPTION);
				if(n == JOptionPane.YES_OPTION) {
					excluirAluno();	
				}
		}
		});
		btnExcluirAluno.setEnabled(false);
		btnExcluirAluno.setIcon(new ImageIcon("/home/phyrosx/eclipse-workspace/cadastro-aluno/src/icons/icons8-excluir-64.png"));
		btnExcluirAluno.setBounds(582, 203, 77, 69);
		panel.add(btnExcluirAluno);
		
		panel_1 = new JPanel();
		tabbedPane.addTab("Curso", null, panel_1, null);
		panel_1.setLayout(null);
		
		lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCurso.setBounds(8, 85, 59, 23);
		panel_1.add(lblCurso);
		
		lblCampus = new JLabel("Campus");
		lblCampus.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCampus.setBounds(8, 139, 81, 23);
		panel_1.add(lblCampus);
		
		lblPerodo = new JLabel("Período");
		lblPerodo.setFont(new Font("Dialog", Font.BOLD, 16));
		lblPerodo.setBounds(12, 192, 77, 23);
		panel_1.add(lblPerodo);
		
		txtCurso = new JTextField();
		txtCurso.setEnabled(false);
		txtCurso.setFont(new Font("Dialog", Font.BOLD, 16));
		txtCurso.setColumns(10);
		txtCurso.setBounds(97, 81, 503, 27);
		panel_1.add(txtCurso);
		
		txtCampus = new JTextField();
		txtCampus.setEnabled(false);
		txtCampus.setFont(new Font("Dialog", Font.BOLD, 16));
		txtCampus.setColumns(10);
		txtCampus.setBounds(97, 137, 184, 27);
		panel_1.add(txtCampus);
		
		txtPeriodo = new JTextField();
		txtPeriodo.setEnabled(false);
		txtPeriodo.setFont(new Font("Dialog", Font.BOLD, 16));
		txtPeriodo.setColumns(10);
		txtPeriodo.setBounds(97, 190, 184, 27);
		panel_1.add(txtPeriodo);
		
		lblInformaesDoCurso = new JLabel("Informações do Curso");
		lblInformaesDoCurso.setFont(new Font("Dialog", Font.BOLD, 22));
		lblInformaesDoCurso.setBounds(184, 12, 282, 41);
		panel_1.add(lblInformaesDoCurso);
		
		lblFormao = new JLabel("Formação");
		lblFormao.setFont(new Font("Dialog", Font.BOLD, 16));
		lblFormao.setBounds(298, 139, 94, 23);
		panel_1.add(lblFormao);
		
		lblrea = new JLabel("Área");
		lblrea.setFont(new Font("Dialog", Font.BOLD, 16));
		lblrea.setBounds(299, 192, 81, 23);
		panel_1.add(lblrea);
		
		txtFormacao = new JTextField();
		txtFormacao.setFont(new Font("Dialog", Font.BOLD, 16));
		txtFormacao.setEnabled(false);
		txtFormacao.setColumns(10);
		txtFormacao.setBounds(392, 139, 208, 27);
		panel_1.add(txtFormacao);
		
		txtArea = new JTextField();
		txtArea.setFont(new Font("Dialog", Font.BOLD, 16));
		txtArea.setEnabled(false);
		txtArea.setColumns(10);
		txtArea.setBounds(392, 190, 208, 27);
		panel_1.add(txtArea);
		
		panel_2 = new JPanel();
		tabbedPane.addTab("Disciplinas", null, panel_2, null);
		panel_2.setLayout(null);
		
		
		
		listElementsDisciplinas = new DefaultListModel();	
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 90, 182, 163);
		panel_2.add(scrollPane);
		listDisciplinas = new JList(listElementsDisciplinas);
		listDisciplinas.setFont(new Font("Dialog", Font.BOLD, 16));
		scrollPane.setViewportView(listDisciplinas);
		listDisciplinas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				try {
					int disciplinaId = disciplinas.get(listDisciplinas.getSelectedIndex()).getDisciplinaId();
					txtDisciplinaSelect.setText(Integer.toString(disciplinaId));
					
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Erro ao selecionar disciplinas " + e.getMessage());			
				}	
			}
		});
		listDisciplinas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.DARK_GRAY, null, null));
		
		lblDisciplinasCurso = new JLabel("Disciplinas");
		lblDisciplinasCurso.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDisciplinasCurso.setBounds(82, 55, 182, 23);
		panel_2.add(lblDisciplinasCurso);
		
		
	
		lblDisciplinasMatriculadas = new JLabel("Disciplinas Matriculadas");
		lblDisciplinasMatriculadas.setFont(new Font("Dialog", Font.BOLD, 16));
		lblDisciplinasMatriculadas.setBounds(400, 55, 227, 23);
		panel_2.add(lblDisciplinasMatriculadas);
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(438, 90, 182, 163);
		panel_2.add(scrollPane_1);
		
		listElementsDisciplinasMatriculadas = new DefaultListModel();
		listDisciplinasMatriculadas = new JList(listElementsDisciplinasMatriculadas);
		listDisciplinasMatriculadas.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
			try{
				int numMatricula = matriculas.get(listDisciplinasMatriculadas.getSelectedIndex()).getCursoMatriculaID();
				txtDisciplinaSelect.setText(Integer.toString(numMatricula));
			}catch(Exception e) {
				
			}
				
			}	
		});
		listDisciplinasMatriculadas.setFont(new Font("Dialog", Font.BOLD, 16));
		scrollPane_1.setViewportView(listDisciplinasMatriculadas);
		listDisciplinasMatriculadas.setBorder(new BevelBorder(BevelBorder.LOWERED, null, Color.DARK_GRAY, null, null));
		
		btnMatricular = new JButton("Matricular");
		btnMatricular.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				matricularDisciplina();
			}
		});
		btnMatricular.setBounds(265, 90, 117, 25);
		panel_2.add(btnMatricular);
		
		btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirDisciplina();
				
			}
		});
		btnDeletar.setBounds(265, 144, 117, 25);
		panel_2.add(btnDeletar);
		
		txtCurso2 = new JTextField();
		txtCurso2.setFont(new Font("Dialog", Font.BOLD, 16));
		txtCurso2.setEnabled(false);
		txtCurso2.setColumns(10);
		txtCurso2.setBounds(87, 10, 485, 27);
		panel_2.add(txtCurso2);
		
		lblCurso_6 = new JLabel("Curso");
		lblCurso_6.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCurso_6.setBounds(20, 12, 77, 23);
		panel_2.add(lblCurso_6);
		
		txtDisciplinaSelect = new JTextField();
		txtDisciplinaSelect.setVisible(false);
		txtDisciplinaSelect.setFont(new Font("Dialog", Font.BOLD, 16));
		txtDisciplinaSelect.setColumns(10);
		txtDisciplinaSelect.setBounds(222, 200, 204, 27);
		panel_2.add(txtDisciplinaSelect);
		
		panel_3 = new JPanel();
		tabbedPane.addTab("Notas e Faltas", null, panel_3, null);
		panel_3.setLayout(null);
		
		txtMostrarNome = new JTextField();
		txtMostrarNome.setEnabled(false);
		txtMostrarNome.setFont(new Font("Dialog", Font.BOLD, 16));
		txtMostrarNome.setColumns(10);
		txtMostrarNome.setBounds(99, 12, 329, 27);
		panel_3.add(txtMostrarNome);
		
		txtMostrarRgm = new JTextField();
		txtMostrarRgm.setEnabled(false);
		txtMostrarRgm.setFont(new Font("Dialog", Font.BOLD, 16));
		txtMostrarRgm.setColumns(10);
		txtMostrarRgm.setBounds(500, 12, 137, 27);
		panel_3.add(txtMostrarRgm);
		
		txtMostrarCurso = new JTextField();
		txtMostrarCurso.setEnabled(false);
		txtMostrarCurso.setFont(new Font("Dialog", Font.BOLD, 16));
		txtMostrarCurso.setColumns(10);
		txtMostrarCurso.setBounds(99, 65, 538, 27);
		panel_3.add(txtMostrarCurso);
		
		lblRgm_2 = new JLabel("RGM");
		lblRgm_2.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRgm_2.setBounds(446, 14, 50, 23);
		panel_3.add(lblRgm_2);
		
		lblCurso_1 = new JLabel("Curso");
		lblCurso_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCurso_1.setBounds(12, 67, 77, 23);
		panel_3.add(lblCurso_1);
		
		lblNome_1 = new JLabel("Nome");
		lblNome_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNome_1.setBounds(12, 14, 77, 23);
		panel_3.add(lblNome_1);
		
		lblCurso_2 = new JLabel("Disciplina");
		lblCurso_2.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCurso_2.setBounds(12, 117, 89, 23);
		panel_3.add(lblCurso_2);
		
		lblCurso_3 = new JLabel("Semestre");
		lblCurso_3.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCurso_3.setBounds(12, 164, 89, 23);
		panel_3.add(lblCurso_3);
		
		lblCurso_4 = new JLabel("Nota");
		lblCurso_4.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCurso_4.setBounds(478, 117, 77, 23);
		panel_3.add(lblCurso_4);
		
		lblCurso_5 = new JLabel("Falta");
		lblCurso_5.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCurso_5.setBounds(478, 164, 77, 23);
		panel_3.add(lblCurso_5);
		
		txtFalta = new JTextField();
		txtFalta.setFont(new Font("Dialog", Font.BOLD, 16));
		txtFalta.setColumns(10);
		txtFalta.setBounds(535, 162, 50, 27);
		panel_3.add(txtFalta);
		
		txtNota = new JTextField();
		txtNota.setFont(new Font("Dialog", Font.BOLD, 16));
		txtNota.setColumns(10);
		txtNota.setBounds(535, 113, 50, 27);
		panel_3.add(txtNota);
		
		cmbListElementsDisciplinasMatriculadas = new DefaultComboBoxModel();
		cmbDisciplinas = new JComboBox();
		cmbDisciplinas.setModel(cmbListElementsDisciplinasMatriculadas);
		cmbDisciplinas.setMaximumRowCount(50);
		cmbDisciplinas.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				try {
					int numMatricula = matriculas.get(cmbDisciplinas.getSelectedIndex()).getCursoMatriculaID();
					double nota = matriculas.get(cmbDisciplinas.getSelectedIndex()).getNota();
					int faltas = matriculas.get(cmbDisciplinas.getSelectedIndex()).getFaltas();
					String status = matriculas.get(cmbDisciplinas.getSelectedIndex()).getStatus();
					String semestre = matriculas.get(cmbDisciplinas.getSelectedIndex()).getSemestre();
					
					txtNota.setText(Double.toString(nota));
					txtFalta.setText(Integer.toString(faltas));
					cmbStatus.setSelectedItem(status);
					cmbSemestre.setSelectedItem(semestre);
					txtTeste.setText(Integer.toString(cmbDisciplinas.getSelectedIndex()));
					
				}catch (Exception e) {
					
				}
							
			}
		});
		cmbDisciplinas.setFont(new Font("Dialog", Font.BOLD, 16));
		cmbDisciplinas.setBounds(111, 117, 317, 23);
		panel_3.add(cmbDisciplinas);
		
		cmbSemestre = new JComboBox();
		cmbSemestre.setFont(new Font("Dialog", Font.BOLD, 16));
		cmbSemestre.setModel(new DefaultComboBoxModel(new String[] {"N/A", "2019/1", "2019/2", "2020/1", "2020/2", "2021/1", "2021/2"}));
		cmbSemestre.setBounds(111, 164, 137, 23);
		panel_3.add(cmbSemestre);
		
		btnEditarDadosDisciplina = new JButton("");
		btnEditarDadosDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				alterarDadosMatricula();
			}		
		});
		btnEditarDadosDisciplina.setIcon(new ImageIcon("/home/phyrosx/eclipse-workspace/cadastro-aluno/bin/icons/icons8-editar-64.png"));
		btnEditarDadosDisciplina.setBounds(571, 201, 77, 69);
		panel_3.add(btnEditarDadosDisciplina);
		
		lblCurso_7 = new JLabel("Status");
		lblCurso_7.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCurso_7.setBounds(12, 201, 89, 23);
		panel_3.add(lblCurso_7);
		
		cmbStatus = new JComboBox();
		cmbStatus.setModel(new DefaultComboBoxModel(new String[] {"INATIVO", "ATIVO", "APROVADO", "REPROVADO"}));
		cmbStatus.setFont(new Font("Dialog", Font.BOLD, 16));
		cmbStatus.setBounds(111, 201, 137, 23);
		panel_3.add(cmbStatus);
		
		txtTeste = new JTextField();
		txtTeste.setVisible(false);
		txtTeste.setBounds(295, 167, 114, 19);
		panel_3.add(txtTeste);
		txtTeste.setColumns(10);
		
		panel_4 = new JPanel();
		tabbedPane.addTab("Boletim", null, panel_4, null);
		panel_4.setLayout(null);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setFont(new Font("Dialog", Font.BOLD, 14));
		scrollPane_2.setBounds(12, 77, 647, 195);
		panel_4.add(scrollPane_2);
		
		tableBoletim = new JTable();
		scrollPane_2.setViewportView(tableBoletim);
		tableBoletim.setModel(new DefaultTableModel(
		));
		
		lblBoletim = new JLabel("Boletim");
		lblBoletim.setBounds(272, 0, 70, 15);
		panel_4.add(lblBoletim);
		
		lblNome_3 = new JLabel("Nome:");
		lblNome_3.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNome_3.setBounds(12, 12, 70, 23);
		panel_4.add(lblNome_3);
		
		lblCurso_9 = new JLabel("Curso:");
		lblCurso_9.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCurso_9.setBounds(12, 42, 77, 23);
		panel_4.add(lblCurso_9);
		
		lblRgm_4 = new JLabel("RGM:");
		lblRgm_4.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRgm_4.setBounds(394, 17, 57, 23);
		panel_4.add(lblRgm_4);
		
		lblNomeBoletim = new JLabel("nome");
		lblNomeBoletim.setFont(new Font("Dialog", Font.BOLD, 16));
		lblNomeBoletim.setBounds(94, 12, 277, 23);
		panel_4.add(lblNomeBoletim);
		
		lblCursoBoletim = new JLabel("curso");
		lblCursoBoletim.setFont(new Font("Dialog", Font.BOLD, 16));
		lblCursoBoletim.setBounds(94, 42, 531, 23);
		panel_4.add(lblCursoBoletim);
		
		lblRgmBoletim = new JLabel("rgm");
		lblRgmBoletim.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRgmBoletim.setBounds(461, 17, 98, 23);
		panel_4.add(lblRgmBoletim);
			
		lblConsultarAluno = new JLabel("Consultar Aluno");
		lblConsultarAluno.setFont(new Font("Dialog", Font.BOLD, 16));
		lblConsultarAluno.setBounds(43, 12, 155, 23);
		contentPane.add(lblConsultarAluno);
		
		lblRgm_1 = new JLabel("RGM");
		lblRgm_1.setFont(new Font("Dialog", Font.BOLD, 16));
		lblRgm_1.setBounds(236, 12, 77, 23);
		contentPane.add(lblRgm_1);
		
		txtRgmConsulta = new JFormattedTextField(fmtRgm);
		txtRgmConsulta.setFocusLostBehavior(JFormattedTextField.PERSIST);
		txtRgmConsulta.setFont(new Font("Dialog", Font.BOLD, 16));
		txtRgmConsulta.setColumns(10);
		txtRgmConsulta.setBounds(294, 10, 160, 27);
		contentPane.add(txtRgmConsulta);
		
		btnCancelarPesquisa = new JButton("");
		btnCancelarPesquisa.setIcon(new ImageIcon("/home/phyrosx/eclipse-workspace/cadastro-aluno/src/icons/icons8-cancelar-64.png"));
		btnCancelarPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				bloquear();
				limpar();
			}
		});
		btnCancelarPesquisa.setBounds(617, 0, 71, 63);
		contentPane.add(btnCancelarPesquisa);
		
		btnPesquisar = new JButton("");
		btnPesquisar.setBounds(539, 0, 71, 63);
		contentPane.add(btnPesquisar);
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				if(consultarAluno()) {
					listarDisciplinasMatriculadas();
				}
			}
		});
		btnPesquisar.setIcon(new ImageIcon("/home/phyrosx/eclipse-workspace/cadastro-aluno/src/icons/icons8-pesquisar-64.png"));
		
		listarDisciplinas();
		bloquear();
		
	}
	
	public void bloquear(){
		tabbedPane.setEnabled(false);
		tabbedPane.setSelectedIndex(0);
		txtNome.setEnabled(false);
		txtData.setEnabled(false);
		txtCpf.setEnabled(false);
		txtEmail.setEnabled(false);
		txtEnd.setEnabled(false);
		txtMun.setEnabled(false);
		cmbUf.setEnabled(false);
		txtTel.setEnabled(false);
		btnEditar.setEnabled(false);
		btnExcluirAluno.setEnabled(false);
		
	}
	
	public void desbloquear() {				//Quando o rgm for válido o painel é desbloqueado para o uso.
		tabbedPane.setEnabled(true);
		txtNome.setEnabled(true);
		txtData.setEnabled(true);
		txtCpf.setEnabled(true);
		txtEmail.setEnabled(true);
		txtEnd.setEnabled(true);
		txtMun.setEnabled(true);
		cmbUf.setEnabled(true);
		txtTel.setEnabled(true);
		btnEditar.setEnabled(true);
		btnExcluirAluno.setEnabled(true);
	}
	
	public void limpar() {					//Limpa os campos quando for necessário
		txtRgm.setText(null);
		txtNome.setText(null);
		txtCpf.setText(null);
		txtData.setText(null);
		txtEmail.setText(null);
		txtEnd.setText(null);
		txtMun.setText(null);
		cmbUf.setSelectedIndex(0);
		txtTel.setText(null);
		txtRgmConsulta.setText(null);
	}
	
	public void listarDisciplinas() {
		try {
			disciplinaDao = new DisciplinaDao();
			disciplinas = disciplinaDao.listarDisciplinas();			
			for(Disciplina obj : disciplinas) {	
				listElementsDisciplinas.addElement(obj.getNome());
			}			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao listar disciplinas " + e.getMessage());			
		}	
	}
	
	public boolean consultarAluno() {
		try {
			alunoDao = new AlunoDao();
			aluno = new Aluno();	
		    aluno = alunoDao.consultarAluno(txtRgmConsulta.getText());
		    
		    if(aluno != null) {
		    	tabbedPane.setSelectedIndex(0);
		    	JOptionPane.showMessageDialog(null, "Rgm Encontrado");
		    	desbloquear();
		    	
		    	txtRgm.setText(aluno.getRgm());
		    	txtNome.setText(aluno.getNome());
		    	txtData.setText(aluno.getDate());
		    	txtCpf.setText(aluno.getCpf());
		    	txtEmail.setText(aluno.getEmail());
		    	txtEnd.setText(aluno.getEndereço());
		    	txtMun.setText(aluno.getMunicipio());
		    	cmbUf.setSelectedItem(aluno.getEstado());
		    	txtTel.setText(aluno.getTelefone());
		    	

		    	txtPeriodo.setText(aluno.getCurso().getPeriodo());
		    	txtCampus.setText(aluno.getCurso().getCampus());
		    	
		    	txtMostrarRgm.setText(aluno.getRgm());
		    	txtMostrarNome.setText(aluno.getNome());

		    	
		    	lblNomeBoletim.setText(aluno.getNome());
		    	lblRgmBoletim.setText(aluno.getRgm());
		    	
		    	consultarCurso();
		    	return true;
	
		    }else {
		    	JOptionPane.showMessageDialog(null, "Rgm não encontrado");	
		    	return false;
		    }	    	
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Problemas ao pesquisar" + e.getMessage());	
			return false;
		}	
	}
	
	public void consultarCurso() {
		int cursoId = aluno.getCurso().getCursoId();
		
		try {
			curso = new Curso();
			cursoDao = new CursoDao();
			curso = cursoDao.consultaCurso(cursoId);
			
			txtFormacao.setText(curso.getTipo());
			txtArea.setText(curso.getArea());
			txtCurso.setText(curso.getNome());
			txtCurso2.setText(curso.getNome());
			txtMostrarCurso.setText(curso.getNome());
			lblCursoBoletim.setText(curso.getNome());
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Problemas ao Consultar curso" + e.getMessage());			
		}
	
	}
	
	public void matricularDisciplina() {
		try {
			alunoDao = new AlunoDao();	
			matriculaDao = new MatriculaDao();
			matricula = new Matricula();
			matricula.setAlunoCursoID(aluno.getCurso().getAlunoCursoId());
			matricula.setDisciplinaID(disciplinas.get(listDisciplinas.getSelectedIndex()).getDisciplinaId());
			matriculaDao.matricularDisciplina(matricula);
			JOptionPane.showMessageDialog(null, "O aluno " + aluno.getNome() + " foi matriculado com sucesso na disciplina " + listDisciplinas.getSelectedValue());
			listarDisciplinasMatriculadas();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Problemas ao Matricular Disciplina " + e.getMessage());						
		}	
	}
	
	public void listarDisciplinasMatriculadas(){
			
			
		try {
			listElementsDisciplinasMatriculadas.clear();
			cmbListElementsDisciplinasMatriculadas.removeAllElements();
			
			matricula = new Matricula();
			alunoDao = new AlunoDao();
			matriculaDao = new MatriculaDao();
			matriculas = matriculaDao.consultarDisciplinasMatriculadas(aluno.getCurso().getAlunoCursoId());
			
			for(Matricula obj : matriculas) {				
				listElementsDisciplinasMatriculadas.addElement("Id-" + obj.getCursoMatriculaID() + " - " + obj.getDisciplina().getNome());		
				cmbListElementsDisciplinasMatriculadas.addElement("Id-" + obj.getCursoMatriculaID() + " - " + obj.getDisciplina().getNome());
				}
		
			tableBoletim.setModel(DbUtils.resultSetToTableModel(matriculaDao.consultarDisciplinasMatriculadasTable(aluno.getCurso().getAlunoCursoId())));	
				
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Problemas ao Consultar Disciplinas Maticuladas " + e.getMessage());			
		}	
	}
	
	public void alterarDadosAluno(){
		try {
	//		aluno = new Aluno();
	//		alunoDao = new AlunoDao();
			
			aluno.setRgm(txtRgm.getText());
			aluno.setNome(txtNome.getText());
			aluno.setCpf(txtCpf.getText());
			aluno.setDate(txtData.getText());
			aluno.setEmail(txtEmail.getText());
			aluno.setEndereço(txtEnd.getText());
			aluno.setMunicipio(txtMun.getText());
			aluno.setEstado((String)cmbUf.getSelectedItem());
			aluno.setTelefone(txtTel.getText());
			alunoDao.alterarDadosAluno(aluno);	
				
			JOptionPane.showMessageDialog(null, "Dados do aluno " + aluno.getNome() + " alterados com sucesso!");		
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Problemas ao Alterar dados do aluno " + e.getMessage());							
		}
	}
	
	public void alterarDadosMatricula() {
		try {
			matricula = new Matricula();
			
			matricula.setCursoMatriculaID(matriculas.get(cmbDisciplinas.getSelectedIndex()).getCursoMatriculaID());
			matricula.setStatus((String)cmbStatus.getSelectedItem());
			matricula.setSemestre((String)cmbSemestre.getSelectedItem());
			matricula.setNota(Double.valueOf(txtNota.getText()));
			matricula.setFaltas(Integer.valueOf(txtFalta.getText()));	
			matriculaDao.alterarDadosMatricula(matricula);
			
			JOptionPane.showMessageDialog(null, "A disciplina foi alterada com sucesso!");
			listarDisciplinasMatriculadas();
			
		}catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Problemas ao Alterar dados da Matricula " + e.getMessage());		
		}	
	}
	
		public void excluirAluno() {
			try {
				alunoDao = new AlunoDao();
				
				String rgm = aluno.getRgm();
				alunoDao.excluirAluno(rgm);
				
				JOptionPane.showMessageDialog(null, "Aluno excluído com sucesso");
				
				limpar();
				bloquear();
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Problemas ao Excluir dados da Matricula " + e.getMessage());			
			}		
		}
		
		public void excluirDisciplina() {
			try {
				matriculaDao = new MatriculaDao();
				
				int matriculaID = matriculas.get(listDisciplinasMatriculadas.getSelectedIndex()).getCursoMatriculaID();
				matriculaDao.excluirDisciplina(matriculaID);
				
				listarDisciplinasMatriculadas();
				JOptionPane.showMessageDialog(null, "Disciplina excluída com sucesso ");
				
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null, "Problemas ao Excluir dados da Disciplina " + e.getMessage());			
			}		
		}
}