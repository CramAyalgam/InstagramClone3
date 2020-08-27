package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;
import com.shashank.sony.fancytoastlib.FancyToast;

public class SignUp extends AppCompatActivity {

    private EditText edtName,edtPunchPower,edtPunchSpeed,edtKickSpeed,edtKickPower;
    private Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edt_signup_Name);
        edtKickPower = findViewById(R.id.edt_signup_kickpower);
        edtKickSpeed = findViewById(R.id.edt_signup_kickspeed);
        edtPunchSpeed = findViewById(R.id.edt_signup_punchspeed);
        edtPunchPower = findViewById(R.id.edt_signup_punchpower);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    final ParseObject kickBoxer = new ParseObject("KickBoxer");
                    kickBoxer.put("name", edtName.getText().toString());
                    kickBoxer.put("punchSpeed", Integer.parseInt(edtPunchSpeed.getText().toString()));
                    kickBoxer.put("punchPower", Integer.parseInt(edtPunchPower.getText().toString()));
                    kickBoxer.put("kickSpeed", Integer.parseInt(edtKickSpeed.getText().toString()));
                    kickBoxer.put("kickPower", Integer.parseInt(edtKickPower.getText().toString()));
                    kickBoxer.saveInBackground(new SaveCallback() {
                        @Override
                        public void done(ParseException e) {
                            if(e==null){
                                FancyToast.makeText(SignUp.this,kickBoxer.get("name") + " object is save successfully",FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                            }else {
                                FancyToast.makeText(SignUp.this, e.getMessage() ,FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                            }
                        }
                    });
                }catch (Exception e){
                    FancyToast.makeText(SignUp.this, e.getMessage() ,FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                }

            }
        });
    }

}