package com.mss.auth.jwt;

import lombok.Getter;
import java.io.Serializable;

@Getter
public class JwtResponse implements Serializable {

	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;
	private  final String user;

	public JwtResponse(String user, String jwttoken) {
		this.user = user;
		this.jwttoken = jwttoken;
	}
}