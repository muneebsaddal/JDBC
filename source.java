import java.sql.*;
import java.util.Scanner;

public class lab7JDBC {
	public static void main(String args[]) {
		try {
			Scanner input = new Scanner(System.in);
			Class.forName("com.mysql.jdbc.Driver");
			String URL = "jdbc:mysql://127.0.0.1:8080/name";
			Connection conn = DriverManager.getConnection(URL,"root","");
			Statement stmt = conn.createStatement();
			int decision;
			String repeat = "y";
			System.out.println("Enter choice -->  1.View Data  2.Insert Data  3.Delete  4.Update");
			decision = input.nextInt();
			switch(decision) {
			case 2:
				boolean rs1 = stmt.execute("INSERT INTO feeslip  VALUES ('abc','def','12367','mar','monday')");
				break;
			case 3:
				boolean rs2 = stmt.execute("DELETE FROM feeslip WHERE fname = 'abc'");
				break;
			case 4:
				boolean rs3 = stmt.execute("UPDATE feeslip SET fname = 'ghi', sname = 'jkl' WHERE regnumber = '135404'");
				break;
			}
			ResultSet rs0 = stmt.executeQuery("SELECT * FROM feeslip");
			while(rs0.next()) {
				System.out.print(rs0.getString(1) + " | ");
				System.out.print(rs0.getString(2) + " | ");
				System.out.print(rs0.getString(3) + " | ");
				System.out.print(rs0.getString(4) + " | ");
				System.out.println(rs0.getString(5));
			}
			rs0.close();
			stmt.close();
			conn.close();
		}catch(SQLException se) {
			System.out.println("SQL Exception: ");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
}
