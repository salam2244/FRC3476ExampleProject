package frc.subsystem;
import java.lang.Object;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXInvertType;
import com.ctre.phoenix.motorcontrol.can.TalonFX;
import edu.wpi.first.wpilibj.Solenoid;
import frc.robot.Constants;

import static frc.utility.Pneumatics.getPneumaticsHub;


public class Intake extends AbstractSubsystem {

    private static TalonFX intakeMotor = new TalonFX(40);

    private static Solenoid intakeSolenoid = getPneumaticsHub().makeSolenoid(3);
    private static boolean TalonFXInvertType;
    private static double Value = 0;
    public Intake(int period, int loggingInterval) {
        super(period, loggingInterval);
    }

    public static void closeIntake(){
        intakeSolenoid.set(false);
    }
    public static void openIntake(){
        intakeSolenoid.set(true);
    }

    public static void reverseIntake(){
        if (TalonFXInvertType){
            TalonFXInvertType = false;
        } else {
            TalonFXInvertType = true;
        }

        intakeMotor.setInverted(TalonFXInvertType);

    }
    public static void controlIntake(){
        if(Value == 0){
            Value = 0.5;
        } else {
            Value = 0;
        }

        intakeMotor.set(TalonFXControlMode.PercentOutput, Value);
    }



    @Override
    public void close() throws Exception {

    }
}
