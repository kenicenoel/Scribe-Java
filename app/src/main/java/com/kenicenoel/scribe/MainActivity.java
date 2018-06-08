package com.kenicenoel.scribe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.kenicenoel.quicktools.Toolkit;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    // Removed IBM Watson Credentials 2018-06-08
    private final String URL = "";
    private final String USERNAME = "";
    private final String PASSWORD = "";
    private Toolkit toolkit;
    private ScribedTextAdaptor adaptor;
    private RecyclerView recyclerView;
    private ArrayList<ScribedText> scribedTexts = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.textRecyclerview);
        adaptor = new ScribedTextAdaptor(scribedTexts, getApplicationContext());
        toolkit =  new Toolkit(getApplicationContext());

        // Get the intent that started this activity
        Intent receivedIntent = getIntent();

        //get the action
        String receivedAction = receivedIntent.getAction();

        //find out what we are dealing with
        String receivedType = receivedIntent.getType();

        //make sure it's an action and type we can handle
        if(receivedAction.equals(Intent.ACTION_SEND))
        {
            //content is being shared
            handleIncomingMedia(receivedIntent, receivedType);
        }
        else if(receivedAction.equals(Intent.ACTION_MAIN))
        {
            // app has been launched directly, not from share list
            Toast.makeText(getApplicationContext(), "You launched the app manually", Toast.LENGTH_SHORT).show();
        }


    }

    public void copyText(View view)
    {

    }

    public void handleIncomingMedia(Intent receivedIntent, String receivedType)
    {


        if(receivedType.startsWith("audio/"))
        {
            String prefix = "audioFile";
            String suffix = ".flac";

            //handle sent audio
            //get the uri of the received image
            Uri receivedUri = (Uri)receivedIntent.getParcelableExtra(Intent.EXTRA_STREAM);

            //check we have a uri
            if (receivedUri != null)
            {
                File audio = new File(receivedUri.getPath());

            }
        }




    }

}

