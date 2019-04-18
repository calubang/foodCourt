package kitri.foodCourt.management.order;

import java.awt.*;
import java.util.*;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class OrderListFrame extends JFrame {

	JPanel contentPane;
	JScrollPane scrollPane = new JScrollPane();
	JButton btnOrderview = new JButton("\uC8FC\uBB38 \uD655\uC778");
	JButton btnComplete = new JButton("\uC870\uB9AC \uC644\uB8CC");
	JButton btnRemove = new JButton("\uC81C\uAC70");
	JPanel panOrder = new JPanel();
	GridBagLayout gbl_panel = new GridBagLayout();
	private final JPanel panBase = new JPanel();
	Border defualt;
	Map<Integer, OrderList> tmap = new TreeMap<Integer, OrderList>(Collections.reverseOrder()); // 내림차순 정렬을 하기위한 맵 덕분에
	Iterator<Integer> iteratorKey; // 키값 오름차순 정렬(기본)									// list안써도댐
	int selectedRequestNumber = 0; // 현재 누른 버튼 가져오기
	int orderNumber = 0; // 주문번호
	Color color = new Color(250,250,210);
	OrderController orderController = null;
	OrderDetailDialog orderDetailDialog = null;
	public OrderListServer orderListServer = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void addOrder() { // 여기서 리스트를 받아온다
		iteratorKey = tmap.keySet().iterator();
		int gridx = 0;
		int gridy = 0;
		while (iteratorKey.hasNext()) {
			int key = iteratorKey.next();
			OrderListButton orderListButton = new OrderListButton(tmap.get(key).getRequestNumber());
			orderListButton.setSize(new Dimension(100, 100) );
			orderListButton.setMaximumSize(new Dimension(100, 100));
			orderListButton.setPreferredSize(new Dimension(100, 100));
			GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
			gbc_btnNewButton.insets = new Insets(0, 0, 9, 17);
			gbc_btnNewButton.fill = GridBagConstraints.BOTH;
			gbc_btnNewButton.gridx = gridx;
			gbc_btnNewButton.gridy = gridy;
			panOrder.add(orderListButton, gbc_btnNewButton);

			orderListButton.setName(Integer.toString(tmap.get(key).getRequestNumber()));
			orderListButton.addActionListener(orderController);
			// 디폴트 색은 오렌지!!
			if(!tmap.get(key).getCheckOrder())
				orderListButton.setBackground(Color.ORANGE);
			else {
				orderListButton.setBackground(color);
			}
			// 여기서 전에 클릭이 되었었는지 처리완료가 되있었는지 판단해서 볼더를 주거나 색을 칠해준다
			if (tmap.get(key).isComplete()) {
				orderListButton.setBackground(Color.GREEN);
			}
			System.out.println("tmap.get(key).getRequestNumber() : "+tmap.get(key).getRequestNumber());
			System.out.println("selectedRequestNumber : "+selectedRequestNumber);
			if (tmap.get(key).getRequestNumber() == selectedRequestNumber)
				orderListButton.setBorder(new LineBorder(new Color(0, 0, 0), 3));
			gridx++;
			if (gridx > 4) {
				gridx = 0;
				gridy++;
			}
			// 이버튼의 주소값을 넣어줘야 이벤트처리가 가능하다 (그러므로 orderlist에 button 필드 하나 추가??
			// 그러면 버튼이 새로 생성될때마다 넣어줘야한다
			tmap.get(key).setButton(orderListButton);
		}
	}

	/**
	 * Create the frame.
	 */
	public OrderListFrame() {
		super("\uC74C\uC2DD \uC8FC\uBB38 \uBAA9\uB85D");
		getContentPane().setBackground(Color.WHITE);
		orderController = new OrderController(this);
		orderListServer = new OrderListServer(new OrderService(orderController));
		new Thread(orderListServer).start();

		orderDetailDialog = new OrderDetailDialog(this);
		setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		btnOrderview.setBounds(662, 148, 120, 87);
		getContentPane().add(btnOrderview);
		btnComplete.setBounds(662, 277, 120, 87);
		getContentPane().add(btnComplete);
		btnRemove.setBounds(662, 409, 120, 87);
		btnOrderview.setVisible(false);
		btnComplete.setVisible(false);
		btnRemove.setVisible(false);
		getContentPane().add(btnRemove);
		panBase.setBounds(0, 0, 650, 592);
		
		gbl_panel.columnWidths = new int[] {30, 100, 100, 100, 100};
		gbl_panel.rowHeights = new int[] {30, 100, 100, 100};
		gbl_panel.columnWeights = new double[]{0.0};
		gbl_panel.rowWeights = new double[]{0.0};
		panOrder.setBackground(Color.WHITE);
		
		panOrder.setLayout(gbl_panel);
		
		getContentPane().add(panBase);
		
		panBase.setLayout(null);
		panBase.add(scrollPane);
		
		scrollPane.setViewportView(panOrder);
		scrollPane.setBounds(0, 0, 650, 592);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		defualt = btnComplete.getBorder();
		panBase.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel.setBackground(Color.ORANGE);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBounds(662, 10, 37, 36);
		getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.setBorder(new LineBorder(new Color(0, 0, 0)));
		label.setBackground(color);
		label.setBounds(662, 56, 37, 36);
		getContentPane().add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setOpaque(true);
		label_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		label_1.setBackground(Color.GREEN);
		label_1.setBounds(662, 102, 37, 36);
		getContentPane().add(label_1);
		
		JLabel lblNewLabel_1 = new JLabel("\uBBF8\uD655\uC778");
		lblNewLabel_1.setBounds(707, 10, 75, 36);
		getContentPane().add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("\uD655\uC778");
		label_2.setBounds(707, 56, 75, 36);
		getContentPane().add(label_2);
		
		JLabel label_3 = new JLabel("\uC870\uB9AC\uC644\uB8CC");
		label_3.setBounds(707, 102, 75, 36);
		getContentPane().add(label_3);
		setBounds(200, 200, 800, 620);
		setResizable(false);
		// 이벤트 등록--------------------------
		btnOrderview.addActionListener(orderController);
		btnComplete.addActionListener(orderController);
		btnRemove.addActionListener(orderController);
	}
}
