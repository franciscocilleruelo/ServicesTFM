package es.uned.master.software.tfm.microservice.order.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.uned.master.software.tfm.microservice.order.jpa.entity.Order;
import es.uned.master.software.tfm.microservice.order.service.OrderService;

@RestController
public class OrderRestController {
	
	private static final Logger log = LoggerFactory.getLogger(OrderRestController.class);
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(path="/orders", method=RequestMethod.GET)
	public List<Order> listOrders(@ModelAttribute("order") Order order){
		log.info("Se llama al servicio REST para listar los pedidos");
		return orderService.findAll();
	}
	
	@RequestMapping(path="/orders", method=RequestMethod.POST)
	public Order createOrder(@ModelAttribute("order") Order order){
		log.info("Se llama al servicio REST para crear un nuevo pedido");
		return orderService.createOrder(order);
	}
	

}
