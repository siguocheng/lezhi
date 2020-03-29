package com.lezhi.service;

import com.lezhi.entity.Contact;

public interface ContactService {

	Contact getContact();
	
	int updateContact(Contact contact);
}
