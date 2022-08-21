package com.xuegao.test.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirstJdbc {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverTest.doGetConnection(DriverTest.driverProperties);
        PreparedStatement ps1 = connection.prepareStatement("select * from users where uid in (?,?)");
        ps1.setInt(1, 1);
        ps1.setInt(2, 2);
        ResultSet resultSet = ps1.executeQuery();
        System.out.println(resultSet);

        List<Map<String, Object>> rowList = new ArrayList<>(100);
        ResultSetMetaData md = resultSet.getMetaData();
        int columnCount = md.getColumnCount();
        while (resultSet.next()) {
            Map<String, Object> rowData = new HashMap<>();
            for (int i = 1; i <= columnCount; i++) {
                rowData.put(md.getColumnName(i), resultSet.getObject(i));
            }
            rowList.add(rowData);
        }
        // int uid = resultSet.getInt("uid");
        // String name = resultSet.getString("name");
        System.out.println(rowList);
    }
}
