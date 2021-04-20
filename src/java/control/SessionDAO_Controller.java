/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.ViewDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 *
 * @author nguye
 */
public class SessionDAO_Controller implements HttpSessionListener {

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        try {

            new ViewDAO().increaseView();
      

        } catch (Exception ex) {
            Logger.getLogger(SessionDAO_Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
