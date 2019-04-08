package kitri.foodCourt.user.menu;

import java.util.List;

import javax.swing.JButton;

public class FoodMainService {
	FoodMainController foodMainController = null;
	FoodMain foodMain = null;
	List<FoodDto> foodList = null;
	FoodDao foodDao = new FoodDao();
	public FoodMainService(FoodMainController foodMainController) {
		this.foodMainController = foodMainController;
		this.foodMain = foodMainController.foodMain;
	}
	public void searchMenu(JButton button) {
		// 카드레이아웃 -> 메뉴 목록 페이지로 (한식, 중식, 일식, 양식)
		System.out.println("menuList");
		foodList = foodDao.getMenubyCategory(Integer.parseInt(button.getName()));
		foodMain.userMenuList.setMenu(1, foodList);
		foodMain.card.show(foodMain.changePanel, "menuList");
	}
	public void clickMain() {
		// 카드레이아웃 -> 메인 메뉴 목록 페이지로 (메인메뉴)
		System.out.println("mainMenu");
		foodMain.card.show(foodMain.changePanel, "mainMenu");
	}
	public void userInfo() {
		// 카드레이아웃 -> 유저 페이지로 (유저 정보 버튼)
		
	}
	public void orderList() {
		// 카드레이아웃 -> 주문목록 페이지로 (주문목록 버튼)
		
	}
	public void searchAllMenu() {
		// 카드레이아웃 -> 주문목록 페이지로 (검색 버튼)
		System.out.println("menuAllList");
		foodList = foodDao.getMenuAll();
		foodMain.userMenuList.setMenu(27, foodList);
		foodMain.card.show(foodMain.changePanel, "menuList");
	}
	
}
