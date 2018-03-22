/*
 * Copyright (c) 2018, Matthias
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * * Redistributions of source code must retain the above copyright notice, this
 *   list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE
 * LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR
 * CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF
 * SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS
 * INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN
 * CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE)
 * ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE
 * POSSIBILITY OF SUCH DAMAGE.
 */
package cns.java.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;


/**
 *
 * @author Matthias
 */
public class MainView extends JFrame {

    private JTable table;
 
    public MainView() {
        super();
 
        this.setTitle("CNS - Administration");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        String[] columnNames = {"Nom", "Prénom", "Mot de passe", "Status"};
        String[][] data = {
            {"Jo", "Bu", "azerty123", "Apprenti"},
            {"Hey", "Hy", "erzaet45", "Apprenti"},
            {"Oh", "Hi", "bgfdb53", "Apprenti"},
            {"Uh", "Er", "retez23", "Apprenti"}
        };
        
        JTable table = new JTable(data, columnNames);
        
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
 
        getContentPane().add(new JScrollPane(table), BorderLayout.CENTER);
 
        JPanel boutons = new JPanel();
 
        boutons.add(new JButton("Ajouter"));
        boutons.add(new JButton("Supprimer"));
 
        getContentPane().add(boutons, BorderLayout.SOUTH);
 
        pack();
    }
    
    public JTable getTable()
    {
        return this.table;
    }
    
    public void afficher()
    {
        this.setVisible(true);
    }
}
