package kitri.foodCourt.user.menu;

import java.util.List;
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
		foodMain.card.show(foodMain.panChangePanel, "foodMainView");
	}

	public void searchCategory(String category) {
		// 메뉴 목록 페이지로 (한식, 중식, 일식, 양식)
		System.out.println("menuList");
		List<FoodDto> list = menuDao.getMenubyCategory(Integer.parseInt(category));
		foodMain.panChangePanel.remove(foodMain.userMenuView);
		foodMain.panChangePanel.add(new UserMenuView(list, this), "userMenuView");
		foodMain.card.show(foodMain.panChangePanel, "userMenuView");
	}

	public void searchMenuName() {
		// 주문목록 페이지로 (검색 버튼)
		System.out.println("menuNameList");
		String foodName = foodMain.searchField.getText();
		List<FoodDto> list = menuDao.getMenubyName(foodName);
		foodMain.panChangePanel.remove(foodMain.userMenuView);
		foodMain.panChangePanel.add(new UserMenuView(list, this), "userMenuView");
		foodMain.card.show(foodMain.panChangePanel, "userMenuView");
	}

	public void searchMenuDetail(String food_id) {
		// 메뉴 상세 페이지로 (메뉴 이미지 버튼)
		System.out.println("menuDetail");
		FoodDto foodDto = menuDao.getMenubyId(food_id);
		foodMain.panChangePanel.remove(foodMain.UserMenuDetailView);
		foodMain.panChangePanel.add(new UserMenuDetailView(foodDto, this), "UserMenuDetailView");
		foodMain.card.show(foodMain.panChangePanel, "UserMenuDetailView");
	}
	
	public void userInfo() {
		// 유저 페이지로 (유저 정보 버튼)
	}

	public void orderList() {
		// 주문목록 페이지로 (주문목록 버튼)
	}

	public void backMenu() {
		// 이전으로
		System.out.println("이전으로");
		foodMain.card.show(foodMain.panChangePanel, "userMenuView");
	}
}
