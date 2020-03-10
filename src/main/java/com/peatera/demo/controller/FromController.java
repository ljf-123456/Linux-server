package com.peatera.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.peatera.demo.pojo.SysMessage;
import com.peatera.demo.service.HistoryServiceDao;
@CrossOrigin
@RestController
public class FromController {
	@Autowired
	private HistoryServiceDao dao;
  @RequestMapping("/showHistrory")
  public JSONObject showOneDay(@RequestBody JSONObject param){
	  System.out.println(param.getString("ip"));
	 return dao.showHistrory(param.getString("ip"));
  }
}
