;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-reader.ss" "lang")((modname increasing-list-of-nums) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
;; ListOfNumber -> ListOfNumber
;; sort the numbers in lon in increasing order
;(check-expect (sort-lon empty) empty)
;(check-expect (sort-lon (list 1)) (list 1))
;(check-expect (sort-lon (list 1 2 3)) (list 1 2 3))
;(check-expect (sort-lon (list 2 1 3)) (list 1 2 3))
;(check-expect (sort-lon (list 3 2 1)) (list 1 2 3))


                 
;; Number ListOfNumber -> ListOfNumber
;; insert n in proper position in lon
;; ASSUME: lon is sorted in increasing order
(check-expect (insert 2 empty) (list 2))
(check-expect (insert 2 (list 1 3)) (list 1 2 3))

(define (insert n lon)
  (local [(define (sort-lon lon)
            (cond [(empty? lon) empty]
                  [else (insert (first lon)
                                (sort-lon (rest lon)))]))
          (define sorted-lon (sort-lon lon))]
    (cond [(empty? sorted-lon) (cons n empty)]
          [else
           (if (> (first sorted-lon) n)
               (cons n sorted-lon)
               (cons (first sorted-lon) (insert n (rest sorted-lon))))])))