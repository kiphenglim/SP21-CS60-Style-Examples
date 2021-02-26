#lang racket

(provide sum-of-squares square-of-sum difference)

;;; Computes the sum of squares of numbers from 1 to n.
;;; 
;;; inputs: n - integer maximum element in the sequence
;;; output: 1^2 + 2^2 + ... + n^2
(define (sum-of-squares n)
  (if (equal? n 1)
    1
    (+ (* n n) (sum-of-squares (- n 1)))))

;;; Computes the square of the sum of numbers from 1 to n.
;;; 
;;; inputs: n - integer maximum element in the sequence
;;; output: (1 + 2 + ... + n)^2
(define (square-of-sum n)
  (let ([sum (for/sum
               ([i (in-range (add1 n))]) i)])
    (* sum sum)))

;;; Computes the difference between the square of sums and the sum of squares
;;; for a sequence from 1 to n.
;;; 
;;; inputs: n - integer maximum element in the sequence
;;; outputs: the difference between (square-of-sum n) and (sum-of-squares n)
(define (difference n)
  (- (square-of-sum n) (sum-of-squares n)))
