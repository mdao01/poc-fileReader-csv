package org.example;

import org.example.model.Product;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String path = "C:\\workstation\\estudos-java\\files-teste\\in.csv";
        List<Product> products = new ArrayList<Product>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            String line = br.readLine();
            while ( line != null){

                String[] vect = line.split(",");

                String name = vect[0];
                BigDecimal price = BigDecimal.valueOf(Double.parseDouble(vect[1]));
                Integer qnt = Integer.valueOf(vect[2]);

                Product product = new Product(name, price, qnt);
                products.add(product);

                line = br.readLine();
            }

            System.out.println("Products :");
            for (Product p : products){
                System.out.println(p);
            }

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}