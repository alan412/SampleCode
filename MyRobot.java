class MyRobot extends MechanismBasedRobot{
    public MecanumDrive mecanumDrive;
    public SparkfunOtos otos;
    public Arm arm;
    public Wrist wrist;
    public Claw claw;

    MyRobot(){
        mecanumDrive = new MecanumDrive(
            new FtcMotor(MOTOR_PORT_0, true), 
            new FtcMotor(MOTOR_PORT_1), 
            new FtcMotor(MOTOR_PORT_2, true), 
            new FtcMotor(MOTOR_PORT_3));

        otos = new SparkfunOtos(I2C_PORT_0);
        mecanumDrive.addLocalizer(otos);

        arm = new Arm(new FtcMotor(MOTOR_PORT_4), new LimitSwitch(SMARTIO_PORT_0));
        wrist = new Wrist(new Servo(SERVO_PORT_0));
        claw = new Claw(new Servo(SERVO_PORT_1), new DistanceSensor(I2C_PORT_1));
        mechanisms = Arrays.asList(
                mecanumDrive,
                otos,
                arm,
                wrist,
                claw);
    }
}