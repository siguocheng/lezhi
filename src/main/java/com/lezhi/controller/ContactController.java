package com.lezhi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.lezhi.entity.Contact;
import com.lezhi.entity.ResultBean;
import com.lezhi.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	ContactService contactService;
	
	@PostMapping("/getContact")
	public ResultBean<Contact> getContact(@RequestBody String params) {
		

		return new ResultBean<>(contactService.getContact());
	}
	
	@PostMapping("/updateContact")
	public ResultBean<Integer> updateContact(@RequestBody String params) {
		Contact contact = JSONObject.parseObject(params, Contact.class);

		return new ResultBean<>(contactService.updateContact(contact));
	}
}
