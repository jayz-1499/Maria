/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import entity.Cake;
import java.util.List;

/**
 *
 * @author nguye
 */
public interface CakeInterface {

    public int getTotalProducts() throws Exception;

    public List<Cake> getTop2() throws Exception;

    public List<Cake> getAllCakes(int startIndex, int endIndex) throws Exception;

    public Cake getCakeDetail(int CakeID) throws Exception;

}
