package bom.tohellik.magerik;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.tohellik.magerik.R;

public class GLjkjsdf extends AppCompatActivity {
    Button nekistnikam;
    Intent breshitIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bugrges);

        nekistnikam = (Button) findViewById(R.id.smelfelix);
    }
public void setagnmek(View view){
    breshitIntent = new Intent ( this, Furiksoasf.class);
    startActivity(breshitIntent);
}
}