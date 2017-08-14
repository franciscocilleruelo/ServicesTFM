package es.uned.master.software.tfm.microservice.customer.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.uned.master.software.tfm.microservice.customer.jpa.entity.Order;
import es.uned.master.software.tfm.microservice.customer.service.CustomerService;

@Component
public class Consumer {
	
	private static final Logger log = LoggerFactory.getLogger(Consumer.class);

	@Autowired
	private CustomerService customerService;
	
	@RabbitListener(queues="${queue.orders.name}")
	public void handleMessage(String message){
		log.info("Recibido mensaje {}", message);
		ObjectMapper mapper = new ObjectMapper();
		try {
			Order order = mapper.readValue(message, Order.class);
			customerService.checkLimit(order);
		} catch (Exception ex){
			log.error("Error en la conversión del mensaje JSON {} a objeto partir del objecto del tipo", message, Order.class);
		}
		
	}
}
