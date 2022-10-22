package listgenerator;

import java.util.Collection;

public class Rack {
    

private int id;
private Collection<Machine> machines;

    public Rack(int id, Machine... machines){
        for (Machine machine : machines) {
            this.machines.add(machine);
        }
        
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Collection<Machine> getMachines() {
        return machines;
    }
}
