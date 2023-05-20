package br.com.alura.tdd.service;

import br.com.alura.tdd.modelo.Funcionario;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {
    //colocar nome dos testes bem descritivos
    @Test
    void bonusZeroParaFuncionarioComSalarioAlto(){
        BonusService service = new BonusService();

        //um modo de conferir a exception
        //assertThrows(IllegalArgumentException.class, () -> service.calcularBonus(new Funcionario("Dayane Lima", LocalDate.now(), new BigDecimal("25000"))));

        //outro modo de conferir a exception
        try {
            service.calcularBonus(new Funcionario("Dayane Lima", LocalDate.now(), new BigDecimal("25000")));
            fail("Não retornou a exception!");
        } catch (Exception e) {
            assertEquals("Funcionário com salário acima de R$10000,00 não pode receber bônus", e.getMessage()); //confere se mensagem esperada está correta
        }
    }

    @Test
    void bonusDezPorCentoDoSalario(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Pedro Souza", LocalDate.now(), new BigDecimal("2500")));

        assertEquals(new BigDecimal("250.00"), bonus);
    }

    @Test
    void bonusDezPorCentoSalarioDeExatamenteDezMil(){
        BonusService service = new BonusService();
        BigDecimal bonus = service.calcularBonus(new Funcionario("Ana Barreto", LocalDate.now(), new BigDecimal("10000")));

        assertEquals(new BigDecimal("1000.00"), bonus);
    }
}