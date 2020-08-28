package com.dt;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class App {

    private static final CloseableHttpClient httpClient = HttpClients.createDefault();

    public static void main(String[] args) throws InterruptedException, IOException {
        while(true) {
            request();
            Thread.sleep(100);
        }
    }

    static void request() throws IOException {
        HttpGet request = new HttpGet("http://localhost:8080");

        try (CloseableHttpResponse response = httpClient.execute(request)) {

            System.out.println(response.getStatusLine().toString());

            HttpEntity entity = response.getEntity();
            Header headers = entity.getContentType();
            System.out.println(headers);

            if (entity != null) {
                String result = EntityUtils.toString(entity);
                System.out.println(result);
            }

        }
    }
}
