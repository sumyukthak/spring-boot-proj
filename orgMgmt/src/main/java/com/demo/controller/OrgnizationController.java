package com.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.demo.model.Organization;
import com.demo.service.OrganizationService;

@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class OrgnizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping(value = "/organization/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Organization> getOrganizationById(@PathVariable Integer id) {
        return ResponseEntity.ok(organizationService.getOrganizationById(id));
    }
}
