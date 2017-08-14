package es.uned.master.software.tfm.microservice.order.controller;

import java.util.Map;

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
	
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(path={"/", "/orders/list"}, method=RequestMethod.GET)
	public ModelAndView listOrders(){
		ModelAndView mav = new ModelAndView("listOrders");
		mav.addObject("orders", orderService.findAll());
		return mav;
	}
	
	@RequestMapping(path= "/orders/create", method=RequestMethod.GET)
	public ModelAndView addOrder(Map<String, Object> model) {
		ModelAndView mav = new ModelAndView("createOrder");
		mav.addObject("order", new Order());
		return mav;
	}
	
	@RequestMapping(path="/orders/create", method=RequestMethod.POST)
	public ModelAndView createOrder(@ModelAttribute("order") Order order){
		Order orderCreated = orderService.createOrder(order);
		ModelAndView mav = new ModelAndView("orderCreated");
		mav.addObject("order", orderCreated);
		return mav;
	}

}
