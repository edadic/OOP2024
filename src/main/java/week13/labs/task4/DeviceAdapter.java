package week13.labs.task4;

interface OldDevice {
    void operateOldFunction();
}

interface NewDevice {
    void operateNewFunction();
}

class OldDeviceImpl implements OldDevice {
    @Override
    public void operateOldFunction() {
        System.out.println("Operating old device function...");
    }
}

class NewDeviceImpl implements NewDevice {
    @Override
    public void operateNewFunction() {
        System.out.println("Operating new device function...");
    }
}

class DeviceAdapter implements NewDevice {
    private final OldDevice oldDevice;

    public DeviceAdapter(OldDevice oldDevice) {
        this.oldDevice = oldDevice;
    }

    @Override
    public void operateNewFunction() {
        oldDevice.operateOldFunction();
    }
}

class Main {
    public static void main(String[] args) {
        OldDevice oldDevice = new OldDeviceImpl();
        NewDevice newDevice = new DeviceAdapter(oldDevice);

        newDevice.operateNewFunction();
    }
}
