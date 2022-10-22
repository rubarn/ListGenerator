package listgenerator;

public class Machine {

private Boolean offline;
private Boolean zeroHash;
private Boolean abnormalFans;
private int id;



    public Machine(int id, Boolean offline, Boolean zeroHash, Boolean abnormalFans){
        this.offline = offline;
        this.zeroHash = zeroHash;
        this.abnormalFans = abnormalFans;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Boolean isAbnormalFans() {
        return abnormalFans;
    }

    public Boolean isOffline() {
        return offline;
    }

    public Boolean isZeroHash() {
        return zeroHash;
    }
    
}
