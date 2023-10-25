package bean;

public class Admin {

	
		private int  login_id;
		private String user_name;
		private String password;
		private String role;
		private int  status;
		
		//Setter & Getter 
		public int getLogin_id() {
			return login_id;
		}
		
		public void setLogin_id(int login_id) {
			this.login_id = login_id;
		}
		public String getUser_name() {
			return user_name;
		}
		public void setUser_name(String user_name) {
			this.user_name = user_name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}
		
	
		@Override
		public String toString() {
			return "Admin [login_id=" + login_id + ", user_name=" + user_name + ", password=" + password + ", role="
					+ role + ", status=" + status + "]";
		}
		
		
		
	}


