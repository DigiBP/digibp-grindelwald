package ch.fhnw.digibp.rm.listener;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.delegate.Expression;

import ch.fhnw.digibp.db.RequestDAO;

public class DataRequestedListener implements ExecutionListener {

    RequestDAO request = new RequestDAO();
    private Expression dataType;

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        String requestId = execution.getBusinessKey();
        System.out.println(this.getClass().getSimpleName() + " - Working on the request:" + requestId);
        //Requester
        Map<String, Object> requesterInfo = new HashMap<>();
        requesterInfo.put("dataRequester", execution.getVariable("requester"));
        //Data Info
        Map<String, Object> dataInfo = new HashMap<>();
        dataInfo.put("requester", requesterInfo);
        //Doc Data
        Map<String, Object> docData = new HashMap<>();
        docData.put(dataType.getValue(execution).toString(), dataInfo);
        request.waitingDataUpdateRequest(requestId, docData);
    }
  }