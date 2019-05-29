package Jedis;

import redis.clients.jedis.Jedis;

public class JedisTest {
	public static void main(String[] args) {
		Jedis jedis=new Jedis("172.18.104.222", 6379);
		jedis.auth("123456");
		jedis.set("name", "java知识网");
		String name=jedis.get("name");
		System.out.println("从缓存中读取的数据 为"+name);
		jedis.close();
	}
}
