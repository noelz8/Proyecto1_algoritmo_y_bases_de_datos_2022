
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Stack;
import javax.swing.JLabel;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
/**
 *
 * @author Noel
 */
public class Normal extends javax.swing.JPanel {

    rrayList<JLabel> etiquetas = new ArrayList();
    Stack<JLabel> cartasBuenas = new Stack<JLabel>();
    JLabel[][] matrizCartas = new JLabel[4][4];
    SecureRandom revolver = new SecureRandom();
    String[] picCorto = new String[8];
    String[][] rutaCorto = new String[4][4];
    int[] nums = new int[8];
    int cantClics = 0;
    String[] Comparacion = new String[2];//
    int[] numeroCarta = new int[2];
    int mis_aciertos = 0;
    int aciertos_rival = 0;
    int fallas = 0;
    private boolean gameOver = false;
    JLabel label = new JLabel();
    private boolean miTurno = false;
}

/**
 * Creates new form Normal
 */
public Normal() {
        initComponents();
        setSize(800, 700);
        setLocationRelativeTo(this);
        cargarEtiquetas();
        agregarImagenes();
        pnlNormal.setVisible(false);
    }
           void cargarEtiquetas() {
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
        matrizCartas[0][0] = jlbF1;
        matrizCartas[0][1] = jlbF2;
        matrizCartas[0][2] = jlbF3;
        matrizCartas[0][3] = jlbF4;
        matrizCartas[1][0] = jlbF5;
        matrizCartas[1][1] = jlbF6;
        matrizCartas[1][2] = jlbF7;
        matrizCartas[1][3] = jlbF8;
        matrizCartas[2][0] = jlbF10;
        matrizCartas[2][1] = jlbF11;
        matrizCartas[2][2] = jlbF12;
        matrizCartas[2][3] = jlbF13;
        matrizCartas[3][0] = jlbF14;
        matrizCartas[3][1] = jlbF15;
        matrizCartas[3][2] = jlbF16;
        matrizCartas[3][3] = jlbF17;

    }

    public int revolverCartas() {
        int numeroGenerado = revolver.nextInt(8);//revolver las cartas

        return numeroGenerado;
    }

    void agregarImagenes() {
        for (int pic = 0; pic < picCorto.length; pic++) {
            picCorto[pic] = "/img/" + (pic + 1) + ".png";//llamo a las imagenes de las cartas
        }
    }

    void cargarImagenesCarta() {
        int contador = 0;

        for (int fila = 0; fila < rutaCorto.length; fila++) {
            for (int columna = 0; columna < rutaCorto[0].length; columna++) {

                int temp = revolverCartas();
                if (nums[temp] == 2) {//para evitar que las imagenes se repitan mas 2 veces
                    columna--;
                } else {
                    rutaCorto[fila][columna] = picCorto[temp];
                    nums[temp]++;

                }

            }
        }

        for (int fila = 0; fila < rutaCorto.length; fila++) {
            for (int columna = 0; columna < rutaCorto[0].length; columna++) {
                etiquetas.get(contador).setOpaque(true);
                etiquetas.get(contador).setIcon(new ImageIcon(getClass().getResource(rutaCorto[fila][columna])));
                etiquetas.get(contador).setText("" + (contador + 1));
                contador++;
            }
        }
    }

    void voltearCartas() {
        for (int i = 0; i < etiquetas.size(); i++) {
            etiquetas.get(i).setIcon(null);
            etiquetas.get(i).setBackground(Color.BLUE);
        }
    }

    void mostrarImagen(int numCarta) {
        if (cantClics != 2) {
            if (numCarta >= 0 && numCarta <= 3) {
                Comparacion[cantClics] = rutaCorto[0][numCarta];
                etiquetas.get(numCarta).setIcon(new ImageIcon(getClass().getResource(rutaCorto[0][numCarta])));
            } else {
                if (numCarta >= 4 && numCarta <= 7) {
                    Comparacion[cantClics] = rutaCorto[1][numCarta - 4];
                    etiquetas.get(numCarta).setIcon(new ImageIcon(getClass().getResource(rutaCorto[1][numCarta - 4])));
                } else {
                    if (numCarta >= 8 && numCarta <= 11) {
                        Comparacion[cantClics] = rutaCorto[2][numCarta - 8];
                        etiquetas.get(numCarta).setIcon(new ImageIcon(getClass().getResource(rutaCorto[2][numCarta - 8])));
                    } else {
                        if (numCarta >= 12 && numCarta <= 15) {
                            Comparacion[cantClics] = rutaCorto[3][numCarta - 12];
                            etiquetas.get(numCarta).setIcon(new ImageIcon(getClass().getResource(rutaCorto[3][numCarta - 12])));
                        }
                    }
                }
            }
            numeroCarta[cantClics] = numCarta;
            cantClics++;
            if (cantClics == 2) {
                btnComparar.setEnabled(true);
            }

        }
    }
        

    boolean jugarONo() {
        boolean jugarAct;
        if (btnJugar.getText().equals("Jugando")) {
            jugarAct = true;
            finDeJuego();
        } else {
            jugarAct = false;
        }

        return jugarAct;

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlNormal = new javax.swing.JPanel();
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
        jlbF18 = new javax.swing.JLabel();
        jlbF19 = new javax.swing.JLabel();
        jlbF20 = new javax.swing.JLabel();
        jlbF21 = new javax.swing.JLabel();

        pnlNormal.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pnlNormal.setLayout(null);

        jlbF1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF1MouseClicked(evt);
            }
        });
        pnlNormal.add(jlbF1);
        jlbF1.setBounds(8, 8, 80, 80);

        jlbF2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF2MouseClicked(evt);
            }
        });
        pnlNormal.add(jlbF2);
        jlbF2.setBounds(106, 8, 80, 80);

        jlbF3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF3MouseClicked(evt);
            }
        });
        pnlNormal.add(jlbF3);
        jlbF3.setBounds(204, 8, 80, 80);

        jlbF4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF4MouseClicked(evt);
            }
        });
        pnlNormal.add(jlbF4);
        jlbF4.setBounds(302, 8, 80, 80);

        jlbF5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF5MouseClicked(evt);
            }
        });
        pnlNormal.add(jlbF5);
        jlbF5.setBounds(302, 117, 80, 80);

        jlbF6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF6MouseClicked(evt);
            }
        });
        pnlNormal.add(jlbF6);
        jlbF6.setBounds(204, 117, 80, 80);

        jlbF7.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF7.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF7MouseClicked(evt);
            }
        });
        pnlNormal.add(jlbF7);
        jlbF7.setBounds(106, 117, 80, 80);

        jlbF8.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF8MouseClicked(evt);
            }
        });
        pnlNormal.add(jlbF8);
        jlbF8.setBounds(8, 117, 80, 80);

        jlbF10.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF10.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF10MouseClicked(evt);
            }
        });
        pnlNormal.add(jlbF10);
        jlbF10.setBounds(106, 215, 80, 80);

        jlbF11.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF11.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF11MouseClicked(evt);
            }
        });
        pnlNormal.add(jlbF11);
        jlbF11.setBounds(204, 215, 80, 80);

        jlbF12.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF12MouseClicked(evt);
            }
        });
        pnlNormal.add(jlbF12);
        jlbF12.setBounds(302, 215, 80, 80);

        jlbF13.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF13.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF13MouseClicked(evt);
            }
        });
        pnlNormal.add(jlbF13);
        jlbF13.setBounds(302, 313, 80, 80);

        jlbF14.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF14.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF14MouseClicked(evt);
            }
        });
        pnlNormal.add(jlbF14);
        jlbF14.setBounds(8, 215, 80, 80);

        jlbF15.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF15.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF15MouseClicked(evt);
            }
        });
        pnlNormal.add(jlbF15);
        jlbF15.setBounds(420, 320, 80, 80);

        jlbF16.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF16.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF16MouseClicked(evt);
            }
        });
        pnlNormal.add(jlbF16);
        jlbF16.setBounds(106, 313, 80, 80);

        jlbF17.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF17.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF17MouseClicked(evt);
            }
        });
        pnlNormal.add(jlbF17);
        jlbF17.setBounds(204, 313, 80, 80);

        jlbF18.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF18.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF18MouseClicked(evt);
            }
        });
        pnlNormal.add(jlbF18);
        jlbF18.setBounds(8, 313, 80, 80);

        jlbF19.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF19.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF19MouseClicked(evt);
            }
        });
        pnlNormal.add(jlbF19);
        jlbF19.setBounds(420, 10, 80, 80);

        jlbF20.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF20.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF20MouseClicked(evt);
            }
        });
        pnlNormal.add(jlbF20);
        jlbF20.setBounds(430, 120, 80, 80);

        jlbF21.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jlbF21.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jlbF21MouseClicked(evt);
            }
        });
        pnlNormal.add(jlbF21);
        jlbF21.setBounds(420, 220, 80, 80);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 560, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 560, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 440, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(pnlNormal, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jlbF1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF1MouseClicked
        // TODO add your handling code here:
        if (jugarONo()) {
            mostrarImagen(Integer.parseInt((jlbF1.getText())) - 1);
    }//GEN-LAST:event_jlbF1MouseClicked

    private void jlbF2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF2MouseClicked
        // TODO add your handling code here:
        if (jugarONo()) {
            mostrarImagen(Integer.parseInt((jlbF2.getText())) - 1);
    }//GEN-LAST:event_jlbF2MouseClicked

    private void jlbF3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF3MouseClicked
        // TODO add your handling code here:
        if (jugarONo()) {
            mostrarImagen(Integer.parseInt((jlbF3.getText())) - 1);
    }//GEN-LAST:event_jlbF3MouseClicked

    private void jlbF4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF4MouseClicked
        // TODO add your handling code here:
        if (jugarONo()) {
            mostrarImagen(Integer.parseInt((jlbF4.getText())) - 1);
    }//GEN-LAST:event_jlbF4MouseClicked

    private void jlbF5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF5MouseClicked
        // TODO add your handling code here:
        if (jugarONo()) {
            mostrarImagen(Integer.parseInt((jlbF5.getText())) - 1);
    }//GEN-LAST:event_jlbF5MouseClicked

    private void jlbF6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF6MouseClicked
        // TODO add your handling code here:
        if (jugarONo()) {
            mostrarImagen(Integer.parseInt((jlbF6.getText())) - 1);
    }//GEN-LAST:event_jlbF6MouseClicked

    private void jlbF7MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF7MouseClicked
        // TODO add your handling code here:
        if (jugarONo()) {
            mostrarImagen(Integer.parseInt((jlbF7.getText())) - 1);
    }//GEN-LAST:event_jlbF7MouseClicked

    private void jlbF8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF8MouseClicked
        // TODO add your handling code here:
        if (jugarONo()) {
            mostrarImagen(Integer.parseInt((jlbF8.getText())) - 1);
    }//GEN-LAST:event_jlbF8MouseClicked

    private void jlbF10MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF10MouseClicked
        // TODO add your handling code here:
        if (jugarONo()) {
            mostrarImagen(Integer.parseInt((jlbF10.getText())) - 1);
    }//GEN-LAST:event_jlbF10MouseClicked

    private void jlbF11MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF11MouseClicked
        // TODO add your handling code here:
        if (jugarONo()) {
            mostrarImagen(Integer.parseInt((jlbF11.getText())) - 1);
    }//GEN-LAST:event_jlbF11MouseClicked

    private void jlbF12MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF12MouseClicked
        // TODO add your handling code here:
        if (jugarONo()) {
            mostrarImagen(Integer.parseInt((jlbF12.getText())) - 1);
    }//GEN-LAST:event_jlbF12MouseClicked

    private void jlbF13MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF13MouseClicked
        // TODO add your handling code here:
        if (jugarONo()) {
            mostrarImagen(Integer.parseInt((jlbF13.getText())) - 1);
    }//GEN-LAST:event_jlbF13MouseClicked

    private void jlbF14MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF14MouseClicked
        // TODO add your handling code here:
        if (jugarONo()) {
            mostrarImagen(Integer.parseInt((jlbF14.getText())) - 1);
    }//GEN-LAST:event_jlbF14MouseClicked

    private void jlbF15MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF15MouseClicked
        // TODO add your handling code here:
        if (jugarONo()) {
            mostrarImagen(Integer.parseInt((jlbF15.getText())) - 1);
    }//GEN-LAST:event_jlbF15MouseClicked

    private void jlbF16MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF16MouseClicked
        // TODO add your handling code here:
        if (jugarONo()) {
            mostrarImagen(Integer.parseInt((jlbF16.getText())) - 1);
    }//GEN-LAST:event_jlbF16MouseClicked

    private void jlbF17MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF17MouseClicked
        // TODO add your handling code here:
        if (jugarONo()) {
            mostrarImagen(Integer.parseInt((jlbF17.getText())) - 1);
    }//GEN-LAST:event_jlbF17MouseClicked

    private void jlbF18MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF18MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbF18MouseClicked

    private void jlbF19MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF19MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbF19MouseClicked

    private void jlbF20MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF20MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbF20MouseClicked

    private void jlbF21MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jlbF21MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbF21MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jlbF1;
    private javax.swing.JLabel jlbF10;
    private javax.swing.JLabel jlbF11;
    private javax.swing.JLabel jlbF12;
    private javax.swing.JLabel jlbF13;
    private javax.swing.JLabel jlbF14;
    private javax.swing.JLabel jlbF15;
    private javax.swing.JLabel jlbF16;
    private javax.swing.JLabel jlbF17;
    private javax.swing.JLabel jlbF18;
    private javax.swing.JLabel jlbF19;
    private javax.swing.JLabel jlbF2;
    private javax.swing.JLabel jlbF20;
    private javax.swing.JLabel jlbF21;
    private javax.swing.JLabel jlbF3;
    private javax.swing.JLabel jlbF4;
    private javax.swing.JLabel jlbF5;
    private javax.swing.JLabel jlbF6;
    private javax.swing.JLabel jlbF7;
    private javax.swing.JLabel jlbF8;
    private javax.swing.JPanel pnlNormal;
    // End of variables declaration//GEN-END:variables
}
