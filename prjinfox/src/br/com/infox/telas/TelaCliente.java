/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.infox.telas;
import java.sql.*;
import br.com.infox.dal.ModuloConexao;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Miétje
 */
public class TelaCliente extends javax.swing.JInternalFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    /**
     * Creates new form TelaCliente
     */
    public TelaCliente() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    private void adicionar(){
        String sql = "insert into tbclientes(nome,endereço,fone,email)values(?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtclinome.getText());
            pst.setString(2, txtcliendereco.getText());
            pst.setString(3, txtclifone.getText());
            pst.setString(4, txtcliemail.getText());
            if(txtclinome.getText().isEmpty()||txtcliendereco.getText().isEmpty()||txtclifone.getText().isEmpty()||txtcliemail.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "preencha todos os campos");
            }else{
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "adicionado com sucesso");
                limpar();
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void pesquisar(){
        String sql = "select * from tbclientes where nome like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtclipesquisa.getText()+"%");
            rs = pst.executeQuery();
            tblcli.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, e);
        }
    }
    public void setarCampos(){
        int setar = tblcli.getSelectedRow();
        txtcliid.setText(tblcli.getModel().getValueAt(setar,0).toString());
        txtclinome.setText(tblcli.getModel().getValueAt(setar,1).toString());
        txtcliendereco.setText(tblcli.getModel().getValueAt(setar,2).toString());
        txtclifone.setText(tblcli.getModel().getValueAt(setar,3).toString());
        txtcliemail.setText(tblcli.getModel().getValueAt(setar,4).toString());
        btnadicionar.setEnabled(false);
    }
    private void alterar(){
        String sql ="update tbclientes set nome=?,endereço=?,fone=?,email=? where idcli=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtclinome.getText());
            pst.setString(2, txtcliendereco.getText());
            pst.setString(3, txtclifone.getText());
            pst.setString(4, txtcliemail.getText());
            pst.setString(5, txtcliid.getText());
            if(txtclinome.getText().isEmpty()||txtcliendereco.getText().isEmpty()||txtclifone.getText().isEmpty()||txtcliemail.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "preencha todos os campos");
            }else{
                pst.executeUpdate();
                 JOptionPane.showMessageDialog(null, "alterado com sucesso");
                
                limpar();
                btnadicionar.setEnabled(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    private void deletar(){
        
    int con = JOptionPane.showConfirmDialog(null, "tem sertesa que deseja remover este usuario","Atenção",JOptionPane.YES_NO_OPTION);
        if(con==JOptionPane.YES_OPTION){
            String sql ="delete from tbclientes where idcli=?";
            try {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtcliid.getText());
                
                if (txtcliid.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "prencha o campo id");
            } else {
                int apagado = pst.executeUpdate();
                if(apagado>0){
                    JOptionPane.showMessageDialog(null, "deletado com sucesso");
                    limpar();
                    btnadicionar.setEnabled(true);
                }
                
            }
                
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    private void limpar(){
        txtclipesquisa.setText(null);
        txtcliid.setText(null);
        txtclinome.setText(null);
        txtclifone.setText(null);
        txtcliendereco.setText(null);
        txtcliemail.setText(null);
        ((DefaultTableModel)tblcli.getModel()).setRowCount(0);
    }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtclinome = new javax.swing.JTextField();
        txtcliendereco = new javax.swing.JTextField();
        txtclifone = new javax.swing.JTextField();
        txtcliemail = new javax.swing.JTextField();
        pesquisa = new javax.swing.JLabel();
        txtclipesquisa = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblcli = new javax.swing.JTable();
        btnadicionar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btndeletar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        txtcliid = new javax.swing.JTextField();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jLabel1.setText("Nome");

        jLabel2.setText("Endereço");

        jLabel3.setText("Telefone");

        jLabel4.setText("Email");

        pesquisa.setText("pesquisa");

        txtclipesquisa.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtclipesquisaKeyReleased(evt);
            }
        });

        tblcli.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tblcli.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblcliMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tblcli);

        btnadicionar.setText("adicionar");
        btnadicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadicionarActionPerformed(evt);
            }
        });

        btneditar.setText("editar");
        btneditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btneditarActionPerformed(evt);
            }
        });

        btndeletar.setText("deletar");
        btndeletar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeletarActionPerformed(evt);
            }
        });

        jLabel5.setText("id");

        txtcliid.setEnabled(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 88, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel3)
                                    .addGap(22, 22, 22)
                                    .addComponent(txtclifone, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addGap(38, 38, 38))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                            .addComponent(pesquisa)
                                            .addGap(30, 30, 30)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(txtcliemail)
                                        .addComponent(txtclipesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, 186, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtclinome, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                    .addComponent(txtcliendereco))
                                .addGap(37, 37, 37)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtcliid, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(btnadicionar)
                        .addGap(28, 28, 28)
                        .addComponent(btneditar)
                        .addGap(39, 39, 39)
                        .addComponent(btndeletar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtclinome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtcliid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtcliendereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtclifone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtcliemail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(pesquisa)
                    .addComponent(txtclipesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadicionar)
                    .addComponent(btneditar)
                    .addComponent(btndeletar))
                .addContainerGap(229, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnadicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadicionarActionPerformed
        adicionar();
    }//GEN-LAST:event_btnadicionarActionPerformed

    private void txtclipesquisaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtclipesquisaKeyReleased
        pesquisar();
    }//GEN-LAST:event_txtclipesquisaKeyReleased

    private void tblcliMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblcliMouseClicked
        setarCampos();
    }//GEN-LAST:event_tblcliMouseClicked

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        alterar();
    }//GEN-LAST:event_btneditarActionPerformed

    private void btndeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletarActionPerformed
        deletar();
    }//GEN-LAST:event_btndeletarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadicionar;
    private javax.swing.JButton btndeletar;
    private javax.swing.JButton btneditar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel pesquisa;
    private javax.swing.JTable tblcli;
    private javax.swing.JTextField txtcliemail;
    private javax.swing.JTextField txtcliendereco;
    private javax.swing.JTextField txtclifone;
    private javax.swing.JTextField txtcliid;
    private javax.swing.JTextField txtclinome;
    private javax.swing.JTextField txtclipesquisa;
    // End of variables declaration//GEN-END:variables
}
