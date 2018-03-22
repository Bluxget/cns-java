/*
 * Copyright (c) 2018, jbulach
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

/**
 *
 * @author jbulach
 */
public abstract class Utilisateur extends Model {
    
    private int id = 0;
    private String nom, prenom, mdp;
    
    public Utilisateur(String nom, String prenom, String mdp)
    {
        this.nom = nom;
        this.prenom = prenom;
        this.mdp = mdp;
    }
    
    public int getId()
    {
        return this.id;
    }
    public String getNom()
    {
        return this.nom;
    }
    public String getPrenom()
    {
        return this.prenom;
    }
    public String getMdp()
    {
        return this.mdp;
    }
    
    public void setId(int id)
    {
        this.id = id;
    }
    public void setNom(String nom)
    {
        this.nom = nom;
    }
    public void setPrenom(String prenom)
    {
        this.prenom = prenom;
    }
    public void setMdp(String mdp)
    {
        this.mdp = mdp;
    }
    public void saveUser()
    {
        if (this.id > 0)
        {
            String request = "UPDATE `utilisateurs` "
                           + "SET nom = '"+this.nom+"',  prenom = '"+this.prenom+"',  mot_de_passe = '"+this.mdp+"' "
                           + "WHERE id_utilisateur = "+this.id+" ;";
            this.db.edit(request);
        } 
        else 
        {
            String request = "INSERT INTO `utilisateurs` (`id_utilisateur`, `nom`, `prenom`, `mot_de_passe`) "
                            +"VALUES (NULL, '"+this.nom+"', '"+this.prenom+"', '"+this.mdp+"');";
            this.db.edit(request);
        }
    }
    
}
