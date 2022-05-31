package com.example.tttnew321;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    int plr = 1;   // player 1 is cross
    int [][]winningState={{0,1,2},{3,4,5},{6,7,8}};
    int []gameState={-1,-1,-1,-1,-1,-1,-1,-1,-1};
    public void load(View view){
        ImageView v = (ImageView) view;
        //by using tag property we will use toast
        int tag = Integer.parseInt(v.getTag().toString());
        if(plr==1){
            gameState[tag] = plr;
            v.setImageResource(R.drawable.cross);
            Toast.makeText(this, tag+"" + "Cross", Toast.LENGTH_SHORT).show();
            plr=0;
        }else{
            gameState[tag]=plr;
            v.setImageResource(R.drawable.zero);
            Toast.makeText(this, tag+"" + "Zero", Toast.LENGTH_SHORT).show();

            plr=1;
        }
        for(int i=0;i< winningState.length;i++){
            if(gameState[winningState[i][0]]==gameState[winningState[i][1]] && gameState[winningState[i][1]]==gameState[winningState[i][2]] && gameState[winningState[i][0]]>-1 ){
                Toast.makeText(this,"Winner is"+(plr==0?1:0),Toast.LENGTH_SHORT).show();
            }
        }
//        v.setImageResource(R.drawable.cross);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}