/*
CREATE EXECUTABLE JAR:
1. Make sure all of your class files are in the classes directory
2. Create a manifest.txt file that states which class has the main() method. Main-Class: MyApp
3. Run the jar tool to create a JAR file that contains everything in the classes directory, plus the manifest. (jar -cvmf manifest.txt app1.jar *.class)
4. Run jar: java -jar app1.jar
* */
public class MyApp {
    public static void main(String[] args) {
        System.out.println("I Rule!");
        System.out.println("The World");
    }
}