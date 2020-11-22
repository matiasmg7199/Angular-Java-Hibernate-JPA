package ttps.spring.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table (name="FoodTruckers")
public class FoodTrucker extends Usuario {
	
	@JsonIgnore
	@OneToMany(mappedBy="foodtrucker", cascade = CascadeType.ALL)
	private List<FoodTruck> foodTrucks = new ArrayList<FoodTruck>();
	
	public FoodTrucker(long id, List<FoodTruck> foodTrucks) {
		super();
		this.foodTrucks = foodTrucks;
	}

	public boolean addFoodTruck(FoodTruck f) {
		 foodTrucks.add(f);
		 return true;
	 }

	public List<FoodTruck> getFoodTrucks() {
		return foodTrucks;
	}

	public boolean removeFoodTruck(FoodTruck f) {
		 foodTrucks.remove(f);
		 return true;
	 }

	public FoodTrucker() {
		super();
	}
	
	public boolean soyFoodTrucker(){
		return true;
	}
	
}
