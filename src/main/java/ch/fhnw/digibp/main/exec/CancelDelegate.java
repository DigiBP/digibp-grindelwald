package ch.fhnw.digibp.main.exec;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * CancelRentDelegate
 */
public class CancelDelegate implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("CANCEL");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("...");
        execution.setVariable("caseId", "CASE-001");
        execution.setVariable("caseType", "RENT");
    }

}
