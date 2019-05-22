package vermeer.luc.journal;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public ListView list;
    public Cursor cursor;
    public EntryDatabase db;
    public EntryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.listView);
        list.setOnItemClickListener(new ItemClickListener());
        list.setOnItemLongClickListener(new LongItemClickListener());

        db = EntryDatabase.getInstance(getApplicationContext());
        cursor = db.selectAll();
        adapter = new EntryAdapter(this, R.layout.entry_row , cursor, 0);
        list.setAdapter(adapter);

        LongItemClickListener longClickListener = new LongItemClickListener();
    }

    public void NewEntry(View view) {
        Intent intent = new Intent(MainActivity.this, InputActivity.class);
        startActivity(intent);
    }

    private class ItemClickListener implements AdapterView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(MainActivity.this, DetailActivity.class);

            String title = view.findViewById(R.id.title).toString();
            String mood = view.findViewById(R.id.mood).toString();
            String content = view.findViewById(R.id.content).toString();
            String timestamp = view.findViewById(R.id.timestamp).toString();

            intent.putExtra("title", title);
            intent.putExtra("mood", mood);
            intent.putExtra("content", content);
            intent.putExtra("timestamp", timestamp);

            startActivity(intent);
        }
    }

    private class LongItemClickListener implements AdapterView.OnItemLongClickListener {
        @Override
        public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
            Log.d("LONG CLICK:", "DETECTED!!!!!!!!!!!!!!!!");
            db.delete(id);
            updateData();
            return false;
        }
    }

    private void updateData() {
        adapter.swapCursor(db.selectAll());
    }

}
