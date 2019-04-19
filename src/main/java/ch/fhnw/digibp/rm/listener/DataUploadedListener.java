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
        System.out.println(this.getClass().getSimpleName() + " - Working on the request:" + requestId);

        //Data Info
        Map<String, Object> dataInfo = new HashMap<>();
        dataInfo.put("requesterId", execution.getVariable("dataRequesterId"));
        dataInfo.put("uploaderId", execution.getVariable("dataUploaderId"));
        dataInfo.put("uploaderType", uploaderType.getValue(execution).toString());
        dataInfo.put("link", execution.getVariable("link"));

        //Doc Data
        Map<String, Object> docData = new HashMap<>();
        docData.put("status", "RUNNING");
        docData.put(dataType.getValue(execution).toString(), dataInfo);

        request.updateRequest(requestId, docData);

        dataInfo.put("status", "RUNNING");
        request.updateDataUpload(requestId, dataType.getValue(execution).toString(), dataInfo);
    }
  }