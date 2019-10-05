package edu.fiap.aula2.services;

import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.fiap.aula2.clients.OrganizationRestTemplateClient;
import edu.fiap.aula2.config.ServiceConfig;
import edu.fiap.aula2.model.License;
import edu.fiap.aula2.model.Organization;
import edu.fiap.aula2.repository.LicenseRepository;

@Service
public class LicenseService {

	private static final Logger logger = LoggerFactory.getLogger(LicenseService.class);

	@Autowired
	private LicenseRepository licenseRepository;

	@Autowired
	ServiceConfig config;

	@Autowired
	OrganizationRestTemplateClient organizationRestClient;

	/*
	 * Suponha que o método getLicense é um processo muito demorado de consulta no
	 * banco de dados. Essa demora é representada pelo método randomlyRunLong(),
	 * implemente os mecanismos de Padrões de Resiliência vistos em aula afim de
	 * garantir que o método apresente um comportamento adequeado.
	 */
	public License getLicense(String organizationId, String licenseId) {
		randomlyRunLong();
		return null;
	}

	private Organization getOrganization(String organizationId) {
		return organizationRestClient.getOrganization(organizationId);
	}

	private void randomlyRunLong() {
		Random rand = new Random();
		int randomNum = rand.nextInt(3) + 1;
		if (randomNum == 3) {
			sleep();
		}
	}

	private void sleep() {
		try {
			Thread.sleep(11000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public List<License> getLicensesByOrg(String organizationId) {
		randomlyRunLong();
		return licenseRepository.findByOrganizationId(organizationId);
	}

	public void saveLicense(License license) {
		license.withId(UUID.randomUUID().toString());
		licenseRepository.save(license);
	}

	public void updateLicense(License license) {
		licenseRepository.save(license);
	}

	public void deleteLicense(License license) {
		licenseRepository.delete(license.getLicenseId());
	}

}
