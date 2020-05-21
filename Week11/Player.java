package com.example.demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Player {

    public Player(String request){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/game","root","");
            Statement stmt=con.createStatement();

            if(request.equals("showallplayers")) {
                ResultSet rs=stmt.executeQuery("select * from players");
                while(rs.next())
                    System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            }

            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}


}
