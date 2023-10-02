package com.javatraining;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class FunctionalInterfaceExample {


        public static void main(String[] args) {
            // Predicate Example
            List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

            // Define a predicate to check if a number is even
            Predicate<Integer> isEven = number -> number % 2 != 0;

            // Filter the list to only include even numbers
            List<Integer> evenNumbers = numbers.stream()
                    .filter(isEven)
                    .collect(Collectors.toList());

            // Print the even numbers
            System.out.println(evenNumbers);

            // Consumer Example
            List<String> names = new ArrayList<>();
            names.add("Alice");
            names.add("Charlie");
            names.add("David");

            // Create a Consumer to print each name
            Consumer<String> printName = (name) -> System.out.println(name);

            // Use the Consumer to process each element in the list
            names.forEach(printName);

            // Supplier Example
            // Create a supplier to generate a random number
            Supplier<Integer> randomNumberSupplier = () -> (int) (Math.random() * 100);

            // Generate a random number
            int randomNumber = randomNumberSupplier.get();

            // Print the random number
            System.out.println(randomNumber);

            //Function Example

            // Create a Function that converts a string to its length (integer).
            Function<String, Integer> stringLength = (str) -> str.length();

            // Apply the function to a string.
            String input = "Java funtional interface";
            int length = stringLength.apply(input);

            System.out.println("Length of '" + input + "' is: " + length);
        }

    }





