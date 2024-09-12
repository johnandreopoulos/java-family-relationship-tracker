# Family Relationship Finder

**Note**: Although the code may not follow the highest programming standards, it has been thoroughly tested and functions as expected. Ensure the file path for "tree.csv" is correctly specified in the code for proper functionality.

## Introduction

This project, created for a college assignment, involves reading and manipulating data from a CSV file containing family information. Developed in Java, the project allows users to explore relationships among family members and manage data efficiently. Issues or suggestions for improvements can be reported [here](https://github.com/JohnAndreop/Family-Tree-Relationship-finder/issues).

---

### [Java Code](https://github.com/JohnAndreop/Family-Tree-Relationship-finder/blob/main/App.java)

The Java application features a menu enabling users to:

- Find relationships between individuals
- Sort names lexicographically into a new file
- Clear the console
- Exit the program

The code processes data from a CSV file, which includes names, genders, and relationships among family members.

#### Example Usage:

```java
findRelation("Steffon Baratheon", "Robert Baratheon", relationMap, personList);
```
Returns: `Steffon Baratheon is father of Robert Baratheon`

```java
findRelation("Steffon Baratheon", "Selyse Baratheon", relationMap, personList);
```
Returns: `Steffon Baratheon is father-in-law of Selyse Baratheon`

---

## Conclusion

This project showcases the ability to read and manipulate CSV data using Java, providing a user-friendly interface and various functionalities for managing family relationships. The Java application is designed specifically for the House of Baratheon and may require adjustments to work with other family trees.

---

#### [CSV File](https://github.com/JohnAndreop/Family-Tree-Relationship-finder/blob/main/tree.csv)

```
Steffon Baratheon, man
Cassana Estermont, woman
Robert Baratheon, man
Cersei Lannister, woman
Stannis Baratheon, man
Selyse Baratheon, woman
Renly Baratheon, man
Margaery Tyrell, woman
Gendry, man
Joffrey Baratheon, man
Myrcella Baratheon, woman
Tommen Baratheon, man
Shireen Baratheon, woman
Steffon Baratheon, husband, Cassana Estermont
Steffon Baratheon, father, Robert Baratheon
Steffon Baratheon, father, Stannis Baratheon
Steffon Baratheon, father, Renly Baratheon
Cassana Estermont, mother, Robert Baratheon
Cassana Estermont, mother, Stannis Baratheon
Cassana Estermont, mother, Renly Baratheon
Robert Baratheon, husband, Cersei Lannister
Robert Baratheon, father, Gendry
Robert Baratheon, father, Joffrey Baratheon
Robert Baratheon, father, Myrcella Baratheon
Robert Baratheon, father, Tommen Baratheon
Cersei Lannister, mother, Gendry
Cersei Lannister, mother, Joffrey Baratheon
Cersei Lannister, mother, Myrcella Baratheon
Cersei Lannister, mother, Tommen Baratheon
Stannis Baratheon, husband, Selyse Baratheon
Stannis Baratheon, father, Shireen Baratheon
Renly Baratheon, husband, Margaery Tyrell
Selyse Baratheon, mother, Shireen Baratheon
```

![image](https://user-images.githubusercontent.com/39243722/213921106-feebeeec-cec4-40cf-8680-a1a5e3bbd386.png)

The project processes a CSV file with the House of Baratheon family details, including names, genders, and relationships. While the code is designed for this specific family, it may need modifications for other family trees.
