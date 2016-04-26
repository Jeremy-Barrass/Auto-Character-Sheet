import javax.sound.midi.*;

public class MiniMiniMusicApp6 {

    public static void main(String[] args) {

        MiniMiniMusicApp6 mini = new MiniMiniMusicApp6();

        mini.play();

    }

    public void play() {

        try {

            Sequencer player = MidiSystem.getSequencer();

            //System.out.println("We have a Sequencer");

            player.open();

            //System.out.println("The player is open");

            Sequence seq = new Sequence(Sequence.PPQ, 4);

            //System.out.println("We have a Sequence");

            Track track = seq.createTrack();

            //System.out.println("We have a track");

            ShortMessage a = new ShortMessage();

            //System.out.println("We have a Midi Message");

            ShortMessage first = new ShortMessage();

            //System.out.println("We have a Midi Message");

            first.setMessage(192, 1, 102, 0);

            //System.out.println("The message is set");

            MidiEvent noteChange = new MidiEvent(first, 1);

            //System.out.println("We have a Midi Event");

            track.add(noteChange);

            //System.out.println("The Event is on the Track");

            a.setMessage(144, 1, 57, 100);

            //System.out.println("The message is set");

            MidiEvent noteOn = new MidiEvent(a, 1);

            //System.out.println("We have a Midi Event");

            track.add(noteOn);

            //System.out.println("The Event is on the Track");

            ShortMessage c = new ShortMessage();

            //System.out.println("We have a Midi Message");

            c.setMessage(128, 1, 57, 100);

            //System.out.println("The message is set");

            MidiEvent noteOff = new MidiEvent(c, 64);

            //System.out.println("We have a Midi Event");

            track.add(noteOff);

            //System.out.println("The Event is on the Track");

            player.setSequence(seq);

            //System.out.println("The Sequence is set");

            player.start();

            //System.out.println("The player is started");

            while(player.getTickLength() > player.getTickPosition()) { 

                Thread.sleep(player.getTickLength());

            }

            player.stop();

            player.close();

            //System.out.println("The player is closed");

        } catch (Exception ex) {

            ex.printStackTrace();

        }

    }

}
