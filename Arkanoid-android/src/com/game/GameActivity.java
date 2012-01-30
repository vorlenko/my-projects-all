package com.game;



import game.Game;

import com.badlogic.gdx.backends.android.AndroidApplication;


import android.os.Bundle;

public class GameActivity extends AndroidApplication {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize(new Game(), false);
    }
}