/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package Interface;
import Process.LoaiSP;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class frmSPTheoloai extends javax.swing.JFrame {
    LoaiSP sp = new LoaiSP();
    DefaultTableModel tableModel = new DefaultTableModel();

    public frmSPTheoloai() {
        initComponents();
        ShowDataCombo(); // Sửa lỗi tên phương thức
         String[] colsName = {"Mã SP", "Tên SP", "Giá bán", "Loại"};
        // Đặt tiêu đề cột cho tableModel
        tableModel.setColumnIdentifiers(colsName);
        // Kết nối jTable với tableModel
        jTableLoaiSP.setModel(tableModel);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitApplication();
            }
        });
    }
    private void exitApplication() {
        int confirm = JOptionPane.showConfirmDialog(this, "Bạn có chắc chắn muốn thoát?", "Xác nhận thoát", JOptionPane.YES_NO_OPTION);
        if (confirm == JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }


    // Phương thức hiển thị dữ liệu lên ComboBox
    public final void ShowDataCombo() {
        ResultSet result = null;
        try {
            result = sp.ShowLoaiSP();
            while (result.next()) {
                cboLoaiSP.addItem(result.getString("Maloai"));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi hiển thị ComboBox: " + e.getMessage());
        } finally {
            // Đóng ResultSet sau khi sử dụng
            try {
                if (result != null) result.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Lỗi đóng ResultSet: " + e.getMessage());
            }
        }
    }
      public void ClearData() {
        // Lấy chỉ số dòng cuối cùng
        int n = tableModel.getRowCount() - 1;
        for (int i = n; i >= 0; i--)
            tableModel.removeRow(i); // Xóa từng dòng
    }
       public final void ShowData(String ml) {
        ResultSet result = null;
        try {
            ClearData();
            result = sp.ShowSanpham(ml); // Gọi phương thức để lấy sản phẩm theo loại
            while (result.next()) {
                String[] rows = new String[4];
                rows[0] = result.getString(1); // Mã SP
                rows[1] = result.getString(2); // Tên SP
                rows[2] = result.getString(3); // Giá bán
                rows[3] = result.getString(4); // Loại
                tableModel.addRow(rows);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Lỗi hiển thị sản phẩm: " + e.getMessage());
        } finally {
            // Đóng ResultSet sau khi sử dụng
            try {
                if (result != null) result.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Lỗi đóng ResultSet: " + e.getMessage());
            }
        }
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        cboLoaiSP = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableLoaiSP = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("SẢN PHẨM THEO LOẠI");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Chọn loại sản phẩm:");

        cboLoaiSP.setBackground(new java.awt.Color(204, 204, 204));
        cboLoaiSP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cboLoaiSPActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(cboLoaiSP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        jTableLoaiSP.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableLoaiSP.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã SP", "Tên Sản phẩm", "Đơn giá", "Loại SP"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class
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
        jScrollPane1.setViewportView(jTableLoaiSP);
        if (jTableLoaiSP.getColumnModel().getColumnCount() > 0) {
            jTableLoaiSP.getColumnModel().getColumn(0).setResizable(false);
            jTableLoaiSP.getColumnModel().getColumn(1).setResizable(false);
            jTableLoaiSP.getColumnModel().getColumn(3).setResizable(false);
        }

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton1.setText("Thoát");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(94, 94, 94)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(21, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cboLoaiSPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cboLoaiSPActionPerformed
        // TODO add your handling code here:
          String ml = cboLoaiSP.getSelectedItem().toString(); // Lấy mã loại được chọn
        ShowData(ml);
    }//GEN-LAST:event_cboLoaiSPActionPerformed
 private void cboLoaiSPItemStateChanged(java.awt.event.ItemEvent evt) {
        String ml = cboLoaiSP.getSelectedItem().toString();
        ShowData(ml); // Gọi phương thức ShowData với Maloai đã chọn
    }
 
    /**
     * @param args the command line arguments
     */

        public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new frmSPTheoloai().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> cboLoaiSP;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableLoaiSP;
    // End of variables declaration//GEN-END:variables
}