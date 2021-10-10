package com.hediyeyildirim.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;

public class ChatActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    RecyclerView recyclerView;
    EditText messageText;


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

        messageText =findViewById(R.id.chat_activity_message_text);
        recyclerView =findViewById(R.id.recycler_view);


        mAuth = FirebaseAuth.getInstance();

    }

    public void sendMessage(View view){

    }
}