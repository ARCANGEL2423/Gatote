package com.example.gatote;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button[][] buttons = new Button[6][6];

    private boolean PersonaTurno1 = true;
    private int contaconta;
    private int Persona1Puntos;
    private int Persona2Puntos;
    private TextView textViewJugador1;
    private TextView textViewJugador2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewJugador1 = findViewById(R.id.text_view_p1);
        textViewJugador2 = findViewById(R.id.text_view_p2);

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                String buttonID = "button_" + i + j;
                int resID = getResources().getIdentifier(buttonID, "id", getPackageName());
                buttons[i][j] = findViewById(resID);
                buttons[i][j].setOnClickListener(this);
            }
        }

        Button buttonReset = findViewById(R.id.button_reset);
        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetGame();
            }
        });
    }
    @Override
    public void onClick(View v) {
        if (!((Button) v).getText().toString().equals("")) {
            return;
        }

        if (PersonaTurno1) {
            ((Button) v).setText("X");

        } else {
            ((Button) v).setText("O");

        }

        contaconta++;

        if (checkForWin()) {
            if (PersonaTurno1) {
                player1Wins();
            } else {
                player2Wins();
            }
        } else if (contaconta == 36) {
            draw();
        } else {
            PersonaTurno1 = !PersonaTurno1;
        }

    }
    private boolean checkForWin() {
        String[][] field = new String[6][6];

        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                field[i][j] = buttons[i][j].getText().toString();
            }
        }

        for (int i = 0; i < 6; i++) {
            if (field[i][0].equals(field[i][1]) && field[i][0].equals(field[i][2]) && field[i][0].equals(field[i][3]) && !field[i][0].equals("")) {
                return true;
            }
            if (field[i][1].equals(field[i][2]) && field[i][1].equals(field[i][3]) && field[i][1].equals(field[i][4]) && !field[i][1].equals("")) {
                return true;
            }
            if (field[i][2].equals(field[i][3]) && field[i][2].equals(field[i][4]) && field[i][2].equals(field[i][5]) && !field[i][2].equals("")) {
                return true;
            }
        }

        for (int i = 0; i < 6; i++) {
            if (field[0][i].equals(field[1][i]) && field[0][i].equals(field[2][i]) && field[0][i].equals(field[3][i]) && !field[0][i].equals("")) {
                return true;
            }
            if (field[1][i].equals(field[2][i]) && field[1][i].equals(field[3][i]) && field[1][i].equals(field[4][i]) && !field[1][i].equals("")) {
                return true;
            }
            if (field[2][i].equals(field[3][i]) && field[2][i].equals(field[4][i]) && field[2][i].equals(field[5][i]) && !field[2][i].equals("")) {
                return true;
            }
            if (field[0][2].equals(field[1][3]) && field[0][2].equals(field[2][4]) && field[0][2].equals(field[3][5]) && !field[0][2].equals("")) {
                return true;
            }
            if (field[0][1].equals(field[1][2]) && field[0][1].equals(field[2][3]) && field[0][1].equals(field[3][4]) && !field[0][1].equals("")) {
                return true;
            }
            if (field[0][0].equals(field[1][1]) && field[0][1].equals(field[2][2]) && field[0][1].equals(field[3][3]) && !field[0][1].equals("")) {
                return true;
            }
            if (field[1][2].equals(field[2][3]) && field[1][2].equals(field[3][4]) && field[1][2].equals(field[4][5]) && !field[1][2].equals("")) {
                return true;
            }

            if (field[1][1].equals(field[2][2]) && field[1][1].equals(field[3][3]) && field[1][1].equals(field[4][4]) && !field[1][1].equals("")) {
                return true;
            }
            if (field[2][2].equals(field[3][3]) && field[2][2].equals(field[4][4]) && field[2][2].equals(field[5][5]) && !field[2][2].equals("")) {
                return true;
            }
            if (field[1][2].equals(field[2][3]) && field[1][2].equals(field[3][4]) && field[1][2].equals(field[4][5]) && !field[1][2].equals("")) {
                return true;
            }
            if (field[0][2].equals(field[1][3]) && field[0][2].equals(field[2][4]) && field[0][2].equals(field[3][5]) && !field[0][2].equals("")) {
                return true;
            }


            if (field[5][2].equals(field[4][3]) && field[5][2].equals(field[3][4]) && field[5][2].equals(field[2][5]) && !field[5][2].equals("")) {
                return true;
            }
            if (field[4][2].equals(field[3][3]) && field[4][2].equals(field[2][4]) && field[4][2].equals(field[1][5]) && !field[4][2].equals("")) {
                return true;
            }
            if (field[3][2].equals(field[2][3]) && field[3][2].equals(field[1][4]) && field[3][2].equals(field[0][5]) && !field[3][2].equals("")) {
                return true;
            }
            if (field[5][1].equals(field[4][2]) && field[5][1].equals(field[3][3]) && field[5][1].equals(field[2][4]) && !field[5][1].equals("")) {
                return true;
            }

            if (field[4][1].equals(field[3][2]) && field[4][1].equals(field[2][3]) && field[4][1].equals(field[1][4]) && !field[4][1].equals("")) {
                return true;
            }
            if (field[3][1].equals(field[2][2]) && field[3][1].equals(field[1][3]) && field[3][1].equals(field[0][4]) && !field[3][1].equals("")) {
                return true;
            }
            if (field[5][0].equals(field[4][1]) && field[5][0].equals(field[3][2]) && field[5][0].equals(field[2][3]) && !field[5][0].equals("")) {
                return true;
            }
        }



        return false;
    }

    private void player1Wins() {
        Persona1Puntos++;
        Toast.makeText(this, "¡Gatote 1 gana!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void player2Wins() {
        Persona2Puntos++;
        Toast.makeText(this, "¡Gatote 2 gana!", Toast.LENGTH_SHORT).show();
        updatePointsText();
        resetBoard();
    }

    private void draw() {
        Toast.makeText(this, "¡Empatados!", Toast.LENGTH_SHORT).show();
        resetBoard();
    }

    private void updatePointsText() {
        textViewJugador1.setText("Gatote 1: " + Persona1Puntos);
        textViewJugador2.setText("Gatote 2: " + Persona2Puntos);
    }

    private void resetBoard() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                buttons[i][j].setText("");

            }
        }

        contaconta = 0;
        PersonaTurno1 = true;
    }

    private void resetGame() {
        Persona1Puntos = 0;
        Persona2Puntos = 0;
        updatePointsText();
        resetBoard();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("roundCount", contaconta);
        outState.putInt("Jugador1Puntos", Persona1Puntos);
        outState.putInt("Jugador2Puntos", Persona2Puntos);
        outState.putBoolean("PersonaTurno1", PersonaTurno1);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        contaconta = savedInstanceState.getInt("roundCount");
        Persona1Puntos = savedInstanceState.getInt("Jugador1Puntos");
        Persona2Puntos = savedInstanceState.getInt("Jugador2Puntos");
        PersonaTurno1 = savedInstanceState.getBoolean("PersonaTurno1");
    }


}