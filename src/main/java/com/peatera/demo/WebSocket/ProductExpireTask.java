package com.peatera.demo.WebSocket;

import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONObject;
import com.peatera.demo.pojo.SysMessage;
import com.peatera.demo.redis.RedisUtils;

/**
 * @Author：JCccc
 * @Description：
 * @Date： created in 15:56 2019/5/13
 */
@Component
public class ProductExpireTask implements ApplicationContextAware {

	/*
	 * @Autowired private RedisTemplate<String,Object> redisTemplate;
	 */

	ApplicationContext applicationContext;

	@Scheduled(fixedRate = 1000)
	public void productExpire() throws Exception {
		InetAddress addr = InetAddress.getLocalHost();
		RedisUtils redis = (RedisUtils) applicationContext.getBean("redis");
		Sigars si = (Sigars) applicationContext.getBean("sigars");
		JSONObject json = new JSONObject();
		String dir = System.getProperty("user.dir");

		SysMessage vo = si.getSysMessage(dir);
		/* System.out.println("vo:"+vo);
		System.out.println("ip:" + getipAddress());*/
		//这里，需要优化，不能写死
		redis.lSet("192.168.186.128"+"sysHours", vo, 3600);
		redis.lSet("192.168.186.128"+"sysDay", vo, 86400);

		json.put("msg", vo);// 返回实时数据

		ProductWebSocket.sendInfo(json);

	}

	public static String getipAddress() {
		List<String>list=new ArrayList<String>();
		Enumeration allNetInterfaces;
		try {
			allNetInterfaces = NetworkInterface.getNetworkInterfaces();

			InetAddress ip = null;
			while (allNetInterfaces.hasMoreElements()) {
				NetworkInterface netInterface = (NetworkInterface) allNetInterfaces
						.nextElement();
				//System.out.println(netInterface.getName());
				Enumeration addresses = netInterface.getInetAddresses();
				while (addresses.hasMoreElements()) {
					ip = (InetAddress) addresses.nextElement();
					if (ip != null && ip instanceof Inet4Address) {
						list.add(ip.getHostAddress());
						System.out.println("本机的IP = " + ip.getHostAddress());
					}
				}
			}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list.get(0);
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		// TODO Auto-generated method stub
		this.applicationContext = applicationContext;

	}

}
