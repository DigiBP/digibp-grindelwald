package ch.fhnw.digibp.db;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

import com.google.api.core.ApiFuture;
import com.google.cloud.Timestamp;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;

public class RequestDAO extends FirestoreDBCon {
    private final static  String COLLECTION_REQUEST = "requests";
    public final static String COLLECTION_METADATA = "metadata";
    public final static String  COLLECTION_DATA = "data";
    private Firestore db = null;

    public RequestDAO() {
        this.db = super.getInstance();
    }

    public void setRequest(String requestId,  Map<String, Object> docData) throws InterruptedException, ExecutionException {
        if (docData == null) docData = new HashMap<>();
        docData.put("statusTimestamp", Timestamp.now().toString());
        ApiFuture<WriteResult> future = db.collection(COLLECTION_REQUEST).document(requestId).set(docData);
        System.out.println("Update time : " + future.get().getUpdateTime());
    };

    public void updateRequest(String requestId, Map<String, Object> docData) throws InterruptedException, ExecutionException {
        if (docData == null) docData = new HashMap<>();
        docData.put("statusTimestamp", Timestamp.now().toString());
        ApiFuture<WriteResult> future = db.collection(COLLECTION_REQUEST).document(requestId).update(docData);
        System.out.println("Update time : " + future.get().getUpdateTime());
    };

    public void setDataRequest(String requestId, String dataType, Map<String, Object> docData) throws InterruptedException, ExecutionException {
        if (docData == null) docData = new HashMap<>();
        docData.put("requestTimestamp", Timestamp.now().toString());
        ApiFuture<WriteResult> future = db
        .collection(COLLECTION_REQUEST)
        .document(requestId)
        .collection(dataType)
        .document(UUID.randomUUID().toString())
        .set(docData);
        System.out.println("Update time : " + future.get().getUpdateTime());
    };

    public void updateDataUpload(String requestId, String dataType, Map<String, Object> docData) throws InterruptedException, ExecutionException {
        if (docData == null) docData = new HashMap<>();
        docData.put("uploadTimestamp", Timestamp.now().toString());
        ApiFuture<WriteResult> future = db
        .collection(COLLECTION_REQUEST)
        .document(requestId)
        .collection(dataType)
        .document(UUID.randomUUID().toString())
        .update(docData);
        System.out.println("Update time : " + future.get().getUpdateTime());
    };

    public boolean hasDublicate(String requestId) throws InterruptedException, ExecutionException {
        ApiFuture<DocumentSnapshot> query = db.collection(COLLECTION_REQUEST).document(requestId).get();
        return query.get().exists();
    }

}