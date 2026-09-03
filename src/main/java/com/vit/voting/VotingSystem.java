package com.vit.voting;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VotingSystem {

    public static String evaluateEligibility(Voter voter) {
        List<String> reasons = new ArrayList<>();

        if (voter.getAge() < 18) {
            reasons.add("Underage (Must be at least 18)");
        }
        if (!"Indian".equalsIgnoreCase(voter.getCitizenship())) {
            reasons.add("Not a citizen (Must be an Indian citizen)");
        }
        if (voter.getVoterId() == null || voter.getVoterId().isBlank() || !voter.isIdValid()) {
            reasons.add("Invalid ID status or missing Voter ID");
        }

        if (reasons.isEmpty()) {
            return "ELIGIBLE";
        } else {
            return "INELIGIBLE: " + String.join(", ", reasons);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of voters to evaluate: ");
        
        if (!scanner.hasNextInt()) {
            System.out.println("Invalid input count.");
            scanner.close();
            return;
        }
        
        int count = scanner.nextInt();
        scanner.nextLine(); 

        for (int i = 0; i < count; i++) {
            System.out.println("\n--- Entering Details for Voter " + (i + 1) + " ---");
            System.out.print("Enter Name: ");
            String name = scanner.nextLine();
            
            System.out.print("Enter Age: ");
            int age = scanner.nextInt();
            scanner.nextLine(); 

            System.out.print("Enter Citizenship: ");
            String citizenship = scanner.nextLine();

            System.out.print("Enter Voter ID: ");
            String voterId = scanner.nextLine();

            System.out.print("Is Voter ID valid? (true/false): ");
            boolean isIdValid = scanner.nextBoolean();
            scanner.nextLine(); 

            Voter voter = new Voter(name, age, citizenship, voterId, isIdValid);
            String status = evaluateEligibility(voter);
            
            System.out.println("Result for " + voter.getName() + ": " + status);
        }
        scanner.close();
    }
}
