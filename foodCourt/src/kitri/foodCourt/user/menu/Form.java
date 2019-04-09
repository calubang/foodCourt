package kitri.foodCourt.user.menu;

import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import kitri.foodCourt.user.swing.FOptionPane;


public class Form extends JFrame {

	BufferedImage bimg; // 이미지 파일을 읽어들일 변수
	int width, height; // 읽어들인 이미지의 원본 크기
	JLabel imgLable; // 이미지를 출력할 레이블
	JPanel panel; // 패널

	public Form() {
		System.out.println("생성자");
		try{
			bimg = ImageIO.read(new File(Form.class.getResource("/kitri/foodCourt/user/menu/menuImage/junjoobibimbab.jpg").toURI())); //이미지 로드
			System.out.println("이미지 로드 완료");
			width = bimg.getWidth();
			height = bimg.getHeight();
		} catch(IOException ex) {
			System.out.println("IO익셉션 발생");
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}

	public void initalize() {
		// JFrame
		setTitle("이미지 비율 조절 예제");
		setLayout(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		// Jpanel
		panel = new JPanel();
		panel.setBounds(0, 0, getWidth(), getHeight());
		panel.setBackground(Color.black);
		add(panel);
		// imgLable
		imgLable = new JLabel(new ImageIcon(bimg));
		imgLable.setBounds(10, 10, 300, 300);
		panel.add(imgLable);
		// JSlider
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 1, 200, 100);
		slider.setMajorTickSpacing(20);
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.addChangeListener(new imgChanger());
		slider.setBounds(10, 460, 480, 20);
		panel.add(slider);
		setVisible(true);
	}// initialize

	class imgChanger implements ChangeListener {
		@Override
		public void stateChanged(ChangeEvent e) {
			double mag = ((JSlider) e.getSource()).getValue() / 100.0d;
			panel.remove(imgLable);
			imgLable = null;
			imgLable = new JLabel(new ImageIcon(bimg.getScaledInstance((int) (width * mag), (int) (height * mag), Image.SCALE_SMOOTH)));
			imgLable.setBounds(10, 10, 300, 300);
			panel.add(imgLable);
			panel.repaint();
		}// stateChanger
	}// imgChanger
	public static void main(String[] args) {
		Form form = new Form();
		form.initalize();
	}
}// Form
