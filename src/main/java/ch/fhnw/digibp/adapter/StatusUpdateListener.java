package ch.fhnw.digibp.adapter;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.camunda.bpm.engine.delegate.Expression;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ch.fhnw.digibp.service.StatusService;

@Component("SendStatusUpdate")
public class StatusUpdateListener implements ExecutionListener {
  private static Logger logger = LoggerFactory.getLogger(StatusUpdateListener.class);

  private StatusService statusService;
  private Expression status;

  @Autowired
  public StatusUpdateListener(StatusService statusService) {
    this.statusService = statusService;
  }

  @Override
  public void notify(DelegateExecution execution) throws Exception {
    logger.info("preparing status update\r\n");
    statusService.sendUpdate((String) execution.getBusinessKey(), (String) status.getValue(execution));
  }
}