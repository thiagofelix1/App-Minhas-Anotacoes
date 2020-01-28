package com.example.minhasanotaes;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencias {
    private Context context;
    private SharedPreferences preferences;
    private  final String ARQUIVO_ANOTACOES = "ArquivoAnotacoes";
    private SharedPreferences.Editor editor;
    private final String CHAVE_NOME = "nome";

    public AnotacaoPreferencias(Context c ) {
        this.context=c;
        preferences = context.getSharedPreferences(ARQUIVO_ANOTACOES,0);
        editor = preferences.edit();
    }

    public void salvarAnotacao(String anotacao){
        editor.putString(CHAVE_NOME,anotacao);
        editor.commit();

    }

    public String recuperarAnotacao(){

        return preferences.getString(CHAVE_NOME,"");
    }


}
