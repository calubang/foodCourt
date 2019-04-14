package kitri.foodCourt.user.menu;

import kitri.foodCourt.user.main.FoodMain;
import kitri.foodCourt.user.swing.RoundPanel;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JTextField;

public class FoodMainController implements ActionListener, KeyListener, MouseListener{
	FoodMain foodMain = null;
	public FoodMainService foodMainService = null;
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
		} else if(ob instanceof RoundPanel) {
			foodMainService.searchCategory(((RoundPanel)ob).getName());
		} else if(ob instanceof MainButton){
			foodMainService.searchCategory(((JButton)ob).getName());
		} else if(ob == foodMain.pfPassword) {
			foodMainService.isCorrectPassword();
		} else if(((JButton)ob).getName().equals("back")) {
			foodMainService.backMenu();
		} else if(((AddOrderListButton)ob).getName().equals("basket")) {
			foodMainService.addMenuInbasket(((AddOrderListButton)ob).getFoodDto(), ((AddOrderListButton)ob).getCount());
		} 
			
	}
	//숫자 이외의 키를 입력시 막는 메소드
	@Override
	public void keyTyped(KeyEvent e) {
		foodMainService.validationCheck(e);
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		String name = e.getComponent().getName();
		if(name.charAt(0) >= '0' && name.charAt(0) <= '9') {
			foodMainService.searchCategory(name);
		} else if(name.equals("back")){
			foodMainService.backMenu();
		} else if(name.equals("basket")){

		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}