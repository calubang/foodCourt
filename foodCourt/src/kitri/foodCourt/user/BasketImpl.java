package kitri.foodCourt.user;

import java.util.*;

import kitri.foodCourt.dto.UserDto;
import kitri.foodCourt.user.swing.FLabel;

public class BasketImpl implements Basket{
	//장바구니
	private int requestNumber;				//요청번호
	private String paymentDate;					//결제일
	private int totalPrice;							//총가격
	private int savePoint;
	//차후 결제로 사용될 부분(? 약간 애매함. 구지 안가지고 있어도 될지도 모르것음. 
	//                          paymentDto가 있기때문에.. )
	private int usedPoint;
	private int card;
	private int cash;
	//결제시 포함된 음식
	private List<BasketDetail> detailList;
	
	//결제 add시 메인화면 수정
	private FLabel orderCount;

	//생성자
	public BasketImpl() {
		super();
		totalPrice = 0;
		savePoint = 0;
		usedPoint = 0;
		card = 0;
		cash = 0;
		detailList = new ArrayList<BasketDetail>();
	}
	
	public int getRequestNumber() {
		return requestNumber;
	}
	public void setRequestNumber(int requestNumber) {
		this.requestNumber = requestNumber;
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
	public List<BasketDetail> getDetailList() {
		return detailList;
	}
	public void setDetailList(List<BasketDetail> detailList) {
		this.detailList = detailList;
	}
	
	public FLabel getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(FLabel orderCount) {
		this.orderCount = orderCount;
	}
	
	//구현 메소드
	//유저용
	//추가
	public int add(BasketDetail detail) {
		int size = detailList.size();
		BasketDetail temp = null;
		for(int i = 0 ; i < size  ; i++) {
			temp = detailList.get(i);
			if(temp.getFood().getFoodId().equals(detail.getFood().getFoodId())) {
				temp.setCount(temp.getCount() + detail.getCount());
				totalPrice += detail.getFood().getPrice() * detail.getCount();
				savePoint += detail.getFood().getPoint() * detail.getCount();
				return detailList.size();
			}
		}
		detailList.add(detail);
		totalPrice += detail.getFood().getPrice() * detail.getCount();
		savePoint += detail.getFood().getPoint() * detail.getCount();
		if(orderCount != null) {
			if(size == 0) {
				orderCount.setText("");
			}else {
				orderCount.setText(detailList.size()+"");
			}
		}
		return detailList.size();
	}
	//삭제(index로 삭제)
	public BasketDetail remove(int index) {
		BasketDetail detail = detailList.get(index);
		totalPrice -= detail.getFood().getPrice();
		savePoint -= detail.getFood().getPoint();
		detail = detailList.remove(index);
		if(orderCount != null) {
			if(detailList.size() == 0) {
				orderCount.setText("");
			}else {
				orderCount.setText(detailList.size()+"");
			}
		}
		return detail;
	}
	//삭제(비교해서 삭제)
	//없으면 null 있으면 삭제한 객체
	public BasketDetail remove(BasketDetail detailRemove) {
		int size = detailList.size();
		BasketDetail detail = null;
		for(int i = 0 ; i<size ; i++) {
			if(detailList.get(i) == detailRemove) {
				remove(i);
			}
		}
		return detail;
	}
	//모두 삭제
	public int removeAll() {
		Iterator<BasketDetail> iter = detailList.iterator();
		int size = detailList.size();
		while(iter.hasNext()) {
			BasketDetail temp = iter.next();
			iter.remove();
		}
		totalPrice = 0;
		savePoint = 0;
		return size;
	}
	
	@Override
	public String toString() {
		return "BasketImpl [requestNumber=" + requestNumber + ", paymentDate=" + paymentDate + ", totalPrice="
				+ totalPrice + ", savePoint=" + savePoint + ", usedPoint=" + usedPoint + ", card=" + card + ", cash="
				+ cash + ", detailList=" + detailList + "]";
	}
}
