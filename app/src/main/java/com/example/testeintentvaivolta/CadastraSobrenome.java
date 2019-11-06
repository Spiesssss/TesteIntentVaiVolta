package com.example.testeintentvaivolta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class CadastraSobrenome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastra_sobrenome);
    }

    public void voltaParaInicio(View view) {
        Intent estaIntent = getIntent();
        String nome = estaIntent.getStringExtra("nome");
        String curso = estaIntent.getStringExtra("curso");
        EditText et_pegaSobrenome = findViewById(R.id.et_pegaSobrenome);
        String sobrenome = et_pegaSobrenome.getText().toString();
        try{
            testaSobrenome(sobrenome);
            String informacoesPessoa = "Nome : "+nome+" Sobrenome: "+sobrenome+" Curso: "+curso;
            Intent intentResultado = new Intent();
            intentResultado.putExtra("info",informacoesPessoa);
            setResult(RESULT_OK,intentResultado);
            finish();
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }


    }

    private void testaSobrenome(String sobrenome) throws Exception{
        Exception e = new Exception("Digite um sobrenome");
        if(sobrenome.isEmpty()){
            throw e;
        }
    }
}
