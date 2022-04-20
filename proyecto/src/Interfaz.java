
import java.awt.Color;
import java.security.SecureRandom;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */

/**
 *
 * @author Noel
 */
//Constructir
public class Interfaz extends javax.swing.JFrame {
    
ArrayList<JLabel> etiquetas = new ArrayList();
SecureRandom revolver= new SecureRandom();
String [] picCorto=new String [8];
String[][] rutaCorto=new String [4][4];
    int[]nums= new int[8];

    public Interfaz() {
        initComponents();
        setSize(800,700);
        setLocationRelativeTo(this);
        cargarEtiquetas();
        agregarImagenes();
        pnlCorto.setVisible(false);
    }

void cargarEtiquetas(){
    etiquetas.add(jlbF1);
    etiquetas.add(jlbF2);
    etiquetas.add(jlbF3);
    etiquetas.add(jlbF4);
    etiquetas.add(jlbF5);
    etiquetas.add(jlbF6);
    etiquetas.add(jlbF7);
    etiquetas.add(jlbF8);
    etiquetas.add(jlbF10);
    etiquetas.add(jlbF11);
    etiquetas.add(jlbF12);
    etiquetas.add(jlbF13);
    etiquetas.add(jlbF14);
    etiquetas.add(jlbF15);
    etiquetas.add(jlbF16);
    etiquetas.add(jlbF17);
    
    
}

public int revolverCartas(){
    int numeroGenerado= revolver.nextInt(8);//revolver las cartas
    
    
    return numeroGenerado;
}

void agregarImagenes(){
    for (int pic =0; pic < picCorto.length; pic++){
        picCorto[pic]="/img/"+(pic+1)+".png";//llamo a las imagenes de las cartas
    }
}

void cargarImagenesCarta(){
    int contador=0;
    
    for(int fila=0; fila<rutaCorto.length; fila++){
        for(int columna=0; columna<rutaCorto[0].length; columna++){
            
            int temp= revolverCartas();
            if(nums[temp]==2){//para evitar que las imagenes se repitan mas 2 veces
                columna--;
            }else{
                rutaCorto[fila][columna]=picCorto[temp];
                nums[temp]++;
                
            }
            
        }
    }
    
    for(int fila=0;fila<rutaCorto.length;fila++){
        for(int columna=0; columna<rutaCorto[0].length; columna++){
          etiquetas.get(contador).setOpaque(true);
          etiquetas.get(contador).setIcon(new ImageIcon(getClass().getResource(rutaCorto[fila][columna])));
          etiquetas.get(contador).setText(""+(contador+1));
          contador++;
        }
    }
}

void voltearCartas(){
    for(int i=0;i<etiquetas.size();i++){
        etiquetas.get(i).setIcon(null);
        etiquetas.get(i).setBackground(Color.BLUE);
    }
}

void mostrarImagen(int numCarta){
    if(numCarta>=0 && numCarta<=3){
       etiquetas.get(numCarta).setIcon(new ImageIcon(getClass().getResource(rutaCorto[0][numCarta]))); 
    }else{
        if(numCarta>=4 &&numCarta<=7){
            etiquetas.get(numCarta).setIcon(new ImageIcon(getClass().getResource(rutaCorto[1][numCarta-4])));
        }else{
            if(numCarta>=8 &&numCarta<=11){
                etiquetas.get(numCarta).setIcon(new ImageIcon(getClass().getResource(rutaCorto[2][numCarta-8])));
            }else{
                 if(numCarta>=12 &&numCarta<=15){
                    etiquetas.get(numCarta).setIcon(new ImageIcon(getClass().getResource(rutaCorto[3][numCarta-12])));
            }
        }
    }
    
    
}
        
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnCorto = new javax.swing.JButton();
        btnNormal = new javax.swing.JButton();
        pnlCorto = new javax.swing.JPanel();
        jlbF1 = new javax.swing.JLabel();
        jlbF2 = new javax.swing.JLabel();
        jlbF3 = new javax.swing.JLabel();
        jlbF4 = new javax.swing.JLabel();
        jlbF5 = new javax.swing.JLabel();
        jlbF6 = new javax.swing.JLabel();
        jlbF7 = new javax.swing.JLabel();
        jlbF8 = new javax.swing.JLabel();
        jlbF10 = new javax.swing.JLabel();
        jlbF11 = new javax.swing.JLabel();
        jlbF12 = new javax.swing.JLabel();
        jlbF13 = new javax.swing.JLabel();
        jlbF14 = new javax.swing.JLabel();
        jlbF15 = new javax.swing.JLabel();
        jlbF16 = new javax.swing.JLabel();
        jlbF17 = new javax.swing.JLabel();
        btnJugar = new javax.swing.JButton();
        btnComparar = new javax.swing.JButton();
        jlbFallas = new javax.swing.JLabel();
        jlbCorrectos = new javax.swing.JLabel();
        btnPoder1 = new javax.swing.JButton();
        btnPoder2 = new javax.swing.JButton();
        btnPoder3 = new javax.swing.JButton();
        jlbF9 = new javax.swing.JLabel();
        btnLargo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

        btnCorto.setText("Corto");
        btnCorto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCortoActionPerformed(evt);
            }
        });
        getContentPane().add(btnCorto);
        btnCorto.setBounds(50, 21, 72, 22);

        btnNormal.setText("Normal");
        getContentPane().add(btnNormal);
        btnNormal.setBounds(247, 21, 72, 22);

        pnlCorto.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jlbF1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF1MouseClicked(evt);
            }
        });

        jlbF2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF2MouseClicked(evt);
            }
        });

        jlbF3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF3MouseClicked(evt);
            }
        });

        jlbF4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF4MouseClicked(evt);
            }
        });

        jlbF5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF5MouseClicked(evt);
            }
        });

        jlbF6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF6MouseClicked(evt);
            }
        });

        jlbF7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF7MouseClicked(evt);
            }
        });

        jlbF8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF8MouseClicked(evt);
            }
        });

        jlbF10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF10MouseClicked(evt);
            }
        });

        jlbF11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF11MouseClicked(evt);
            }
        });

        jlbF12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF12MouseClicked(evt);
            }
        });

        jlbF13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF13MouseClicked(evt);
            }
        });

        jlbF14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF14MouseClicked(evt);
            }
        });

        jlbF15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF15MouseClicked(evt);
            }
        });

        jlbF16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF16MouseClicked(evt);
            }
        });

        jlbF17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF17MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout pnlCortoLayout = new javax.swing.GroupLayout(pnlCorto);
        pnlCorto.setLayout(pnlCortoLayout);
        pnlCortoLayout.setHorizontalGroup(
            pnlCortoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCortoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCortoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlCortoLayout.createSequentialGroup()
                        .addGroup(pnlCortoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnlCortoLayout.createSequentialGroup()
                                .addComponent(jlbF1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlbF2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlbF3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(pnlCortoLayout.createSequentialGroup()
                                .addComponent(jlbF8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlbF7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlbF6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCortoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbF5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbF4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(pnlCortoLayout.createSequentialGroup()
                        .addGroup(pnlCortoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCortoLayout.createSequentialGroup()
                                .addComponent(jlbF15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlbF16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlbF17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnlCortoLayout.createSequentialGroup()
                                .addComponent(jlbF14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlbF10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlbF11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(pnlCortoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jlbF12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbF13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        pnlCortoLayout.setVerticalGroup(
            pnlCortoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCortoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlCortoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbF1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbF3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbF2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbF4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(pnlCortoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbF7, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbF6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbF5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbF8, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCortoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbF10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbF12, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbF14, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbF11, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(pnlCortoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jlbF15, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbF13, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbF16, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbF17, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        getContentPane().add(pnlCorto);
        pnlCorto.setBounds(10, 50, 530, 420);

        btnJugar.setText("Jugar");
        btnJugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnJugarActionPerformed(evt);
            }
        });
        getContentPane().add(btnJugar);
        btnJugar.setBounds(620, 60, 72, 22);

        btnComparar.setText("Comparar");
        getContentPane().add(btnComparar);
        btnComparar.setBounds(612, 110, 83, 22);

        jlbFallas.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jlbFallas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbFallas.setBorder(javax.swing.BorderFactory.createTitledBorder("Fallas"));
        getContentPane().add(jlbFallas);
        jlbFallas.setBounds(590, 280, 120, 100);

        jlbCorrectos.setFont(new java.awt.Font("Impact", 0, 14)); // NOI18N
        jlbCorrectos.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbCorrectos.setBorder(javax.swing.BorderFactory.createTitledBorder("Correctos"));
        getContentPane().add(jlbCorrectos);
        jlbCorrectos.setBounds(590, 160, 120, 100);

        btnPoder1.setText("Poder 1");
        getContentPane().add(btnPoder1);
        btnPoder1.setBounds(40, 500, 72, 22);

        btnPoder2.setText("Poder 2");
        getContentPane().add(btnPoder2);
        btnPoder2.setBounds(140, 500, 72, 22);

        btnPoder3.setText("Poder 3");
        getContentPane().add(btnPoder3);
        btnPoder3.setBounds(250, 500, 72, 22);

        jlbF9.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        getContentPane().add(jlbF9);
        jlbF9.setBounds(0, 0, 4, 4);

        btnLargo.setText("largo");
        getContentPane().add(btnLargo);
        btnLargo.setBounds(410, 20, 72, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnJugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnJugarActionPerformed
        // TODO add your handling code here:
        //Probar agregar sockets aqui
        if(rutaCorto[0][0]==null){
            cargarImagenesCarta();
            btnJugar.setText("Jugar");
        }   else{
            voltearCartas();
            btnJugar.setText("Jugando");
        } 
    }//GEN-LAST:event_btnJugarActionPerformed

    private void btnCortoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCortoActionPerformed
        // TODO add your handling code here:
        pnlCorto.setVisible(true);
        
    }//GEN-LAST:event_btnCortoActionPerformed

    private void jlbF4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF4MouseClicked
        // TODO add your handling code here:
        mostrarImagen(Integer.parseInt((jlbF4.getText()))-1);
    }//GEN-LAST:event_jlbF4MouseClicked

    private void jlbF1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF1MouseClicked
        // TODO add your handling code here:
        mostrarImagen(Integer.parseInt((jlbF1.getText()))-1);
        
    }//GEN-LAST:event_jlbF1MouseClicked

    private void jlbF2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF2MouseClicked
        // TODO add your handling code here:
        mostrarImagen(Integer.parseInt((jlbF2.getText()))-1);
    }//GEN-LAST:event_jlbF2MouseClicked

    private void jlbF3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF3MouseClicked
        // TODO add your handling code here:
        mostrarImagen(Integer.parseInt((jlbF3.getText()))-1);
    }//GEN-LAST:event_jlbF3MouseClicked

    private void jlbF5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF5MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbF5MouseClicked

    private void jlbF6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF6MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbF6MouseClicked

    private void jlbF7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF7MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbF7MouseClicked

    private void jlbF8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF8MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbF8MouseClicked

    private void jlbF12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF12MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbF12MouseClicked

    private void jlbF11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF11MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbF11MouseClicked

    private void jlbF10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF10MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbF10MouseClicked

    private void jlbF14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF14MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbF14MouseClicked

    private void jlbF13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF13MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbF13MouseClicked

    private void jlbF17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF17MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbF17MouseClicked

    private void jlbF16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF16MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbF16MouseClicked

    private void jlbF15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF15MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbF15MouseClicked

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Interfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new Interfaz().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnComparar;
    private javax.swing.JButton btnCorto;
    private javax.swing.JButton btnJugar;
    private javax.swing.JButton btnLargo;
    private javax.swing.JButton btnNormal;
    private javax.swing.JButton btnPoder1;
    private javax.swing.JButton btnPoder2;
    private javax.swing.JButton btnPoder3;
    private javax.swing.JLabel jlbCorrectos;
    private javax.swing.JLabel jlbF1;
    private javax.swing.JLabel jlbF10;
    private javax.swing.JLabel jlbF11;
    private javax.swing.JLabel jlbF12;
    private javax.swing.JLabel jlbF13;
    private javax.swing.JLabel jlbF14;
    private javax.swing.JLabel jlbF15;
    private javax.swing.JLabel jlbF16;
    private javax.swing.JLabel jlbF17;
    private javax.swing.JLabel jlbF2;
    private javax.swing.JLabel jlbF3;
    private javax.swing.JLabel jlbF4;
    private javax.swing.JLabel jlbF5;
    private javax.swing.JLabel jlbF6;
    private javax.swing.JLabel jlbF7;
    private javax.swing.JLabel jlbF8;
    private javax.swing.JLabel jlbF9;
    private javax.swing.JLabel jlbFallas;
    private javax.swing.JPanel pnlCorto;
    // End of variables declaration//GEN-END:variables
}
