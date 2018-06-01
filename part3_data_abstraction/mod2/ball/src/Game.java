public class Game {
    public void playGame() {
        Ball ball = new Ball(100);
        System.out.println(ball.getSpeed());
        ball.setSpeed(10);
        passBall(ball);
        ball.setSpeed(30);
    }

    public void passBall(Ball ball) {
        ball.setSpeed(ball.getSpeed() + 5);     // (1)
//        System.out.println(ball.getSpeed());
        catchBall(ball);                        // (2)
//        System.out.println(ball.getSpeed());
    }

    public void catchBall(Ball ball) {
        Ball newBall = new Ball(50);
        newBall.setSpeed(40);
        newBall.setSpeed(0);                    // (3)
        ball = newBall;                         // (4)
//        ball.setSpeed(newBall.getSpeed());
        System.out.println("Caught the Ball");
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.playGame();
    }
}
