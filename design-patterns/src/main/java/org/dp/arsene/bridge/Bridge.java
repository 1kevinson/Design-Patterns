package org.dp.arsene.bridge;

public class Bridge {

    public static void main(String... args) {
        final Device tv = new Television();
        final RemoteControl remoteControl = new RemoteControl(tv);

        remoteControl.togglePower();

        final Device radio = new Radio();
        final AdvanceRemoteControl advanceRemoteControl = new AdvanceRemoteControl(radio);

        advanceRemoteControl.muteVolume();
    }
}


// STEP 1 - Define the abstraction
class RemoteControl {

    protected final Device device;

    RemoteControl(Device device) {
        this.device = device;
    }

    void togglePower(){
        if (device.isEnabled())
            device.enable();
        else
            device.disable();
    }

    void volumeDown(){
        device.setVolume(device.getVolume() - 10);
    }

    void volumeUp(){
        device.setVolume(device.getVolume() + 10);
    }

    void channelDown(){
       device.setChannel(device.getChannel() - 1);
    }

    void channelUp(){
        device.setChannel(device.getChannel() + 1);
    }
}

class AdvanceRemoteControl extends RemoteControl {

    AdvanceRemoteControl(Device device) {
        super(device);
    }

    void muteVolume(){
        device.setVolume(0);
    }
}

// STEP 2 - Define the Implementation
interface Device {

   boolean isEnabled();

   void enable();

   void disable();

   int getVolume();

   int setVolume(int percentage);

   int getChannel();

   int setChannel(int channelNumber);
}


class Radio implements Device{

    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void enable() {

    }

    @Override
    public void disable() {

    }

    @Override
    public int getVolume() {
        return 0;
    }

    @Override
    public int setVolume(int percentage) {
        return 0;
    }

    @Override
    public int getChannel() {
        return 0;
    }

    @Override
    public int setChannel(int channelNumber) {
        return 0;
    }
}

class Television implements Device{
    @Override
    public boolean isEnabled() {
        return false;
    }

    @Override
    public void enable() {

    }

    @Override
    public void disable() {

    }

    @Override
    public int getVolume() {
        return 0;
    }

    @Override
    public int setVolume(int percentage) {
        return 0;
    }

    @Override
    public int getChannel() {
        return 0;
    }

    @Override
    public int setChannel(int channelNumber) {
        return 0;
    }
}