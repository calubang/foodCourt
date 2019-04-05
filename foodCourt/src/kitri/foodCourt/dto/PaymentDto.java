package kitri.foodCourt.dto;

import java.util.*;

public class PaymentDto implements Payment{
	//결제정보
	//private String paymentId;
	private String requestNumber;				//요청번호
	private UserDto user;							//유저정보
	private String paymentDate;					//결제일
	private int totalPrice;							//총가격
	private int savePoint;
	//결제로 사용한 금액
	private int usedPoint;
	private int card;
	private int cash;
	private char paymentState;
	//결제시 포함된 음식
	private List<PaymentDetailDto> detailList;
	
	//생성자
	public PaymentDto(UserDto user) {
		super();
		this.user = user;
		totalPrice = 0;
		savePoint = 0;
		usedPoint = 0;
		card = 0;
		cash = 0;
		detailList = new ArrayList<PaymentDetailDto>();
	}
	public String getRequestNumber() {
		return requestNumber;
	}
	public void setRequestNumber(String requestNumber) {
		this.requestNumber = requestNumber;
	}
	public UserDto getUser() {
		return user;
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
	public int getUsedPoint() {
		return usedPoint;
	}
	public void setUsedPoint(int usedPoint) {
		this.usedPoint = usedPoint;
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
	public List<PaymentDetailDto> getDetailList() {
		return detailList;
	}
	public void setDetailList(List<PaymentDetailDto> detailList) {
		this.detailList = detailList;
	}
	
	//구현 메소드
	//추가
	public int add(PaymentDetailDto detail) {
		detailList.add(detail);
		totalPrice += detail.getFood().getPrice();
		savePoint += detail.getFood().getPoint();
		return detailList.size();
	}
	//삭제(index로 삭제)
	public PaymentDetailDto remove(int index) {
		PaymentDetailDto detail = remove(index);
		totalPrice -= detail.getFood().getPrice();
		savePoint -= detail.getFood().getPoint();
		return detailList.remove(index);
	}
	//삭제(비교해서 삭제)
	//없으면 null 있으면 삭제한 객체
	public PaymentDetailDto remove(PaymentDetailDto detailRemove) {
		int size = detailList.size();
		PaymentDetailDto detail = null;
		for(int i = 0 ; i<size ; i++) {
			if(detailList.get(i) == detailRemove) {
				remove(i);
			}
		}
		return detail;
	}
	//모두 삭제
	public int removeAll() {
		Iterator<PaymentDetailDto> iter = detailList.iterator();
		int size = detailList.size();
		while(iter.hasNext()) {
			iter.remove();
		}
		totalPrice = 0;
		savePoint = 0;
		return size;
	}
	
}
