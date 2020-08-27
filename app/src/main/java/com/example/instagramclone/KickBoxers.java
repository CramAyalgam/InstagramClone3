package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.parse.FindCallback;
import com.parse.GetCallback;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.shashank.sony.fancytoastlib.FancyToast;

import java.util.List;

public class KickBoxers extends AppCompatActivity {

    private TextView txtGetName;
    private Button btnGetAll;
    private String allKickBoxers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kick_boxers);

        txtGetName = findViewById(R.id.txtGetName);
        btnGetAll = findViewById(R.id.btnGetAll);




        txtGetName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ParseQuery<ParseObject> parseQuery = ParseQuery.getQuery("KickBoxer");
                parseQuery.getInBackground("8Dj8F9vGRZ", new GetCallback<ParseObject>() {
                    @Override
                    public void done(ParseObject object, ParseException e) {
                         if(object != null && e == null){
                             txtGetName.setText(object.get("name").toString());
                         }
                    }
                });
            }
        });


        btnGetAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                allKickBoxers = "";

                ParseQuery<ParseObject> queryAll = ParseQuery.getQuery("KickBoxer");
                queryAll.findInBackground(new FindCallback<ParseObject>() {
                    @Override
                    public void done(List<ParseObject> objects, ParseException e) {
                        if(e == null) {
                            if(objects.size() > 0){

                                for(ParseObject kickBoxer : objects){
                                    allKickBoxers = allKickBoxers +  kickBoxer.get("name") + "\n";

                                }


                                FancyToast.makeText(KickBoxers.this,allKickBoxers,FancyToast.LENGTH_LONG,FancyToast.SUCCESS,true).show();
                            }else{
                                FancyToast.makeText(KickBoxers.this, e.getMessage() ,FancyToast.LENGTH_LONG,FancyToast.ERROR,true).show();
                            }
                        }

                    }
                });
            }
        });

    }
}