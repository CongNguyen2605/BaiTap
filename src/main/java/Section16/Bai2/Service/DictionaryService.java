package Section16.Bai2.Service;

import Section16.Bai2.Model.Dictionary;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class DictionaryService {
    public Map<String , Dictionary> input(){
        Scanner scanner = new Scanner(System.in);
        Map<String , Dictionary> stringDictionaryMap = new HashMap<>();
        while (true){

            Dictionary dictionary = new Dictionary();
            System.out.println("nhap key");
            String a = scanner.next();
            dictionary.setKeyWord(a);
            if(a.equalsIgnoreCase("exit") ) break;
            System.out.println("nhap setDescription");
            dictionary.setDescription(scanner.next());
            System.out.println("nhap setWordType");
            dictionary.setWordType(scanner.next());
            stringDictionaryMap.put(dictionary.getKeyWord(), dictionary);
        }
        return stringDictionaryMap;
    }
    public void infor(Map<String, Dictionary> dictionaryMap){
        for (Dictionary dictionary : dictionaryMap.values()){
            System.out.println(dictionary.getKeyWord() + "-" + dictionary.getDescription() + "-" + dictionary.getWordType());
        }
    }
    public void filter(Map<String , Dictionary> dictionaryMap){
        Scanner scanner = new Scanner(System.in);
        System.out.println("nhap key");
        String key = scanner.next();
        if (dictionaryMap.containsKey(key)){
            Dictionary dictionary = dictionaryMap.get(key);
            System.out.println(dictionary.getKeyWord() + "-" + dictionary.getDescription() + "-" + dictionary.getWordType());
        }
    }
    public void delete(Map<String, Dictionary> dictionaryMap) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập keyword:");
        String key = scanner.next();


        if (dictionaryMap.containsKey(key)) {
            dictionaryMap.remove(key);
            System.out.println("Đã xóa từ khóa: " + key);
        }
        for (Dictionary dictionary : dictionaryMap.values()){
            System.out.println(dictionary.getKeyWord() + "-" + dictionary.getDescription() + "-" + dictionary.getWordType());
        }
    }

}
