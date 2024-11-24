class Claw extends Mechanism{
    Servo servo;
    DistanceSensor distanceSensor;

    int OPEN_ANGLE_DEG = 160;
    int CLOSE_ANGLE_DEG = 30;
    int OBJECT_IN_RANGE_MM = 12;

    Claw(Servo servo, DistanceSensor distanceSensor){
        this.servo = servo;
        this.distanceSensor = distanceSensor;
    }

    Command close(){
        return new CommandServoGoToPosition(servo, CLOSE_ANGLE_DEG);
    }
    Command open(){
        return SequenceCommand(
            new CommandServoGoToPosition(servo, OPEN_ANGLE_DEG),
            new WaitTimeSeconds(0.5),
            new WaitUntilCommand(inRange()),
            close(),
        );
    }
    boolean inRange(){
        return distanceSensor.getRange() < OBJECT_IN_RANGE_MM;
    }

    List<WiringTest> getTests(){
        return Arrays.asList(
            new TestServo("Open Claw", servo, OPEN_ANGLE_DEG, CLOSE_ANGLE_DEG),
            new DistanceSensor("Distance Sensor", distanceSensor)
        )
    }
}