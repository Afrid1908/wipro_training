package day6;

interface MediaPlayer {
    default void play() {
        System.out.println("Playing music...");
    }
}

interface VoiceAssistant {
    default void play() {
        System.out.println("Playing voice response...");
    }
}

public class MultipleInheritance implements MediaPlayer, VoiceAssistant {

	 // Overriding the play method  to resolve the conflict
    @Override
    public void play() {
        System.out.println("Music player is playing a audio...");
        MediaPlayer.super.play();       
        VoiceAssistant.super.play();  
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MultipleInheritance m1 = new MultipleInheritance();
        m1.play();
	}

}
