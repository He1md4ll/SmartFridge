package com.smart.fridge;

import org.junit.Test;

public class CoolTest {
    @Test
    public void test() {
        String URLString = "http://10.80.57.41:8080/rest/getMeals";



    /*ClientConfig clientConfig = new DefaultClientConfig();
    clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
    Client client = Client.create(clientConfig);
    WebResource webResourceGet = client.resource(URLString);
    ClientResponse response = webResourceGet.get(ClientResponse.class);
      ResponseEntity<MealPerformance[]> responseEntity = response.getEntity(MealPerformance[].class);
    List<MealPerformance> responseEntity = response.getEntity(MealPerformance[].class);
      response.getEntity()
    System.out.println(responseEntity); */
    }
}
