package com.mg.app.controller;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mg.app.bean.ETHModel;
import com.mg.app.service.ETHService;

@Controller
@RequestMapping({"/eth"})
public class ETHController {
	
	@Autowired
	ETHService ETHService;
	
	// ����ҳ��
	@RequestMapping("/requestPage")
	public ModelAndView request(){
		return new ModelAndView("ETH");
	}
	
	// ����ת��
	@RequestMapping("/forward")
	public ModelAndView request(HttpServletRequest request,ETHModel model){
		if(model.getMethod() != null && !model.getMethod().trim().equals("")){
			request.setAttribute("param", model.getParam());
			return new ModelAndView("forward:" + model.getMethod());
		}
		ModelAndView mv = new ModelAndView();
    	mv.addObject("result", "������ӿ�");
    	mv.setViewName("ETH");
		return mv;
	}
	
    @RequestMapping("/eth_getBalance")
    public ModelAndView getBalance(ETHModel model) throws Exception {
    	if(model.getParam() == null && model.getParam().trim().equals(""))
    		return paramIsNull();
    	JSONObject BalanceJb = ETHService.getbalance(model.getParam().trim());
    	ModelAndView mv = new ModelAndView();
    	mv.addObject("result", BalanceJb);
    	mv.setViewName("ETH");
        return mv;
    }
    
    // ���Ǯ��
    @RequestMapping("/personal_newAccount")
    public ModelAndView getNewAddress(ETHModel model) throws Exception {
    	if(model.getParam() == null && model.getParam().trim().equals(""))
    		return paramIsNull();
    	JSONObject  newAddressJb = ETHService.getNewaddress(model.getParam().trim());
    	ModelAndView mv = new ModelAndView();
    	mv.addObject("result", newAddressJb);
    	mv.setViewName("ETH");
        return mv;
    }
    
    // ��ȡ�˻���Ϣ
    @RequestMapping("/eth_accounts")
    public ModelAndView eth_accounts(ETHModel model) throws Exception {
    	JSONObject  accountsJb = ETHService.eth_accounts();
    	ModelAndView mv = new ModelAndView();
    	mv.addObject("result", accountsJb);
    	mv.setViewName("ETH");
        return mv;
    }
    
    // ����Ϊnull����
    private ModelAndView paramIsNull(){
    	ModelAndView mv = new ModelAndView();
    	mv.addObject("result", "���������");
    	mv.setViewName("ETH");
		return mv;
    }
}
