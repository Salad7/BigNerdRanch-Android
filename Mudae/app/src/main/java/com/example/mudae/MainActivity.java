package com.example.mudae;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mudae.Objects.Mudae;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class MainActivity extends AppCompatActivity {

    Button rolls;
    TextView roll_name;
    TextView roll_rank;
    ArrayList<Mudae> mudaes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rolls = findViewById(R.id.roll);
        roll_name = findViewById(R.id.rollName);
        roll_rank = findViewById(R.id.rollRank);
        mudaes = new ArrayList<>();
        mudaes.add(new Mudae("Zero Two","..",1,0L));
        mudaes.add(new Mudae("Ahri","..",7,0L));
        mudaes.add(new Mudae("Pain","..",32,0L));
        mudaes.add(new Mudae("Saitama","..",12,0L));
        mudaes.add(new Mudae("Goku","..",11,0L));
        mudaes.add(new Mudae("Vegeta","..",9000,0L));

        rolls.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int randomVal = ThreadLocalRandom.current().nextInt(1, mudaes.size());
//                Toast.makeText(getApplicationContext(),"Poop "+randomVal,Toast.LENGTH_LONG).show();;
                roll_name.setText(mudaes.get(randomVal).name);
                roll_rank.setText(mudaes.get(randomVal).rank+"");

            }
        });

    }
}