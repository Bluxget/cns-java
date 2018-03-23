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

/**
 *
 * @author Matthias
 */
public class Apprenti extends Utilisateur{
    
    private Section section;
    private Tuteur tuteur;
    
    public Apprenti(String nom, String prenom, String mdp) throws SQLException//, Section section, Tuteur tuteur) throws SQLException
    {
        super(nom, prenom, mdp);
        //this.section = section;
        //this.tuteur = tuteur;
    }
    public Section getSection()
    {
        return this.section;
    }
    public Tuteur getTuteur()
    {
        return this.tuteur;
    }
    public void setSection(Section section)
    {
        this.section = section;
    }
    public void setTuteur(Tuteur tuteur)
    {
        this.tuteur = tuteur;
    }
    @Override
    public void saveUser() throws SQLException
    {   
        if (this.getId() > 0)
        {
            String request = "UPDATE `utilisateurs` "
                           + "SET nom = '"+this.getNom()+"',  prenom = '"+this.getPrenom()+"',  mot_de_passe = '"+this.getMdp()+"' "
                           + "WHERE id_utilisateur = "+this.getId()+" ;";
            this.db.edit(request);
        } 
        else 
        {
            String request = "INSERT INTO `utilisateurs` (`id_utilisateur`, `nom`, `prenom`, `mot_de_passe`) "
                            +"VALUES (NULL, '"+this.getNom()+"', '"+this.getPrenom()+"', '"+this.getMdp()+"');";
            this.db.edit(request);
            
        }
        if (this.isInApprenti())
        {
            String request = "UPDATE `apprentis` "
                           + "SET id_utilisateur = '"+this.getId()+"',  id_section = '"+this.section.getId()+"',  id_tuteur = '"+this.tuteur.getId()+"' "
                           + "WHERE id_utilisateur = "+this.getId()+" ;";
            this.db.edit(request);
        }
        else
        {
            String request = "INSERT INTO `apprentis` (`id_utilisateur`, `id_section`, `id_tuteur`) "
                            +"VALUES ('"+this.getId()+"', '"+this.section.getId()+"', '"+this.tuteur.getId()+"');";
            this.db.edit(request);
        }
    }
    @Override
    public void deleteUser()
    {
        if (this.getId() > 0)
        {
            String request = "DELETE FROM `Apprentis` "
                           + "WHERE id_utilisateur = "+this.getId()+" ;";
            this.db.edit(request);
            request = "DELETE FROM `utilisateurs` "
                    + "WHERE id_utilisateur = "+this.getId()+" ;";
            this.db.edit(request);
        } 
    }
    public boolean isInApprenti() throws SQLException
    {
        if (this.getId() != 0)
        {
            String request = "SELECT id_utilisateur FROM apprentis "
                           + "WHERE id_utilisateur = "+this.getId()+" "
                           + "AND id_section = "+this.section.getId()+" "
                           + "AND id_tuteur = "+this.tuteur.getId()+" ;";
            ResultSet result = this.db.select(request);
            return result.next();
        }
        else{return false;}
    }
}

