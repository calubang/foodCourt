package kitri.foodCourt.dto;

import java.util.*;

import kitri.foodCourt.user.Basket;
import kitri.foodCourt.user.BasketDetail;

public class PaymentDto {
	private String paymentId;
	private String userId;
	private String paymentDate;
	private int totalPrice;
	private int savePoint;
	private int used_point;
	private int card;
	private int cash;
	private char paymentState;	
	
	List<PaymentDetailDto> detailList = new ArrayList<PaymentDetailDto>();
	
	public PaymentDto(String paymentId, String userId, String paymentDate, int totalPrice, int savePoint,
			int used_point, int card, int cash) {
		super();
		this.paymentId = paymentId;
		this.userId = userId;
		this.paymentDate = paymentDate;
		this.totalPrice = totalPrice;
		this.savePoint = savePoint;
		this.used_point = used_point;
		this.card = card;
		this.cash = cash;
	}
	
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getSavePoint() {
		return savePoint;
	}
	public void setSavePoint(int savePoint) {
		this.savePoint = savePoint;
	}
	public int getUsed_point() {
		return used_point;
	}
	public void setUsed_point(int used_point) {
		this.used_point = used_point;
	}
	public int getCard() {
		return card;
	}
	public void setCard(int card) {
		this.card = card;
	}
	public int getCash() {
		return cash;
	}
	public void setCash(int cash) {
		this.cash = cash;
	}
	public char getPaymentState() {
		return paymentState;
	}
	public void setPaymentState(char paymentState) {
		this.paymentState = paymentState;
	}

	@Override
	public String toString() {
		return "PaymentDto [paymentId=" + paymentId + ", userId=" + userId + ", paymentDate=" + paymentDate
				+ ", totalPrice=" + totalPrice + ", savePoint=" + savePoint + ", used_point=" + used_point + ", card="
				+ card + ", cash=" + cash + ", paymentState=" + paymentState + "]";
	}

}
