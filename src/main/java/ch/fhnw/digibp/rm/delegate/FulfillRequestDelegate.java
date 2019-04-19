package ch.fhnw.digibp.rm.delegate;

import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import ch.fhnw.digibp.db.RequestDAO;

public class FulfillRequestDelegate implements JavaDelegate {

    RequestDAO request = new RequestDAO();

    public void execute(DelegateExecution execution) throws Exception {
        String requestId = execution.getBusinessKey();
        System.out.println(this.getClass().getSimpleName() + " - Working on the request:" + requestId);
        Map<String, Object> docData = new HashMap<>();
        docData.put("status", "COMPLETED");
        request.updateRequest(requestId, docData);
    }
  }