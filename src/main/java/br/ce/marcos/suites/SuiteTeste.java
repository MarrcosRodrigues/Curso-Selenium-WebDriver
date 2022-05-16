package br.ce.marcos.suites;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import br.ce.marcos.teste.TesteCadastro;
import br.ce.marcos.teste.TesteCampoTreinamento;
import br.ce.marcos.teste.TesteRegrasCadrasto;

@RunWith(Suite.class)
@SuiteClasses({
	TesteCadastro.class,
	TesteRegrasCadrasto.class,
	TesteCampoTreinamento.class	
})
public class SuiteTeste {
	
	
}
