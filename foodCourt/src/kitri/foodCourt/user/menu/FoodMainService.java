package kitri.foodCourt.user.menu;

import java.util.List;

import javax.swing.JOptionPane;

import kitri.foodCourt.dto.FoodDto;
import kitri.foodCourt.user.BasketDetail;
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

	// 메인 메뉴 목록 페이지로 (메인메뉴)
	public void clickMain() {
		foodMain.card.show(foodMain.panChangePanel, "foodMainView");
	}

	// 메뉴 목록 페이지로 (한식, 중식, 일식, 양식)
	public void searchCategory(String category) {
		List<FoodDto> list = menuDao.getMenubyCategory(Integer.parseInt(category));
//		foodMain.panChangePanel.remove(foodMain.userMenuView);
		foodMain.panChangePanel.add(new UserMenuView(list, this), "userMenuView");
		foodMain.card.show(foodMain.panChangePanel, "userMenuView");
	}

	// 주문목록 페이지로 (검색 버튼)
	public void searchMenuName() {
		String foodName = foodMain.searchField.getText();
		List<FoodDto> list = menuDao.getMenubyName(foodName);
		if (list.size() != 0) {
//			foodMain.panChangePanel.remove(foodMain.userMenuView);
			foodMain.panChangePanel.add(new UserMenuView(list, this), "userMenuView");
			foodMain.card.show(foodMain.panChangePanel, "userMenuView");
		} else {
			foodMain.card.show(foodMain.panChangePanel, "noSearchMenuImg");
		}
	}

	// 메뉴 상세 페이지로 (메뉴 이미지 버튼)
	public void searchMenuDetail(String food_id) {
		FoodDto foodDto = menuDao.getMenubyId(food_id);
//		foodMain.panChangePanel.remove(foodMain.UserMenuDetailView);
		foodMain.panChangePanel.add(new UserMenuDetailView(foodDto, this), "UserMenuDetailView");
		foodMain.card.show(foodMain.panChangePanel, "UserMenuDetailView");
	}

	// 이전으로 (이전으로 버튼)
	public void backMenu() {
		foodMain.card.show(foodMain.panChangePanel, "userMenuView");
	}
//	public void backMenuDetail() {
//		foodMain.card.show(foodMain.panChangePanel, "UserMenuDetailView");
//	}

	// 주문목록 추가 (장바구니 추가 버튼)
	public void addMenuInbasket(FoodDto foodDto, int count) {
		System.out.println("현재 수량 : " + count);
		int result;
		int subResult;
		result = JOptionPane.showConfirmDialog(foodMain.UserMenuDetailView, "주문목록에 추가하시겠습니까?", "주문 메뉴 추가",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
		if (result == 0) { // 확인을 눌렀을 때
			// 장바구니 List에 현재 메뉴를 추가
			BasketDetail detail = new BasketDetail(foodDto, count);
			foodMain.user.getBasket().add(detail);
			foodMain.basketMain.dataSetting();
			subResult = JOptionPane.showConfirmDialog(foodMain.UserMenuDetailView, "추가되었습니다\n장바구니로 가시겠습니까?", "titme",
					JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if (subResult == 1) {
				backMenu();
			} else {
				foodMain.card.show(foodMain.panChangePanel, "basketMain");
				foodMain.basketMain.card.show(foodMain.basketMain.pChangePanel, "basket");
			}
		}
//		System.out.println(subResult);
	}

	// 유저 페이지로 (유저 정보 버튼)
	public void userInfo() {
	}

	// 주문목록 페이지로 (주문목록 버튼)
	public void orderList() {
		//System.out.println(foodMain.user.getBasket());
//		foodMain.basketMain.user = foodMain.user; // 장바구니버튼을 클릭하지 않고 메뉴에서 바로 들어가게 되면 이 문장이 실행되지 않는다  
		foodMain.basketMain.dataSetting();
		foodMain.card.show(foodMain.panChangePanel, "basketMain");
		foodMain.basketMain.card.show(foodMain.basketMain.pChangePanel, "basket");
	}

}
