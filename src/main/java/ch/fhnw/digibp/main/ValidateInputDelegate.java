package ch.fhnw.digibp.main;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * ValidateInputDelegate
 */
public class ValidateInputDelegate implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("VALIDATE-INPUT");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("...");
        execution.setVariable("rentEquipment", true);
        execution.setVariable("buyTicket", true);
        execution.setVariable("hireInstructor", true);
    }

}
