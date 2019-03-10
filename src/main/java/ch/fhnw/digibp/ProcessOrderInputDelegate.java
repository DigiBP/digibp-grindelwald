package ch.fhnw.digibp;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * ProcessOrderInputDelegate
 */
public class ProcessOrderInputDelegate implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("ORDER-INPUT");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("Processing request by '" + execution.getVariable("customerId") + "'...");
        execution.setVariable("customerId", "CSRM-001");
        execution.setVariable("caseId", "CASE-001");
        execution.setVariable("rentEquipment", true);
        execution.setVariable("buyTicket", true);
        execution.setVariable("hireInstructor", true);
    }

}
