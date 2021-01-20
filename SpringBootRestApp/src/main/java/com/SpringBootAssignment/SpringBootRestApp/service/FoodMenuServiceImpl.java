package com.SpringBootAssignment.SpringBootRestApp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBootAssignment.SpringBootRestApp.dao.FoodMenuDao;
import com.SpringBootAssignment.SpringBootRestApp.entities.FoodMenu;

@Service
public class FoodMenuServiceImpl implements FoodMenuService {
	@Autowired
	private FoodMenuDao FMD;
	
//	List<FoodMenu> list;
	
	public FoodMenuServiceImpl()
	{
//		list=new ArrayList<FoodMenu>();
//		list.add(new FoodMenu(121,"Gulab Jamun","Sweet"));
//		list.add(new FoodMenu(122,"Rasmalai","Sweet"));
	}

	@Override
	public List<FoodMenu> getMenu() {
		return FMD.findAll();
	}

	@Override
	public FoodMenu getFood(int FoodID) {
		
//		FoodMenu fm=null;
//		for(FoodMenu foodmenu:list)
//		{
//			if(foodmenu.getId()==FoodID)
//			{
//				fm=foodmenu;
//				break;
//			}
//		}
		return FMD.getOne(FoodID);
	}

	@Override
	public FoodMenu addFood(FoodMenu foodmenu) {
//		list.add(foodmenu);
		FMD.save(foodmenu);
		return foodmenu;
	}

	@Override
	public void deleteFoodMenu(int parseint) {
//		list=this.list.stream().filter(e->e.getId()!=parseint).collect(Collectors.toList());
		FoodMenu entity=FMD.getOne(parseint);
		FMD.delete(entity);
	}

}
