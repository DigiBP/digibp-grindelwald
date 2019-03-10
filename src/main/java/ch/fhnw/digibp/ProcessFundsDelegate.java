package ch.fhnw.digibp;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * ProcessFundsDelegate
 */
public class ProcessFundsDelegate implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("GET-FUNDS");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("Processing request by '" + execution.getVariable("customerId") + "'...");
        execution.setVariable("paymentId", "PAID-001");
        execution.setVariable("status", "success");
    }

}
