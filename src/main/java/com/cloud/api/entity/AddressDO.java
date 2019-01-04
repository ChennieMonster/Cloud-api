package com.cloud.api.entity;
/**
* @author huang_kefei
* @date 2018年11月11日
* 类说明
*/
public class AddressDO {
private String ip;
private String nodeName;
private TargetRefDO targetRef;
public String getIp() {
	return ip;
}
public void setIp(String ip) {
	this.ip = ip;
}
public String getNodeName() {
	return nodeName;
}
public void setNodeName(String nodeName) {
	this.nodeName = nodeName;
}
public TargetRefDO getTargetRef() {
	return targetRef;
}
public void setTargetRef(TargetRefDO targetRef) {
	this.targetRef = targetRef;
}


}
