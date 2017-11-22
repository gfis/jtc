/*
 * Copyright (c) 2010, Oracle.
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 *  * Redistributions of source code must retain the above copyright notice,
 *    this list of conditions and the following disclaimer.
 *  * Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the distribution.
 *  * Neither the name of Oracle nor the names of its
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT 
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, 
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED 
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR
 * PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF
 * LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 * NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. 
 */

 /* Rational Test Application */
package org.teherba.jtc.math;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Main window of the Anagram Game application.
 */
public class RationalTestSwing extends JFrame {

    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            javax.swing.UIManager.LookAndFeelInfo[] installedLookAndFeels = javax.swing.UIManager.getInstalledLookAndFeels();
            for (int idx = 0; idx < installedLookAndFeels.length; idx++) {
                if ("Nimbus".equals(installedLookAndFeels[idx].getName())) {
                    javax.swing.UIManager.setLookAndFeel(installedLookAndFeels[idx].getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(RationalTestSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(RationalTestSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(RationalTestSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(RationalTestSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new RationalTestSwing().setVisible(true);
            }
        });
    } // main

    /**
     * minimum number of sticks to be taken by each player
     */
    private static final int MIN_TAKE = 1;
    /**
     * maximum number of sticks to be taken by each player
     */
    private static final int MAX_TAKE = 3;
    /**
     * starting number of sticks
     */
    private static final int START_NO_STICKS = 19;

    /**
     * Get a random number between (including) MIN_TAKE and MAX_TAKE
     *
     * @return random number
     */
    public int randomNumber() {
        return (new Double(Math.random() * MAX_TAKE + MIN_TAKE)).intValue();
        // random() yields >= 0.0 and < 1.0 -> 1..3
    } // randomNumber

    /** the components of the Rationals will be lower than this cconstant. */
    private static final int MAX_NUM = 8;
    /**
     * Get a random {@link Rational}
     *
     * @return random fraction
     */
    public Rational getRandomRational() {
        int numerator   = (new Double(Math.random() * MAX_NUM + 1)).intValue();
        int denominator = (new Double(Math.random() * MAX_NUM + 1)).intValue();
        return (new Rational(numerator, denominator)).reduce();
    } // randomNumber

    /** List of possible arithmetic operators */
    private static final String OPERATORS = "+-*/";
    /**
     * Get a random operator: of 0,1,2,3 for "+", "-", "*" or "/"
     */
    public int getRandomOperator() {
        return (new Double(Math.random() * 4)).intValue();
    } // getNearestMagic

    /**
     * No-args constructor: creates new form for Nim game
     */
    public RationalTestSwing() {
        initComponents();
        getRootPane().setDefaultButton(enterButton);
        pack();
        newExpression();
        answerText.requestFocusInWindow();
        // Center in the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(new Point((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.width) / 2));
    } // Constructor

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        mainPanel = new javax.swing.JPanel();
        computeLabel = new javax.swing.JLabel();
        computeText = new javax.swing.JTextField();
        answerLabel = new javax.swing.JLabel();
        answerText = new javax.swing.JTextField();
        messageText = new javax.swing.JLabel();
        buttonsPanel = new javax.swing.JPanel();
        enterButton = new javax.swing.JButton();
        newButton = new javax.swing.JButton();
        mainMenu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setTitle("Rational Test");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        mainPanel.setBackground(new java.awt.Color(255, 255, 204));
        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        mainPanel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        mainPanel.setMinimumSize(new java.awt.Dimension(297, 200));
        mainPanel.setLayout(new java.awt.GridBagLayout());

        computeLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        computeLabel.setText("Compute and simplify:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 6);
        mainPanel.add(computeLabel, gridBagConstraints);

        computeText.setEditable(false);
        computeText.setBackground(new java.awt.Color(255, 255, 204));
        computeText.setColumns(20);
        computeText.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        mainPanel.add(computeText, gridBagConstraints);

        answerLabel.setDisplayedMnemonic('Y');
        answerLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        answerLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        answerLabel.setLabelFor(answerText);
        answerLabel.setText("Your answer:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 6);
        mainPanel.add(answerLabel, gridBagConstraints);

        answerText.setColumns(20);
        answerText.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        mainPanel.add(answerText, gridBagConstraints);

        messageText.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        messageText.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        mainPanel.add(messageText, gridBagConstraints);

        buttonsPanel.setBackground(new java.awt.Color(255, 255, 204));
        buttonsPanel.setLayout(new java.awt.GridBagLayout());

        enterButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        enterButton.setMnemonic('E');
        enterButton.setText("Enter");
        enterButton.setToolTipText("Check the answer");
        enterButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answerActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 6);
        buttonsPanel.add(enterButton, gridBagConstraints);

        newButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        newButton.setMnemonic('N');
        newButton.setText("New Expression");
        newButton.setToolTipText("Show another expression");
        newButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weighty = 1.0;
        buttonsPanel.add(newButton, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(buttonsPanel, gridBagConstraints);

        getContentPane().add(mainPanel, java.awt.BorderLayout.LINE_START);

        fileMenu.setMnemonic('F');
        fileMenu.setText("File");
        fileMenu.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        aboutMenuItem.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        aboutMenuItem.setMnemonic('A');
        aboutMenuItem.setText("About");
        aboutMenuItem.setToolTipText("About");
        aboutMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aboutMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(aboutMenuItem);

        exitMenuItem.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        exitMenuItem.setMnemonic('E');
        exitMenuItem.setText("Exit");
        exitMenuItem.setToolTipText("Quit Team, Quit!");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        mainMenu.add(fileMenu);

        setJMenuBar(mainMenu);
    }// </editor-fold>//GEN-END:initComponents

    private void aboutMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aboutMenuItemActionPerformed
        new AboutRationalTest(this).setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    /** The Rational which is presented as question */
    private Rational wanted;
    
    /** Shows a new Rational expression 
     */
    private void newExpression() {
        Rational op1 = getRandomRational();
        Rational op2 = getRandomRational();
        int oper     = getRandomOperator(); 
        String operText = OPERATORS.substring(oper, oper + 1);
        String otext1 = op1.toString(operText);
        String otext2 = op2.toString(operText);
        String wantedText = otext1 + " " + operText + " " + otext2;
        switch (oper) {
            case 0: // +
                wanted = op1.add(op2);
                break;
            case 1: // -
                wanted = op1.subtract(op2);
                wantedText = otext1 + " - " + otext2;
                break;
            case 2: // *
                wanted = op1.multiply(op2);
                wantedText = otext1 + " * " + otext2;
                break;
            case 3: // /
                wanted = op1.divide(op2);
                wantedText = otext1 + " / " + otext2;
                break;
            default:
                wantedText = "internal error";
                break;
        } // switch
        computeText.setText(wantedText);
        messageText.setText("");
        answerText.setText("");
        getRootPane().setDefaultButton(enterButton);
        answerText.requestFocusInWindow();        
    } // newExpression
    
    private void newButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newButtonActionPerformed
        newExpression();
    }//GEN-LAST:event_newButtonActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void answerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answerActionPerformed
        Rational answer = new Rational(answerText.getText());
        if (answer.compareTo(wanted) == 0) { // ok
            newExpression();
            messageText.setText("Ok!");
        } else { // wrong answer
            messageText.setText("No! Please try again.");
        } // wrong answer
        answerText.setText("");
        getRootPane().setDefaultButton(enterButton);
        answerText.requestFocusInWindow();
    }//GEN-LAST:event_answerActionPerformed

    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JLabel answerLabel;
    private javax.swing.JTextField answerText;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JLabel computeLabel;
    private javax.swing.JTextField computeText;
    private javax.swing.JButton enterButton;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel messageText;
    private javax.swing.JButton newButton;
    // End of variables declaration//GEN-END:variables

}
