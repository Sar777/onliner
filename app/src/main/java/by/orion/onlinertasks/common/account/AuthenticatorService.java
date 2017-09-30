package by.orion.onlinertasks.common.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import javax.inject.Inject;

import by.orion.onlinertasks.App;
import by.orion.onlinertasks.data.repository.credentials.CredentialsRepository;

public class AuthenticatorService extends Service {

    @Inject
    CredentialsRepository credentialsRepository;

    private UserAuthenticator userAuthenticator;

    @Override
    public void onCreate() {
        super.onCreate();

        App.getComponent().inject(this);

        userAuthenticator = new UserAuthenticator(getApplicationContext(), credentialsRepository);
    }

    @Override
    public IBinder onBind(Intent intent) {
        return userAuthenticator.getIBinder();
    }
}
