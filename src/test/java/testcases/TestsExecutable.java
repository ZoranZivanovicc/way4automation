package testcases;

import java.io.IOException;

public class TestsExecutable {
    public static void main(String[] args) throws IOException {
        DriverManager driver = new DriverManager("chrome","http://icicibank.com");
        Keywords keywords = new Keywords();
        //keywords.sendText("email_ID","zoran.v.zivanovic" );
        keywords.clickIt("//*[@id='footer_links']/a[1]");
        //keywords.clickIt("nextButton_ID");
        //keywords.sendText("password_NAME","testiranje");
        keywords.switchTabs("1");
    }
}
