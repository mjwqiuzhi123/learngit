package com.mg.app.service;

import net.sf.json.JSONObject;


public interface ETHService {
	// �½�Ǯ��
	public JSONObject getNewaddress(String walletPassword) throws Exception;

	// ��ȡ�˻�����
	public JSONObject eth_accounts() throws Exception;
	
	public JSONObject getbalance(String address) throws Exception;

	public JSONObject getAbstractMethod(String method, String paramsString) throws Exception;

	public JSONObject getBalance(String walletAddress) throws Exception;
	
}
