/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.infox.telas;
import java.sql.*;
import br.com.infox.dal.ModuloConexao;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;
/**
 * estudar django e mongodb
 * @author Miétje
 */
public class TelaOs extends javax.swing.JInternalFrame {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    private String tipo;
    /**
     * Creates new form TelaOs
     */
    public TelaOs() {
        initComponents();
        conexao = ModuloConexao.conector();
    }
    private void pesquisar(){
        String sql = "select * from tbclientes where nome like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtpesquisar.getText()+"%");
            rs = pst.executeQuery();
            tblclientes.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);  
        }
    }
    private void setar(){
        int setar = tblclientes.getSelectedRow();
       txtcliid.setText(tblclientes.getModel().getValueAt(setar, 0).toString());
    }
    private void emitirOs(){
        String sql = "insert into tbos (tipo,situacao,equipamento,defeito,serviço,tecnico,valor,idcli) values(?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, tipo);
            pst.setString(2, cbosituacao.getSelectedItem().toString());
            pst.setString(3, txtosequi.getText());
            pst.setString(4, txtosdef.getText());
            pst.setString(5, txtosservico.getText());
            pst.setString(6, txtostec.getText());
            pst.setString(7, txtosvalor.getText());
            pst.setString(8, txtcliid.getText());
            if (txtcliid.getText().isEmpty()||txtosequi.getText().isEmpty()||txtosdef.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "preencha todos os campos");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado>0) {
                    JOptionPane.showMessageDialog(null, "Os adicionada com sucesso");
                    limpar();
                    
                    
                }
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
    }
    private void pesquisarOS(){
        String numOS=JOptionPane.showInputDialog("numeros da os");
        String sql = ("select * from tbos where idos="+ numOS);
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            if (rs.next()) {
                txtdata.setText(rs.getString(2));
                txtos.setText(rs.getString(1));
                String rbttipo = rs.getString(3);
                if (rbttipo.equals("Os")) {
                    rbtos.setSelected(true);
                    tipo = "Os";
                } else {
                    rbtorcamento.setSelected(true);
                    tipo = "Orçamento";
                }
                cbosituacao.setSelectedItem(rs.getString(4));
                txtosequi.setText(rs.getString(5));
                txtosdef.setText(rs.getString(6));
                txtosservico.setText(rs.getString(7));
                txtostec.setText(rs.getString(8));
                txtosvalor.setText(rs.getString(9));
                txtcliid.setText(rs.getString(10));
                
                btnadicionar.setEnabled(false);
                txtpesquisar.setEditable(false);
                tblclientes.setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "os não registrada");
            }
        }catch(SQLSyntaxErrorException ee){
            JOptionPane.showMessageDialog(null, "OS invalida");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            System.out.println(e);
        }
    }
    private void alterarOS(){
        String sql = "update tbos set tipo=?,situacao=?,equipamento=?,defeito=?,serviço=?,tecnico=?,valor=? where idos=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, tipo);
            pst.setString(2, cbosituacao.getSelectedItem().toString());
            pst.setString(3, txtosequi.getText());
            pst.setString(4, txtosdef.getText());
            pst.setString(5, txtosservico.getText());
            pst.setString(6, txtostec.getText());
            pst.setString(7, txtosvalor.getText());
            pst.setString(8, txtcliid.getText());
            if (txtcliid.getText().isEmpty()||txtosequi.getText().isEmpty()||txtosdef.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "preencha todos os campos");
            } else {
                int adicionado = pst.executeUpdate();
                if (adicionado>0) {
                    JOptionPane.showMessageDialog(null, "Os alterada com sucesso");
                    limpar();
                    
                    
                }
            } 
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    private void excluirOs(){
        int confirma = JOptionPane.showConfirmDialog(null, "tem certeza que deseja excluir esta OS?","Atenção",JOptionPane.YES_NO_OPTION);
        if(confirma == JOptionPane.YES_OPTION){
            String sql = "delete from tbos where idos=?";
            try {
                pst=conexao.prepareStatement(sql);
                pst.setString(1, txtos.getText());
                int apagado=pst.executeUpdate();
                if(apagado>0){
                    JOptionPane.showMessageDialog(null, "os excluida");
                   limpar();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    private void limpar(){
        txtos.setText(null);
        txtdata.setText(null);
        txtosequi.setText(null);
        txtosdef.setText(null);
        txtosservico.setText(null);
        txtostec.setText(null);
        txtosvalor.setText(null);
                    
        btnadicionar.setEnabled(true);
        txtpesquisar.setEditable(true);
        tblclientes.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtos = new javax.swing.JTextField();
        txtdata = new javax.swing.JTextField();
        rbtorcamento = new javax.swing.JRadioButton();
        rbtos = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        cbosituacao = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        txtpesquisar = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtcliid = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblclientes = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtosequi = new javax.swing.JTextField();
        txtosdef = new javax.swing.JTextField();
        txtosservico = new javax.swing.JTextField();
        txtostec = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtosvalor = new javax.swing.JTextField();
        btnadicionar = new javax.swing.JButton();
        btnpesquisar = new javax.swing.JButton();
        btneditar = new javax.swing.JButton();
        btndeletar = new javax.swing.JButton();
        btnimprimir = new javax.swing.JButton();

        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("N°OS");

        jLabel2.setText("data");

        buttonGroup1.add(rbtorcamento);
        rbtorcamento.setText("Orçamento");
        rbtorcamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtorcamentoActionPerformed(evt);
            }
        });

        buttonGroup1.add(rbtos);
        rbtos.setText("Ordem de serviço");
        rbtos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1))
                            .addComponent(txtos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(rbtorcamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbtos)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdata, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbtorcamento)
                    .addComponent(rbtos))
                .addContainerGap(11, Short.MAX_VALUE))
        );

        jLabel3.setText("Situação");

        cbosituacao.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Aguardando aprovação", "Entrega ok", "Oreçamento reprovado", "Aguardando peças", "Na bancada", "Abandonado pelo cliente", "Retornou" }));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Cliente"));

        txtpesquisar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtpesquisarKeyReleased(evt);
            }
        });

        jLabel4.setText("pesquisar");

        txtcliid.setEnabled(false);

        jLabel5.setText("id");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtpesquisar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtcliid, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtpesquisar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtcliid, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        tblclientes.setModel(new javax.swing.table.DefaultTableModel(
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
        tblclientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblclientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblclientes);

        jLabel6.setText("Equipamento");

        jLabel7.setText("Defeito");

        jLabel8.setText("Serviço");

        jLabel9.setText("Técnico");

        txtosequi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtosequiActionPerformed(evt);
            }
        });

        txtosdef.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtosdefActionPerformed(evt);
            }
        });

        jLabel10.setText("Valor total");

        txtosvalor.setText("0");

        btnadicionar.setText("adicionar");
        btnadicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnadicionarActionPerformed(evt);
            }
        });

        btnpesquisar.setText("pesquisar");
        btnpesquisar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnpesquisarActionPerformed(evt);
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

        btnimprimir.setText("imprimir os");
        btnimprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnimprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 38, Short.MAX_VALUE)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel8)
                                .addComponent(jLabel7))
                            .addComponent(jLabel9))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtosequi)
                                    .addComponent(txtosdef)
                                    .addComponent(txtosservico)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(txtostec, javax.swing.GroupLayout.PREFERRED_SIZE, 286, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jLabel10))
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(12, 12, 12)
                                                .addComponent(btnadicionar)
                                                .addGap(45, 45, 45)
                                                .addComponent(btnpesquisar)
                                                .addGap(39, 39, 39)
                                                .addComponent(btneditar)))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(btndeletar)
                                                .addGap(33, 33, 33)
                                                .addComponent(btnimprimir)
                                                .addGap(0, 78, Short.MAX_VALUE))
                                            .addComponent(txtosvalor)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(cbosituacao, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(cbosituacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtosequi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtosdef, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtosservico, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtostec, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(txtosvalor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnadicionar)
                    .addComponent(btnpesquisar)
                    .addComponent(btneditar)
                    .addComponent(btndeletar)
                    .addComponent(btnimprimir))
                .addGap(0, 51, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtosdefActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtosdefActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtosdefActionPerformed

    private void txtpesquisarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtpesquisarKeyReleased
        pesquisar();
    }//GEN-LAST:event_txtpesquisarKeyReleased

    private void tblclientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblclientesMouseClicked
        setar();
    }//GEN-LAST:event_tblclientesMouseClicked

    private void rbtorcamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtorcamentoActionPerformed
        tipo = "Orçamento";
    }//GEN-LAST:event_rbtorcamentoActionPerformed

    private void rbtosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbtosActionPerformed
        tipo = "Os";
    }//GEN-LAST:event_rbtosActionPerformed

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        rbtorcamento.setSelected(true);
    }//GEN-LAST:event_formInternalFrameOpened

    private void txtosequiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtosequiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtosequiActionPerformed

    private void btnadicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnadicionarActionPerformed
        emitirOs();
    }//GEN-LAST:event_btnadicionarActionPerformed

    private void btnimprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnimprimirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnimprimirActionPerformed

    private void btnpesquisarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnpesquisarActionPerformed
        pesquisarOS();
    }//GEN-LAST:event_btnpesquisarActionPerformed

    private void btneditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btneditarActionPerformed
        alterarOS();
    }//GEN-LAST:event_btneditarActionPerformed

    private void btndeletarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeletarActionPerformed
        excluirOs();
    }//GEN-LAST:event_btndeletarActionPerformed
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadicionar;
    private javax.swing.JButton btndeletar;
    private javax.swing.JButton btneditar;
    private javax.swing.JButton btnimprimir;
    private javax.swing.JButton btnpesquisar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> cbosituacao;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rbtorcamento;
    private javax.swing.JRadioButton rbtos;
    private javax.swing.JTable tblclientes;
    private javax.swing.JTextField txtcliid;
    private javax.swing.JTextField txtdata;
    private javax.swing.JTextField txtos;
    private javax.swing.JTextField txtosdef;
    private javax.swing.JTextField txtosequi;
    private javax.swing.JTextField txtosservico;
    private javax.swing.JTextField txtostec;
    private javax.swing.JTextField txtosvalor;
    private javax.swing.JTextField txtpesquisar;
    // End of variables declaration//GEN-END:variables
}
