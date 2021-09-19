package com.demo.service;

import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.model.Organization;
import com.demo.repository.OrganizationRepository;

@Service
@XmlRootElement
public class OrganizationService {
	@Autowired
	OrganizationRepository organizationRepository;

	// getting a specific record
	public Organization getOrganizationById(int id) {
		Organization organization = organizationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Organization with the id - " + id + " not exist"));

		if (organization == null)
			throw new ResourceNotFoundException("id-" + id);

		return organization;
	}
}
