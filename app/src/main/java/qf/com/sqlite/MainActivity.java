package qf.com.sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import sqlite.MySQLiteHelper;

public class MainActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView) findViewById(R.id.tv);
    }
    public void insertData(View view){
        MySQLiteHelper mySQLiteHelper=new MySQLiteHelper(this,"mydb.db",null,1);
        SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();//打开数据库
        ContentValues values=new ContentValues();//获取存储数据库的集合存储机制
        values.put("name","张三");
        values.put("age",20);
        values.put("score",78);
        long insertdata = db.insert("student", null, values);
        if (insertdata>0){
            Toast.makeText(MainActivity.this, "数据插入成功", Toast.LENGTH_SHORT).show();
        }
    }
    public void updateData(View view){
        MySQLiteHelper mySQLiteHelper=new MySQLiteHelper(this,"mydb.db",null,1);
        SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();
        ContentValues values=new ContentValues();
        values.put("age",10);
        int update = db.update("student", values, "_id=?", new String[]{"1"});
        if (update>0){
            Toast.makeText(MainActivity.this, "数据库修改成功", Toast.LENGTH_SHORT).show();
        }
    }
    public void deleteData(View view){
        MySQLiteHelper mySQLiteHelper=new MySQLiteHelper(this,"mydb.db",null,1);
        SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();
        int delete = db.delete("student", "_id=?", new String[]{"1"});
        if (delete>0){
            Toast.makeText(MainActivity.this, "数据库删除成功", Toast.LENGTH_SHORT).show();
        }
    }
    public void quetyData(View view){
        MySQLiteHelper mySQLiteHelper=new MySQLiteHelper(this,"mydb.db",null,1);
        SQLiteDatabase db = mySQLiteHelper.getReadableDatabase();
        Cursor query = db.query("student", new String[]{"_id,name,age,score"}, "name=?", new String[]{"张三"}, null, null, null);
        String info="";
        Toast.makeText(MainActivity.this, "sdfsdggsagd", Toast.LENGTH_SHORT).show();
        while(query.moveToNext()){
            int id = query.getInt(query.getColumnIndex("_id"));
            String name = query.getString(query.getColumnIndex("name"));
            int age = query.getInt(query.getColumnIndex("age"));
            double score = query.getDouble(query.getColumnIndex("score"));
            info="_id"+id+";name"+name+";age"+age+";score"+score;
            Log.d("zkq","name==="+name);
        }
        tv.setText(info);
    }
}
