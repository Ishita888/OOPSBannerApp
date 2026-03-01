/**
 * OOPSBannerApp UC7 – Store Character Pattern in a Class
 * This use case stores character and pattern together using an inner class.
 */

public class OOPSBannerApp {

    /**
     * Inner Static Class to store character and its pattern
     */
    static class CharacterPatternMap {
        private char character;
        private String[] pattern;

        // Constructor
        public CharacterPatternMap(char character, String[] pattern) {
            this.character = character;
            this.pattern = pattern;
        }

        // Getter for character
        public char getCharacter() {
            return character;
        }

        // Getter for pattern
        public String[] getPattern() {
            return pattern;
        }
    }

    // Create array of CharacterPatternMap objects
    public static CharacterPatternMap[] createCharacterPatternMaps() {

        CharacterPatternMap[] maps = new CharacterPatternMap[4];

        maps[0] = new CharacterPatternMap('O', new String[]{
                "  ***  ",
                " *   * ",
                "*     *",
                "*     *",
                "*     *",
                " *   * ",
                "  ***  "
        });

        maps[1] = new CharacterPatternMap('P', new String[]{
                " ****  ",
                "*    * ",
                "*    * ",
                " ****  ",
                "*      ",
                "*      ",
                "*      "
        });

        maps[2] = new CharacterPatternMap('S', new String[]{
                "  *****",
                " *     ",
                " *     ",
                "  *****",
                "      *",
                "      *",
                " ***** "
        });

        maps[3] = new CharacterPatternMap(' ', new String[]{
                "       ",
                "       ",
                "       ",
                "       ",
                "       ",
                "       ",
                "       "
        });

        return maps;
    }

    // Get pattern for a given character
    public static String[] getCharacterPattern(char ch, CharacterPatternMap[] maps) {
        for (CharacterPatternMap map : maps) {
            if (map.getCharacter() == ch) {
                return map.getPattern();
            }
        }
        return maps[3].getPattern(); // return space if not found
    }

    // Print message as banner
    public static void printMessage(String message, CharacterPatternMap[] maps) {

        for (int i = 0; i < 7; i++) {

            StringBuilder line = new StringBuilder();

            for (char ch : message.toCharArray()) {
                String[] pattern = getCharacterPattern(ch, maps);
                line.append(pattern[i]).append("  ");
            }

            System.out.println(line);
        }
    }

    // Main Method
    public static void main(String[] args) {

        CharacterPatternMap[] maps = createCharacterPatternMaps();

        String message = "OOPS";

        printMessage(message, maps);
    }
}