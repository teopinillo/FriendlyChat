package com.teopinillo.friendlychat;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private MessageAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private List<Message> myDataset = new ArrayList<>();
    private ProgressBar progressBar;
    private ImageButton btPhotoPicker;
    private EditText etMessage;
    private Button btSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find all views
        Toolbar toolbar = findViewById(R.id.toolbar);
        progressBar = findViewById(R.id.pbLoading);
        btPhotoPicker = findViewById(R.id.ibPhotoPickerButton);
        etMessage = findViewById(R.id.etMessage);
        btSend = findViewById(R.id.btSend);

        setSupportActionBar(toolbar);

        initDataSet();
        Log.e("debug","step 1");
        recyclerView = findViewById(R.id.rvMessages);
        Log.e("debug","step 2");
        recyclerView.setHasFixedSize(true);
        Log.e("debug","step 3");
        layoutManager = new LinearLayoutManager(this);
        Log.e("debug","step 4");
        recyclerView.setLayoutManager(layoutManager);
        Log.e("debug","step 5");
        // specify an adapter (see also next example)
        mAdapter = new MessageAdapter(this, myDataset);
        Log.e("debug","step 6");
        recyclerView.setAdapter(mAdapter);

        //Initialize progress bar
        progressBar.setVisibility(ProgressBar.INVISIBLE);

        //btPhotoPicker shows an mage picker to upload a image for a message.
        btPhotoPicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO: fire an intent to show an image picker.
            }
        });

        etMessage.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                //TODO
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence.toString().trim().length()>0){
                    btSend.setEnabled(true);
                }else{
                    btSend.setEnabled (false);
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                //TODO
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    private void initDataSet(){
        myDataset.add (new Message("Hello","Maria",""));
        myDataset.add (new Message("Hola","Ana",""));
        myDataset.add (new Message("Good","Bigui",""));

    }
}
