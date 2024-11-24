class Auto extends AutoOpMode{
    MyRobot robot = new MyRobot();
    double GAME_PIECE_X_IN = 40;
    double GAME_PIECE_Y_IN = 80;
    double SCORE_X_IN = -40;
    double SCORE_Y_IN = 80;

    void init(){
        robot.init();
    }
 
    SequenceCommand getCommands(){
        return new SequenceCommand(
            new ParallelCommand(
                robot.mecanumDrive.goToPosition(DistanceUnit.INCH, GAME_PIECE_X_IN, GAME_PIECE_Y_IN),
                robot.claw.open()
            ),
            robot.arm.goToIntake(),
            new ParallelCommand(
                robot.mecanumDrive.goToPosition(DistanceUnit.INCH, SCORE_X_IN, SCORE_Y_IN),
                robot.arm.goToScore()
            ),
            robot.claw.open();
        ); 
    }
}