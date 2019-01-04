/**
 * 
 */
package com.cloud.api.entity.request;

/**
 * @author zhao_pengchen
 *
 */
public class CicdProjectRequest {

	private String jobId;

    private String projectName;

    private String gitUrl;

    private String gitUsername;

    private String gitPassword;

    private Integer servicePort;

    private String serviceName;

    private String remark;
    
    private Integer codeAnalysis;

    private Integer unitTest;

    private Integer integrationTest;

    private String codePath;

    private String compileFilePath;

    private String apiUrl;

	public String getJobId() {
		return jobId;
	}

	public void setJobId(String jobId) {
		this.jobId = jobId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getGitUrl() {
		return gitUrl;
	}

	public void setGitUrl(String gitUrl) {
		this.gitUrl = gitUrl;
	}

	public String getGitUsername() {
		return gitUsername;
	}

	public void setGitUsername(String gitUsername) {
		this.gitUsername = gitUsername;
	}

	public String getGitPassword() {
		return gitPassword;
	}

	public void setGitPassword(String gitPassword) {
		this.gitPassword = gitPassword;
	}

	public Integer getServicePort() {
		return servicePort;
	}

	public void setServicePort(Integer servicePort) {
		this.servicePort = servicePort;
	}

	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getCodeAnalysis() {
		return codeAnalysis;
	}

	public void setCodeAnalysis(Integer codeAnalysis) {
		this.codeAnalysis = codeAnalysis;
	}

	public Integer getUnitTest() {
		return unitTest;
	}

	public void setUnitTest(Integer unitTest) {
		this.unitTest = unitTest;
	}

	public Integer getIntegrationTest() {
		return integrationTest;
	}

	public void setIntegrationTest(Integer integrationTest) {
		this.integrationTest = integrationTest;
	}

	public String getCodePath() {
		return codePath;
	}

	public void setCodePath(String codePath) {
		this.codePath = codePath;
	}

	public String getCompileFilePath() {
		return compileFilePath;
	}

	public void setCompileFilePath(String compileFilePath) {
		this.compileFilePath = compileFilePath;
	}

	public String getApiUrl() {
		return apiUrl;
	}

	public void setApiUrl(String apiUrl) {
		this.apiUrl = apiUrl;
	}
    
}
