package game;

import java.io.Serializable;

//박수정
public class Data implements Serializable {
	   String name;
	   int health;
	   int money;
	   int skill;
	   int day;
	   int when;
	   int[] item;
	   
	   Data(String name, int health, int money, int skill, int day, int when,int[]item){
	      this.name = name;
	      this.health = health;
	      this.money = money;
	      this.skill = skill;
	      this.day = day;
	      this.when = when;
	      this.item = item;
	 
	   }
	}
