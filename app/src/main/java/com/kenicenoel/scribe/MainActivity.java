package com.kenicenoel.scribe;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.kenicenoel.quicktools.Toolkit;

import java.io.File;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private final String URL = "https://stream.watsonplatform.net/speech-to-text/api";
    private final String USERNAME = "b4af98fe-c6bf-40f7-b0ad-8b9e6c1ca70d";
    private final String PASSWORD = "dIonSuVOYheL";
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

