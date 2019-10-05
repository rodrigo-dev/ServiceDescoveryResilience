package edu.fiap.aula2.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import edu.fiap.aula2.model.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, String> {
	List<License> findByOrganizationId(String organizationId);

	License findByOrganizationIdAndLicenseId(String organizationId, String licenseId);
}
