package vermeer.luc.journal;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;
import android.view.View;
import android.widget.ResourceCursorAdapter;
import android.widget.TextView;

public class EntryAdapter extends ResourceCursorAdapter {
    public EntryAdapter(Context context, int layout, Cursor cursor, int flags) {
        super(context, layout, cursor, flags);
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        TextView title_text = view.findViewById(R.id.title);
        TextView content_text = view.findViewById(R.id.content);
        TextView mood_text = view.findViewById(R.id.mood);
        TextView timestamp_text = view.findViewById(R.id.timestamp);

//        Log.d("!!!!!!!!!!!!!!!!!!!!!!!!Column name at  index: ", cursor.getColumnName(2));

        String titleText = cursor.getString(cursor.getColumnIndex("title"));
        String timeStampText = cursor.getString(cursor.getColumnIndex("timestamp"));
        String moodText = cursor.getString(cursor.getColumnIndex("mood"));
        String contentText = cursor.getString(cursor.getColumnIndex("content"));

        title_text.setText(titleText);
        content_text.setText(contentText);
        mood_text.setText(moodText);
        timestamp_text.setText(timeStampText);
    }
}
