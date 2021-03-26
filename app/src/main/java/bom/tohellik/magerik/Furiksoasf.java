package bom.tohellik.magerik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.tohellik.magerik.R;

public class Furiksoasf extends AppCompatActivity {
Button setnomergend;
Intent polikIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calfuysf);

        setnomergend = (Button) findViewById(R.id.kjsdfgv);
    }
    public void getmemore(View view) {
        polikIntent = new Intent(this, Kmjyysf.class);
        startActivity(polikIntent);
    }
}