package com.Funcionarios2;


import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Objects;

public class Empresa {

    ArrayList<Funcionario> funcionarios;
    ArrayList<Area> areas;

    Empresa(){
        this.funcionarios = new ArrayList<Funcionario>();
        this.areas = new ArrayList<Area>();
    }

  
    //1. Quem mais recebe e quem menos recebe na empresa e a média salarial da empresa.
    public void identificarSalarios() {
        System.out.println("\n#Maior, menor e medio salario dos funcionarios");
        float max = 0;
        Funcionario maiorFuncionario = null;
        float min = 0;
        Funcionario menorFuncionario = null;
        float sum = 0;
        float avg;

        for (int i = 0; i < funcionarios.size(); i++) {
            if (max < funcionarios.get(i).getSalario()) {
                max = funcionarios.get(i).getSalario();
                maiorFuncionario = funcionarios.get(i);
            }
            if (i == 0) {
                min = funcionarios.get(i).getSalario();
                menorFuncionario = funcionarios.get(i);
            }
            if (min > funcionarios.get(i).getSalario()) {
                min = funcionarios.get(i).getSalario();
                menorFuncionario = funcionarios.get(i);
            }
            sum +=funcionarios.get(i).getSalario();
        }

        for(int i = 0; i<funcionarios.size(); i++){
            if(funcionarios.get(i).getSalario() == maiorFuncionario.getSalario()){
                System.out.println("global_max|"+funcionarios.get(i).getNome()+" "+funcionarios.get(i).getSobrenome()+"|"+max);
            }
            if(funcionarios.get(i).getSalario() == menorFuncionario.getSalario()){
                System.out.println("global_min|"+funcionarios.get(i).getNome()+" "+funcionarios.get(i).getSobrenome()+"|"+min);
            }
        }

        avg = sum/funcionarios.size();
        System.out.println("global_avg|"+avg);
    }

//2. Quem mais recebe e quem menos recebe em cada área e a média salarial em cada área.
    public void salariosArea() {
        System.out.println("\n#Maior, menor e medio salario por area");
        float max = 0;
        Funcionario maiorFuncionario = null;
        float min = 0;
        Funcionario menorFuncionario = null;
        float sum = 0;
        float avg = 0;
        String areaAtual = "";
        float count = 0;

        for(int i = 0; i < areas.size(); i++){
            for(int k = 0; k < funcionarios.size(); k++){
                if(Objects.equals(funcionarios.get(k).getArea(), areas.get(i).getCodigo())){
                    count++;
                    areaAtual = areas.get(i).getNome();
                    if (max < funcionarios.get(k).getSalario()) {max = funcionarios.get(k).getSalario(); maiorFuncionario = funcionarios.get(k);}
                    if (count == 1) {min = funcionarios.get(k).getSalario(); menorFuncionario = funcionarios.get(k);}
                    if (min > funcionarios.get(k).getSalario()) { min = funcionarios.get(k).getSalario(); menorFuncionario = funcionarios.get(k);}
                    sum += funcionarios.get(k).getSalario();
                }
            }

            for(int j = 0; j < funcionarios.size(); j++){
                if(funcionarios.get(j).getSalario() == maiorFuncionario.getSalario()){
                    System.out.println("area_max|"+areaAtual+"|"+funcionarios.get(j).getNome()+" "+funcionarios.get(j).getSobrenome()+"|"+max);
                }
                if(funcionarios.get(j).getSalario() == menorFuncionario.getSalario()){
                    System.out.println("area_min|"+areaAtual+"|"+funcionarios.get(j).getNome()+" "+funcionarios.get(j).getSobrenome()+"|"+min);
                }
            }
            avg = sum / count;
            System.out.println("area_avg|"+areaAtual+"|"+avg);
            count = 0;
            sum = 0;
        }
    }

    //3. Área(s) com o maior e menor número de funcionários
    public void identificarP(){
        System.out.println("\n#Area com maior e menor número de funcionarios");
        int maior = 0;
        int menor = 0;
        String maiorArea = null;
        String menorArea = null;
        ArrayList<Integer> vezesSetor = new ArrayList<Integer>();
        for(int i = 0; i < funcionarios.size(); i++){
            int vezes = 0;
            for(int k = 0; k < funcionarios.size(); k++){
                if(Objects.equals(funcionarios.get(i).getArea(), funcionarios.get(k).getArea())){
                    vezes++;
                }
            }
            vezesSetor.add(i, vezes);

            for(int c = 0; c < vezesSetor.size(); c++){
                if( maior < vezesSetor.get(c)){maior = vezesSetor.get(c); maiorArea = funcionarios.get(c).getArea();
                }
                if(c == 0){ menor = vezesSetor.get(c); menorArea = funcionarios.get(c).getArea();
                }
                if(menor > vezesSetor.get(c)){ menor = vezesSetor.get(c); menorArea = funcionarios.get(c).getArea();
                }
            }
        }
        for(int i = 0; i < areas.size(); i++){
            if(Objects.equals(maiorArea, areas.get(i).getCodigo())){
                System.out.println("most_employees|"+areas.get(i).getNome()+"|"+ maior);
            }
            if(Objects.equals(menorArea, areas.get(i).getCodigo())){
                System.out.println("least_employees|" +areas.get(i).getNome()+"|"+ menor);
            }
        }
    }

    //4. Maiores salários para funcionários com o mesmo sobrenome
    public void salariosSobrenome() {
        System.out.println("\n#Maiores salários para funcionários com o mesmo sobrenome");
        float max = 0;
        Funcionario maiorFuncionario = null;

        ArrayList<Funcionario> sobrenomes = new ArrayList<Funcionario>();
        for(int i = 0; i < funcionarios.size(); i++){
            for(int k = 0; k < funcionarios.size(); k++){
                if(Objects.equals(funcionarios.get(i).getSobrenome(), funcionarios.get(k).getSobrenome()) && funcionarios.get(i).getId() != funcionarios.get(k).getId()){
                    sobrenomes.add(funcionarios.get(i));
                    sobrenomes.add(funcionarios.get(k));
                }
            }
        }

        for (int i = 0; i < sobrenomes.size(); i++) {
            if (max < sobrenomes.get(i).getSalario()) {
                max = sobrenomes.get(i).getSalario();
                maiorFuncionario = sobrenomes.get(i);
                System.out.println("last_name_max|"+maiorFuncionario.getSobrenome()+"|"+maiorFuncionario.getNome()+" "+maiorFuncionario.getSobrenome()+"|"+max);

            }
        }
    }
}
