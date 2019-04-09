package kitri.foodCourt.dto;

public class PaymentDetailDto {
	
	String foodId;
	String foodName;
	int price;
	int count;
	int point;
	
	public PaymentDetailDto(String foodId, String foodName, int price, int count, int point) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.price = price;
		this.count = count;
		this.point = point;
	}
	
	public String getFoodId() {
		return foodId;
	}
	public void setFoodId(String foodId) {
		this.foodId = foodId;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}

	@Override
	public String toString() {
		return "PaymentDetailDto [foodId=" + foodId + ", foodName=" + foodName + ", price=" + price + ", count=" + count
				+ ", point=" + point + "]";
	}
	
	
}
