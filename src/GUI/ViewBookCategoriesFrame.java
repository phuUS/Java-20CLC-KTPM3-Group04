/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import BUS.CategoryBUS;
import POJO.CategoryPOJO;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.table.*;
import GUI.AddNewCategoryFrame;
import GUI.EditCategoryFrame;
import javax.swing.JTextField;

/**
 *
 * @author bachl
 */
public class ViewBookCategoriesFrame extends javax.swing.JFrame {
    int typeTable;
    String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    DefaultTableModel tableModel = new DefaultTableModel() {
        // disable to edit table
        public boolean isCellEditable(int rowIndex, int mColIndex) {
            return false;
        }
    };

    /**
     * Creates new form ViewBookCategoriesFrame
     */
    public ViewBookCategoriesFrame(String username) {
        setUsername(username);
        initComponents();
        initTable();
        initGroupSortCategory();
        this.setLocationRelativeTo(null);
    }

    public void fillTable(List<CategoryPOJO> categories) {
        tableModel.setRowCount(0);

        for (int i = 0; i < categories.size(); i++) {
            String id = categories.get(i).getId();
            String name = categories.get(i).getName();
            String description = categories.get(i).getDescription();
            boolean isEnabled = categories.get(i).isIsEnabled();
            String isEnabledStr = null;

            if (isEnabled) {
                isEnabledStr = "Yes";
            } else {
                isEnabledStr = "No";
            }

            tableModel.addRow(new String[] { id, name, description, isEnabledStr });
        }
        tableModel.fireTableDataChanged();
    }

    public void initGroupSortCategory() {
        ButtonGroup groupID = new ButtonGroup();
        groupID.add(radioStoLId);
        groupID.add(radioLtoSId);

        ButtonGroup groupName = new ButtonGroup();
        groupID.add(radioStoLName);
        groupID.add(radioLtoSName);
    }

    public void initTable() {
        String[] cols = new String[] { "ID", "Name", "Description", "Enabled" };
        tableModel.setColumnIdentifiers(cols);
        tableModel.setRowCount(0);

        tableViewCategories.setModel(tableModel);
        radioStoLId.setSelected(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelHandelViewCategories = new javax.swing.JPanel();
        btnAddNewCategory = new javax.swing.JButton();
        btnViewCategories = new javax.swing.JButton();
        btnViewDisabledList = new javax.swing.JButton();
        textFieldSearch = new javax.swing.JTextField();
        btnSearchCategory = new javax.swing.JButton();
        labelSortId = new javax.swing.JLabel();
        labelSortName = new javax.swing.JLabel();
        radioStoLId = new javax.swing.JRadioButton();
        radioLtoSId = new javax.swing.JRadioButton();
        radioStoLName = new javax.swing.JRadioButton();
        radioLtoSName = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableViewCategories = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Book categories");
        setName("Search by ID or Name"); // NOI18N
        setPreferredSize(new java.awt.Dimension(993, 680));
        setResizable(false);

        panelHandelViewCategories.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        panelHandelViewCategories.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        panelHandelViewCategories.setPreferredSize(new java.awt.Dimension(170, 715));

        btnAddNewCategory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnAddNewCategory.setText("Add new category");
        btnAddNewCategory.setMaximumSize(new java.awt.Dimension(169, 40));
        btnAddNewCategory.setMinimumSize(new java.awt.Dimension(169, 40));
        btnAddNewCategory.setPreferredSize(new java.awt.Dimension(169, 40));
        btnAddNewCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddNewCategoryActionPerformed(evt);
            }
        });

        btnViewCategories.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnViewCategories.setText("View categories");
        btnViewCategories.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnViewCategories.setMaximumSize(new java.awt.Dimension(169, 40));
        btnViewCategories.setMinimumSize(new java.awt.Dimension(169, 40));
        btnViewCategories.setPreferredSize(new java.awt.Dimension(169, 40));
        btnViewCategories.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewCategoriesActionPerformed(evt);
            }
        });

        btnViewDisabledList.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnViewDisabledList.setText("View disabled list");
        btnViewDisabledList.setPreferredSize(new java.awt.Dimension(169, 40));
        btnViewDisabledList.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnViewDisabledListActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelHandelViewCategoriesLayout = new javax.swing.GroupLayout(
                panelHandelViewCategories);
        panelHandelViewCategories.setLayout(panelHandelViewCategoriesLayout);
        panelHandelViewCategoriesLayout.setHorizontalGroup(
                panelHandelViewCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelHandelViewCategoriesLayout.createSequentialGroup()
                                .addGroup(panelHandelViewCategoriesLayout
                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(btnViewCategories, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnViewDisabledList, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnAddNewCategory, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE)));
        panelHandelViewCategoriesLayout.setVerticalGroup(
                panelHandelViewCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelHandelViewCategoriesLayout.createSequentialGroup()
                                .addComponent(btnViewCategories, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnViewDisabledList, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAddNewCategory, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 581, Short.MAX_VALUE)));

        textFieldSearch.setForeground(new java.awt.Color(153, 153, 153));
        textFieldSearch.setText("Search by ID or Name");
        textFieldSearch.setMargin(new java.awt.Insets(2, 10, 2, 6));
        textFieldSearch.setMinimumSize(new java.awt.Dimension(96, 40));
        textFieldSearch.setPreferredSize(new java.awt.Dimension(96, 40));
        textFieldSearch.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textFieldSearchMouseClicked(evt);
            }
        });
        textFieldSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textFieldSearchActionPerformed(evt);
            }
        });

        btnSearchCategory.setBackground(new java.awt.Color(204, 255, 204));
        btnSearchCategory.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        btnSearchCategory.setText("Search");
        btnSearchCategory.setMaximumSize(new java.awt.Dimension(110, 40));
        btnSearchCategory.setMinimumSize(new java.awt.Dimension(108, 40));
        btnSearchCategory.setPreferredSize(new java.awt.Dimension(100, 40));
        btnSearchCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchCategoryActionPerformed(evt);
            }
        });

        labelSortId.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSortId.setText("Sort by ID:");

        labelSortName.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        labelSortName.setText("Sort by Name:");

        radioStoLId.setText("Smallest to Largest");
        radioStoLId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioStoLIdActionPerformed(evt);
            }
        });

        radioLtoSId.setText("Largest to Smallest");
        radioLtoSId.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioLtoSIdActionPerformed(evt);
            }
        });

        radioStoLName.setText("Smallest to Largest");
        radioStoLName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioStoLNameActionPerformed(evt);
            }
        });

        radioLtoSName.setText("Largest to Smallest");
        radioLtoSName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioLtoSNameActionPerformed(evt);
            }
        });

        tableViewCategories.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null },
                        { null, null, null, null }
                },
                new String[] {
                        "Title 1", "Title 2", "Title 3", "Title 4"
                }) {
            boolean[] canEdit = new boolean[] {
                    false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        tableViewCategories.setPreferredSize(new java.awt.Dimension(687, 430));
        tableViewCategories.setRowHeight(35);
        tableViewCategories.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableViewCategoriesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tableViewCategories);
        if (tableViewCategories.getColumnModel().getColumnCount() > 0) {
            tableViewCategories.getColumnModel().getColumn(0).setResizable(false);
            tableViewCategories.getColumnModel().getColumn(0).setPreferredWidth(50);
            tableViewCategories.getColumnModel().getColumn(1).setResizable(false);
            tableViewCategories.getColumnModel().getColumn(1).setPreferredWidth(100);
            tableViewCategories.getColumnModel().getColumn(2).setResizable(false);
            tableViewCategories.getColumnModel().getColumn(2).setPreferredWidth(387);
            tableViewCategories.getColumnModel().getColumn(3).setResizable(false);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelHandelViewCategories, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(65, 65, 65)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(textFieldSearch, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btnSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
                                                .createSequentialGroup()
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(radioStoLId)
                                                        .addComponent(radioLtoSId)
                                                        .addComponent(labelSortId))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(labelSortName)
                                                        .addComponent(radioLtoSName)
                                                        .addComponent(radioStoLName)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 687,
                                                Short.MAX_VALUE))
                                .addGap(71, 71, 71)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(panelHandelViewCategories, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(textFieldSearch, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnSearchCategory, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 430,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(labelSortId)
                                        .addComponent(labelSortName))
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(radioStoLId)
                                        .addComponent(radioStoLName))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(radioLtoSId)
                                        .addComponent(radioLtoSName))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void radioLtoSIdActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioLtoSIdActionPerformed
        // TODO add your handling code here:
        String typeSort = "id";
        String orderSort = "desc";

        CategoryBUS business = new CategoryBUS();
        List<CategoryPOJO> categories = null;

        if (typeTable == 1) {
            categories = business.getEnabledAllSorted(typeSort, orderSort);
        } else {
            categories = business.getDisabledAllSorted(typeSort, orderSort);
        }

        fillTable(categories);
    }// GEN-LAST:event_radioLtoSIdActionPerformed

    private void btnViewCategoriesActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnViewCategoriesActionPerformed
        // TODO add your handling code here:
        this.typeTable = 1;
        CategoryBUS business = new CategoryBUS();
        List<CategoryPOJO> categories = business.getEnabledAll();

        fillTable(categories);
    }// GEN-LAST:event_btnViewCategoriesActionPerformed

    private void textFieldSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_textFieldSearchActionPerformed
        // TODO add your handling code here:
    }// GEN-LAST:event_textFieldSearchActionPerformed

    private void btnSearchCategoryActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnSearchCategoryActionPerformed
        // TODO add your handling code here:
        String keyWords = textFieldSearch.getText();
        CategoryBUS business = new CategoryBUS();
        CategoryPOJO category = business.getCategory(keyWords);

        if (category != null) {
            String id = category.getId();
            String name = category.getName();
            String description = category.getDescription();

            tableModel.setRowCount(0);
            tableModel.addRow(new String[] { id, name, description });
            tableModel.fireTableDataChanged();
        } else {
            JOptionPane.showMessageDialog(rootPane, "Not found any category!");
        }
    }// GEN-LAST:event_btnSearchCategoryActionPerformed

    private void textFieldSearchMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_textFieldSearchMouseClicked
        // TODO add your handling code here:
        textFieldSearch.setText("");
    }// GEN-LAST:event_textFieldSearchMouseClicked

    private void radioStoLIdActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioStoLIdActionPerformed
        // TODO add your handling code here:
        String typeSort = "id";
        String orderSort = "asc";

        CategoryBUS business = new CategoryBUS();
        List<CategoryPOJO> categories = null;

        if (typeTable == 1) {
            categories = business.getEnabledAllSorted(typeSort, orderSort);
        } else {
            categories = business.getDisabledAllSorted(typeSort, orderSort);
        }

        fillTable(categories);
    }// GEN-LAST:event_radioStoLIdActionPerformed

    private void radioStoLNameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioStoLNameActionPerformed
        // TODO add your handling code here:
        String typeSort = "name";
        String orderSort = "asc";

        CategoryBUS business = new CategoryBUS();
        List<CategoryPOJO> categories = null;

        if (typeTable == 1) {
            categories = business.getEnabledAllSorted(typeSort, orderSort);
        } else {
            categories = business.getDisabledAllSorted(typeSort, orderSort);
        }

        fillTable(categories);
    }// GEN-LAST:event_radioStoLNameActionPerformed

    private void radioLtoSNameActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_radioLtoSNameActionPerformed
        // TODO add your handling code here:
        String typeSort = "name";
        String orderSort = "desc";

        CategoryBUS business = new CategoryBUS();
        List<CategoryPOJO> categories = null;

        if (typeTable == 1) {
            categories = business.getEnabledAllSorted(typeSort, orderSort);
        } else {
            categories = business.getDisabledAllSorted(typeSort, orderSort);
        }

        fillTable(categories);
    }// GEN-LAST:event_radioLtoSNameActionPerformed

    private void btnAddNewCategoryActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnAddNewCategoryActionPerformed
        // TODO add your handling code here:
        AddNewCategoryFrame addNewCategory = new AddNewCategoryFrame();

        addNewCategory.setVisible(true);
    }// GEN-LAST:event_btnAddNewCategoryActionPerformed

    private void tableViewCategoriesMouseClicked(java.awt.event.MouseEvent evt) {// GEN-FIRST:event_tableViewCategoriesMouseClicked
        // TODO add your handling code here:
        // Get double clicked
        if (evt.getClickCount() == 2 && !evt.isConsumed()) {
            evt.consume();

            int selectedRow = tableViewCategories.getSelectedRow();
            String idCategory = tableViewCategories.getValueAt(selectedRow, 0).toString();
            String nameCategory = tableViewCategories.getValueAt(selectedRow, 1).toString();
            String descriptionCategory = tableViewCategories.getValueAt(selectedRow, 2).toString();
            String isEnabledCategoryStr = tableViewCategories.getValueAt(selectedRow, 3).toString();
            boolean isEnabledCategory;

            if (isEnabledCategoryStr.equals("Yes")) {
                isEnabledCategory = true;
            } else {
                isEnabledCategory = false;
            }

            EditCategoryFrame editCategory = new EditCategoryFrame(idCategory,
                    nameCategory, descriptionCategory, isEnabledCategory);

            editCategory.setVisible(true);
        }
    }// GEN-LAST:event_tableViewCategoriesMouseClicked

    private void btnViewDisabledListActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_btnViewDisabledListActionPerformed
        // TODO add your handling code here:
        this.typeTable = 0;
        CategoryBUS business = new CategoryBUS();
        List<CategoryPOJO> categories = business.getDisabledAll();

        fillTable(categories);
    }// GEN-LAST:event_btnViewDisabledListActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ViewBookCategoriesFrame.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ViewBookCategoriesFrame.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ViewBookCategoriesFrame.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ViewBookCategoriesFrame.class.getName())
                    .log(java.util.logging.Level.SEVERE, null, ex);
        }
        // </editor-fold>

        /* Create and display the form */
        // java.awt.EventQueue.invokeLater(new Runnable() {
        // public void run() {
        // new ViewBookCategoriesFrame().setVisible(true);
        // }
        // });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAddNewCategory;
    private javax.swing.JButton btnSearchCategory;
    private javax.swing.JButton btnViewCategories;
    private javax.swing.JButton btnViewDisabledList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelSortId;
    private javax.swing.JLabel labelSortName;
    private javax.swing.JPanel panelHandelViewCategories;
    private javax.swing.JRadioButton radioLtoSId;
    private javax.swing.JRadioButton radioLtoSName;
    private javax.swing.JRadioButton radioStoLId;
    private javax.swing.JRadioButton radioStoLName;
    private javax.swing.JTable tableViewCategories;
    private javax.swing.JTextField textFieldSearch;
    // End of variables declaration//GEN-END:variables
}
