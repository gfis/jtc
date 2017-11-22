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

 /* Anagram Game Application */
package org.teherba.jtc.game;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Main window of the Anagram Game application.
 */
public class PlayNimSwing extends JFrame {

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
            java.util.logging.Logger.getLogger(PlayNimSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayNimSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayNimSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayNimSwing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PlayNimSwing().setVisible(true);
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

    /**
     * Get the nearest magic number <= to the parameter. The magic number for
     * MAX_TAKE = 3 are 1, 5, 9, 13, 17 and so on. The general formula is magic
     * = 1 + MAX_TAKE * n. @param noSticks current number of sticks; the result
     * must be <= this value @return the nearest random number
     */
    public int getNearestMagic(int noSticks) {
        return ((noSticks - 1) / (MAX_TAKE + 1)) * (MAX_TAKE + 1) + 1;
    } // getNearestMagic

    /**
     * Shows the sticks in the field
     */
    public void showSticks(int noSticks) {
        StringBuffer value = new StringBuffer(128);
        int ist = 1;
        while (ist <= noSticks) {
            value.append("|");
            if (ist % 5 == 0) {
                value.append(" ");
            }
            ist ++;
        } // while ist
        value.append(" (");
        value.append(String.valueOf(noSticks));
        value.append(")");
        noSticksText.setText(value.toString());
    } // showSticks

    private int humanTaken = 0;
    private int machineTaken = 0;
    private int noSticks = START_NO_STICKS;

    /**
     * No-args constructor: creates new form for Nim game
     */
    public PlayNimSwing() {
        noSticks = START_NO_STICKS;
        initComponents();
        getRootPane().setDefaultButton(takeButton);
        showSticks(noSticks);
        pack();
        humanTakenText.requestFocusInWindow();
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
        remainingLabel = new javax.swing.JLabel();
        noSticksText = new javax.swing.JTextField();
        takeLabel = new javax.swing.JLabel();
        humanTakenText = new javax.swing.JTextField();
        machineTakenLabel = new javax.swing.JLabel();
        buttonsPanel = new javax.swing.JPanel();
        takeButton = new javax.swing.JButton();
        newGame = new javax.swing.JButton();
        mainMenu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setTitle("Nim Game");
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

        remainingLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        remainingLabel.setText("Remaining sticks:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 6);
        mainPanel.add(remainingLabel, gridBagConstraints);

        noSticksText.setEditable(false);
        noSticksText.setBackground(new java.awt.Color(255, 255, 204));
        noSticksText.setColumns(20);
        noSticksText.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        mainPanel.add(noSticksText, gridBagConstraints);

        takeLabel.setDisplayedMnemonic('Y');
        takeLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        takeLabel.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        takeLabel.setLabelFor(humanTakenText);
        takeLabel.setText("You take:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 6);
        mainPanel.add(takeLabel, gridBagConstraints);

        humanTakenText.setColumns(20);
        humanTakenText.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        mainPanel.add(humanTakenText, gridBagConstraints);

        machineTakenLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        machineTakenLabel.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        mainPanel.add(machineTakenLabel, gridBagConstraints);

        buttonsPanel.setBackground(new java.awt.Color(255, 255, 204));
        buttonsPanel.setLayout(new java.awt.GridBagLayout());

        takeButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        takeButton.setMnemonic('T');
        takeButton.setText("Take");
        takeButton.setToolTipText("Take 1 to 3 sticks");
        takeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humanTakenActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 6);
        buttonsPanel.add(takeButton, gridBagConstraints);

        newGame.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        newGame.setMnemonic('N');
        newGame.setText("New Game");
        newGame.setToolTipText("Start anew game");
        newGame.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weighty = 1.0;
        buttonsPanel.add(newGame, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        mainPanel.add(buttonsPanel, gridBagConstraints);

        getContentPane().add(mainPanel, java.awt.BorderLayout.CENTER);

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
        new AboutPlayNim(this).setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void newGameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameActionPerformed
        machineTakenLabel.setText("");
        showSticks(noSticks);
        humanTakenText.setText("");
        getRootPane().setDefaultButton(takeButton);
        humanTakenText.requestFocusInWindow();
    }//GEN-LAST:event_newGameActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void humanTakenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_humanTakenActionPerformed
        try {
            humanTaken = Integer.parseInt(humanTakenText.getText());
        } catch (Exception exc) {
            humanTaken = 0;
        }
        if (humanTaken < MIN_TAKE || humanTaken > MAX_TAKE) {
            machineTakenLabel.setText("You must enter a number between "
                    + String.valueOf(MIN_TAKE) + " and "
                    + String.valueOf(MAX_TAKE) + ".");
        } else { // human entered correct number
            if (noSticks - humanTaken < 1) {
                machineTakenLabel.setText("Bad! You could have reached 1, but you lost.");
                noSticks = START_NO_STICKS;
            } else if (noSticks - humanTaken == 1) { // human wins
                machineTakenLabel.setText("Good! You won!");
                noSticks = START_NO_STICKS;
            } else { // game goes on: machine takes
                noSticks -= humanTaken;
                int diffMagic = noSticks - getNearestMagic(noSticks);
                if (diffMagic == 0) { // human is good so far
                    machineTaken = randomNumber();
                } else { // human will loose
                    machineTaken = diffMagic;
                }
                noSticks -= machineTaken;
                if (noSticks == 1) {
                    machineTakenLabel.setText("Bad for you!"
                            + "I took " + String.valueOf(machineTaken)
                            + " and won!");
                    noSticks = START_NO_STICKS;
                } else { // game goes on
                    machineTakenLabel.setText(""
                            + "I took " + String.valueOf(machineTaken)
                            + ".");
                } // game goes on
            } // game goes on
            showSticks(noSticks);
            humanTakenText.setText("");
            getRootPane().setDefaultButton(takeButton);
            humanTakenText.requestFocusInWindow();
        } // correct number
    }//GEN-LAST:event_humanTakenActionPerformed

    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JTextField humanTakenText;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JLabel machineTakenLabel;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton newGame;
    private javax.swing.JTextField noSticksText;
    private javax.swing.JLabel remainingLabel;
    private javax.swing.JButton takeButton;
    private javax.swing.JLabel takeLabel;
    // End of variables declaration//GEN-END:variables

}
