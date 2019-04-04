package com.fracasapps.recyclerviewpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String GAME_NAME_EXTRA = "game-name";
    private EditText gameNameInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gameNameInput = findViewById(R.id.game_name_input);
    }

    public void queryTwitch(View view) {
        String gameName = gameNameInput.getText().toString();
        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra(GAME_NAME_EXTRA, gameName);
        startActivity(intent);
    }
}
