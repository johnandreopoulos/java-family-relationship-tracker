// ===========================================================================================================
// The main porpuse of this program is to find the family relationship between two people.
// The program reads data from a csv file and stores it in a list of Tree objects.
// The program then prompts the user to enter the names of two people and checks if the names are valid.
// If the names are valid, the program finds the family relationship between the two people and displays it.
// If the names are invalid, the program displays an error message and prompts the user to enter the names again.
// ===========================================================================================================

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// This class creates a Person object with a name and gender.
// It also has getter methods to access the name and gender.
import classes.Person;

// This class creates a Tree object with a name, relation, and a list of Person
// objects. It has setter methods to set the name and relation, and a method to
// add Person objects to the list. It also has getter methods to access the
// name, relation, and list of Person objects.
import classes.Tree;

public class App {

    static String inputName1;
    static String inputName2;

    static String filePath = "C://tree.csv";

    public static void main(String[] args) {
        menu();
    }

    // This code creates a menu that allows the user to select from various options.
    // The options include finding the family relationship between two people,
    // sorting people in lexicographical order and writing to a file, clearing the
    // console screen, and exiting the program. The code uses a while loop and an
    // if-else statement to check the user's choice and execute the corresponding
    // action. The user can choose an option by entering a number between 1-3 or by
    // typing 'exit'. If the user enters an invalid option, the code will display an
    // error message. The loop will continue until the user chooses to exit the
    // program.
    public static void menu() {
        boolean menu = false;
        while (!menu) {
            System.out.println("\n------------------------------------");
            System.out.println("-    Welcome to the main menu      -");
            System.out.println("------------------------------------");
            System.out.println("1. Find the family relationship between two people.");
            System.out.println("2. Sort people in lexicographical order and write to file.");
            System.out.println("3. Clear console screen.");
            System.out.println("~> To stop the program type 'exit'");
            System.out.print("\nChoose an option: ");

            Scanner input = new Scanner(System.in);
            String choice = input.nextLine();

            if (choice.equals("1")) {
                System.out.println("\nThis option allows you to find the family relationship between two people.");
                System.out .println("Please enter the names of the two people you want to find the relationship between.");
                System.out.print("Enter the first name: ");
                inputName1 = input.nextLine().trim();
                System.out.print("Enter the second name: ");
                inputName2 = input.nextLine().trim();
                while (inputName1.equals("") || inputName2.equals("")) {
                    System.out.println("Invalid input. Please enter the names again.");
                    System.out.print("Enter the first name: ");
                    inputName1 = input.nextLine().trim();
                    System.out.print("Enter the second name: ");
                    inputName2 = input.nextLine().trim();
                }
                readData();
            } else if (choice.equals("2")) {
                sortLexicographically();
            } else if (choice.equals("3")) {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            } else if (choice.toLowerCase().equals("exit")) {
                System.out.println("\nThank you for using this family relationship finder!!\n");
                System.exit(0); // With System.exit we exit the programm.
                menu = true;
            } else {
                System.out.println("Invalid option");
            }
        }
    }

    // This code creates a method that allows the user to decide whether they want
    // to continue using the program or exit it. The method prompts the user with a
    // question asking if they want to continue (Y/N). The user's choice is captured
    // by a scanner and stored in the variable "choice". The code then uses an
    // if-else statement to check the user's choice. If the user chooses 'Y', the
    // main method is called again, allowing the user to continue using the program.
    // If the user chooses 'N', the program exits and displays a "Goodbye!" message.
    // If the user enters an invalid choice, an error message is displayed and the
    // method is called again.
    public static void wantContinue() {
        System.out.print("\n~> Do you want to continue? (Y/N): ");
        Scanner input = new Scanner(System.in);
        String choice = input.nextLine();

        if (choice.toLowerCase().equals("y")) {
            main(null); // call main method
        } else if (choice.toLowerCase().equals("n")) {
            System.out.println("\nThank you for using this family relationship finder!!\n");
            System.exit(0); // exit program
        } else {
            System.out.println("Invalid choice. Please try again."); // print error message
            wantContinue(); // call method again
        }
    }

    // The code is reading the content of a CSV file and storing it in a String
    // variable. It uses a try-catch block to handle any errors that may occur while
    // reading the file. It also skips empty lines. If there is no error, the code
    // returns the content of the file as a String. If an error is encountered, it
    // prints an error message and returns null.
    private static String csvFile() {
        String fileName = filePath; // this is the name of the file that will be read
        String fileContent = ""; // this is the variable that will store the content of the file
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line; // this is the variable that will store the current line
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) continue;
                fileContent += line + "\n";
            }
            return fileContent;
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
            return null;
        }
    }

    // This code reads the content of a CSV file, splits it into lines, and creates
    // a list to store names and genders. It then loops through the lines, splits
    // them into parts, and adds the name and gender to the list. The list is then
    // sorted and written to a new file "sorted.csv" using a BufferedWriter. If an
    // error occurs while writing to the file, an error message is printed. The code
    // then calls the method "wantContinue" to ask the user if they want to continue
    // using the program.
    public static void sortLexicographically() {
        String fileContent = csvFile();
        String[] lines = fileContent.split("\n");
        List<String> names = new ArrayList<>();

        for (String line : lines) {
            String[] parts = line.split(", ");
            if (parts.length == 2) {
                String name = parts[0].trim() + ", " + parts[1].trim();
                names.add(name);
            }
        }

        Collections.sort(names);
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("sorted.csv"))) {
            for (String name : names) {
                writer.write(name);
                writer.newLine();
            }
            System.out.println("File sorted.csv created successfully in the project folder.");

            wantContinue();
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    // This code reads and processes the content of a CSV file, creates a Map and a
    // list to store the data and calls a method "findRelation" to find the relation
    // between two names specified by the user. If a relation is found it will be
    // displayed, otherwise it will show "no relation". It calls the method
    // "wantContinue" to ask the user if they want to continue using the program. If
    // an error occurs, it will print the error.
    public static void readData() {
        csvFile();
        String csvFile = "tree.csv";
        String line = "";
        String csvSplitBy = ",";
        Map<String, List<Tree>> relationMap = new HashMap<>();
        List<Person> personList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                if (line.isEmpty()) continue;
                String[] parts = line.split(csvSplitBy);
                if (parts.length == 2) {
                    Person person = new Person(parts[0].toLowerCase().trim(), parts[1].toLowerCase().trim());
                    personList.add(person);
                } else if (parts.length == 3) {
                    Tree tree = new Tree();
                    tree.setName(parts[0].trim());
                    tree.setRelation(parts[1].trim());
                    tree.addPerson(new Person(parts[2].toLowerCase().trim(), null));
                    if (relationMap.containsKey(parts[0].toLowerCase().trim())) relationMap.get(parts[0].toLowerCase().trim()).add(tree);
                    else {
                        List<Tree> trees = new ArrayList<>();
                        trees.add(tree);
                        relationMap.put(parts[0].toLowerCase().trim(), trees);
                    }
                }
            }

            String relation = findRelation(inputName1.toLowerCase(), inputName2.toLowerCase(), relationMap, personList);
            if (relation != null) {
                if (relation == "PERSON_NOT_FOUND") System.out.println(inputName1 + " or " + inputName2 + " not found in the database.");
                else if (relation == "SAME_PERSON") System.out.println("Same person.");
                else System.out.println(inputName1 + " is " + relation + " of " + inputName2);
            } else System.out.println("No relation found.");

            wantContinue();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // The private static classes check familial relationships between people by
    // using data structures such as maps and lists, and methods like looping and
    // comparing names to determine relationships like father-son, mother-daughter,
    // grandparents-grandchildren, etc. They help to track and understand family
    // connections.
    private static String findFather(Map<String, List<Tree>> relationMap, List<Person> personList, String name) {
        String father = null;
        for (Person person : personList) {
            if (relationMap.containsKey(person.getName())) {
                List<Tree> trees = relationMap.get(person.getName());
                for (Tree tree : trees) {
                    if (tree.getRelation().equals("father")) {
                        for (Person person2 : tree.getPersons()) {
                            if (person2.getName().equals(name)) father = person.getName();
                        }
                    }
                }
            }
        }
        return father;
    }

    private static String findMother(Map<String, List<Tree>> relationMap, List<Person> personList, String name) {
        String father = null;
        for (Person person : personList) {
            if (relationMap.containsKey(person.getName())) {
                List<Tree> trees = relationMap.get(person.getName());
                for (Tree tree : trees) {
                    if (tree.getRelation().equals("mother")) {
                        for (Person person2 : tree.getPersons()) {
                            if (person2.getName().equals(name))  father = person.getName();
                        }
                    }
                }
            }
        }
        return father;
    }

    private static String getGender(List<Person> personList, String name) {
        for (Person person : personList) {
            if (person.getName().equals(name))  return person.getGender();
        }
        return null;
    }

    private static String isSibling(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String fatherOfName1 = findFather(relationMap, personList, name1);
        String fatherOfName2 = findFather(relationMap, personList, name2);
        String motherOfName1 = findMother(relationMap, personList, name1);
        String motherOfName2 = findMother(relationMap, personList, name2);
        if (fatherOfName1 != null && fatherOfName2 != null && motherOfName1 != null && motherOfName2 != null) {
            if (fatherOfName1.equals(fatherOfName2)) {
                String genderOfName1 = getGender(personList, name1);
                return genderOfName1.equals("man") ? "brother" : "sister";
            }
        }
        return null;
    }

    private static String isFather(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        if (relationMap.containsKey(name1)) {
            List<Tree> trees = relationMap.get(name1);
            for (Tree tree : trees) {
                if (tree.getRelation().equals("father")) {
                    for (Person person : tree.getPersons()) {
                        if (person.getName().equals(name2)) return "father";
                    }
                }
            }
        }
        return null;
    }

    private static String isMother(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        if (relationMap.containsKey(name1)) {
            List<Tree> trees = relationMap.get(name1);
            for (Tree tree : trees) {
                if (tree.getRelation().equals("mother")) {
                    for (Person person : tree.getPersons()) {
                        if (person.getName().equals(name2)) return "mother";
                    }
                }
            }
        }
        return null;
    }

    private static String isChild(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String fatherOfName1 = isFather(relationMap, personList, name2, name1);
        String motherOfName1 = isMother(relationMap, personList, name2, name1);
        String gender = getGender(personList, name1);

        if (fatherOfName1 != null || motherOfName1 != null) return gender.equals("man") ? "son" : "daughter";

        return null;
    }

    private static String isSpouse(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        if (relationMap.containsKey(name1)) {
            List<Tree> trees = relationMap.get(name1);
            for (Tree tree : trees) {
                for (Person person : tree.getPersons()) {
                    if (person.getName().equals(name2)) {
                        if (tree.getRelation().equals("husband")) {
                            return "husband";
                        }
                    }
                }
            }
        }

        if (relationMap.containsKey(name2)) {
            List<Tree> trees = relationMap.get(name2);
            for (Tree tree : trees) {
                for (Person person : tree.getPersons()) {
                    if (person.getName().equals(name1)) {
                        if (tree.getRelation().equals("husband")) return "wife";
                    }
                }
            }
        }

        return null;
    }

    private static String findSpouse(Map<String, List<Tree>> relationMap, List<Person> personList, String name) {
        for (Person person : personList) {
            if (relationMap.containsKey(person.getName())) {
                List<Tree> trees = relationMap.get(person.getName());
                for (Tree tree : trees) {
                    for (Person person2 : tree.getPersons()) {
                        if (person2.getName().equals(name)) {
                            if (tree.getRelation().equals("husband")) return person.getName();
                        }
                    }
                }
            }
        }
        return null;
    }

    private static String isGrandParent(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        List<Tree> trees = relationMap.get(name1);
        if (trees == null) return null;
        for (Tree tree : trees) {
            if (tree.getRelation().equals("father") || tree.getRelation().equals("mother")) {
                List<Tree> trees2 = relationMap.get(tree.getPersons().get(0).getName());
                if (trees2 == null) continue;
                for (Tree tree2 : trees2) {
                    if (tree2.getRelation().equals("father")) {
                        for (Person person2 : tree2.getPersons()) {
                            if (person2.getName().equals(name2)) return tree.getRelation().equals("mother") ? "grandmother" : "grandfather";
                        }
                    }
                }
            }
        }
        return null;
    }

    private static String isGrandChild(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String fatherOfName1 = findFather(relationMap, personList, name1);
        String motherOfName1 = findMother(relationMap, personList, name1);
        String fatherOfFatherName1 = findFather(relationMap, personList, fatherOfName1);
        String motherOfFatherName1 = findMother(relationMap, personList, fatherOfName1);

        if ((fatherOfName1 != null && fatherOfFatherName1 != null && motherOfFatherName1 != null) || (motherOfName1 != null && motherOfFatherName1 != null && fatherOfFatherName1 != null)) {
            if (fatherOfFatherName1.equals(name2) || motherOfFatherName1.equals(name2)) {
                String gender = getGender(personList, name1);
                return gender.equals("man") ? "grandson" : "granddaughter";
            }
        }

        return null;
    }

    private static String isUncle(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String fatherOfName2 = findFather(relationMap, personList, name2);
        String motherOfName2 = findMother(relationMap, personList, name2);
        if (isSibling(relationMap, personList, name1, fatherOfName2) != null || isSibling(relationMap, personList, name1, motherOfName2) != null) {
            String gender = getGender(personList, name1);
            if (gender.equals("man")) return "uncle";
        }

        return null;
    }

    private static String isAunt(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String fatherOfName2 = findFather(relationMap, personList, name2);
        String motherOfName2 = findMother(relationMap, personList, name2);
        String spouseOfName1 = findSpouse(relationMap, personList, name1);
        if (isSibling(relationMap, personList, spouseOfName1, fatherOfName2) != null || isSibling(relationMap, personList, spouseOfName1, motherOfName2) != null) return "aunt";

        return null;
    }

    private static String isNephew(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String fatherOfName1 = findFather(relationMap, personList, name1);
        String motherOfName1 = findMother(relationMap, personList, name1);
        if (isSibling(relationMap, personList, fatherOfName1, name2) != null || isSibling(relationMap, personList, motherOfName1, name2) != null) {
            String gender = getGender(personList, name1);
            return gender.equals("man") ? "nephew" : "niece";
        }
        return null;
    }

    private static String isNiece(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String fatherOfName1 = findFather(relationMap, personList, name1);
        String motherOfName1 = findMother(relationMap, personList, name1);
        String spouseOfName2 = findSpouse(relationMap, personList, name2);
        if (isSibling(relationMap, personList, fatherOfName1, spouseOfName2) != null || isSibling(relationMap, personList, motherOfName1, spouseOfName2) != null) {
            String gender = getGender(personList, name1);
            return gender.equals("man") ? "nephew" : "niece";
        }
        return null;
    }

    private static String isCousin(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String fatherOfName1 = findFather(relationMap, personList, name1);
        String motherOfName1 = findMother(relationMap, personList, name1);
        String fatherOfName2 = findFather(relationMap, personList, name2);
        String motherOfName2 = findMother(relationMap, personList, name2);
        if (isSibling(relationMap, personList, fatherOfName1, fatherOfName2) != null || isSibling(relationMap, personList, motherOfName1, motherOfName2) != null) return "cousin";
        return null;
    }

    private static String isFatherInLaw(Map<String, List<Tree>> relationMap, List<Person> personList, String name1,
            String name2) {
        String gender = getGender(personList, name1);
        String spouseOfName2 = findSpouse(relationMap, personList, name2);
        if (isFather(relationMap, personList, name1, spouseOfName2) != null) return gender.equals("man") ? "father-in-law" : "mother-in-law";
        return null;
    }

    private static String isMotherInLaw(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String gender = getGender(personList, name1);
        String spouseOfName2 = findSpouse(relationMap, personList, name2);
        if (isMother(relationMap, personList, name1, spouseOfName2) != null) return gender.equals("man") ? "father-in-law" : "mother-in-law";
        return null;
    }

    private static String isSonInLawOrDaughterInLaw(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String spouseOfName1 = findSpouse(relationMap, personList, name1);
        if (isFather(relationMap, personList, name2, spouseOfName1) != null) {
            String gender = getGender(personList, name1);
            return gender.equals("man") ? "son-in-law" : "daughter-in-law";
        }
        return null;
    }

    private static String isBrotherInLawOrSisterInLaw(Map<String, List<Tree>> relationMap, List<Person> personList, String name1, String name2) {
        String spouseOfName1 = findSpouse(relationMap, personList, name1);
        String spouseOfName2 = findSpouse(relationMap, personList, name2);
        if (spouseOfName1 == null || spouseOfName2 == null) return null;
        if (isSibling(relationMap, personList, spouseOfName1, spouseOfName2) != null || isSibling(relationMap, personList, name1, spouseOfName2) != null || isSibling(relationMap, personList, name2, spouseOfName1) != null) {
            return getGender(personList, name1).equals("man") ? "brother-in-law" : "sister-in-law";
        }
        return null;
    }

    // The methods listed below are used to identify the connection between two
    // people. Each method is evaluated in turn, and when a match is found, the
    // relevant relationship is returned.
    public static String findRelation(String name1, String name2, Map<String, List<Tree>> relationMap, List<Person> personList) { 
        if (personList.stream().filter(p -> p.getName().equals(name1)).count() == 0 || personList.stream().filter(p -> p.getName().equals(name2)).count() == 0) {
            return "PERSON_NOT_FOUND";
        }

        if (name1 == name2) return "SAME_PERSON";

        String[] relationshipArray = {
            isSpouse(relationMap, personList, name1, name2),
            isFather(relationMap, personList, name1, name2),
            isMother(relationMap, personList, name1, name2),
            isChild(relationMap, personList, name1, name2),
            isGrandParent(relationMap, personList, name1, name2),
            isGrandChild(relationMap, personList, name1, name2),
            isUncle(relationMap, personList, name1, name2),
            isAunt(relationMap, personList, name1, name2),
            isNephew(relationMap, personList, name1, name2),
            isNiece(relationMap, personList, name1, name2),
            isCousin(relationMap, personList, name1, name2),
            isFatherInLaw(relationMap, personList, name1, name2),
            isMotherInLaw(relationMap, personList, name1, name2),
            isSonInLawOrDaughterInLaw(relationMap, personList, name1, name2),
            isBrotherInLawOrSisterInLaw(relationMap, personList, name1, name2)
        };

        for (String relationship : relationshipArray) {
            if (relationship != null) return relationship;
        }

        return null;
    }
}