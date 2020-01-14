package com.m150.backend.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.m150.backend.db.MySqlDB;
import com.m150.backend.model.Bestellung;
import com.m150.backend.model.Chips;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api(value = "BackendController", description = "Backend for Chips Webshop")
@RestController
public class BackendController {

	Connection conn = MySqlDB.getConnection();
	List<Bestellung> best = new ArrayList<Bestellung>();

	@ApiOperation(httpMethod = "GET", value = "Get list of Chips in the System ", response = Iterable.class, tags = "getAllChips")
	@RequestMapping(value = "/getAllChips")
	public List<Chips> getAllChips() {
		List<Chips> chips = new ArrayList<Chips>();
		String query = "SELECT name, desc, price FROM chips";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Chips c = new Chips();
				c.setName(rs.getString("name"));
				c.setDesc(rs.getString("desc"));
				c.setPrice(rs.getDouble("price"));
				chips.add(c);
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return chips;
	}

	@ApiOperation(httpMethod = "POST", value = "Create new Order ", response = Bestellung.class, tags = "createBestellung")
	@RequestMapping(value = "/createBestellung/")
	public void createBestellung(@ApiParam(value = "New Order to add", required = true) Bestellung bestellung) {
		String query = "INSERT INTO bestellung (chips, total) VALUES (?,?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, bestellung.getChips());
			ps.setDouble(2, bestellung.getTotal());
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
