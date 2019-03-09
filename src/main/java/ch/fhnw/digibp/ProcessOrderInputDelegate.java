package ch.fhnw.digibp;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

/**
 * ProcessOrderInputDelegate
 */
public class ProcessOrderInputDelegate implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        execution.setVariable("customerId", "CSRM-001");
        execution.setVariable("caseId", "CASE-001");
        execution.setVariable("rentEquipment", true);
        execution.setVariable("buyTicket", true);
        execution.setVariable("hireInstructor", true);
    }

}
