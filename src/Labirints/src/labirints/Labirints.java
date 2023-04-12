package labirints;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;

public class Labirints extends javax.swing.JFrame {
    int m,n; //labirinta rindu un kolonnu skaits
    public Labirints() {
        initComponents();
    }
    ArrayList<Integer>[] labirints;
    Integer SIZE = 60;
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lasa = new javax.swing.JButton();
        zime = new javax.swing.JButton();
        panelis = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lasa.setText("Uzzīmēt labirintu");
        lasa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lasaActionPerformed(evt);
            }
        });

        zime.setText("Uzzīmēt ceļu");
        zime.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                zimeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelisLayout = new javax.swing.GroupLayout(panelis);
        panelis.setLayout(panelisLayout);
        panelisLayout.setHorizontalGroup(
            panelisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 625, Short.MAX_VALUE)
        );
        panelisLayout.setVerticalGroup(
            panelisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 267, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(776, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lasa, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(zime, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(panelis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lasa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(zime)
                .addGap(18, 18, 18)
                .addComponent(panelis, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lasaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lasaActionPerformed
        try { 
            BufferedReader bufRdr  = new BufferedReader(new FileReader("labirints.txt")); 
            String failaRinda = bufRdr.readLine(); //nolasa no faila vienu teksta rindu
            String[] tmp=failaRinda.split(" ");    //sadala to atsevišķos gabaliņos, kurus saliek masīvā tmp
            m=Integer.parseInt(tmp[0]);            //iegūst rindu skaitu
            n=Integer.parseInt(tmp[1]);            //iegūst kolonnu skaitu
            System.out.println(m+" "+n);           //izvada rindu un kolonnu skaitu testa nolūkiem
            Graphics2D g=(Graphics2D)panelis.getGraphics();
            g.setStroke(new BasicStroke(5));
//  DONE jāraksta cikls, kas uzzīmēs m reiz n labirinta rūtiņas
            g.setStroke(new BasicStroke(3));
            for (int i = 0; i <= n; i++){
                g.drawLine(i * SIZE, 0, i * SIZE, m * SIZE);
            }
            for (int i = 0; i <= m; i++){
                g.drawLine(0, i * SIZE, n * SIZE, i * SIZE);
            }
//            g.drawLine(0,0, 20*n, 0);               
            
//DONE te jāraksta cikls, kas lasa katru no m reiz n faila rindām un izmanto datus, 
            labirints=new ArrayList[m*n];
            for(int i=0;i<labirints.length;i++){
                failaRinda = bufRdr.readLine();
                tmp=failaRinda.split(" ");
                labirints[i]=new ArrayList<Integer>();
                for(int j=1;j<tmp.length;j++){
                    labirints[i].add(Integer.parseInt(tmp[j]));
                }
                g.setColor(panelis.getBackground());
                int iy = i / n;
                int ix = i % n;
                for (int j : labirints[i]){
                    int jy = (j-1) / n;
                    int jx = (j-1) % n;
//                    System.out.println((i+1) + " - " + ix + " " + iy);
//                    System.out.println((j+1) + " - " + jx + " " + jy);
                    if (Math.abs(i-(j-1))==1){
                        // horizontal neighbors
//                        System.out.println("horiz " + i + " " + (j-1));
                        if (i > (j-1)) { // |j|i|
//                            System.out.println((j-1) + " " + i + " -> " + ix + " " + iy + " " + ix + " " + (iy+1));
                            g.drawLine(ix * SIZE, iy * SIZE, ix * SIZE, (iy + 1) * SIZE);
                        } else { // |i|j|
//                            System.out.println(i + " " + (j-1) + " -> " + jx + " " + jy + " " + jx + " " + (jy+1));
                            g.drawLine(jx * SIZE, jy * SIZE, jx * SIZE, (jy + 1) * SIZE);
                        }
                        
                    } else {
                        // vertical neghbors
//                        System.out.println("vert " + i + " " + (j-1));
                        if (i > (j-1)) {
                            // |j|
                            // |-|
                            // |i|
                            System.out.println((j-1) + " " + i + " -> " + ix + " " + jy + " " + (ix+1) + " " + jy);
                            g.drawLine(ix * SIZE, (jy+1) * SIZE, (ix + 1) * SIZE, (jy+1) * SIZE);
                        } else {
                            // |i|
                            // |-|
                            // |j|
                            System.out.println(i + " " + (j-1) + " -> " + jx + " " + iy + " " + (jx+1) + " " + iy);
                            g.drawLine(jx * SIZE, (iy+1) * SIZE, (jx + 1) * SIZE, (iy+1) * SIZE);
                        }
                    }
                }
            } 

            for(int i=0;i<labirints.length;i++){
                System.out.print((i+1)+" kaimiņi: ");
                Iterator it=labirints[i].iterator();
                while(it.hasNext()){
                    int j=(Integer)it.next();  
                    System.out.print(j+" ");
                } 
                System.out.println();
            }

// lai dzēstu sienas starp kaimiņu rūtiņām. Dzēšana notiek, pārvelkot līniju fona krāsā
            g.setColor(panelis.getBackground());
            
        } catch (IOException e) { 
            System.err.println(e); 
            System.exit(1); 
    } 
        
    }//GEN-LAST:event_lasaActionPerformed

    private void zimeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_zimeActionPerformed
      // te jānolasa lietotāja vēlmes no kuras uz kuru rūtiņu jāmeklē ceļš
        zimetCelu(1,6);
    }//GEN-LAST:event_zimeActionPerformed
    public void zimetCelu(int no,int uz){
       Stack<Integer> cels=mekletCelu(no,uz);
       Graphics g=panelis.getGraphics();
       // te jāraksta cikls ceļa zimēšanai
       g.setColor(Color.red);
       g.drawLine(10,10, 10, 30);
    }
    public Stack<Integer> mekletCelu(int no, int uz){
        Stack<Integer> cels=new Stack();
        // te jāraksta ceļa meklēšnas algoritms
        return cels;
    }
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
            java.util.logging.Logger.getLogger(Labirints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Labirints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Labirints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Labirints.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Labirints().setVisible(true);
            }
        });
    }
    
//    public void BFS(int vs){
//        Queue<Integer> q = new LinkedList<>();
//        ArrayList<Integer>[] apmeklets = new ArrayList<Integer>(Collections.copies(n*m, false));
//        q.add(vs);
//        apmeklets(vs) = true;
//        while(!q.isEempty())
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton lasa;
    private javax.swing.JPanel panelis;
    private javax.swing.JButton zime;
    // End of variables declaration//GEN-END:variables
}
