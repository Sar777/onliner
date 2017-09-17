package by.orion.onlinertasks.data.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import by.orion.onlinertasks.BuildConfig;

public class DbOpenHelper extends SQLiteOpenHelper {

    public DbOpenHelper(@NonNull Context context) {
        super(context, BuildConfig.DATABASE_NAME, null, BuildConfig.DATABASE_VERSION);
    }

    @Override
    public void onCreate(@NonNull SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(@NonNull SQLiteDatabase db, int oldVersion, int newVersion) {
        // no impl
    }
}
