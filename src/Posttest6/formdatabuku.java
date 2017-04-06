/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Posttest6;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Acer E5-475G
 */
public class formdatabuku extends javax.swing.JFrame {

    private DefaultTableModel model;
    private final Connection con = koneksi.getConnection();
    private Statement stt;
    private ResultSet rss;
    
    private int baris;
    private boolean kebenaran;
    /*
     */
    public formdatabuku() {
        initComponents();
    }
    
    private void InitTable(){
        model = new DefaultTableModel();
        model.addColumn("ID");
        model.addColumn("JUDUL");
        model.addColumn("PENULIS");
        model.addColumn("HARGA");
        
        tabel.setModel(model);
    }
    
    private void TampilData(){
        try {
            String sql = "SELECT * FROM buku";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
                Object[] o = new Object[4];
                o[0] = rss.getInt("id");
                o[1] = rss.getString("judul");
                o[2] = rss.getString("penulis");
                o[3] = rss.getString("harga");
                model.addRow(o);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     
    private void TambahData(String judul, String penulis, String harga){
        try {
            String sql = 
                    "INSERT INTO buku VALUES (NULL,'"+judul+"','"+penulis+"',"+harga+")";
            stt = con.createStatement();
            stt.executeUpdate(sql);
            model.addRow(new Object[]{judul,penulis,harga});
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    private void HapusData(String id,int baris){
        try {
            
            String sqldelete = 
                    "DELETE FROM buku WHERE id='"+id+"'";
            stt = con.createStatement();
            stt.executeUpdate(sqldelete);
            model.removeRow(baris);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
     private void UbahData(String judul,String penulis, String harga, String id){
        try {
            
            String sql = "UPDATE buku SET "
                         + "judul='"+judul+"',"
                         + "penulis='"+penulis+"',"
                         + "harga='"+harga+"'"
                         + "WHERE id='"+id+"'";
            stt = con.createStatement();
            stt.executeUpdate(sql);
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
     
    private void validasi (String judul, String penulis, String harga){
        try {
            String sql = "SELECT * FROM judul";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
                Object[] o = new Object[2];
                o[0] = rss.getString("judul").toLowerCase();
                o[1] = rss.getString("penulis").toLowerCase();
                
                if( o[0].equals(judul.toLowerCase()) && o[1].equals(penulis.toLowerCase())){
                    JOptionPane.showMessageDialog(null,"Data telah ada");
                    kebenaran=false;
                    break;
                }
            }
            if(kebenaran==true){
                TambahData(judul, penulis, harga);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
  
    }
    private void CariId(){
        try{
            String sql = "SELECT*from buku where id='"+cari.getText()+"'";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
              Object[] o = new Object[4];   
              o[0] = rss.getInt("id");
              o[1] = rss.getString("judul");
              o[2] = rss.getString("penulis");
              o[3] = rss.getString("harga");
              model.addRow(o);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private void CariJudul(){
        try{
            String sql = "SELECT*from buku where judul='"+cari.getText()+"'";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
              Object[] o = new Object[4];   
              o[0] = rss.getInt("id");
              o[1] = rss.getString("judul");
              o[2] = rss.getString("penulis");
              o[3] = rss.getString("harga");
              model.addRow(o);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private void CariPenulis(){
        try{
            String sql = "SELECT*from buku where penulis='"+cari.getText()+"'";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
              Object[] o = new Object[4];   
              o[0] = rss.getInt("id");
              o[1] = rss.getString("judul");
              o[2] = rss.getString("penulis");
              o[3] = rss.getString("harga");
              model.addRow(o);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }
    }
    private void CariHarga(){
        try{
            String sql = "SELECT*from buku where harga='"+cari.getText()+"'";
            stt = con.createStatement();
            rss = stt.executeQuery(sql);
            while(rss.next()){
              Object[] o = new Object[4];   
              o[0] = rss.getInt("id");
              o[1] = rss.getString("judul");
              o[2] = rss.getString("penulis");
              o[3] = rss.getString("harga");
              model.addRow(o);
            }
        }catch(SQLException e){
            System.out.println(e.getMessage());
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        judul = new javax.swing.JTextField();
        harga = new javax.swing.JTextField();
        penulis = new javax.swing.JComboBox();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cari = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        crr = new javax.swing.JButton();
        bck = new javax.swing.JButton();
        id = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();
        sv = new javax.swing.JButton();
        chg = new javax.swing.JButton();
        dlt = new javax.swing.JButton();
        ex = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                jPanel1ComponentShown(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(153, 255, 153));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel1.setText("FORM DATA BUKU");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(146, 146, 146))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel2.setText("Judul");

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel3.setText("Penulis");

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel4.setText("Harga");

        penulis.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        penulis.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "WIRA NAGARA", "BOY CHANDRA", "FIERSA BESARI", "TERE LIYE" }));
        penulis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                penulisActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(harga)
                    .addComponent(judul)
                    .addComponent(penulis, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(judul, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(penulis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(harga, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel5.setText("Search");

        jPanel6.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        crr.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        crr.setText("Cari");
        crr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                crrActionPerformed(evt);
            }
        });
        jPanel6.add(crr);

        bck.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        bck.setText("Kembali");
        bck.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bckActionPerformed(evt);
            }
        });
        jPanel6.add(bck);

        id.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        id.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Id", "Judul", "Penulis", "Harga" }));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        jLabel6.setText("By  :");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(21, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel6)
                        .addComponent(cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel5)))
                .addContainerGap(14, Short.MAX_VALUE))
        );

        sv.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        sv.setText("SAVE");
        sv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                svActionPerformed(evt);
            }
        });

        chg.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        chg.setText("CHANGE");
        chg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                chgActionPerformed(evt);
            }
        });

        dlt.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        dlt.setText("DELETE");
        dlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dltActionPerformed(evt);
            }
        });

        ex.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        ex.setText("EXIT");
        ex.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exMouseClicked(evt);
            }
        });
        ex.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exActionPerformed(evt);
            }
        });

        tabel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id", "Judul", "Penulis", "Harga"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(sv, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(chg, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(dlt, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(ex, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 486, Short.MAX_VALUE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sv, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chg, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dlt, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ex, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void penulisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_penulisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_penulisActionPerformed

    private void jPanel1ComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_jPanel1ComponentShown
        // TODO add your handling code here:
         InitTable();
        TampilData();
    }//GEN-LAST:event_jPanel1ComponentShown

    private void svActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_svActionPerformed
        // TODO add your handling code here:
        if(judul.getText().equals("") && harga.getText().equals(""))
     {
           JOptionPane.showMessageDialog(null, "Data Belum Lengkap","Warning !!!!",JOptionPane.INFORMATION_MESSAGE);
           judul.requestFocus();
     } else{
        String judul = judul.getText();
        String penulis = penulis.getSelectedItem().toString();
        String harga = harga.getText();
        TambahData(judul,penulis,harga);
        validasi(judul, penulis, harga);
        
        InitTable();
        TampilData();
    }//GEN-LAST:event_svActionPerformed
    }
    private void exMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exMouseClicked
        // TODO add your handling code here:
         System.exit(0); 
    }//GEN-LAST:event_exMouseClicked

    private void dltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dltActionPerformed
        // TODO add your handling code here:
        String id = tabel.getValueAt(baris, 0).toString();
        HapusData( id, baris);
    }//GEN-LAST:event_dltActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        int baris = tabel.getSelectedRow();
        
        String judul=tabel.getValueAt(baris,1).toString();
        String penulis=tabel.getValueAt(baris,2).toString();
        String harga=tabel.getValueAt(baris,3).toString();
        String id=tabel.getValueAt(baris,0).toString();
        
        
        judul.setText(judul);
        penulis.setSelectedItem(penulis);
        harga.setText(harga);
    }//GEN-LAST:event_tabelMouseClicked

    private void chgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_chgActionPerformed
        // TODO add your handling code here:
        int baris = tabel.getSelectedRow();
        
        
        tabel.setValueAt(judul.getText(),baris,1);
        tabel.setValueAt(penulis.getSelectedItem(),baris,2);
        tabel.setValueAt(harga.getText(),baris,3); 
        
        String judul=tabel.getValueAt(baris,1).toString();
        String penulis=tabel.getValueAt(baris,2).toString();
        String harga=tabel.getValueAt(baris,3).toString();
        String id=tabel.getValueAt(baris,0).toString();
        
        
        judul.setText(judul);
        penulis.setSelectedItem(penulis);
        harga.setText(harga);
        
        UbahData(judul,penulis,harga,id);
    }//GEN-LAST:event_chgActionPerformed

    private void crrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_crrActionPerformed
        // TODO add your handling code here:
       if(cari.getText().equals("")){
            JOptionPane.showMessageDialog(null,"ISI DULU GAN!!!");
        }
        else{
            model.getDataVector().removeAllElements();
            model.fireTableDataChanged();
            if(id.getSelectedItem().equals("Id")){
             CariId();  
            }
            else if(id.getSelectedItem().equals("Judul")){
             CariJudul();
            }
            else if(id.getSelectedItem().equals("Penulis")){
             CariPenulis();
            }
            else if(id.getSelectedItem().equals("Harga")){
             CariHarga();
             }
        }
    }//GEN-LAST:event_crrActionPerformed

    private void bckActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bckActionPerformed
        // TODO add your handling code here:
        InitTable();
        TampilData();
    }//GEN-LAST:event_bckActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
       InitTable();
       TampilData(); 
    }//GEN-LAST:event_formComponentShown

    private void exActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_exActionPerformed

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
            java.util.logging.Logger.getLogger(formdatabuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(formdatabuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(formdatabuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(formdatabuku.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new formdatabuku().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bck;
    private javax.swing.JTextField cari;
    private javax.swing.JButton chg;
    private javax.swing.JButton crr;
    private javax.swing.JButton dlt;
    private javax.swing.JButton ex;
    private javax.swing.JTextField harga;
    private javax.swing.JComboBox id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField judul;
    private javax.swing.JComboBox penulis;
    private javax.swing.JButton sv;
    private javax.swing.JTable tabel;
    // End of variables declaration//GEN-END:variables

   
}
