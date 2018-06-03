;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-reader.ss" "lang")((modname quiz) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(require 2htdp/image)

;PROBLEM:
;
;Design a function that consumes two images and produces true if the first is larger than the second.
;
;Complete your design using DrRacket. When you are done, you must submit something in this box in order to unlock the assessment rubric, but when you are doing your assessment, grade your submission in DrRacket where indentation and formatting will be preserved.
;
;Be sure to watch the evaluation video before completing your assessment.

;Define examples, wrap each in check-expect.
(check-expect (larger? (rectangle 2 3 "solid" "red") (rectangle 1 2 "solid" "red"))
              true)
(check-expect (larger? (rectangle 2 3 "solid" "red") (rectangle 4 5 "solid" "red"))
              false)
(check-expect (larger? (rectangle 2 3 "solid" "red") (rectangle 2 3 "solid" "red"))
              false)
(check-expect (larger? (rectangle 2 3 "solid" "red") (rectangle 3 2 "solid" "red"))
              false)
(check-expect (larger? (rectangle 2 3 "solid" "red") (rectangle 1 6 "solid" "red"))
              false)
(check-expect (larger? (rectangle 2 3 "solid" "red") (rectangle 5 1 "solid" "red"))
              true)
(check-expect (larger? (rectangle 2 3 "solid" "red") (circle 1 "solid" "red"))
              true)
;Signature, purpose and stub.
;; Images -> Boolean
;; produce true if the area of the first image is larger than the second image
;; (define (larger? img1 img2) false)    ; stub

;Template and inventory.
;(define (larger? img1 img2)
;  (... img1 img2))

;Code the function body.
(define (larger? img1 img2)
  (> (* (image-width img1) (image-height img1))
     (* (image-width img2) (image-height img2))))

;Test and debug until correct