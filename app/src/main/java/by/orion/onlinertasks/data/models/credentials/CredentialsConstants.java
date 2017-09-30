package by.orion.onlinertasks.data.models.credentials;


import android.support.annotation.NonNull;

public class CredentialsConstants {

    public static final class AuthenticationGrants {

        @NonNull
        public static final String PASSWORD = "password";

        @NonNull
        public static final String REFRESH = "refresh_token";

        private AuthenticationGrants() {
        }
    }

    public static class AuthenticationClients {

        @NonNull
        public static final String USER = "onliner_user";

        private AuthenticationClients() {
        }
    }
}
