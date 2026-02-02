## Assignment 1 Turn 1
```markdown
@author Omkar Anil Gajare
@uid 2025300063
```
#### Question 1
Write a Java program that:
Prints your firstname, middlename, and lastname

![image](https://hackmd.io/_uploads/rya0hOvU-l.png)
```java
/**
 * @brief Prints my first name ,middle name and last name.
 * @author Omkar Gajare
 * @date 28-1-26
 * @
 */
public class fullname
{
    public static void main(String args[]){
        System.out.println("Omkar Anil Gajare 2025300063");
        System.out.println("First Name: Omkar");
        System.out.println("Middle Name: Anil");
        System.out.println("Last Name: Gajare");
    }
}
```

#### Question 2
Write a Java program that:
Accepts exactly three command-line arguments
Displays the total number of arguments
Prints the first, second, and third arguments explicitly with descriptive text

![image](https://hackmd.io/_uploads/rJO8AdPLWg.png)


```java    

/**
 * @brief Prints arguements from an args array of size 3.
 * @author Omkar Anil Gajare
 * @date 28-1-26
 */
public class ArgumentPrinter
{
    public static void main(String args[]){
        System.out.println("Omkar Anil Gajare 2025300063");
        int count = args.length;
        System.out.println("Number of arguement: " + count);
        System.out.println("First arguement: " + args[0]);//Prints the first element of args
        System.out.println("Second arguement: " + args[1]);//Prints the second element of args
        System.out.println("Third arguement: " + args[2]);//Prints the third element of args
        System.out.println("Omkar Anil Gajare 2025300063");
    }
}
```

#### Question 3
![image](https://hackmd.io/_uploads/SkdkRuwUZx.png)

```java

/**
 * @brief This program accepts 3 words describing java and prints them in a complete sentence.
 *
 * @author  Omkar Anil Gajare
 * @date 28-1-26
 */
public class JavaDescriber
{
    public static void main(String args[]){
        System.out.println("Omkar Anil Gajare 2025300063");
        System.out.println("Java is " + args[0] + "," + args[1] + " and " + args[2]);
        System.out.println("Omkar Anil Gajare 2025300063");
    }
}
```


#### Question 4
Design a Java application that:
Accepts three opinions about Java
Prints:The first argument in uppercase
The second argument in lowercase
The third argument as-is
You may use toUpperCase(),toLowerCase()functions
![image](https://hackmd.io/_uploads/S1O6adPLWe.png)

```java

/**
 * @brief This program formats the input such that first is print in uppercase, second in lowercase and third as is.
 *
 * @author Omkar Anil Gajare
 * @date 28-1-26
 */
public class OutputFormatter
{
    public static void main(String args[]){
        System.out.println("Omkar Anil Gajare 2025300063");
        System.out.println("Formatted Output: ");
        System.out.println(args[0].toUpperCase());//.toUpperCase() converts string to uppercase
        System.out.println(args[1].toLowerCase());//.toLowerCase() converts string to lowercase
        System.out.println(args[2]);//Prints element as is.
        System.out.println("Omkar Anil Gajare 2025300063");
    }
}
```
```