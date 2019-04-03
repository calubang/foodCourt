package kitri.clothingStore.management.product;

import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.GridLayout;
import javax.swing.JTable;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ListSelectionModel;


public class AdminProductManagement extends JPanel {

	private String[] properties = {"카테고리", "상품명", "상품코드"};
	private String[][] entries = {{"모자", "모자1", "123-456-789-123"}, {"모자2", "모자4", "133-466-779-183"}};
		
	private JTextField searchTextField = new JTextField();
	//private JTable commonTable = new JTable(entries, properties);
	private JTable commonTable = new JTable(60, 8);
	
	JLabel searchLabel = new JLabel("\uAC80\uC0C9");
	JLabel pictureLabel = new JLabel("Picture");
	JPanel picturePanel = new JPanel();

	JScrollPane scrollPane = new JScrollPane(commonTable);
	private JPanel menuPanel = new JPanel();
	
	private JButton registerBtn = new JButton("\uB4F1\uB85D");
	private JButton modifyBtn = new JButton("\uC218\uC815");
	private JButton deleteBtn = new JButton("\uC0AD\uC81C");
	private JButton storeBtn = new JButton("\uC800\uC7A5");

	JFrame jfR = new JFrame("제품등록");
	JFrame jfM = new JFrame("제품수정");
	
	
	AdminRegisterProduct arp;
	AdminModifyProduct amp;
	
	
	/**
	 * Create the panel.
	 */
	public AdminProductManagement() {
		setSize(new Dimension(1008, 722));
		setLayout(null);
		
		searchLabel.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		searchLabel.setFont(new Font("굴림", Font.PLAIN, 24));
		searchLabel.setHorizontalAlignment(SwingConstants.CENTER);
		searchLabel.setBounds(0, 0, 110, 60);
		add(searchLabel);
		
		
		searchTextField.setBorder(new LineBorder(Color.BLACK, 1, true));
		searchTextField.setFont(new Font("굴림", Font.PLAIN, 24));
		searchTextField.setBounds(110, 0, 681, 60);
		searchTextField.setColumns(10);
		add(searchTextField);
		
		picturePanel.setBounds(803, 0, 205, 213);
		picturePanel.setLayout(new BorderLayout(0, 0));
		pictureLabel.setIcon(null);
		pictureLabel.setForeground(Color.BLACK);
		pictureLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		pictureLabel.setHorizontalAlignment(SwingConstants.CENTER);
		picturePanel.add(pictureLabel, BorderLayout.CENTER);
		add(picturePanel);
		
		commonTable.setBorder(new LineBorder(new Color(0, 0, 0)));
		commonTable.setBounds(0, 356, 791, 366);
		commonTable.setShowGrid(true);
		commonTable.setShowVerticalLines(true);
		commonTable.setAutoCreateRowSorter(true);
		commonTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		scrollPane.setBounds(0, 58, 791, 664);
		add(scrollPane);

		menuPanel.setLayout(new GridLayout(4, 1, 0, 40));
		menuPanel.setBorder(new CompoundBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "\uBA54\uB274", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0)), new EmptyBorder(40, 40, 40, 40)));
		menuPanel.setBounds(799, 243, 209, 479);
		
		registerBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				arp = new AdminRegisterProduct();
				
				jfM.setVisible(false);
				
				jfR.getContentPane().add(arp);
				jfR.setSize(750, 650);
				jfR.setVisible(true);
			}
		});
		menuPanel.add(registerBtn);
		
		modifyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				amp = new AdminModifyProduct();
				
				jfR.setVisible(false);
				
				jfM.getContentPane().add(amp);
				jfM.setSize(750, 650);
				jfM.setVisible(true);
			}
		});
		menuPanel.add(modifyBtn);
		
		deleteBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] option = {"예", "아니오"};
				JOptionPane.showOptionDialog(deleteBtn, "정말 삭제하시겠습니까?\n(삭제하면 다시 되돌릴 수 없습니다.)", "삭제 확인", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
			}
		});
		menuPanel.add(deleteBtn);
		
		menuPanel.add(storeBtn);
		add(menuPanel);
		
		
	}
}
