package sqlite;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

/**
 * Created by Administrator on 2016/12/2.
 */
public class MySQLiteHelper extends SQLiteOpenHelper{

    private Context context;
    public static final String CREATE_TABLE="create table student(" +
            "_id integer primary key autoincrement," +
            "name text not null," +
            "age integer not null," +
            "score real not null)";

    public MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(CREATE_TABLE);
        Toast.makeText(context, "建表成功", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
       db.execSQL("drop table if exists student");
        onCreate(db);
    }
}
