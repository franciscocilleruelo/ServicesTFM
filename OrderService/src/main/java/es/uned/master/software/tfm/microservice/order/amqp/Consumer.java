package es.uned.master.software.tfm.microservice.order.amqp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

import es.uned.master.software.tfm.microservice.order.jpa.entity.Order;
import es.uned.master.software.tfm.microservice.order.service.OrderService;

@Component
public class Consumer {
	
	private static final Logger log = LoggerFactory.getLogger(Consumer.class);

	@Autowired
	private OrderService orderService;
	
	@RabbitListener(queues="${queue.customers.name}")
	public void handleMessage(String message){
		log.info("Recibido mensaje {}", message);
		ObjectMapper mapper = new ObjectMapper();
		try {
			Order order = mapper.readValue(message, Order.class);
			orderService.udpate(order);
		} catch (Exception ex){
			log.error("Error en la conversión del mensaje JSON {} a objeto partir del objecto del tipo", message, Order.class);
		}
		
	}
}
