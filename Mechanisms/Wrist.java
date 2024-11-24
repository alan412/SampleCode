class Wrist extends Mechanism{
    Servo servo;
    int LEFT_ANGLE_DEG = 30;
    int CENTER_ANGLE_DEG = 90;
    int RIGHT_ANGLE_DEG = 150;

    Wrist(Servo servo){
        this.servo = servo;
    }
    Command goToLeft(){
        return new CommandServoGoToPosition(servo, LEFT_ANGLE_DEG);
    }
    Command goToCenter(){
        return new CommandServoGoToPosition(servo, CENTER_ANGLE_DEG);
    }
     Command goToRight(){
        return new CommandServoGoToPosition(servo, RIGHT_ANGLE_DEG);
    }
    List<WiringTest> getTests(){
        return Arrays.asList(
            new TestServo("Left", servo, LEFT_ANGLE_DEG),
            new TestServo("Center", servo, CENTER_ANGLE_DEG),
            new TestServo("Right", servo, RIGHT_ANGLE_DEG),
        )
    }

}