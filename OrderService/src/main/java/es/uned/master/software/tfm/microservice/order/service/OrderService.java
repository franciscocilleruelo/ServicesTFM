package es.uned.master.software.tfm.microservice.order.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.uned.master.software.tfm.microservice.order.amqp.Producer;
import es.uned.master.software.tfm.microservice.order.jpa.entity.Order;
import es.uned.master.software.tfm.microservice.order.jpa.repository.OrderRepository;

@Service
@Transactional
public class OrderService {
	
	private static final Logger log = LoggerFactory.getLogger(OrderService.class);
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private Producer producer;
	
	@Value("${queue.orders.name}")
	private String ordersQueueName;
	
	public void insertExampleData(){
		orderRepository.save(new Order("OPEN", 25));
		orderRepository.save(new Order("OPEN", 250));
		log.info("Inicializado repositorio de pedidos con datos de ejemplo");
	}
	
	public List<Order> findAll(){
		log.info("Busqueda de todos los pedidos");
		return orderRepository.findAll();
	}
	
	public Order createOrder(Order order){
		log.info("Se inicializa el estado del pedido a crear como nuevo (NEW)");
		order.setStatus("NEW");
		log.info("Se guarda el nuevo pedido");
		orderRepository.save(order);
		log.info("Se envia el pedido a la cola {} para ser procesado por el servicio de clientes", ordersQueueName);
		producer.sendTo(ordersQueueName, order);
		return order;
	}
	
	public void udpate(Order order){
		log.info("Se actualiza el pedido");
		orderRepository.save(order);
	}

}
