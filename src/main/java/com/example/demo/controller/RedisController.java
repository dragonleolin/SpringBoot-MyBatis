package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.pojo.Product;

import redis.clients.jedis.Jedis;

@RestController
@RequestMapping(path = "/redis")
public class RedisController {

	// 連接本地的Redis服務
	Jedis jedis = new Jedis("192.168.100.206", 6379);

//	@RequestMapping(method = RequestMethod.GET)
//	public void testRedis() {
//		// 查看服務是否運行，打出pong表示OK
//		System.out.println("連接返回的值爲:" + jedis.ping());
//	}

	@RequestMapping(method = RequestMethod.GET)
	public Set queryAllKey() {
		//新增
        jedis.flushAll();
        jedis.set("k1","1");
        jedis.set("k2","2");
        jedis.set("k3","3");
		// 查詢所有的key
		Set<String> keys = jedis.keys("*");
		Iterator iter = keys.iterator();
		System.out.println("keys=" + keys);
		return keys;
		
	}
	

}
