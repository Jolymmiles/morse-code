import java.util.HashMap;
import java.util.Map;

public class Log {
    private final Map<Character, String> alp = new HashMap<>();
    private final TwoQueuesCache<String, String> twoQueuesCache = new TwoQueuesCache<>(100);

    public Log() {
        alp.put('А', ".-");
        alp.put('Б', "-...");
        alp.put('В', ".--");
        alp.put('Г', "--.");
        alp.put('Д', "-..");
        alp.put('Е', ".");
        alp.put('Ж', "...-");
        alp.put('З', "--..");
        alp.put('И', "..");
        alp.put('Й', ".---");
        alp.put('К', "-.-");
        alp.put('Л', ".-..");
        alp.put('М', "--");
        alp.put('Н', "-.");
        alp.put('О', "---");
        alp.put('П', ".--.");
        alp.put('Р', ".-.");
        alp.put('С', "...");
        alp.put('Т', "-");
        alp.put('У', "..-");
        alp.put('Ф', "..-.");
        alp.put('Х', "....");
        alp.put('Ц', "-.-.");
        alp.put('Ч', "---.");
        alp.put('Ш', "----");
        alp.put('Щ', "--.-");
        alp.put('Ъ', ".--.-.");
        alp.put('Ы', "-.--");
        alp.put('Ь', "-..-");
        alp.put('Э', "...-...");
        alp.put('Ю', "..--");
        alp.put('Я', ".-.-");
    }

    public String getCrypt(String s) {
        StringBuilder newStr = new StringBuilder();
        String[] sArray = s.split(" ");
        for (String tempS : sArray) {
            if (twoQueuesCache.get(tempS) != null) {
                newStr.append(twoQueuesCache.get(tempS));
            } else {
                if (tempS.contains(",") | tempS.contains(".")) {
                    tempS = tempS.substring(0, tempS.length() - 1);
                }
                String tempWord = makeWordCrypt(tempS);
                newStr.append(tempWord);
                twoQueuesCache.put(tempS, tempWord);
            }
            newStr.append(" ");
        }
        return newStr.toString();
    }

    private String makeWordCrypt(String s) {
        StringBuilder newStr = new StringBuilder();
        for (char c : s.toCharArray()) {
            newStr.append(alp.getOrDefault(Character.toUpperCase(c), String.valueOf(c)));
        }
        return newStr.toString();
    }
}
