package mysql;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Mysql {
    Connection mySqlUrl = new Connection();
    public List<String> 구검색(String 사용자입력구) {

        try {
            String query = "select 3단계 from weather where 2단계 = '" + 사용자입력구 + "'";

            PreparedStatement ps = mySqlUrl.DB검색().prepareStatement(query);

            ResultSet rs = ps.executeQuery();
            List<String> 동리스트 = new ArrayList<>();

            while (rs.next()) {
                동리스트.add(rs.getString(1));
            }

            return 동리스트;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Integer> 동검색(String 사용자입력동) {

        try {
            String query;
            query = "SELECT 격자_X, 격자_Y FROM weather WHERE 3단계 = '" + 사용자입력동 + "'";
            PreparedStatement ps = mySqlUrl.DB검색().prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            List<Integer> 위경도 = new ArrayList<>();
            while (rs.next()) {
                위경도.add(rs.getInt(1));
                위경도.add(rs.getInt(2));
            }

            return 위경도;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
