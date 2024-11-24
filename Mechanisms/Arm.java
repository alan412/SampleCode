class Arm extends Mechanism{
    FtcMotor motor;
    LimitSwitch limitSwitch;
    int SCORE_ENCODER_POS = 4000;
    int INTAKE_ENCODER_POS = 0;
    int MOTOR_TEST_SPEED = 0.3;

    Arm(FtcMotor motor, LimitSwitch limitSwitch){
        this.motor = motor;
        this.limitSwitch = limitSwitch;
    }
    Command goToScore(){
        return new CommandMotorGoToPosition(motor, SCORE_ENCODER_POS);
    }
    Command goToIntake(){
        return new CommandMotorGoToPositionOrSwitch(motor, INTAKE_ENCODER_POS, limitSwitch);
    }
    List<WiringTest> getTests(){
        return Arrays.asList(
            new TestMotor("Raise Arm", motor, MOTOR_TEST_SPEED),
            new TestMotor("Lower Arm", motor, -MOTOR_TEST_SPEED),
            new TestLimitSwitch("Arm Limit Switch", limitSwitch)
        )
    }
    void update(Telemetry telemetry){
        if(limitSwitch.isPressed()){
            motor.stopAndResetPosition();
        }
    }
}