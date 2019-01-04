package com.cloud.api.core.http;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContexts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.cloud.api.core.Config;

public class HttpClientFactory {

	public static final HttpClientFactory INSTANCE = new HttpClientFactory();
	
    private static final String USER_AGENT = "oc/v1.10.0+b81c8f8 (linux/amd64) kubernetes/b81c8f8";
    
    private static final Logger LOG = LoggerFactory.getLogger(HttpOpenSExecutor.class);

    private CloseableHttpClient client;

    /**
     * Creates or Returns an existing HttpClient
     *
     * @param config the configuration
     * @return CloseableHttpClient
     */
    CloseableHttpClient getClient(Config config) {
        if (client == null) {
            synchronized(this) {
                if (client == null) {
                    client = buildClient(config);
                }
            }
        }
        return client;
    }

    private CloseableHttpClient buildClient(Config config) {
        HttpClientBuilder cb = HttpClientBuilder.create().setUserAgent(USER_AGENT);

        if (config.getProxy() != null) {
            try {
                URL url = new URL(config.getProxy().getHost());
                HttpHost proxy = new HttpHost(url.getHost(), config.getProxy().getPort(), url.getProtocol());
                cb.setProxy(proxy);
            } catch (MalformedURLException e) {
                LOG.error(e.getMessage(), e);
            }
        }

        if (config.getMaxConnections() > 0) {
            cb.setMaxConnTotal(config.getMaxConnections());
        }

        if (config.getMaxConnectionsPerRoute() > 0) {
            cb.setMaxConnPerRoute(config.getMaxConnectionsPerRoute());
        }

        try {
			cb.setSslcontext(createIgnoreVerifySSL());
		} catch (KeyManagementException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        RequestConfig.Builder rcb = RequestConfig.custom();

        if (config.getConnectTimeout() > 0)
            rcb.setConnectTimeout(config.getConnectTimeout());

        if (config.getReadTimeout() > 0)
            rcb.setSocketTimeout(config.getReadTimeout());

        return cb.setDefaultRequestConfig(rcb.build()).build();
    }
    
    public static SSLContext createIgnoreVerifySSL() throws NoSuchAlgorithmException, KeyManagementException {  
        SSLContext sc = SSLContext.getInstance("TLSv1.2");
      
        // 实现一个X509TrustManager接口，用于绕过验证，不用修改里面的方法  
        X509TrustManager trustManager = new X509TrustManager() {  
            @Override  
            public void checkClientTrusted(  
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,  
                    String paramString) throws CertificateException {  
            }  
      
            @Override  
            public void checkServerTrusted(  
                    java.security.cert.X509Certificate[] paramArrayOfX509Certificate,  
                    String paramString) throws CertificateException {  
            }  
      
            @Override  
            public java.security.cert.X509Certificate[] getAcceptedIssuers() {  
                return null;  
            }  
        };  
      
        sc.init(null, new TrustManager[] { trustManager }, null);  
        return sc;
    }
}
