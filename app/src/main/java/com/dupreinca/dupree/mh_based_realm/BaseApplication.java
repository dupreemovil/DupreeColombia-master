package com.dupreinca.dupree.mh_based_realm;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by cloudemotion on 5/9/17.
 */

public class BaseApplication extends Application {

    private static final String TAG = "MyApplication";

    public void onCreate() {
        super.onCreate();
        // The default Realm file is "default.realm" in Context.getFilesDir();
        // we'll change it to "myrealm.realm"
        Realm.init(this);
        RealmConfiguration config = new RealmConfiguration.Builder()
                .schemaVersion(2)
                .deleteRealmIfMigrationNeeded()// si hay un cambio en la estructura de la base de
                // datos, la elimina, tras una actualizacion de la app
                .name("myrealm2.realm")
                .build();


        Realm.setDefaultConfiguration(config);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }
}
