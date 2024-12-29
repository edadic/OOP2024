package week13.labs.task3;

interface TextFormatter {
    String formatText(String text);
}

class UpperCaseFormatter implements TextFormatter {
    @Override
    public String formatText(String text) {
        return text.toUpperCase();
    }
}

class LowerCaseFormatter implements TextFormatter {
    @Override
    public String formatText(String text) {
        return text.toLowerCase();
    }
}

class CamelCaseFormatter implements TextFormatter {
    @Override
    public String formatText(String text) {
        String[] words = text.split(" ");
        StringBuilder camelCaseText = new StringBuilder();
        for (String word : words) {
            camelCaseText.append(Character.toUpperCase(word.charAt(0)))
                    .append(word.substring(1).toLowerCase());
        }
        return camelCaseText.toString();
    }
}

class TextEditor {
    private TextFormatter formatter;

    public void setFormatter(TextFormatter formatter) {
        this.formatter = formatter;
    }

    public String formatText(String text) {
        return formatter.formatText(text);
    }
}

public class TextFormater {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.setFormatter(new UpperCaseFormatter());
        System.out.println(editor.formatText("hello world"));

        editor.setFormatter(new LowerCaseFormatter());
        System.out.println(editor.formatText("HELLO WORLD"));

        editor.setFormatter(new CamelCaseFormatter());
        System.out.println(editor.formatText("hello world"));
    }
}
