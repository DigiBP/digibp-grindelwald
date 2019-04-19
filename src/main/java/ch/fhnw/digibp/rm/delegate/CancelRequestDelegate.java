package ch.fhnw.digibp.rm.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import ch.fhnw.digibp.db.RequestDAO;

public class CancelRequestDelegate implements JavaDelegate {

    RequestDAO request = new RequestDAO();

    public void execute(DelegateExecution execution) throws Exception {
        String businessKey = execution.getBusinessKey();
        System.out.println("Working with request:" + businessKey);
        request.cancelRequest(businessKey, null);
    }
  }