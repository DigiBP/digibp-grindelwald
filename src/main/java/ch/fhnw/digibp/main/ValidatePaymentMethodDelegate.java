package ch.fhnw.digibp.main;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * ValidatePaymentMethodDelegate
 */
public class ValidatePaymentMethodDelegate implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("VALIDATE-PAYMENTMETHOD");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("...");
        execution.setVariable("status", "success");
    }

}
