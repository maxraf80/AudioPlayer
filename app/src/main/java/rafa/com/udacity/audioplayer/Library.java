package rafa.com.udacity.audioplayer;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class Library extends AppCompatActivity {

    TextView roxette,aceOfBase,takeThat;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.music);

        roxette=(TextView)findViewById(R.id.roxette);
        roxette.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent roxetteIntent=new Intent(Library.this,Roxette.class);
            startActivity(roxetteIntent);}
    });

        aceOfBase=(TextView)findViewById(R.id.aceofbase);
        aceOfBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent aceOfBaseIntent = new Intent(Library.this,AceofBase.class);
            startActivity(aceOfBaseIntent);}});
        takeThat=(TextView)findViewById(R.id.takethat);
        takeThat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Intent takethatIntent=new Intent(Library.this,TakeThat.class);
            startActivity(takethatIntent);
            }
        });

    }}
