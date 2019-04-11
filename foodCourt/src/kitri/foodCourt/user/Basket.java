package kitri.foodCourt.user;

import java.util.Iterator;
import java.util.List;

public interface Basket {
	
	//구현 메소드
	//추가 : list추가뿐 아니라 totalPrice와 savePoint 값도 같이 더함
	public int add(BasketDetail detail);
	//삭제(index로 삭제) : list삭제뿐 아니라 totalPrice와 savePoint 값도 같이 삭제
	public BasketDetail remove(int index);
	//삭제(비교해서 삭제)
	//없으면 null 있으면 삭제한 객체
	public BasketDetail remove(BasketDetail detailRemove);
	//모두 삭제 : 모두 0으로
	public int removeAll();
	
	public int getRequestNumber();
	public void setRequestNumber(int requestNumber);
	public String getPaymentDate();
	public void setPaymentDate(String paymentDate);
	public int getTotalPrice();
	public void setTotalPrice(int totalPrice);
	public int getSavePoint();
	public void setSavePoint(int savePoint);
	public List<BasketDetail> getDetailList();
	public void setDetailList(List<BasketDetail> detailList);
	
}
