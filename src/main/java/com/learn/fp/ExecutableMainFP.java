/**
 * 
 */
package com.learn.fp;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * @author mpanchapakesan
 *
 */
public class ExecutableMainFP {

    /**
     * @param args
     */
    public static void main(String[] args) {
        doMath();
    }

    private static void doMath() {
        Function<Integer, Integer> addNumbers = x -> x + 1;
        Function<Integer, Integer> addTwice = x -> x + 2;

        Function<Integer, Integer> multiplyTwice = x -> x * 2;
        //Function<Integer, Integer> addOnce = x -> x * 2; 
        Function<Integer, Integer> multiplyThrice = x -> x * 3;
        Function<Integer, String> multiplyWithStringOutput = x -> x * x + " plus this string";
        int addCountWithAndThen = addNumbers.andThen(addNumbers).apply(4);
        int addCount = addNumbers.apply(4);
        System.out.println("composed :: "+addTwice.compose(multiplyThrice).andThen(multiplyTwice).apply(10));
        String outputValMulti = addNumbers.andThen(multiplyWithStringOutput).apply(5);
        System.out.println(" addCount value in doMath method " + addCount);
        System.out.println(" addCountWithAndThen value in doMath method " + addCountWithAndThen);
        System.out.println(" multiplyWithStringOutput value in doMath method " + outputValMulti);
        //compose function example

        int outputVal = addNumbers.compose(multiplyThrice).andThen(multiplyThrice).apply(4);
        int outputVal1 = addNumbers.andThen(multiplyThrice).apply(4);
        System.out.println("outputVal for compose function is " + outputVal + "outputVal for andThen is " + outputVal1);
        invokeBiFunctions();
    }

    private Integer printStuff(Function<Integer, Integer> addNumbers) {
        System.out.println("print me from printStuff method");
        return addNumbers.apply(1);
    }

    private static void invokeBiFunctions() {
        BiFunction<String, List<Article>, List<Article>> byName = (name, articles) -> articles.stream()
            .filter(a -> a.getName().equals(name)).collect(Collectors.toList());
        Article article = new Article();
        Article article1 = new Article();
        Article article2 = new Article();
        article.setName("Manoj");
        article1.setName("Srikar");
        article2.setName("Manoj");
        List<Article> articleListFromSource = new ArrayList<Article>();
        articleListFromSource.add(article);
        articleListFromSource.add(article1);
        articleListFromSource.add(article2);
        List<Article> articleList = byName.apply("Manoj", articleListFromSource);
        articleList.toString();
        
        articleList.size();
        
    }
}
