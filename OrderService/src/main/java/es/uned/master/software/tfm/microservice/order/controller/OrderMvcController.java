package es.uned.master.software.tfm.microservice.order.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.uned.master.software.tfm.microservice.order.jpa.entity.Order;
import es.uned.master.software.tfm.microservice.order.service.OrderService;

@Controller
public class OrderMvcController {
	
	private static final Logger log = LoggerFactory.getLogger(OrderMvcController.class);
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(path={"/", "/orders/list"}, method=RequestMethod.GET)
	public ModelAndView listOrders(){
		log.info("Se solicita la vista de listado de pedidos");
		ModelAndView mav = new ModelAndView("listOrders");
		mav.addObject("orders", orderService.findAll());
		return mav;
	}
	
	@RequestMapping(path= "/orders/create", method=RequestMethod.GET)
	public ModelAndView addOrder(Map<String, Object> model) {
		log.info("Se solicita la vista para crear un nuevo pedido");
		ModelAndView mav = new ModelAndView("createOrder");
		mav.addObject("order", new Order());
		return mav;
	}
	
	@RequestMapping(path="/orders/create", method=RequestMethod.POST)
	public ModelAndView createOrder(@ModelAttribute("order") Order order){
		log.info("Se realiza la llamada desde el cliente para crear un nuevo pedido");
		Order orderCreated = orderService.createOrder(order);
		ModelAndView mav = new ModelAndView("orderCreated");
		mav.addObject("order", orderCreated);
		return mav;
	}

}
