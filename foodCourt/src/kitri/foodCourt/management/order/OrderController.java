package kitri.foodCourt.management.order;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class OrderController implements ActionListener{
	OrderListFrame orderListFrame;
	OrderService orderService;
	public OrderController(OrderListFrame orderListFrame) {
		this.orderListFrame = orderListFrame;
		this.orderService = new OrderService(this);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob == orderListFrame.btnOrderview) {
			orderService.visibleOrder();
		} else if(ob == orderListFrame.btnComplete) {
			orderService.completeOrder();
		} else if(ob == orderListFrame.btnRemove) {
			orderService.removeOrder();
		} else if(ob instanceof OrderListButton) {
			orderService.setGlobalOrderButton(ob);
		}
	}
}
