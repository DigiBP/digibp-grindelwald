package ch.fhnw.digibp.db;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;

public class RequestDAO extends FirestoreDBCon {
    final private String COLLECTION = "requests";
    private Firestore db = null;

    public RequestDAO() {
        if (this.db != null){
            this.db = super.getInstance();
        }
    }

    public void registerRequest(String requestId,  Map<String, String> docData) throws InterruptedException, ExecutionException {
        ApiFuture<WriteResult> future = db.collection(COLLECTION).document(requestId).set(docData);
        System.out.println("Update time : " + future.get().getUpdateTime());
    };

    public void fulfillRequest(String requestId,  Map<String, Object> docData) throws InterruptedException, ExecutionException {
        if (docData == null) docData = new HashMap<>();
        docData.put("status", "FULLFILLED");
        docData.put("statusTimestamp", Timestamp.now().toString());
        ApiFuture<WriteResult> future = db.collection(COLLECTION).document(requestId).update(docData);
        System.out.println("Update time : " + future.get().getUpdateTime());
    };

    public void cancelRequest(String requestId,  Map<String, Object> docData) throws InterruptedException, ExecutionException {
        if (docData == null) docData = new HashMap<>();
        docData.put("status", "CANCELLED");
        docData.put("statusTimestamp", Timestamp.now().toString());
        ApiFuture<WriteResult> future = db.collection(COLLECTION).document(requestId).update(docData);
        System.out.println("Update time : " + future.get().getUpdateTime());
    };

    public boolean hasDublicate(String requestId) throws InterruptedException, ExecutionException {
        ApiFuture<DocumentSnapshot> query = db.collection(COLLECTION).document(requestId).get();
        return query.get().exists();
    };

}