import java.util.ArrayList;
public class Vigenere {
    String word;
    ArrayList<Character> listify;
    public Vigenere(String word){
        this.word = word;
        ArrayList<Character> charsList = new ArrayList<>(word.length());
        for (int i = 0; i < word.length(); i++) {
            charsList.add(word.charAt(i));
        }
        this.listify = charsList;
    }

    public String encipher(String key){
        StringBuilder shifted = new StringBuilder();
        ArrayList<Character> keyListify = new ArrayList<>(key.length());
        for (int i = 0; i < key.length(); i++) {
            keyListify.add(key.charAt(i));
        }
        int i = 0;
        ArrayList<Character> alphabet = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphabet.add(c);
        }
        for(Character c : listify){
            if(!Character.isLetter(c)){
                shifted.append(c);
                continue;
            }
            if(i > keyListify.size()-1){
                i = 0;
            }
            int shift = Character.toLowerCase(c) - 'a';
            ArrayList<Character> shiftedAlphabet = new ArrayList();
            for(int j = shift; j<alphabet.size(); j++){
                shiftedAlphabet.add(alphabet.get(j));
            }
            for(int k = 0; k<shift; k++){
                shiftedAlphabet.add(alphabet.get(k));
            }
            int index = Character.toLowerCase(keyListify.get(i)) - 'a';
            shifted.append(shiftedAlphabet.get(index));
            i++;
        }
        return shifted.toString();
    }

    public String decipher(String cipher, String key){
        StringBuilder shifted = new StringBuilder();
        ArrayList<Character> keyListify = new ArrayList<>(key.length());
        for (int i = 0; i < key.length(); i++) {
            keyListify.add(key.charAt(i));
        }
        int i = 0;
        ArrayList<Character> alphabet = new ArrayList<>();
        for (char c = 'a'; c <= 'z'; c++) {
            alphabet.add(c);
        }
        ArrayList<Character> cipherList = new ArrayList<>(cipher.length());
        for (int k = 0; k < cipher.length(); k++) {
            cipherList.add(cipher.charAt(k));
        }
        for(Character c : cipherList){
            if(!Character.isLetter(c)){
                shifted.append(c);
                continue;
            }
            if(i > keyListify.size()-1){
                i = 0;
            }
            int keyNum = Character.toLowerCase(keyListify.get(i)) - 'a';
            int cNum = Character.toLowerCase(c) - 'a';
            int difference = (cNum - keyNum + 26) % 26;
            shifted.append(alphabet.get(difference));
            i++;
        }
        return shifted.toString();
    }

    public static void main(String[] args){
        Vigenere word = new Vigenere("hello# world1");
        System.out.println(word.word);
        System.out.println(word.encipher("hello"));
        System.out.println(word.decipher("oiwwc# dscwr1","hello"));
    }
}
