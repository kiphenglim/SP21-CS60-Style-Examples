# CS60 Style Examples

Hello CS060'ers! We received feedback from students that some of the style
guidelines could benefit from examples! Here are some examples that fit the
convention guidelines for the Spring 2021 CS60 course at Harvey Mudd College.

## Racket

We have provided two examples of complete Racket files (you can run them on
your own machine!) that demonstrate good style and good tests.

`anagram.rkt` contains a function `anagram?` that returns true if two words
are anagrams of each other and a function `anagram-for` that uses a
higher-order function to filter a list based on whether an element is an
anagram of a given input. This is a relatively short file, so there isn't
special formatting here.

`sum-of-squares.rkt` contains several functions. These are `sum-of-squares`,
`square-of-sum`, and `difference-of-sequences`. Since there are more
functions, this file groups the functions and their tests into the same area
and also introduces function headers, which can be useful to visually mark the
code blocks for more complex files.

The code files for these style examples are modified from
[@exercism/racket](https://github.com/exercism/racket) on GitHub under the MIT
License.

## Java

There are three total Java files that have been provided. 

`Heap.java` is a class that implements a min-heap data structure. This file
demonstrates conventions you will encounter throughout the rest of the class.

`Hash.java` is an interface and `HashProbe.java` is a class that implements
`Hash.java`. If you don't know what this means yet, don't worry! You will
learn more about inheritance and other object-oriented concepts later in the
class.

These files are implementing data structures that are outside the scope of
this class. You are not expected to understand any details about these
implementations. Additionally, none of these classes have main functions and
will not run without modifications.

There are a couple of ``meta notes'' that are scattered throughout the files.
These are NOT part of the conventions and are only included to draw attention
to certain decisions that were made during the coding process.
