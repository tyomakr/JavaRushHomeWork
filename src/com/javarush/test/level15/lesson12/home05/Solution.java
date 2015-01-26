package com.javarush.test.level15.lesson12.home05;

/* Перегрузка конструкторов
1. В классе Solution создайте по 3 конструктора для каждого модификатора доступа.
2. В отдельном файле унаследуйте класс SubSolution от класса Solution.
3. Внутри класса SubSolution создайте конструкторы командой Alt+Insert -> Constructors.
4. Исправьте модификаторы доступа конструкторов в SubSolution так, чтобы они соответствовали конструкторам класса Solution.
*/

public class Solution {
    public Solution(Object pub1) {}
    public Solution(String pub2) {}
    public Solution(Integer pub3) {}

    protected Solution(Character prot1) {}
    protected Solution(Double prot2) {}
    protected Solution(Exception prot3) {}

    private Solution(Number priv1) {}
    private Solution(Boolean priv2) {}
    private Solution(Float priv3) {}

    Solution(int def1) {}
    Solution(Byte def2) {}
    Solution(Short def3) {}







}

