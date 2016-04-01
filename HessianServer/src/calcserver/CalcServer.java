/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calcserver;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.nio.NetworkTrafficSelectChannelConnector;
import org.eclipse.jetty.servlet.ServletContextHandler;

/**
 *
 * @author om4rezz
 */
public class CalcServer {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            int port = 7001;

            Server server = new Server();
            NetworkTrafficSelectChannelConnector connector = new NetworkTrafficSelectChannelConnector(server);
            connector.setPort(port);
            server.addConnector(connector);

            ServletContextHandler webApp = new ServletContextHandler(server, "");//add app at root context path
            server.setHandler(webApp);
            // we must add all servlets to the web app.!
            webApp.addServlet(CalculatorService.class, "/calc_service");//define one endpoint per service
            webApp.addServlet(DictionaryService.class, "/dict_service");//define one endpoint per service
            server.start();
        } catch (Exception ex) {
            Logger.getLogger(CalcServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
