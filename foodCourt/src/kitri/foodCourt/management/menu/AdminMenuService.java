package kitri.foodCourt.management.menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import kitri.foodCourt.dto.FoodDto;


public class AdminMenuService {

	AdminMenuControl amc;
	AdminMenuManagement amm;
	
	AdminRegisterMenu arp;
	AdminModifyMenu amp;
	
	JFrame jfR = new JFrame("메뉴등록");
	JFrame jfM = new JFrame("메뉴수정");
	
	String[] option = {"예", "아니오"};
	String[] column = {"메뉴ID", "메뉴이름", "카테고리", "가격", "포인트", "담당매니저", "등록일", "주문가능여부"};
	
	DefaultTableModel dtm;
	
	
	public AdminMenuService(AdminMenuControl amc) {
		this.amc = amc;
		amm = this.amc.amm;
		dtm = amm.dtm;
		
		arp = new AdminRegisterMenu();
		amp = new AdminModifyMenu();
		
		// Set Table column
		for (int i = 0; i < column.length; i++) {
			dtm.addColumn(column[i]);
		}
	}
	
	
	public void showRegisterWindow() {
		jfM.setVisible(false);
		
		jfR.getContentPane().add(arp);
		jfR.setSize(750, 650);
		jfR.setVisible(true);
	}
	
	public void showModifyWindow() {
		jfR.setVisible(false);
		
		jfM.getContentPane().add(amp);
		jfM.setSize(750, 650);
		jfM.setVisible(true);
	}
	
	public void showDeleteWindow() {
		JOptionPane.showOptionDialog(amm.deleteBtn, "정말 삭제하시겠습니까?\n(삭제하면 다시 되돌릴 수 없습니다.)", "삭제 확인", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
	}
	
	public void showMenu() {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		List<FoodDto> list = new ArrayList<FoodDto>();
		ListIterator<FoodDto> iterator;
		FoodDto foodDto = null;
		
		Object[] rowData = new Object[8];
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.32:1521:orcl", "kitri", "kitri");
			
			ps = c.prepareStatement("select food_id, food_name, f.category_id \"category_id\", category_name, price, point, description, image_address, manager_id, create_date, enable from food f, category c where f.category_id = c.category_id");
			rs = ps.executeQuery();

			while (rs.next()) {
				foodDto = new FoodDto(rs.getString("food_id"), rs.getString("food_name"), rs.getInt("category_id"), rs.getString("category_name"), rs.getInt("price"), rs.getString("image_address"));

				foodDto.setPoint(rs.getInt("point"));
				foodDto.setDescription(rs.getString("description"));
				foodDto.setManagerId(rs.getString("manager_id"));
				foodDto.setCreateDate(rs.getDate("create_date"));
				foodDto.setEnable(rs.getString("enable").charAt(0));
				
				list.add(foodDto);
			}

			iterator = list.listIterator();
			
			while(iterator.hasNext()) {
				foodDto = iterator.next();
				
				rowData[0] = foodDto.getFoodId();
				rowData[1] = foodDto.getFoodName();
				rowData[2] = foodDto.getCategoryName();
				rowData[3] = foodDto.getPrice();
				rowData[4] = foodDto.getPoint();
				rowData[5] = foodDto.getManagerId();
				rowData[6] = foodDto.getCreateDate().toString();
				rowData[7] = foodDto.getEnable();
				
				dtm.addRow(rowData);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			if(c != null) {
				try {
					c.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}


	public void showImageDescription() {
		TableModel tm = amm.commonTable.getModel();
		
		int currentSelectedrow = amm.commonTable.getSelectedRow();
		if (currentSelectedrow >= 0) {
			Object ob = tm.getValueAt(currentSelectedrow, 0);
			
			Connection c = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String imgUrl = null;
			String description = null;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				c = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.32:1521:orcl", "kitri", "kitri");
				
				ps = c.prepareStatement("select image_address, description from food where food_id = (?)");
				ps.setString(1, (String)ob);
				
				rs = ps.executeQuery();
	
				if (rs.next()) {
					imgUrl = rs.getString("image_address");
					description = rs.getString("description");
				}
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				if(rs != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				if(ps != null) {
					try {
						ps.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				if(c != null) {
					try {
						c.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
			
			ImageIcon image = new ImageIcon(AdminMenuService.class.getResource(imgUrl));
			amm.pictureLabel.setIcon(image);
			
			amm.descriptionTextArea.setText(description);
		}
	}
}
