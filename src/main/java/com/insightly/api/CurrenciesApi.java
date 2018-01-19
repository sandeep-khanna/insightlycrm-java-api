package com.insightly.api;

import com.insightly.api.util.ApiClient;
import com.insightly.model.Currency;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;


@Component("com.insightly.CurrenciesApi")
public class CurrenciesApi {
    private ApiClient apiClient;

    public CurrenciesApi() {
        this(new ApiClient());
    }

    @Autowired
    public CurrenciesApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Gets a list of Currencies used by Insightly
     * This read only endpoint returns a list of the currencies and currency symbols currently recognized by Insightly.
     * <p><b>200</b> - Request succeeded.
     * <p><b>401</b> - Authentication failed.
     * @return List&lt;Currency&gt;
     * @throws RestClientException if an error occurs while attempting to invoke the API
     */
    public List<Currency> getCurrencies() throws RestClientException {
        Object postBody = null;
        
        String path = UriComponentsBuilder.fromPath("/Currencies").build().toUriString();
        
        final MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<String, String>();
        final HttpHeaders headerParams = new HttpHeaders();
        final MultiValueMap<String, Object> formParams = new LinkedMultiValueMap<String, Object>();

        final String[] accepts = { 
            "application/json"
        };
        final List<MediaType> accept = apiClient.selectHeaderAccept(accepts);
        final String[] contentTypes = { };
        final MediaType contentType = apiClient.selectHeaderContentType(contentTypes);

        String[] authNames = new String[] {  };

        ParameterizedTypeReference<List<Currency>> returnType = new ParameterizedTypeReference<List<Currency>>() {};
        return apiClient.invokeAPI(path, HttpMethod.GET, queryParams, postBody, headerParams, formParams, accept, contentType, authNames, returnType);
    }
}
