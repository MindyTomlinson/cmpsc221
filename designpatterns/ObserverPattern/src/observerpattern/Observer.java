/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observerpattern;

/**
 *
 * @author Mindy Tomlinson (ast121@psu.edu)
 */
public interface Observer {
    void update(double temperature, double humidity, double pressure);
}
