package kitri.foodCourt.user.menu;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.awt.*;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;

import kitri.foodCourt.dto.FoodDto;

public class UserMenuDetailView extends JPanel {
	JTextField tfcount;
	JTextArea tfDescription = new JTextArea();
	FoodDto foodDto;
	JLabel image;
	JLabel foodName = new JLabel();
	JLabel price = new JLabel();
	JLabel count = new JLabel("\uC218\uB7C9");
	JLabel point = new JLabel();
	JPanel panel = new JPanel();
	JButton btnBack = new JButton("\uC774\uC804\uC73C\uB85C");
	AddOrderListButton btnBasket;
	public UserMenuDetailView(FoodDto foodDto, FoodMainService service) {
		tfDescription.setLineWrap(true);
		BufferedImage bimg;
		try {
			bimg = ImageIO.read(new File(UserMenuView.class.getResource(foodDto.getImageAddress()).toURI()));
			ImageIcon properImg; // 적정크기에 맞춰진 이미지를 담을 변수
			properImg = new ImageIcon(bimg.getScaledInstance((int) (475), (int) (394), Image.SCALE_SMOOTH));
			image = new JLabel(properImg);
			foodName.setText(foodDto.getFoodName());
			foodName.setFont(new Font("맑은고딕", Font.BOLD, 28));
			System.out.println(foodDto.getFoodName());
			price.setText("가격 : " + Integer.toString(foodDto.getPrice()) + " 원");
			System.out.println(foodDto.getPrice());
			tfDescription.setText(foodDto.getDescription());
			System.out.println(foodDto.getDescription());
			point.setText("적립 포인트 : " + Integer.toString(foodDto.getPoint()));
			this.foodDto = foodDto;
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		btnBasket = new AddOrderListButton("\uC7A5\uBC14\uAD6C\uB2C8 \uB2F4\uAE30", this);
		btnBack.setName("back");
		btnBasket.setName("basket");
		btnBasket.setFoodDto(foodDto);
		
		//이벤트 등록부 ------------------------------------------
		btnBack.addActionListener(service.foodMainController);
		btnBasket.addActionListener(service.foodMainController);
		
		
		
		setBackground(Color.WHITE);
		setLayout(null);
		
		
		image.setBorder(new MatteBorder(2, 2, 5, 5, (Color) new Color(128, 128, 128)));
		image.setToolTipText("\uC774\uBBF8\uC9C0");
		image.setBounds(35, 39, 475, 394);
		add(image);
		
		
		foodName.setBorder(new LineBorder(Color.GRAY, 3));
		foodName.setHorizontalAlignment(SwingConstants.CENTER);
		foodName.setToolTipText("\uBA54\uB274 \uC774\uB984");
		foodName.setBounds(542, 39, 419, 71);
		add(foodName);
		
		
		price.setBorder(new LineBorder(Color.LIGHT_GRAY, 3, true));
		price.setHorizontalAlignment(SwingConstants.CENTER);
		price.setBounds(542, 131, 162, 52);
		add(price);
		
		tfDescription.setBorder(new LineBorder(Color.LIGHT_GRAY, 3, true));
		tfDescription.setBounds(542, 202, 419, 165);
		tfDescription.setEditable(false);
		add(tfDescription);
		count.setHorizontalAlignment(SwingConstants.CENTER);
		count.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		
		count.setBorder(new LineBorder(Color.LIGHT_GRAY, 2));
		count.setBounds(542, 385, 69, 35);
		add(count);
		
		
		point.setBorder(new LineBorder(Color.LIGHT_GRAY, 3, true));
		point.setHorizontalAlignment(SwingConstants.CENTER);
		point.setBounds(723, 131, 162, 52);
		add(point);
		
		
		panel.setBackground(Color.BLACK);
		panel.setBounds(631, 385, 3, 35);
		add(panel);
		
		tfcount = new JTextField("1");
		tfcount.setHorizontalAlignment(SwingConstants.CENTER);
		tfcount.setBounds(653, 385, 308, 35);
		add(tfcount);
		tfcount.setColumns(10);
		
		
		btnBack.setFont(new Font("맑은 고딕", Font.BOLD, 26));
		btnBack.setBounds(199, 476, 223, 92);
		add(btnBack);
		
		
		btnBasket.setFont(new Font("맑은 고딕", Font.BOLD, 26));
		btnBasket.setBounds(585, 476, 223, 92);
		add(btnBasket);
	}
	public UserMenuDetailView() {
		// TODO Auto-generated constructor stub
	}
	public FoodDto getFoodDto() {
		return this.foodDto;
	}
	public int getCount() {
		return Integer.parseInt(tfcount.getText()); // 장바구니 추가를 실행할때 액션이 발생했을때
	}
}
