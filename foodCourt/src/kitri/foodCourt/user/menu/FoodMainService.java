package kitri.foodCourt.user.menu;

import java.util.List;
import javax.swing.JButton;
import javax.swing.JPanel;
import kitri.foodCourt.user.main.FoodMain;
import kitri.foodCourt.user.menu.jdbc.DaoFactory;

public class FoodMainService {
	FoodMainController foodMainController;
	FoodMain foodMain;
	MenuDao menuDao = new DaoFactory().menuDao();

	public FoodMainService(FoodMainController foodMainController) {
		this.foodMainController = foodMainController;
		this.foodMain = foodMainController.foodMain;
	}

	public void clickMain() {
		// 메인 메뉴 목록 페이지로 (메인메뉴)
		System.out.println("mainMenu");
		foodMain.card.show(foodMain.panChangePanel, "mainMenu");
	}

	public void searchCategory(String category) {
		// 메뉴 목록 페이지로 (한식, 중식, 일식, 양식)
		System.out.println("menuList");
		List<FoodDto> list = menuDao.getMenubyCategory(Integer.parseInt(category));
//		JPanel userMenuList = new UserMenuView(list, this);
//		userMenuList.setBounds(160, 118, 1012, 634);
		foodMain.panChangePanel.add(new UserMenuView(list, this), "userMenuList");
		foodMain.card.show(foodMain.panChangePanel, "userMenuList");
	}

	public void searchMenuName() {
		// 주문목록 페이지로 (검색 버튼)
		System.out.println("menuNameList");
		String foodName = foodMain.searchField.getText();
		List<FoodDto> list = menuDao.getMenubyName(foodName);
//		JPanel userMenuList = new UserMenuView(list, this);
		foodMain.panChangePanel.add(new UserMenuView(list, this), "menuNameList");
		foodMain.card.show(foodMain.panChangePanel, "menuNameList");
	}

	public void searchMenuDetail(String food_id) {
		// 메뉴 상세 페이지로 (메뉴 이미지 버튼)
		System.out.println("menuDetail");
		FoodDto foodDto = menuDao.getMenubyId(food_id);
//		JPanel userMenuList = new UserMenuDetailView(foodDto);
		foodMain.panChangePanel.add(new UserMenuDetailView(foodDto), "menuNameList");
		foodMain.card.show(foodMain.panChangePanel, "menuNameList");
	}
	
	public void userInfo() {
		// 유저 페이지로 (유저 정보 버튼)
		// 지금은 임시로 메뉴 디테일 띄우기
		System.out.println("menuList");
		foodMain.card.show(foodMain.panChangePanel, "menuDetail");
	}

	public void orderList() {
		// 주문목록 페이지로 (주문목록 버튼)
	}
}
