package info.androidhive.firebase.database;

import android.content.ContentValues;
import android.content.Context;
import info.androidhive.firebase.database.Contract__class.*;
import info.androidhive.firebase.model.Question;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;

public class QuestionDbHelper extends SQLiteOpenHelper {
    private static final String Database_name="Question.db";
    private static final int Db_version=1;
    private SQLiteDatabase db;

    public QuestionDbHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, Database_name, null, Db_version);
        //this call the parent class of the database and will sets the parameters of the database we are going to use.
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db=db;
        final String sql_create_question_table="CREATE TABLE "+
                QuestionsTable.TABLE_NAME+
                "("+
                QuestionsTable._ID+"INTEGER PRIMARY KEY AUTOINCREMENT,"+
                QuestionsTable.COL_QUESTION+"TEXT,"+
                QuestionsTable.OPTION_1+"TEXT,"+
                QuestionsTable.OPTION_2+"TEXT,"+
                QuestionsTable.OPTION_3+"TEXT"+
                ")";
        db.execSQL(sql_create_question_table);
        //this will be created only once if the application is uninstalled then it is again created in the memory but for now it is only created once
    fillquestions();
    }

    private void fillquestions() {
        Question q1=new Question("Do you Like this college ","YES","NO","partially ");
        addquestion(q1);
        Question q2=new Question("Do you Like this college ","YES","NO","partially ");
        addquestion(q2);
        Question q3=new Question("Do you Like this college ","YES","NO","partially ");
        addquestion(q3);
        Question q4=new Question("Do you Like this college ","YES","NO","partially ");
        addquestion(q4);
        Question q5=new Question("Do you Like this college ","YES","NO","partially ");
        addquestion(q5);
        Question q6=new Question("Do you Like this college ","YES","NO","partially ");
        addquestion(q6);
        Question q7=new Question("Do you Like this college ","YES","NO","partially ");
        addquestion(q7);
    }

    private void addquestion(Question question) {
        ContentValues cv=new ContentValues();
        cv.put(QuestionsTable.COL_QUESTION,question.getQuestion());
        cv.put(QuestionsTable.OPTION_1,question.getOption1());
        cv.put(QuestionsTable.OPTION_2,question.getOption2());
        cv.put(QuestionsTable.OPTION_3,question.getOption3());
        db.insert(QuestionsTable.TABLE_NAME,null,cv);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
     db.execSQL("DROP TABLE IF EXISTS "+QuestionsTable.TABLE_NAME);
     onCreate(db);
    }
}
