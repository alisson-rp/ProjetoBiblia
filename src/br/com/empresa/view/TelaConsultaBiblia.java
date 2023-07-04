package br.com.empresa.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.table.TableColumnModel;

import br.com.empresa.exception.BOException;
import br.com.empresa.exception.BOValidationException;
import br.com.empresa.service.Service;
import br.com.empresa.view.util.ButtonGradient;
import br.com.empresa.view.util.RowData;
import br.com.empresa.view.util.TableModel;
import br.com.empresa.vo.BibliaVO;
import br.com.empresa.vo.LivroVO;

public class TelaConsultaBiblia extends JFrame {

	private JTextField verIni;
	private JTextField verFim;
	private JTextField textoBiblico;
	private JComboBox comboBox;
	private JComboBox comboBox_1;
	private JTable table;
	private TableModel tableModel;
	private LivroVO livroSelecionado;
	private Integer capituloSelecionado;
	private BigInteger vIni;
	private BigInteger vFim;

	public TelaConsultaBiblia() {
		setBackground(new Color(231, 231, 231));
		getContentPane().setBackground(new Color(231, 231, 231));
		setResizable(false);

		setBounds(100, 100, 953, 650);

		getContentPane().setFont(new Font("Times New Roman", Font.BOLD, 20));
		getContentPane().setLayout(null);

		comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				preencherComboCapitulo();
			}
		});
		comboBox.setBounds(95, 42, 146, 22);
		getContentPane().add(comboBox);

		JLabel lblLivro = new JLabel("Livro:");
		lblLivro.setFont(new Font("Arial", Font.BOLD, 20));
		lblLivro.setBounds(34, 40, 105, 21);
		getContentPane().add(lblLivro);

		JLabel lblCapítulo = new JLabel("Capítulo:");
		lblCapítulo.setFont(new Font("Arial", Font.BOLD, 20));
		lblCapítulo.setBounds(251, 40, 91, 17);
		getContentPane().add(lblCapítulo);

		comboBox_1 = new JComboBox();
		comboBox_1.setBounds(346, 40, 84, 22);
		getContentPane().add(comboBox_1);

		JLabel lblVerIni = new JLabel("Versículo Inicial:");
		lblVerIni.setFont(new Font("Arial", Font.BOLD, 20));
		lblVerIni.setBounds(446, 39, 164, 18);
		getContentPane().add(lblVerIni);

		verIni = new JTextField();
		verIni.setBounds(609, 40, 64, 21);
		getContentPane().add(verIni);
		verIni.setColumns(10);

		JLabel lblVerFin = new JLabel("Versículo Final:");
		lblVerFin.setFont(new Font("Arial", Font.BOLD, 20));
		lblVerFin.setBounds(689, 40, 152, 18);
		getContentPane().add(lblVerFin);

		verFim = new JTextField();
		verFim.setBounds(842, 41, 64, 21);
		getContentPane().add(verFim);
		verFim.setColumns(10);

		JLabel lblTexto = new JLabel("Texto:");
		lblTexto.setFont(new Font("Arial", Font.BOLD, 20));
		lblTexto.setBounds(31, 91, 72, 26);
		getContentPane().add(lblTexto);

		textoBiblico = new JTextField();
		textoBiblico.setBounds(95, 89, 572, 28);
		getContentPane().add(textoBiblico);
		textoBiblico.setColumns(10);

		ButtonGradient btnPesquisar = new ButtonGradient();
		btnPesquisar.setText("Pesquisar");
		btnPesquisar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnPesquisar.setBackground(new Color(60, 179, 113));
		btnPesquisar.setForeground(new Color(255, 255, 255));
		btnPesquisar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnPesquisar.setBounds(681, 89, 105, 28);
		getContentPane().add(btnPesquisar);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setEnabled(false);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(34, 150, 872, 398);
		getContentPane().add(scrollPane);

		tableModel = new TableModel();
		tableModel.addColumn("Livro");
		tableModel.addColumn("Capítulo");
		tableModel.addColumn("Versículo");
		tableModel.addColumn("Texto");

		table = new JTable(tableModel);
		table.setAutoscrolls(true);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

		TableColumnModel tableColumnModel = table.getColumnModel();
		tableColumnModel.getColumn(0).setPreferredWidth(150);
		tableColumnModel.getColumn(1).setPreferredWidth(100);
		tableColumnModel.getColumn(2).setPreferredWidth(100);
		tableColumnModel.getColumn(3).setPreferredWidth(1024);

		scrollPane.setViewportView(table);

		ButtonGradient btnLimpar = new ButtonGradient();
		btnLimpar.setText("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limparPesquisa();
			}
		});
		btnLimpar.setBackground(new Color(30, 144, 255));
		btnLimpar.setForeground(new Color(255, 255, 255));
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpar.setBounds(796, 89, 85, 28);
		getContentPane().add(btnLimpar);

		ButtonGradient btnLer = new ButtonGradient();
		btnLer.setText("Ler");
		btnLer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abreTelaDeLeitura();
			}
		});
		btnLer.setForeground(new Color(255, 255, 255));
		btnLer.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLer.setBackground(new Color(240, 213, 15));
		btnLer.setBounds(34, 558, 105, 28);
		getContentPane().add(btnLer);

		buscaLivros();

	}

	private void pesquisar() {

		Service service = new Service();
		TableModel tableModel = (TableModel) table.getModel();
		tableModel.clearTable();

		try {

			Map<String, Object> filters = new HashMap<>();

			this.livroSelecionado = (LivroVO) comboBox.getSelectedItem();
			try {
				this.livroSelecionado.getClass();
			} catch (Exception e) {
				throw new BOValidationException("Livro não selecionado, Favor selecione um livro:");
			}

			capituloSelecionado = (Integer) comboBox_1.getSelectedItem();
			if (capituloSelecionado != null) {
				try {
					if (this.capituloSelecionado != null) {
						filters.put("capitulo", capituloSelecionado);
					} else {
						JOptionPane.showMessageDialog(this, "Selecione um capítulo", "Mensagem de aviso",
								JOptionPane.WARNING_MESSAGE);
					}
				} catch (Exception e) {
					throw new BOValidationException();
				}
			}

			if (this.verIni.getText() != null && this.verIni.getText().trim().length() > 0) {
				try {
					vIni = new BigInteger(this.verIni.getText().trim());
				} catch (Exception e) {
					throw new BOValidationException("Vercículo inicial: Erro de validação: " + "Valor incorreto.");
				}
			} 

			if (this.verFim.getText() != null && this.verFim.getText().trim().length() > 0) {
				try {
					vFim = new BigInteger(this.verFim.getText().trim());
				} catch (Exception e) {
					throw new BOValidationException("Vercículo final: Erro de validação: " + "Valor incorreto.");
				}
			}

			if (textoBiblico.getText() != null && textoBiblico.getText().trim().length() > 0) {
				filters.put("texto", textoBiblico.getText().trim());
			}

			List<BibliaVO> bibliaVOs = service.consultarBiblia(0, Integer.MAX_VALUE, vIni, vFim, filters,
					this.livroSelecionado);

			if (bibliaVOs != null) {

				for (BibliaVO bibliaVO : bibliaVOs) {
					RowData rowData = new RowData();
					rowData.getValues().put(0, bibliaVO.getLivroVO().toString());
					rowData.getValues().put(1, bibliaVO.getCapitulo());
					rowData.getValues().put(2, bibliaVO.getVersiculo());
					rowData.getValues().put(3, bibliaVO.getTexto());

					rowData.setElement(bibliaVO);
					tableModel.addRow(rowData);
				}
			}

		} catch (BOValidationException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage(), "Mensagem de aviso", JOptionPane.WARNING_MESSAGE);
		} catch (BOException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(this, e.getMessage(), "Ocorreu um erro ao executar a operação!",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	private void buscaLivros() {
		Service service = new Service();

		try {
			List<LivroVO> livros = service.buscaLivros();

			comboBox.addItem(null);
			for (LivroVO livroVO : livros) {
				comboBox.addItem(livroVO);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void preencherComboCapitulo() {
		comboBox_1.removeAllItems();
		livroSelecionado = (LivroVO) comboBox.getSelectedItem();
		if (livroSelecionado != null) {
			for (int i = 1; i <= livroSelecionado.getQtdCapitulo(); i++) {
				comboBox_1.addItem(i);
			}
		}
	}

	public void limparPesquisa() {
		this.comboBox.setSelectedIndex(0);
		this.verIni.setText(null);
		this.vIni = null;
		this.vFim = null;
		this.verFim.setText(null);
		this.textoBiblico.setText(null);
	}

	public void abreTelaDeLeitura() {

		if (table.getSelectedRows().length <= 0) {
			JOptionPane.showMessageDialog(this, "É necessário selecionar um registro!", "Mensagem de aviso",
					JOptionPane.WARNING_MESSAGE);
		} else {

			try {

				int[] qtdtexto = table.getSelectedRows();
				List<RowData> rows = tableModel.getRows();
				List<BibliaVO> aux = new ArrayList<BibliaVO>();
				for (int i = 0; i < qtdtexto.length; i++) {
					aux.add((BibliaVO) rows.get(qtdtexto[i]).getElement());
				}

				new TelaDeLeitura(aux);

			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ocorreu um erro " + "ao realizar a operação.", "Erro",
						JOptionPane.ERROR_MESSAGE);
			}

		}
	}
}
