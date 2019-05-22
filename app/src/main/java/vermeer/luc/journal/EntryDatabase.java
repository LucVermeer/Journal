package vermeer.luc.journal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;
import android.util.Log;

public class EntryDatabase extends SQLiteOpenHelper {
    private static EntryDatabase instance;
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS entries");
        sqLiteDatabase.execSQL("CREATE TABLE Entries(_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "title TEXT, content TEXT, mood TEXT, timestamp DATETIME DEFAULT CURRENT_TIMESTAMP)");

        String insertEntry = "INSERT INTO Entries (title, mood, content) VALUES " +
                "('Test title', 'hungry', 'Didnt eat enough today..')";
        sqLiteDatabase.execSQL(insertEntry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS Entries");
        onCreate(sqLiteDatabase);
    }

    private EntryDatabase(@Nullable Context context, @Nullable String name,
                          @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static EntryDatabase getInstance(Context context) {
        if (instance == null){
            instance = new EntryDatabase(context, "databaseJournal", null, 1 );
        }
        return instance;
    }

    public void insert(JournalEntry entry) {
        SQLiteDatabase sqLiteDatabase = instance.getWritableDatabase();

        // Store the variables in ContentValues
        ContentValues content = new ContentValues();
        content.put("title", entry.getTitle());
        content.put("mood", entry.getMood());
        content.put("content", entry.getContent());
        sqLiteDatabase.insert("Entries", null, content);
        Log.d("SUCCEFULLY INSERTED???????!!!", entry.getTitle());
    }

    public Cursor selectAll() {
        SQLiteDatabase db = getWritableDatabase();
        return db.rawQuery("SELECT * FROM Entries", null);
    }

    public void delete(long id) {
        SQLiteDatabase sqLiteDatabase = instance.getWritableDatabase();
        sqLiteDatabase.delete("Entries", "_id=?", new String[]{Long.toString(id)});
    }

    public void getEntry(long id) {
        SQLiteDatabase sqLiteDatabase = instance.getWritableDatabase();
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM Entries WHERE _id=?", new String[]{Long.toString(id)});

    }
}