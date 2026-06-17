public class StringCodes {

}
//common string method
// .length() returns the no of characters in a string for e.g (java).length = 4
// .charArt gets the character at a specific index (java).charArt(2) = 4
// .toUpperCase converts a string to upper case e.g (hello).toUpperCase = "HELLO"
// .trim removes leading and trailing(blank spaces before the first word and after the last) spaces e.g "  Hello World  " = "Hello World"
// .contains(str) checks if a substring exists .e.g "Hello".contains ("l")= true
// .replace (a,b) is used to replace character "apple".replace
// .split splits into an array "one, two".split (",") =(split anywhere , appears resulting into multiple arrays)
// .indexOf find index of first occurrence "Hello".indexOf("e")= 1
// .substring used to extract part of a string
// string builder ans=d string buffer
// since string is immutable modifying it// many times can create unnecessary objects
// string builders and string buffer allow modification without creating new `object
// when to use string , string builder and buffer
// if a string is going to remain constant throughout the program then use the string class
// objects because a string object is immutable if a string can change (e.g lots of logic and
// operations in the construction of the string
// and will only be accessed from a single thread using a string is a good idea
// if a string can change and will be accessed for multiple threads use a string buffer
//                         Regex
//this is a special pattern used to find,match,replace text they are used for pattern and text manipulation a regular expression can be a single character or more complicated pattern
//a regex pattern is made up of special symbols that tell the computer what to find
//reasons for regex application
//1. finding specific text e.g searching specific text in a document
//validating input e.g checking the accuracy of an email
//replacing text e.g replacing all spaces with a dash
// NOTE: data doesn't have a regular expression class
// But we can import the java.util.regexpackage
//to work with regular Expression
//the package includes the following classes
//1.pattern - defines regex pattern
//2.matcher - locates matches in a text
//3.matches - checks if the whole text matches the pattern
//find - locates occurrences of the pattern in a text
//5.group - locates matched texts
//PatternSyntaxException - Indicates syntax error in a regex patter
//Step by step breakdown of regex
//1.u must first define a pattern using Pattern.compile
//understanding Matcher.find()(finding multiple matches)-the find method doesnt stop at a single match
//Using matches(full string matching )if u want to check if a whole string matches a pattern use matches
//using special characters(Meta character):Regex allows you to search for patterns using special symbols