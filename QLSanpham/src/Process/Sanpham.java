package Process;

import Connection.Connect;
import java.sql.*;

public class Sanpham {
    private final Connect cn = new Connect();

    // Truy vấn tất cả dữ liệu trong bảng LoaiSP
    public ResultSet ShowLoaiSP() throws SQLException {
        cn.connectSQL();
        String sql = "SELECT * FROM LoaiSP";
        return cn.LoadData(sql);
    }

    // Truy vấn các dòng dữ liệu trong bảng LoaiSP theo Maloai
    public ResultSet ShowLoaiSP(String ml) throws SQLException {
        String sql = "SELECT * FROM LoaiSP WHERE Maloai = ?";
        Connection conn = cn.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, ml);
        return pst.executeQuery();
    }

    // Truy vấn dữ liệu trong bảng Sanpham theo Maloai
    public ResultSet ShowSPTheoloai(String ml) throws SQLException {
        String sql = "SELECT MaSP, TenSP, Dongia, L.Maloai, Tenloai FROM Sanpham S, LoaiSP L WHERE L.Maloai = S.Maloai AND L.Maloai = ?";
        Connection conn = cn.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, ml);
        return pst.executeQuery();
    }

    // Truy vấn tất cả dữ liệu trong bảng Sanpham
    public ResultSet ShowSanpham() throws SQLException {
        cn.connectSQL();
        String sql = "SELECT MaSP, TenSP, Dongia, L.Maloai, Tenloai FROM Sanpham S, LoaiSP L WHERE L.Maloai = S.Maloai";
        return cn.LoadData(sql);
    }

    // Truy vấn dữ liệu trong bảng Sanpham theo MaSP
    public ResultSet ShowSPTheoma(String ma) throws SQLException {
        String sql = "SELECT MaSP, TenSP, Dongia, L.Maloai, Tenloai FROM Sanpham S, LoaiSP L WHERE L.Maloai = S.Maloai AND MaSP = ?";
        Connection conn = cn.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, ma);
        return pst.executeQuery();
    }

    // Truy vấn dữ liệu trong bảng Sanpham theo giá
    public ResultSet ShowSPTheogia(int giatu, int giaden) throws SQLException {
        String sql = "SELECT MaSP, TenSP, Dongia, L.Maloai, Tenloai FROM Sanpham S, LoaiSP L WHERE L.Maloai = S.Maloai AND Dongia BETWEEN ? AND ?";
        Connection conn = cn.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setInt(1, giatu);
        pst.setInt(2, giaden);
        return pst.executeQuery();
    }

    // Truy vấn dữ liệu trong bảng Sanpham theo tên sản phẩm
    public ResultSet ShowSPTheoten(String ten) throws SQLException {
        String sql = "SELECT MaSP, TenSP, Dongia, L.Maloai, Tenloai FROM Sanpham S, LoaiSP L WHERE L.Maloai = S.Maloai AND TenSP LIKE ?";
        Connection conn = cn.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, "%" + ten + "%");
        return pst.executeQuery();
    }

    // Thêm một dòng dữ liệu vào bảng Sanpham
    public void InsertSanpham(String ma, String ten, int dg, String ml) throws SQLException {
        String sql = "INSERT INTO Sanpham (MaSP, TenSP, Dongia, Maloai) VALUES (?, ?, ?, ?)";
        Connection conn = cn.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, ma);
        pst.setString(2, ten);
        pst.setInt(3, dg);
        pst.setString(4, ml);
        pst.executeUpdate();
    }

    // Cập nhật một dòng dữ liệu vào bảng Sanpham
    public void EditSanpham(String ma, String ten, int dg, String ml) throws SQLException {
        String sql = "UPDATE Sanpham SET TenSP = ?, Dongia = ?, Maloai = ? WHERE MaSP = ?";
        Connection conn = cn.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, ten);
        pst.setInt(2, dg);
        pst.setString(3, ml);
        pst.setString(4, ma);
        pst.executeUpdate();
    }

    // Xóa một dòng dữ liệu vào bảng Sanpham
    public void DeleteSanpham(String ma) throws SQLException {
        String sql = "DELETE FROM Sanpham WHERE MaSP = ?";
        Connection conn = cn.getConnection();
        PreparedStatement pst = conn.prepareStatement(sql);
        pst.setString(1, ma);
        pst.executeUpdate();
    }
}
