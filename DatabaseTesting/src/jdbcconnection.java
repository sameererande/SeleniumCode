import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.mysql.cj.jdbc.JdbcStatement;

public class jdbcconnection {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		String host="127.0.0.1";
		String port="3306";

		Connection con=DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/qadbt","root", "Foot");
		//Connection url is stricky part
		// "jdbc:mysql://"+host+":"+port+"/databasename";
		Statement s=con.createStatement();   //Create path
		ResultSet rs=s.executeQuery("select * from credentials where scenerio='rewardcard'");
		while(rs.next()) //move pointer from base index to first index
		{
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\samee\\Grid\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			
			driver.get("https://login.salesforce.com/?locale=in");
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(rs.getString("username"));
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(rs.getString("password"));
		
		
	}
	}
	

}
