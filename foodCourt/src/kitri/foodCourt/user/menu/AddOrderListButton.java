package kitri.foodCourt.user.menu;

import javax.swing.JButton;

import kitri.foodCourt.dto.FoodDto;

public class AddOrderListButton extends JButton{
	FoodDto foodDto;
	UserMenuDetailView userMenuDetailView;
	public AddOrderListButton(String text, UserMenuDetailView userMenuDetailView) {
		super(text);
		this.userMenuDetailView = userMenuDetailView;
	}
	public FoodDto getFoodDto() {
		return this.foodDto;
	}
	public void setFoodDto(FoodDto foodDto) {
		this.foodDto = foodDto;
	}
	public int getCount() {
		return userMenuDetailView.getCount();
	}
	
}
