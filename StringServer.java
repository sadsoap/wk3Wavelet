import java.io.IOException;
import java.net.URI;

class Handler implements URLHandler {
    // Values that will be changed based on input:
  
    // String value that will hold the text being displayed.
    String sCurrent = "[Intentionally blank for testing]"; //Delete this before submission
    
    // Number that increments with each string added.
    int iNum = 0;

    public String handleRequest(URI url) {
        if (url.getPath().equals("/")) {
          // Default; What user sees at index.
            return sCurrent;
          
        } else {
            if (url.getPath().contains("/add-message")) {
                String[] parameters = url.getQuery().split("=");
                if (parameters[0].equals("s")) {
                    iNum++;
                    sCurrent += ( "\n" + iNum + parameters[1] );
                    return sCurrent;
                  
                }
            }
            return "404 Not Found!";
        }
    }
}

class StringServer {
    public static void main(String[] args) throws IOException {
        if(args.length == 0){
            System.out.println("Missing port number! Try any number between 1024 to 49151");
            return;
        }

        int port = Integer.parseInt(args[0]);

        Server.start(port, new Handler());
    }
}
