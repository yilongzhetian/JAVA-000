package com.ylzt.geekbang.lesson09.work1.rpcfx.provider;


import com.ylzt.geekbang.lesson09.work1.rpcfx.api.OrderService;
import com.ylzt.geekbang.lesson09.work1.rpcfx.api.UserService;
import com.ylzt.geekbang.lesson09.work1.rpcfx.core.api.RpcfxRequest;
import com.ylzt.geekbang.lesson09.work1.rpcfx.core.api.RpcfxResolver;
import com.ylzt.geekbang.lesson09.work1.rpcfx.core.api.RpcfxResponse;
import com.ylzt.geekbang.lesson09.work1.rpcfx.core.server.RpcfxInvoker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

@SpringBootApplication
@RestController
public class RpcfxServerApplication {

	public static void main(String[] args) throws Exception {

		// xxx "io.kimmking.rpcfx.demo.api.UserService"

		ServiceProviderDesc desc = new ServiceProviderDesc();
		desc.setHost(InetAddress.getLocalHost().getHostAddress());
		desc.setPort(8080);
		desc.setServiceClass("io.kimmking.rpcfx.demo.api.UserService");

		// Curator.

		SpringApplication.run(RpcfxServerApplication.class, args);
	}

	@Autowired
	RpcfxInvoker invoker;

	@PostMapping("/")
	public RpcfxResponse invoke(@RequestBody RpcfxRequest request) {
		return invoker.invoke(request);
	}

	@Bean
	public RpcfxInvoker createInvoker(@Autowired RpcfxResolver resolver){
		return new RpcfxInvoker(resolver);
	}

	@Bean
	public RpcfxResolver createResolver(){
		return new DemoResolver();
	}

	// 能否去掉name
	//

	// annotation


	@Bean(name = "com.ylzt.geekbang.lesson09.work1.rpcfx.api..UserService")
	public UserService createUserService(){
		return new UserServiceImpl();
	}

	@Bean(name = "com.ylzt.geekbang.lesson09.work1.rpcfx.api.OrderService")
	public OrderService createOrderService(){

		return new OrderServiceImpl();
	}

}
