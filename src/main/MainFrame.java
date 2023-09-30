package main;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import classes.Cliente;
import classes.UnidadeFederativa;
import conexaoBanco.ClienteDAO;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;

import java.awt.GridLayout;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class MainFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JFormattedTextField textFieldCPF;
	private JTextField textFieldNome;
	private JTextField textFieldRua;
	private JTextField textFieldNumero;
	private JTextField textFieldBairro;
	private JTextField textFieldCidade;
	private JTextField textFieldFone;
	private JTextField textFieldEmail;
	private JFormattedTextField inputDataDeNascimento;

	private JComboBox<UnidadeFederativa> inputUF;
	private JButton botaoConfirmar;
	private JButton botaoCancelar;

	public MainFrame() {
		int height = 70;
		String fonteString = "Arial";
		Color corDeFundo = new Color(222, 245, 250);

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(corDeFundo);
		contentPane.setBorder(new EmptyBorder(15, 30, 15, 30));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelCPF = new JPanel();
		panelCPF.setBackground(corDeFundo);
		panelCPF.setBounds(120, 28, 980, 70);
		contentPane.add(panelCPF);
		panelCPF.setLayout(new BorderLayout(0, 0));

		JLabel textoCPF = new JLabel("CPF*:   ");
		panelCPF.add(textoCPF, BorderLayout.WEST);
		textoCPF.setHorizontalAlignment(SwingConstants.LEFT);
		textoCPF.setFont(new Font(fonteString, Font.BOLD, 32));

		JPanel panelCPFInput = new JPanel();
		panelCPFInput.setBackground(corDeFundo);
		panelCPFInput.setBorder(new EmptyBorder(15, 10, 15, 0));
		panelCPF.add(panelCPFInput, BorderLayout.CENTER);
		panelCPFInput.setLayout(new BorderLayout(0, 0));

		MaskFormatter cpfFormatter = null;

		try {
			cpfFormatter = new MaskFormatter("###.###.###-##");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		textFieldCPF = new JFormattedTextField(cpfFormatter);
		textFieldCPF.setFont(new Font(fonteString, Font.PLAIN, 20));
		panelCPFInput.add(textFieldCPF, BorderLayout.CENTER);
		textFieldCPF.setHorizontalAlignment(SwingConstants.LEFT);
		textFieldCPF.setFocusLostBehavior(JFormattedTextField.PERSIST);

		JPanel panelNome = new JPanel();
		panelNome.setBackground(corDeFundo);
		panelNome.setBounds(120, 102, 980, height);
		contentPane.add(panelNome);
		panelNome.setLayout(new BorderLayout(0, 0));

		JLabel textoNome = new JLabel("Nome*: ");
		textoNome.setHorizontalAlignment(SwingConstants.LEFT);
		textoNome.setFont(new Font(fonteString, Font.BOLD, 32));
		panelNome.add(textoNome, BorderLayout.WEST);

		JPanel panelNomeInput = new JPanel();
		panelNomeInput.setBorder(new EmptyBorder(15, 4, 15, 0));
		panelNomeInput.setBackground(corDeFundo);
		panelNome.add(panelNomeInput, BorderLayout.CENTER);
		panelNomeInput.setLayout(new BorderLayout(0, 0));

		textFieldNome = new JTextField();
		textFieldNome.setFont(new Font(fonteString, Font.PLAIN, 20));
		panelNomeInput.add(textFieldNome, BorderLayout.CENTER);
		textFieldNome.setColumns(10);

		JPanel panelRua = new JPanel();
		panelRua.setBackground(corDeFundo);
		panelRua.setBounds(120, 183, 980, height);
		contentPane.add(panelRua);
		panelRua.setLayout(new BorderLayout(0, 0));

		JLabel textoRua = new JLabel("Rua:     ");
		textoRua.setHorizontalAlignment(SwingConstants.LEFT);
		textoRua.setFont(new Font(fonteString, Font.BOLD, 32));
		panelRua.add(textoRua, BorderLayout.WEST);

		JPanel panelRuaInput = new JPanel();
		panelRuaInput.setBorder(new EmptyBorder(15, 8, 15, 0));
		panelRuaInput.setBackground(corDeFundo);
		panelRua.add(panelRuaInput, BorderLayout.CENTER);
		panelRuaInput.setLayout(new BorderLayout(0, 0));

		textFieldRua = new JTextField();
		textFieldRua.setFont(new Font(fonteString, Font.PLAIN, 20));
		textFieldRua.setColumns(10);
		panelRuaInput.add(textFieldRua, BorderLayout.CENTER);

		JPanel panelNumero = new JPanel();
		panelNumero.setBackground(corDeFundo);
		panelNumero.setBounds(120, 269, 480, height);
		contentPane.add(panelNumero);
		panelNumero.setLayout(new BorderLayout(0, 0));

		JLabel textoNumero = new JLabel("Nº:        ");
		textoNumero.setHorizontalAlignment(SwingConstants.LEFT);
		textoNumero.setFont(new Font(fonteString, Font.BOLD, 32));
		panelNumero.add(textoNumero, BorderLayout.WEST);

		JPanel panelNumeroInput = new JPanel();
		panelNumeroInput.setBorder(new EmptyBorder(15, 6, 15, 0));
		panelNumeroInput.setBackground(corDeFundo);
		panelNumero.add(panelNumeroInput, BorderLayout.CENTER);
		panelNumeroInput.setLayout(new BorderLayout(0, 0));

		textFieldNumero = new JTextField();
		textFieldNumero.setFont(new Font(fonteString, Font.PLAIN, 20));
		textFieldNumero.setColumns(10);
		panelNumeroInput.add(textFieldNumero, BorderLayout.CENTER);

		JPanel panelBairro = new JPanel();
		panelBairro.setBackground(corDeFundo);
		panelBairro.setBounds(620, 269, 480, height);
		contentPane.add(panelBairro);
		panelBairro.setLayout(new BorderLayout(0, 0));

		JLabel textoBairro = new JLabel("Bairro:");
		textoBairro.setHorizontalAlignment(SwingConstants.LEFT);
		textoBairro.setFont(new Font(fonteString, Font.BOLD, 32));
		panelBairro.add(textoBairro, BorderLayout.WEST);

		JPanel panelBairroInput = new JPanel();
		panelBairroInput.setBorder(new EmptyBorder(15, 9, 15, 0));
		panelBairroInput.setBackground(corDeFundo);
		panelBairro.add(panelBairroInput, BorderLayout.CENTER);
		panelBairroInput.setLayout(new BorderLayout(0, 0));

		textFieldBairro = new JTextField();
		textFieldBairro.setFont(new Font(fonteString, Font.PLAIN, 20));
		textFieldBairro.setColumns(10);
		panelBairroInput.add(textFieldBairro, BorderLayout.CENTER);

		JPanel panelCidade = new JPanel();
		panelCidade.setBackground(corDeFundo);
		panelCidade.setBounds(120, 350, 480, height);
		contentPane.add(panelCidade);
		panelCidade.setLayout(new BorderLayout(0, 0));

		JLabel textoCidade = new JLabel("Cidade:");
		textoCidade.setHorizontalAlignment(SwingConstants.LEFT);
		textoCidade.setFont(new Font(fonteString, Font.BOLD, 32));
		panelCidade.add(textoCidade, BorderLayout.WEST);

		JPanel panelCidadeInput = new JPanel();
		panelCidadeInput.setBorder(new EmptyBorder(15, 5, 15, 0));
		panelCidadeInput.setBackground(corDeFundo);
		panelCidade.add(panelCidadeInput, BorderLayout.CENTER);
		panelCidadeInput.setLayout(new BorderLayout(0, 0));

		textFieldCidade = new JTextField();
		textFieldCidade.setFont(new Font(fonteString, Font.PLAIN, 20));
		textFieldCidade.setColumns(10);
		panelCidadeInput.add(textFieldCidade, BorderLayout.CENTER);

		JPanel panelUF = new JPanel();
		panelUF.setBackground(corDeFundo);
		panelUF.setBounds(620, 350, 480, height);
		contentPane.add(panelUF);
		panelUF.setLayout(new BorderLayout(0, 0));

		JLabel textoUF = new JLabel("UF:      ");
		textoUF.setHorizontalAlignment(SwingConstants.LEFT);
		textoUF.setFont(new Font(fonteString, Font.BOLD, 32));
		panelUF.add(textoUF, BorderLayout.WEST);

		JPanel panelUFInput = new JPanel();
		panelUFInput.setBorder(new EmptyBorder(15, 8, 15, 0));
		panelUFInput.setBackground(corDeFundo);
		panelUF.add(panelUFInput, BorderLayout.CENTER);
		panelUFInput.setLayout(new BorderLayout(0, 0));

		inputUF = new JComboBox<>();
		inputUF.setFont(new Font(fonteString, Font.PLAIN, 20));
		panelUFInput.add(inputUF, BorderLayout.CENTER);
		inputUF.addItem(null);
		inputUF.addItem(UnidadeFederativa.AC);
		inputUF.addItem(UnidadeFederativa.AL);
		inputUF.addItem(UnidadeFederativa.AM);
		inputUF.addItem(UnidadeFederativa.AP);
		inputUF.addItem(UnidadeFederativa.BA);
		inputUF.addItem(UnidadeFederativa.CE);
		inputUF.addItem(UnidadeFederativa.DF);
		inputUF.addItem(UnidadeFederativa.ES);
		inputUF.addItem(UnidadeFederativa.GO);
		inputUF.addItem(UnidadeFederativa.MA);
		inputUF.addItem(UnidadeFederativa.MG);
		inputUF.addItem(UnidadeFederativa.MS);
		inputUF.addItem(UnidadeFederativa.MT);
		inputUF.addItem(UnidadeFederativa.PA);
		inputUF.addItem(UnidadeFederativa.PB);
		inputUF.addItem(UnidadeFederativa.PE);
		inputUF.addItem(UnidadeFederativa.PI);
		inputUF.addItem(UnidadeFederativa.PR);
		inputUF.addItem(UnidadeFederativa.RJ);
		inputUF.addItem(UnidadeFederativa.RN);
		inputUF.addItem(UnidadeFederativa.RO);
		inputUF.addItem(UnidadeFederativa.RR);
		inputUF.addItem(UnidadeFederativa.RS);
		inputUF.addItem(UnidadeFederativa.SC);
		inputUF.addItem(UnidadeFederativa.SE);
		inputUF.addItem(UnidadeFederativa.SP);
		inputUF.addItem(UnidadeFederativa.TO);

		JPanel panelFone = new JPanel();
		panelFone.setBackground(corDeFundo);
		panelFone.setBounds(120, 431, 480, height);
		contentPane.add(panelFone);
		panelFone.setLayout(new BorderLayout(0, 0));

		JLabel textoFone = new JLabel("Fone*:  ");
		textoFone.setHorizontalAlignment(SwingConstants.LEFT);
		textoFone.setFont(new Font(fonteString, Font.BOLD, 32));
		panelFone.add(textoFone, BorderLayout.WEST);

		JPanel panelFoneInput = new JPanel();
		panelFoneInput.setBorder(new EmptyBorder(15, 6, 15, 0));
		panelFoneInput.setBackground(corDeFundo);
		panelFone.add(panelFoneInput, BorderLayout.CENTER);
		panelFoneInput.setLayout(new BorderLayout(0, 0));

		MaskFormatter numeroTelefoneFormatter = null;

		try {
			numeroTelefoneFormatter = new MaskFormatter("(##) #####-####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		textFieldFone = new JFormattedTextField(numeroTelefoneFormatter);
		textFieldFone.setFont(new Font(fonteString, Font.PLAIN, 20));
		textFieldFone.setColumns(10);
		panelFoneInput.add(textFieldFone, BorderLayout.CENTER);

		JPanel panelEmail = new JPanel();
		panelEmail.setBackground(corDeFundo);
		panelEmail.setBounds(620, 431, 480, height);
		contentPane.add(panelEmail);
		panelEmail.setLayout(new BorderLayout(0, 0));

		JLabel textoEmail = new JLabel("Email*:");
		textoEmail.setHorizontalAlignment(SwingConstants.LEFT);
		textoEmail.setFont(new Font(fonteString, Font.BOLD, 32));
		panelEmail.add(textoEmail, BorderLayout.WEST);

		JPanel panelEmailInput = new JPanel();
		panelEmailInput.setBorder(new EmptyBorder(15, 5, 15, 0));
		panelEmailInput.setBackground(corDeFundo);
		panelEmail.add(panelEmailInput, BorderLayout.CENTER);
		panelEmailInput.setLayout(new BorderLayout(0, 0));

		textFieldEmail = new JTextField();
		textFieldEmail.setFont(new Font(fonteString, Font.PLAIN, 20));
		textFieldEmail.setColumns(10);
		panelEmailInput.add(textFieldEmail, BorderLayout.CENTER);

		JPanel panelDataDeNascimento = new JPanel();
		panelDataDeNascimento.setBackground(corDeFundo);
		panelDataDeNascimento.setBounds(120, 512, 980, height);
		contentPane.add(panelDataDeNascimento);
		panelDataDeNascimento.setLayout(new GridLayout(0, 2, 0, 0));

		JLabel textoDataDeNascimento = new JLabel("Data de nascimento*:");
		textoDataDeNascimento.setHorizontalAlignment(SwingConstants.LEFT);
		textoDataDeNascimento.setFont(new Font(fonteString, Font.BOLD, 32));
		panelDataDeNascimento.add(textoDataDeNascimento);

		JPanel panelDataDeNascimentoInput1 = new JPanel();
		panelDataDeNascimentoInput1.setBorder(new EmptyBorder(15, 100, 15, 0));
		panelDataDeNascimentoInput1.setBackground(corDeFundo);
		panelDataDeNascimento.add(panelDataDeNascimentoInput1);
		panelDataDeNascimentoInput1.setLayout(new BorderLayout(0, 0));

		JPanel panelDataDeNascimentoInput2 = new JPanel();
		panelDataDeNascimentoInput2.setBorder(new EmptyBorder(0, 24, 0, 0));
		panelDataDeNascimentoInput2.setBackground(corDeFundo);
		panelDataDeNascimentoInput1.add(panelDataDeNascimentoInput2, BorderLayout.CENTER);
		panelDataDeNascimentoInput2.setLayout(new BorderLayout(0, 0));

		MaskFormatter dataDeNascimentoFormatter = null;

		try {
			dataDeNascimentoFormatter = new MaskFormatter("##/##/####");
		} catch (ParseException e) {
			e.printStackTrace();
		}

		inputDataDeNascimento = new JFormattedTextField(dataDeNascimentoFormatter);
		inputDataDeNascimento.setFont(new Font(fonteString, Font.PLAIN, 20));
		inputDataDeNascimento.setColumns(22);
		panelDataDeNascimentoInput2.add(inputDataDeNascimento, BorderLayout.CENTER);

		JPanel panelBotoes = new JPanel();
		panelBotoes.setBackground(corDeFundo);
		panelBotoes.setBounds(620, 593, 480, 60);
		contentPane.add(panelBotoes);
		panelBotoes.setLayout(new GridLayout(0, 2, 50, 0));

		botaoCancelar = new JButton("Cancelar");
		botaoCancelar.setFont(new Font(fonteString, Font.PLAIN, 32));
		panelBotoes.add(botaoCancelar);

		botaoConfirmar = new JButton("Confirmar");
		botaoConfirmar.setFont(new Font(fonteString, Font.PLAIN, 35));
		panelBotoes.add(botaoConfirmar);

		configurarBotoes();
	}

	private void configurarBotoes() {
		botaoCancelar.addActionListener(e -> dispose());

		botaoConfirmar.addActionListener(e -> {

			try {

				String cpf = textFieldCPF.getText();
				String nome = textFieldNome.getText();
				String email = textFieldEmail.getText();
				String telefone = textFieldFone.getText();
				int diaDoNascimento = Integer.parseInt(inputDataDeNascimento.getText().substring(0, 2));
				int mesDoNascimento = Integer.parseInt(inputDataDeNascimento.getText().substring(3, 5));
				int anoDoNascimento = Integer.parseInt(inputDataDeNascimento.getText().substring(6, 10));

				String rua = textFieldRua.getText();
				String bairro = textFieldBairro.getText();
				String cidade = textFieldCidade.getText();
				int numeroResidencia = -1;
				UnidadeFederativa UF = (UnidadeFederativa) inputUF.getSelectedItem();

				if (textFieldNumero.getText().isEmpty() == false && textFieldNumero.getText().isBlank() == false) {
					numeroResidencia = Integer.parseInt(textFieldNumero.getText());
				}

				cpf = cpf.replace(".", "").replace("-", "");
				telefone = telefone.replace("(", "").replace(")", "").replace("-", "").replace(" ", "");

				Cliente novoCliente = new Cliente(cpf, nome, email, telefone, diaDoNascimento, mesDoNascimento,
						anoDoNascimento);
				Logger logger = Logger.getLogger(MainFrame.class.getName());
				logger.log(Level.INFO, "Cliente criado com sucesso");

				if (rua.isEmpty() == false && rua.isBlank() == false)
					novoCliente.setRua(rua);
				if (bairro.isEmpty() == false && bairro.isBlank() == false)
					novoCliente.setBairro(bairro);
				if (cidade.isEmpty() == false && cidade.isBlank() == false)
					novoCliente.setCidade(cidade);
				if (numeroResidencia != -1)
					novoCliente.setNumeroResidencia(numeroResidencia);
				if (UF != null)
					novoCliente.setUF(UF);

				// TODO Chama a classe intermediaria entre o Banco de dados e a Interface

				if (ClienteDAO.inserirCliente(novoCliente)) {
					// a ser removido depois dos popups
					System.out.println("Cliente Inserido com sucesso!");
				}

			} catch (Exception excpt) {
				Logger logger = Logger.getLogger(MainFrame.class.getName());
				logger.log(Level.SEVERE, excpt.getMessage());
			}

		});
	}

}
