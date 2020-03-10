package com.peatera.demo.service;

import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.peatera.demo.pojo.SysMessage;

public interface HistoryServiceDao {
 public JSONObject showHistrory(String ip);
}
