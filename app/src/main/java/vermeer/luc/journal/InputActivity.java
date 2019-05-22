package vermeer.luc.journal;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InputActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
    }


    public void AddEntry(View view) {
        // Add to database
        EditText editTitle = findViewById(R.id.editTitle);
        EditText editContent = findViewById(R.id.editContent);
        EditText editMood = findViewById(R.id.editMood);

        String title = editTitle.getText().toString();
        String content = editContent.getText().toString();
        String mood = editMood.getText().toString();

        JournalEntry journalEntry = new JournalEntry(title, content, mood);

        EntryDatabase db = EntryDatabase.getInstance(getApplicationContext());
        db.insert(journalEntry);

        // Go back to activity
        Intent intent = new Intent(InputActivity.this, MainActivity.class);
        startActivity(intent);

        // Prevent going back to this view to avoid duplicating database entries
        finish();
    }
}

