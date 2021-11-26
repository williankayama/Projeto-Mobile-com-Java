package com.example.pimmm.dao;

import com.example.pimmm.conexao.ConexaoBD;
import com.example.pimmm.model.Usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {

    public Usuario selecionaUsuario(String usuario, String senha) {
        try {
            Connection conn = ConexaoBD.conectarBD();
            if(conn != null){
                String sqlQuery = "SELECT * FROM Usuario WHERE Login = '"+usuario+"' AND Senha = '"+senha+"' AND Status = 1";
                Statement stmt = null;
                stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(sqlQuery);
                while(rs.next()){
                    Usuario usu = new Usuario();
                    usu.setUsuario(rs.getString(1));
                    usu.setSenha(rs.getString(2));

                    conn.close();
                    return usu;
                }
            }
        }catch (ClassNotFoundException e) {
            e.printStackTrace();
        }catch (SQLException throwables) {
            throwables.printStackTrace();

        }
        return null;
    }
}
