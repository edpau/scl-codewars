# Scala Codewars Solutions

This repository contains my solutions to various [Codewars](https://www.codewars.com) challenges, written in **Scala** as part of my practice to improve problem-solving skills and learn functional programming concepts.

---

## Challenges

| No | Name                                                                                                                  | kyu | File Path                                                                                 | Related Topic                                                                | Test File                                                                                   | Note                                                                |
|----|-----------------------------------------------------------------------------------------------------------------------|-----|-------------------------------------------------------------------------------------------|------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------|---------------------------------------------------------------------|
| 1  | [Currying functions: multiply all elements in an array](https://www.codewars.com/kata/586909e4c66d18dd1800009b/scala) | 7   | [MultiplyAll.scala](./src/main/scala/MultiplyAll.scala)                                   | Currying, Higher-Order Functions                                             | [MultiplyAllSpec.scala](./src/test/scala/MultiplyAllSpec.scala)                             |                                                                     |
| 2  | [Odd or Even?](https://www.codewars.com/kata/5949481f86420f59480000e7/train/scala)                                    | 7   | [OddOrEven.scala](./src/main/scala/OddOrEven.scala)                                       | Arithmetic, Modulus                                                          | [OddEvenSpec.scala](./src/test/scala/OddEvenSpec.scala)                                     |                                                                     |
| 3  | [Find the odd int](https://www.codewars.com/kata/54da5a58ea159efa38000836/train/scala)                                | 6   | [FindTheOddInt.scala](./src/main/scala/FindTheOddInt.scala)                               | Counting, Collections                                                        | [FindTheOddIntSpec.scala](./src/test/scala/FindTheOddIntSpec.scala)                         |                                                                     |
| 4  | [Descending Order](https://www.codewars.com/kata/5467e4d82edf8bbf40000155)                                            | 7   | [DescendingOrder.scala](./src/main/scala/DescendingOrder.scala)                           | Sorting, Number Manipulation                                                 | —                                                                                           |                                                                     |
| 5  | [Your order, please](https://www.codewars.com/kata/55c45be3b2079eccff00010f/train/scala)                              |     | [YourOrderPlease.scala](./src/main/scala/YourOrderPlease.scala)                           | String Manipulation, Sorting                                                 | —                                                                                           |                                                                     |
| 6  | [Find the first non-consecutive number](https://www.codewars.com/kata/58f8a3a27a5c28d92e000144/train/scala)           | 8   | [FirstNonConsecutive.scala](./src/main/scala/FirstNonConsecutive.scala)                   | Sequences, Pattern Matching                                                  | [FindNonConsecutiveSpec.scala](./src/test/scala/FindNonConsecutiveSpec.scala)               |                                                                     |
| 7  | [Return Negative](https://www.codewars.com/kata/55685cd7ad70877c23000102/train/scala)                                 | 8   | [Negative.scala](./src/main/scala/Negative.scala)                                         | Arithmetic                                                                   | —                                                                                           |                                                                     |
| 8  | [Remove First and Last Character](https://www.codewars.com/kata/56bc28ad5bdaeb48760009b0/solutions/scala)             | 8   | [RemoveFirstAndLastCharacters.scala](./src/main/scala/RemoveFirstAndLastCharacters.scala) | String Manipulation, Guards, Pattern Matching                                | [RemoveFirstAndLastCharactersSpec](./src/test/scala/RemoveFirstAndLastCharactersSpec.scala) |                                                                     |
| 9  | [Abbreviate a Two Word Name](https://www.codewars.com/kata/57eadb7ecd143f4c9c0000a3/scala)                            | 8   | [AbbrevName.scala](./src/main/scala/AbbrevName.scala)                                     | String Manipulation, Collection Transformation, Functional Composition       | -                                                                                           |                                                                     |
| 10 | [Even or Odd](https://www.codewars.com/kata/53da3dbb4a5168369a0000fe/train/scala)                                     | 8   | [EvenOrOdd.scala](./src/main/scala/EvenOrOdd.scala)                                       | Arithmetic Operations, Conditional Expressions, Expression-Based Programming | -                                                                                           |                                                                     |
| 11 | [Square Every Digit](https://www.codewars.com/kata/546e2562b03326a88e000020/scala)                                    | 7   | [SquareDigits.scala](./src/main/scala/SquareDigits.scala)                                 | Digit Manipulation, FoldLeft, Functional Style                               | -                                                                                           | Lean Sealed Traits for Domain Errors, BigInt vs Int Overflow Safety |                        
| 12 | [Sum of two lowest positive integers](https://www.codewars.com/kata/558fc85d8fd1938afb000014/scala)                   | 7   | [SumTwoSmallest.scala](./src/main/scala/SumTwoSmallest.scala)                             | Error Handling, FoldLeft, Min Search, Domain Errors                          | -                                                                                           |                                                                     |
| 13 | [Jaden Casing Strings](https://www.codewars.com/kata/5390bac347d09b7da40006f6/scala)                                  | 7   | [JadenCasing.scala](./src/main/scala/JadenCasing.scala)                                   | String manipulation, Implicits / Extensions                                  | _                                                                                           |                                                                     |

## How to Run Tests

### 1. Add ScalaTest to `build.sbt`

Latest stable version: **3.2.19**  
(From [Maven Repository](https://mvnrepository.com/artifact/org.scalatest/scalatest/3.2.19))

```scala
libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.19" % Test
```

---

### 2. Run All Tests

```bash
sbt test
```

---

### 3. Run a Specific Test

Example: Run only the **MultiplyAll** tests

```bash
sbt "testOnly *MultiplyAllSpec"
```

---

