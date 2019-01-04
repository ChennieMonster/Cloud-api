package com.cloud.api.core.http;

import com.cloud.api.core.ObjectMapperSingleton;
import com.cloud.api.core.exception.ConnectionException;
import com.cloud.api.core.functions.EndpointURIFromRequestFunction;
import com.cloud.api.core.http.HttpOpenSClient;
import com.google.common.net.MediaType;

import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;

import org.apache.http.client.entity.EntityBuilder;
import org.apache.http.client.methods.*;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.InputStreamEntity;
import org.apache.http.impl.client.CloseableHttpClient;

public final class HttpOpenSExecutor<R> {

	private HttpOpenSClient<R> osClient;
    private CloseableHttpClient client;
    HttpUriRequest clientReq;
    private int retries;

    private HttpOpenSExecutor(HttpOpenSClient<R> osClient) {
        this.osClient = osClient;
    }

    /**
     * Creates a new HttpCommand from the given request
     * 
     * @param request
     *            the request
     * @return the command
     */
    public static <R> HttpOpenSExecutor<R> create(HttpOpenSClient<R> osClient) {
    	HttpOpenSExecutor<R> executor = new HttpOpenSExecutor<R>(osClient);
    	executor.initialize();
        return executor;
    }

    private void initialize() {
        URI url = null;
        try {
            url = populateQueryParams(osClient);
        } catch (URISyntaxException e) {
            throw new ConnectionException(e.getMessage(), e.getIndex(), e);
        }
        client = HttpClientFactory.INSTANCE.getClient(osClient.getConfig());

        switch (osClient.getMethod()) {
        case POST:
            clientReq = new HttpPost(url);
            break;
        case PUT:
            clientReq = new HttpPut(url);
            break;
        case DELETE:
            clientReq = new HttpDelete(url);
            break;
        case HEAD:
            clientReq = new HttpHead(url);
            break;
        case PATCH:
            clientReq = new HttpPatch(url);
            break;
        case GET:
            clientReq = new HttpGet(url);
            break;
        default:
            throw new IllegalArgumentException("Unsupported http method: " + osClient.getMethod());
        } 
        clientReq.setHeader("Accept", MediaType.JSON_UTF_8.toString());
        populateHeaders(osClient);
    }

    /**
     * Executes the command and returns the Response
     *
     * @return the response
     * @throws Exception
     */
    public CloseableHttpResponse execute() throws Exception {

        EntityBuilder builder = null;

        if (osClient.getEntity() != null) {
            if (InputStream.class.isAssignableFrom(osClient.getEntity().getClass())) {
                InputStreamEntity ise = new InputStreamEntity((InputStream) osClient.getEntity(),
                        ContentType.create(osClient.getContentType()));
                ((HttpEntityEnclosingRequestBase) clientReq).setEntity(ise);
            } else {
                builder = EntityBuilder.create().setContentType(ContentType.create(osClient.getContentType(), "UTF-8"))
                        .setText(ObjectMapperSingleton.getContext(osClient.getEntity().getClass()).writer()
                                .writeValueAsString(osClient.getEntity()));
            }
        } else if (osClient.hasJson()) {
            builder = EntityBuilder.create().setContentType(ContentType.APPLICATION_JSON).setText(osClient.getJson());
        }
        if (builder != null && clientReq instanceof HttpEntityEnclosingRequestBase)
            ((HttpEntityEnclosingRequestBase) clientReq).setEntity(builder.build());
        return client.execute(clientReq);
    }

    /**
     * @return true if a request entity has been set
     */
    public boolean hasEntity() {
        return osClient.getEntity() != null;
    }

    /**
     * @return current retry execution count for this command
     */
    public int getRetries() {
        return retries;
    }

    /**
     * @return incremement's the retry count and returns self
     */
    public HttpOpenSExecutor<R> incrementRetriesAndReturn() {
        initialize();
        retries++;
        return this;
    }

    public HttpOpenSClient<R> getOpenSClient() {
        return osClient;
    }

    private URI populateQueryParams(HttpOpenSClient<R> osClient) throws URISyntaxException {

        URIBuilder uri = new URIBuilder(new EndpointURIFromRequestFunction().apply(osClient));

        if (!osClient.hasQueryParams())
            return uri.build();

        for (Map.Entry<String, List<Object>> entry : osClient.getQueryParams().entrySet()) {
            for (Object o : entry.getValue()) {
                uri.addParameter(entry.getKey(), String.valueOf(o));
            }
        }
        return uri.build();
    }

    private void populateHeaders(HttpOpenSClient<R> osClient) {

        if (!osClient.hasHeaders())
            return;

        for (Map.Entry<String, Object> h : osClient.getHeaders().entrySet()) {
            clientReq.addHeader(h.getKey(), String.valueOf(h.getValue()));
        }
    }
}
