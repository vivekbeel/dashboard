package com.policybazaar.refund.util;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.util.CollectionUtils;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

/**
 * 
 * @author dharmendra.singh
 *
 */
@Configuration
public class RestClient {

    /**
     * Method: GET
     * 
     * @param url
     * @return
     */
    
    private List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
    
    
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public ResponseEntity<String> get(String url){
        if(isValidUrl(url)){
            RestTemplate restTemplate = new RestTemplate();
            
            if(!CollectionUtils.isEmpty(messageConverters)) {
                restTemplate.setMessageConverters(messageConverters);
            }
            try {
                SimpleClientHttpRequestFactory  rf =
                        (SimpleClientHttpRequestFactory ) restTemplate.getRequestFactory();
                rf.setReadTimeout(15 * 1000);
                rf.setConnectTimeout(5 * 1000);

                return restTemplate.getForEntity(url, String.class);
            }catch (RestClientException rce){
                return new BrokenResponse("Could not complete the request at the moment.", rce);
            }
        }
        return null;
    }

    /**
     * Method: GET
     *
     * @param url
     * @param responseType
     * @param urlVariables
     * @param <T>
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <T> ResponseEntity<T> get(String url, Class<T> responseType, Object ... urlVariables){
        if(url == null || responseType == null){
            throw new IllegalArgumentException("URL is required for HTTP GET. It can not be null.");
        }
        try{
            RestTemplate restTemplate = new RestTemplate();
            if(!CollectionUtils.isEmpty(messageConverters)) {
                restTemplate.setMessageConverters(messageConverters);
            }
            SimpleClientHttpRequestFactory  rf =
                    (SimpleClientHttpRequestFactory ) restTemplate.getRequestFactory();
            rf.setReadTimeout(15 * 1000);
            rf.setConnectTimeout(5 * 1000);
            return restTemplate.getForEntity(url, responseType, urlVariables);
        }catch(RestClientException rce){
            return new BrokenResponse("Could not complete the request at the moment.", rce);
        }
    }

    /**
     * Method: GET
     *
     * @param url
     * @param responseType
     * @param urlVariables
     * @param <T>
     * @return
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public <T> ResponseEntity<T> get(String url, Class<T> responseType, Map<String, ?> urlVariables){
        if(url == null || responseType == null){
            throw new IllegalArgumentException("URL is required for HTTP GET. It can not be null.");
        }
        try{
            RestTemplate restTemplate = new RestTemplate();
            if(!CollectionUtils.isEmpty(messageConverters)) {
                restTemplate.setMessageConverters(messageConverters);
            }
            SimpleClientHttpRequestFactory  rf =
                    (SimpleClientHttpRequestFactory ) restTemplate.getRequestFactory();
            rf.setReadTimeout(15 * 1000);
            rf.setConnectTimeout(5 * 1000);
            return restTemplate.getForEntity(url, responseType, urlVariables);
        }catch(RestClientException rce){
            return new BrokenResponse("Could not complete the request at the moment.", rce);
        }
    }
    
    /**
     * Method: POST
     * 
     * @param url
     * @param request: the object that needs to be posted
     * @param responseType
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <T> ResponseEntity<T> post(URI url, Object request, Class<T> responseType) {
        if (url == null || responseType == null) 
            throw new IllegalArgumentException("URL is required for HTTP POST. It can not be null.");
        
        try {
            RestTemplate restTemplate = new RestTemplate();
            if(!CollectionUtils.isEmpty(messageConverters)) {
                restTemplate.setMessageConverters(messageConverters);
            }
            return restTemplate.postForEntity(url, request, responseType);
        }catch (RestClientException rce){
            return new BrokenResponse("Could not complete the request at the moment.", rce);
        }
    }

    
    /**
     * Method: POST
     * 
     * @param url
     * @param request: the object that needs to be posted
     * @param responseType
     * @param urlVariables
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <T> ResponseEntity<T> post(String url, Object request, Class<T> responseType, Object ... urlVariables){
        if (url == null || responseType == null) 
            throw new IllegalArgumentException("URL is required for HTTP POST. It can not be null.");
        
        try {
            RestTemplate restTemplate = new RestTemplate();
            if(!CollectionUtils.isEmpty(messageConverters)) {
                restTemplate.setMessageConverters(messageConverters);
            }
            return restTemplate.postForEntity(url, request, responseType, urlVariables);
        }catch (RestClientException rce){
            return new BrokenResponse("Could not complete the request at the moment.", rce);
        }
    }

    /**
     * Method: POST 
     * 
     * @param url
     * @param request : the object that needs to be posted
     * @param responseType
     * @param uriVariables
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <T> ResponseEntity<T> post(String url, Object request, Class<T> responseType, Map<Object, ?> uriVariables){
        if (url == null || responseType == null) 
            throw new IllegalArgumentException("URL is required for HTTP POST. It can not be null.");
        
        try {
            RestTemplate restTemplate = new RestTemplate();
            if(!CollectionUtils.isEmpty(messageConverters)) {
                restTemplate.setMessageConverters(messageConverters);
            }
            return restTemplate.postForEntity(url, request, responseType, uriVariables);
        }catch (RestClientException rce){
            return new BrokenResponse("Could not complete the request at the moment.", rce);
        }
    }
    
    /**
     * Method: exchange 
     * 
     * @param url
     * @param request : the object that needs to be posted/get
     * @param responseType
     * @param uriVariables
     * @return
     */
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public <T> ResponseEntity<T> exchange(String url, HttpMethod method,
            HttpEntity<?> requestEntity, Class<T> responseType,
            Object... uriVariables) {
        if (url == null || responseType == null)
            throw new IllegalArgumentException(
                    "URL is required for HTTP POST. It can not be null.");

        try {

            RestTemplate restTemplate = new RestTemplate();
        
            SimpleClientHttpRequestFactory rf = (SimpleClientHttpRequestFactory) restTemplate
                    .getRequestFactory();
            rf.setReadTimeout(15 * 1000);
            rf.setConnectTimeout(5 * 1000);
            return restTemplate.exchange(url, method, requestEntity,
                    responseType);
        } catch (RestClientException rce) {
            return new BrokenResponse(
                    "Could not complete the request at the moment.", rce);
        }
    }
    
     

    private boolean isValidUrl(String url){
        if(url == null){
            throw new IllegalArgumentException("URL is required for HTTP GET. It can not be null.");
        }
        return true;
    }

    public List<HttpMessageConverter<?>> getMessageConverters() {
        return messageConverters;
    }

    public void setMessageConverters(List<HttpMessageConverter<?>> messageConverters) {
        this.messageConverters = messageConverters;
    }

    /*public static void main(String [] args) throws Exception{
        
        //String url = "http://jssostg.indiatimes.com/sso/crossdomain/genericLogin?login=nitin111@indiatimes.com&passwd=123456&siteId=32c05a0c7818edb2451260f7c7fac46c";
        String url = "http://192.168.33.100/cmslite/api/userprefrence/userDetails/get?ssoToken=3103d4bddf614a719f527872816b3b91";
       
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> response = restTemplate.getForEntity(url,
                String.class);

        if (response != null && response.getBody() != null
                && response.getStatusCode().is2xxSuccessful()) {

            ObjectMapper mapper = new ObjectMapper();
            TypeReference<HashMap<String, Object>> typeRef 
              = new TypeReference<HashMap<String, Object>>() {};
            HashMap<String, Object> map = mapper.readValue(response.getBody(),
                    typeRef);
            if (map != null && map.containsKey("USERDETAILS")) {
                Map userDetails = (Map) map.get("USERDETAILS");
                
                System.err.println(userDetails.get("userId"));
                
                Map<CMSNode, UserToNodePermissions> nodePermissions = (Map<CMSNode, UserToNodePermissions>)userDetails.get("mapForNodePermissions");
                
                System.err.println(nodePermissions);
                
            }
        }
    }
*/

}
