package com.cloud.api;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

import com.cloud.api.entity.AppInstanceDetailDO;
import com.cloud.api.entity.request.ApplicationRequest;
import com.cloud.api.entity.request.GuiRequestBody;
import com.cloud.api.util.JsonUtils;

public class JsonTest {
	
	@Test
	public void test1() {
//		TokenDO tokenDO = new TokenDO();
//		tokenDO.setdExpiresTime(new Date());
////		tokenDO.setsPassword("123321");
////		tokenDO.setsTenantId("2222");
//		tokenDO.setsUserName("ssss");
//		tokenDO.setsTokenId("fasfertvafderq");
//		MqMessage mqMessage = new MqMessage("template", tokenDO);
//		
//		String str = JSON.toJSONString(mqMessage);
//		System.out.println(str);
//		
//		MqMessage mqMsg = JSON.parseObject(str, MqMessage.class);
//		
//		System.out.println(mqMsg.getTokenDO().getsTokenId());
	}
	
	@Test
	public void test2() throws IOException {
		String str = "{\r\n" + 
				"	\"project\": \"11\",\r\n" + 
				"	\"region\": \"nanking\",\r\n" + 
				"	\"data\": {\r\n" + 
				"		\"applicationName\": \"template005\",\r\n" + 
				"		\"applicationDisplayName\": \"template 005\",\r\n" + 
				"		\"applicationDescription\": \"asd\",\r\n" + 
				"		\"instances\": [{\r\n" + 
				"			\"instanceName\": \"Apache Tomcat5\",\r\n" + 
				"			\"instanceDisplayName\": \"Tomcat 12\",\r\n" + 
				"			\"instanceDescription\": \"description\",\r\n" + 
				"			\"objects\": [{\r\n" + 
				"				\"apiVersion\": \"v1\",\r\n" + 
				"				\"kind\": \"Service\",\r\n" + 
				"				\"metadata\": {\r\n" + 
				"					\"annotations\": {\r\n" + 
				"						\"description\": \"Exposes and load balances the application pods\"\r\n" + 
				"					},\r\n" + 
				"					\"name\": \"${NAME}\"\r\n" + 
				"				},\r\n" + 
				"				\"spec\": {\r\n" + 
				"					\"ports\": [{\r\n" + 
				"						\"name\": \"web\",\r\n" + 
				"						\"port\": 8080,\r\n" + 
				"						\"targetPort\": 8080\r\n" + 
				"					}],\r\n" + 
				"					\"selector\": {\r\n" + 
				"						\"name\": \"${NAME}\"\r\n" + 
				"					}\r\n" + 
				"				}\r\n" + 
				"			}, {\r\n" + 
				"				\"apiVersion\": \"v1\",\r\n" + 
				"				\"kind\": \"Route\",\r\n" + 
				"				\"metadata\": {\r\n" + 
				"					\"annotations\": {\r\n" + 
				"						\"template.openshift.io/expose-uri\": \"http://{.spec.host}{.spec.path}\"\r\n" + 
				"					},\r\n" + 
				"					\"name\": \"${NAME}\"\r\n" + 
				"				},\r\n" + 
				"				\"spec\": {\r\n" + 
				"					\"host\": \"${APPLICATION_DOMAIN}\",\r\n" + 
				"					\"to\": null\r\n" + 
				"				}\r\n" + 
				"			},{\r\n" + 
				"				\"apiVersion\": \"extensions/v1beta1\",\r\n" + 
				"				\"kind\": \"Deployment\",\r\n" + 
				"				\"metadata\": {\r\n" + 
				"					\"creationTimestamp\": null,\r\n" + 
				"					\"name\": \"nginx\",\r\n" + 
				"					\"namespace\": \"${NAMESPACE}\"\r\n" + 
				"				},\r\n" + 
				"				\"spec\": {\r\n" + 
				"					\"replicas\": 1,\r\n" + 
				"					\"revisionHistoryLimit\": 5,\r\n" + 
				"					\"selector\": {},\r\n" + 
				"					\"strategy\": {\r\n" + 
				"						\"rollingUpdate\": {\r\n" + 
				"							\"maxSurge\": 1,\r\n" + 
				"							\"maxUnavailable\": 0\r\n" + 
				"						},\r\n" + 
				"						\"type\": \"RollingUpdate\"\r\n" + 
				"					},\r\n" + 
				"					\"template\": {\r\n" + 
				"						\"metadata\": {\r\n" + 
				"							\"creationTimestamp\": null\r\n" + 
				"						},\r\n" + 
				"						\"spec\": {\r\n" + 
				"							\"containers\": [{\r\n" + 
				"								\"args\": [\"-f\", \"/conf/logstash.conf\"],\r\n" + 
				"								\"command\": [\"/docker-entrypoint.sh\"],\r\n" + 
				"								\"image\": \"ccr.ccs.tencentyun.com/library/logstash:latest\",\r\n" + 
				"								\"imagePullPolicy\": \"Always\",\r\n" + 
				"								\"name\": \"logstash\",\r\n" + 
				"								\"resources\": {\r\n" + 
				"									\"limits\": {\r\n" + 
				"										\"cpu\": \"100m\",\r\n" + 
				"										\"memory\": \"512Mi\"\r\n" + 
				"									},\r\n" + 
				"									\"requests\": {\r\n" + 
				"										\"cpu\": \"20m\",\r\n" + 
				"										\"memory\": \"128Mi\"\r\n" + 
				"									}\r\n" + 
				"								},\r\n" + 
				"								\"securityContext\": {\r\n" + 
				"									\"privileged\": false\r\n" + 
				"								},\r\n" + 
				"								\"volumeMounts\": [{\r\n" + 
				"									\"mountPath\": \"/conf\",\r\n" + 
				"									\"name\": \"conf\"\r\n" + 
				"								}, {\r\n" + 
				"									\"mountPath\": \"/var/log/nginx\",\r\n" + 
				"									\"name\": \"log\"\r\n" + 
				"								}]\r\n" + 
				"							}, {\r\n" + 
				"								\"image\": \"ccr.ccs.tencentyun.com/library/nginx:latest\",\r\n" + 
				"								\"imagePullPolicy\": \"Always\",\r\n" + 
				"								\"name\": \"nginx\",\r\n" + 
				"								\"resources\": {\r\n" + 
				"									\"limits\": {\r\n" + 
				"										\"cpu\": \"100m\",\r\n" + 
				"										\"memory\": \"128Mi\"\r\n" + 
				"									},\r\n" + 
				"									\"requests\": {\r\n" + 
				"										\"cpu\": \"100m\",\r\n" + 
				"										\"memory\": \"64Mi\"\r\n" + 
				"									}\r\n" + 
				"								},\r\n" + 
				"								\"securityContext\": {\r\n" + 
				"									\"privileged\": false\r\n" + 
				"								},\r\n" + 
				"								\"volumeMounts\": [{\r\n" + 
				"									\"mountPath\": \"/var/log/nginx\",\r\n" + 
				"									\"name\": \"log\"\r\n" + 
				"								}]\r\n" + 
				"							}],\r\n" + 
				"							\"serviceAccountName\": \"\",\r\n" + 
				"							\"volumes\": [{\r\n" + 
				"								\"configMap\": {\r\n" + 
				"									\"items\": [{\r\n" + 
				"										\"key\": \"logstash.conf\",\r\n" + 
				"										\"mode\": 511,\r\n" + 
				"										\"path\": \"logstash.conf\"\r\n" + 
				"									}],\r\n" + 
				"									\"name\": \"${ReleaseConfig}\"\r\n" + 
				"								},\r\n" + 
				"								\"name\": \"conf\"\r\n" + 
				"							}, {\r\n" + 
				"								\"emptyDir\": {},\r\n" + 
				"								\"name\": \"log\"\r\n" + 
				"							}]\r\n" + 
				"						}\r\n" + 
				"					}\r\n" + 
				"				},\r\n" + 
				"				\"status\": {}\r\n" + 
				"			}]\r\n" + 
				"		}],\r\n" + 
				"		\"parameters\": [{\r\n" + 
				"			\"name\": \"NAMESPACE\",\r\n" + 
				"			\"value\": \"global\"\r\n" + 
				"		},{\r\n" + 
				"			\"name\": \"ReleaseConfig\",\r\n" + 
				"			\"value\": \"Xmx=1024\"\r\n" + 
				"		},{\r\n" + 
				"			\"name\":\"NAME\",\r\n" + 
				"			\"value\":\"nginx-test\"\r\n" + 
				"		}]\r\n" + 
				"	}\r\n" + 
				"}";
		
		GuiRequestBody<ApplicationRequest>  ff = JsonUtils.jsonToObject(str, GuiRequestBody.class, ApplicationRequest.class);
		System.out.println(ff);
		
	}
	
	@Test
	public void test3() {
		
		String str = "[{\r\n" + 
				"				\"apiVersion\": \"v1\",\r\n" + 
				"				\"kind\": \"Service\",\r\n" + 
				"				\"metadata\": {\r\n" + 
				"					\"annotations\": {\r\n" + 
				"						\"description\": \"Exposes and load balances the application pods\"\r\n" + 
				"					},\r\n" + 
				"					\"name\": \"${NAME}\"\r\n" + 
				"				},\r\n" + 
				"				\"spec\": {\r\n" + 
				"					\"ports\": [{\r\n" + 
				"						\"name\": \"web\",\r\n" + 
				"						\"port\": 8080,\r\n" + 
				"						\"targetPort\": 8080\r\n" + 
				"					}],\r\n" + 
				"					\"selector\": {\r\n" + 
				"						\"name\": \"${NAME}\"\r\n" + 
				"					}\r\n" + 
				"				}\r\n" + 
				"			}, {\r\n" + 
				"				\"apiVersion\": \"v1\",\r\n" + 
				"				\"kind\": \"Route\",\r\n" + 
				"				\"metadata\": {\r\n" + 
				"					\"annotations\": {\r\n" + 
				"						\"template.openshift.io/expose-uri\": \"http://{.spec.host}{.spec.path}\"\r\n" + 
				"					},\r\n" + 
				"					\"name\": \"${NAME}\"\r\n" + 
				"				},\r\n" + 
				"				\"spec\": {\r\n" + 
				"					\"host\": \"${APPLICATION_DOMAIN}\",\r\n" + 
				"					\"to\": null\r\n" + 
				"				}\r\n" + 
				"			}, {\r\n" + 
				"				\"apiVersion\": \"extensions/v1beta1\",\r\n" + 
				"				\"kind\": \"Deployment\",\r\n" + 
				"				\"metadata\": {\r\n" + 
				"					\"name\": \"${NAME}\"\r\n" + 
				"				},\r\n" + 
				"				\"spec\": {\r\n" + 
				"					\"progressDeadlineSeconds\": 600,\r\n" + 
				"					\"replicas\": 3,\r\n" + 
				"					\"revisionHistoryLimit\": 10,\r\n" + 
				"					\"selector\": {\r\n" + 
				"						\"matchLabels\": {\r\n" + 
				"							\"app\": \"${NAME}\"\r\n" + 
				"						}\r\n" + 
				"					},\r\n" + 
				"					\"strategy\": {\r\n" + 
				"						\"rollingUpdate\": {\r\n" + 
				"							\"maxSurge\": 1,\r\n" + 
				"							\"maxUnavailable\": 1\r\n" + 
				"						},\r\n" + 
				"						\"type\": \"RollingUpdate\"\r\n" + 
				"					},\r\n" + 
				"					\"template\": {\r\n" + 
				"						\"metadata\": {\r\n" + 
				"							\"creationTimestamp\": null,\r\n" + 
				"							\"labels\": {\r\n" + 
				"								\"app\": \"nginx\"\r\n" + 
				"							}\r\n" + 
				"						},\r\n" + 
				"						\"spec\": {\r\n" + 
				"							\"containers\": [{\r\n" + 
				"								\"image\": \"nginx:1.9.1\",\r\n" + 
				"								\"imagePullPolicy\": \"IfNotPresent\",\r\n" + 
				"								\"name\": \"nginx1\",\r\n" + 
				"								\"ports\": [{\r\n" + 
				"									\"containerPort\": 80,\r\n" + 
				"									\"protocol\": \"TCP\"\r\n" + 
				"								}],\r\n" + 
				"								\"resources\": {},\r\n" + 
				"								\"terminationMessagePath\": \"/dev/termination-log\",\r\n" + 
				"								\"terminationMessagePolicy\": \"File\"\r\n" + 
				"							}],\r\n" + 
				"							\"dnsPolicy\": \"ClusterFirst\",\r\n" + 
				"							\"restartPolicy\": \"Always\",\r\n" + 
				"							\"schedulerName\": \"default-scheduler\",\r\n" + 
				"							\"securityContext\": {},\r\n" + 
				"							\"terminationGracePeriodSeconds\": 30\r\n" + 
				"						}\r\n" + 
				"					}\r\n" + 
				"				}\r\n" + 
				"			}]";
		
//		List<AppInstanceDetailDO> objectsList = (List<AppInstanceDetailDO>) JsonUtils.jsonToObject(str, AppInstanceDetailDO.class);
		List<AppInstanceDetailDO> objectsList2 = JsonUtils.jsonToObject(str, List.class);
	}
	
//	@Test
//	public void test4() {
//		
//		String str = "\"metadata\": {\r\n" + 
//				"					\"annotations\": {\r\n" + 
//				"						\"description\": \"Exposes and load balances the application pods\"\r\n" + 
//				"					},\r\n" + 
//				"					\"name\": \"${NAME}\"\r\n" + 
//				"				}";
//		JsonNode jsNode = JsonUtils.strToJsonNode(str);
//		String s = jsNode.get("type").toString();
//		System.out.println(s);
//	}
	
	@Test
	public void test5() {

		String str = "{\"apiVersion\":\"extensions/v1beta1\",\"kind\":\"Deployment\",\"metadata\":{\"name\":\"nginx\",\"namespace\":\"${NAMESPACE}\"},\"spec\":{\"selector\":{},\"replicas\":1,\"revisionHistoryLimit\":5,\"strategy\":{\"rollingUpdate\":{\"maxSurge\":\"1\",\"maxUnavailable\":\"0\"},\"type\":\"RollingUpdate\"},\"template\":{\"metadata\":{},\"spec\":{\"containers\":[{\"image\":\"ccr.ccs.tencentyun.com/library/logstash:latest\",\"imagePullPolicy\":\"Always\",\"name\":\"logstash\",\"resources\":{\"limits\":{\"cpu\":\"100m\",\"memory\":\"512Mi\"},\"requests\":{\"cpu\":\"20m\",\"memory\":\"128Mi\"}}},{\"image\":\"ccr.ccs.tencentyun.com/library/nginx:latest\",\"imagePullPolicy\":\"Always\",\"name\":\"nginx\",\"resources\":{\"limits\":{\"cpu\":\"100m\",\"memory\":\"128Mi\"},\"requests\":{\"cpu\":\"100m\",\"memory\":\"64Mi\"}}}]}}}}";
		String str2 = str.replace("${NAMESPACE}", "namespace");
		System.out.println(str2);
		
	}
	
	@Test
	public void test6() {
		
		Pattern p = Pattern.compile("[a-z0-9]([-a-z0-9]*[a-z0-9])?(\\\\.[a-z0-9]([-a-z0-9]*[a-z0-9])?)*");
		Matcher m = p.matcher("daass");
		boolean b = m.matches();
		System.out.println(b);
		
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Test
	public void test7() {
		
		List<String> instanceNameList = new ArrayList<>();
		instanceNameList.add("apple");
		instanceNameList.add("apple");
		instanceNameList.add("orange");
		instanceNameList.add("banana");
		instanceNameList.add("banana");
		
		Set nameSet = new HashSet(instanceNameList);
		System.out.println(nameSet.size());
		System.out.println(instanceNameList.size());
		
	}
	
	@Test
	public void test8() {
		Set<String> instanceNameSet = new HashSet<>();
		List<String> instanceNameList = new ArrayList<>();
		instanceNameList.add("apple");
		instanceNameList.add("apple");
		instanceNameList.add("orange");
		instanceNameList.add("banana");
		instanceNameList.add("banana");
		for(String fruit : instanceNameList) {
			instanceNameSet.add(fruit);
		}
		System.out.println(instanceNameSet.size());
		System.out.println(instanceNameSet);
	}
	
}
