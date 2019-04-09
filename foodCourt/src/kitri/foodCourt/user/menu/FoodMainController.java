package kitri.foodCourt.user.menu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		else if(ob == foodMain.btnSearch)
			foodMainService.searchMenuName();
		else if(ob == foodMain.btnUserInfo)
			foodMainService.userInfo();
		else if(ob == foodMain.btnOrderList)
			foodMainService.orderList();
		else if(ob instanceof MenuButton) {
			foodMainService.searchMenuDetail(((MenuButton) ob).getName());
		}
		else {
			foodMainService.searchMenu((JButton)ob);
		}
	}

}