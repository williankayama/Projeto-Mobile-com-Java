package com.example.pimmm.conexao;

import android.content.Context;
import android.os.StrictMode;
import android.widget.Toast;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {

    public static Connection conectarBD() throws  ClassNotFoundException, SQLException{

            Connection conn = null;

            StrictMode.ThreadPolicy politica;
            politica = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(politica);

            Class.forName("net.sourceforge.jtds.jdbc.Driver");

            conn = DriverManager.getConnection(
                    "jdbc:jtds:sqlserver://192.168.1.30:1433;"+
                            "databaseName=DBPIM;user=sa;password=1202022010;");
        return conn;
    }
}