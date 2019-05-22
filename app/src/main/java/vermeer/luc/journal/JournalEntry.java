package vermeer.luc.journal;

import java.io.Serializable;

public class JournalEntry implements Serializable {
    private String title;
    private String content;
    private String mood;

    public JournalEntry(String title, String content, String mood) {
        this.title = title;
        this.content = content;
        this.mood = mood;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public String getMood() {
        return mood;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setMood(String mood) {
        this.mood = mood;
    }
}
