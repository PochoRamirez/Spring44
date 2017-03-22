package com.learn.service;

import java.util.List;

import com.learn.entity.Contact;
import com.learn.model.ContactModel;

public interface ContactService {

	public abstract ContactModel addContact(ContactModel contactModel);
	public abstract List<ContactModel> listAllContacts();
	public abstract Contact findContactById(int id);
	public abstract ContactModel findContactByIdModel(int id);
	public abstract void removeContact(int id);
}
