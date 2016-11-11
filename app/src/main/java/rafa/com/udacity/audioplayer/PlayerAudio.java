package rafa.com.udacity.audioplayer;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class PlayerAudio extends AppCompatActivity {

    private Button previous,play,next,library;
    private TextView songDisplay;
    private MediaPlayer mediaPlayer;
    private int position;
    private int forwardTime = 5000;
    private int backwardTime = 5000;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        library=(Button)findViewById(R.id.music);

        //Song display
        songDisplay=(TextView)findViewById(R.id.song);
        songDisplay.setText("Song.mp3");

        // Music buttons
        previous=(Button)findViewById(R.id.previustrack);
        play= (Button)findViewById(R.id.play);
        next= (Button)findViewById(R.id.nextTrack);

        //Text Views

        mediaPlayer= MediaPlayer.create(this,R.raw.bobo);

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            Toast.makeText(getApplicationContext(),"Played the selected song",Toast.LENGTH_SHORT).show();
            mediaPlayer.start();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {
                Toast.makeText(getApplicationContext(),"Song finished",Toast.LENGTH_SHORT).show();
                mediaPlayer.start();}});}});

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mediaPlayer.isPlaying()){mediaPlayer.pause();Toast.makeText(getApplicationContext(),
                        "Pausing the song",Toast.LENGTH_SHORT).show();}else {mediaPlayer.start();}}});

    previous.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
           position= mediaPlayer.getCurrentPosition();
           mediaPlayer.seekTo(position-backwardTime);
           Toast.makeText(getApplicationContext(),"Setting 5 seconds less",Toast.LENGTH_SHORT).show();
        }});

    next.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            position=mediaPlayer.getCurrentPosition();
            mediaPlayer.seekTo(position+forwardTime);
            Toast.makeText(getApplicationContext(),"Setting 5 seconds forward",Toast.LENGTH_SHORT).show();}});



    library.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Intent libraryIntent = new Intent(PlayerAudio.this, Library.class);
            startActivity(libraryIntent);
        }});

    }}