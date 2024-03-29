package com.crowdfunding.core.util;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.multipart.MultipartRequestEntity;
import org.apache.commons.httpclient.methods.multipart.Part;

public class HttpUtils {
	public static String URI_PREFIX = "http://";

	public static HttpResponse get(String uri) throws Exception {
		return get(uri, null, null);
	}
	
	public static HttpResponse get(String uri, String encoding) throws Exception {
		return get(uri, null, encoding);
	}
	
	public static HttpResponse get(String uri, Header[] headers) throws Exception {
		return get(uri, headers, null);
	}

	public static HttpResponse get(String uri, Header[] headers, String encoding) throws Exception {
		return get(uri,headers,null,encoding);
	}
	public static HttpResponse get(String uri, Header[] headers,NameValuePair[] params,String encoding) throws Exception{
		HttpResponse httpResponse = new HttpResponse();
		
		uri = buildFullUri(uri);
		GetMethod getMethod = new GetMethod(uri);
		if(encoding != null) {
			getMethod.getParams().setHttpElementCharset(encoding);
			getMethod.getParams().setCredentialCharset(encoding);
			getMethod.getParams().setContentCharset(encoding);
		}
		if (headers != null) {
			for (Header header : headers) {
				getMethod.addRequestHeader(header);
			}
		}
		if(params!=null){
			getMethod.setQueryString(params);
		}
		HttpClient httpclient = new HttpClient();
		// timeout
		httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
		try {
			int status = httpclient.executeMethod(getMethod);
			String response = new String(getMethod.getResponseBody(), "utf-8");
			
			httpResponse.setStatus(status);
			httpResponse.setHeaders(getMethod.getResponseHeaders());
			httpResponse.setResponse(response);
		} catch (Exception e) {
			throw e;
		} finally {
			getMethod.releaseConnection();
		}
		
		return httpResponse;
	}

	public static HttpResponse post(String uri, NameValuePair[] data) throws Exception {
		return post(uri, data, null, null);
	}
	
	public static HttpResponse post(String uri, NameValuePair[] data, String encoding) throws Exception {
		return post(uri, data, null, encoding);
	}
	
	public static HttpResponse post(String uri, NameValuePair[] data, Header[] headers)
	throws Exception {
		return post(uri, data, headers, null);
	}

	public static HttpResponse post(String uri, NameValuePair[] data, Header[] headers, String encoding)
			throws Exception {
		HttpResponse httpResponse = new HttpResponse();
		
		uri = buildFullUri(uri);
		PostMethod postMethod = new PostMethod(uri);
		if(encoding != null) {
			postMethod.getParams().setHttpElementCharset(encoding);
			postMethod.getParams().setCredentialCharset(encoding);
			postMethod.getParams().setContentCharset(encoding);
		}
		if (headers != null) {
			for (Header header : headers) {
				postMethod.addRequestHeader(header);
			}
		}
		postMethod.setRequestBody(data);
		HttpClient httpclient = new HttpClient();
		// timeout
		httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
		try {
			int status = httpclient.executeMethod(postMethod);
			String response = new String(postMethod.getResponseBody(), "utf-8");
			
			httpResponse.setStatus(status);
			httpResponse.setHeaders(postMethod.getResponseHeaders());
			httpResponse.setResponse(response);
		} catch (Exception e) {
			throw e;
		} finally {
			postMethod.releaseConnection();
		}
		
		return httpResponse;
	}

	public static HttpResponse post(String uri, Part[] parts) throws Exception {
		return post(uri, parts, null, null);
	}
	
	public static HttpResponse post(String uri, Part[] parts, String encoding) throws Exception {
		return post(uri, parts, null, encoding);
	}
	
	public static HttpResponse post(String uri, Part[] parts, Header[] headers) throws Exception {
		return post(uri, parts, headers, null);
	}

	public static HttpResponse post(String uri, Part[] parts, Header[] headers, String encoding)
			throws Exception {
		HttpResponse httpResponse = new HttpResponse();
		
		uri = buildFullUri(uri);
		PostMethod postMethod = new PostMethod(uri);
		if(encoding != null) {
			postMethod.getParams().setHttpElementCharset(encoding);
			postMethod.getParams().setCredentialCharset(encoding);
			postMethod.getParams().setContentCharset(encoding);
		}
		if (headers != null) {
			for (Header header : headers) {
				postMethod.addRequestHeader(header);
			}
		}
		postMethod.setRequestEntity(new MultipartRequestEntity(parts,
				postMethod.getParams()));
		HttpClient httpclient = new HttpClient();
		// timeout
		httpclient.getHttpConnectionManager().getParams().setConnectionTimeout(5000);
		try {
			int status = httpclient.executeMethod(postMethod);
			String response = new String(postMethod.getResponseBody(), "utf-8");
			
			httpResponse.setStatus(status);
			httpResponse.setHeaders(postMethod.getResponseHeaders());
			httpResponse.setResponse(response);
		} catch (Exception e) {
			throw e;
		} finally {
			postMethod.releaseConnection();
		}
		
		return httpResponse;
	}

	public static String buildFullUri(String uri) {
		String lcUri = uri.toLowerCase();
		if (lcUri.startsWith("http://") || lcUri.startsWith("https://")) {
			return uri;
		}
		return URI_PREFIX + uri;
	}
	public static void main(String[] args) throws Exception {
		System.out.println(get("http://localhost:8080/docserver/rest/doc2swf/convert",null,new NameValuePair[]{new NameValuePair("srcfile","d:/abc.pdf")} ,"utf-8").getResponse());
	}
}
