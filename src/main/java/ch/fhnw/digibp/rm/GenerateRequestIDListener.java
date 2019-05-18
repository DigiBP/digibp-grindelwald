package ch.fhnw.digibp.rm;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;

public class GenerateRequestIDListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        String requestId = execution.getBusinessKey();
        if(StringUtils.isEmpty(requestId)){
            System.out.println(this.getClass().getSimpleName() + " - Working on a new request (generated id):" + requestId);
            requestId = UUID.randomUUID().toString();
            execution.setProcessBusinessKey(requestId);
        }
    }
  }