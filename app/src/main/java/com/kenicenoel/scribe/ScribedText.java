package com.kenicenoel.scribe;

/**
 * Created as part of the Scribe project.
 * Author: Kenice Noel. Date created: Jul, 18, 2017
 */

public class ScribedText
{
    private String text;
    private String timestamp;

    public ScribedText()
    {

    }

    public ScribedText(String text, String timestamp)
    {
        this.text = text;
        this.timestamp = timestamp;
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }

    public String getTimestamp()
    {
        return timestamp;
    }

    public void setTimestamp(String timestamp)
    {
        this.timestamp = timestamp;
    }
}
