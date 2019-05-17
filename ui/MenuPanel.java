/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.awt.CardLayout;
import javax.swing.JPanel;
import modelo.BiblioSQL;
import src.SessionDB;
import static ui.MainFrame.*;

/**
 *
 * @author NarF
 */
public class MenuPanel extends javax.swing.JPanel {

    JPanel cards;
    CardLayout layout;
    SessionDB session;
    BiblioSQL biblioSQL;
    /**
     * Creates new form MenuPanel
     */
    public MenuPanel() {
    }

    public MenuPanel(SessionDB session) {
        this.session = session;
        biblioSQL = new BiblioSQL(session);
        if(session.numOfTables()==0){
            biblioSQL.initializeBiblio();
            biblioSQL.insertDemoData();
        }
            
        
        cards = MainFrame.getCards();
        layout = (CardLayout)cards.getLayout();
        
        cards.add(new GenerosPanel(biblioSQL), GENEROSPANEL);
        cards.add(new PaisesPanel(biblioSQL), PAISESPANEL);
        cards.add(new AutoresPanel(biblioSQL), AUTORESPANEL);
        
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        btnLibros = new javax.swing.JButton();
        btnGeneros = new javax.swing.JButton();
        btnEditoriales = new javax.swing.JButton();
        btnAutores = new javax.swing.JButton();
        btnPaises = new javax.swing.JButton();
        btnQuit = new javax.swing.JButton();

        jLabel2.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Biblioteca");

        btnLibros.setText("Libros");

        btnGeneros.setText("Generos");
        btnGeneros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGenerosActionPerformed(evt);
            }
        });

        btnEditoriales.setText("Editoriales");

        btnAutores.setText("Autores");
        btnAutores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAutoresActionPerformed(evt);
            }
        });

        btnPaises.setText("Paises");
        btnPaises.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPaisesActionPerformed(evt);
            }
        });

        btnQuit.setText("Salir");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEditoriales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnGeneros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnLibros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnAutores, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(btnPaises, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE)
                            .addComponent(btnQuit, javax.swing.GroupLayout.DEFAULT_SIZE, 90, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLibros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnAutores, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGeneros, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnPaises, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditoriales, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnQuit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnGenerosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGenerosActionPerformed
        // TODO add your handling code here:
        layout.show(cards, GENEROSPANEL);        
    }//GEN-LAST:event_btnGenerosActionPerformed

    private void btnPaisesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPaisesActionPerformed
        // TODO add your handling code here:
        layout.show(cards, PAISESPANEL);     
    }//GEN-LAST:event_btnPaisesActionPerformed

    private void btnAutoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAutoresActionPerformed
        // TODO add your handling code here:
        layout.show(cards, AUTORESPANEL);    
    }//GEN-LAST:event_btnAutoresActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAutores;
    private javax.swing.JButton btnEditoriales;
    private javax.swing.JButton btnGeneros;
    private javax.swing.JButton btnLibros;
    private javax.swing.JButton btnPaises;
    private javax.swing.JButton btnQuit;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}