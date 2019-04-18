package ch.fhnw.digibp.rm;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import com.google.cloud.Timestamp;

import org.apache.commons.lang.StringUtils;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import ch.fhnw.digibp.db.RequestDAO;

public class CancelRequestDelegate implements JavaDelegate {

    RequestDAO request = new RequestDAO();

    public void execute(DelegateExecution execution) throws Exception {
        String businessKey = execution.getBusinessKey();
        if(StringUtils.isEmpty(businessKey)){
            businessKey = "R" + UUID.randomUUID().toString();
            execution.setProcessBusinessKey(businessKey);
        }
        if(request.hasDublicate(businessKey)){
            System.out.println("Working on existing request:" + businessKey);
        }
        Map<String, String> docData = new HashMap<>();
        docData.put("requester", "John Doe");
        docData.put("deadline", Timestamp.parseTimestamp("2020-09-25T00:00:00Z").toString());
        docData.put("status", "OPEN");
        docData.put("statusTimestamp", Timestamp.now().toString());
        request.registerRequest(businessKey, docData);
    }
  }