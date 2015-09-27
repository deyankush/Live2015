/**
 * 
 */
package com.marketRoad.controller;

/**
 * @author Gaurav PC
 *
 */
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.marketRoad.configuration.security.TokenAuthenticationService;
import com.marketRoad.model.CustomerProfileInfo;
import com.marketRoad.model.LoginRequest;
import com.marketRoad.model.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.marketRoad.model.Customer;
import com.marketRoad.model.userSecurrity.User;
import com.marketRoad.model.userSecurrity.UserAuthentication;
import com.marketRoad.services.DataServices;
import com.marketRoad.vo.CategorizationVO;
import com.marketRoad.vo.CustomerProfileVO;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@Autowired
	DataServices dataServices;
	
	@Autowired
	TokenAuthenticationService tokenAuthenticationService;

	static final Logger logger = Logger.getLogger(AuthController.class);

	/* Submit form in Spring Restful Services */
	@RequestMapping(value = "/login/{id}", method=RequestMethod.GET, headers="Accept=application/json")
	public Status login(@PathVariable("id") String id) {
		
		//HttpServletRequest req = 
		try {
			Customer cust = dataServices.getCustDtls(id);
			if (cust == null){
				return new Status(1,"Customer doesn't exist");
			}
			return new Status(1,"Login successfully");
		}catch (Exception e){
			return new Status(1,"Customer doesn't exist");
		}
		 
		

	}
	
	@RequestMapping(value = "/customer/login", method=RequestMethod.POST, headers="Accept=application/json")
	public @ResponseBody CustomerProfileVO postlogin(@RequestBody LoginRequest request, HttpServletRequest httpRequest, HttpServletResponse httpResponse) {
		
		CustomerProfileVO custProfVO = new CustomerProfileVO();
		//HttpServletRequest req = 
		try {
			Customer cust = dataServices.getCustDtls(request.getUserID());
			if(cust!=null && request.getPassword().equals(cust.getPassword())){	
				User user = new User(cust.getUserID());
				user.setPassword(cust.getPassword());
				UserAuthentication userAuthentication = new UserAuthentication(user);
				tokenAuthenticationService.addAuthentication(httpResponse, userAuthentication);
				custProfVO.setEmail(cust.getEmail());
				custProfVO.setPhone(cust.getPhone());
				custProfVO.setStatus(new Status(1,"Login successfully"));
				CustomerProfileInfo custProfileInfo = dataServices.getCustProfileDetails(cust.getUserID());
				custProfVO.setProfile(custProfileInfo);
				return custProfVO;
			}
			else{
				custProfVO.setStatus(new Status(0,"Customer doesn't exist"));
				return custProfVO;
			}
		}catch (Exception e){
			custProfVO.setStatus(new Status(0,"Customer doesn't exist"));
			return custProfVO;
		}
	}
	
	@RequestMapping(value = "/rest/sample", method=RequestMethod.GET, headers="Accept=application/json")
	public User sample() throws Exception {
		return new User("sampleUser");
	}

	
}