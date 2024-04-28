public class Test {
    public static void main(String[] args) {
        String input = "The quick brown fox jumps over the lazy dog";

        int n = 10;
        for (int i = 0; i <= input.length() - n - 1; i++) {
            String history = input.substring(i, n + i);
            Character nextCharacter = input.charAt(n + i);

            System.out.println(history + " next " + nextCharacter);
        }
    }

}
