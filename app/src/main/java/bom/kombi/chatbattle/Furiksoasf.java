package bom.kombi.chatbattle;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.tohellik.magerik.R;

public class Furiksoasf extends AppCompatActivity {
Button setnomergend;
Toast nikoniko;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calfuysf);

        setnomergend = (Button) findViewById(R.id.kinenbsaf);
    }
    public void getmemore(View view) {
        Toast.makeText(Furiksoasf.this, "Starting find new people", Toast.LENGTH_LONG).show();
    }
}