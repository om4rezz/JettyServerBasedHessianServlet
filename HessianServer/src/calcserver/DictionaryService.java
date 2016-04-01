/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcserver;

import com.caucho.hessian.server.HessianServlet;
import java.util.ArrayList;
import calccommon.IDictionary;

/**
 *
 * @author om4rezz
 */
public class DictionaryService extends HessianServlet implements IDictionary {

    ArrayList<String> arabicItems;
    ArrayList<String> englishItems;
    ArrayList<String> germanItems;

    public DictionaryService() {
        arabicItems = new ArrayList<>();
        englishItems = new ArrayList<>();
        germanItems = new ArrayList<>();

        arabicItems.add("بنت");
        arabicItems.add("ولد");
        arabicItems.add("رجل");
        arabicItems.add("امرأة");
        arabicItems.add("طفل");

        englishItems.add("a girl");
        englishItems.add("a boy");
        englishItems.add("a man");
        englishItems.add("a woman");
        englishItems.add("a child");

        germanItems.add("ein Mädchen");
        germanItems.add("ein Junge");
        germanItems.add("ein man");
        germanItems.add("eine frau");
        germanItems.add("ein kind");

    }

    @Override
    public String translate(String text, String fromLang) {
        int index = 0;
        switch (fromLang) {
            case "ar":
                index = arabicItems.indexOf(text);
                if (index == -1) {
                    return "translation not found";
                } else {
                    return englishItems.get(index);
                }
            case "en":
                index = englishItems.indexOf(text);
                if (index == -1) {
                    return "translation not found";
                } else {
                    return englishItems.get(index);
                }
            case "ge":
                index = germanItems.indexOf(text);
                if (index == -1) {
                    return "translation not found";
                } else {
                    return englishItems.get(index);
                }
            default:
                return "not supported language";
        }
    }

    @Override
    public String translate(String text, String fromLang, String toLang) {

        return "comming soon.!";
    }

}
