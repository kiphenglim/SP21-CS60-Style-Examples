#lang racket

(require rackunit)
(provide sum-of-squares square-of-sum difference-of-sequences)


;;;;;;;;;;;;;;;;;;;;;;
;;; sum-of-squares ;;;
;;;;;;;;;;;;;;;;;;;;;;

;;; Computes the sum of squares of numbers from 1 to n.
;;; 
;;; inputs: n - integer maximum element in the sequence
;;; output: 1^2 + 2^2 + ... + n^2
(define (sum-of-squares n)
  (if (equal? n 1)
    1
    (+ (* n n) (sum-of-squares (- n 1)))))

;;; Given tests
(check-equal? (sum-of-squares 5) 55)
(check-equal? (sum-of-squares 10) 385)
(check-equal? (sum-of-squares 100) 338350)

;;; Additional student tests
(check-equal? (sum-of-squares 1) 1)
(check-equal? (sum-of-squares 2) 5)
(check-equal? (sum-of-squares 3) 14)


;;;;;;;;;;;;;;;;;;;;;
;;; square-of-sum ;;;
;;;;;;;;;;;;;;;;;;;;;

;;; Computes the square of the sum of numbers from 1 to n.
;;; 
;;; inputs: n - integer maximum element in the sequence
;;; output: (1 + 2 + ... + n)^2
(define (square-of-sum n)
  (let ([sum (for/sum
               ([i (in-range (add1 n))]) i)])
    (* sum sum)))

;;; Given tests
(check-equal? (square-of-sum 5) 225)
(check-equal? (square-of-sum 10) 3025)
(check-equal? (square-of-sum 100) 25502500)

;;; Additional student tests
(check-equal? (square-of-sum 1) 1)
(check-equal? (square-of-sum 2) 9)
(check-equal? (square-of-sum 3) 36)


;;;;;;;;;;;;;;;;;;
;;; difference ;;;
;;;;;;;;;;;;;;;;;;

;;; Computes the difference between the square of sums and the sum of squares
;;; for a sequence from 1 to n.
;;; 
;;; inputs: n - integer maximum element in the sequence
;;; outputs: the difference between (square-of-sum n) and (sum-of-squares n)
(define (difference-of-sequences n)
  (- (square-of-sum n) (sum-of-squares n)))


;;; Given tests
(check-equal? (difference-of-sequences 5) 170)
(check-equal? (difference-of-sequences 10) 2640)
(check-equal? (difference-of-sequences 100) 25164150)

;;; Additional student tests
(check-equal? (difference-of-sequences 1) 0)
(check-equal? (difference-of-sequences 2) 4)
(check-equal? (difference-of-sequences 3) 22)
