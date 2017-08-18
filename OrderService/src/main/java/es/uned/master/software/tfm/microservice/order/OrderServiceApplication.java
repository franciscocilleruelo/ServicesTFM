package es.uned.master.software.tfm.microservice.order;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class OrderServiceApplication {
	
	private static final Logger log = LoggerFactory.getLogger(OrderServiceApplication.class);

	public static void main(String[] args) {
		log.info("Arrancado microservicio de pedidos");
		SpringApplication.run(OrderServiceApplication.class, args);
	}
	
	@Value("${queue.orders.name}")
	private String ordersQueueName;
	
	@Bean
	public Queue ordersQueue(){
		return new Queue(ordersQueueName, false, false, false);
	}
	
	@Value("${queue.customers.name}")
	private String customersQueueName;
	
	@Bean
	public Queue customersQueue(){
		return new Queue(customersQueueName, false, false, false);
	}
	
}
