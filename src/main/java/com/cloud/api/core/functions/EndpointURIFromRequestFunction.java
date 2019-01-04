package com.cloud.api.core.functions;

import com.cloud.api.core.http.HttpOpenSClient;
import com.google.common.base.Function;
import static com.cloud.api.util.ClientConstants.URI_SEP;

public class EndpointURIFromRequestFunction implements Function<HttpOpenSClient<?>, String>{

    /**
     * {@inheritDoc}
     */
    @Override
    public String apply(HttpOpenSClient<?> osClient) {
        if (osClient.getEndpoint().endsWith(URI_SEP) || osClient.getPath().startsWith(URI_SEP))
            return escape(osClient.getEndpoint() + osClient.getPath());
        
        return escape(osClient.getEndpoint() + URI_SEP + osClient.getPath());
    }
    
    private String escape(String uri) {
        return uri.replaceAll(" ", "%20");
    }
}
