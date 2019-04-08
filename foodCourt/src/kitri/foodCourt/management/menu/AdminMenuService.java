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
			JOptionPane.showMessageDialog(amm.modifyBtn, "수정할 메뉴가 없습니다.");
			closeWindow(amm.jdM);
			return;
		}
		
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c = DriverManager.getConnection("jdbc:oracle:thin:@192.168.14.32:1521:orcl", "kitri", "kitri");
			
			ps = c.prepareStatement("select * from food where food_id = (?)");
			ps.setString(1, (String)dtm.getValueAt(rowSelect, 0));
			rs = ps.executeQuery();

			while (rs.next()) {
				foodDto = new FoodDto(rs.getString("food_id"), rs.getString("food_name"), rs.getInt("category_id"), null, rs.getInt("price"), rs.getString("image_address"));

				foodDto.setPoint(rs.getInt("point"));
				foodDto.setDescription(rs.getString("description"));
				foodDto.setManagerId(rs.getString("manager_id"));
				foodDto.setCreateDate(rs.getDate("create_date"));
				foodDto.setEnable(rs.getString("enable").charAt(0));
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
					
					ps = c.prepareStatement("delete from food where food_id = (?)");
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
			JOptionPane.showMessageDialog(amm.deleteBtn, "삭제할 메뉴가 없습니다.");
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

	public void closeWindow(JDialog jd) {
		jd.dispose();
	}

	public void searchFood() {
		String str = amm.searchTextField.getText().trim();
		
		int rowCount = dtm.getRowCount();
		for(int i = 0; i < rowCount; i++) {
			if (str.equals((String)dtm.getValueAt(i, 1))) {
				amm.commonTable.setRowSelectionInterval(i, i);
				break;
			}
		}
		
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
}
