/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Process;

import Connection.Connect;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Admin
 */
public class LoaiSP {
    private final Connect cn = new Connect();

    // Truy vấn mã loại trong bảng LoaiSP
    public ResultSet ShowLoaiSP() {
        String sql = "SELECT Maloai FROM LoaiSP";
        ResultSet rs = null;

        try {
            Connection conn = cn.getConnection();
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                rs = pst.executeQuery();
            } else {
                JOptionPane.showMessageDialog(null, "Không thể kết nối đến CSDL");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn: " + e.getMessage());
        }

        return rs; // Trả về ResultSet chứa mã loại
    }

    // Truy vấn sản phẩm theo mã loại
    public ResultSet ShowSanpham(String ml) {
        String sql = "SELECT MaSP, TenSP, Dongia, Maloai FROM SanPham WHERE Maloai = ?";
        ResultSet rs = null;

        try {
            Connection conn = cn.getConnection();
            if (conn != null) {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, ml); // Thiết lập giá trị cho tham số trong câu lệnh SQL
                rs = pst.executeQuery();
            } else {
                JOptionPane.showMessageDialog(null, "Không thể kết nối đến CSDL");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi truy vấn sản phẩm: " + e.getMessage());
        }

        return rs; // Trả về ResultSet chứa danh sách sản phẩm theo loại
    }
}