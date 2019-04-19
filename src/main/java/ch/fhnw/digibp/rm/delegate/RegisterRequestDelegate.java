package ch.fhnw.digibp.rm.delegate;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.google.cloud.Timestamp;

import org.apache.commons.lang.StringUtils;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import ch.fhnw.digibp.db.RequestDAO;

public class RegisterRequestDelegate implements JavaDelegate {

    RequestDAO request = new RequestDAO();

    public void execute(DelegateExecution execution) throws Exception {
        String requestId = execution.getBusinessKey();
        Map<String, Object> docData = new HashMap<>();
        docData.put("customerId", execution.getVariable("customerId"));
        docData.put("coordination", execution.getVariable("coordination"));
        docData.put("dataDirectlyAvailable", execution.getVariable("dataDirectlyAvailable"));
        docData.put("deadline", Timestamp.parseTimestamp("2020-09-25T00:00:00Z").toString());
        docData.put("status", "RUNNING");
        docData.put("statusTimestamp", Timestamp.now().toString());
        docData.put("status", "RUNNING");

        if(StringUtils.isEmpty(requestId)){
            System.out.println(this.getClass().getSimpleName() + " - Working on a new request (generated id):" + requestId);
            requestId = UUID.randomUUID().toString();
            execution.setProcessBusinessKey(requestId);
            request.setRequest(requestId, docData);
        } else if (request.hasDublicate(requestId)){
            System.out.println(this.getClass().getSimpleName() + " - Working on the existing request:" + requestId);
            request.updateRequest(requestId, docData);
        } else {
            System.out.println(this.getClass().getSimpleName() + " - Working on a new request (provided id):" + requestId);
            request.setRequest(requestId, docData);
        }
    }
  }