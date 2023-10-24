/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package teste;


import java.util.Iterator;
import br.calebe.ticketmachine.core.Troco;
import br.calebe.ticketmachine.core.PapelMoeda;
import org.junit.Test;
import static org.junit.Assert.*;

public class TrocoTeste {

    @Test
    public void testTrocoIterator() {
        Troco troco = new Troco(137);
        Iterator<PapelMoeda> iterator = troco.getIterator();

        assertTrue(iterator.hasNext());
        assertEquals(100, iterator.next().getValor());

        assertTrue(iterator.hasNext());
        assertEquals(20, iterator.next().getValor());

        assertTrue(iterator.hasNext());
        assertEquals(10, iterator.next().getValor());

        assertTrue(iterator.hasNext());
        assertEquals(5, iterator.next().getValor());

        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next().getValor());

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testTrocoIteratorWithZeroValue() {
        Troco troco = new Troco(0);
        Iterator<PapelMoeda> iterator = troco.getIterator();

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testTrocoIteratorWithNegativeValue() {
        Troco troco = new Troco(-10);
        Iterator<PapelMoeda> iterator = troco.getIterator();

        assertFalse(iterator.hasNext());
    }
}