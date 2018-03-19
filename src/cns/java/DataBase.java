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

/**
 *
 * @author Matthias
 */
public class DataBase {

    private ArrayList al = new ArrayList();
 
    String mdp = "root";
    
    public DataBase(String data) 
    {
        Connection connexion = null;
        
        if (data.startsWith("S",0)) 
        {
            try 
            {
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Le pilote JDBC MySQL a été chargé");
                connexion = DriverManager.getConnection("jdbc:mysql://localhost/cdo", "root", mdp);
                //System.out.println(data.charAt(0));

                try (Statement state = connexion.createStatement();

                ResultSet result = state.executeQuery(data)) 
                {
                    ResultSetMetaData resultMeta = result.getMetaData();
                    ArrayList a2 = null;
                    while(result.next())
                    {

                        a2 = new ArrayList();
                        
                        for(int i = 1; i <= resultMeta.getColumnCount(); i++) {
                            if(result.getObject(i)!=null) {
                            a2.add(result.getObject(i).toString());}
                         else {a2.add("");}
                        
                        }
                    al.add(a2);    
                    }

                }

                connexion.close();
                 
                this.al = al;
            }
            catch (Exception e) 
            {
                e.printStackTrace();
                
            } 
       
        }
        else
        {
            try 
            {
            
                Class.forName("com.mysql.jdbc.Driver");
                System.out.println("Le pilote JDBC MySQL a été chargé");
                connexion = DriverManager.getConnection("jdbc:mysql://localhost/cdo", "root", mdp);

                Statement state = connexion.createStatement();
                state.executeUpdate(data);
                connexion.close();
            }
            catch (Exception e) 
            {
                e.printStackTrace();
            }  
        }
      
    }

    public ArrayList renvoi() 
    {
        return al;
    }
    
    public int renvoiInt() {
        String contenu = al.get(0).toString();
        int don = Integer.parseInt(contenu.substring(1,contenu.length()-1));
        return don;
    }

    
 public class GestionException extends Exception {

  public GestionException() {
    super();
  }

  public GestionException(String s) {
    super(s);
  }
}
    
    
}