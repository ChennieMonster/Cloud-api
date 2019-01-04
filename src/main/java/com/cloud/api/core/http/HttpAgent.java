package com.cloud.api.core.http;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.Charset;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.ExceptionLogger;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import com.cloud.api.core.exception.ServiceException;

/**
 * @author Administrator HTTP处理
 */
public class HttpAgent extends HttpPost {
	
	private static final Logger logger = LoggerFactory.getLogger(HttpAgent.class);
	
	// 默认编码
	private static String charset = "UTF-8";
	private static final int DEFAULT_TIMEOUT = 60000;// 默认超时时间,毫秒
	
	private static final int HTTP_STATUS_OK = 200;

	public int getStatusLine() {
		return statusLine;
	}

	public static int getDefaultTimeout() {
		return DEFAULT_TIMEOUT;
	}

	private int statusLine;// 返回状态码
	private int timeout = 0;

	public HttpAgent(String url) {
		super(url);
	}

	public HttpAgent() {
		super();
	}

	public void setDefaultHeader() {
		this.addHeader("Content-type", "application/json; charset=UTF-8");
	}

	public void setContentHeader() {
		this.setHeader("contentEncoding", "charset=UTF-8");
	}

	public static PoolingHttpClientConnectionManager cm = null;
	public static CloseableHttpClient httpClient = null;

	static {
		cm = new PoolingHttpClientConnectionManager();
		// 最大连接数
		cm.setMaxTotal(400);
		// 路由连接数
		cm.setDefaultMaxPerRoute(200);

		httpClient = HttpClients.custom().setConnectionManager(cm).build();
	}
	
	/**
     * 通过get方式发送请求，并返回响应结果
     * 
     * @param url
     *            请求地址
     * @param params
     *            参数列表，例如name=小明&age=8里面的中文要经过Uri.encode编码
     * @param encoding
     *            编码格式
     * @return 服务器响应结果
     * @throws Exception
     */
    public static String doGet(String url, String params,
            String encoding) throws Exception {
        String result = "";
        url += ((-1 == url.indexOf("?")) ? "?" : "&") + params;

        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        get.setHeader("charset", encoding);

        try {
            HttpResponse response = client.execute(get);
            if (HTTP_STATUS_OK == response.getStatusLine().getStatusCode()) {
                result = EntityUtils.toString(response.getEntity(), encoding);
            } else {
                throw new ServiceException("Invalide response from Api!"
                        + response.toString());
            }
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

	/**
	 *
	 * @param jsonStr
	 * @return 接口返回信息
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public String doPost(String jsonStr) throws ClientProtocolException, IOException {
		HttpClient httpclient = new DefaultHttpClient();
		// 默认JSON传输
		this.setDefaultHeader();
		this.setContentHeader();
		// 接口返回
		String respJson = "";
		HttpResponse response = null;
		// 设置超时间
		if (timeout > 0) {
			httpclient.getParams().setIntParameter("http.socket.timeout", timeout);
		} else {
			httpclient.getParams().setIntParameter("http.socket.timeout", DEFAULT_TIMEOUT);
		}
		// 设置请求体,以及编码方式
		if (StringUtils.isNotBlank(jsonStr)) {
			StringEntity reqEntity = new StringEntity(jsonStr, charset);
			this.setEntity(reqEntity);
		}
		response = httpclient.execute(this);
		statusLine = response.getStatusLine().getStatusCode();
		logger.debug("HttpAgent statusline==>" + statusLine);
		if (response.getStatusLine().getStatusCode() == HttpStatus.OK.value()) {
			HttpEntity resEntity = response.getEntity();
			if (resEntity != null) {
				respJson = EntityUtils.toString(resEntity, "UTF-8");
			}
		}else {
			throw new ServiceException("Invalide response from Api!"
                    + response.toString());
		}
		return respJson;
	}

	// 返回HTTP相应状态码
	public int getstatusLine() {
		return statusLine;
	}

	public void setCharset(String charset) {
		this.charset = charset;
	}

	public void setUrl(String url) throws URISyntaxException {
		this.setURI(new URI(url));
	}

	/**
	 * 设置连接超时
	 *
	 * @param timeout
	 */
	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	/**
	 *
	 * @param jsonStr
	 * @return 接口返回信息
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public static String doPostNew(String postUrl, String jsonStr) throws ClientProtocolException, IOException {
		String responseStr = "";
		HttpPost httppost = new HttpPost(postUrl);
		// 配置请求的超时设置
		RequestConfig requestConfig = RequestConfig.custom().setConnectionRequestTimeout(DEFAULT_TIMEOUT)
				.setConnectTimeout(DEFAULT_TIMEOUT).setSocketTimeout(DEFAULT_TIMEOUT).build();
		httppost.setConfig(requestConfig);
		CloseableHttpResponse response = null;
		try {
			// 设置请求体,以及编码方式
			if (StringUtils.isNotBlank(jsonStr)) {
				StringEntity reqEntity = new StringEntity(jsonStr, charset);
				httppost.setEntity(reqEntity);
			}
			response = httpClient.execute(httppost);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.OK.value()) {
				HttpEntity resEntity = response.getEntity();
				if (resEntity != null) {
					responseStr = EntityUtils.toString(resEntity, charset);
				}
			}
		} catch (Exception e) {
			logger.error(e.getMessage());
		} finally {
			response.close();
		}
		return responseStr;
	}

	public static String httpPut(String urlPath, String data, String charSet)
	{
		String result = null;
		URL url = null;
		HttpURLConnection httpurlconnection = null;
		try
		{
			url = new URL(urlPath);
			httpurlconnection = (HttpURLConnection) url.openConnection();
			httpurlconnection.setDoInput(true);
			httpurlconnection.setDoOutput(true);
			httpurlconnection.setConnectTimeout(2000000);// 设置连接主机超时（单位：毫秒）
			httpurlconnection.setReadTimeout(2000000);// 设置从主机读取数据超时（单位：毫秒）
			
			httpurlconnection.setRequestProperty("Content-type", "application/json; charset=UTF-8");
			httpurlconnection.setRequestProperty("contentEncoding", "charset=UTF-8");
			httpurlconnection.setRequestMethod("PUT");
 
			if (StringUtils.isNotBlank(data))
			{
				httpurlconnection.getOutputStream().write(data.getBytes("UTF-8"));
			}
			httpurlconnection.getOutputStream().flush();
			httpurlconnection.getOutputStream().close();
			int code = httpurlconnection.getResponseCode();
 
			if (code == 200)
			{
				DataInputStream in = new DataInputStream(httpurlconnection.getInputStream());
				int len = in.available();
				byte[] by = new byte[len];
				in.readFully(by);
				if (StringUtils.isNotBlank(charSet))
				{
					result = new String(by, Charset.forName(charSet));
				} else
				{
					result = new String(by);
				}
				in.close();
			} else
			{
				throw new ServiceException("Invalide response from api!");
			}
		} catch (IOException e)
		{
			
		} finally
		{
			url = null;
			if (httpurlconnection != null)
			{
				httpurlconnection.disconnect();
			}
		}
		return result;
	}

	
}
