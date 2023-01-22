# Family Relationship Finder
- Note: While the codes may not adhere to the highest standards of programming practices, they have been thoroughly tested and have been confirmed to function correctly.

> To ensure proper functionality, it is crucial that the file path for "tree.csv" is correctly incorporated into the code.

## Introduction:
This project was developed for a college assignment with the purpose of reading and manipulating data from a CSV file containing information about family members. The code for this project is written in Java, and any issues or potential improvements can be discussed by opening an [issue](https://github.com/JohnAndreop/Family-Tree-Relationship-finder/issues).

---

### [Java Code](https://github.com/JohnAndreop/Family-Tree-Relationship-finder/blob/main/App.java)
> The Java code includes a menu that allows the user to perform various tasks such as finding a relationship between two individuals, ordering the names lexicographically into a new file, clearing the console, and exiting the program. Additionally, the Java code can read the data from a CSV file which contains information about the family members such as their names, gender and their known relationship to one another.

#### Example 1: 
```js
findRelation("Steffon Baratheon", "Robert Baratheon", relationMap, personList);
```
Returns: `Steffon Baratheon is father of Robert Baratheon`

#### Example 2: 
```js
findRelation("Steffon Baratheon", "Selyse Baratheon", relationMap, personList);
```
Returns: `Steffon Baratheon is father-in-law of Selyse Baratheon`

---

## Conclusion:
Overall, this project demonstrates the ability to read and manipulate data from a CSV file and perform various tasks using Java. While the Java code provides a user-friendly interface and multiple functionalities.

--- 

#### [CSV FILE](https://github.com/JohnAndreop/Family-Tree-Relationship-finder/blob/main/tree.csv)
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


The project utilizes a CSV file containing information about the House of Baratheon family. The data includes the name, gender, and known relationships of each family member. The Java code is able to read and process this information, allowing the user to perform various tasks such as finding relationships between individuals and ordering the names lexicographically. However, it should be noted that the code is specifically tailored for the House of Baratheon family and may not function correctly for other family trees. While there may be some issues when using the Java code for other families, it is believed that these issues will be minimal.
