package kitri.foodCourt.user.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import kitri.foodCourt.user.main.FoodMain;
import javax.swing.JButton;

public class FoodMainController implements ActionListener{
	FoodMain foodMain = null;
	FoodMainService foodMainService = null;
	public FoodMainController(FoodMain main) {
		this.foodMain = main;
		foodMainService = new FoodMainService(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == foodMain.btnMainMenu)
			foodMainService.clickMain();
		else if(ob == foodMain.btnSearch || ob == foodMain.searchField)
			foodMainService.searchMenuName();
		else if(ob == foodMain.btnUserInfo)
			foodMainService.userInfo();
		else if(ob == foodMain.btnOrderList)
			foodMainService.orderList();
		else if(ob instanceof MenuButton) {
			foodMainService.searchMenuDetail(((MenuButton) ob).getName());
		} else if(ob instanceof MainButton){
			foodMainService.searchCategory(((JButton)ob).getName());
		} else if(((JButton)ob).getName().equals("back")) {
			foodMainService.backMenu();
		} else if(((AddOrderListButton)ob).getName().equals("basket")) {
			foodMainService.addMenuInbasket(((AddOrderListButton)ob).getFoodDto(), ((AddOrderListButton)ob).getCount());
		}
			
	}

}