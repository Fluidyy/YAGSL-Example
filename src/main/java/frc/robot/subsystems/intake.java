package frc.robot.subsystems;

import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.DigitalInput;

public class intake extends SubsystemBase{
    private SparkMax neo1 = new SparkMax(9, MotorType.kBrushless);
    private SparkMax neo2 = new SparkMax(10, MotorType.kBrushless);
    private SparkMax neo3 = new SparkMax(14, MotorType.kBrushless);


    private DigitalInput beamBreaker = new DigitalInput(0);
  

    @Override
    public void periodic() {

    }

    public Command Intakecmd(double speed) {

        return new Command() {
            @Override
            public void initialize() {

            }

            @Override
            public void execute() {
                neo1.set(speed);
                neo2.set(-speed);
                neo3.set(speed);
            }

            @Override
            public void end(boolean interrupted) {

            }

            @Override
            public boolean isFinished() {   
                return !beamBreaker.get();
            }
        };
    }
}


