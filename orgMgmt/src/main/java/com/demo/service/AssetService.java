package com.demo.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.model.Asset;
import com.demo.repository.AssetRepository;

@Service
public class AssetService {
	@Autowired
	AssetRepository assetRepository;

	/*
	 * @PostConstruct private void postConstruct() { Asset asset1 = new Asset();
	 * asset1.setAssetName("Laptop"); asset1.setAssetType("Hardware");
	 * 
	 * assetRepository.save(asset1);
	 * 
	 * 
	 * Asset asset2 = new Asset(); asset2.setAssetName("Printer");
	 * asset2.setAssetType("Hardware");
	 * 
	 * assetRepository.save(asset2);
	 * 
	 * Organization org = new Organization(); org.setOrgId(1);
	 * org.setOrgName("Org"); org.setBranch("Chennai");
	 * 
	 * }
	 */

// getting all asset records
	public List<Asset> getAllAssets() {
		List<Asset> assets = new ArrayList<Asset>();
		assetRepository.findAll().forEach(asset -> assets.add(asset));
		return assets;
	}

// getting a specific record
	public Asset getAssetById(long id) {
		Asset asset = assetRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Asset with the id - " + id + " not exist"));

		if (asset == null)
			throw new ResourceNotFoundException("id-" + id);

		return asset;
	}

	public Asset save(Asset asset) {
		return assetRepository.save(asset);
	}

	public Asset update(long id, Asset assetDetails) {
		Asset asset = assetRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Asset with the id - " + id + " not exist"));
		asset.setAssetName(assetDetails.getAssetName());
		asset.setAssetType(assetDetails.getAssetType());
		
		asset.setEmp(assetDetails.getEmp());
		asset.setOrg(assetDetails.getOrg());
		 
		return assetRepository.save(asset);
	}

// deleting a specific record
	public void delete(long id) {
		Asset asset = assetRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Asset with the id - " + id + " not exist"));
		assetRepository.delete(asset);
		if (asset == null)
			throw new ResourceNotFoundException("id-" + id);
	}

}
