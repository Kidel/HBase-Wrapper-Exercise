package it.uniroma3.hw.sii.hbase.ui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import it.uniroma3.hw.sii.hbase.HBaseWrapper;
import it.uniroma3.hw.sii.hbase.RowBean;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.UIManager;

public class HBaseWrapperUI {

	private HBaseWrapper hw = new HBaseWrapper();

	private JFrame frmHbaseWrapperUi;
	private JTextField add_tableName;
	private JTextField add_rowKey;
	private JTextField add_family;
	private JTextField add_qualifier;
	private JTextField add_value;
	private JTextField del_tableName;
	private JTextField del_rowKey;
	private JTextField getOne_tableName;
	private JTextField getOne_rowKey;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HBaseWrapperUI window = new HBaseWrapperUI();
					window.frmHbaseWrapperUi.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public HBaseWrapperUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHbaseWrapperUi = new JFrame();
		frmHbaseWrapperUi.setResizable(false);
		frmHbaseWrapperUi.setTitle("HBase Wrapper UI");
		frmHbaseWrapperUi.setBounds(100, 100, 748, 519);
		frmHbaseWrapperUi.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmHbaseWrapperUi.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(6, 6, 737, 105);
		panel.setBorder(new TitledBorder(null, "Add Record", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setToolTipText("Add Record");
		frmHbaseWrapperUi.getContentPane().add(panel);
		panel.setLayout(new MigLayout("", "[114px][113px][113px][114px][114px]", "[15px][19px][25px]"));

		JLabel lblNewLabel_1 = new JLabel("Table Name");
		panel.add(lblNewLabel_1, "cell 0 0,alignx left,aligny top");

		JLabel lblNewLabel_2 = new JLabel("Row Key");
		panel.add(lblNewLabel_2, "cell 1 0,alignx left,aligny top");

		JLabel lblNewLabel_3 = new JLabel("Family");
		panel.add(lblNewLabel_3, "cell 2 0,alignx left,aligny top");

		JLabel lblNewLabel_4 = new JLabel("Qualifier");
		panel.add(lblNewLabel_4, "cell 3 0,alignx left,aligny top");

		JLabel lblNewLabel_5 = new JLabel("Value");
		panel.add(lblNewLabel_5, "cell 4 0,alignx left,aligny top");

		add_tableName = new JTextField();
		panel.add(add_tableName, "cell 0 1,alignx left,aligny top");
		add_tableName.setColumns(10);

		add_rowKey = new JTextField();
		panel.add(add_rowKey, "cell 1 1,growx,aligny top");
		add_rowKey.setColumns(10);

		add_family = new JTextField();
		panel.add(add_family, "cell 2 1,growx,aligny top");
		add_family.setColumns(10);

		add_qualifier = new JTextField();
		panel.add(add_qualifier, "cell 3 1,alignx left,aligny top");
		add_qualifier.setColumns(10);

		add_value = new JTextField();
		panel.add(add_value, "cell 4 1,alignx left,aligny top");
		add_value.setColumns(10);

		JButton btn_addRecord = new JButton("Add Record");
		panel.add(btn_addRecord, "cell 0 2,alignx left,aligny top");

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(6, 117, 737, 105);
		panel_1.setBorder(new TitledBorder(null, "Delete Record", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frmHbaseWrapperUi.getContentPane().add(panel_1);
		panel_1.setLayout(new MigLayout("", "[][][]", "[][][]"));

		JLabel lblTableName = new JLabel("Table Name");
		panel_1.add(lblTableName, "cell 0 0");

		JLabel lblRowKey = new JLabel("Row Key");
		panel_1.add(lblRowKey, "cell 2 0");

		del_tableName = new JTextField();
		panel_1.add(del_tableName, "flowy,cell 0 1");
		del_tableName.setColumns(10);

		del_rowKey = new JTextField();
		panel_1.add(del_rowKey, "cell 2 1");
		del_rowKey.setColumns(10);

		JButton btn_delRecord = new JButton("Del Record");
		panel_1.add(btn_delRecord, "cell 0 2");

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(6, 228, 737, 105);
		panel_2.setBorder(new TitledBorder(null, "Get One Record", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		frmHbaseWrapperUi.getContentPane().add(panel_2);
		panel_2.setLayout(new MigLayout("", "[][][]", "[][][]"));

		JLabel lblTableName_1 = new JLabel("Table Name");
		panel_2.add(lblTableName_1, "cell 0 0");

		JLabel lblNewLabel_8 = new JLabel("Row Key");
		panel_2.add(lblNewLabel_8, "cell 2 0");

		getOne_tableName = new JTextField();
		panel_2.add(getOne_tableName, "cell 0 1");
		getOne_tableName.setColumns(10);

		getOne_rowKey = new JTextField();
		panel_2.add(getOne_rowKey, "cell 2 1");
		getOne_rowKey.setColumns(10);

		JButton btn_getOneRecord = new JButton("Get Record");
		panel_2.add(btn_getOneRecord, "cell 0 2");

		final JTextArea output_textArea = new JTextArea();
		output_textArea.setBackground(UIManager.getColor("Label.background"));
		output_textArea.setWrapStyleWord(true);
		output_textArea.setLineWrap(true);
		output_textArea.setForeground(Color.BLACK);
		output_textArea.setToolTipText("output");
		output_textArea.setBounds(6, 339, 737, 137);
		output_textArea.setEditable(false);
		frmHbaseWrapperUi.getContentPane().add(output_textArea);

		JSeparator separator = new JSeparator();
		separator.setBounds(6, 385, 1, 1);
		frmHbaseWrapperUi.getContentPane().add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 430, 1, 1);
		frmHbaseWrapperUi.getContentPane().add(separator_1);

		btn_addRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output_textArea.setText("");
				output_textArea.setForeground(Color.BLACK);
				try {
					hw.addRecord(add_tableName.getText(), add_rowKey.getText(), add_family.getText(), add_qualifier.getText(), add_value.getText());
					output_textArea.setText("Added record " + add_tableName.getText() 
											+ " " + add_rowKey.getText() + " " + add_family.getText() 
											+ ":" + add_qualifier.getText() + " " + add_value.getText());
				} catch (Exception e1) {
					output_textArea.setText(e1.getMessage());
					output_textArea.setForeground(Color.RED);
					e1.printStackTrace();
				}
			}
		});
		
		btn_delRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output_textArea.setText("");
				output_textArea.setForeground(Color.BLACK);
				try {
					hw.delRecord(del_tableName.getText(), del_rowKey.getText());
					output_textArea.setText("Deleted record " + del_tableName.getText() + " " + del_rowKey.getText() + " (if it ever existed)");
				} catch (Exception e1) {
					output_textArea.setText(e1.getMessage());
					output_textArea.setForeground(Color.RED);
					e1.printStackTrace();
				}
			}
		});
		
		btn_getOneRecord.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				output_textArea.setText("");
				output_textArea.setForeground(Color.BLACK);
				try {
					RowBean rb = hw.getOneRecord(getOne_tableName.getText(), getOne_rowKey.getText());
					output_textArea.setText(rb.toString());
				} catch (Exception e1) {
					output_textArea.setText(e1.getMessage());
					output_textArea.setForeground(Color.RED);
					e1.printStackTrace();
				}
			}
		});
	}
}
