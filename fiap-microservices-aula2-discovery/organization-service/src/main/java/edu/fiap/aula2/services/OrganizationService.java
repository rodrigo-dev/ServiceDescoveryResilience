package edu.fiap.aula2.services;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fiap.aula2.model.Organization;
import edu.fiap.aula2.repository.OrganizationRepository;

@Service
public class OrganizationService {

	@Autowired
	private OrganizationRepository orgRepository;

	public Organization getOrg(String organizationId) {
		Organization organization = new Organization(organizationId);
		organization.setContactEmail("teste@gmail.com");
		organization.setContactName("Contact Name Example");
		organization.setContactPhone("11-1234-9874");
		organization.setName("Name Example");
		return organization;
//		return orgRepository.findById(organizationId);
	}

	public void saveOrg(Organization org) {
		org.setId(UUID.randomUUID().toString());
		orgRepository.save(org);
	}

	public void updateOrg(Organization org) {
		orgRepository.save(org);
	}

	public void deleteOrg(Organization org) {
		orgRepository.delete(org.getId());
	}
}
