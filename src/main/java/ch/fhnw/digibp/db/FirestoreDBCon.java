package ch.fhnw.digibp.db;

import java.io.IOException;
import java.io.InputStream;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

public abstract class FirestoreDBCon {

    private static final String SA_FILE_PATH = "/grindelwald-firebase-sa.json";
    private static final String SERVICE_ADDRESS = "https://grindelwald-638c8.firebaseio.com";

    public FirestoreDBCon() {
        InputStream serviceAccount = this.getClass().getResourceAsStream(SA_FILE_PATH);
        try {
            GoogleCredentials credentials = GoogleCredentials.fromStream(serviceAccount);
            //FirestoreOptions fsOptions = FirestoreOptions.newBuilder().setTimestampsInSnapshotsEnabled(true).build();
            FirebaseOptions fbOptions = new FirebaseOptions.Builder()
            .setCredentials(credentials)
            .setDatabaseUrl(SERVICE_ADDRESS)
            //.setFirestoreOptions(fsOptions)
            .build();
            FirebaseApp.initializeApp(fbOptions);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Firestore getInstance(){
        return FirestoreClient.getFirestore();
    }

}