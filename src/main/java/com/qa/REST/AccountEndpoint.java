package com.qa.REST;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.qa.service.IAccountService;

@Path("/account")
public class AccountEndpoint {

	@Inject
	private IAccountService ac;

	@Path("/getAllAccounts")
	@GET
	@Produces({ "application/json" })
	public String getAllMovies() throws JsonProcessingException {
		return ac.getAllAccounts();
	}

	@Path("/getAnAccount/{id}")
	@GET
	@Produces({ "application/json" })
	public String getAnAccount(@PathParam("id") Long id) {
		return ac.getAccount(id).toString();
	}

	@Path("/createAccount")
	@POST
	@Produces({ "application/json" })
	public String addAccount(String account) {
		return ac.createAccount(account);
	}

	@Path("/deleteAccount/{id}")
	@DELETE
	@Produces({ "application/json" })
	public String deleteAccount(@PathParam("id") Long id) {
		return ac.deleteAccount(id);
	}

	@Path("/updateAccount/{id}")
	@PUT
	@Produces({ "application/json" })
	public String updateAccount(@PathParam("id") Long id, String acc) {
		return ac.updateAccount(id, acc);
	}

	public void setService(IAccountService accountService) {
		ac = accountService;
	}

}
