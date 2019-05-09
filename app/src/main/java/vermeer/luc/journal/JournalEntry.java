package vermeer.luc.journal;

import java.io.Serializable;

public class JournalEntry implements Serializable {
    private int id;
    private String title;
    private String content;
    private int mood;
    private int timestamp;

    public JournalEntry(int id, String title, String content, int mood, int timestamp) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.mood = mood;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public int getMood() {
        return mood;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setMood(int mood) {
        this.mood = mood;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }
}
