package ch.fhnw.digibp.equipment;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * ProcessAnswerDelegate
 */
public class ProcessAnswerDelegate implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("GET-ANSWER");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("Processing request by '" + execution.getVariable("customerId") + "'...");
        execution.setVariable("orderId", "ORDE-001");
        execution.setVariable("orderState", "confirmed");
    }

}
