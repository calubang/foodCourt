package kitri.foodCourt.user;

import kitri.foodCourt.dto.FoodDto;

public class BasketDetail {
	FoodDto food;				//음식정보
	int count;					//개수
	
	public BasketDetail(FoodDto food, int count) {
		super();
		this.food = food;
		this.count = count;
	}
	
	public FoodDto getFood() {
		return food;
	}
	public void setFood(FoodDto food) {
		this.food = food;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}

	@Override
	public String toString() {
		return "PaymentDetailDto [food=" + food + ", count=" + count + "]";
	}
	
}
