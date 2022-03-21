package com.dmiazga.budgetapp.categories;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Category {
	@Id
	@GeneratedValue
	private Long categoryid;
	private String username;
	private String categoryname;
	private String comment;
	private String hexcolor;
	
	public Category() {
	}

		public Category(long categoryid, 
				String username, 
				String categoryname,
				String comment,
				String hexcolor) {
		super();
		this.categoryid = categoryid;
		this.username = username;
		this.categoryname = categoryname;
		this.categoryname = comment;
		this.hexcolor = hexcolor;
	}

	public Long getId() {
		return categoryid;
	}

	public void setId(Long categoryid) {
		this.categoryid = categoryid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getHexcolor() {
		return hexcolor;
	}

	public void setHexcolor(String hexcolor) {
		this.hexcolor = hexcolor;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (categoryid ^ (categoryid >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Category other = (Category) obj;
		if (categoryid != other.categoryid)
			return false;
		return true;
	}
}