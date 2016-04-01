/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcserver;

import calccommon.ICalc;
import com.caucho.hessian.server.HessianServlet;

/**
 *
 * @author om4rezz
 */
public class CalculatorService extends HessianServlet implements ICalc {

    @Override
    public int sum(int n1, int n2) {
        return n1 + n2;
    }

    @Override
    public int subtract(int n1, int n2) {
        return n1 - n2;
    }

    @Override
    public int multiply(int n1, int n2) {
        return n1 * n2;
    }

}
