package com.apnishop.web.controller;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.ws.rs.Consumes;
import javax.ws.rs.core.MediaType;

import org.apache.http.HttpRequest;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apnishop.web.Application;
import com.apnishop.web.data.entity.Address;
import com.apnishop.web.data.entity.ResponseTransfer;
import com.apnishop.web.data.entity.Retailer;
import com.apnishop.web.data.entity.User;
import com.apnishop.web.data.entity.UserRegisterModel;
import com.apnishop.web.data.entity.UserRetailerMapping;
import com.apnishop.web.dto.AddressDTO;
import com.apnishop.web.dto.RetailerDTO;
import com.apnishop.web.dto.UserAddressDTO;
import com.apnishop.web.dto.UserDTO;
import com.apnishop.web.dto.UserLeadDTO;
import com.apnishop.web.dto.UserRetailerDTO;
import com.apnishop.web.service.RetailerService;
import com.apnishop.web.service.UserAddressService;
import com.apnishop.web.service.UserRetailerMappingService;
import com.apnishop.web.service.UserRetailerService;
import com.apnishop.web.service.UserService;
import com.apnishop.web.util.Constant;
import com.apnishop.web.util.ResponseCodes;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


@SuppressWarnings("unused")
@RestController
@RequestMapping("${vs}/user")
public class UserController {
	
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	
	@Autowired
	 UserService userservice;
	
	@Autowired
	 UserRetailerService userRetservice;
	
	@Autowired
	 UserAddressService userAddrservice;
	
	@Autowired
	 UserController _self;
	
	
	@Autowired
	 RetailerService retservice;
	
	@Autowired
	 UserRetailerMappingService userretservice;
	
	 private static final ModelMapper modelMapper = new ModelMapper();
	 
	
	 
	 /*
	  * Service to make a "lead" entry in user table.
	  * A new entry is made in User table with user type as "lead".
	  * 
	  */
	 
	 @PostMapping("/register/lead")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @ResponseBody
	 public ResponseTransfer registerLeadUser(@RequestBody String reqObj) throws RuntimeException	
		 {
		 try{
		
			 logger.debug("Lead resgistration");
			 JsonParser jsonparser = new JsonParser();
			 JsonElement jsontree = jsonparser.parse(reqObj);
			 JsonObject obj = jsontree.getAsJsonObject();
			 String mobno=obj.get("mobno").getAsString();
			 if(userservice.getUserByMobNo(mobno)==null){
				 logger.debug("new user");
				 UserLeadDTO userdto = new UserLeadDTO();
				 userdto.setUsermobileno(mobno);
				 userdto.setUsertype(Constant.USER_TYPE_LEAD);
				 userdto.setCreatedonutc(new Timestamp(System.currentTimeMillis()));
				 userdto.setLastactivitydateutc(new Timestamp(System.currentTimeMillis()));
				 int guid=Integer.parseInt(userservice.getMaxGUId())+1;
				 userdto.setUserguid(String.valueOf(guid));
								 
				 userservice.addUser(modelMapper.map(userdto, User.class));
				 return new ResponseTransfer(Constant.SUCCESS_USER_CODE,ResponseCodes.Code_2001,userdto,null);
			
			 }
		 
			 else{
				 logger.debug("existing user");
				 HashMap<String,String> errdesc= new HashMap<String, String>();
				 errdesc.put(Constant.SUCCESS_USER_EXIST_CODE, ResponseCodes.Code_4001);
				 return new ResponseTransfer(Constant.SUCCESS_USER_EXIST_CODE,ResponseCodes.Code_4001,null,errdesc);
			 }
		 }
		 catch(Exception ex)
		 {
			 logger.error("Exception::"+ex);
			 HashMap<String,String> errdesc= new HashMap<String, String>();
			 errdesc.put(Constant.TECHNICAL_ERROR_CODE, ResponseCodes.Code_5001);
			 return new ResponseTransfer(Constant.TECHNICAL_ERROR_CODE,ResponseCodes.Code_5001,null,errdesc); 
		 }
		 
		 
	 }	
	 
	 /*Service to register a user as customer/retailer
	  * customer entry:
	  * If store is selected then user table is updated with usertype as "active" and
	  *  a new entry is made in userretailer mapping table.
	  *  
	  *  Retailer entry:
	  *  Entry is made in user table and Retailer table.
	  * 
	  */
	 
	 @PostMapping("/register")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @ResponseBody
	//@Transactional(rollbackFor=Exception.class)
	 public ResponseTransfer registerUser(@RequestBody String UserRetObj) throws RuntimeException
	 {
		 try{
			 JsonParser jsonparser = new JsonParser();
			 JsonElement jsontree = jsonparser.parse(UserRetObj);
			 JsonObject retObj = jsontree.getAsJsonObject();
			 UserRetailerMapping rObj= new UserRetailerMapping();
			 Retailer storeobj =retservice.getByStoreId(retObj.get("storeid").getAsString());
			 if(retObj.get("role").getAsString().equalsIgnoreCase(Constant.USER_ROLE_CUSTOMER))
			 {
					 if(storeobj!=null){
						 logger.debug("Store present in retailer list");
						 //userservice.updateUser(Constant.USER_TYPE_ACTIVE,Constant.USER_ROLE_CUSTOMER,Integer.parseInt(retObj.get("userid").toString()));
						 UserDTO user= new UserDTO();
						 user.setUsertype(Constant.USER_TYPE_ACTIVE);
						 user.setUserrole(Constant.USER_ROLE_CUSTOMER);
						user.setUserguid(retObj.get("userid").toString());
						 UserRetailerDTO userdto = new UserRetailerDTO();
						 
						 userdto.setRetailerid(Integer.parseInt(storeobj.getStoreid()));						 
						// userdto.setUserid(Integer.parseInt(retObj.get("userid").toString()));
						 userdto.setDisplayorder(-1);
						// userretservice.addUserRet(modelMapper.map(userdto, UserRetailerMapping.class));
						userRetservice.updateUserRetailer_Customer(modelMapper.map(user, User.class), modelMapper.map(userdto, UserRetailerMapping.class));
						 
						 return new ResponseTransfer(Constant.SUCCESS_USER_CODE,ResponseCodes.Code_2001,userdto,null);
							
					 }
					 
					 else{
						 logger.debug("no store selected by user");
						 userservice.updateUser(Constant.USER_TYPE_ACTIVE,Constant.USER_ROLE_CUSTOMER,Integer.parseInt(retObj.get("userid").toString()));
						 /*HashMap<String,String> errdesc= new HashMap<String, String>();
						 errdesc.put(Constant.SUCCESS_USER_EXIST_CODE, ResponseCodes.Code_4001);*/
						 return new ResponseTransfer(Constant.SUCCESS_USER_EXIST_CODE,ResponseCodes.Code_4001,null,null);
					 }
			 }
			 else if(retObj.get("role").getAsString().equalsIgnoreCase(Constant.USER_ROLE_RETAILER)){
				
					 Random rand = new Random();
					 int rand_no = rand.nextInt(999999);
					// userservice.updateUser(Constant.USER_TYPE_LEAD,Constant.USER_ROLE_RETAILER,Integer.parseInt(retObj.get("userid").toString()));
					 UserDTO user= new UserDTO();
					 user.setUsertype(Constant.USER_TYPE_LEAD);
					 user.setUserrole(Constant.USER_ROLE_RETAILER);
					 user.setUserguid(retObj.get("userid").toString());
					
					 RetailerDTO retailerdto = new RetailerDTO();
					 retailerdto.setStorename(retObj.get("storename").getAsString());
					 retailerdto.setStoreid(String.format("%06d",rand_no));
					// retservice.addRetailer(modelMapper.map(retailerdto, Retailer.class));
					 userRetservice.updateUserRetailer_Retailer(modelMapper.map(user, User.class), modelMapper.map(retailerdto, Retailer.class));
						 
					 return new ResponseTransfer(Constant.SUCCESS_USER_CODE,ResponseCodes.Code_2001,retailerdto,null);
						
				
			 }
			 else
			 {
				 HashMap<String,String> errdesc= new HashMap<String, String>();
				 errdesc.put(Constant.NO_ROLE_ERROR_CODE, ResponseCodes.Code_5002);
				 return new ResponseTransfer(Constant.NO_ROLE_ERROR_CODE,ResponseCodes.Code_5002,null,errdesc);
			 }
				
		}
		 catch(Exception ex){
			 logger.error("Exception::"+ex);
			 HashMap<String,String> errdesc= new HashMap<String, String>();
			 errdesc.put(Constant.TECHNICAL_ERROR_CODE, ResponseCodes.Code_5001);
			 return new ResponseTransfer(Constant.TECHNICAL_ERROR_CODE,ResponseCodes.Code_5001,null,errdesc); 
	     }	
	   }
	 
	 /*
	  * To Update the User profile details
	  */
	 
	 @PostMapping("/profile")
	 @Consumes(MediaType.APPLICATION_JSON)
	 @ResponseBody
	 public ResponseTransfer userProfile(@RequestBody String profile,@RequestHeader Map<String,String> header) throws RuntimeException
	 {
		 try{
			
			 Object retobj= new Object();
			 JsonParser jsonparser = new JsonParser();
			 JsonObject obj = new JsonParser().parse(profile).getAsJsonObject();
			
			 UserDTO userdto = new UserDTO();
			 userdto.setUserguid(header.get("userid").toString());
			 userdto.setUsername(obj.get("username").getAsString());
			 userdto.setEmail(obj.get("email").getAsString());
			 userdto.setLanguageid(Integer.parseInt(obj.get("language").getAsString()));
			 JsonArray jsonarray = obj.getAsJsonArray("address");
			 logger.debug("jsonarr size--"+jsonarray.size());
			ArrayList<Address> addrArray= new ArrayList<Address>();
			if(jsonarray.size()!=0){
			 for(int i=0;i<jsonarray.size();i++)
			 {
			 AddressDTO addrdto= new AddressDTO();
			 logger.info("jsonarr size--"+jsonarray.size());
			 logger.info(jsonarray.get(i).getAsJsonObject().get("address").getAsString());
			 addrdto.setAddresstype(jsonarray.get(i).getAsJsonObject().get("addresstype").getAsString());
			 addrdto.setAddress1(jsonarray.get(i).getAsJsonObject().get("address").getAsString());
			 addrdto.setCity(jsonarray.get(i).getAsJsonObject().get("city").getAsString());
			 addrdto.setCountryid(Integer.parseInt(jsonarray.get(i).getAsJsonObject().get("country").getAsString()));
			 addrdto.setStateprovinceid(Integer.parseInt(jsonarray.get(i).getAsJsonObject().get("state").getAsString()));
			 addrdto.setLandmark(jsonarray.get(i).getAsJsonObject().get("landmark").getAsString());
			 addrdto.setCreatedonutc(new Timestamp(System.currentTimeMillis()));
			 addrdto.setUserid(Integer.parseInt(header.get("userid").toString()));
			 addrdto.setZippostalcode(jsonarray.get(i).getAsJsonObject().get("pincode").getAsString());
			 userAddrservice.updateUserAddress(modelMapper.map(userdto, User.class), modelMapper.map(addrdto, Address.class),i);
			 addrArray.add(modelMapper.map(addrdto, Address.class));
			 }
			 
			
			 
			}
			else
			{// if there are no addresses to be inserted
				userAddrservice.updateUserAddress(modelMapper.map(userdto, User.class),null,-1);
				addrArray=null;
			}
			
			 // setting the return obj with user and address details
			UserAddressDTO userAddrObj= new UserAddressDTO();
			userAddrObj.setName(obj.get("username").getAsString());
			userAddrObj.setEmailid(obj.get("email").getAsString());
			userAddrObj.setLang(obj.get("language").getAsString());
			userAddrObj.setMobno(userservice.getUserByguId(header.get("userid").toString()).getUsermobileno());
			userAddrObj.setAddrList(addrArray);
			retobj=userAddrObj;
			
				 return new ResponseTransfer(Constant.SUCCESS_USER_CODE,ResponseCodes.Code_2001,retobj,null);
				
			 
		 }
		 
		 catch(Exception ex){
			 logger.error("Exception::"+ex);
			 HashMap<String,String> errdesc= new HashMap<String, String>();
			 errdesc.put(Constant.TECHNICAL_ERROR_CODE, ResponseCodes.Code_5001);
			 return new ResponseTransfer(Constant.TECHNICAL_ERROR_CODE,ResponseCodes.Code_5001,null,errdesc); 
	     }
			
	 }
	 
	 
	 
	 
	
	  @GetMapping("/getAllStores")
	 public ResponseEntity<List<Retailer>> getAllStores()
    {
		//System.out.println("version::"+ResponseCodes.Code_2001);
		logger.info("getting stores");
		 List<Retailer> catList=retservice.getAllStores();
		 if (catList.isEmpty()) {
				//logger.debug("Employees does not exists");
				return new ResponseEntity<List<Retailer>>(HttpStatus.NO_CONTENT);
			}
			
			return new ResponseEntity<List<Retailer>>(catList, HttpStatus.OK);
		     
    }
	
	     

}
