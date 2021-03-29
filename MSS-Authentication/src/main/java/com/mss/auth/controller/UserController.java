package com.mss.auth.controller;

import com.mss.auth.config.JwtTokenUtil;
import com.mss.auth.jwt.JwtRequest;
import com.mss.auth.jwt.JwtResponse;
import com.mss.auth.jwt.JwtUserDetailsService;
import com.mss.auth.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private JwtUserDetailsService userDetailsService;

	@GetMapping("/done")
	public String add(Model model) {
		model.addAttribute("jwtRequest", new JwtRequest());
		return "login";
	}

	@PostMapping("/done")
	public ModelAndView createAuthenticationToken(@ModelAttribute("jwtRequest") JwtRequest jwtRequest) throws Exception {

		authenticate(jwtRequest.getUsername(), jwtRequest.getPassword());

		final UserDetails userDetails = userDetailsService.loadUserByUsername(jwtRequest.getUsername());

		final String token = jwtTokenUtil.generateToken(userDetails);

		JwtResponse response = new JwtResponse(userDetails.getUsername(), token);
		ModelAndView view = new ModelAndView("register_success");
		view.addObject("response", response);

		return view;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ResponseEntity<?> saveUser(@RequestBody User user) throws Exception {
		return ResponseEntity.ok(userDetailsService.save(user));
	}

	private void authenticate(String username, String password) throws Exception {
		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}
}
