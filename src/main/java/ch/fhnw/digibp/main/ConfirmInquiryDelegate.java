package ch.fhnw.digibp.main;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * ConfirmInquiryDelegate
 */
public class ConfirmInquiryDelegate implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("CONFIRM");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("...");
        execution.setVariable("message", "payload");
    }

}
