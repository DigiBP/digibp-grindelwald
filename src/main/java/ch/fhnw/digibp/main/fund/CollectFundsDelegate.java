package ch.fhnw.digibp.main.fund;

import java.util.logging.Logger;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * CollectFundsDelegate
 */
public class CollectFundsDelegate implements JavaDelegate {

    private final static Logger LOGGER = Logger.getLogger("REFUND");

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        LOGGER.info("...");
        execution.setVariable("paymentId", "PAID-001");
        execution.setVariable("status", "success");
    }

}
