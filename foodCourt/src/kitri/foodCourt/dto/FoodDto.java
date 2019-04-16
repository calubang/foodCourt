package kitri.foodCourt.dto;

import java.util.Date;

import kitri.foodCourt.util.Constance;

public class FoodDto {
	//유저 dto
	private String foodId;				
	private String foodName; 		
	private int categoryId;				
	private String categoryName;	
	private int price;						
	private int point;					
	private String description;		
	private String imageAddress;	
	
	//관리자 전용()
	private String managerId;		
	private Date createDate;		
	private char enable;				
		
	public FoodDto() {
	}
	
	public FoodDto(String foodId, String foodName, int categoryId, String categoryName, int price,
			String imageAddress) {
		super();
		this.foodId = foodId;
		this.foodName = foodName;
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.price = price;
		this.imageAddress = imageAddress;
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
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageAddress() {
		return Constance.FOOD_IMAGE_PATH + imageAddress;
	}
	public void setImageAddress(String imageAddress) {
		this.imageAddress = imageAddress;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public char getEnable() {
		return enable;
	}
	public void setEnable(char enable) {
		this.enable = enable;
	}

	@Override
	public String toString() {
		return "FoodDto [foodId=" + foodId + ", foodName=" + foodName + ", categoryId=" + categoryId + ", categoryName="
				+ categoryName + ", price=" + price + ", point=" + point + ", description=" + description
				+ ", imageAddress=" + imageAddress + ", managerId=" + managerId + ", createDate=" + createDate
				+ ", enable=" + enable + "]";
	}
}
