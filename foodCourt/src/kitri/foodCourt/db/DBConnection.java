package kitri.foodCourt.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import kitri.foodCourt.util.Constance;

public class DBConnection 
{
    public static Connection dbConn;
    
    public static Connection getConnection()
    {
        Connection conn = null;
        try {
    
        	String user = "fook"; 
            String pw = "fook";
            String url = "jdbc:oracle:thin:@" + Constance.DB_IP + ":1521:orcl";
            // jdbc라는 프로토콜을 쓴다는것 thin:@ 까지 프로토콜
            // 포트번호 바꿈.
            
            Class.forName("oracle.jdbc.driver.OracleDriver"); 
            // 프로토콜 맞춰줌
            conn = DriverManager.getConnection(url, user, pw);
            // 데이터베이스 연결
            // url = Uniform Resource Locator 의 약자인데 말 그대로 정형화 된 리소스 위치표시 라는 뜻
            // uri = 특정 자원에 대해 절대적 경로 뿐만 아니라 유니크한 이름을 통해 상대적 경로를 가지고 있는것
            
            System.out.println("Database에 연결되었습니다.\n");
            
        } catch (ClassNotFoundException cnfe) {
            System.out.println("DB 드라이버 로딩 실패 :"+cnfe.toString());
        } catch (SQLException sqle) {
            System.out.println("DB 접속실패!! : "+sqle.toString());
        } catch (Exception e) {
            System.out.println("Unkonwn error");
            e.printStackTrace();
        }
        return conn;     
    }
}
 
