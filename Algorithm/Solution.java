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
// Student Andrew Lee 17983766
// Student: Jacob Tupe - 18018323
public class Solution {
    public double cost = Double.MAX_VALUE;
    public List<Point> p1 = new ArrayList<>();
    public List<Point> p2 = new ArrayList<>();

    @Override
    public String toString(){
            return this.cost + p1.toString() + p2.toString();
    }
}
