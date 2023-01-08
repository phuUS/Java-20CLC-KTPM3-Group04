/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.PromotionStatisticsBUS; 
import POJO.PromotionStatisticsPOJO;
import java.util.List;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author bachl
 */
public class ViewDetailStatisticPromotionFrame extends javax.swing.JFrame {
    private int totalRevenue;

    DefaultTableModel tableModel = new DefaultTableModel() {
    //disable to edit table
        public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
        }
    };
    
    private void initTable() {
        String []cols = new String[]{"ID", "Name", "Total Orders", "Total Customers", "Total Revenue"};
        tableModel.setColumnIdentifiers(cols);
        tableModel.setRowCount(0);
        
        tableViewPromotion.setModel(tableModel);
    }
    
    private void fillTable() {
        PromotionStatisticsBUS business = new PromotionStatisticsBUS();
        List<PromotionStatisticsPOJO> promotion = business.getPromotion();
        
        totalRevenue = 0;
        tableModel.setRowCount(0);
        
        for(int i = 0; i < promotion.size(); i++){
            String id = promotion.get(i).getId();
            String name = promotion.get(i).getName();
            int totalOrders = promotion.get(i).getTotalOrders();
            int totalCustomers = promotion.get(i).getTotalCustomers();
            int revenue = promotion.get(i).getTotalRevenue();
            
            this.totalRevenue += revenue;
           
            tableModel.addRow(new String[]{id, name, "" + totalOrders, "" + totalCustomers, "" + revenue});
        }
        tableModel.fireTableDataChanged();
    }
    /**
     * Creates new form ViewStatisticPromotionFrame
     */
    public ViewDetailStatisticPromotionFrame() {
        initComponents();
        initTable();
        fillTable();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableViewPromotion = new javax.swing.JTable();
        btnBack = new javax.swing.JButton();
        btnViewTopsPromotion = new javax.swing.JButton();
        labelIconPromotion = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        jLabel2.setText("jLabel2");

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel1.setText("Promotion list");

        setTitle("View Details Promotion");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tableViewPromotion.setFont(new java.awt.Font("Arial", 0, 19)); // NOI18N
        tableViewPromotion.setModel(new javax.swing.table.DefaultTableModel(
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
        tableViewPromotion.setRowHeight(35);
        jScrollPane1.setViewportView(tableViewPromotion);

        btnBack.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnBack.setText("Back");
        btnBack.setPreferredSize(new java.awt.Dimension(110, 40));
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        btnViewTopsPromotion.setFont(new java.awt.Font("Segoe UI", 1, 15)); // NOI18N
        btnViewTopsPromotion.setText("View Tops Promotion");
        btnViewTopsPromotion.setPreferredSize(new java.awt.Dimension(197, 40));
        btnViewTopsPromotion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewTopsPromotionActionPerformed(evt);
            }
        });

        labelIconPromotion.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/banner_promotion.png"))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 25)); // NOI18N
        jLabel4.setText("Promotion list");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnViewTopsPromotion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelIconPromotion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(303, 303, 303)
                        .addComponent(jLabel4)))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnViewTopsPromotion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelIconPromotion)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>                        

    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {                                        
        // TODO add your handling code here:
        this.setVisible(false);
        ViewRevenueStatisticsFrame viewRevenueStatistics = new ViewRevenueStatisticsFrame();
        viewRevenueStatistics.setVisible(true);
    }                                       

    private void formWindowClosed(java.awt.event.WindowEvent evt) {                                  
        // TODO add your handling code here:
        ViewRevenueStatisticsFrame viewRevenueStatistics = new ViewRevenueStatisticsFrame();
        viewRevenueStatistics.setVisible(true);
    }                                 

    private void btnViewTopsPromotionActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
        ViewTopsInPromotionFrame viewTopsPromotion = new ViewTopsInPromotionFrame();
        viewTopsPromotion.setVisible(true);
    }                                                    


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
            java.util.logging.Logger.getLogger(ViewDetailStatisticPromotionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewDetailStatisticPromotionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewDetailStatisticPromotionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewDetailStatisticPromotionFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ViewDetailStatisticPromotionFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnViewTopsPromotion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelIconPromotion;
    private javax.swing.JTable tableViewPromotion;
    // End of variables declaration                   
}
