
import com.Funcionarios2.*;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new Gson();
        Reader reader = new FileReader("resources/funcionarios.json");

        Empresa empresa = gson.fromJson(reader, Empresa.class);

        //1. Quem mais recebe e quem menos recebe na empresa e a média salarial da empresa.
        empresa.identificarSalarios();
        //2. Quem mais recebe e quem menos recebe em cada área e a média salarial em cada área.
        empresa.salariosArea();
        //3. Área(s) com o maior e menor número de funcionários
        empresa.identificarP();
        //4. Maiores salários para funcionários com o mesmo sobrenome
        empresa.salariosSobrenome();






    }
}
