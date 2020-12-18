package com.ylzt.geekbang.lesson09.work1.rpcfx.consumer;

import com.ylzt.geekbang.lesson09.work1.rpcfx.api.Order;
import com.ylzt.geekbang.lesson09.work1.rpcfx.api.OrderService;
import com.ylzt.geekbang.lesson09.work1.rpcfx.api.User;
import com.ylzt.geekbang.lesson09.work1.rpcfx.api.UserService;
import com.ylzt.geekbang.lesson09.work1.rpcfx.core.client.Rpcfx;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RpcfxClientApplication {

	// 二方库
	// 三方库 lib
	// nexus, userserivce -> userdao -> user
	//

	public static void main(String[] args) {

		// UserService service = new xxx();
		// service.findById

		UserService userService = Rpcfx.create(UserService.class, "http://localhost:8080/");
		User user = userService.findById(1);
		System.out.println("find user id=1 from server: " + user.getName());

		OrderService orderService = Rpcfx.create(OrderService.class, "http://localhost:8080/");
		Order order = orderService.findOrderById(1992129);
		System.out.println(String.format("find order name=%s, amount=%f",order.getName(),order.getAmount()));

		//

//		SpringApplication.run(RpcfxClientApplication.class, args);
	}

}



