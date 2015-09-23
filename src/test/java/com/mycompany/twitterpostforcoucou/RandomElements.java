/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.twitterpostforcoucou;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.lang.model.util.ElementScanner6;

/**
 *
 * @author janit_000
 */
public class RandomElements<T> {
    List<T> elements;
    public RandomElements(T[] urls) {
        elements = Arrays.asList(urls);
    }

    List<T> getElementsInRadomOrder(int numberofElementstoReturn) {
        Collections.shuffle(elements);
        return elements.subList(0, numberofElementstoReturn);
    }
}
