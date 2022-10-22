package listgenerator;

import java.util.Collection;

public class List {

    private Collection<String> ip;
    private Collection<Collection<String>> ipList;

    public List(String... ips){
        for (String string : ips) {
            ip.add(string);
        }
    }


    
}
