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
package cns.java;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author Matthias
 */
public class DataBase {

    String type = "mysql";
    String ip = "localhost";
    String database = "cns_prod";
    String user = "root";
    String mdp = "root";
    Connection connexion = null;
    
    public DataBase() 
    {
        try 
        {
            Class.forName("com."+ this.type +".jdbc.Driver");
            this.connexion = DriverManager.getConnection("jdbc:"+ this.type +"://"+ this.ip +"/"+ this.database, this.user, this.mdp);
        }
        catch(Exception ex) 
        {
            ex.printStackTrace();
        }
    }

    public ResultSet select(String request) 
    {
        ResultSet result = null;

        try 
        {
           Statement stmt = this.connexion.createStatement();
           result = stmt.executeQuery(request);
        } 
        catch(SQLException ex) 
        {
           ex.printStackTrace();
        }
        
        return result;
    }
    public ResultSet update(String request) 
    {
        ResultSet result = null;

        try 
        {
           Statement stmt = this.connexion.createStatement();
           stmt.executeUpdate(request);
        } 
        catch(SQLException ex) 
        {
           ex.printStackTrace();
        }
        
        return result;
    }
}