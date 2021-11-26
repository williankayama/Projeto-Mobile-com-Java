package com.example.pimmm;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.pimmm.MainActivity;


import com.example.pimmm.conexao.ConexaoBD;
import com.example.pimmm.dao.UserDAO;
import com.example.pimmm.model.Usuario;

import java.sql.Connection;
import java.sql.SQLException;

public class activity_login extends AppCompatActivity {

    EditText txtLogin, txtSenha;
    Button btLogar;
    TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    txtLogin = findViewById(R.id.txtLogin);
    txtSenha = findViewById(R.id.txtSenha);
    txtView = findViewById(R.id.txtView);
    btLogar = findViewById(R.id.btEntrar);



    }
    public void realizarLogin(View v){
        String login = txtLogin.getText().toString();
        String senha = txtSenha.getText().toString();

        Usuario usu = new UserDAO().selecionaUsuario(login, senha);
        if (usu != null){
            Intent it = new Intent(this, MenuActivity.class);
            startActivity(it);
            finish();

        }else{
            txtView.setText("Usuario e/ou senha incorretos!");
            txtLogin.requestFocus();
            txtSenha.setText("");
        }
    }
}