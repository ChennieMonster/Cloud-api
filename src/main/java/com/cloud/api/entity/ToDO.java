package com.cloud.api.entity;

/**
 * @author huang_kefei
 * @date 2018年11月28日 类说明
 */
public class ToDO {
	private String kind;
	private String name;
	private Integer weight;

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getWeight() {
		return weight;
	}

	public void setWeight(Integer weight) {
		this.weight = weight;
	}

}
