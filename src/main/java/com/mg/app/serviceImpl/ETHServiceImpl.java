package com.mg.app.serviceImpl;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mg.app.service.ETHService;
import com.mg.app.util.ETHUtils;

@Service("ETHService")
public class ETHServiceImpl implements ETHService{
	
	@Autowired
	ETHUtils ethutils;
	
	// ��ȡǮ�����
	@Override
	public JSONObject getBalance(String walletAddress) throws Exception {
		// TODO Auto-generated method stub
		String s = ethutils.main("eth_getBalance", "[\""+walletAddress+"\", \"latest\"]");
		JSONObject json = JSONObject.fromObject(s); 
        return json;
	}
	
	// �½�Ǯ�� ��API��personal_newAccount 
	@Override
	public JSONObject getNewaddress(String walletPassword) throws Exception {
		// TODO Auto-generated method stub
		String s = ethutils.main("personal_newAccount", "[\""+walletPassword+"\"]");
		JSONObject json = JSONObject.fromObject(s); 
        return json;
	}

	// ��ȡ�˻�����
	@Override
	public JSONObject eth_accounts() throws Exception {
		String s = ethutils.main("eth_accounts", "[]");
		JSONObject json = JSONObject.fromObject(s);
		return json;
	}

	@Override
	public JSONObject getbalance(String address) throws Exception {
		String s = ethutils.main("eth_getBalance", "[\""+address+"\", \"latest\"]");
		JSONObject json = JSONObject.fromObject(s); 
        return json;
	}
	
	@Override
	public JSONObject getAbstractMethod(String method, String paramsString) throws Exception{
		if(method.isEmpty()) {
			String json = "{\"method is null\":\"msg\"}";  
			return JSONObject.fromObject(json);
		}
		String s = ethutils.main(method, paramsString);
		JSONObject json = JSONObject.fromObject(s); 
        return json;
	}
	
}
