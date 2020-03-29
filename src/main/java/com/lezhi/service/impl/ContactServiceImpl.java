package com.lezhi.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lezhi.dao.DictionaryMapper;
import com.lezhi.entity.Contact;
import com.lezhi.entity.Dictionary;
import com.lezhi.service.ContactService;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	DictionaryMapper dictionaryMapper;

	@Override
	public Contact getContact() {
		Dictionary dictionary = new Dictionary();
		dictionary.setItemKey("name");
		Dictionary d1 = dictionaryMapper.selectByItemKey(dictionary);
		dictionary.setItemKey("phoneNumer");
		Dictionary d2 = dictionaryMapper.selectByItemKey(dictionary);
		dictionary.setItemKey("mail");
		Dictionary d3 = dictionaryMapper.selectByItemKey(dictionary);
		dictionary.setItemKey("address");
		Dictionary d4 = dictionaryMapper.selectByItemKey(dictionary);

		Contact contact = new Contact();
		if (d1 != null) {
			contact.setName(d1.getItemValue());
		}
		if (d2 != null) {
			contact.setPhoneNumber(d2.getItemValue());
		}
		if (d3 != null) {
			contact.setMail(d3.getItemValue());
		}
		if (d4 != null) {
			contact.setAddress(d4.getItemValue());
		}
		return contact;
	}

	@Override
	public int updateContact(Contact contact) {

		Dictionary dictionary = new Dictionary();
		dictionary.setItemKey("name");
		dictionary.setItemValue(contact.getName());
		dictionaryMapper.updateByItemKey(dictionary);
		
		dictionary.setItemKey("phoneNumer");
		dictionary.setItemValue(contact.getPhoneNumber());
		dictionaryMapper.updateByItemKey(dictionary);
		
		dictionary.setItemKey("mail");
		dictionary.setItemValue(contact.getMail());
		dictionaryMapper.updateByItemKey(dictionary);
		
		dictionary.setItemKey("address");
		dictionary.setItemValue(contact.getAddress());
		dictionaryMapper.updateByItemKey(dictionary);
		
		return 1;
	}

}
