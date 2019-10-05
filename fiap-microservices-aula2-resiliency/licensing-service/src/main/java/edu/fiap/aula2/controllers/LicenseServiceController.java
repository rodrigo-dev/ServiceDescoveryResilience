package edu.fiap.aula2.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import edu.fiap.aula2.model.License;
import edu.fiap.aula2.services.LicenseService;

@RestController
@RequestMapping(value = "v1/organizations/{organizationId}/licenses")
public class LicenseServiceController {
	private static final Logger logger = LoggerFactory.getLogger(LicenseServiceController.class);
	@Autowired
	private LicenseService licenseService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public List<License> getLicenses(@PathVariable("organizationId") String organizationId) {
		return licenseService.getLicensesByOrg(organizationId);
	}

	@RequestMapping(value = "/{licenseId}", method = RequestMethod.GET)
	public License getLicenses(@PathVariable("organizationId") String organizationId,
			@PathVariable("licenseId") String licenseId) {
		return licenseService.getLicense(organizationId, licenseId);
	}

	@RequestMapping(value = "{licenseId}", method = RequestMethod.PUT)
	public void updateLicenses(@PathVariable("licenseId") String licenseId, @RequestBody License license) {
		licenseService.updateLicense(license);
	}

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public void saveLicenses(@RequestBody License license) {
		licenseService.saveLicense(license);
	}

	@RequestMapping(value = "{licenseId}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteLicenses(@PathVariable("licenseId") String licenseId, @RequestBody License license) {
		licenseService.deleteLicense(license);
	}
}
