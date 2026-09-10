import java.util.ArrayList;

interface Connectable {
    void Connect();
    void Disconnect();
}

interface Switchable {
    void TurnOn();
    void TurnOff();
}

interface Lockable {
    void Lock();
    void Unlock();
}

abstract class SmartDevice {
    String id;
    String nama;
    double daya;
    String status;

    public SmartDevice(String id, String nama, double daya, String status) {
        this.id = id;
        this.nama = nama;
        this.daya = daya;
        this.status = status;
    }

    public abstract String getDeviceDetails();
}

class SmartTV extends SmartDevice implements Switchable, Connectable {
    int channel;
    int volume;
    String koneksi;

    public SmartTV(String id, String nama, double daya, int channel, int volume, String status) {
        super(id, nama, daya, status);
        this.channel = channel;
        this.volume = volume;
        this.koneksi = "-";
    }

    @Override
    public void TurnOn() {
        status = "On";
    }

    @Override
    public void TurnOff() {
        status = "Off";
    }

    @Override
    public void Connect() {
        koneksi = "wipi";
    }

    @Override
    public void Disconnect() {
        koneksi = "-";
    }

    @Override
    public String getDeviceDetails() {
        return "Smart TV [" + nama + "] (ID: " + id + ") Daya: " + daya + "W | Status: " + status + " | Koneksi: " + koneksi + " | Channel: " + channel + " | Volume: " + volume;
    }
}

class SmartSpeaker extends SmartDevice implements Switchable, Connectable {
    int volume;
    String koneksi;

    public SmartSpeaker(String id, String nama, double daya, int volume, String status) {
        super(id, nama, daya, status);
        this.volume = volume;
        this.koneksi = "-";
    }

    @Override
    public void TurnOn() {
        status = "On";
    }

    @Override
    public void TurnOff() {
        status = "Off";
    }

    @Override
    public void Connect() {
        koneksi = "blutut";
    }

    @Override
    public void Disconnect() {
        koneksi = "-";
    }

    @Override
    public String getDeviceDetails() {
        return "Smart Speaker [" + nama + "] (ID: " + id + ") Daya: " + daya + "W | Status: " + status + " | Koneksi: " + koneksi + " | Volume: " + volume;
    }
}

class SmartDoorLock extends SmartDevice implements Lockable {
    int pin;

    public SmartDoorLock(String id, String nama, double daya, int pin, String status) {
        super(id, nama, daya, status);
        this.pin = pin;
    }

    @Override
    public void Lock() {
        status = "Ke kunci";
    }

    @Override
    public void Unlock() {
        status = "Ndak kekunci mas";
    }

    @Override
    public String getDeviceDetails() {
        return "Smart Door [" + nama + "] (ID: " + id + ") Daya: " + daya + "W | Status: " + status+ " | PIN: ****";
    }
}

public class SmartHome {
    public static void main(String[] args) {

        ArrayList<SmartDevice> devices = new ArrayList<>();

        SmartTV tv1 = new SmartTV("TV-jawa","TV jawa",120,5,20,"Off");
        tv1.TurnOn();
        tv1.Connect();
        devices.add(tv1);

        SmartSpeaker sp1 = new SmartSpeaker("SP-batam","Batam Studio",30,15,"Off");
        sp1.TurnOn();
        sp1.Connect();
        devices.add(sp1);

        SmartDoorLock dl1 = new SmartDoorLock("DL-medan","Pintu depan",15,7777,"Ndak kekunci");
        dl1.Lock();
        devices.add(dl1);

        System.out.println("Daftar: ");

        for (SmartDevice d : devices) {
            System.out.println(d.getDeviceDetails());
        }
    }
}