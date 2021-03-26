package bom.tohellik.magerik;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tohellik.magerik.R;

public class Kmjyysf extends AppCompatActivity {
Button noblastingchat;
TextView woblingmewuser;
ProgressBar gonewuserik;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pejuksiggh);
        gonewuserik = (ProgressBar) findViewById(R.id.kmchsaa);
        gonewuserik.setVisibility(ProgressBar.INVISIBLE);
        noblastingchat = (Button) findViewById(R.id.bookivms);
    }
    public void golikemi(View view){
        gonewuserik.setVisibility(ProgressBar.VISIBLE);
        woblingmewuser = (TextView) findViewById(R.id.iekjnssd);
        woblingmewuser.setText("Waiting for new users...");
    }
}