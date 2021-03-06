package com.example.minorchatbot;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    public int account_no;
    public double balance;
    public String name;
    public String phone_no;
    public String email;
    private String[] localdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       localdata[0] = "hii. i am bot How may i help you";

        Button btn1 = findViewById(R.id.btnOne);
        Button btn2 = findViewById(R.id.btnTwo);
        Button btn3 = findViewById(R.id.btnThree);

        TextInputEditText text_area = findViewById(R.id.texthere);
        ImageButton but = findViewById(R.id.mic);

        ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult() , result -> {
            if(result.getResultCode() == RESULT_OK && result.getData()!=null){
                Intent data = result.getData();
                text_area.setText(data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS).get(0));
            }
        });

        but.setOnClickListener(view -> {
            Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
            intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
            intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Start speaking");

            launcher.launch(intent);
        });

        btn1.setOnClickListener(v -> {
            ChatbotResponse obj = new ChatbotResponse("Hello");
            String renderValue = obj.returnAnswer();
            Toast.makeText(MainActivity.this,renderValue,Toast.LENGTH_LONG).show();
        });
        btn2.setOnClickListener(v -> {
            ChatbotResponse obj = new ChatbotResponse("Balance");
            String renderValue = obj.returnAnswer();
            Toast.makeText(MainActivity.this,renderValue,Toast.LENGTH_LONG).show();
        });
        btn3.setOnClickListener(v -> {
            ChatbotResponse obj = new ChatbotResponse("Transfer");
            String renderValue = obj.returnAnswer();
            Toast.makeText(MainActivity.this,renderValue,Toast.LENGTH_LONG).show();
        });


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.chatrecyclerview);
        ChatAdaptor adapter = new ChatAdaptor(localdata);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }
    public void loadData(final String userName)
    {
        String key = "users";
        FirebaseDatabase.getInstance().getReference(key)
                .addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        for(DataSnapshot snapshot1:snapshot.getChildren())
                        {
                            String DBusername = snapshot1.child(userName).getValue(String.class);
                            if(userName.equals(DBusername) )
                            {
                                account_no = Integer.parseInt(Objects.requireNonNull(snapshot1.child("account_no").getValue()).toString());
                                balance = Double.parseDouble(Objects.requireNonNull(snapshot1.child("balance").getValue()).toString());
                                name = snapshot1.child("name").getValue().toString();
                                phone_no = snapshot.child("phone_no").getValue().toString();
                                email = snapshot1.child("email").getValue().toString();
                            }
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });
    }




}