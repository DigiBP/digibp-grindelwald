package ch.fhnw.digibp.rm.delegate;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import ch.fhnw.digibp.db.RequestDAO;

public class CancelRequestDelegate implements JavaDelegate {

    RequestDAO request = new RequestDAO();

    public void execute(DelegateExecution execution) throws Exception {
        String requestId = execution.getBusinessKey();
        System.out.println(this.getClass().getSimpleName() + " - Working on the request:" + requestId);

        //Cancellation Data
        Map<String, Object> cancellationInfo = new HashMap<>();
        cancellationInfo.put("requesterId", execution.getVariable("cancellationRequesterId"));
        cancellationInfo.put("reasonId", execution.getVariable("reasonId"));
        cancellationInfo.put("reasonDescription", execution.getVariable("reasonDescription"));

        //Doc Data
        Map<String, Object> docData = new HashMap<>();
        docData.put("status", "CANCELLED");
        docData.put("cancel", cancellationInfo);

        request.updateRequest(requestId, docData);
    }
  }