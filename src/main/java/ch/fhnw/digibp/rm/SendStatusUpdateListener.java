package ch.fhnw.digibp.rm;

import java.io.DataOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.ExecutionListener;
import org.springframework.stereotype.Component;

import ch.fhnw.digibp.rm.util.ParameterStringBuilder;

@Component
public class SendStatusUpdateListener implements ExecutionListener {

    @Override
    public void notify(DelegateExecution execution) throws Exception {
        URL url = new URL("https://hook.integromat.com/phxd3eepyetckunbowpf7ps9a3y4hk76");
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");

        Map<String, String> parameters = new HashMap<>();
        parameters.put("requestID", execution.getBusinessKey());
        parameters.put("status", "RECEIVED");
        con.setDoOutput(true);
        DataOutputStream out = new DataOutputStream(con.getOutputStream());
        out.writeBytes(ParameterStringBuilder.getParamsString(parameters));
        out.flush();
        out.close();
    }
  }