package com.codebulls.challenges;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class JavaDataTypeIntroduction {

    public static void main(String[] args) {
        //String  es una cadena de caracteres inmutable
        String str1 = "Hol trabajo en codebulls";
        char character = str1.charAt(0); //Obtener el primer caracter

        //Short for small numbers
        Short str2 ; // -> null
        short str3 ; // -> 0

        //Integer for big numbers
        Integer num1 = 1000; // -> null 128 bytes en memoria
        num1.toString();
        num1.equals(100); // -> true
        int num4 = 1000; // -> 0   //32 bits en memoria

        //Long for very big numbers
        Long num2 = 1000L;//64 bits en memoria
        long num5 = 1000L; //64 bits en memoria

        //BigDecimal for precise decimal numbers
        BigDecimal num3 = new BigDecimal("1000.00");
        num3.multiply(new BigDecimal("2.5"));

        //Float for decimal numbers with less precision
        Float num44 = 1000.0f;
        float num6 = 1000.0f; //32 bits en memoria

        //Boolean for true/false values
        Boolean bool1 = true;
        boolean bool2 = false; //1 bit en memoria

        //StringBuilder for mutable strings
        StringBuilder strBuilder = new StringBuilder("Hola, soy un StringBuilder");
        strBuilder.append(" y puedo ser modificado.");
        strBuilder.insert(5, "mundo ");
        strBuilder.delete(0, 5);

        //Si necesitas una lista mutable, usa new ArrayList<>(List.of(...))
        List<String> stringList = List.of("Hola", "mundo", "Codebulls", "Java", "Programación");

        //Java 5
        for (int i = 0; i < stringList.size(); i++) {
            if(stringList.get(i).equals("Codebulls")) {
                System.out.println("¡Encontré Codebulls!");
            }
            stringList.add("Nuevo Elemento"); // Esto lanzará UnsupportedOperationException porque List.of() crea una lista inmutable
        }

        //Java 8 < permite crear listas inmutables con List.of()
        int indice = 0;
        for (String str : stringList) { //10000000000
            if (str.equals("Codebulls")) {
                System.out.println("¡Encontré Codebulls!");
            }
            indice++;
            stringList.add("Nuevo Elemento"); // Esto lanzará UnsupportedOperationException porque List.of() crea una lista inmutable
        }

        //Java 8 > stremas
        stringList.stream().forEach(str -> { if (str.equals("Codebulls")) { System.out.println("¡Encontré Codebulls!"); }  });

        var priemrPosicion = stringList.get(0);

        if(priemrPosicion instanceof String) {
            System.out.println("El primer elemento es una cadena: " + priemrPosicion);
        } else {
            System.out.println("El primer elemento no es una cadena.");
        }

        String direccion1 = "Calle Falsa 123, Ciudad, Pais";
        String direccion2 = "Calle Falsa 123, Ciudad, test";
        List<String> listaDirecciones = List.of(direccion1, direccion2);

        class Client {
            private String name;
            private String department;
            private int age;

            public Client(String name, String department, int age) {
                this.name = name;
                this.department = department;
                this.age = age;
            }
        }

        //Clase ejemplo para representar un producto de WP
        class Product {
            private String name;
            private String sku;
            private BigDecimal price;
            private List<String> tags;
            private String description;

            public Product(String name, String sku, BigDecimal price, List<String> tags, String description) {
                this.name = name;
                this.sku = sku;
                this.price = price;
                this.tags = tags;
                this.description = description;
            }
        }

        Map<Integer, Client> stringIntegerMap = Map.of(
                1, new Client("Juan", "IT", 35),
                2, new Client("Maria", "HR", 45),
                3, new Client("Pedro", "Finance", 67),
                4, new Client("Ana", "Marketing", 29),
                5, new Client("Luis", "Sales", 50)
        );

        Set<String> stringSet = Set.of("uno", "dos", "tres","tres", "cinco");

        class Figura {
            private String nombre;
            private double area;

            public Figura(String nombre, double area) {
                this.nombre = nombre;
                this.area = area;
            }

            public String getNombre() {
                return nombre;
            }

            public double getArea() {
                return area;
            }
        }

        class Circulo extends Figura {
            private double radio;

            public Circulo(String nombre, double area, double radio) {
                super(nombre, area);
                this.radio = radio;
            }

            public double getRadio() {
                return radio;
            }

            @Override
            public double getArea() {
                return Math.PI * radio * radio;
            }
        }

        Circulo circulo = new Circulo("Círculoide", 78.54, 5.0);
        var area = circulo.getArea();
    }

    /*
    try {
        int resultado = 10 / 0;
    } catch (ArithmeticException e) {
        System.out.println("Error: " + e.getMessage());
    }
    */

}
