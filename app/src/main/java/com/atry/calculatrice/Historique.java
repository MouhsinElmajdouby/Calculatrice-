package com.atry.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class Historique extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historique);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu4,menu);

        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId())
        {
            case R.id.scientifique:
                Intent i = new Intent(this,MainActivity.class);
                startActivity(i);
                break;
            case R.id.standard:
                Intent j = new Intent(this,Standart.class);
                startActivity(j);
                break;

            case R.id.historique:
                Intent k = new Intent(this,Historique.class);
                startActivity(k);
                break;
            case R.id.about:
                Intent l = new Intent(this,About.class);
                startActivity(l);
                break;
        }

        return true;
    }
}