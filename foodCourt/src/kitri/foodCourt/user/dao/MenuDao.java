package kitri.foodCourt.user.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import kitri.foodCourt.db.ConnectionMaker;
import kitri.foodCourt.db.DbFactory;
import kitri.foodCourt.dto.FoodDto;

public class MenuDao {

	private ConnectionMaker connectionMaker;
	
	
	public MenuDao() {
		this.connectionMaker = DbFactory.connectionMaker("oracle");
	}

	//카테고리 메뉴 클릭시 음식 메뉴 얻어오기
	public List<FoodDto> getMenubyCategory(int categori_id) {
		List<FoodDto> list = new ArrayList<FoodDto>();
		Connection c = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null;
		try {
			c = connectionMaker.makeConnection();
			ps = c.prepareStatement("select food_name, image_address, food_id from fook_food where category_id = ? and lower(food_enable) = lower('y') order by food_name");
			ps.setInt(1, categori_id);
			rs = ps.executeQuery();
			//음식 이름, 이미지주소, 아이디 (메뉴 리스트에 갖고있을 정보만)
			while (rs.next()) {
				FoodDto food = new FoodDto();
				food.setFoodName(rs.getString("food_name"));
				food.setImageAddress(rs.getString("image_address"));
				food.setFoodId(rs.getString("food_id"));
				list.add(food);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
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

		return list;
	}
	// 검색으로 메뉴 얻어오기
	public List<FoodDto> getMenubyName(String foodName) {
		List<FoodDto> list = new ArrayList<FoodDto>();
		Connection c = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null;
		try {
			c = connectionMaker.makeConnection();
			String str = "'%"+foodName+"%'";
			ps = c.prepareStatement("select food_name, image_address, food_id from fook_food where food_name like " + str + " and lower(food_enable) = lower('y') order by food_name");
//			ps.setString(1, foodName); //의문의 에러 발생 해결!!!
			rs = ps.executeQuery();
			//음식 이름, 이미지주소, 아이디 (메뉴 리스트에 갖고있을 정보만)
			while (rs.next()) {
				FoodDto food = new FoodDto();
				food.setFoodName(rs.getString("food_name"));
				food.setImageAddress(rs.getString("image_address"));
				food.setFoodId(rs.getString("food_id"));
				list.add(food);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
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

		return list;
	}
	
	public FoodDto getMenubyId(String food_id) {
		FoodDto foodDto = null;
		Connection c = null; 
		PreparedStatement ps = null; 
		ResultSet rs = null;
		try {
			c = connectionMaker.makeConnection();
			ps = c.prepareStatement("select food_name, image_address, food_id, food_description, price, food_point, category_name from fook_food f, fook_category c where f.category_id = c.category_id and food_id = ? and lower(food_enable) = lower('y') order by food_name");
			ps.setString(1, food_id);
			rs = ps.executeQuery();
			if(rs.next()) {
				foodDto = new FoodDto();
				foodDto.setFoodName(rs.getString("food_name"));
				foodDto.setImageAddress(rs.getString("image_address"));
				foodDto.setFoodId(rs.getString("food_id"));
				foodDto.setPrice(rs.getInt("price"));
				foodDto.setCategoryName(rs.getString("category_name"));
				foodDto.setDescription(rs.getString("food_description"));
				foodDto.setPoint(rs.getInt("food_point"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(rs != null) {
				try {
					rs.close();
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

		return foodDto;
	}
}