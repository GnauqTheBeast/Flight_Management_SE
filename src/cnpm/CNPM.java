/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cnpm;

import DAO.DAO;
import View.Revenue;
/**
 *
 * @author Quang Nguyen
 */
public class CNPM {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DAO deptrai = new DAO();
        Revenue revenue = new Revenue();
        revenue.setVisible(true);
    }
    
}
