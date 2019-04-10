package kitri.foodCourt.management.menu;

import java.awt.Component;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import kitri.foodCourt.dto.FoodDto;


public class AdminMenuService {

	AdminMenuControl amc;
	AdminMenuManagement amm;
	AdminRegisterMenu arm;
	AdminModifyMenu am;
	
	String[] option = {"예", "아니오"};
	String[] column = {"메뉴ID", "메뉴이름", "카테고리", "가격", "포인트", "담당매니저", "등록일", "주문가능여부"};
	
	DefaultTableModel dtm;
	
	JFileChooser chooser = new JFileChooser();
    FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF & PNG Images", "jpg", "gif", "png");
	
    
	public AdminMenuService(AdminMenuControl amc) {
		this.amc = amc;
		amm = this.amc.amm;
		arm = amm.arm;
		am = amm.am;
		
		dtm = amm.dtm;
		
		// Set Table column
		for (int i = 0; i < column.length; i++) {
			dtm.addColumn(column[i]);
		}
		
		chooser.setFileFilter(filter);
	}
	
	
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
		amm.jdR.setModal(true);
		amm.jdR.setVisible(true);
	}
	
	public void showModifyWindow() {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		FoodDto foodDto = null;
		ImageIcon image = null;
		
		String imgUrl = null;
		int rowSelect = amm.commonTable.getSelectedRow();
		
		if (rowSelect == -1) {
			warningMessage(amm.modifyBtn, "수정할 메뉴가 없습니다.", "메뉴 수정 오류");
			closeWindow(amm.jdM);
			return;
		}
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.32:1521:orcl", "kitri", "kitri");
			
			ps = c.prepareStatement("select * "
								  + "from fook_food "
								  + "where food_id = (?)");
			
			ps.setString(1, (String)dtm.getValueAt(rowSelect, 0));
			rs = ps.executeQuery();

			while (rs.next()) {
				foodDto = new FoodDto(rs.getString("food_id"), rs.getString("food_name"), rs.getInt("category_id"), null, rs.getInt("price"), rs.getString("image_address"));

				foodDto.setPoint(rs.getInt("food_point"));
				foodDto.setDescription(rs.getString("food_description"));
				foodDto.setManagerId(rs.getString("manager_id"));
				foodDto.setCreateDate(rs.getDate("create_date"));
				foodDto.setEnable(rs.getString("food_enable").charAt(0));
			}

			am.menuCodeTextField.setText(foodDto.getFoodId());
			am.menuNameTextField.setText(foodDto.getFoodName());
			am.priceTextField.setText(String.valueOf(foodDto.getPrice()));
			am.pointTextField.setText(String.valueOf(foodDto.getPoint()));
			am.descriptionTextArea.setText(foodDto.getDescription());
			am.categoryComboBox.setSelectedIndex(foodDto.getCategoryId() - 1);
			am.cg.setSelectedCheckbox((foodDto.getEnable() == 'y') ? am.checkBox1 : am.checkBox2);
			
			imgUrl = foodDto.getImageAddress();
			image = new ImageIcon(AdminMenuService.class.getResource(imgUrl));
			
			am.pictureLabel.setIcon(image);
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
		
		amm.jdM.getContentPane().add(amm.am);
		amm.jdM.setSize(750, 650);
		amm.jdM.setModal(true);
		amm.jdM.setResizable(false);
		amm.jdM.setVisible(true);
	}
	
	public void showDeleteWindow() {
		Connection c = null;
		PreparedStatement ps = null;
		int resultQuery = 0;
		
		int result = JOptionPane.showOptionDialog(amm.deleteBtn, "정말 삭제하시겠습니까?\n(삭제하면 다시 되돌릴 수 없습니다.)", "삭제 확인", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
		int currentSelectedrow = amm.commonTable.getSelectedRow();
		
		if (result == JOptionPane.OK_OPTION) {
			if (currentSelectedrow >= 0) {
				Object ob = amm.commonTable.getModel().getValueAt(currentSelectedrow, 0);
					
				try {
					Class.forName("oracle.jdbc.driver.OracleDriver");
					c = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.32:1521:orcl", "kitri", "kitri");
					
					ps = c.prepareStatement("delete from fook_food "
										  + "where food_id = (?)");
					
					ps.setString(1, (String)ob);
					
					resultQuery = ps.executeUpdate();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (SQLException e) {
					e.printStackTrace();
				} finally {
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
				
				dtm.removeRow(currentSelectedrow);
			}
		} else {
			return;
		}
		
		if (resultQuery == 0) {
			warningMessage(amm.deleteBtn, "삭제할 메뉴가 없습니다.", "메뉴 삭제 오류");
		}
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
			
			ps = c.prepareStatement("select food_id, food_name, f.category_id \"category_id\", category_name, price, food_point, food_description, image_address, manager_id, create_date, food_enable "
								  + "from fook_food f, fook_category c "
								  + "where f.category_id = c.category_id");
			
			rs = ps.executeQuery();

			while (rs.next()) {
				foodDto = new FoodDto(rs.getString("food_id"), rs.getString("food_name"), rs.getInt("category_id"), rs.getString("category_name"), rs.getInt("price"), rs.getString("image_address"));

				foodDto.setPoint(rs.getInt("food_point"));
				foodDto.setDescription(rs.getString("food_description"));
				foodDto.setManagerId(rs.getString("manager_id"));
				foodDto.setCreateDate(rs.getDate("create_date"));
				foodDto.setEnable(rs.getString("food_enable").charAt(0));
				
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
		int currentSelectedrow = amm.commonTable.getSelectedRow();
		if (currentSelectedrow >= 0) {
			Object ob = amm.commonTable.getModel().getValueAt(currentSelectedrow, 0);
			
			Connection c = null;
			PreparedStatement ps = null;
			ResultSet rs = null;
			
			String imgUrl = null;
			String description = null;
			
			try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
				c = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.32:1521:orcl", "kitri", "kitri");
				
				ps = c.prepareStatement("select image_address, food_description "
									  + "from fook_food "
									  + "where food_id = (?)");
				
				ps.setString(1, (String)ob);
				
				rs = ps.executeQuery();
	
				if (rs.next()) {
					imgUrl = rs.getString("image_address");
					description = rs.getString("food_description");
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

	public void closeWindow(JDialog jd) {
		jd.dispose();
	}

	public void searchFood() {
		String str = amm.searchTextField.getText().trim();
		
		int rowCount = dtm.getRowCount();
		for(int i = 0; i < rowCount; i++) {
			if (str.equals((String)dtm.getValueAt(i, 1))) {
				amm.commonTable.setRowSelectionInterval(i, i);
				return;
			}
		}
		
		warningMessage(amm.searchTextField, "찾는 메뉴가 없습니다.", "메뉴 검색 오류");
	}

	public void findImage(Object ob) {
		chooser.setCurrentDirectory(new File("." + File.separator + "src" + File.separator + "kitri" + File.separator + "foodCourt" + File.separator + "management" + File.separator + "menu" + File.separator + "image"));
		int choice = chooser.showOpenDialog((Component)ob);
		String imgUrl = null;
		ImageIcon image = null;
		
		if (choice == JFileChooser.APPROVE_OPTION) {
			String fullpath = chooser.getSelectedFile().toString();
			imgUrl = fullpath.substring(fullpath.indexOf("kitri") - 1, fullpath.length()).replace('\\', '/');
			image = new ImageIcon(AdminMenuService.class.getResource(imgUrl));
			
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

	private void warningMessage(Component component, Object msg, String title) {
		JOptionPane.showMessageDialog(component, msg, title, JOptionPane.WARNING_MESSAGE);
	}
	
	public void modifyMenu() {
		int currentSelectedrow = amm.commonTable.getSelectedRow();
		
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
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
		
		String priceStr = am.priceTextField.getText();
		if (priceStr.isEmpty()) {
			warningMessage(am.confirmBtn, "메뉴 가격을 입력하세요.", "메뉴 수정 오류");
			return;
		}
		int price = Integer.parseInt(priceStr);
		
		int point = am.pointTextField.getText().isEmpty() ? (price / 100) : Integer.parseInt(am.pointTextField.getText());
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
		String imgUrl = fullpath.substring(fullpath.indexOf("kitri") - 1, fullpath.length());
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.32:1521:orcl", "kitri", "kitri");
			
			ps = c.prepareStatement("update fook_food "
								  + "set food_name = (?), category_id = (?), price = (?), food_point = (?), food_description = (?), image_address = (?), food_enable = (?) "
								  + "where food_id = (?)");
			
			ps.setString(1, food_name);
			ps.setInt(2, category);
			ps.setInt(3, price);
			ps.setInt(4, point);
			ps.setString(5, food_description);
			ps.setString(6, imgUrl);
			ps.setString(7, food_enable);
			ps.setString(8, food_id);
			
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
				rowData[5] = dtm.getValueAt(currentSelectedrow, 5);	// TODO jwlee use to real manager_id
				rowData[6] = dtm.getValueAt(currentSelectedrow, 6);
				rowData[7] = food_enable;

				int columnNum = dtm.getColumnCount();
				for (int i = 0; i < columnNum; i++) {
					dtm.setValueAt(rowData[i], currentSelectedrow, i);
				}
			}
			
			amm.commonTable.setRowSelectionInterval(currentSelectedrow, currentSelectedrow);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		
		closeWindow(amm.jdM);
	}

	public void registerMenu() {
		Connection c = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int result = 0;
		
		Object[] rowData = new Object[8];

		String food_name = arm.menuNameTextField.getText();
		if (food_name.isEmpty()) {
			warningMessage(arm.confirmBtn, "메뉴 이름을 입력하세요.", "메뉴 등록 오류");
			return;
		}
		
		String food_enable = "y";
		String food_description = arm.descriptionTextArea.getText();
		Icon food_image = arm.pictureLabel.getIcon();
		if (food_image == null) {
			warningMessage(arm.confirmBtn, "메뉴 이미지를 선택하세요.", "메뉴 등록 오류");
			return;
		}		
		String fullpath = food_image.toString();
		String imgUrl = fullpath.substring(fullpath.indexOf("kitri") - 1, fullpath.length());
		
		String manager_id = "Admin123";	// TODO jwlee use to real manager_id
		
		String priceStr = arm.priceTextField.getText();
		if (priceStr.isEmpty()) {
			warningMessage(arm.confirmBtn, "메뉴 가격을 입력하세요.", "메뉴 동록 오류");
			return;
		}
		int price = Integer.parseInt(priceStr);
		
		int point = arm.pointTextField.getText().isEmpty() ? (price / 100) : Integer.parseInt(arm.pointTextField.getText());
		int category = arm.categoryComboBox.getSelectedIndex() + 1;
		if (category < 1) {
			warningMessage(arm.confirmBtn, "카테고리를 선택하세요.", "메뉴 등록 오류");
			return;
		}
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.32:1521:orcl", "kitri", "kitri");
			
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
				rowData[7] = food_enable;
			}
			
			dtm.addRow(rowData);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		
		closeWindow(amm.jdR);
	}
}