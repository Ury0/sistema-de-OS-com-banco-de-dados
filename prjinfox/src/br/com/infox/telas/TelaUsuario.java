/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.infox.telas;
import java.sql.*;
import br.com.infox.dal.ModuloConexao;
import javax.swing.JOptionPane;


public class TelaUsuario extends javax.swing.JInternalFrame {

    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    public TelaUsuario() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    private void consultar(){
        String sql = "select * from tbusuarios where iduser=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtuseid.getText());
            rs = pst.executeQuery();
            if (rs.next()) {
                txtusenome.setText(rs.getString(2));
                txtusefone.setText(rs.getString(3));
                txtuselogin.setText(rs.getString(4));
                txtusesenha.setText(rs.getString(5));
                txtuseperfil.setSelectedItem(rs.getString(6));
            } else {
                JOptionPane.showMessageDialog(null, "id não cadastrado");
                txtusenome.setText(null);
                txtusefone.setText(null);
                txtuselogin.setText(null);
                txtusesenha.setText(null);
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    private void adicionar(){
        String sql = "insert into tbusuarios(iduser,usuario,fone,login,senha,perfil) values(?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtuseid.getText());
            pst.setString(2,txtusenome.getText());
            pst.setString(3, txtusefone.getText());
            pst.setString(4,txtuselogin.getText());
            pst.setString(5, txtusesenha.getText());
            pst.setString(6, txtuseperfil.getSelectedItem().toString());
            
           
            if (txtuseid.getText().isEmpty()||txtusenome.getText().isEmpty()||txtusefone.getText().isEmpty()||txtuselogin.getText().isEmpty()||txtusesenha.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "prencha todos os campos");
            } else {
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "adicionado com sucesso");
                txtuseid.setText(null);
                txtusenome.setText(null);
                txtusefone.setText(null);
                txtuselogin.setText(null);
                txtusesenha.setText(null);
                
                
            }
            
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void alterar(){
        String sql = "update tbusuarios set usuario=?,fone=?,login=?,senha=?,perfil=? where iduser=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1,txtusenome.getText());
            pst.setString(2, txtusefone.getText());
            pst.setString(3,txtuselogin.getText());
            pst.setString(4, txtusesenha.getText());
            pst.setString(5, txtuseperfil.getSelectedItem().toString());
            pst.setString(6, txtuseid.getText());
            
             if (txtuseid.getText().isEmpty()||txtusenome.getText().isEmpty()||txtusefone.getText().isEmpty()||txtuselogin.getText().isEmpty()||txtusesenha.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "prencha todos os campos");
            } else {
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "alterado com sucesso");
                txtuseid.setText(null);
                txtusenome.setText(null);
                txtusefone.setText(null);
                txtuselogin.setText(null);
                txtusesenha.setText(null);
                
                
            }
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void deletar(){
        int confira = JOptionPane.showConfirmDialog(null, "tem sertesa que deseja remover este usuario","Atenção",JOptionPane.YES_NO_OPTION);
        if(confira==JOptionPane.YES_OPTION){
            String sql ="delete from tbusuarios where iduser=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtuseid.getText());
                
                if (txtuseid.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "prencha o campo id");
            } else {
                int apagado = pst.executeUpdate();
                if(apagado>0){
                    JOptionPane.showMessageDialog(null, "deletado com sucesso");
                    txtuseid.setText(null);
                    txtusenome.setText(null);
                    txtusefone.setText(null);
                    txtuselogin.setText(null);
                    txtusesenha.setText(null);
                }
                
            }
                
            } catch (Exception e) {
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtuseid = new javax.swing.JTextField();
        txtusenome = new javax.swing.JTextField();
        txtuselogin = new javax.swing.JTextField();
        txtusesenha = new javax.swing.JTextField();
        txtuseperfil = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtusefone = new javax.swing.JTextField();
        btnusecreate = new javax.swing.JButton();
        btnuseread = new javax.swing.JButton();
        btnuseconsultar = new javax.swing.JButton();
        btnusedelet = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("usuario");

        jLabel1.setText("id");

        jLabel2.setText("nome");

        jLabel3.setText("login");

        jLabel4.setText("senha");

        jLabel5.setText("perfil");

        txtusenome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusenomeActionPerformed(evt);
            }
        });

        txtusesenha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtusesenhaActionPerformed(evt);
            }
        });

        txtuseperfil.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "adimin", "user" }));

        jLabel6.setText("fone");

        btnusecreate.setText("adicionar");
        btnusecreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnusecreateActionPerformed(evt);
            }
        });

        btnuseread.setText("alterar");
        btnuseread.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnusereadActionPerformed(evt);
            }
        });

        btnuseconsultar.setText("consultar");
        btnuseconsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnuseconsultarActionPerformed(evt);
            }
        });

        btnusedelet.setText("deletar");
        btnusedelet.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnusedeletActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel3)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtuselogin)
                            .addComponent(txtusenome)
                            .addComponent(txtuseid)
                            .addComponent(txtuseperfil, 0, 126, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtusefone, javax.swing.GroupLayout.DEFAULT_SIZE, 126, Short.MAX_VALUE)
                            .addComponent(txtusesenha))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnusecreate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnuseread, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnuseconsultar, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnusedelet, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(14, 14, 14))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtuseid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(btnusecreate)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txtusenome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnuseread)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtuselogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtusefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtusesenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtuseperfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(btnuseconsultar)
                        .addGap(26, 26, 26)
                        .addComponent(btnusedelet)))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtusenomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusenomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusenomeActionPerformed

    private void txtusesenhaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtusesenhaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtusesenhaActionPerformed

    private void btnuseconsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnuseconsultarActionPerformed
        consultar();
    }//GEN-LAST:event_btnuseconsultarActionPerformed

    private void btnusecreateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnusecreateActionPerformed
        adicionar();
    }//GEN-LAST:event_btnusecreateActionPerformed

    private void btnusereadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnusereadActionPerformed
        alterar();
    }//GEN-LAST:event_btnusereadActionPerformed

    private void btnusedeletActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnusedeletActionPerformed
        deletar();
    }//GEN-LAST:event_btnusedeletActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnuseconsultar;
    private javax.swing.JButton btnusecreate;
    private javax.swing.JButton btnusedelet;
    private javax.swing.JButton btnuseread;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField txtusefone;
    private javax.swing.JTextField txtuseid;
    private javax.swing.JTextField txtuselogin;
    private javax.swing.JTextField txtusenome;
    private javax.swing.JComboBox<String> txtuseperfil;
    private javax.swing.JTextField txtusesenha;
    // End of variables declaration//GEN-END:variables
}
