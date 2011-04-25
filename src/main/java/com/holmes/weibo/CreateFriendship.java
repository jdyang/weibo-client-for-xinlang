package com.holmes.weibo;


import java.util.Random;

import weibo4j.User;
import weibo4j.Weibo;
import weibo4j.WeiboException;

public class CreateFriendship {
	
	static Random r = new Random();

	/**
	 * ��עĳ�û� 
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
		if(isOauth) {//oauth��֤��ʽ args[0]:���ʵ�token��args[1]:���ʵ��ܳ�
			weibo.setToken(args[0], args[1]);
		}else {//�û���¼��ʽ
    		weibo.setUserId("104601223@qq.com");//�û���/ID
    		weibo.setPassword("123456");//����
	 	}
	 	return weibo;
	}
}
