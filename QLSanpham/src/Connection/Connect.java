/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Huyen
 */

public class Connect {
    private Connection con = null;

    // Tự động kết nối khi tạo đối tượng Connect
    public Connect() {
        connectSQL();
    }

    // Phương thức thiết lập kết nối SQL Server
    public void connectSQL() {
        try {
            // Thông tin kết nối
            String sqlURL = "jdbc:sqlserver://localhost:1433;databaseName=QLSP;encrypt=false;";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            con = DriverManager.getConnection(sqlURL, "sa", "1235");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error(Connect): " + ex.getMessage());
        }
    }

    // Phương thức lấy đối tượng Connection hiện tại
    public Connection getConnection() {
        if (con == null) {
            connectSQL(); // Thiết lập lại kết nối nếu chưa có
        }
        return con;
    }

    // Phương thức để thực hiện truy vấn SELECT và trả về ResultSet
    public ResultSet LoadData(String sql) {
        ResultSet rs = null;
        try {
            Statement stmt = getConnection().createStatement();
            rs = stmt.executeQuery(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error(LoadData): " + e.getMessage());
        }
        return rs;
    }

    // Phương thức để thực hiện các truy vấn INSERT, UPDATE, DELETE
    public void UpdateData(String sql) {
        try (Statement stmt = getConnection().createStatement()) {
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error(UpdateData): " + e.getMessage());
        }
    }

    // Phương thức đóng kết nối
    public void closeSQL() {
        try {
            if (con != null && !con.isClosed()) {
                con.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error(Close): " + ex.getMessage());
        }
    }
}
