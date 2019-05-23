package ch.fhnw.digibp.service;

import org.camunda.spin.Spin;
import org.camunda.spin.json.SpinJsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StatusService {

    private static Logger logger = LoggerFactory.getLogger(StatusService.class);
    private RestTemplate restTemplate;

    @Value("${statusUpdateWebhookURL}")
    private String statusUpdateWebhookURL;

    @Autowired
    public StatusService(RestTemplate restTemplate) {
      this.restTemplate =restTemplate;
    }
 
    public void sendUpdate(String requresID, String status) {
        logger.info("sending status update\r\n");
        logger.info("requestID:" +  requresID);
        logger.info("status:" +  status);
      
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
      
        SpinJsonNode requestJson = Spin.JSON("{}");
        requestJson.prop("requestID", requresID);
        requestJson.prop("status", status);
      
        HttpEntity<String> request = new HttpEntity<>(requestJson.toString(), headers);
      
        ResponseEntity<String> result = restTemplate.postForEntity(statusUpdateWebhookURL, request, String.class);
        if (!result.getStatusCode().is2xxSuccessful()) {
            throw new RuntimeException("Error while starting customer update process" + result.getStatusCode());
        }
        logger.info("response:\r\n" +  result.toString());
    }
  }