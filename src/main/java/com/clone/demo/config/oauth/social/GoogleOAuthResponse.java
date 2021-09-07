package com.clone.demo.config.oauth.social;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GoogleOAuthResponse {

	private String accessToken;
	private String expiresIn;
	private String tokenType;
	private String scope;
	private String idToken;
	private String refreshToken;
}
