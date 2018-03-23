/*
 * Copyright (c) 2018, john
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
package cns.java;

import cns.java.models.Apprenti;
import cns.java.models.Section;
import cns.java.models.Tuteur;
import cns.java.models.Utilisateur;
import cns.java.models.Model;
import cns.java.views.MainView;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author john
 */
public class CnsJava {

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
     */
    /*public static void main(String[] args) {
        System.out.println("Hey");
        
        DataBase db = new DataBase();
        ResultSet result = db.select("SELECT * FROM utilisateurs");
        //db.update("INSERT INTO `utilisateurs` (`id_utilisateur`, `nom`, `prenom`, `mot_de_passe`) VALUES (NULL, 'test', 'test', 'tatayoyo');");
        //db.update("DELETE FROM `utilisateurs` WHERE `utilisateurs`.`nom` = 'test' AND `utilisateurs`.`prenom` = 'test' AND `utilisateurs`.`mot_de_passe` = 'tatayoyo' ;");
        
        try 
        {
            while(result.next()) 
            {
                System.out.print(result.getString("nom") + " " + result.getString("prenom"));

                System.out.println();
             }
        }
        catch(SQLException ex) 
        {
           ex.printStackTrace();
        }
    }*/
    
    /*public static void main(String[] args)
    {
        MainView view = new MainView();
        view.afficher();
    }*/
    public static void main(String[] args) throws SQLException
    {
        Section section = new Section("SLAM");
        Tuteur tuteur = new Tuteur("simon","marie","test1");
        Apprenti apprenti = new Apprenti("vaytet","matthias","test",section,tuteur);
        //System.out.println(section.getId());
        //System.out.println(tuteur.getId());
        //System.out.println(apprenti.getId());
        System.out.println(apprenti.isInDb());
        
    }
    
}
