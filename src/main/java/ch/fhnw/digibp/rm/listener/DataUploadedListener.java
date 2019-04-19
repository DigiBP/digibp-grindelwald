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
    private Expression newUpload;

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        String requestId = execution.getBusinessKey();
        System.out.println(this.getClass().getSimpleName() + " - Working on the request:" + requestId);

        String dataId = (String) execution.getVariable(dataType.getValue(execution).toString() + "Id");
        if (dataId == null || dataId.isEmpty()) {
            System.out.println(this.getClass().getSimpleName() + " - Working on the " + dataType.getValue(execution).toString() +": no id");
        }else{
            System.out.println(this.getClass().getSimpleName() + " - Working on the " + dataType.getValue(execution).toString() +": " + dataId);
        }
       
        //Data Info
        Map<String, Object> dataInfo = new HashMap<>();
        dataInfo.put("requesterId", execution.getVariable("requesterId"));
        dataInfo.put("uploaderId", execution.getVariable("dataUploaderId"));
        dataInfo.put("uploaderType", uploaderType.getValue(execution).toString());
        dataInfo.put("link", execution.getVariable("link"));

        //Doc Data
        Map<String, Object> docData = new HashMap<>();
        docData.put("status", "RUNNING");
        docData.put(dataType.getValue(execution).toString(), dataInfo);

        request.updateRequest(requestId, docData);

        dataInfo.put("status", "COMPLETED");

        if(dataId == null || dataId.isEmpty() || newUpload.getValue(execution).toString().equals("true")) {
            dataId = request.setDataRequest(requestId, dataType.getValue(execution).toString(), dataInfo);
            System.out.println(this.getClass().getSimpleName() + " - Working on the " + dataType.getValue(execution).toString() +":" + dataId);
            execution.setVariable(dataType.getValue(execution).toString() + "Id", dataId);
        }
        else {
            request.updateDataUpload(requestId, dataType.getValue(execution).toString(), dataId, dataInfo);
        }
    }
  }