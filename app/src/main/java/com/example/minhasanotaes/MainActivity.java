package com.example.minhasanotaes;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText editAnotacao;
    private AnotacaoPreferencias preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        preferencias = new AnotacaoPreferencias(getApplicationContext());
        editAnotacao=findViewById(R.id.editAnotacao);



        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // validar campos
                String textoRecuperado = editAnotacao.getText().toString();
                if(textoRecuperado.equals("")){
                    Snackbar.make(view, "Preencha a anotação", Snackbar.LENGTH_LONG)
                         .show();
                }else{
                    preferencias.salvarAnotacao(textoRecuperado);
                    Snackbar.make(view, " Anotação salva com sucesso", Snackbar.LENGTH_LONG)
                            .show();
                }

            }
        });
        //recuperar anotção
        String anotacao = preferencias.recuperarAnotacao();
        if(!anotacao.equals("")){
            editAnotacao.setText(anotacao);
        }



    }




    }

