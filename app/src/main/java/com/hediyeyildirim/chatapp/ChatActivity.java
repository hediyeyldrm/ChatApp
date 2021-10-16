package com.hediyeyildirim.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.UUID;

public class ChatActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    EditText messageText;

    FirebaseDatabase database;
    DatabaseReference databaseReference;


    private ArrayList<String> chatMessages = new ArrayList<>();



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.option_menu,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.options_menu_sign_out){

            mAuth.signOut();
            Intent intent = new Intent(getApplicationContext(), SignUpActivity.class);
            startActivity(intent);

        } else if (item.getItemId() == R.id.options_menu_profile){
            Intent intent = new Intent(getApplicationContext(), ProfileActivity.class);
            startActivity(intent);

        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        //chatMessages.add("sss");
        //chatMessages.add("123");

        messageText =findViewById(R.id.chat_activity_message_text);
        recyclerView =findViewById(R.id.recycler_view);
        recyclerViewAdapter = new RecyclerViewAdapter(chatMessages);


        RecyclerView.LayoutManager recyclerViewManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(recyclerViewManager);

        recyclerView.setAdapter(recyclerViewAdapter);


        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance("https://chatapp-32d3f-default-rtdb.firebaseio.com/");
        databaseReference = database.getReference();

    }

    public void sendMessage(View view){

        String messageToSend = messageText.getText().toString();

        UUID uuid = UUID.randomUUID(); //uydurma bir dizi-sayı verir.
        String uuidString = uuid.toString();

        FirebaseUser user = mAuth.getCurrentUser();
        String userEmail = user.getEmail().toString();

        databaseReference.child("Chats").child(uuidString).child("usermessage").setValue(messageToSend);
        databaseReference.child("Chats").child(uuidString).child("useremail").setValue(userEmail);

        messageText.setText("");
        //databaseReference.child("Chat").child("Chat 1").child("Test Chat").child("Test 1").setValue(messageToSend);

    }
}