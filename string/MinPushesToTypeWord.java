package a.string;
public class MinPushesToTypeWord {

    public static int minPushesToTypeWord(String dial, String word) {
        int totalPushes = 0;
        
      //  String dial = "abcdefghijklmnopqrstuvwxyz";
      //  String word = "cat";
        int currentPosition = dial.indexOf(word.charAt(0));

        for (int i = 1; i < word.length(); i++) {
            int targetPosition = dial.indexOf(word.charAt(i));

            int clockwiseDist = Math.abs(targetPosition - currentPosition);
            int counterclockwiseDist = dial.length() - clockwiseDist;

            totalPushes += Math.min(clockwiseDist, counterclockwiseDist);
            currentPosition = targetPosition;
        }

        return totalPushes;
    }

    public static void main(String[] args) {
        String dial = "abcdefghijklmnopqrstuvwxyz";
        String word = "cat";

        int result = minPushesToTypeWord(dial, word);
        System.out.println("Minimum pushes required: " + result);
    }
}