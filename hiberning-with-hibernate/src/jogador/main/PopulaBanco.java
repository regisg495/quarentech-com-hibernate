package jogador.main;

import jogador.model.Jogador;
import jogador.model.Posicao;
import jogador.model.Tecnico;
import jogador.model.Time;
import jogador.persistencia.JogadorDAO;
import jogador.persistencia.PosicaoDAO;
import jogador.persistencia.TecnicoDAO;
import jogador.persistencia.TimeDAO;

public class PopulaBanco {

	public static void main(String[] args) {

		Time t = new Time("Internacional");
		Time t2 = new Time("Gr�mio");
		Time t3 = new Time("Palmeiras");
		Time t4 = new Time("Santos");
		
		Tecnico te1 = new Tecnico("Abel Braga", t);
		Tecnico te2 = new Tecnico("Renato Gaucho", t2);
		Tecnico te3 = new Tecnico("Luxemburgo", t3);
		Tecnico te4 = new Tecnico("Felip�o", t4);
		

		Posicao p1 = new Posicao("Atacante");
		Posicao p2 = new Posicao("Meia");
		Posicao p3 = new Posicao("Volante");
		Posicao p4 = new Posicao("Goleiro");
		Posicao p5 = new Posicao("Lateral");

		Jogador j1 = new Jogador("Romulo", t, p1);
		Jogador j2 = new Jogador("Tiago", t2, p2);
		Jogador j3 = new Jogador("Renato", t, p3);
		Jogador j4 = new Jogador("Felipe", t3, p4);
		Jogador j5 = new Jogador("Isaque", t4, p5);
		Jogador j6 = new Jogador("Israel", t2, p3);
		Jogador j7 = new Jogador("Matheus", t3, p1);
		
		TimeDAO timedao = new TimeDAO();
		
		TecnicoDAO tecnicodao = new TecnicoDAO();
		
		PosicaoDAO pdao = new PosicaoDAO();
		
		JogadorDAO jdao = new JogadorDAO();
		
		timedao.save(t);
		timedao.save(t2);
		timedao.save(t3);
		timedao.save(t4);
		
		tecnicodao.save(te1);
		tecnicodao.save(te2);
		tecnicodao.save(te3);
		tecnicodao.save(te4);
		
		pdao.save(p1);
		pdao.save(p2);
		pdao.save(p3);
		pdao.save(p4);
		pdao.save(p5);
		
		jdao.save(j1);
		jdao.save(j2);
		jdao.save(j3);
		jdao.save(j4);
		jdao.save(j5);
		jdao.save(j6);
		jdao.save(j7);

		
	}

}
