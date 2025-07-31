package userAuthentication;

import java.util.LinkedList;
import java.util.Scanner;

class User{
	private String username;
	private String password;
	
	public User(String username, String password) {
		this.username=username;
		this.password=password;
	}
	public User() {
		super();
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername() {
		this.username=username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword() {
		this.password=password;
	}
	
	public String toString() {
		return username+" "+password;
	}
}
public class UserAuthentication {
	private LinkedList<User>userList;
	public UserAuthentication() {
		userList = new LinkedList<>();
	}
	
	public void register(String username,String password) {
		User newUser = new User(username, password);
		userList.add(newUser);
		System.out.println("User Registred successfully");
		
	}
	
	public boolean login(String username, String password) {
		for(User user : userList) {
			if(user.getUsername().equals(username) && user.getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		UserAuthentication auth = new UserAuthentication();
		Scanner sc = new Scanner(System.in);
		
		boolean loggedIn=false;
		while(!loggedIn) {
			System.out.println("Choose an Option");
			System.out.println("1. Register user");
			System.out.println("2. Login");
			System.out.println("3. Exit");
			
			int choice = sc.nextInt();
			sc.nextLine();
			
			switch(choice) {
			case 1:
				System.out.println("Enter a username: ");
				String regUsername = sc.nextLine();
				System.out.println("Enter a password: ");
				String regPassword = sc.nextLine();
				auth.register(regUsername, regPassword);
				break;
				
			case 2:
				System.out.println("Enter your username login: ");
				String loginUsername = sc.nextLine();
				System.out.println("Enter your password login: ");
				String loginPassword = sc.nextLine();
				auth.login(loginUsername, loginPassword);
				if(auth.login(loginUsername, loginPassword)) {
					System.out.println("Login Successfully....");
					loggedIn = true;
				}else {
					System.out.println("Login failed!!!");
				}
				break;
				
			case 3:
				System.out.println("Exiting....");
				loggedIn = true;
				break;
			default:
				System.out.println("Invalid choice, Please try again...");
			}
			
		}
	}
}
