/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcclient;

import calccommon.ICalc;
import calccommon.IDictionary;
import com.caucho.hessian.client.HessianProxyFactory;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author om4rezz
 */
public class CalcClient {

    static ICalc calcService;
    static IDictionary dictService;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        try {
            HessianProxyFactory hpf = new HessianProxyFactory();
            // add this line of you have some overloaded methods.!
            hpf.setOverloadEnabled(true);

            calcService = (ICalc) hpf.create(ICalc.class, "http://localhost:7001/calc_service"); //service endpoint
            dictService = (IDictionary) hpf.create(IDictionary.class, "http://localhost:7001/dict_service"); //service endpoint

        } catch (MalformedURLException ex) {
            Logger.getLogger(CalcClient.class.getName()).log(Level.SEVERE, null, ex);
        }

        new CalcClientFrame().setVisible(true);
        new DictionaryClientFrame().setVisible(true);
    }

}
