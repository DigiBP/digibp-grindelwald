package ch.fhnw.digibp.rm.listener;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.delegate.Expression;

import ch.fhnw.digibp.db.RequestDAO;

public class DataUploadedListener implements ExecutionListener {

    RequestDAO request = new RequestDAO();
    private Expression uploaderType;
    private Expression dataType;

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        String requestId = execution.getBusinessKey();
        System.out.println("Working on the request:" + requestId);
        //Uploader
        Map<String, Object> uploaderInfo = new HashMap<>();
        uploaderInfo.put("id", execution.getVariable("uploader"));
        uploaderInfo.put("type", uploaderType.getValue(execution).toString());
        //Data Info
        Map<String, Object> dataInfo = new HashMap<>();
        dataInfo.put("uploader", uploaderInfo);
        dataInfo.put("link", execution.getVariable("link"));
        //Doc Data
        Map<String, Object> docData = new HashMap<>();
        docData.put(dataType.getValue(execution).toString(), dataInfo);
        request.dataUploadedRequest(requestId, docData);
    }
  }