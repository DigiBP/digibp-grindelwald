package ch.fhnw.digibp.adapter;

import java.util.UUID;

import org.apache.commons.lang.StringUtils;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component("GenerateRequestID")
public class GenerateRequestIDListener implements ExecutionListener {
    private static Logger logger = LoggerFactory.getLogger(StatusUpdateListener.class);

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        String requestID = execution.getBusinessKey();
        if(StringUtils.isEmpty(requestID)){
            requestID = UUID.randomUUID().toString();
            execution.setProcessBusinessKey(requestID);
            execution.setVariable("requestID", requestID);
            execution.setVariable("submissionDate", new java.util.Date());
            logger.info("Working on a new request (generated id):" + requestID);
        }
    }
  }