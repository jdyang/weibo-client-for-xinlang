package com.holmes.weibo;


import java.util.Random;

import weibo4j.User;
import weibo4j.Weibo;
import weibo4j.WeiboException;

public class CreateFriendship {
	
	static Random r = new Random();

	/**
	 * 关注某用户 
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("weibo4j.oauth.consumerKey", "1736442704");
		System.setProperty("weibo4j.oauth.consumerSecret", "eebdbd452806a3b119047824975ae84b");
		while(true){
			Thread.sleep(100);
			try {
				Long seed = 2000000000 - Math.abs(r.nextLong()) % 100000000;
				System.out.println(seed);
				User user = getWeibo(false,args).createFriendship(seed.toString());
				System.out.println(user.toString());
			} catch (WeiboException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	private static Weibo getWeibo(boolean isOauth,String[] args) {
		Weibo weibo = new Weibo();
		if(isOauth) {//oauth验证方式 args[0]:访问的token；args[1]:访问的密匙
			weibo.setToken(args[0], args[1]);
		}else {//用户登录方式
    		weibo.setUserId("104601223@qq.com");//用户名/ID
    		weibo.setPassword("123456");//密码
	 	}
	 	return weibo;
	}
}
