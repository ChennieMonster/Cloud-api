/**
 *
 */
package com.cloud.api.core.constant;

/**
 * 系统常量
 *
 * @author zhao_pengchen
 */
public class Constants {

    /**
     * 成功状态
     */
    public static final Integer SUCCESS_RET_CODE = 0;

    /**
     * 失败状态
     */
    public static final Integer FAIL_RET_CODE = 1;

    public static final String APIVERSION = "template.openshift.io/v1";

    public static final String PORJECT_APIVERSION = "project.openshift.io/v1";

    public static final String NAMESPACE_OPENSHIFT = "default";

    public static final String TEMPLATE_KIND = "Template";

    public static final String METADATA_NAMESPACE = "cloud-api-test";

    public static final String INSTANCE_SERVICE = "Service";

    public static final String INSTANCE_ROUTE = "Route";

    public static final String INSTANCE_DEPLOYMENT = "Deployment";

    public static final String SPEC_SELECTOR_MATCHLABELS = "matchLabels";
    
    public static final String METADATA_LABELS_APP = "app";

    /**
     * 平台仓库
     */
    public static final String REGISTRY_TYPE_PLATFORM = "platform";

    /**
     * 私有仓库
     */
    public static final String REGISTRY_TYPE_PRIVATE = "private";

    /**
     * 第三方仓库
     */
    public static final String REGISTRY_TYPE_THIRD = "third";

    /**
     * 平台仓库用户名
     */
    public static final String REGISTRY_PLATFORM_USERNAME = "admin";

    /**
     * 平台仓库密码
     */
    public static final String REGISTRY_PLATEFORM_PASSWORD = "admin";

    public static final String IMAGE_FILE = "image_file";

    public static final String REGISTRY_PRIVATE_IMAGE = "registry:latest";

    public static final String STATUS = "Pending";

    public static final String STATUS_AVAILABLE = "available";

    public static final String STATUS_PROGRESSING = "progressing";

    public static final String STATUS_FAILURE = "failure";

    public static final String DEPLOYMENT_APIVERSION_1 = "apps/v1beta1";

    public static final String DEPLOYMENT_APIVERSION_2 = "apps/v1";

    public static final String DEPLOYMENT_APIVERSION_3 = "extensions/v1beta1";

    public static final String SERVICE_APIVERSION = "v1";

    public static final String ROUTE_APIVERSION = "route.openshift.io/v1";

    public static final String SERVICE_PROTOCOL_TCP = "TCP";

    public static final String SERVICE_PROTOCOL_UDP = "UDP";

    public static final String ROUTE_TO_KIND = "Service";

    public static final String MQ_ROUTEKEY_ROUTE = "Route";

    public static final String MQ_ROUTEKEY_SERVICE = "Service";

    public static final String MQ_ROUTEKEY_POD = "Pod";

    public static final String MQ_ROUTEKEY_REGISTRY = "ThirdRegistry";

    public static final String MQ_ROUTEKEY_TAG = "Tag";

    public static final String MQ_ROUTEKEY_QUOTA = "Quota";

    public static final String MQ_ROUTEKEY_DEPLOYMENT = "Deployment";
    
    public static final String MQ_ROUTEKEY_CONTAINER = "Container";

    public static final String MQ_EXCHANE_DIRECT = "DirectExchange";

    public static final String FILTER_NAME_DISPLAYNAME = "displayName";

    public static final String FILTER_NAME_STATUS = "status";

    public static final String FILTER_NAME_DESCRIPTION = "description";

    public static final String FILTER_NAME_CREATEDTIME = "createdTime";

    public static final String FILTER_NAME_INSTANCECOUNT = "instanceCount";

    public static final String FILTER_NAME_USERNAME = "username";

    public static final String OPERATION_TYPE_POST = "POST";

    public static final String OPERATION_TYPE_PUT = "PUT";

    public static final String OPERATION_TYPE_DELETE = "DELETE";

    public static final int IS_NOT_A_REGISTRY = 0;

    public static final int IS_A_REGISTRY = 1;

    public static final String ROUTE_TO_NAME = "name";

    /**
     * 创建私有仓库，service后缀名
     */
    public static final String REGISTRY_CREATE_NAME_SERVICE = "registry-service";

    /**
     * 创建私有仓库，route后缀名
     */
    public static final String REGISTRY_CREATE_NAME_ROUTE = "registry-route";

    /**
     * 创建私有仓库，deployment后缀名
     */
    public static final String REGISTRY_CREATE_NAME_DEPLOYMENT = "registry-deployment";

    /**
     * 创建私有仓库时,指定route的host 后缀名
     */
    public static final String ROUTE_HOST_SUFFIX = ".apps.example.com";

    /**
     * param key:NAME
     */
    public static final String PARAM_KEY_NAME = "NAME";

    /**
     * param key:APPLICATION_DOMAIN
     */
    public static final String PARAM_KEY_APPLICATION_DOMAIN = "APPLICATION_DOMAIN";

    /**
     * param key:IMAGE
     */
    public static final String PARAM_KEY_IMAGE = "IMAGE";

    /**
     * param key:CPU
     */
    public static final String PARAM_KEY_CPU = "CPU";

    /**
     * param key:MEMORY
     */
    public static final String PARAM_KEY_MEMORY = "MEMORY";

    /**
     * param key:NAMESPACE
     */
    public static final String PARAM_KEY_NAMESPACE = "NAMESPACE";

    /**
     * param key:SECRETNAME
     */
    public static final String PARAM_KEY_SECRETNAME = "SECRETNAME";

    public static final String PROJECT_APPLY_REASON = "apply";

    public static final String PROJECT_APPLY_STATUS = "apply";

    public static final String PROJECT_APPLY_TYPE = "project";

    /**
     * 容器暂停
     */
    public static final String CONTAINER_OPERATE_STOP = "stop";

    /**
     * 容器恢复
     */
    public static final String CONTAINER_OPERATE_RECOVERY = "recovery";

    /**
     * 容器删除
     */
    public static final String CONTAINER_OPERATE_DELETE = "delete";

    /**
     * 容器重启
     */
    public static final String CONTAINER_OPERATE_RESTART = "restart";

    /**
     * 容器kill
     */
    public static final String CONTAINER_OPERATE_KILL = "kill";

    /**
     * 上传文件
     */
    public static final String CONTAINER_OPERATE_UPLOADFILE = "uploadfile";

    public static final String ACTION_TYPE = "Create";

    public static final String ACTION_TYPE_EDIT = "Modify";

    public static final String PASS_PROCESS_STATUS = "approve";

    public static final String REVOKE_PROCESS_STATUS = "reject";

    public static final String PROJECT_KIND = "ProjectRequest";

    public static final String RESOURCEQUOTA_KIND = "ResourceQuota";

    public static final String RESOURCE_REQUESTS = "requests";

    public static final String RESOURCE_LIMITS = "limits";

    public static final String RESOURCE_CPU = "cpu";

    public static final String RESOURCE_MEMORY = "memory";

    /*
     * 新增用户时配置默认角色
     */
    public static final String ADMIN_ROLE_ID = "00011122233344455566677788899901";
    
    public static final String DEFAULT_ROLE_ID = "00011122233344455566677788899902";
    
    public static final String PROJECT_ROLE_ID = "00011122233344455566677788899903";

    public static final String DEFAULT_ROLE_NAME = "user";
    
    public static final String DEFAULT_ROLE_STATUS = "1";
    
    public static final String MODULES_TEMPLATES = "Templates";

    public static final String MODULES_TEMPLATES_PLATFORM = "TemplatesPlatform";

    public static final String MODULES_TEMPLATES_PRIVATE = "TemplatesPrivate";

    public static final String MODULES_APPLICATIONS = "Applications";

    public static final String MODULES_APPLICATION = "Application";

    public static final String MODULES_INSTANCES = "Instances";

    public static final String MODULES_INSTANCE = "Instance";

    public static final String MODULES_SERVICES = "Services";

    public static final String MODULES_SERVICE = "Service";

    public static final String MODULES_ROUTES = "Routes";

    public static final String MODULES_ROUTE = "Route";

    public static final String MODULES_DEPLOYMENT = "DeploymentConfiguration";
	
	public static final String MODULES_PODS = "DeploymentPods";
	
	public static final String MODULES_DEPLOYMENT_HISTORY = "DeploymentHistory";

    public static final String MODULES_PROJECTS = "projects";

    public static final String MODULES_PROJECT = "project";
    
    public static final String MODULES_APPLY = "Apply";
	
	public static final String MODULES_TODOLIST = "TodoList";
	
	public static final String MODULES_APPROVEHISTORY = "ApproveHistory";

    public static final String MODULES_PROCESS_SETTINGS = "ProcessSettings";

    public static final String MODULES_PROCESS_SETTING = "ProcessSetting";

    public static final String MODULES_USERS = "Users";

    public static final String MODULES_PROJECTUSERS = "ProjectUsers";

    public static final String MODULES_ROLES = "Roles";

    public static final String MODULES_OPERATIONLOGS = "OperationLogs";

    public static final String ACTION_QUERY = "query";
    
    public static final String ACTION_DETAIL = "detail";

    public static final String ACTION_ADD = "add";

    public static final String ACTION_MODIFY = "modify";

    public static final String ACTION_UPLOAD = "upload";

    public static final String ACTION_DEPLOY = "deploy";

    public static final String ACTION_DOWNLOAD = "download";

    public static final String ACTION_DELETE = "delete";

    public static final String ACTION_ROLLBACK = "rollback";
    
    public static final String ACTION_APPROVE = "approve";
    
    public static final String MODULES_CONTAINER = "Container";
    
    public static final String MODULES_CONTAINERS = "Containers";
    
    public static final String SECRET_TYPE_NAMEPW = "kubernetes.io/dockerconfigjson";
    
    public static final String MONITOR_TYPE_HOST = "host";
    
    public static final String MONITOR_TYPE_APPLICATION = "application";
    
    public static final String ITEM_CPU_UTIL = "cpuUtil";
    
    public static final String ITEM_MEMORY_UTIL = "memoryUtil";
    
    public static final String ITEM_NET_IN = "netIn";
    
    public static final String ITEM_NET_OUT = "netOut";
    
    public static final String ITEM_DISK_IN = "diskIn";

    public static final String ITEM_DISK_OUT = "diskOut";
    
    public static final String ITEM_BLOCK_IN = "blockIn";
    
    public static final String ITEM_BLOCK_OUT = "blockOut";
    
    public static final String ITEM_BLOCK = "block";
    
    public static final String ITEM_DISK = "disk";

    public static final String ITEM_NET = "net";
}
