package com.sk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Collections;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@SpringBootApplication
public class SpringCloudFunApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFunApplication.class, args);
	}

	@Bean
	public Function<String, GatewayResponse> computePayment(){
		return input -> new GatewayResponse(input, 200, Collections.singletonMap("X-token", "abcd"), false);
	 }

	 @Bean
	public Consumer<String> consumer(){
		return input -> System.out.println(input);
	 }

	 @Bean
	public Supplier<String> supplier(){
		return ()-> "Hello from skarre labmda";
	 }
}


class GatewayResponse {
	private String body;
	private Integer statusCode;
	private Map<String, String> headers;
	private boolean isBase64Encoded;

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public Integer getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(Integer statusCode) {
		this.statusCode = statusCode;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public void setHeaders(Map<String, String> headers) {
		this.headers = headers;
	}

	public boolean isBase64Encoded() {
		return isBase64Encoded;
	}

	public void setBase64Encoded(boolean base64Encoded) {
		isBase64Encoded = base64Encoded;
	}

	public GatewayResponse(String body, Integer statusCode, Map<String, String> headers, boolean isBase64Encoded) {
		this.body = body;
		this.statusCode = statusCode;
		this.headers = headers;
		this.isBase64Encoded = isBase64Encoded;
	}
}
