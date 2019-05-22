package vermeer.luc.journal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();

        TextView title = findViewById(R.id.title2);
        TextView content = findViewById(R.id.content2);
        TextView mood = findViewById(R.id.mood2);
        TextView timestamp = findViewById(R.id.timestamp2);

        String title_text = intent.getStringExtra("title");
        String content_text = intent.getStringExtra("content");
        String mood_text = intent.getStringExtra("mood");
        String timestamp_text = intent.getStringExtra("timestamp");

        title.setText(title_text);
        content.setText(content_text);
        mood.setText(mood_text);
        timestamp.setText(timestamp_text);
    }
}
