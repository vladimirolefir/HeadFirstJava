public class JavaFeatures17 {

    public static void main(String[] args) {

        JavaFeatures17 jclass = new JavaFeatures17();
        jclass.diamondoperator();
        jclass.stringswitch();
        jclass.trywithres();
        jclass.numericliterals();
        jclass.exceptionhandling();
        jclass.workwithpaths();

        System.out.println("***");
        System.out.println("End");
    }

    // You don’t have to type the whole list of types for the instantiation. Instead you use the symbol, which is called diamond operator.
    public void diamondoperator() {
        System.out.println("*********");
        System.out.println("diamondoperator");
        Map<String, List<Trade>> trades = new TreeMap<String, List<Trade>>(); // OLD Style
        Map<String, List<Trade>> trades = new TreeMap<>(); // JAVA 1.7
    }

    public void stringswitch() {
        System.out.println("*********");
        System.out.println("stringswitch");

        String language = "C#";

        switch (language) {
            case "Java":
                System.out.println("Java: " + language);
                break;
            case "C#":
                System.out.println("C#: " + language);
                break;
            case "Swift":
                System.out.println("Swift: " + language);
                break;
            default:
                break;
        }
    }

    // Behind the scenes, the resources that should be auto closed must implement java.lang.AutoCloseable interface
    public void trywithres() {
        System.out.println("*********");
        System.out.println("trywithres");

        // OLD Style
        FileOutputStream fos;
        DataOutputStream dos;
        try {
            FileOutputStream fos = newFileOutputStream("movies.txt");
            DataOutputStream dos = new DataOutputStream(fos);
            dos.writeUTF("Java 7 Block Buster");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
                dos.close();
            } catch (IOException e) {
                // log the exception
            }
        }

        // JAVA 1.7
        try (FileOutputStream fos1 = newFileOutputStream("movies.txt"); DataOutputStream dos1 = newDataOutputStream(fos1)) {
            dos1.writeUTF("Java 7 Block Buster");
        } catch (IOException e) {
            // log the exception
        }
    }

    public void numericliterals() {
        System.out.println("*********");
        System.out.println("numericliterals");

        int thousand =  1_000;
        int million  =  1_000_000;
    }

    public void exceptionhandling() {
        System.out.println("*********");
        System.out.println("exceptionhandling");

        // OLD Style
        try{
            int i = 0;
        } catch(ExceptionOne e) {
            // log and deal with ExceptionOne
        } catch(ExceptionTwo e) {
            // log and deal with ExceptionTwo
        } catch(ExceptionThree e) {
            // log and deal with ExceptionThree
        }

        // JAVA 1.7
        try{
            int i = 0;
        } catch(ExceptionOne | ExceptionTwo | ExceptionThree e) {
            // log and deal with all Exceptions
        }
    }

    // there is a new pckage - java.nio.file - which is more advanced version of java.io.file
    public void workwithpaths() {
        System.out.println("*********");
        System.out.println("workwithpaths");

        Path path= Paths.get("c:\\Temp\\temp");
        System.out.println("Number of Nodes:"+ path.getNameCount());
        System.out.println("File Name:"+ path.getFileName());
        System.out.println("File Root:"+ path.getRoot());
        System.out.println("File Parent:"+ path.getParent());

        // File change notifications. The WatchService API lets you receive notification events upon changes to the subject (directory or file).

        // 1. Creating a WatchService object
        WatchService  watchService = FileSystems.getDefault().newWatchService();

        // 2. Obtain a path reference to your watchable directory. I suggest you parameterize this directory so you don’t hard code the file name.
        Path path2 = Paths.get("C:\\Temp\\temp\\");

        // 3. The next step is to register the directory with the WatchService for all types of events.
        path2.register(watchService, ENTRY_CREATE, ENTRY_MODIFY, ENTRY_DELETE);

        // 4. Initiate the infinite loop and start taking the events.
        while(true){
            WatchKey key = watchService.take(); // this would return you keys

            // 5. Run through the events on the key.
            for(WatchEvent<?> event : key.pollEvents()) {
                Kind<?> kind = event.kind();
                System.out.println("Event on "+ event.context().toString() + " is "+ kind);
            }
        }
    }
}