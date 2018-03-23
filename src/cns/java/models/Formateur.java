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
package cns.java.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Matthias
 */
public class Formateur extends Utilisateur{
    
    private List<Section> listeSections;
    
    public Formateur(String nom, String prenom, String mdp) throws SQLException
    {
        super(nom, prenom, mdp);
        this.setSectionsList();
    }
    private void setSectionsList() throws SQLException
    {
        if (this.getId() > 0)
        {   
            ResultSet result = this.db.select("SELECT formateurs_sections.id_section as id_section, sections.nom as nom "
                                       + "FROM `formateurs_sections` "
                                       + "JOIN sections ON formateurs_sections.id_section = sections.id_section "
                                       + "WHERE formateurs_sections.id_formateur = "+this.getId()+" ;");
            try 
            {
                while(result.next()) 
                {
                    
                    Section section = new Section(result.getString("nom"));
                    this.listeSections.add(section);
                 }
            }
            catch(SQLException ex) 
            {
               ex.printStackTrace();
            }
        }
    }
    
    public void addSection(Section section)
    {
        this.listeSections.add(section);
    }
}
