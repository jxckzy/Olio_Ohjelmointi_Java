public class Television {
    private int channel;
    private boolean isOn;

    public Television() {
        channel = 0; isOn = true;
    }

    public void setChannel(int channel){
        this.channel = channel;
    }

    public int getChannel(){
        return channel;
    }

    public boolean isOn() {
        return isOn;
    }

    public void pressOnOff() {
        this.isOn = !this.isOn;
    }
}

class TelevisionViewer {
    public static void main(String[] args) {
        Television myTV = new Television();
        myTV.setChannel(1);

        for (int day = 1; day <= 10; day++) {
            System.out.println("Woke up, day " + day);

            boolean tired = false;

            if (!myTV.isOn())
                myTV.pressOnOff();

            while (!tired) {
                System.out.println("Watching channel " + myTV.getChannel());
                myTV.setChannel((myTV.getChannel() % 10) + 1);
                if (myTV.getChannel() % 4 == 0)
                    tired = true;
            }

            myTV.pressOnOff();

            System.out.println("Falling asleep");
        }
    }
}