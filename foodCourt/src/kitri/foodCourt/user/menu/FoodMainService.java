package kitri.foodCourt.user.menu;

import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.*;

import kitri.foodCourt.dto.FoodDto;
import kitri.foodCourt.user.BasketDetail;
import kitri.foodCourt.user.main.FoodMain;
import kitri.foodCourt.user.menu.jdbc.DaoFactory;

public class FoodMainService {
	FoodMainController foodMainController;
	FoodMain foodMain;
	MenuDao menuDao = new DaoFactory().menuDao();
	ImageIcon icon = new ImageIcon(FoodMain.class.getResource("/kitri/foodCourt/user/menu/mainImage/basket.png"));

	public FoodMainService(FoodMainController foodMainController) {
		this.foodMainController = foodMainController;
		this.foodMain = foodMainController.foodMain;
	}

	// 메인 메뉴 목록 페이지로 (메인메뉴)
	public void clickMain() {
		foodMain.setPanelName("foodMainView");
		foodMain.card.show(foodMain.panChangePanel, foodMain.getPanelName());
	}

	// 메뉴 목록 페이지로 (한식, 중식, 일식, 양식)
	public void searchCategory(String category) {
		List<FoodDto> list = menuDao.getMenubyCategory(Integer.parseInt(category));
		// foodMain.panChangePanel.remove(foodMain.userMenuView);
		foodMain.panChangePanel.add(new UserMenuView(list, this), "userMenuView");
		foodMain.setPanelName("userMenuView");
		foodMain.card.show(foodMain.panChangePanel, foodMain.getPanelName());
	}

	// 주문목록 페이지로 (검색 버튼)
	public void searchMenuName() {
		if (!foodMain.getPanelName().equals("basketMain")) {
			searchMenuNameImpl();
		} else {
			// 현재 페이지에서 나가겠습니까 (장바구니 혹은 결제 페이지에서)
			int result;
			result = JOptionPane.showConfirmDialog(foodMain.UserMenuDetailView, "현재페이지에서 나가시겠습니까?", "페이지",
					JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE);
			if(result==0) {
				searchMenuNameImpl();
			} 
		}
	}

	// 메뉴 상세 페이지로 (메뉴 이미지 버튼)
	public void searchMenuDetail(String food_id) {
		FoodDto foodDto = menuDao.getMenubyId(food_id);
		// foodMain.panChangePanel.remove(foodMain.UserMenuDetailView);
		foodMain.panChangePanel.add(new UserMenuDetailView(foodDto, this), "UserMenuDetailView");
		foodMain.setPanelName("UserMenuDetailView");
		foodMain.card.show(foodMain.panChangePanel, foodMain.getPanelName());
		System.out.println("카드 레이아웃 투스트링 : " + foodMain.card.toString());
	}

	// 이전으로 (이전으로 버튼)
	public void backMenu() {
		foodMain.setPanelName("UserMenuDetailView");
		foodMain.card.show(foodMain.panChangePanel, foodMain.getPanelName());
	}

	// 주문목록 추가 (장바구니 추가 버튼)
	public void addMenuInbasket(FoodDto foodDto, int count) {
		if (count != 0) {
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
				subResult = JOptionPane.showConfirmDialog(foodMain.UserMenuDetailView, "추가되었습니다\n장바구니로 가시겠습니까?",
						"titme", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, icon);
				System.out.println(subResult);
				if (subResult == 1 || subResult == -1) {
					backMenu();
				} else {
					foodMain.setPanelName("basketMain");
					foodMain.card.show(foodMain.panChangePanel, foodMain.getPanelName());
					foodMain.basketMain.card.show(foodMain.basketMain.pChangePanel, "basket");
				}
			}
		} else {
			JOptionPane.showMessageDialog(foodMain.UserMenuDetailView, "수량을 1개 이상 입력해주세요", "",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	// 유저 페이지로 (유저 정보 버튼)
	public void userInfo() {
	}

	// 주문목록 페이지로 (주문목록 버튼)
	public void orderList() {
		foodMain.basketMain.dataSetting();
		foodMain.setPanelName("basketMain");
		foodMain.card.show(foodMain.panChangePanel, foodMain.getPanelName());
		foodMain.basketMain.card.show(foodMain.basketMain.pChangePanel, "basket");
	}

	// 유효성 검사
	public void validationCheck(KeyEvent e) {
		char keyValue = e.getKeyChar();
		if (!Character.isDigit(keyValue)) {
			e.consume();
			return;
		}
	}
	private void searchMenuNameImpl() {
		String foodName = foodMain.searchField.getText();
		if (foodName.isEmpty())
			JOptionPane.showMessageDialog(foodMain, "전체 메뉴를 검색합니다", "", JOptionPane.OK_CANCEL_OPTION);
		List<FoodDto> list = menuDao.getMenubyName(foodName);
		if (list.size() != 0) {
			// foodMain.panChangePanel.remove(foodMain.userMenuView);
			foodMain.panChangePanel.add(new UserMenuView(list, this), "userMenuView");
			foodMain.setPanelName("userMenuView");
			foodMain.card.show(foodMain.panChangePanel, foodMain.getPanelName());
		} else {
			foodMain.setPanelName("noSearchMenuImg");
			foodMain.card.show(foodMain.panChangePanel, foodMain.getPanelName());
		}
	}
}