
package com.kio.applications.validator.noctopus.api;

import java.io.Serializable;
import java.security.cert.X509Certificate;
import java.util.concurrent.TimeUnit;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.core.MediaType;

import org.apache.log4j.Logger;
import org.apache.logging.log4j.core.net.Protocol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kio.applications.validator.exception.GenericException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * The Class APINoctopus.
 */
@Component 
@Scope("prototype")
public class APINoctopus implements Serializable {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -6641166885167286110L;
	/** The Constant logger. */
	private static final Logger logger = Logger.getLogger(APINoctopus.class);

	private static final String urlToken = "https://ansible.kionetworks.com/api/v2/tokens";

	/**
	 * Instantiates a new API remedy.
	 */
	@Autowired
	public APINoctopus() {
		this.disableCertificationValidation();
	}

	public boolean validateTokenAnsible(String token) throws GenericException {
		OkHttpClient client = null;
		Response response = null;
		Request request = null;

		int timeOut = 0;
		try {

			client = new OkHttpClient.Builder().connectTimeout(timeOut, TimeUnit.SECONDS)
					.writeTimeout(timeOut, TimeUnit.SECONDS).readTimeout(timeOut, TimeUnit.SECONDS).build();

			request = new Request.Builder().url(urlToken).method(RequestMethod.GET.name(), null)
					.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + token)
					.addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON).build();
			response = client.newCall(request).execute();

			if (!(response.code() >= 200 && response.code() <= 299)) {
				throw new GenericException("Token no registrado en ansible");
			}
		} catch (final Exception e) {
			logger.error(e.getMessage());
			throw new GenericException(e.getMessage());
		} finally {
			if (null != response) {
				response.close();
			}
		}
		return true;
	}

	/**
	 * Disable certification validation.
	 *
	 * @return true, if successful
	 */
	private boolean disableCertificationValidation() {
		try {
			// Create a trust manager that does not validate certificate chains
			final TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
				@Override
				public void checkClientTrusted(X509Certificate[] certs, String authType) {
				}

				@Override
				public void checkServerTrusted(X509Certificate[] certs, String authType) {
				}

				@Override
				public java.security.cert.X509Certificate[] getAcceptedIssuers() {
					return null;
				}
			} };
			// Install the all-trusting trust manager
			final SSLContext sc = SSLContext.getInstance(Protocol.SSL.name());
			sc.init(null, trustAllCerts, new java.security.SecureRandom());
			HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
			// Create all-trusting host name verifier
			final HostnameVerifier allHostsValid = new HostnameVerifier() {
				@Override
				public boolean verify(String hostname, SSLSession session) {
					return true;
				}
			};
			// Install the all-trusting host verifier
			HttpsURLConnection.setDefaultHostnameVerifier(allHostsValid);
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
		return true;
	}
}
