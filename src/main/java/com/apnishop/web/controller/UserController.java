package com.apnishop.web.controller;

import java.sql.Timestamp;
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
import com.apnishop.web.dto.UserDTO;
import com.apnishop.web.dto.UserLeadDTO;
import com.apnishop.web.dto.UserMapper;
import com.apnishop.web.dto.UserRetailerDTO;
import com.apnishop.web.service.RetailerService;
import com.apnishop.web.service.UserAddressService;
import com.apnishop.web.service.UserRetailerMappingService;
import com.apnishop.web.service.UserRetailerService;
import com.apnishop.web.service.UserService;
import com.apnishop.web.util.Constant;
import com.apnishop.web.util.ResponseCodes;
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
	 public ResponseTransfer registerLeadUser(@RequestBody String mobno) throws RuntimeException	
		 {
		 try{
		
			 logger.info("in register func");
			 if(userservice.getUserByMobNo(mobno)==null){
				 logger.info("new user");
				 UserLeadDTO userdto = new UserLeadDTO();
				 userdto.setUsermobileno(mobno);
				 userdto.setUsertype(Constant.USER_TYPE_LEAD);
				 userdto.setCreatedonutc(new Timestamp(System.currentTimeMillis()));
				 userdto.setLastactivitydateutc(new Timestamp(System.currentTimeMillis()));
				 userdto.setUserguid("xx01");
								 
				 userservice.addUser(modelMapper.map(userdto, User.class));
				 return new ResponseTransfer(ResponseCodes.Code_2001,userdto,null);
			
			 }
		 
			 else{
				 logger.info("existing user");
				 HashMap<String,String> errdesc= new HashMap<String, String>();
				 errdesc.put(Constant.SUCCESS_USER_EXIST_CODE, ResponseCodes.Code_4001);
				 return new ResponseTransfer(ResponseCodes.Code_4001,null,errdesc);
			 }
		 }
		 catch(Exception ex)
		 {
			 logger.error("Exception::"+ex);
			 HashMap<String,String> errdesc= new HashMap<String, String>();
			 errdesc.put(Constant.TECHNICAL_ERROR_CODE, ResponseCodes.Code_5001);
			 return new ResponseTransfer(ResponseCodes.Code_5001,null,errdesc); 
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
			 Retailer storeobj =retservice.getByStorename(retObj.get("retailershortname").getAsString());
			 if(retObj.get("role").getAsString().equalsIgnoreCase(Constant.USER_ROLE_CUSTOMER))
			 {
					 if(storeobj!=null){
						 logger.debug("Store present in retailer list");
						 //userservice.updateUser(Constant.USER_TYPE_ACTIVE,Constant.USER_ROLE_CUSTOMER,Integer.parseInt(retObj.get("userid").toString()));
						 UserDTO user= new UserDTO();
						 user.setUsertype(Constant.USER_TYPE_ACTIVE);
						 user.setUserrole(Constant.USER_ROLE_CUSTOMER);
						user.setId(Integer.parseInt(retObj.get("userid").toString()));
						 UserRetailerDTO userdto = new UserRetailerDTO();
						 
						 userdto.setRetailerid(storeobj.getId());						 
						 userdto.setUserid(Integer.parseInt(retObj.get("userid").toString()));
						 userdto.setDisplayorder(Integer.parseInt(retObj.get("displayorder").toString()));
						// userretservice.addUserRet(modelMapper.map(userdto, UserRetailerMapping.class));
						userRetservice.updateUserRetailer_Customer(modelMapper.map(user, User.class), modelMapper.map(userdto, UserRetailerMapping.class));
						 
						 return new ResponseTransfer(ResponseCodes.Code_2001,userdto,null);
							
					 }
					 
					 else{
						 logger.debug("no store selected by user");
						 userservice.updateUser(Constant.USER_TYPE_ACTIVE,Constant.USER_ROLE_CUSTOMER,Integer.parseInt(retObj.get("userid").toString()));
						 /*HashMap<String,String> errdesc= new HashMap<String, String>();
						 errdesc.put(Constant.SUCCESS_USER_EXIST_CODE, ResponseCodes.Code_4001);*/
						 return new ResponseTransfer(ResponseCodes.Code_4001,null,null);
					 }
			 }
			 else if(retObj.get("role").getAsString().equalsIgnoreCase(Constant.USER_ROLE_RETAILER)){
				
					 Random rand = new Random();
					 int rand_no = rand.nextInt(999999);
					 userservice.updateUser(Constant.USER_TYPE_LEAD,Constant.USER_ROLE_RETAILER,Integer.parseInt(retObj.get("userid").toString()));
					 UserDTO user= new UserDTO();
					 user.setUsertype(Constant.USER_TYPE_LEAD);
					 user.setUserrole(Constant.USER_ROLE_RETAILER);
					 user.setId(Integer.parseInt(retObj.get("userid").toString()));
					
					 RetailerDTO retailerdto = new RetailerDTO();
					 retailerdto.setStorename(retObj.get("retailershortname").getAsString());
					 retailerdto.setStoreid(String.format("%06d",rand_no));
					// retservice.addRetailer(modelMapper.map(retailerdto, Retailer.class));
					 userRetservice.updateUserRetailer_Retailer(modelMapper.map(user, User.class), modelMapper.map(retailerdto, Retailer.class));
						 
					 return new ResponseTransfer(ResponseCodes.Code_2001,retailerdto,null);
						
				
			 }
			 else
			 {
				 HashMap<String,String> errdesc= new HashMap<String, String>();
				 errdesc.put(Constant.NO_ROLE_ERROR_CODE, ResponseCodes.Code_5002);
				 return new ResponseTransfer(ResponseCodes.Code_5002,null,errdesc);
			 }
				
		}
		 catch(Exception ex){
			 logger.error("Exception::"+ex);
			 HashMap<String,String> errdesc= new HashMap<String, String>();
			 errdesc.put(Constant.TECHNICAL_ERROR_CODE, ResponseCodes.Code_5001);
			 return new ResponseTransfer(ResponseCodes.Code_5001,null,errdesc); 
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
			 logger.debug(header.get("userid"));
			 
			 JsonParser jsonparser = new JsonParser();
			 JsonElement jsontree = jsonparser.parse(profile);
			 JsonObject obj = jsontree.getAsJsonObject();
			 UserDTO userdto = new UserDTO();
			 userdto.setId(Integer.parseInt(header.get("userid").toString()));
			 userdto.setUsername(obj.get("username").getAsString());
			 userdto.setEmail(obj.get("email").getAsString());
			// userdto.setLanguageid(Integer.parseInt(obj.get("languageid").getAsString()));
			 String lang=obj.get("language").getAsString();
			 String state=obj.get("state").getAsString();
			 String country=obj.get("country").getAsString();
			 AddressDTO addrdto= new AddressDTO();
			 addrdto.setAddresstype(obj.get("addresstype").getAsString());
			 addrdto.setAddress1(obj.get("address").getAsString());
			 addrdto.setCity(obj.get("city").getAsString());
			// addrdto.setCountry(obj.get("country").getAsString());
			 addrdto.setLandmark(obj.get("landmark").getAsString());
			 addrdto.setCreatedonutc(new Timestamp(System.currentTimeMillis()));
			 
			// addrdto.setStateprovinceid(Integer.parseInt(obj.get("stateid").getAsString()));
			 addrdto.setZippostalcode(obj.get("pincode").getAsString());
			 userAddrservice.updateUserAddress(modelMapper.map(userdto, User.class), modelMapper.map(addrdto, Address.class),lang,state,country);
			 return new ResponseTransfer(ResponseCodes.Code_2001,addrdto,null);
				
			 
		 }
		 
		 catch(Exception ex){
			 logger.error("Exception::"+ex);
			 HashMap<String,String> errdesc= new HashMap<String, String>();
			 errdesc.put(Constant.TECHNICAL_ERROR_CODE, ResponseCodes.Code_5001);
			 return new ResponseTransfer(ResponseCodes.Code_5001,null,errdesc); 
	     }
			
	 }
	 
	 
	 
	 
	/* 
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
	
	 @PostMapping("/register1")
	 @Consumes("application/json")
	 public ResponseEntity<String> registerUser1(@RequestBody String UserObj,@RequestHeader Map<String,String> headers)
	     {
		 List<String> str=(List<String>) headers.keySet();
		 for(int i=0;i<str.size();i++)
		 {
		 System.out.println(str.get(i));
		 }
		 System.out.println("register present");
		 String storeid="";
		 if(retservice.getByStoreId(UserObj)!=null){
			 System.out.println("Store present");
		 }
		 
		 else{
			 return new ResponseEntity<>("Failure", HttpStatus.NOT_FOUND);
		 }
		 
		 return new ResponseEntity<>("Success", HttpStatus.OK);
	     }
	     
*/
}
