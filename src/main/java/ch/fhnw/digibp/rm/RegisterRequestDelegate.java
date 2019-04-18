package ch.fhnw.digibp.rm;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

import ch.fhnw.digibp.db.RequestDAO;

public class RegisterRequestDelegate implements JavaDelegate {

    RequestDAO request = new RequestDAO();

    public void execute(DelegateExecution execution) throws Exception {
        String businessKey = execution.getBusinessKey();
        System.out.println("Working on with request:" + businessKey);
        request.registerRequest(businessKey, null);
    }
  }