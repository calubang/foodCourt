package kitri.foodCourt.user.basket;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import kitri.foodCourt.user.swing.FLabel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

public class receipt extends JFrame {

	private JPanel contentPane;
	private String columnNames[] = {"ºÐ·ù", "À½½Ä¸í", "Ç±Å°Æ÷ÀÎÆ®", "¼ö·®", "°¡°Ý"};
	private Object data[][] = {{"ÇÑ½Ä", "µÈÀåÂî°³", 100, 2, 5000}, {"¾ç½Ä", "½ºÅ×ÀÌÅ©", 100, 2, 5000}, {"Áß½Ä", "ÀÚÀå¸é", 100, 2, 5000}, {"ÀÏ½Ä", "ÃÊ¹ä", 100, 2, 5000}};
	private JTable table;
	
	//Å×½ºÆ®¿ë
	BasketMain basket = new BasketMain();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					receipt frame = new receipt();
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
	public receipt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel pTop = new JPanel();
		pTop.setBounds(0, 0, 424, 114);
		panel.add(pTop);
		pTop.setLayout(null);
		
		FLabel label = new FLabel();
		label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		label.setFont(new Font("¸¼Àº °íµñ", Font.BOLD, 20));
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setText("\uC601\uC218\uC99D");
		label.setOpaque(true);
		label.setBackground(Color.LIGHT_GRAY);
		label.setBounds(0, 0, 424, 40);
		pTop.add(label);
		
		FLabel label_1 = new FLabel();
		label_1.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		label_1.setText("\uC8FC\uBB38\uBC88\uD638 : ");
		label_1.setBounds(0, 50, 75, 30);
		pTop.add(label_1);
		
		FLabel label_2 = new FLabel();
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setText("217");
		label_2.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		label_2.setBounds(75, 50, 73, 30);
		pTop.add(label_2);
		
		FLabel label_3 = new FLabel();
		label_3.setText("\uACB0\uC81C\uC77C\uC2DC : ");
		label_3.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		label_3.setBounds(202, 50, 75, 30);
		pTop.add(label_3);
		
		FLabel label_4 = new FLabel();
		label_4.setText("19-04-08 12:05:23");
		label_4.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		label_4.setBounds(277, 50, 135, 30);
		pTop.add(label_4);
		
		FLabel lblid = new FLabel();
		lblid.setHorizontalAlignment(SwingConstants.CENTER);
		lblid.setText("\uD68C\uC6D0ID : ");
		lblid.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblid.setBounds(234, 84, 75, 30);
		pTop.add(lblid);
		
		FLabel lblCa = new FLabel();
		lblCa.setText("calubang");
		lblCa.setFont(new Font("¸¼Àº °íµñ", Font.PLAIN, 15));
		lblCa.setBounds(312, 84, 100, 30);
		pTop.add(lblCa);
		
		JPanel pMiddle = new JPanel();
		pMiddle.setBounds(0, 124, 424, 363);
		panel.add(pMiddle);
		pMiddle.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 424, 150);
		pMiddle.add(scrollPane);
		
		DefaultTableModel foodTableMode = new DefaultTableModel();
		int len = columnNames.length;
		for (int i = 0; i < len; i++) {
			foodTableMode.addColumn(columnNames[i]);
		}
		
		table = new JTable(foodTableMode);
		scrollPane.setViewportView(table);
		foodTableMode.addRow(data[0]);
		
		JPanel pPayment = new JPanel();
		pPayment.setBounds(0, 183, 424, 76);
		pMiddle.add(pPayment);
		
		JPanel pTotal = new JPanel();
		pTotal.setBounds(0, 283, 424, 80);
		pMiddle.add(pTotal);
		pTotal.setLayout(new BorderLayout(0, 0));
		
		
		
		JPanel pBottom = new JPanel();
		pBottom.setBounds(0, 497, 424, 55);
		panel.add(pBottom);
	}
}
