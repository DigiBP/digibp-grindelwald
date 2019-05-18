package ch.fhnw.digibp.rm;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

public class GenerateRequestIDListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        String requestID = execution.getBusinessKey();
        if(StringUtils.isEmpty(requestID)){
            requestID = UUID.randomUUID().toString();
            execution.setProcessBusinessKey(requestID);
            execution.setVariable("requestID", requestID);
            execution.setVariable("submissionDate", new java.util.Date());
            System.out.println(this.getClass().getSimpleName() + " - Working on a new request (generated id):" + requestID);
        }
    }
  }