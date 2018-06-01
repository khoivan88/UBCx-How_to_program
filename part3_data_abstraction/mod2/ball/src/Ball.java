public class Ball {

    private int speed;

    // This creates a ball with the given speed
    public Ball(int speed) {
        this.speed = speed;
    }

    //This sets the speed of the ball to the given speed
    public void setSpeed(int speed) { this.speed = speed; }

    //This returns the speed of the ball
    public int getSpeed() { return speed; }
}