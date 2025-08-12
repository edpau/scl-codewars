# Scala Codewars Solutions

This repository contains my solutions to various [Codewars](https://www.codewars.com) challenges, written in **Scala** as part of my practice to improve problem-solving skills and learn functional programming concepts.

---

## Challenges

| Name                                                                                                                  | kyu | File Path                                                                                 | Related Topic                                                                | Test File                                                                                   |
|-----------------------------------------------------------------------------------------------------------------------|-----|-------------------------------------------------------------------------------------------|------------------------------------------------------------------------------|---------------------------------------------------------------------------------------------|
| [Currying functions: multiply all elements in an array](https://www.codewars.com/kata/586909e4c66d18dd1800009b/scala) | 7   | [MultiplyAll.scala](./src/main/scala/MultiplyAll.scala)                                   | Currying, Higher-Order Functions                                             | [MultiplyAllSpec.scala](./src/test/scala/MultiplyAllSpec.scala)                             |
| [Odd or Even?](https://www.codewars.com/kata/5949481f86420f59480000e7/train/scala)                                    | 7   | [OddOrEven.scala](./src/main/scala/OddOrEven.scala)                                       | Arithmetic, Modulus                                                          | [OddEvenSpec.scala](./src/test/scala/OddEvenSpec.scala)                                     |
| [Find the odd int](https://www.codewars.com/kata/54da5a58ea159efa38000836/train/scala)                                | 6   | [FindTheOddInt.scala](./src/main/scala/FindTheOddInt.scala)                               | Counting, Collections                                                        | [FindTheOddIntSpec.scala](./src/test/scala/FindTheOddIntSpec.scala)                         |
| [Descending Order](https://www.codewars.com/kata/5467e4d82edf8bbf40000155)                                            | 7   | [DescendingOrder.scala](./src/main/scala/DescendingOrder.scala)                           | Sorting, Number Manipulation                                                 | —                                                                                           |
| [Your order, please](https://www.codewars.com/kata/55c45be3b2079eccff00010f/train/scala)                              |     | [YourOrderPlease.scala](./src/main/scala/YourOrderPlease.scala)                           | String Manipulation, Sorting                                                 | —                                                                                           |
| [Find the first non-consecutive number](https://www.codewars.com/kata/58f8a3a27a5c28d92e000144/train/scala)           | 8   | [FirstNonConsecutive.scala](./src/main/scala/FirstNonConsecutive.scala)                   | Sequences, Pattern Matching                                                  | [FindNonConsecutiveSpec.scala](./src/test/scala/FindNonConsecutiveSpec.scala)               |
| [Return Negative](https://www.codewars.com/kata/55685cd7ad70877c23000102/train/scala)                                 | 8   | [Negative.scala](./src/main/scala/Negative.scala)                                         | Arithmetic                                                                   | —                                                                                           |
| [Remove First and Last Character](https://www.codewars.com/kata/56bc28ad5bdaeb48760009b0/solutions/scala)             | 8   | [RemoveFirstAndLastCharacters.scala](./src/main/scala/RemoveFirstAndLastCharacters.scala) | String Manipulation, Guards, Pattern Matching                                | [RemoveFirstAndLastCharactersSpec](./src/test/scala/RemoveFirstAndLastCharactersSpec.scala) |
| [Abbreviate a Two Word Name](https://www.codewars.com/kata/57eadb7ecd143f4c9c0000a3/scala)                            | 8   | [AbbrevName.scala](./src/main/scala/AbbrevName.scala)                                     | String Manipulation, Collection Transformation, Functional Composition       | -                                                                                           |
| [Even or Odd](https://www.codewars.com/kata/53da3dbb4a5168369a0000fe/train/scala)                                     | 8   | [EvenOrOdd.scala](./src/main/scala/EvenOrOdd.scala)                                       | Arithmetic Operations, Conditional Expressions, Expression-Based Programming | -                                                                                           |

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

