/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;
import Process.Sanpham;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Admin
 */
public final class frmCapnhatSP extends javax.swing.JFrame {
    private final Sanpham sp = new Sanpham();
    private boolean cothem=true;
    private final DefaultTableModel tableModel = new DefaultTableModel();
    //Ham do du lieu vao combobox public
     final void ShowDataCombo() {
        try (ResultSet result = sp.ShowLoaiSP()) {
            while (result.next()) {
                cboLoaiSP.addItem(result.getString("Maloai"));
            }
        } catch (SQLException e) {
            Logger.getLogger(frmCapnhatSP.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(this, "Error loading product types", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    //Hien thi ten loai theo ma loai trong combobox
        public void ShowTenloai(String ma) throws SQLException{
        ResultSet result= sp.ShowLoaiSP(ma);
        if(result.next()){ // nếu còn đọc tiếp được một dòng dữ liệu
        txtTenloai.setText(result.getString("Tenloai"));
        }
        }
       public final void ShowData() {
        try (ResultSet result = sp.ShowSanpham()) {
            ClearData();
            while (result.next()) {
                String[] rows = new String[4];
                rows[0] = result.getString(1);
                rows[1] = result.getString(2);
                rows[2] = result.getString(3);
                rows[3] = result.getString(5);
                tableModel.addRow(rows);
            }
        } catch (SQLException e) {
            Logger.getLogger(frmCapnhatSP.class.getName()).log(Level.SEVERE, null, e);
        }
    }
  //Ham xoa du lieu trong tableModel
        public void ClearData() throws SQLException{
        //Lay chi so dong cuoi cung
        int n=tableModel.getRowCount()-1;
        for(int i=n;i>=0;i--)
        tableModel.removeRow(i);//Remove tung dong
        }
        //Ham xoa trang cac TextField
            private void setNull()
            {
            //Xoa trang cac JtextField
            txtMaSP.setText(null);
            txtMaSP.requestFocus();
            txtTenSP.setText(null);
            txtGiaban.setText(null);
            txtTenSP.setText(null);
            }
         //Ham khoa cac TextField
        private void setKhoa(boolean a)
        {
        //Khoa hoac mo khoa cho Cac JTextField
        txtMaSP.setEnabled(!a);
        txtTenSP.setEnabled(!a);
        txtGiaban.setEnabled(!a);
        cboLoaiSP.setEnabled(!a);
        txtTenloai. setEnabled(!a);
        }
        //Ham khoa cac Button
        private void setButton(boolean a)
        {
        //Vo hieu hoac co hieu luc cho cac JButton
        btThem.setEnabled(a);
        btXoa.setEnabled(a);
        btSua.setEnabled(a);
        btLuu.setEnabled(!a);
        btKLuu.setEnabled(!a);
        btThoat.setEnabled(a);
        }
    /**
     * Creates new form frmCapnhatSP
     */
    public frmCapnhatSP() {
        initComponents();
        String[] colsName = {"Mã SP", "Tên sản phẩm", "Giá bán", "Loại SP"};
        tableModel.setColumnIdentifiers(colsName);
        jTableLoaiSP.setModel(tableModel);
        ShowData();
        ShowDataCombo();
        setNull();
        setKhoa(true);
        setButton(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtMaSP = new javax.swing.JTextField();
        txtGiaban = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cboLoaiSP = new javax.swing.JComboBox<>();
        txtTenSP = new javax.swing.JTextField();
        txtTenloai = new javax.swing.JTextField();
        btThem = new javax.swing.JButton();
        btXoa = new javax.swing.JButton();
        btSua = new javax.swing.JButton();
        btLuu = new javax.swing.JButton();
        btKLuu = new javax.swing.JButton();
        btThoat = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLoaiSP = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("QUẢN LÝ DANH MỤC SẢN PHẨM");

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Mã SP:");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setText("Giá bán:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel4.setText("Tên sản phẩm:");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel5.setText("Loại SP:");

        cboLoaiSP.setBackground(new java.awt.Color(153, 204, 255));
        cboLoaiSP.setEditable(true);
        cboLoaiSP.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cboLoaiSPItemStateChanged(evt);
            }
        });

        btThem.setBackground(new java.awt.Color(153, 204, 255));
        btThem.setText("Thêm");
        btThem.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btThemMouseClicked(evt);
            }
        });

        btXoa.setBackground(new java.awt.Color(153, 204, 255));
        btXoa.setText("Xóa");
        btXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btXoaMouseClicked(evt);
            }
        });

        btSua.setBackground(new java.awt.Color(153, 204, 255));
        btSua.setText("Sửa");
        btSua.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btSuaMouseClicked(evt);
            }
        });

        btLuu.setBackground(new java.awt.Color(153, 204, 255));
        btLuu.setText("Lưu");
        btLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btLuuMouseClicked(evt);
            }
        });

        btKLuu.setBackground(new java.awt.Color(153, 204, 255));
        btKLuu.setText("K.Lưu");
        btKLuu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btKLuuMouseClicked(evt);
            }
        });

        btThoat.setBackground(new java.awt.Color(153, 204, 255));
        btThoat.setText("Thoát");
        btThoat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btThoatMouseClicked(evt);
            }
        });

        jTableLoaiSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableLoaiSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên sản phẩm", "Giá bán", "Loại SP"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableLoaiSP.setGridColor(new java.awt.Color(0, 0, 0));
        jTableLoaiSP.setShowGrid(true);
        jTableLoaiSP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableLoaiSPMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableLoaiSP);
        if (jTableLoaiSP.getColumnModel().getColumnCount() > 0) {
            jTableLoaiSP.getColumnModel().getColumn(0).setResizable(false);
            jTableLoaiSP.getColumnModel().getColumn(1).setResizable(false);
            jTableLoaiSP.getColumnModel().getColumn(2).setResizable(false);
            jTableLoaiSP.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(37, 37, 37)
                                        .addComponent(jLabel4))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtGiaban, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTenloai))
                                    .addComponent(txtTenSP)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(28, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btThem)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btXoa)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btSua)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btLuu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btKLuu)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btThoat)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtMaSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(txtTenSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtGiaban, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenloai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btThem)
                    .addComponent(btXoa)
                    .addComponent(btSua)
                    .addComponent(btLuu)
                    .addComponent(btKLuu)
                    .addComponent(btThoat))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTableLoaiSPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableLoaiSPMouseClicked
        // TODO add your handling code here:
        //Hien thi du lieu len cac JTextField khi Click chuot vao JTable
        try{
        //Lay chi so dong dang chon
        int row =jTableLoaiSP.getSelectedRow();
        String ma=(jTableLoaiSP.getModel().getValueAt(row,0)).toString();
        ResultSet rs= sp.ShowSPTheoma(ma);//Goi ham lay du lieu theo ma loai
        if(rs.next())//Neu co du lieu
        {
        txtMaSP.setText(rs.getString("MaSP"));
        txtTenSP.setText(rs.getString("TenSP"));
        txtGiaban.setText(rs.getString("Dongia"));
        cboLoaiSP.setSelectedItem(rs.getString("Maloai"));
        txtTenloai.setText(rs.getString("Tenloai"));
        }
        }
         catch (SQLException e) {
    }

    }//GEN-LAST:event_jTableLoaiSPMouseClicked

    private void btXoaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btXoaMouseClicked
        // TODO add your handling code here:
         String ma=txtMaSP.getText();
        try {
        if(ma.length()==0)
        JOptionPane.showMessageDialog(null,"Can chon 1 SP de xoa","Thong bao",1);
        else
        {
        if(JOptionPane.showConfirmDialog(null, "Ban muon xoa sp " + ma + "này hay khong?","Thong bao",2)==0)
        {
        sp.DeleteSanpham(ma);//goi ham xoa du lieu theo ma loai
        ClearData();//Xoa du lieu trong tableModel
        ShowData();//Do du lieu vao table Model
        setNull();//Xoa trang Textfield
        }
        }
        }
        catch (SQLException ex) {
        Logger.getLogger(frmCapnhatSP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btXoaMouseClicked

    private void btThemMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btThemMouseClicked
        // TODO add your handling code here:
        setNull();//Xoa trang TextField
        setKhoa(false);//Mo khoa TextField
        setButton(false);//Goi ham khoa cac Button
        cothem=true;//Gan cothem = true de ghi nhan trang thai them moi
    }//GEN-LAST:event_btThemMouseClicked

    private void btSuaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSuaMouseClicked
        // TODO add your handling code here:
        String ml=txtMaSP.getText();
        if(ml.length()==0) //Chua chon Ma loai 
        JOptionPane.showMessageDialog(null,"Vui long chon loi can sua", "Thong bao",1);
        else
        {
        setKhoa(false);//Mo khoa cac TextField
        setButton(false); //Khoa cac Button
        cothem=false; //Gan cothem=false de ghi nhan trang thai la sua
        }

    }//GEN-LAST:event_btSuaMouseClicked

    private void btLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btLuuMouseClicked
        // TODO add your handling code here:
        String ma = txtMaSP.getText();
        String ten = txtTenSP.getText();
        int gia;
        try {
            gia = Integer.parseInt(txtGiaban.getText());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Giá bán phải là số", "Thông báo", JOptionPane.WARNING_MESSAGE);
            return;
        }
        String loai = cboLoaiSP.getSelectedItem().toString();
        if (ma.length() == 0 || ten.length() == 0) {
            JOptionPane.showMessageDialog(null, "Vui lòng nhập Mã SP và Tên", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else if (ma.length() > 4 || ten.length() > 30) {
            JOptionPane.showMessageDialog(null, "Mã SP chỉ tối đa 4 ký tự, Tên SP tối đa 30 ký tự", "Thông báo", JOptionPane.WARNING_MESSAGE);
        } else {
            try {
                if (cothem) {
                    sp.InsertSanpham(ma, ten, gia, loai);
                } else {
                    sp.EditSanpham(ma, ten, gia, loai);
                }
                ClearData();
                ShowData();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Cập nhật thất bại", "Thông báo", JOptionPane.WARNING_MESSAGE);
            }
            setNull();
            setKhoa(true);
            setButton(true);
        }
        
    }//GEN-LAST:event_btLuuMouseClicked

    private void btKLuuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btKLuuMouseClicked
        // TODO add your handling code here:
        setNull();
        setKhoa(true);
        setButton(true);
    }//GEN-LAST:event_btKLuuMouseClicked

    private void btThoatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btThoatMouseClicked
        // TODO add your handling code here:
        dispose();
    }//GEN-LAST:event_btThoatMouseClicked

    private void cboLoaiSPItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cboLoaiSPItemStateChanged
        // TODO add your handling code here:
         try {
        String ml=cboLoaiSP.getSelectedItem().toString();
        ShowTenloai(ml);
        } catch (SQLException ex) {
        Logger.getLogger(frmCapnhatSP.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_cboLoaiSPItemStateChanged

    /**
     * @param args the command line arguments
     */
   
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(frmCapnhatSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmCapnhatSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmCapnhatSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmCapnhatSP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new frmCapnhatSP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btKLuu;
    private javax.swing.JButton btLuu;
    private javax.swing.JButton btSua;
    private javax.swing.JButton btThem;
    private javax.swing.JButton btThoat;
    private javax.swing.JButton btXoa;
    private javax.swing.JComboBox<String> cboLoaiSP;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLoaiSP;
    private javax.swing.JTextField txtGiaban;
    private javax.swing.JTextField txtMaSP;
    private javax.swing.JTextField txtTenSP;
    private javax.swing.JTextField txtTenloai;
    // End of variables declaration//GEN-END:variables
}
