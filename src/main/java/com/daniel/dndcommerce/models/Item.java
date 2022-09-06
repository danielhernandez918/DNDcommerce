package com.daniel.dndcommerce.models;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="items")
public class Item {
	
	//Attributes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull(message="Name is required")
    @Size(min = 2, max = 200, message="Name must be at least 2 characters")
    private String name;
    
    @NotNull(message="Image url is required")
    @Size(min = 2, max = 256, message="Image needs to be url")
    private String image;
    
    @NotNull(message="Pice is required")
    @Min(value=0, message="Price must be positive")
    private BigDecimal price;
    
    @NotNull(message="Stock qty is required")
    @Min(value=0, message="Stock must be positive")
    private Integer stock;
   
    @NotNull(message="Manufacturer is required")
    @Size(min = 2, max = 200, message="Manufacturer must be at least 2 characters")
    private String manufacturer;
    
    @NotNull(message="Product# is required")
    @Size(min = 2, max = 200, message="Product# must be at least 2 characters")
    private String product;
    
    @NotNull(message="Universe is required")
    @Size(min = 2, max = 200, message="Universe must be at least 2 characters")
    private String universe;
    
    @NotNull(message="Set is required")
    @Size(min = 2, max = 200, message="Number be at least 2 characters")
    private String setName;
    
    @NotNull(message="Number is required")
    @Size(min = 2, max = 200, message="Number be at least 1 characters")
    private String setNumber;
    
    @NotNull(message="Rarity is required")
    @Size(min = 2, max = 200, message="Rarity must be at least 1 characters")
    private String rarity;
    
    @NotNull(message="Base size is required")
    @Size(min = 2, max = 200, message="Base size must be at least 1 characters")
    private String base;
    
    @NotNull(message="Height is required")
    @Size(min = 2, max = 200, message="Height must be at least 1 characters")
    private String height;
    
    //Many to one relationship
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category group;


   
    
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
	@PrePersist
	protected void onCreate() {
		this.createdAt = new Date();
	}
	@PreUpdate
	protected void onUpdate() {
		this.updatedAt = new Date();
	}
    
    //Constructors
    public Item() {
        
    }
    
    public Item(String name, String image, BigDecimal price, Integer stock, String manufacturer, 
    		String product, String universe, String setName, String setNumber, String rarity, String base, String height, Category group) {
    	this.name = name;
    	this.image = image; 
    	this.price = price;
    	this.stock = stock;
    	this.manufacturer = manufacturer;
    	this.product = product;
    	this.universe= universe;
    	this.setName = setName;
    	this.setNumber = setNumber;
    	this.rarity = rarity;
    	this.base = base;
    	this.height = height;
    	this.group = group;
 
    	
    }
    
    //Getters
	public Long getId() {
		return id;
	}
	public String getName() {
		return name;

	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public BigDecimal getPrice() {
		return price;
	}
	public Integer getStock() {
		return stock;
	}
	public String getImage() {
		return image;
	}

	//Setters
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public void setImage(String image) {
		this.image = image;
	}

	
	//new
	
	public String getManufacturer() {
		return manufacturer;
	}
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public String getUniverse() {
		return universe;
	}
	public void setUniverse(String universe) {
		this.universe = universe;
	}
	public String getSetName() {
		return setName;
	}
	public void setSetName(String setName) {
		this.setName = setName;
	}
	public String getSetNumber() {
		return setNumber;
	}
	public void setSetNumber(String setNumber) {
		this.setNumber = setNumber;
	}
	public String getRarity() {
		return rarity;
	}
	public void setRarity(String rarity) {
		this.rarity = rarity;
	}
	public String getBase() {
		return base;
	}
	public void setBase(String base) {
		this.base = base;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public Category getGroup() {
		return group;
	}
	public void setGroup(Category group) {
		this.group = group;
	}

	
	
	
}
