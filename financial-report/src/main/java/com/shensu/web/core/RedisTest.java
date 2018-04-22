package com.shensu.web.core;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class RedisTest {

	public static void main(String[] args) {
//		 JedisPoolConfig config = new JedisPoolConfig();
//		 //修改最大连接数
//		 config.setMaxTotal(20);
//		 //声明一个线程池
//		 JedisPool pool = new JedisPool(config,"192.168.62.129",6379);
//		 
//		 //获得jedis对象
//		 Jedis jedis = pool.getResource();
//		 System.out.println(jedis.ping());
		 Jedis jedis = new Jedis("192.168.62.129", 6379);
		 System.out.println(jedis.ping());
		 jedis.close();
	}
}
