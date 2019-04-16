package kitri.foodCourt.management.order;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.Color;

public class Test1 extends JFrame {

	private JPanel contentPane;
	Map<String,String> tmap = new TreeMap<String,String>(Collections.reverseOrder()); // 정렬을 하기위한 맵 덕분에 list안써도댐

	 

	Iterator<String> iteratorKey;   //키값 오름차순 정렬(기본)



	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test1 frame = new Test1();
					frame.setVisible(true);
					frame.test11();
					frame.test();
					System.out.println(frame.isVisible());
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 555);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JLabel lblTest = new JLabel("test");
		lblTest.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblTest, BorderLayout.CENTER);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBackground(Color.gray);
		contentPane.add(btnNewButton, BorderLayout.EAST);
	}
	public void test11() {
		tmap.put("1", "첫번째");
		tmap.put("2", "2번째");
		tmap.put("3", "3번째");
		tmap.put("4", "4번째");
		tmap.put("5", "5번째");
		tmap.remove("3");
	}
	public void test() {
		iteratorKey = tmap.keySet( ).iterator();
		while(iteratorKey.hasNext()) {

			  String key = iteratorKey.next();

			  System.out.println(key+","+tmap.get(key));

			 }
	}
}
