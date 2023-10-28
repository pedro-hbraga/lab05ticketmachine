
package teste;

import br.calebe.ticketmachine.exception.PapelMoedaInvalidaException;
import br.calebe.ticketmachine.exception.SaldoInsuficienteException;
import br.calebe.ticketmachine.core.TicketMachine;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TicketMachineTest {

    private TicketMachine ticketMachine;

    @Before
    public void setUp() {
        ticketMachine = new TicketMachine(10); // Criando uma TicketMachine com o valor do bilhete de 10 unidades
    }

    @Test
    public void testInserirPapelMoedaValida() throws PapelMoedaInvalidaException {
        ticketMachine.inserir(10);
        assertEquals(10, ticketMachine.getSaldo());
    }

    @Test(expected = PapelMoedaInvalidaException.class)
    public void testInserirPapelMoedaInvalida() throws PapelMoedaInvalidaException {
        ticketMachine.inserir(7); // Tentando inserir uma nota inválida
    }

    @Test
    public void testImprimirComSaldoSuficiente() throws SaldoInsuficienteException, PapelMoedaInvalidaException {
        ticketMachine.inserir(20); // Inserindo mais do que o valor do bilhete
        String resultado = ticketMachine.imprimir();
        assertEquals("******\n* R$ 10,00 **\n******\n", resultado);
    }

    @Test(expected = SaldoInsuficienteException.class)
    public void testImprimirComSaldoInsuficiente() throws SaldoInsuficienteException, PapelMoedaInvalidaException {
        ticketMachine.inserir(5); // Inserindo menos do que o valor do bilhete
        ticketMachine.imprimir(); // Deve lançar uma exceção
    }
}