package com.cloud.api.entity;

import com.cloud.api.model.ModelEntity;

public class ImageUploadDO implements ModelEntity{
	
	private static final long serialVersionUID = -5167391114618270165L;
	
	private String image_file;

	public String getImage_file() {
		return image_file;
	}

	public void setImage_file(String image_file) {
		this.image_file = image_file;
	}

	public ImageUploadDO(String image_file) {
		super();
		this.image_file = image_file;
	}

	public ImageUploadDO() {
		super();
		// TODO Auto-generated constructor stub
	}

}
