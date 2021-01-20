package com.SpringBootAssignment.SpringBootRestApp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBootAssignment.SpringBootRestApp.entities.FoodMenu;
import com.SpringBootAssignment.SpringBootRestApp.service.FoodMenuService;

@RestController
public class MyController {
	
	@Autowired
	private FoodMenuService FMS;
	
	@GetMapping("/home")
	public String home()
	{
		return "this is home page";
	}
	
	//get the food menus
	@GetMapping("/FoodMenu")
	public List<FoodMenu> getMenu()
	{
		return this.FMS.getMenu();
	}
	
	@GetMapping("/FoodMenu/{FoodID}")
	public FoodMenu getFood(@PathVariable String FoodID)
	{
		return this.FMS.getFood(Integer.parseInt(FoodID));
	}
	
	@PostMapping("/FoodMenu")
	public FoodMenu addFood(@RequestBody FoodMenu foodmenu)
	{
		return this.FMS.addFood(foodmenu);
	}
	
	@DeleteMapping("/FoodMenu/{FoodID}")
	public ResponseEntity<HttpStatus> deleteFoodMenu(@PathVariable String FoodID)
	{
		try
		{
			this.FMS.deleteFoodMenu(Integer.parseInt(FoodID));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
