import java.time.LocalDate;
import java.util.Set;

import dominio.AtividadesCursos;
import dominio.Bootcamp;
import dominio.Devs;
import dominio.Mentorias;

public class DesafioPOO {
    public static void main(String[] args) {
        AtividadesCursos cursoCollection = new AtividadesCursos("Collections Java", "Princípios de Collection em Java", 3);
        AtividadesCursos cursoStream = new AtividadesCursos("Java - Stream API", "Princípios da Stream API em Java", 2);

        Set<AtividadesCursos> cursosBootcamp = Set.of(cursoCollection, cursoStream);

        Mentorias mentoriaStream = new Mentorias("Exercícios de Stream API", "Resolução de exercícios da Stream API.", LocalDate.of(2024, 7, 20));
        Mentorias mentoriaSoftSkill = new Mentorias("Soft Skills em TI", "As soft skills mais cobiçadas pelo mercado.", LocalDate.of(2024, 8, 5));
        Set<Mentorias> mentoriasBootcamp = Set.of(mentoriaSoftSkill, mentoriaStream);

        System.out.println("XP de curso Collection: " + cursoCollection.calcularXP());

        Bootcamp bootcamp = new Bootcamp(LocalDate.of(2024, 7, 5), LocalDate.of(2024, 8, 20), "Bootcamp Java Developer", "Bootcamp Java Back-End patrocinado pelo Santander.", cursosBootcamp, mentoriasBootcamp);

        Devs devGabriela = new Devs("Gabriela");
        devGabriela.inscreverBootcamp(bootcamp);
        System.out.println(devGabriela);

        devGabriela.progredir(cursoStream);
        devGabriela.progredir(cursoCollection);
        System.out.println("XP:" + devGabriela.calcularTotalXp());
        
    }

}