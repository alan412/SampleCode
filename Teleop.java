class Teleop extends OpMode{
    MyRobot robot = new MyRobot();

    void init(){
        robot.init();
    }
    void setupCommands(){
        gamepad1.dpad_up.onPress(robot.arm.goToScore());
        gamepad1.dpad_down.onPress(robot.arm.goToIntake());
        gamepad1.leftTrigger.onPress(robot.claw.close());
        gamepad1.rightTrigger.onPress(robot.claw.open());
        gamepad1.x.onPress(robot.mecanumDrive.imu.resetYaw());
    }
    void loop(){
        double leftSpeed = gamepad1.leftStick.x;
        double forwardSpeed = -gamepad1.leftStick.y;
        double rotateSpeed = gamepad1.rightStick.y;

        robot.mecanumDrive.driveFieldRelative(leftSpeed, forwardSpeed, rotateSpeed );


        if(gamepad1.dpad_left){
            startCommand(robot.wrist.goToLeft());
        }
        else if(gamepad1.dpad_right){
            startCommand(robot.wrist.goToRight());
        }
        else{
            startCommand(robot.wrist.goToCenter());
        }
        robot.update(telemetry);
    }
}