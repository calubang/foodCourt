package kitri.foodCourt.management.login;

import java.awt.event.*;
import java.io.IOException;

import kitri.foodCourt.management.order.OrderListServer;


public class LoginControl extends WindowAdapter implements ActionListener {

	LoginMain lm;
	LoginService ls;
	
	
	public LoginControl(LoginMain lm) {
		this.lm = lm;
		
		ls = new LoginService(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		
		if (ob == lm.panLogin.loginbtn) {
			ls.loginAdmin();
		}
	}
	@Override
	public void windowClosing(WindowEvent e) {
		super.windowClosing(e);
		if(LoginMain.orderListFrame != null) {
		OrderListServer orderListServer = LoginMain.orderListFrame.orderListServer;
		//안전하게 종료 하기!!
		System.out.println("안전종료 메소드 실행");
		if(LoginMain.orderListFrame.orderListServer.serverSocket != null) {try {orderListServer.serverSocket.close();orderListServer.flag = false;} catch (IOException io) {io.printStackTrace();}}
		if(orderListServer.socket != null) {try {orderListServer.socket.close();} catch (IOException io) {io.printStackTrace();}}
		if(orderListServer.in != null) {try {orderListServer.in.close();} catch (IOException io) {io.printStackTrace();}}
		if(orderListServer.out != null) {try {orderListServer.out.close();} catch (IOException io) {io.printStackTrace();}}
		}
	}
}
