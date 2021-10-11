package com.policybazaar.refund.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.policybazaar.refund.constant.Constant;
import com.policybazaar.refund.refunddashboard.component.InMemoryCache;
import com.policybazaar.refund.refunddashboard.exception.InvailedTokenException;
import com.policybazaar.refund.refunddashboard.repository.RefundPropertiesRepository;
import com.policybazaar.refund.refunddashboard.request.RequestHeaderDetailsDto;
import com.policybazaar.refund.refunddashboard.response.TokenValidationResponse;
import com.policybazaar.refund.util.RestClient;

@Aspect
@Component
public class RequestValidator{
	
	
	public Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	RequestHeaderDetailsDto requestHeaderDetailsDto;
	
	@Autowired
	RefundPropertiesRepository refundPropertiesRepository;
	
	
	
	@Pointcut("execution(* com.policybazaar.refund.refunddashboard.serviceimpl.RefundRequestServiceImpl.*(..))")
	public void validateTokenPointCut() {}
	
	@Around("validateTokenPointCut()")//join point
	public Object validateToken(ProceedingJoinPoint proceedingJoinPoint) {
		RestClient restClient=new RestClient();
		logger.info(" Check for user access ");
		String dataUrl = "";
		final String clintIdValue=InMemoryCache.properties.containsKey(Constant.auth_token_clintId)?InMemoryCache.properties.get(Constant.auth_token_clintId):"";
		final String secretKeyValue=InMemoryCache.properties.containsKey(Constant.auth_token_secretKey)?InMemoryCache.properties.get(Constant.auth_token_secretKey):"";
		final String secretCodeValue=InMemoryCache.properties.containsKey(Constant.auth_token_secretCode)?InMemoryCache.properties.get(Constant.auth_token_secretCode):"";
		final String authValidateUri=InMemoryCache.properties.containsKey(Constant.auth_token_validateuri)?InMemoryCache.properties.get(Constant.auth_token_validateuri):"";
		String access_token="";
		if (System.getenv("domainUrl") != null)
        {
            dataUrl = System.getenv("domainUrl");
            logger.debug("dataUrl from env variable : " + dataUrl);
        }
		
		access_token=requestHeaderDetailsDto.getAccessToken();
		Object result=null;
		dataUrl+=authValidateUri+Constant.clintId_key+clintIdValue+Constant.secretKey+secretKeyValue+Constant.secretCode_key+secretCodeValue+Constant.access_token_key+access_token;
		ResponseEntity<TokenValidationResponse> response= restClient.get(dataUrl, TokenValidationResponse.class);
		int isValid=0;
		if (response != null && response.hasBody() && response.getBody() != null)
        {
            logger.debug("::::GOT RESPONSE FROM Application & GOING TO RETURN URI::::");
            TokenValidationResponse tokenValidationResponse = response.getBody();
            if(tokenValidationResponse!= null) {
            	isValid = tokenValidationResponse.getOk();
            }   
        }
		
		if(isValid==1) {
			try {
				result=proceedingJoinPoint.proceed();
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
			throw new InvailedTokenException("invailed access_token "+access_token);
		return result;
	}
	
	
}
