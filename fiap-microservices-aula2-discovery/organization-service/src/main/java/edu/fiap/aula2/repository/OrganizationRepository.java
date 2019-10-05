package edu.fiap.aula2.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.fiap.aula2.model.Organization;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, String> {
	Organization findById(String organizationId);
}
