package com.example.bhutani.connect3;

import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int array[]={2,2,2,2,2,2,2,2,2};

    int [][] winningPositions = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    int activePlayer=0;

    public void dropIn(View view){

        ImageView counter = (ImageView) view;
        int value = Integer.parseInt(counter.getTag().toString());
        if(array[value]==2) {
            array[value]=activePlayer;
            if (activePlayer == 0) {
                counter.setImageResource(R.drawable.circle);
                activePlayer = 1;

            } else {
                counter.setImageResource(R.drawable.cross);
                activePlayer = 0;

            }
            counter.animate().rotationBy(360f).setDuration(200);

            for(int [] winningPosition : winningPositions)
            {
                if(array[winningPosition[0]] == array[winningPosition[1]] && array[winningPosition[1]]== array[winningPosition[2]] && array[winningPosition[0]]!=2)

                {
                    String winner = "Player 2";

                   if(array[winningPosition[0]]==0){

                       winner = "Player 1";
                   }

                    TextView winnerMessage  = (TextView) findViewById(R.id.winningPlayer);

                    winnerMessage.setText(winner + " has won");

                    LinearLayout layout = (LinearLayout) findViewById(R.id.winningPlayerLayout);

                    layout.setVisibility(View.VISIBLE);

                }else{

                    boolean gameIsOver=true;
                    for(int i=0;i<9;i++){
                        if(array[i]==2)
                            gameIsOver=false;
                    }

                    if(gameIsOver){

                        TextView winnerMessage  = (TextView) findViewById(R.id.winningPlayer);

                        winnerMessage.setText("it's a draw ");

                        LinearLayout layout = (LinearLayout) findViewById(R.id.winningPlayerLayout);

                        layout.setVisibility(View.VISIBLE);
                    }

                }
            }

        }
    }

    public  void  playAgain(View view){

        activePlayer=0;
        for(int i=0;i<8;i++)
            array[i]=2;

        LinearLayout layout = (LinearLayout) findViewById(R.id.winningPlayerLayout);

        layout.setVisibility(View.INVISIBLE);

        ImageView image1 = (ImageView) findViewById(R.id.image1);
        image1.setImageResource(0);

        ImageView image2 = (ImageView) findViewById(R.id.image2);
        image2.setImageResource(0);

        ImageView image3 = (ImageView) findViewById(R.id.image3);
        image3.setImageResource(0);

        ImageView image4 = (ImageView) findViewById(R.id.image4);
        image4.setImageResource(0);

        ImageView image5 = (ImageView) findViewById(R.id.image5);
        image5.setImageResource(0);

        ImageView image6 = (ImageView) findViewById(R.id.image6);
        image6.setImageResource(0);

        ImageView image7 = (ImageView) findViewById(R.id.image7);
        image7.setImageResource(0);

        ImageView image8 = (ImageView) findViewById(R.id.image8);
        image8.setImageResource(0);

        ImageView image9 = (ImageView) findViewById(R.id.image9);
        image9.setImageResource(0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
