package my.edu.taruc.bmiproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    public static final String TAG_MESSAGE ="my.edu,tarc.BMIProject.MESSAGE";
    private EditText editMessage;
    private EditText editMessage2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Link UI to program
        editMessage = findViewById(R.id.editMessage);
        editMessage2 = findViewById(R.id.editMessage2);
    }

    public void SendMessage(View view){
        String stringMessage;
        String stringMessage2;
        if(TextUtils.isEmpty(editMessage.getText())){
            editMessage.setError("Please enter your weight");
            return;
        }
        if(TextUtils.isEmpty(editMessage2.getText())){
            editMessage2.setError("Please enter your height");
            return;
        }

        stringMessage = editMessage.getText().toString();
        stringMessage2 = editMessage2.getText().toString();

        double weight = Double.parseDouble(stringMessage);
        double height = Double.parseDouble(stringMessage2);

        double bmi= weight/(height*height);

        String answer = String.format("BMI: %.2f",bmi);
        Intent intent = new Intent(this,SecondActivity.class);
        intent.putExtra(TAG_MESSAGE ,answer);
        startActivity(intent);


    }
}
