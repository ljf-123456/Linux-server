package com.peatera.demo.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.alibaba.fastjson.JSONObject;
import com.peatera.demo.pojo.SysMessage;
import com.peatera.demo.redis.RedisUtils;
import com.peatera.demo.service.HistoryServiceDao;

@Component
public class HistoryServiceDaoImpl implements HistoryServiceDao,ApplicationContextAware {
	 ApplicationContext applicationContext;


	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext=applicationContext;
		
	}


	@Override
	public JSONObject showHistrory(String ip) {
		RedisUtils redis = (RedisUtils)applicationContext.getBean("redis");
		List<Object> listHours = redis.lGet(ip+"sysHours", 0, -1);
		List<Object> listDay = redis.lGet(ip+"sysDay", 0, -1);
		int lengthH = listHours.size();
		int lengthD = listDay.size();
		System.out.println("hours=："+listHours.size());
		System.out.println("listDay=："+listDay.size());
		for(int i=0;i<lengthH;i++){
			if(i%360==0){
				continue;
			}
			listHours.remove(0);
		}
		for(int i=0;i<lengthD;i++){
			if(i%4320==0){
				continue;
			}
			listDay.remove(0);
		}
		JSONObject json = new JSONObject();
		System.out.println("hours=："+listHours.size());
		System.out.println("listDay=："+listDay.size());
		json.put("hours", listHours);
		json.put("day", listDay);
		return json;
	}
}
