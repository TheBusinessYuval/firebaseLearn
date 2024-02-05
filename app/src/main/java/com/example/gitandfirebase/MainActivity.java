package com.example.gitandfirebase;

import static android.content.ContentValues.TAG;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class MainActivity extends AppCompatActivity {
    int counter =1;
    DatabaseReference myRef;
    FirebaseDatabase database = FirebaseDatabase.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myRef = database.getReference().child("dog1");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Log.d("TEst", "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("TEst", "Failed to read value.", error.toException());
            }

        });

    }
    /*
    public void writeNewUser(String userId, String name) {
        ImageView i = new ImageView(this);
        i.setImageResource(R.drawable.dog);
        Object object = new Object(i,name);

        myRef.child("users").child(userId).setValue(object);
    }
    public void Test (View view){
        writeNewUser(String.valueOf(counter),("dog"));
        counter ++;
    }
    */
    public void Test(View view)
    {
        Log.d("TEst", "counter is " + counter);
        myRef.setValue(counter);
        counter++;
    }

}