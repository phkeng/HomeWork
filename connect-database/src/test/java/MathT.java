/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 *
 * @author anonymous
 */
public class MathT {
    
    @Test
    public void ceil(){
        assertEquals((int)Math.ceil(27/5D), 6);
    }
}
