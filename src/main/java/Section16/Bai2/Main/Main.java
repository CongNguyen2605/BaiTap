package Section16.Bai2.Main;

import Section16.Bai2.Model.Dictionary;
import Section16.Bai2.Service.DictionaryService;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Dictionary dictionary = new Dictionary();
        Map<String,Dictionary>dictionaryMap = new HashMap<>();
        DictionaryService dictionaryService = new DictionaryService();
        dictionaryMap = dictionaryService.input();

        System.out.println("infor");
        dictionaryService.infor(dictionaryMap);
        System.out.println("FILTER");
        dictionaryService.filter(dictionaryMap);
        System.out.println("delete");
        dictionaryService.delete(dictionaryMap);
    }
}
