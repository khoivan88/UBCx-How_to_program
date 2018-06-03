;; The first three lines of this file were inserted by DrRacket. They record metadata
;; about the language level of this file in a form that our tools can easily process.
#reader(lib "htdp-beginner-abbr-reader.ss" "lang")((modname space-invaders-starter) (read-case-sensitive #t) (teachpacks ()) (htdp-settings #(#t constructor repeating-decimal #f #t none #f () #f)))
(require 2htdp/universe)
(require 2htdp/image)

;; Space Invaders


;; Constants:

(define WIDTH  300)
(define HEIGHT 500)

(define INVADER-X-SPEED 1.5)  ;speeds (not velocities) in pixels per tick
(define INVADER-Y-SPEED 1.5)
(define TANK-SPEED 2)
(define MISSILE-SPEED 10)

(define HIT-RANGE 10)

(define INVADE-RATE 280)
(define RANDOM-RATE 1)    ;invader show up 1% of the stick

(define BACKGROUND (empty-scene WIDTH HEIGHT))

(define INVADER
  (overlay/xy (ellipse 10 15 "outline" "blue")              ;cockpit cover
              -5 6
              (ellipse 20 10 "solid"   "blue")))            ;saucer

(define TANK
  (overlay/xy (overlay (ellipse 28 8 "solid" "black")       ;tread center
                       (ellipse 30 10 "solid" "green"))     ;tread outline
              5 -14
              (above (rectangle 5 10 "solid" "black")       ;gun
                     (rectangle 20 10 "solid" "black"))))   ;main body

(define TANK-HEIGHT/2 (/ (image-height TANK) 2))
(define TANK-Y (- HEIGHT TANK-HEIGHT/2))        ; y-coordinate of tank 

(define MISSILE (ellipse 5 15 "solid" "red"))

(define MTS (empty-scene WIDTH HEIGHT))


;; Data Definitions:

(define-struct game (invaders missiles tank))
;; Game is (make-game  (listof Invader) (listof Missile) Tank)
;; interp. the current state of a space invaders game
;;         with the current invaders, missiles and tank position

;; Game constants defined below Missile data definition

#;
(define (fn-for-game s)
  (... (fn-for-loinvader (game-invaders s))
       (fn-for-lom (game-missiles s))
       (fn-for-tank (game-tank s))))

;; Template rules used:
;;  - one of: 3 cases
;;  - compound: (cons Invader ListOfInvader)
;;  - reference: (first loinvader) is Invader
;;  - self-reference: (rest loinvader) is ListOfInvader
;;  - compound: (cons Missile ListOfMissile)
;;  - reference: (first lom) is Missile
;;  - self-reference: (rest lom) is ListOfMissile
;;  - Tank


(define-struct tank (x dir))
;; Tank is (make-tank Number Integer[-1, 1])
;; interp. the tank location is x, HEIGHT - TANK-HEIGHT/2 in screen coordinates
;;         the tank moves TANK-SPEED pixels per clock tick left if dir -1, right if dir 1

(define T0 (make-tank (/ WIDTH 2) 1))   ;center going right
(define T1 (make-tank 50 1))            ;going right
(define T2 (make-tank 50 -1))           ;going left

#;
(define (fn-for-tank t)
  (... (tank-x t) (tank-dir t)))
;; Template rules used:
;;  - compound: 2 fields


(define-struct invader (x y dx))
;; Invader is (make-invader Number Number Number)
;; interp. the invader is at (x, y) in screen coordinates
;;         the invader along x by dx pixels per clock tick

(define I1 (make-invader 150 100 12))           ;not landed, moving right
(define I2 (make-invader 150 HEIGHT -10))       ;exactly landed, moving left
(define I3 (make-invader 150 (+ HEIGHT 10) 10)) ;> landed, moving right


#;
(define (fn-for-invader invader)
  (... (invader-x invader) (invader-y invader) (invader-dx invader)))

;; ListOfInvader is one of:
;;  - empty
;;  - (cons Invader ListOfInvader)
;; interp. a list of missiles
(define LOI0 empty)
(define LOI1 (list I1))
(define LOI2 (list I1 I2))

#;
(define (fn-for-loinvaders loinvaders)
  (cond [(empty? loinvaders) (...)]
        [else
         (... (fn-for-invader (first loinvaders))
              (fn-for-loinvaders (rest loinvaders)))]))

;; Template rules used:
;;  - one of: 2 cases
;;  - atomic distinct: empty
;;  - compound: (cons Invader ListOfInvader)
;;  - reference: (first loinvaders) is Invader
;;  - self-reference: (rest loinvaders) is ListOfInvader

(define-struct missile (x y))
;; Missile is (make-missile Number Number)
;; interp. the missile's location is x y in screen coordinates

(define M1 (make-missile 150 300))                       ;not hit U1
(define M2 (make-missile (invader-x I1) (+ (invader-y I1) 10)))  ;exactly hit U1
(define M3 (make-missile (invader-x I1) (+ (invader-y I1)  5)))  ;> hit U1

#;
(define (fn-for-missile m)
  (... (missile-x m) (missile-y m)))
;; Template rules used:
;;  - compound: 2 fields

;; ListOfMissile is one of:
;;  - empty
;;  - (cons Missile ListOfMissile)
;; interp. a list of missiles
(define LOM0 empty)
(define LOM1 (list M1))
(define LOM2 (list M1 M2))

#;
(define (fn-for-lom lom)
  (cond [(empty? lom) (...)]
        [else
         (... (fn-for-missile (first lom))
              (fn-for-lom (rest lom)))]))

;; Template rules used:
;;  - one of: 2 cases
;;  - atomic distinct: empty
;;  - compound: (cons Missile ListOfMissile)
;;  - reference: (first lom) is Missile
;;  - self-reference: (rest lom) is ListOfMissile



(define G0 (make-game empty empty T0))
(define G1 (make-game empty empty T1))
(define G2 (make-game (list I1) (list M1) T1))
(define G3 (make-game (list I1 I2) (list M1 M2) T1))

;; =================
;; Functions:

;; Game -> Game
;; called to make the game; start with (main (make-tank (/ WIDTH 2) 1))
;; no tests for main function
(define (main g)
  (big-bang g
    (on-tick next-game)
    (to-draw draw-game)     ; Tank -> Image
    (on-key  handle-key)    ; Tank KeyEvent -> Tank
    (stop-when stop-game)))

;; ListOfInvader ListOfMissile Tank -> ListOfInvader ListOfMissile Tank
;; produce the next ListOfInvader, ListOfMissile, Tank
;;!!! (check-expect)
;(define (next-game g) (next-tank (game-tank g)))  ; stub

(define (next-game g)
  (make-game (next-invaders (game-invaders g) (game-missiles g))
             (next-missiles (game-missiles g))
             (next-tank (game-tank g))))


;; ListOfInvader ListOfMissile Tank -> ListOfInvader ListOfMissile Tank
;; produce the next ListOfInvader, ListOfMissile, Tank
;; !!! (check-expect)

;(define (draw-game g) MTS)   ;stub

(define (draw-game g)
  (draw-invaders (game-invaders g)
                 (draw-tank (game-tank g)
                            (draw-missiles (game-missiles g)))))
               

;; Tank -> Tank  
;; increase tank x by dir; when gets to edge, change dir and move off by 1
(check-expect (next-tank (make-tank 20   3)) (make-tank (+ 20 3)  3)) ;away from edges
(check-expect (next-tank (make-tank 20  -3)) (make-tank (- 20 3) -3))

(check-expect (next-tank (make-tank (- WIDTH 3)  3)) (make-tank WIDTH   3)) ;reaches edge
(check-expect (next-tank (make-tank (+ 0 3) -3)) (make-tank 0  -3))

(check-expect (next-tank (make-tank (- WIDTH 2)  3)) (make-tank WIDTH  -3)) ;tries to pass edge
(check-expect (next-tank (make-tank (+ 0 2) -3)) (make-tank 0   3))

;(define (next-tank t) t)      ;stub
(define (next-tank t)
  (cond [(> (+ (tank-x t) (tank-dir t)) WIDTH) (make-tank WIDTH (- (tank-dir t)))]
        [(< (+ (tank-x t) (tank-dir t)) 0) (make-tank 0 (- (tank-dir t)))]
        [else
         (make-tank (+ (tank-x t) (tank-dir t))
                    (tank-dir t))]))


;; Tank Image Image -> Image
;; place appropriate tank image on MTS at (tank-x t) and CTR-Y
(check-expect (draw-tank (make-tank 99 TANK-SPEED) MTS)
              (place-image TANK 99 TANK-Y MTS))
(check-expect (draw-tank (make-tank 33 -3) MTS)
              (place-image TANK 33 TANK-Y MTS))

;(define (draw-tank t img) MTS)  ;stub  

(define (draw-tank t img)
  (place-image TANK (tank-x t) TANK-Y img))


;; Game KeyEvent-> Game
;; reverse direction of tank travel when space bar is pressed
(check-expect (handle-key (make-game empty empty (make-tank 33 3)) "left") (make-game empty empty (make-tank 33 -3)))
(check-expect (handle-key (make-game empty empty (make-tank 33 3)) "right") (make-game empty empty (make-tank 33 3)))
(check-expect (handle-key (make-game empty empty (make-tank 100 -5)) "right") (make-game empty empty (make-tank 100 5)))
(check-expect (handle-key (make-game empty empty (make-tank 100 -5)) "left") (make-game empty empty (make-tank 100 -5)))

; (define (handle-key g ke) t) ;stub
(define (handle-key g key)
  (cond [(and (key=? "left" key) (> (tank-dir (game-tank g)) 0))
         (make-game (game-invaders g) (game-missiles g)
                    (make-tank (tank-x (game-tank g)) (- (tank-dir (game-tank g)))))]
        [(and (key=? "right" key) (< (tank-dir (game-tank g)) 0))
         (make-game (game-invaders g) (game-missiles g)
                    (make-tank (tank-x (game-tank g)) (- (tank-dir (game-tank g)))))]
        [(key=? " " key)
         (make-game (game-invaders g)
                    (cons (make-missile (tank-x (game-tank g)) TANK-Y) (game-missiles g))
                    (game-tank g))]
        [else g]))

;; ListOfMissile -> ListOfMissile
;; produce filtered and ticked list of missiles
(check-expect (next-missiles empty) empty)
(check-expect (next-missiles (list M1 (make-missile 90 0)))
              (list (make-missile 150 (- 300 MISSILE-SPEED))))

;(define (next-missiles lom) empty)   ; stub
(define (next-missiles lom)
  (onscreen-only (tick-missiles lom)))

;; ListOfMissile -> ListOfMissile
;; produce list of ticked missiles
(check-expect (tick-missiles empty) empty)
(check-expect (tick-missiles (list (make-missile 1 20) (make-missile 90 100)))
              (list (make-missile 1 (- 20 MISSILE-SPEED)) (make-missile 90 (- 100 MISSILE-SPEED))))
;(define (tick-missiles lom) empty)   ; stub

(define (tick-missiles lom)
  (cond [(empty? lom) empty]
        [else 
         (cons (tick-missile (first lom))
               (tick-missiles (rest lom)))]))


;; Missile -> Missile
;; produce a new missile that is one pixel farther down the screen
(check-expect (tick-missile (make-missile 6 9)) (make-missile 6 (- 9 MISSILE-SPEED)))

;<template from missile>
(define (tick-missile m)
  (make-missile (missile-x m) (- (missile-y m) MISSILE-SPEED)))


;; ListOfMissile -> ListOfMissile
; produce a list containing only those missiles in lom that are onscreen?
(check-expect (onscreen-only empty) empty)
(check-expect (onscreen-only (cons (make-missile 3 4)
                                   (cons (make-missile 1 (+ 1 HEIGHT))
                                         empty)))
              (cons (make-missile 3 4)
                    empty))

;<template from ListOfMissile>
(define (onscreen-only lom)
  (cond [(empty? lom) empty]
        [else
         (if (onscreen? (first lom))
             (cons (first lom) (onscreen-only (rest lom)))
             (onscreen-only (rest lom)))]))

;; missile -> Boolean
;; produce true if d has not fallen off the bottom of MTS
(check-expect (onscreen? (make-missile 2 -1)) false)
(check-expect (onscreen? (make-missile 2  0)) true)
(check-expect (onscreen? (make-missile 2  1)) true)
(check-expect (onscreen? (make-missile 2 (- HEIGHT 1))) true)
(check-expect (onscreen? (make-missile 2    HEIGHT))    true)
(check-expect (onscreen? (make-missile 2 (+ HEIGHT 1))) false)

;<template from missile>
(define (onscreen? m)  
  (<= 0 (missile-y m) HEIGHT))

;; ListOfMissile -> Image
;; Render the missiles onto MTS
(check-expect (draw-missiles empty) MTS)
(check-expect (draw-missiles (cons (make-missile 3 7) empty))
              (place-image MISSILE 3 7 MTS))
(check-expect (draw-missiles (cons (make-missile 3 7) (cons (make-missile 12 30) empty)))
              (place-image MISSILE 3 7 (place-image MISSILE 12 30 MTS)))

;<template from ListOfMissile>
(define (draw-missiles lom)
  (cond [(empty? lom) MTS]
        [else 
         (place-missile (first lom)
                        (draw-missiles (rest lom)))]))


;; Missile Image -> Image
;; place missile on img as specified by d
(check-expect (place-missile (make-missile 9 5) MTS)
              (place-image MISSILE 9 5 MTS))

;<template from missile w/ extra atomic parameter>

(define (place-missile d img)
  (place-image MISSILE (missile-x d) (missile-y d) img))

;; ListOfInvader ListOfMissile -> ListOfInvader ListOfMissile
;; produce filtered and ticked list of invaders
;(check-random (next-invaders empty)
;              (if (<= (random INVADE-RATE) RANDOM-RATE)
;                  (cons (make-invader (random WIDTH) 0 INVADER-X-SPEED)
;                        empty)
;                  empty))
;(check-random (next-invaders (list (make-invader 3 4 10) I1))
;              (if (<= (random INVADE-RATE) RANDOM-RATE)
;                  (cons (make-invader (random WIDTH) 0 INVADER-X-SPEED)
;                        (list (make-invader 13 14 10)
;                              (make-invader (+ (invader-x I1) (invader-dx I1))
;                                            (+ (invader-y I1) (invader-dx I1))
;                                            (invader-dx I1))))
;                  (list (make-invader 13 14 10)
;                        (make-invader (+ (invader-x I1) (invader-dx I1))
;                                      (+ (invader-y I1) (invader-dx I1))
;                                      (invader-dx I1)))))
(check-random (next-invaders empty empty)
              (if (<= (random INVADE-RATE) RANDOM-RATE)
                  (cons (make-invader (random WIDTH) 0 INVADER-X-SPEED)
                        empty)
                  empty))
(check-random (next-invaders (list (make-invader 3 4 10) I1) empty)
              (if (<= (random INVADE-RATE) RANDOM-RATE)
                  (cons (make-invader (random WIDTH) 0 INVADER-X-SPEED)
                        (list (make-invader 13 14 10)
                              (make-invader (+ (invader-x I1) (invader-dx I1))
                                            (+ (invader-y I1) (invader-dx I1))
                                            (invader-dx I1))))
                  (list (make-invader 13 14 10)
                        (make-invader (+ (invader-x I1) (invader-dx I1))
                                      (+ (invader-y I1) (invader-dx I1))
                                      (invader-dx I1)))))


;(define (next-invaders loinvaders lom) empty)  ; stub

(define (next-invaders loinvaders lom)
  (more-invaders (tick-invaders (remove-invaders loinvaders lom))))

;; ListOfInvader -> ListOfInvader
;; randomly add an invader into a ListOfInvader
(check-random (more-invaders empty)
              (if (<= (random INVADE-RATE) RANDOM-RATE)
                  (cons (make-invader (random WIDTH) 0 INVADER-X-SPEED)
                        empty)
                  empty))
  
;(define (more-invaders loinvaders) empty)    ;stub
(define (more-invaders loinvaders)
  (if (<= (random INVADE-RATE) RANDOM-RATE)
      (cons (make-invader (random WIDTH) 0 INVADER-X-SPEED)
            loinvaders)
      loinvaders))

;; ListOfInvader -> ListOfInvader
;; produce list of ticked invaders
(check-expect (tick-invaders empty) empty)
(check-expect (tick-invaders (list (make-invader 3 4 10)
                                   (make-invader 90 100 10)))
              (list (make-invader 13 14 10)
                    (make-invader 100 110 10)))

;<template from ListOfInvader>

(define (tick-invaders loinvaders)
  (cond [(empty? loinvaders) empty]
        [else 
         (cons (tick-invader (first loinvaders))
               (tick-invaders (rest loinvaders)))]))


;; Invader -> Invader
;; produce a new invader that is one pixel farther down the screen
(check-expect (tick-invader (make-invader 6 9 10)) (make-invader 16 19 10))              ; away from edge

(check-expect (tick-invader (make-invader (- WIDTH 3) 10 3)) (make-invader WIDTH 13 3))  ;reaches edge
(check-expect (tick-invader (make-invader 3 10 -3)) (make-invader 0 13 -3))

(check-expect (tick-invader (make-invader (- WIDTH 2) 10 3)) (make-invader WIDTH 13 -3)) ;tries to pass edge
(check-expect (tick-invader (make-invader 2 10 -3)) (make-invader 0 13 3))

;<template from Invader>

(define (tick-invader i)
  (cond [(> (+ (invader-x i) (invader-dx i)) WIDTH)
         (make-invader WIDTH (+ (invader-y i) (abs (invader-dx i))) (- (invader-dx i)))]
        [(< (+ (invader-x i) (invader-dx i)) 0)
         (make-invader 0 (+ (invader-y i) (abs (invader-dx i))) (- (invader-dx i)))]
        [else
         (make-invader (+ (invader-x i) (invader-dx i))
                       (+ (invader-y i) (abs (invader-dx i)))
                       (invader-dx i))]))

;; ListOfInvader ListOfMissile -> ListOfInvader ListOfMissile
;; produce a list containing only those invaders in loinvaders that are not shot?
(check-expect (remove-invaders empty empty) empty)
(check-expect (remove-invaders (list (make-invader 3 4 10)
                                     (make-invader 1 HEIGHT 10)) empty)
              (list (make-invader 3 4 10) (make-invader 1 HEIGHT 10)))
(check-expect (remove-invaders (list (make-invader 2  0 10) (make-invader 145  310 10)) LOM1)
              (list (make-invader 2  0 10)))

;<template from ListOfInvader>

(define (remove-invaders loinvaders lom)
  (cond [(empty? loinvaders) empty]
        [else
         (if (shot? (first loinvaders) lom)
             (remove-invaders (rest loinvaders) lom)
             (cons (first loinvaders) (remove-invaders (rest loinvaders) lom)))]))


;; Invader ListOfMissile -> Boolean
;; produce true if d has not fallen off the bottom of MTS
(check-expect (shot? (make-invader 2 -1 10) LOM0) false)
(check-expect (shot? (make-invader 2  0 10) LOM1) false)
(check-expect (shot? (make-invader 145  310 10) LOM1) true)
(check-expect (shot? I1 LOM2) true)
(check-expect (shot? I2 (list M3)) false)

;(define (shot? i lom) false)   ; stub
;<template from Invader>

(define (shot? i lom)  
  (cond [(empty? lom) false]
        [else
         (if (and (>= HIT-RANGE (abs (- (invader-x i) (missile-x (first lom)))))
                  (>= HIT-RANGE (abs (- (invader-y i) (missile-y (first lom))))))
             true
             (shot? i (rest lom)))]))

;; Game -> Boolean
;; check if there is any landed invader (and hence stop the game)
(check-expect (stop-game G0) false)
(check-expect (stop-game G2) false)
(check-expect (stop-game G3) true)

;(define (stop-game g) false)   ; stub
(define (stop-game g)
  (over? (game-invaders g)))

;; ListOfInvaders -> Boolean
;; produce true if there is any landed invader in the ListOfInvader
(check-expect (over? LOI0) false)
(check-expect (over? LOI1) false)
(check-expect (over? LOI2) true)

; (define (over? loinvaders) false)   ; stub
(define (over? loinvaders)
  (cond [(empty? loinvaders) false]
        [else
         (if (landed? (first loinvaders))
             true
             (over? (rest loinvaders)))]))

;; Invader -> Boolean
;; produce true if an Invader has landed (y-coordinate >= HEIGHT)
(check-expect (landed? I1) false)
(check-expect (landed? I2) true)
(check-expect (landed? I3) true)

;(define (landed? i) false)   ;stub
(define (landed? i)
  (>= (invader-y i) HEIGHT))

;; ListOfInvader -> Image
;; Render the invaders onto img (in this case, Tank and ListOfInvader)
(check-expect (draw-invaders empty MTS) MTS )
(check-expect (draw-invaders (cons (make-invader 3 7 10) empty) MTS)
              (place-image INVADER 3 7 MTS))
(check-expect (draw-invaders (cons (make-invader 3 7 10) (cons (make-invader 12 30 10) empty)) MTS)
              (place-image INVADER 3 7 (place-image INVADER 12 30 MTS)))


;<template from ListOfInvader>
(define (draw-invaders loinvaders img)
  (cond [(empty? loinvaders) img]
        [else 
         (place-invader (first loinvaders)
                        (draw-invaders (rest loinvaders) img))]))


;; Invader Image -> Image
;; place invader on img
(check-expect (place-invader (make-invader 9 5 10) MTS)
              (place-image INVADER 9 5 MTS))

;<template from Invader w/ extra atomic parameter>

(define (place-invader d img)
  (place-image INVADER (invader-x d) (invader-y d) img))

