package by.orion.onlinernews;

import com.facebook.stetho.Stetho;

import hugo.weaving.DebugLog;
import timber.log.Timber;

public class DebugApp extends App {

    @Override
    public void onCreate() {
        super.onCreate();

        initStetho();
        initTimber();
    }

    @DebugLog
    private void initTimber() {
        Timber.plant(new Timber.DebugTree());
    }

    @DebugLog
    private void initStetho() {
        Stetho.InitializerBuilder initializerBuilder = Stetho.newInitializerBuilder(this);
        // Enable Chrome DevTools
        initializerBuilder.enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this));
        // Enable command line interface
        initializerBuilder.enableDumpapp(Stetho.defaultDumperPluginsProvider(this));
        // Use the InitializerBuilder to generate an Initializer
        Stetho.Initializer initializer = initializerBuilder.build();
        // Initialize Stetho with the Initializer
        Stetho.initialize(initializer);
    }
}
