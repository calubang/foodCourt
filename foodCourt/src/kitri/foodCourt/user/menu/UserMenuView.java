package kitri.foodCourt.user.menu;

import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

public class UserMenuView extends JPanel {
	/**
	 * Create the panel.
	 */
	JScrollPane scrollPane = new JScrollPane();
	JPanel panel = new JPanel();
	GridBagLayout gbl_panel = new GridBagLayout();
	FoodMainService service;
								//db 에서 	select * from food;
//								select * from food where category_id = 1;
//								select * from food where food_name like '%찌개%';
//								등등으로 얻어온 FoodDto들을 List<FoodDto> 안에 넣어올 것이다
//								그러면 count = footList.size() 로 총갯수를 얻어온다음 
//								화면에 뿌려준다 
//								지금은 얻어온 메뉴 갯수가 17개라고 가정

//	메뉴 검색화면을 여는 경우의 종류는 딱 2가지다
//	1. 검색 또는 카테고리 선택을 통해 여는 경우
//	2. 메뉴 상세 화면에서 이전으로 클릭으로 여는 경우
	
//	단순히 이전으로 클릭이면 이미 카테고리 선택 혹은 검색을 통해 메뉴리스트를 이미 가져왔을 것이므로
//	메뉴를 바꿀 필요 없이 단순히 setvisible true만 해주면 된다
// 카테고리 선택 혹은 검색을 통해 여는 경우에는 db에서 메뉴리스트를 얻어와서 뿌려줘야 하므로 매개변수에 메뉴 list를 받아와서 뿌려줘야 한다
	public UserMenuView(List<FoodDto> list, FoodMainService service) {
		this.service = service;
		setBackground(Color.WHITE);
		setLayout(null);
		gbl_panel.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel.setBackground(Color.WHITE);
		panel.setBorder(null);
		panel.setLayout(gbl_panel);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBorder(null);
		
		scrollPane.setViewportView(panel);
		scrollPane.setBounds(12, 10, 988, 614);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		setMenu(list);
		add(scrollPane);
//		panel.setPreferredSize(new Dimension(998, 614));
		
		
	}
	public void setMenu(List<FoodDto> list) { //여기서 리스트를 받아온다
		int listSize = list.size();
		try {
			int gridx = 0;
			int gridy = 0;
			for(FoodDto foodDto : list) {
				// 이미지 로드
				BufferedImage bimg = ImageIO.read(new File(UserMenuView.class.getResource(foodDto.getImageAddress()).toURI()));
				ImageIcon properImg; // 적정크기에 맞춰진 이미지를 담을 변수
				properImg = new ImageIcon(bimg.getScaledInstance((int) (185), (int) (170), Image.SCALE_SMOOTH));
				
				//라벨크기 각 컴포넌트에 맞게 설정해주기 190 190
				MenuPanel menuPanel = new MenuPanel(properImg, foodDto.getFoodName());
				GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
				gbc_btnNewButton.insets = new Insets(0, 0, 9, 9);
				gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
				gbc_btnNewButton.gridx = gridx;
				gbc_btnNewButton.gridy = gridy;
				panel.add(menuPanel, gbc_btnNewButton);
				gridx++;
				if(gridx > 4) {
					gridx = 0;
					gridy++;
				}
				menuPanel.btnImg.setName(foodDto.getFoodId());
				menuPanel.btnImg.addActionListener(service.foodMainController);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
	}
//		만약 메뉴를 17개 뽑아온다고 하면
//		0 1 2 3 4 
//		5개가 첫 줄에
//		다음줄에는 
//		5 6 7 8 9 
//		5개가 와야한다
//
//		그렇다면 포문을 17번 돌리는데 
//		가로가 4인거 까지 넣으면 
//		가로를 다시 0으로만들어주고
//		행을 1 증가시킨다

}
