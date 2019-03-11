package ch.fhnw.digibp.main;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * OpenCaseDelegate
 */
public class OpenCaseDelegate implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("CASE-MAIN-OPEN");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("...");
        execution.setVariable("caseId", "CASE-001");
        execution.setVariable("caseType", "MAIN");
    }

}
