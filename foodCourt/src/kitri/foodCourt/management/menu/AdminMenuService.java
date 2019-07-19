package kitri.foodCourt.management.menu;

import java.awt.Component;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import kitri.foodCourt.db.ConnectionMaker;
import kitri.foodCourt.db.DbFactory;
import kitri.foodCourt.management.main.AdminMainFrame;


public class AdminMenuService {

	AdminMenuControl amc;
	AdminMenuManagement amm;
	AdminRegisterMenu arm;
	AdminModifyMenu am;
	AdminMainFrame amf;
	
	String[] option = {"예", "아니오"};
	String[] column = {"메뉴ID", "메뉴이름", "카테고리", "가격", "포인트", "담당매니저", "등록일", "주문가능여부"};
	
	DefaultTableModel dtm;
	TableRowSorter<TableModel> sorter;
	List<RowSorter.SortKey> sortKeys = new ArrayList<>(column.length);
	
	JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif", "png");
	
    // Default Directory
    String currentPath = File.separator + "img" + File.separator + "food";

    // For OracleDB
    Connection c = null;
    PreparedStatement ps = null;
    ResultSet rs = null;
    private ConnectionMaker connectionMaker;
    

    /**
     * 1. Add JTable columns.
     * 2. Add sorter to each columns.
     * 3. Fix available image file extensions.
     * 
     * @param amc AdminMenuControl object
     */
    public AdminMenuService(AdminMenuControl amc) {
		this.amc = amc;
		amm = this.amc.amm;
		arm = amm.arm;
		am = amm.am;
		
		dtm = amm.dtm;
		
		for (int i = 0; i < column.length; i++) {
			dtm.addColumn(column[i]);
		}
		
		sorter = new TableRowSorter<TableModel>(amm.commonTable.getModel());
		for (int i = 0; i < column.length; i++) {
			sortKeys.add(new RowSorter.SortKey(i, SortOrder.ASCENDING));
		}
		amm.commonTable.setRowSorter(sorter);
		sorter.setSortKeys(sortKeys);
		
		chooser.setFileFilter(filter);
		
		connectionMaker = DbFactory.connectionMaker("oracle");
	}
	
	/**
	 * Finally close SQL connection if each object is not null.
	 * 
	 * @param comp Component which warning occured.
	 * @param c Connection object
	 * @param ps PreparedStatement object
	 * @param rs ResultSet object
	 */
	private void closeOracleConnection(Component comp, Connection c, PreparedStatement ps, ResultSet rs) {
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				warningMessage(comp, e.getMessage(), "SQL 종료 오류");
			} finally {
				rs = null;
			}
		}
		
		if(ps != null) {
			try {
				ps.close();
			} catch (SQLException e) {
				warningMessage(comp, e.getMessage(), "SQL 종료 오류");
			} finally {
				ps = null;
			}
		}
		
		if(c != null) {
			try {
				c.close();
			} catch (SQLException e) {
				warningMessage(comp, e.getMessage(), "SQL 종료 오류");
			} finally {
				c = null;
			}
		}
	}
	
	/**
	 * Show Menu register window.
	 * When register window is opened, each components are reset.
	 */
	public void showRegisterWindow() {
		arm.menuNameTextField.setText("");
		arm.priceTextField.setText("");
		arm.pointTextField.setText("");
		arm.descriptionTextArea.setText("");
		arm.categoryComboBox.setSelectedIndex(0);
		arm.pictureLabel.setText("사진");
		arm.pictureLabel.setIcon(null);
		
		amm.jdR.getContentPane().add(arm);
		amm.jdR.setSize(750, 650);
		amm.jdR.setResizable(false);
		amm.jdR.setModal(true);
		amm.jdR.setVisible(true);
	}
	
	/**
	 * Show Menu register window.
	 * When register window is opened, information of currently selected row is showed.
	 * 
	 * Process : 1) Check if menu is selected
	 *           2) Get information from DB
	 */
	public void showModifyWindow() {
		ImageIcon image = null;
		String imgUrl = null;

		int rowSelect = amm.commonTable.getSelectedRow();
		if (rowSelect == -1) {
			warningMessage(amm.modifyBtn, "수정할 메뉴가 없습니다.", "메뉴 수정 오류");
			closeWindow(amm.jdM);
			return;
		}
		
		try {
			rowSelect = amm.commonTable.convertRowIndexToModel(rowSelect);
			
			c = connectionMaker.makeConnection();
			
			ps = c.prepareStatement("select * "
								  + "from fook_food "
								  + "where food_id = (?)");
			
			ps.setString(1, (String)dtm.getValueAt(rowSelect, 0));
			rs = ps.executeQuery();

			if (rs.next()) {
				am.menuCodeTextField.setText(rs.getString("food_id"));
				am.menuNameTextField.setText(rs.getString("food_name"));
				am.priceTextField.setText(String.valueOf(rs.getInt("price")));
				am.pointTextField.setText(String.valueOf(rs.getInt("food_point")));
				am.descriptionTextArea.setText(rs.getString("food_description"));
				am.categoryComboBox.setSelectedIndex(rs.getInt("category_id") - 1);
				am.cg.setSelectedCheckbox((rs.getString("food_enable").charAt(0) == 'y') ? am.checkBox1 : am.checkBox2);
				
				imgUrl = rs.getString("image_address");
			}

			File f = new File(currentPath + File.separator + imgUrl);
			image = new ImageIcon(AdminMenuService.class.getResource(f.getPath().replace("\\", "/")));
			
			am.pictureLabel.setIcon(image);
		} catch (SQLException e) {
			warningMessage(amm.modifyBtn, e.getMessage(), "메뉴 수정 오류");
		} finally {
			closeOracleConnection(amm.modifyBtn, c, ps, rs);
		}
		
		amm.jdM.getContentPane().add(amm.am);
		amm.jdM.setSize(750, 650);
		amm.jdM.setModal(true);
		amm.jdM.setResizable(false);
		amm.jdM.setVisible(true);
	}
	
	/**
	 * Show Menu deletion window.
	 * When "OK" is selected, data is removed to JTable and DB.
	 * 
	 * Process : 1) Ask if menu is really delete
	 *           2) If OK, remove menu from DB and JTable
	 *           3) If No, method ends
	 *           4) If menu is not selected, show warning message
	 */
	public void showDeleteWindow() {
		int resultQuery = 0;
		
		int result = JOptionPane.showOptionDialog(amm.deleteBtn, "정말 삭제하시겠습니까?\n(삭제하면 다시 되돌릴 수 없습니다.)", "삭제 확인", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
		int currentSelectedrow = amm.commonTable.getSelectedRow();
		
		if (result == JOptionPane.OK_OPTION) {
			if (currentSelectedrow >= 0) {
				currentSelectedrow = amm.commonTable.convertRowIndexToModel(currentSelectedrow);
				Object ob = amm.commonTable.getModel().getValueAt(currentSelectedrow, 0);

				try {
					c = connectionMaker.makeConnection();
					
					ps = c.prepareStatement("delete from fook_food "
										  + "where food_id = (?)");
					
					ps.setString(1, (String)ob);
					
					resultQuery = ps.executeUpdate();
				} catch (SQLException e) {
					warningMessage(amm.deleteBtn, e.getMessage(), "메뉴 삭제 오류");
				} finally {
					closeOracleConnection(amm.deleteBtn, c, ps, null);
				}
				
				dtm.removeRow(currentSelectedrow);
			}
		} else {
			return;
		}
		
		if (resultQuery == 0) {
			warningMessage(amm.deleteBtn, "삭제할 메뉴가 없습니다.", "메뉴 삭제 오류");
		}
	}
	
	/**
	 * Show Menu to JTable.
	 * 
	 * Process : 1) Get all menu information
	 *           2) Add JTable using TableModel
	 */
	public void showMenu() {
		Object[] rowData = new Object[8];
		
		try {
			c = connectionMaker.makeConnection();
			
			ps = c.prepareStatement("select food_id, food_name, f.category_id \"category_id\", category_name, price, food_point, food_description, image_address, manager_id, create_date, food_enable "
								  + "from fook_food f, fook_category c "
								  + "where f.category_id = c.category_id");
			
			rs = ps.executeQuery();

			while (rs.next()) {
				rowData[0] = rs.getString("food_id");
				rowData[1] = rs.getString("food_name");
				rowData[2] = rs.getString("category_name");
				rowData[3] = rs.getInt("price");
				rowData[4] = rs.getInt("food_point");
				rowData[5] = rs.getString("manager_id");
				rowData[6] = rs.getDate("create_date").toString();
				rowData[7] = (rs.getString("food_enable").charAt(0) == 'y') ? "주문 가능" : "주문 불가능";
				
				dtm.addRow(rowData);
			}
		} catch (SQLException e) {
			warningMessage(amm.commonTable, e.getMessage(), "메뉴 보기 오류");
		} finally {
			closeOracleConnection(amm.commonTable, c, ps, rs);
		}
	}

	/**
	 * Show menu image and description.
	 * 
	 * Process : 1) Get image file name and description
	 *           2) Show iamge to JLabel
	 *           3) Show description to JTextArea
	 */
	public void showImageDescription() {
		int currentSelectedrow = amm.commonTable.getSelectedRow();
		if (currentSelectedrow >= 0) {
			currentSelectedrow = amm.commonTable.convertRowIndexToModel(currentSelectedrow);
			Object ob = amm.commonTable.getModel().getValueAt(currentSelectedrow, 0);
			
			String imgUrl = null;
			String description = null;
			
			try {
				c = connectionMaker.makeConnection();
				
				ps = c.prepareStatement("select image_address, food_description "
									  + "from fook_food "
									  + "where food_id = (?)");
				
				ps.setString(1, (String)ob);
				
				rs = ps.executeQuery();
	
				if (rs.next()) {
					imgUrl = rs.getString("image_address");
					description = rs.getString("food_description");
				}
			} catch (SQLException e) {
				warningMessage(amm.commonTable, e.getMessage(), "메뉴 보기 오류");
			} finally {
				closeOracleConnection(amm.commonTable, c, ps, rs);
			}
			
			File f = new File(currentPath + File.separator + imgUrl);
			ImageIcon image = new ImageIcon(AdminMenuService.class.getResource(f.getPath().replace("\\", "/")));
			amm.pictureLabel.setIcon(image);
			
			amm.descriptionTextArea.setText(description);
		}
	}

	/**
	 * Close JDialog window
	 * 
	 * @param jd Which JDialog is closed
	 */
	public void closeWindow(JDialog jd) {
		jd.dispose();
	}

	/**
	 * Search Menu in JTable.
	 * If menu is exactly equals in JTable, row is selected.
	 * If no one is matched, warning message occurs.
	 */
	public void searchFood() {
		String str = amm.searchTextField.getText().trim();
		
		int rowCount = dtm.getRowCount();
		for(int i = 0; i < rowCount; i++) {
			if (str.equals((String)amm.commonTable.getValueAt(i, 1))) {
				amm.commonTable.setRowSelectionInterval(i, i);
				return;
			}
		}
		
		warningMessage(amm.searchTextField, "찾는 메뉴가 없습니다.", "메뉴 검색 오류");
	}

	/**
	 * Open File chooser dialog and select image file.
	 * It is possible to select file in absolute and relative path.
	 * 
	 * When image is selected, show in JLabel.
	 * 
	 * @param ob Which button is selected
	 */
	public void findImage(Object ob) {
		chooser.setCurrentDirectory(new File("." + File.separator + "src" + currentPath));
		int choice = chooser.showOpenDialog((Component)ob);
		String imgUrl = null;
		ImageIcon image = null;
		
		if (choice == JFileChooser.APPROVE_OPTION) {
			String fullpath = chooser.getSelectedFile().toString();
			imgUrl = fullpath.replace('\\', '/');
			image = new ImageIcon(imgUrl);
			
			if (ob == arm.registerImageBtn) {
				arm.pictureLabel.setText(null);
				arm.pictureLabel.setIcon(image); 
			} else if (ob == am.changeImageBtn) {
				am.pictureLabel.setIcon(image);
			}
		} else {
			return;
		}
	}

	/**
	 * Show warning message.
	 * 
	 * @param component Which component cause the warning
	 * @param msg Warning message
	 * @param title Title message
	 */
	private void warningMessage(Component component, Object msg, String title) {
		JOptionPane.showMessageDialog(component, msg, title, JOptionPane.WARNING_MESSAGE);
	}
	
	/**
	 * Process modify menu
	 * 
	 * Process : 1) Check each field values are validated
	 *           2) Check new named menu is duplicated with other menus
	 *           3) If image is not exist in folder, then copied into folder
	 *           4) Update values to DB and JTable
	 */
	public void modifyMenu() {
		int currentSelectedrow = amm.commonTable.convertRowIndexToModel(amm.commonTable.getSelectedRow());
		int result = 0;
		
		Object[] rowData = new Object[8];

		String food_id = am.menuCodeTextField.getText();
		if (food_id.isEmpty()) {
			warningMessage(am.confirmBtn, "메뉴 ID를 입력하세요.", "메뉴 수정 오류");
			return;
		}
		
		String food_name = am.menuNameTextField.getText();
		if (food_name.isEmpty()) {
			warningMessage(am.confirmBtn, "메뉴 이름을 입력하세요.", "메뉴 수정 오류");
			return;
		}
		
		int rowCount = dtm.getRowCount();
		for(int i = 0; i < rowCount; i++) {
			if (i == amm.commonTable.getSelectedRow()) {
				continue;
			}
			
			if (food_name.equals((String)amm.commonTable.getValueAt(i, 1))) {
				warningMessage(am.confirmBtn, "중복되는 메뉴가 있습니다.", "메뉴 수정 오류");
				return;
			}
		}
		
		String priceStr = am.priceTextField.getText();
		if (priceStr.isEmpty()) {
			warningMessage(am.confirmBtn, "메뉴 가격을 입력하세요.", "메뉴 수정 오류");
			return;
		}
		
		if (!isConvertDigit(priceStr)) {
			warningMessage(am.confirmBtn, "메뉴 가격은 숫자만 입력 가능합니다.", "메뉴 수정 오류");
			return;
		}
		
		if (priceStr.length() > 6) {
			warningMessage(am.confirmBtn, "메뉴 가격이 너무 큽니다.", "메뉴 수정 오류");
			return;
		}
		int price = Integer.parseInt(priceStr);
		
		String pointStr = am.pointTextField.getText();
		if (!isConvertDigit(pointStr)) {
			warningMessage(arm.confirmBtn, "메뉴 포인트는 숫자만 입력 가능합니다.", "메뉴 동록 오류");
			return;
		}
		
		if (pointStr.length() > 6) {
			warningMessage(arm.confirmBtn, "메뉴 포인트가 너무 큽니다.", "메뉴 동록 오류");
			return;
		}
		int point = pointStr.isEmpty() ? (price / 100) : Integer.parseInt(pointStr);
		
		String food_enable = am.cg.getSelectedCheckbox().equals(am.checkBox1) ? "y" : "n";
		String food_description = am.descriptionTextArea.getText();
		int category = am.categoryComboBox.getSelectedIndex() + 1;
		if (category < 1) {
			warningMessage(am.confirmBtn, "카테고리를 선택하세요.", "메뉴 수정 오류");
			return;
		}
		
		Icon food_image = am.pictureLabel.getIcon();
		if (food_image == null) {
			warningMessage(am.confirmBtn, "메뉴 이미지를 선택하세요.", "메뉴 수정 오류");
			return;
		}		
		String fullpath = food_image.toString();
		String imgUrl = fullpath.substring(fullpath.lastIndexOf("/") + 1, fullpath.length());
		
		String manager_id = amm.adminID;
		
		try {
			c = connectionMaker.makeConnection();
			ps = c.prepareStatement("select image_address "
					  + "from fook_food "
					  + "where image_address = (?)");

			ps.setString(1, imgUrl);
			
			rs = ps.executeQuery();
			
			if (!rs.next()) {
				try {
					BufferedImage image = null;

					File fin = new File(fullpath);
					File fout = new File("." + File.separator + "src" + currentPath + File.separator + imgUrl);

					if (!fout.exists()) {
						image = ImageIO.read(fin);
						ImageIO.write(image, "jpg", fout);
					}
				} catch (IOException e) {
					warningMessage(am.confirmBtn, "메뉴 이미지 복사 중 에러가 발생하였습니다.", "메뉴 수정 오류");
				}
			}
			
			rs.close();
			ps.close();
			
			ps = c.prepareStatement("update fook_food "
								  + "set food_name = (?), category_id = (?), price = (?), food_point = (?), food_description = (?), image_address = (?), manager_id = (?), food_enable = (?) "
								  + "where food_id = (?)");
			
			ps.setString(1, food_name);
			ps.setInt(2, category);
			ps.setInt(3, price);
			ps.setInt(4, point);
			ps.setString(5, food_description);
			ps.setString(6, imgUrl);
			ps.setString(7, manager_id);
			ps.setString(8, food_enable);
			ps.setString(9, food_id);
			
			result = ps.executeUpdate();

			ps.close();
			
			ps = c.prepareStatement("select category_name "
								  + "from fook_category "
								  + "where category_id = (select distinct category_id from fook_food where category_id = (?))");
			
			ps.setInt(1, category);
			
			rs = ps.executeQuery();
			
			if ((result != 0) && rs.next()) {
				rowData[0] = food_id;
				rowData[1] = food_name;
				rowData[2] = rs.getString("category_name");
				rowData[3] = price;
				rowData[4] = point;
				rowData[5] = manager_id;
				rowData[6] = dtm.getValueAt(currentSelectedrow, 6);
				rowData[7] = food_enable.equals("y") ? "주문 가능" : "주문 불가능";

				int columnNum = dtm.getColumnCount();
				for (int i = 0; i < columnNum; i++) {
					dtm.setValueAt(rowData[i], currentSelectedrow, i);
				}
			}
			
			amm.commonTable.setRowSelectionInterval(amm.commonTable.getSelectedRow(), amm.commonTable.getSelectedRow());
		} catch (SQLException e) {
			warningMessage(am.confirmBtn, e.getMessage(), "메뉴 수정 오류");
		} finally {
			closeOracleConnection(am.confirmBtn, c, ps, rs);
		}
		
		closeWindow(amm.jdM);
	}

	/**
	 * Process register menu
	 * 
	 * Process : 1) Check each field values are validated
	 *           2) Check new named menu is duplicated with other menus
	 *           3) If image is not exist in folder, then copied into folder
	 *           4) Insert values to DB and JTable
	 */
	public void registerMenu() {
		int result = 0;
		
		Object[] rowData = new Object[8];

		String food_name = arm.menuNameTextField.getText();
		if (food_name.isEmpty()) {
			warningMessage(arm.confirmBtn, "메뉴 이름을 입력하세요.", "메뉴 등록 오류");
			return;
		}
		
		int rowCount = dtm.getRowCount();
		for(int i = 0; i < rowCount; i++) {
			if (food_name.equals((String)amm.commonTable.getValueAt(i, 1))) {
				warningMessage(arm.confirmBtn, "중복되는 메뉴가 있습니다.", "메뉴 등록 오류");
				return;
			}
		}
		
		String food_enable = "y";
		String food_description = arm.descriptionTextArea.getText();
		
		Icon food_image = arm.pictureLabel.getIcon();
		if (food_image == null) {
			warningMessage(arm.confirmBtn, "메뉴 이미지를 선택하세요.", "메뉴 등록 오류");
			return;
		}		
		String fullpath = food_image.toString();
		String imgUrl = fullpath.substring(fullpath.lastIndexOf("/") + 1, fullpath.length());
		
		String manager_id = amm.adminID;
		
		String priceStr = arm.priceTextField.getText();
		if (priceStr.isEmpty()) {
			warningMessage(arm.confirmBtn, "메뉴 가격을 입력하세요.", "메뉴 동록 오류");
			return;
		}
		
		if (!isConvertDigit(priceStr)) {
			warningMessage(arm.confirmBtn, "메뉴 가격은 숫자만 입력 가능합니다.", "메뉴 동록 오류");
			return;
		}
		
		if (priceStr.length() > 6) {
			warningMessage(arm.confirmBtn, "메뉴 가격이 너무 큽니다.", "메뉴 동록 오류");
			return;
		}
		int price = Integer.parseInt(priceStr);
		
		String pointStr = arm.pointTextField.getText();
		if (!isConvertDigit(pointStr)) {
			warningMessage(arm.confirmBtn, "메뉴 포인트는 숫자만 입력 가능합니다.", "메뉴 동록 오류");
			return;
		}
		
		if (pointStr.length() > 6) {
			warningMessage(arm.confirmBtn, "메뉴 포인트가 너무 큽니다.", "메뉴 동록 오류");
			return;
		}
		int point = pointStr.isEmpty() ? (price / 100) : Integer.parseInt(pointStr);
		
		int category = arm.categoryComboBox.getSelectedIndex() + 1;
		if (category < 1) {
			warningMessage(arm.confirmBtn, "카테고리를 선택하세요.", "메뉴 등록 오류");
			return;
		}
		
		try {
			c = connectionMaker.makeConnection();
			
			ps = c.prepareStatement("select image_address "
					  + "from fook_food "
					  + "where image_address = (?)");

			ps.setString(1, imgUrl);
			
			rs = ps.executeQuery();
			
			if (!rs.next()) {
				try {
					BufferedImage image = null;

					File fin = new File(fullpath);
					File fout = new File("." + File.separator + "src" + currentPath + File.separator + imgUrl);
					
					if (!fout.exists()) {
						image = ImageIO.read(fin);
						ImageIO.write(image, "jpg", fout);
					}
				} catch (IOException e) {
					warningMessage(arm.confirmBtn, "메뉴 이미지 복사 중 에러가 발생하였습니다.", "메뉴 등록 오류");
				}
			}
			
			rs.close();
			ps.close();
			
			ps = c.prepareStatement("insert into fook_food (food_id, food_name, category_id, price, food_point, food_description, image_address, manager_id, create_date, food_enable) "
												 + "values (food_fid_seq.nextval, (?), (?), (?), (?), (?), (?), (?), sysdate, (?))");
			
			ps.setString(1, food_name);
			ps.setInt(2, category);
			ps.setInt(3, price);
			ps.setInt(4, point);
			ps.setString(5, food_description);
			ps.setString(6, imgUrl);
			ps.setString(7, manager_id);
			ps.setString(8, food_enable);
			
			result = ps.executeUpdate();

			ps.close();
			
			ps = c.prepareStatement("select food_id, category_name, create_date "
								  + "from fook_food f, fook_category c "
								  + "where (food_id = (select max(to_number(food_id,'999999')) from fook_food)) and (f.category_id = c.category_id)");
			
			rs = ps.executeQuery();
			
			if ((result != 0) && rs.next()) {
				rowData[0] = rs.getString("food_id");
				rowData[1] = food_name;
				rowData[2] = rs.getString("category_name");
				rowData[3] = price;
				rowData[4] = point;
				rowData[5] = manager_id;
				rowData[6] = rs.getDate("create_date");
				rowData[7] = food_enable.equals("y") ? "주문 가능" : "주문 불가능";
			}
			
			dtm.addRow(rowData);
		} catch (SQLException e) {
			warningMessage(arm.confirmBtn, e.getMessage(), "메뉴 등록 오류");
		} finally {
			closeOracleConnection(arm.confirmBtn, c, ps, rs);
		}
		
		closeWindow(amm.jdR);
	}
	
	/**
	 * Decide if given string is enable to convert integer.  
	 * 
	 * @param str String to be converted to integer
	 * @return True if string is possible to convert integer, otherwise false.
	 */
	private boolean isConvertDigit(String str) {
		boolean result = true;
		
		for (int i = 0; i < str.length(); i++) {
			if ((str.charAt(i) < '0') || (str.charAt(i) > '9')) {
				return false;
			}
		}
		
		return result;
	}
}