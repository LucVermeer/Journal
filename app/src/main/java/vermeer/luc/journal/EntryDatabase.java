package vermeer.luc.journal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class EntryDatabase extends SQLiteOpenHelper {
    private static EntryDatabase instance;
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String initTable = "create table entries(_id INTEGER PRIMARY KEY AUTOINCREMENT, title TEXT, content TEXT, mood INT, timestamp DATETIME DEFAULT CURRENT_TIMESTAMP)";
        sqLiteDatabase.execSQL(initTable);

        String insertTutorialEntry = "INSERT INTO Entries (Title, Mood, Content) VALUES " +
                "('Title', 0, 'contentcontent content content')";
        sqLiteDatabase.execSQL(insertTutorialEntry);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS entries");
        onCreate(sqLiteDatabase);
    }

    private EntryDatabase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static EntryDatabase getInstance(Context context) {
        if (instance == null){
            instance = new EntryDatabase(context, "databaseJournal", null, 1 );
        }
        return instance;
    }
}
