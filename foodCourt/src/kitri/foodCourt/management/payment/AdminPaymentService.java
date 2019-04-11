package kitri.foodCourt.management.payment;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;


public class AdminPaymentService {

	AdminPaymentControl apc;
	AdminPayment ap;
	
	AdminViewReceipt avr;
	
	JFrame jfR = new JFrame();
	JDialog jdR = new JDialog(jfR, "영수증");
	
	String[] option = {"예", "아니오"};
	String[] column1 = {"결제 ID", "회원 ID", "결제일", "요청번호", "결제 금액", "발생 포인트", "사용 포인트", "결제상태"};
	String[] column2 = {"카테고리", "메뉴명", "수량", "가격", "포인트"};
	
	DefaultTableModel dtmPayment;
	DefaultTableModel dtmReceipt;
	TableRowSorter<TableModel> sorter;
	
	List<RowSorter.SortKey> sortKeys = new ArrayList<>(column1.length);
	
    Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
	
	
	public AdminPaymentService(AdminPaymentControl apc) {
		this.apc = apc;
		ap = this.apc.ap;
		
		avr = new AdminViewReceipt();
		dtmPayment = ap.dtm;
		dtmReceipt = avr.dtm;
		
		// Set Table column
		for (int i = 0; i < column1.length; i++) {
			dtmPayment.addColumn(column1[i]);
		}
		
		for (int i = 0; i < column2.length; i++) {
			dtmReceipt.addColumn(column2[i]);
		}
		
		sorter = new TableRowSorter<TableModel>(ap.commonTable.getModel());
		
		for (int i = 0; i < column1.length; i++) {
			sortKeys.add(new RowSorter.SortKey(i, SortOrder.ASCENDING));
		}
		
		ap.commonTable.setRowSorter(sorter);
		sorter.setSortKeys(sortKeys);
	}
	
	
	private void closeOracleConnection(Connection c, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				rs = null;
			}
		}
		
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ps = null;
			}
		}
		
		if(c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				c = null;
			}
		}
	}
	
	public void showReceiptWindow() {
		if (ap.commonTable.getSelectedRow() < 0) {
			warningMessage(ap.checkReceiptBtn, "선택된 결제 내역이 없습니다.", "영수증 확인 오류");
			return;
		}
		
		dtmReceipt.setRowCount(0);
		
		int currentSelectedrow = ap.commonTable.convertRowIndexToModel(ap.commonTable.getSelectedRow());
		Object user_id = dtmPayment.getValueAt(currentSelectedrow, 1);
		
		Object[] rowData = new Object[8];
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.32:1521:orcl", "kitri", "kitri");
			
			ps = c.prepareStatement("select request_number, to_char(payment_date, 'yyyy.mm.dd hh24:mi:ss') \"payment_date\", category_name, pd.food_name \"food_name\", count, pd.price \"price\", pd.point \"point\", card, cash, used_point, total_price, save_point "
								  + "from fook_payment p, fook_payment_detail pd, fook_food f, fook_category fc "
								  + "where user_id = (?) and p.payment_id = pd.payment_id and pd.food_id = f.food_id and f.category_id = fc.category_id");
			
			ps.setString(1, (String)user_id);
			
			rs = ps.executeQuery();

			avr.memberIDValueLabel.setText((String)user_id);
			
			while (rs.next()) {
				avr.orderNumValueLabel.setText(rs.getString("request_number"));
				avr.orderDateValueLabel.setText(rs.getString("payment_date"));
				
				rowData[0] = rs.getString("category_name");
				rowData[1] = rs.getString("food_name");
				rowData[2] = rs.getInt("count");
				rowData[3] = rs.getInt("price");
				rowData[4] = rs.getInt("point");

				dtmReceipt.addRow(rowData);
				
				avr.moneyValueLabel.setText(String.valueOf(rs.getInt("cash")));
				avr.cardValueLabel.setText(String.valueOf(rs.getInt("card")));
				avr.pointValueLabel.setText(String.valueOf(rs.getInt("used_point")));
				avr.payTotalValueLabel.setText(String.valueOf(rs.getInt("total_price")));
				avr.getPointValueLabel.setText(String.valueOf(rs.getInt("save_point")));
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeOracleConnection(c, ps, rs);
		}
		
		jdR.getContentPane().add(avr);
		jdR.setSize(395, 720);
		jdR.setModal(true);
		jdR.setResizable(false);
		jdR.setVisible(true);
	}
	
	public void showDeleteWindow() {
		int result = JOptionPane.showOptionDialog(ap.deleteBtn, "삭제하시겠습니까?", "삭제 확인", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
		
		if (result == JOptionPane.OK_OPTION) {
			
		} else {
			return;
		}
	}

	public void closeReceiptWindow() {
		jdR.dispose();
	}

	public void showPayment() {
		Object[] rowData = new Object[8];
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.32:1521:orcl", "kitri", "kitri");
			
			ps = c.prepareStatement("select payment_id, user_id, to_char(payment_date, 'yyyy.mm.dd hh24:mi:ss') \"payment_date\", request_number, total_price, save_point, used_point, payment_state "
								  + "from fook_payment");
			
			rs = ps.executeQuery();

			while (rs.next()) {
				rowData[0] = rs.getString("payment_id").replace(" ", "");
				rowData[1] = rs.getString("user_id");
				rowData[2] = rs.getString("payment_date");
				rowData[3] = rs.getString("request_number");
				rowData[4] = rs.getInt("total_price");
				rowData[5] = rs.getInt("save_point");
				rowData[6] = rs.getInt("used_point");
				rowData[7] = rs.getString("payment_state").equals("0") ? "결제 완료" : "환불 처리";
				
				dtmPayment.addRow(rowData);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeOracleConnection(c, ps, rs);
		}
	}

	public void searchUserID() {
		String str = ap.searchTextField.getText().trim();
		
		int rowCount = dtmPayment.getRowCount();
		for(int i = 0; i < rowCount; i++) {
			if (str.equals((String)ap.commonTable.getValueAt(i, 1))) {
				ap.commonTable.setRowSelectionInterval(i, i);
				return;
			}
		}
		
		warningMessage(ap.searchTextField, "찾는 회원 ID가 없습니다.", "회원 검색 오류");
	}
	
	private void warningMessage(Component component, Object msg, String title) {
		JOptionPane.showMessageDialog(component, msg, title, JOptionPane.WARNING_MESSAGE);
	}
}
