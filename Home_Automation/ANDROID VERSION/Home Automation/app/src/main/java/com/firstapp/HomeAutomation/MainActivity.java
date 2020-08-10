package com.firstapp.HomeAutomation;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
Switch sw1,sw2,sw3;
String s1="ON";
String s2="OFF";
DatabaseReference databaseReference,temp_reff;
private ChildEventListener reffchild;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sw1 = findViewById(R.id.s1);
        sw2 = findViewById(R.id.s2);
        final HashMap<String,Object> hashMap = new HashMap<>();
        databaseReference=FirebaseDatabase.getInstance().getReference().child("SWITCH");
        temp_reff=FirebaseDatabase.getInstance().getReference();
        sw3 = findViewById(R.id.s3);
        sw1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sw1.isChecked())
                {
                    hashMap.put("SWITCH1",s1);
                }
                else
                {
                    hashMap.put("SWITCH1",s2);
                }
                databaseReference.updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                });
            }
        });
        sw2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sw2.isChecked())
                {
                    hashMap.put("SWITCH2",s1);
                }
                else
                {
                    hashMap.put("SWITCH2",s2);
                }
                databaseReference.updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                });
            }
        });
        sw3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sw3.isChecked())
                {
                    hashMap.put("SWITCH3",s1);
                }
                else
                {
                    hashMap.put("SWITCH3",s2);
                }
                databaseReference.updateChildren(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {

                    }
                });
            }
        });

        reffchild = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                GenericTypeIndicator<HashMap<String,Object>> ind=new GenericTypeIndicator<HashMap<String, Object>>() {};
                final HashMap<String,Object> childValue=dataSnapshot.getValue(ind);

                childValue.put("key",dataSnapshot.getKey());

                if (childValue.get("SWITCH1").toString().equals("ON")) {

                    sw1.setChecked(true);

                }else {
                    sw1.setChecked(false);
                }

                if (childValue.get("SWITCH2").toString().equals("ON")) {

                    sw2.setChecked(true);

                }else {
                    sw2.setChecked(false);
                }


                if (childValue.get("SWITCH3").toString().equals("ON")) {

                    sw3.setChecked(true);

                }else {
                    sw3.setChecked(false);
                }

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

                GenericTypeIndicator<HashMap<String,Object>> ind=new GenericTypeIndicator<HashMap<String, Object>>() {};
                final HashMap<String,Object> childValue=dataSnapshot.getValue(ind);

                childValue.put("key",dataSnapshot.getKey());

                if (childValue.get("SWITCH1").toString().equals("ON")) {

                    sw1.setChecked(true);

                }else {
                    sw1.setChecked(false);
                }

                if (childValue.get("SWITCH2").toString().equals("ON")) {

                    sw2.setChecked(true);

                }else {
                    sw2.setChecked(false);
                }


                if (childValue.get("SWITCH3").toString().equals("ON")) {

                    sw3.setChecked(true);

                }else {
                    sw3.setChecked(false);
                }
            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        temp_reff.addChildEventListener(reffchild);
    }



}
