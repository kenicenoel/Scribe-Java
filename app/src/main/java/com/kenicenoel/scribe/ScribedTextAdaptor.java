package com.kenicenoel.scribe;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class ScribedTextAdaptor extends RecyclerView.Adapter<ScribedTextAdaptor.DataObjectHolder>
{


    private static final String TAG = ScribedTextAdaptor.class.getSimpleName();
        private ArrayList<ScribedText> scribedTexts;

        private Context context;
//        private DatabaseHandler helper;



         public ScribedTextAdaptor(ArrayList<ScribedText> arrayList, Context c)
        {
            context = c;
            scribedTexts = arrayList;
//            helper = new DatabaseHandler(c, null, null, 1);

        }

        @Override
        public DataObjectHolder onCreateViewHolder(ViewGroup parent, int viewType)
        {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_message, parent, false);

            DataObjectHolder dataObjectHolder = new DataObjectHolder(view);
            return dataObjectHolder;
        }

        @Override
        public void onBindViewHolder(final DataObjectHolder holder, final int position)
        {
            final String text = scribedTexts.get(position).getText();
            final String timestamp = scribedTexts.get(position).getTimestamp();


            holder.text.setText(text);
            holder.timestamp.setText(timestamp);

            holder.copyTextIcon.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    ClipboardManager clipboard = (ClipboardManager) context. getSystemService(Context.CLIPBOARD_SERVICE);
                    // Creates a new text clip to put on the clipboard
                    ClipData clip = ClipData.newPlainText("MessageBody", text);
                    clipboard.setPrimaryClip(clip);
                    Toast.makeText(context, "Copied text to the clipboad", Toast.LENGTH_SHORT).show();
                }
            });


        }



        public void addItem(ScribedText dataObj, int index)
        {
            scribedTexts.add(index, dataObj);
            notifyItemInserted(index);
        }

        public void deleteItem(int index)
        {
            scribedTexts.remove(index);
            notifyItemRemoved(index);
        }

        @Override
        public int getItemCount()
        {
            return scribedTexts.size();
        }




    public class DataObjectHolder extends RecyclerView.ViewHolder
    {
        TextView timestamp;
        TextView text;
        ImageView copyTextIcon;



        public DataObjectHolder(View itemView)
        {
            super(itemView);
            text = (TextView) itemView.findViewById(R.id.resultingText);
            timestamp = (TextView) itemView.findViewById(R.id.timestamp);
            copyTextIcon = (ImageView) itemView.findViewById(R.id.copyTextIcon);
        }



    }


}
