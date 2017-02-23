2)
 a.
 	A singleton can be useful if you only want one instance of a class available in the application. For example a database connection.
 	You might only want to have one open connection to the database at any one time. You would need to make this instance available to the
 	application. For example it could look something like this:
 	
 	```
 	class DatabaseConnection () {
 	
 		private DatabaseConnector databaseContector;
 		
 		public static DatabaseConnector getConnection() {
 		
 			if (this.databaseContector == null) {
 				this.databaseContector = new DatabaseConnector();
 			}
 			
 			return this.databaseContector;
 		}
 	}
 	```