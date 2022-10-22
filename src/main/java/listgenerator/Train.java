package listgenerator;

import java.util.Collection;

public class Train {

private int id;
private Collection<Rack> racks;

    public Train(int id, Rack... racks){
        for (Rack rack : racks) {
            this.racks.add(rack);
        }

        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Collection<Rack> getRacks() {
        return racks;
    }
    
}
