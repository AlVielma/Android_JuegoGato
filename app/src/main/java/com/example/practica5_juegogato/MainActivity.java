package com.example.practica5_juegogato;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private boolean enabled= true;
    private String ganador="";
    private char turno ='X';
    private char[] chars = new char[9];
    private TextView label;
    private ArrayList<TextView> lbs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        label=findViewById(R.id.etiqueta);

        TextView lb1 = findViewById(R.id.lb1);
        TextView lb2 = findViewById(R.id.lb2);
        TextView lb3 = findViewById(R.id.lb3);
        TextView lb4 = findViewById(R.id.lb4);
        TextView lb5 = findViewById(R.id.lb5);
        TextView lb6 = findViewById(R.id.lb6);
        TextView lb7 = findViewById(R.id.lb7);
        TextView lb8 = findViewById(R.id.lb8);
        TextView lb9 = findViewById(R.id.lb9);

        lbs = new ArrayList<>();
        lbs.add(lb1);
        lbs.add(lb2);
        lbs.add(lb3);
        lbs.add(lb4);
        lbs.add(lb5);
        lbs.add(lb6);
        lbs.add(lb7);
        lbs.add(lb8);
        lbs.add(lb9);

        for (int i = 0 ;i<9;i++ ){
            int m=i;
            TextView lb = lbs.get(i);
            lb.setOnClickListener(view -> {
                if (enabled){
                    if (lb.getText().toString().equals("")){
                        lb.setText(String.valueOf(turno));
                        chars[m] = turno;
                        if (turno== 'X'){
                            lb.setTextColor(getResources().getColor(R.color.blue));
                            turno = '0';
                            label.setText("Player 2, te toca mije");
                        } else{
                            lb.setTextColor(getResources().getColor(R.color.red));
                            turno = 'X';
                            label.setText("Player 1, te toca mije");
                        }
                    }else {
                        label.setText("Posición ocupada");
                    }
                    if (Ganador()&&ganador.equals("X")){
                        label.setText("Player 1 gano, Excelente pequeña");
                        label.setTextColor(getResources().getColor(R.color.blue));
                        enabled= false;
                    } else if (Ganador()&&ganador.equals("O")) {
                        label.setText("Player 2 gano, Excelente pequeña");
                        label.setTextColor(getResources().getColor(R.color.red));
                        enabled= false;
                    } else if (dibujo()) {
                        label.setText("Suerte para la proxima mijines");
                        enabled=false;
                    }
                }
            });
        }

    }
    public void newgame(View view){
        chars = new char[9];
        ganador = "";
        label.setText("Player 1, te toca mije");
        label.setTextColor(getResources().getColor(R.color.black));
        turno = 'X';
        enabled = true;
        for (TextView lb:lbs){
            lb.setText("");
        }
    }
    private boolean Ganador(){
        boolean gana=false;
        if (chars[0]==chars[1]&&chars[0]==chars[2]&&chars[0] !=0) {
            gana = true;
            ganador = String.valueOf(chars[0]);
        } else if (chars[3]==chars[4]&&chars[3]==chars[5]&&chars[3] !=0) {
            gana = true;
            ganador = String.valueOf(chars[3]);
        } else if (chars[6]==chars[7]&&chars[6]==chars[8]&&chars[6] !=0) {
            gana = true;
            ganador = String.valueOf(chars[6]);
        } else if (chars[0]==chars[3]&&chars[0]==chars[6]&&chars[0] !=0) {
            gana = true;
            ganador = String.valueOf(chars[0]);
        } else if (chars[1]==chars[4]&&chars[1]==chars[7]&&chars[1] !=0) {
            gana = true;
            ganador = String.valueOf(chars[1]);
        } else if (chars[2]==chars[5]&&chars[2]==chars[8]&&chars[2] !=0) {
            gana = true;
            ganador = String.valueOf(chars[2]);
        } else if (chars[0]==chars[4]&&chars[0]==chars[8]&&chars[0] !=0) {
            gana = true;
            ganador = String.valueOf(chars[0]);
        } if (chars[2]==chars[4]&&chars[2]==chars[6]&&chars[2] !=0) {
            gana = true;
            ganador = String.valueOf(chars[2]);
        }
        return gana;
    }
    private boolean dibujo(){
        boolean dibujo = true;
        for (char a : chars){
            if (a==0){
                dibujo = false;
                break;
            }
        }
        return dibujo;
    }
}