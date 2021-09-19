package com.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.model.Asset;
import com.demo.service.AssetService;
@CrossOrigin
@RestController
@RequestMapping("/api/v1")
public class AssetController {

    @Autowired
    private AssetService assetService;

    @GetMapping(value="/assets", produces = MediaType.APPLICATION_XML_VALUE)
    public List<Asset> getAllAssets() {
        return assetService.getAllAssets();
    }

    @GetMapping(value="/asset/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Asset> getAssetById(@PathVariable Long id) {
        return ResponseEntity.ok(assetService.getAssetById(id));
    }
    

    @PostMapping(value="/assets", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Asset> createAsset(@Valid @RequestBody Asset asset) {
        return ResponseEntity.ok(assetService.save(asset));
    }

    @PutMapping(value="/asset/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Asset> updateAsset(@PathVariable Long id, @Valid @RequestBody Asset assetDetails) {
    	return ResponseEntity.ok(assetService.update(id, assetDetails));
    }

    @DeleteMapping(value="/asset/{id}", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity<Map<String, Boolean>> deleteAsset(@PathVariable Long id) {        
        assetService.delete(id);
        Map<String, Boolean> res = new HashMap<String, Boolean>();
        res.put("delete", Boolean.TRUE);
        return ResponseEntity.ok(res);
    }
}
