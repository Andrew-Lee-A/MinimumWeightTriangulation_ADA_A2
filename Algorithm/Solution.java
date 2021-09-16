/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Andrew_PC
 */
public class Solution {
    public double cost = Double.MAX_VALUE;
    public List<Point> p1 = new ArrayList<>();
    public List<Point> p2 = new ArrayList<>();
    
    @Override
    public String toString(){
        return Double.toString(this.cost) + "\n" + p1.toString() + "\n"+ p2.toString();
    }
}
