/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calccommon;

/**
 *
 * @author om4rezz
 */
public interface IDictionary {
    public String translate(String text, String fromLang); // to English
    public String translate(String text, String fromLang, String toLang);
}
