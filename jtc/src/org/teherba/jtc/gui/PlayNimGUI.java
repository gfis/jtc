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

 /* Nim Game Application */
package org.teherba.jtc.gui;

import java.awt.Dimension;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 * Main window of the Nim Game application.
 */
public class PlayNimGUI extends JFrame {

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
     * Main method
     *
     * @param args commandline arguments (ignored)
     */
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
            java.util.logging.Logger.getLogger(PlayNimGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PlayNimGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PlayNimGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlayNimGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PlayNimGUI().setVisible(true);
            } // run
        });
    } // main

    private int humanTaken = 0;
    private int machineTaken = 0;
    private int noSticks = START_NO_STICKS;

    /**
     * No-args constructor, Creates a new form for the Nim game
     */
    public PlayNimGUI() {
        noSticks = START_NO_STICKS;
        initComponents();
        getRootPane().setDefaultButton(takeButton);
        noSticksField.setText(String.valueOf(noSticks));
        pack();
        humanTakenField.requestFocusInWindow();
        // Center in the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = getSize();
        setLocation(new Point((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.width) / 2));
    } // Constructor()

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        mainPanel = new javax.swing.JPanel();
        remainingLabel = new javax.swing.JLabel();
        noSticksField = new javax.swing.JTextField();
        youTakeLabel = new javax.swing.JLabel();
        humanTakenField = new javax.swing.JTextField();
        machineTakenField = new javax.swing.JLabel();
        buttonsPanel = new javax.swing.JPanel();
        takeButton = new javax.swing.JButton();
        newGameButton = new javax.swing.JButton();
        mainMenu = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        aboutMenuItem = new javax.swing.JMenuItem();
        exitMenuItem = new javax.swing.JMenuItem();

        setTitle("Nim Game");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                exitForm(evt);
            }
        });

        mainPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 12, 12, 12));
        mainPanel.setMinimumSize(new java.awt.Dimension(297, 200));
        mainPanel.setLayout(new java.awt.GridBagLayout());

        remainingLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        remainingLabel.setText("Remaining sticks:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 6);
        mainPanel.add(remainingLabel, gridBagConstraints);

        noSticksField.setEditable(false);
        noSticksField.setColumns(20);
        noSticksField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 12, 0);
        mainPanel.add(noSticksField, gridBagConstraints);

        youTakeLabel.setDisplayedMnemonic('Y');
        youTakeLabel.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        youTakeLabel.setLabelFor(humanTakenField);
        youTakeLabel.setText("You take:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 6);
        mainPanel.add(youTakeLabel, gridBagConstraints);

        humanTakenField.setColumns(20);
        humanTakenField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        mainPanel.add(humanTakenField, gridBagConstraints);

        machineTakenField.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        machineTakenField.setText(" ");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 20, 0);
        mainPanel.add(machineTakenField, gridBagConstraints);

        buttonsPanel.setLayout(new java.awt.GridBagLayout());

        takeButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        takeButton.setMnemonic('G');
        takeButton.setText("Take");
        takeButton.setToolTipText("Take the number of sticks");
        takeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                humanTakeActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 6);
        buttonsPanel.add(takeButton, gridBagConstraints);

        newGameButton.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        newGameButton.setMnemonic('N');
        newGameButton.setText("New Game");
        newGameButton.setToolTipText("Start a new game");
        newGameButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newGameButtonActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.gridheight = java.awt.GridBagConstraints.REMAINDER;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.SOUTHEAST;
        gridBagConstraints.weighty = 1.0;
        buttonsPanel.add(newGameButton, gridBagConstraints);

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
        new AboutNim(this).setVisible(true);
    }//GEN-LAST:event_aboutMenuItemActionPerformed

    private void newGameButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newGameButtonActionPerformed
        noSticks = START_NO_STICKS;
        machineTakenField.setText(" ");
        noSticksField.setText(String.valueOf(noSticks));
        humanTakenField.setText("");
        getRootPane().setDefaultButton(takeButton);
        humanTakenField.requestFocusInWindow();
    }//GEN-LAST:event_newGameButtonActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        System.exit(0);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void humanTakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_humanTakeActionPerformed
        humanTaken = Integer.parseInt(humanTakenField.getText());
        if (humanTaken < MIN_TAKE || humanTaken > MAX_TAKE) {
            machineTakenField.setText("Please take "
                    + String.valueOf(MIN_TAKE) + " to "
                    + String.valueOf(MAX_TAKE) + " sticks.");
            getRootPane().setDefaultButton(takeButton);
            humanTakenField.setText("");
            humanTakenField.requestFocusInWindow();
        } else { // humanTaken in range
            noSticks -= humanTaken;
            if (noSticks == 1) {
                machineTakenField.setText("Good! You won!");
                noSticks = START_NO_STICKS;
                noSticksField.setText(String.valueOf(noSticks));
                getRootPane().setDefaultButton(takeButton);
                humanTakenField.setText("");
                humanTakenField.requestFocusInWindow();
            } else if (noSticks < 1) {
                machineTakenField.setText("You could have won.");
                noSticks -= START_NO_STICKS;
                noSticksField.setText(String.valueOf(noSticks));
                getRootPane().setDefaultButton(takeButton);
                humanTakenField.setText("");
                humanTakenField.requestFocusInWindow();
            } else { // normal
                int diffMagic = noSticks - getNearestMagic(noSticks);
                if (diffMagic == 0) {
                    machineTaken = randomNumber();

                } else {
                    machineTaken = diffMagic;
                }
                noSticks -= machineTaken;
                if (noSticks == 1) { // at the end
                    machineTakenField.setText("Bad - I took "
                            + String.valueOf(machineTaken)
                            + (machineTaken <= 1 ? " stick" : " sticks"
                            + " and I won."));
                    noSticks = START_NO_STICKS;
                    noSticksField.setText(String.valueOf(noSticks));
                    getRootPane().setDefaultButton(takeButton);
                    humanTakenField.setText("");
                    humanTakenField.requestFocusInWindow();
                } else { // not at the end
                    machineTakenField.setText("I took "
                            + String.valueOf(machineTaken)
                            + (machineTaken <= 1 ? " stick." : " sticks."));
                    noSticksField.setText(String.valueOf(noSticks));
                    getRootPane().setDefaultButton(takeButton);
                    humanTakenField.setText("");
                    humanTakenField.requestFocusInWindow();
                } // not at the end
            } // normal
        } // in range
    }//GEN-LAST:event_humanTakeActionPerformed

    private void exitForm(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_exitForm
        System.exit(0);
    }//GEN-LAST:event_exitForm

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem aboutMenuItem;
    private javax.swing.JPanel buttonsPanel;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JTextField humanTakenField;
    private javax.swing.JLabel machineTakenField;
    private javax.swing.JMenuBar mainMenu;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton newGameButton;
    private javax.swing.JTextField noSticksField;
    private javax.swing.JLabel remainingLabel;
    private javax.swing.JButton takeButton;
    private javax.swing.JLabel youTakeLabel;
    // End of variables declaration//GEN-END:variables

}
