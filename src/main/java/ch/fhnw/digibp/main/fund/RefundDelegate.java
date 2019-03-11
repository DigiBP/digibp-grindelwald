package ch.fhnw.digibp.main.fund;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * RefundDelegate
 */
public class RefundDelegate implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("GET-FUNDS");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("...");
        execution.setVariable("paymentId", "PAID-001");
        execution.setVariable("status", "success");
    }

}
