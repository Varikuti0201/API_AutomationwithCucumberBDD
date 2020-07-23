package com.auto1.resources;

public enum APIResources {

	GetManufacturerAPI("/v1/car-types/manufacturer"), GetMainTypesAPI("/v1/car-types/main-types"),
	GetBuiltDatesAPI("/v1/car-types/built-dates"), GetManufacturerAPI_Invalid("/v1/car-types/manufcturr");

	private String resource;

	APIResources(String resource) {
		this.resource = resource;
	}

	public String getResource() {
		return resource;
	}

	public enum USER_INPUT {
		Valid, InValid,

	}

}
