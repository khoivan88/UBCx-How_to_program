;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-intermediate-lambda-reader.ss" "lang")((modname ta-solver-prob2-temp) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(require racket/list)
(define-struct ta (name max avail))
;; TA is (make-ta String Natural (listof Slot))
;; interp. the TA's name, number of slots they can work, and slots they're available for

(define SOBA (make-ta "Soba" 2 (list 1 3)))
(define UDON (make-ta "Udon" 1 (list 3 4)))
(define RAMEN (make-ta "Ramen" 1 (list 2)))
(define NOODLE-TAs (list SOBA UDON RAMEN))


(define-struct assignment (ta slot))

(check-expect (schedule-tas NOODLE-TAs (list 1 2 3 4)) 
              (list
               (make-assignment UDON 4)
               (make-assignment SOBA 3)
               (make-assignment RAMEN 2)
               (make-assignment SOBA 1)))

(define (schedule-tas tas slots)
  (cond [(empty? slots) empty]
        [(empty? tas) false]
        [else
         ;; rsf is (listof Assignment)
         (local [(define (schedule-tas tas slots rsf original-tas)
                   (cond [(empty? slots) rsf]
                         [else
                          (local [(define result (some-fn tas (first slots) empty original-tas))]
                            (if (false? result)
                                false
                                (schedule-tas (rest result) (rest slots) (cons (first result) rsf) original-tas)))]))
                 (define (some-fn tas slot avail-tas original-tas)
                   ;; result of this is: one of
                   ;;  - false: no TA available for that slot
                   ;;  - rsf is the Assignment
                   ;; avail-tas is the TA still available after assignment (would be the same as tas if no assignment is available)
                   ;; original-tas is a list of TAs with their original info
                   (cond [(empty? tas) false]
                         [(member slot (ta-avail (first tas))) 
                          (if (> (ta-max (first tas)) 1)
                              (cons (make-assignment (find-ta-info (first tas) original-tas) slot)
                                    (cons (make-ta (ta-name (first tas))
                                                   (sub1 (ta-max (first tas)))
                                                   (filter (λ (x) (not (equal? slot x))) (ta-avail (first tas))))
                                          (append avail-tas (rest tas))))
                              (cons (make-assignment (find-ta-info (first tas) original-tas) slot)
                                    (append avail-tas (rest tas))))]
                         [else
                          (some-fn (rest tas) slot (append avail-tas (list (first tas))) original-tas)]))
                 ;; find-ta-info ta tas: given a ta, if ta-name is in tas, return the info of the ta in the tas list
                 ;; TA (listof TAs) -> TA
                 (define (find-ta-info ta tas)
                   (cond [(empty? tas) empty]
                         [else
                          (if (string=? (ta-name ta) (ta-name (first tas)))
                              (first tas)
                              (find-ta-info ta (rest tas)))]))]
           (schedule-tas tas slots empty tas))]))

(define Erika (make-ta "Erika" 1 (list 1 3 7 9)))
(define Ryan (make-ta "Ryan" 1 (list 1 8 10)))
(define Reece (make-ta "Reece" 1 (list 5 6)))
(define Gordon (make-ta "Gordon" 2 (list 2 3 9)))
(define David (make-ta "David" 2 (list 2 8 9)))
(define Katie (make-ta "Katie" 1 (list 4 6)))
(define Aashish (make-ta "Aashish" 2 (list 1 10)))
(define Grant (make-ta "Grant" 2 (list 1 11)))
(define Raeanne (make-ta "Raeanne" 2 (list 1 11 12)))

(define QUIZ-TAs (list Erika Ryan Reece Gordon David Katie Aashish Grant Raeanne))

(check-expect (schedule-tas QUIZ-TAs (list 1 2 3 4 5 6 7 8 9 10 11 12)) false)
(check-expect (schedule-tas QUIZ-TAs (list 1 2 3 4 5 6)) false)
(check-expect (schedule-tas (list Ryan Reece) (list 5 6)) false)