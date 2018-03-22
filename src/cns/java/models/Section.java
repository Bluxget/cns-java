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
public class Section extends Model{
    
    private int id = 0;
    private String nom;
    
    public Section(String nom) throws SQLException
    {
        this.nom = nom;
        this.setId();
    }
    
    public int getId()
    {
        return this.id;
    }
    public String getNom()
    {
        return this.nom;
    }
    public void setNom(String nom)
    {
        this.nom = nom;
    }
    private void setId() throws SQLException
    {
        String request = "SELECT id_section FROM `sections` WHERE `nom` = '"+this.nom+"' ;";
        ResultSet result = db.select(request);
        if (result.getFetchSize() == 1)
        {
            try 
            {
                while(result.next()) 
                {
                    this.id = result.getInt("id_section");
                }
            }
            catch(SQLException ex) 
            {
               ex.printStackTrace();
            }
        }
        
            
        
        
    }
    public void saveSection()
    {
        if (id > 0)
        {
            String request = "UPDATE `sections` "
                           + "SET nom = '"+this.nom+"' "
                           + "WHERE id_section = "+this.id+" ;";
            this.db.edit(request);
        }
        else
        {
            String request = "INSERT INTO `sections` (`id_section`, `nom`) "
                            +"VALUES (NULL, '"+this.nom+"');";
            this.db.edit(request);
        }
    }
}
