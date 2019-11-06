package com.example.testeintentvaivolta;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void vaiParaCadastro(View view) {
        Intent minhaIntent = new Intent(this, CadastraSobrenome.class);
        EditText et_pegaNome = findViewById(R.id.et_pegaNome);
        String nomePessoa = et_pegaNome.getText().toString();
        try{
            testaNomePessoa(nomePessoa);
            minhaIntent.putExtra("nome",nomePessoa);
            minhaIntent.putExtra("curso","Ciência da computação");
            startActivityForResult(minhaIntent,0);
        }catch (Exception e){
            Toast.makeText(this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    private void testaNomePessoa(String nomePessoa) throws Exception{
        if(nomePessoa.isEmpty()){
            Exception e = new Exception("O nome precisa ser digitado");
            throw e;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Toast.makeText(this, data.getStringExtra("info").toString(), Toast.LENGTH_LONG).show();
    }
}
