package com.learn.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.learn.component.ContactConverter;
import com.learn.entity.Contact;
import com.learn.model.ContactModel;
import com.learn.repository.ContactRepository;
import com.learn.service.ContactService;

@Service("contactServiceImlp")
public class ContactServiceImpl implements ContactService {

	@Autowired
	@Qualifier("contactRepository")
	private ContactRepository contactRepository;

	@Autowired
	@Qualifier("contactConverter")
	private ContactConverter contactConverter;

	@Override
	public ContactModel addContact(ContactModel contactModel) {
		Contact contact = contactRepository.save(contactConverter.convertContactModel2Contact(contactModel));
		return contactConverter.convertContact2ContactModel(contact);
	}

	@Override
	public List<ContactModel> listAllContacts() {
		List<Contact> contacts = contactRepository.findAll();
		List<ContactModel> contactsModel = new ArrayList<>();
		for (Contact contact : contacts) {
			contactsModel.add(contactConverter.convertContact2ContactModel(contact));
		}
		return contactsModel;
	}

	@Override
	public Contact findContactById(int id) {
		return contactRepository.findById(id);
	}

	public ContactModel findContactByIdModel(int id) {
		return contactConverter.convertContact2ContactModel(contactRepository.findById(id));
	}

	@Override
	public void removeContact(int id) {
		Contact contact = findContactById(id);
		if (null != contact) {
			contactRepository.delete(contact);
		}
	}

}
