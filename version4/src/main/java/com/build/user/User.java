package com.build.user;


	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
	import javax.persistence.Table;


	@Entity
	@Table( name = "users")
	public class User {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		public Integer Id;
		public String firstName;
		public String lastName;
		public String email;
		public String bio;

		public User() {
			
		}
		
		public User(String firstName, String lastName, String email, String bio) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.bio = bio;
			
		}
		
		public Integer getId() {
			return Id;
		}
		public void setId(Integer id) {
			this.Id = id;
		}
		public String getFirstName() {
			return firstName;
		}
		public String getLastName() {
			return lastName;
		}
		public String getEmail() {
			return email;
		}
		public String getBio() {
			return bio;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public void setBio(String bio) {
			this.bio = bio;
		}
		
		
	}

