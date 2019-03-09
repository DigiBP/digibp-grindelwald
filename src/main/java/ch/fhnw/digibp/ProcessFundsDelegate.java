package ch.fhnw.digibp;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * ProcessFundsDelegate
 */
public class ProcessFundsDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable("paymentId", "PAID-001");
        execution.setVariable("status", "success");
    }

}
