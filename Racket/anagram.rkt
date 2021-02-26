#lang racket

(require rackunit)
(provide anagrams-for)

;;; Finds the subset of a list of strings that are an anagram of a given word.
;;; 
;;; inputs: subject - the word we are checking against
;;;         candidates - a list whose elements are strings
;;; output: a subset of candidates whose elements are anagrams of subject
(define (anagrams-for subject candidates)
  (filter (lambda (w) (anagram? w subject)) candidates))

;;: Checks if word1 is an anagram of word2
;;; 
;;; inputs: word1 - a potential anagram
;;;         word2 - the word we are checking against
;;; output: #t if word1 is an anagram of word2
(define (anagram? word1 word2)
  (define (sorted-string s)
    (list->string (sort (string->list s) char-ci<?)))
  (string-ci=? (sorted-string word1) (sorted-string word2)))


;;; Given tests
(check-equal? (anagrams-for "diaper" '("hello" "world" "zombies" "pants"))
              '())
(check-equal? (anagrams-for "ant" '("tan" "stand" "at"))
              '("tan"))
(check-equal? (anagrams-for "galea" '("eagle"))
              '())
(check-equal? (anagrams-for "good" '("dog" "goody"))
              '())

;;; Additional student tests
(check-true (anagram? "" ""))
(check-true (anagram? "a" "a"))
(check-true (anagram? "ab" "ba"))
(check-false (anagram? "a" "b"))
(check-false (anagram? "ab" "b"))

(check-equal? (anagrams-for "" '("")) '(""))
(check-equal? (anagrams-for "a" '("a")) '("a"))
(check-equal? (anagrams-for "a" '("a" "a")) '("a" "a"))
(check-equal? (anagrams-for "ab" '("ab" "ba")) '("ab" "ba"))
