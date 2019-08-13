package fizzbuzz;

public class FizzBuzzKata {

    public String fizzBuzzKataMethod(int number) {

        String result = "";
        if (number % 3 == 0 && number % 5 == 0) result = "FizzBuzz";
        else if (number % 3 == 0) result = "Fizz";
        else if (number % 5 == 0) result = "Buzz";
        else result = number + "";
        return result;
    }
}